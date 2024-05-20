package sync.spctrum.apispring.service.usuario;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.stringtemplate.v4.ST;
import sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.exception.TransactionNotAcceptable;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginGoogleDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

@Service
public class UsuarioService {

    private final EmailService emailService;
    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String containerName;

    @Value("${azure.blob-storage.connection-string}")
    private String connectionString;

    private BlobServiceClient blobServiceClient;

    @PostConstruct
    public void init() {
        blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
    }


    private final PasswordEncoder passwordEncoder;


    private final UsuarioRepository usuarioRepository;


    private final GerenciadorTokenJwt gerenciadorTokenJwt;


    private final AuthenticationManager authenticationManager;

    private final Deque<Usuario> resetQueue = new ArrayDeque<>(2);

    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, GerenciadorTokenJwt gerenciadorTokenJwt, AuthenticationManager authenticationManager, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.gerenciadorTokenJwt = gerenciadorTokenJwt;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }

    public List<UsuarioResponseDTO> usuariosPontuacao() {
        return UsuarioMapper.toListRespostaDTO(usuarioRepository.topUsuarios());
    }

    public UsuarioResponseDTO criarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioCreateDTO);
        usuario.setContaAtiva(true);

        try {
            String senhaCriptografada = passwordEncoder.encode(usuarioCreateDTO.getSenha());
            usuario.setSenha(senhaCriptografada);
        } catch (Exception e) {
            throw new ResponseStatusException(400, "Erro ao criar usuário", e);
        }
        Usuario novoUsuario = usuarioRepository.save(usuario);

        novoUsuario.setObjetivo(new Objetivo(novoUsuario.getId(), null, novoUsuario));
        usuarioRepository.save(novoUsuario);

        return UsuarioMapper.toRespostaDTO(novoUsuario);
    }

    public void atualizarImage(Long id, MultipartFile imageFile) throws IOException {

        try (InputStream inputStream = imageFile.getInputStream()) {
            Usuario usuario = procurarUsuarioPorId(id);

            String blobFileName = StringUtils.cleanPath("%s_%d".formatted(usuario.getNome(), usuario.getId()));
            BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(blobFileName);
            blobClient.upload(inputStream, imageFile.getSize(), true);
            String imageUrl = blobClient.getBlobUrl();

            usuario.setImg(imageUrl);
            usuarioRepository.save(usuario);
        } catch (IOException e) {
            throw new TransactionNotAcceptable("Falha ao processar a imagem");
        }
    }

    public UsuarioTokenDTO autenticar(UsuarioLoginDTO usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail()).orElseThrow(() -> new ResponseStatusException(404, "Email do usuário não cadastrado", null));
        if (!usuarioAutenticado.getContaAtiva()) {
            throw new TransactionNotAcceptable("Conta inativada.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.toToken(usuarioAutenticado, token);
    }

    public UsuarioTokenDTO autenticarGoogle(UsuarioLoginGoogleDTO usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getEmail());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuarioLoginDto.getEmail()).orElseThrow(() -> new ResponseStatusException(404, "Email do usuário não cadastrado", null));
        if (!usuarioAutenticado.getContaAtiva()) {
            throw new TransactionNotAcceptable("Conta inativada.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.toToken(usuarioAutenticado, token);
    }

    public Usuario procurarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }

    @Scheduled(fixedDelay = 120000)
    public void removerPrimeiraSolicitacaoSenha(){
        if (!resetQueue.isEmpty()){
            resetQueue.removeFirst();
        }
    }

    public UsuarioTokenDTO solicitarRedefinicaoSenha(String email){
        if (isPermitidoRedefinicaoSenha(email)){
            Usuario usuario = usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new ResponseStatusException(404, "Email ainda não cadastrado", null));

            resetQueue.addLast(usuario);
        }
        throw new ResponseStatusException(429, "Limite de solicitações excedido. Aguarde 2 minutos e tente novamente.", null);
    }

    private boolean isPermitidoRedefinicaoSenha(String email) {
        LocalDateTime now = LocalDateTime.now();
        return resetQueue.stream()
                .filter(usuario -> usuario.getEmail().equals(email))
                .filter(usuario -> now.minusMinutes(2).isBefore(usuario.getHoraSenhaAtualizacao()))
                .count() < 2;
    }
    
    public String gerarNovaSenha(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%¨&*()_+-={`^}:><.,/?|";
        return RandomStringUtils.random(10, caracteres);
    }
}