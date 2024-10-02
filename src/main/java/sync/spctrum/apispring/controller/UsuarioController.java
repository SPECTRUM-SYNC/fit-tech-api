package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sync.spctrum.apispring.domain.Usuario.ListObject;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceDuplicate;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.exception.TransactionNotAcceptable;
import sync.spctrum.apispring.observer.email.EmailObserver;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.email.dto.EmailDTO;
import sync.spctrum.apispring.service.historicoPeso.HistoricoPesoService;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.usuario.QuickSort;
import sync.spctrum.apispring.service.usuario.UsuarioService;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginGoogleDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioUpdateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioUpdatePerfilDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "Bearer")
@EnableScheduling
public class UsuarioController {
    private EmailService emailService;

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    private final HistoricoPesoService pesoService;
    private final PasswordEncoder passwordEncoder;
    private EmailObserver emailObserver;

    private ListObject<Usuario> listaTopUsuarios;


    public UsuarioController(EmailService emailService, HistoricoPesoService historicoPesoService, UsuarioService usuarioService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.emailService = emailService;
        this.usuarioService = usuarioService;
        this.pesoService = historicoPesoService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        listaTopUsuarios = new ListObject<>(5);
        this.emailObserver = new EmailObserver(usuarioRepository, passwordEncoder, emailService);
    }

    @ApiResponse(responseCode = "200", description = "Mostrando todos os usuários cadastrados no sistema.")
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getListarTudo() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("Nenhum usuário encontrado");
        }
        return ResponseEntity.status(200).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }

    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(procurarUsuarioPorId(id)));
    }

    @ApiResponse(responseCode = "200", description = "Ordenando usuários por ordem alfabética.")
    @GetMapping("/ordemAlfabetica")
    public ResponseEntity<List<UsuarioResponseDTO>> getListarOrdemAlfabetica() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("");
        }
        QuickSort.quickSort(usuarioList, 0, usuarioList.size() - 1);
        return ResponseEntity.status(200).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }


    @ApiResponse(responseCode = "200", description = "os três usuários com mais pontuação")
    @GetMapping(value = "/pontuacao")
    public ResponseEntity<List<UsuarioResponseDTO>> getListarUsuariosPontuacao() {
        return ResponseEntity.status(200).body(usuarioService.usuariosPontuacao());
    }

    @ApiResponse(responseCode = "200", description = "Mostrando usuários por status.")
    @GetMapping("/statusUsuario")
    public ResponseEntity<List<UsuarioResponseDTO>> getListarUsuarioStatus(@RequestParam Boolean contaAtiva) {
        List<Usuario> usuarioList = usuarioRepository.findAll().stream().filter(usuario -> usuario.getContaAtiva().equals(contaAtiva)).toList();
        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("Nehuma conta %s encontrada".formatted(contaAtiva ? "ativa" : "inativa"));
        }
        return ResponseEntity.status(200).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }

    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso.")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> postCadastrarUsuario(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) {
        if (validEmailExistente(usuarioCreateDTO.getEmail())) {
            throw new ResourceDuplicate("Email já utilizado");
        }
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuarioCreateDTO));
    }

    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso.")
    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDTO> postLoginUsuario(@RequestBody @Valid UsuarioLoginDTO usuarioLoginDto) {
        UsuarioTokenDTO usuarioTokenDto = this.usuarioService.autenticar(usuarioLoginDto);
        return ResponseEntity.status(200).body(usuarioTokenDto);
    }

    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso.")
    @PostMapping("/login/google")
    public ResponseEntity<UsuarioTokenDTO> postLoginGoogle(@RequestBody @Valid UsuarioLoginGoogleDTO usuarioLoginDto) {
        UsuarioTokenDTO usuarioTokenDto = this.usuarioService.autenticarGoogle(usuarioLoginDto);
        return ResponseEntity.status(200).body(usuarioTokenDto);
    }

    @ApiResponse(responseCode = "200", description = "Usuário escolhido atualizado com sucesso.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> putAtualizarUsuario(@Valid @RequestBody UsuarioUpdateDTO usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = procurarUsuarioPorId(id);

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setGenero(usuario.getGenero());
        usuarioAtualizado.setPeso(usuario.getPeso());
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuarioAtualizado.setSenha(senhaCriptografada);
        usuarioAtualizado.setAltura(usuario.getAltura());
        usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
        usuarioAtualizado.setMeta(usuario.getMeta());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());

        pesoService.postPeso(new HistoricoPesoCreateDTO(LocalDate.now(), usuario.getPeso(), usuario.getPeso()), id);


        usuarioRepository.save(usuarioAtualizado);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuarioAtualizado));
    }

    @ApiResponse(responseCode = "200", description = "Usuário escolhido atualizado com sucesso.")
    @PutMapping("perfil/{id}")
    public ResponseEntity<UsuarioResponseDTO> putAtualizarPerfil(@Valid @RequestBody UsuarioUpdatePerfilDTO usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = procurarUsuarioPorId(id);

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setAltura(usuario.getAltura());
        usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
        usuarioAtualizado.setMeta(usuario.getMeta());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());

        usuarioRepository.save(usuarioAtualizado);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuarioAtualizado));
    }

    @ApiResponse(responseCode = "200", description = "Atualizar pontuação do usuario.")
    @PutMapping("pontuacao/{id}")
    public ResponseEntity<UsuarioResponseDTO> putAtualizarPontuacao(@PathVariable Long id) {
        Usuario usuarioAtualizado = procurarUsuarioPorId(id);
        usuarioAtualizado.setPontuacao(usuarioAtualizado.getPontuacao() + 20);

        usuarioRepository.save(usuarioAtualizado);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuarioAtualizado));
    }

    @ApiResponse(responseCode = "200", description = "Imagem atualizada com sucesso .")
    @PatchMapping(value = "imagem/{id}")
    public ResponseEntity<Void> atualizarImagem(@PathVariable Long id, @RequestParam MultipartFile imageFile) {
        try {
            usuarioService.atualizarImage(id, imageFile);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiResponse(responseCode = "200", description = "Usuário ativado com sucesso.")
    @PatchMapping("/{id}/ativar")

    public ResponseEntity<UsuarioResponseDTO> patchAtivarContaUsuario(@PathVariable Long id) {
        Usuario usuario = procurarUsuarioPorId(id);
        if (usuario.getContaAtiva()) {
            throw new TransactionNotAcceptable("Usuário já está com a conta ativada");
        }
        usuario.setContaAtiva(true);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuario));
    }

    @ApiResponse(responseCode = "200", description = "Usuário inativado com sucesso.")
    @DeleteMapping("/{id}/inativar")
    public ResponseEntity<UsuarioResponseDTO> inativarContaUsuario(@PathVariable Long id) {
        Usuario usuario = procurarUsuarioPorId(id);
        if (!usuario.getContaAtiva()) {
            throw new TransactionNotAcceptable("Usuário já está com a conta desativada");
        }
        usuario.setContaAtiva(false);
        usuarioRepository.save(usuario);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuario));
    }

    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioRepository.delete(procurarUsuarioPorId(id));
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/enviar-email")
    public ResponseEntity<String> enviarEmail(@RequestBody @Valid EmailDTO email) {
        if (validEmailExistente(email.getPara())) {
            if(email != null ) { emailObserver.atualizar(email.getPara()); }
            return ResponseEntity.ok().body("Solicitação de redefinição de senha enviada com sucesso! Verifique seu email.");
        }
        throw new ResourceNotFound("Email não encontrado");
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadCSV() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        try {
            List<UsuarioResponseDTO> dados = UsuarioMapper.toListRespostaDTO(usuarioList);

            // Cria a matriz bidimensional
            String[][] matrizDados = new String[dados.size() + 1][10];

            // Cabeçalho
            matrizDados[0] = new String[]{"NOME", "PESO", "GENERO", "E-MAIL", "STATUS CONTA", "DATA NASC", "NIVEL", "META", "ALTURA", "PONTUACAO"};

            // Preenche a matriz com os dados dos usuários
            for (int i = 0; i < dados.size(); i++) {
                UsuarioResponseDTO linha = dados.get(i);
                matrizDados[i + 1][0] = linha.getNome();
                matrizDados[i + 1][1] = String.valueOf(linha.getPeso());
                matrizDados[i + 1][2] = linha.getGenero();
                matrizDados[i + 1][3] = linha.getEmail();
                matrizDados[i + 1][4] = linha.getContaAtiva() ? "Ativa" : "Desativa";
                matrizDados[i + 1][5] = String.valueOf(linha.getDataNascimento());
                matrizDados[i + 1][6] = linha.getNivelCondicao();
                matrizDados[i + 1][7] = linha.getMeta();
                matrizDados[i + 1][8] = String.valueOf(linha.getAltura());
                matrizDados[i + 1][9] = String.valueOf(linha.getPontuacao());
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(baos);

            for (String[] linha : matrizDados) {
                writer.write(String.join(";", linha) + "\n");
            }

            writer.close();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            headers.setContentDispositionFormData("attachment", "dados.csv");
            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private boolean validEmailExistente(String email) {
        return usuarioRepository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(email));
    }

    private Usuario procurarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }


    //    Lista OBJ
    @ApiResponse(responseCode = "201", description = "Usuário adicionado no ranking")
    @PostMapping("/adicionar-top-ranking")
    public void adicionarUsuarioRanking(@RequestBody Usuario usuario) {
        listaTopUsuarios.adiciona(usuario);
    }


    @ApiResponse(responseCode = "204", description = "Usuário removido com sucesso.")
    @DeleteMapping("/remover")
    public void removerUsuarioRanking(@RequestBody Usuario usuario) {
        listaTopUsuarios.removeElemento(usuario);
    }

    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso.")
    @GetMapping("/buscar/{elemento}")
    public int buscarUsuarioRanking(@PathVariable Usuario elemento) {
        return listaTopUsuarios.busca(elemento);
    }

    @ApiResponse(responseCode = "200", description = "Mostrando todos os usuários cadastrados no ranking.")
    @GetMapping("/exibir")
    public void exibirUsuariosRanking() {
        listaTopUsuarios.exibe();
    }
}