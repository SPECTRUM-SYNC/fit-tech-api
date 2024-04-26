package sync.spctrum.apispring.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceDuplicate;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.exception.TransactionNotAcceptable;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.email.dto.EmailDTO;
import sync.spctrum.apispring.service.usuario.QuickSort;
import sync.spctrum.apispring.service.usuario.UsuarioService;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginGoogleDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioUpdateDTO;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "Bearer")
public class UsuarioController {
    private final EmailService emailService;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(EmailService emailService, UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.emailService = emailService;
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
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
    public ResponseEntity<UsuarioTokenDTO> postLoginGoogle(@RequestBody @Valid  UsuarioLoginGoogleDTO usuarioLoginDto) {
        UsuarioTokenDTO usuarioTokenDto = this.usuarioService.autenticarGoogle(usuarioLoginDto);
        return ResponseEntity.status(200).body(usuarioTokenDto);
    }

    @ApiResponse(responseCode = "200", description = "Usuário escolhido atualizado com sucesso.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> putAtualizarUsuario(@Valid @RequestBody UsuarioUpdateDTO usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = procurarUsuarioPorId(id);

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setPeso(usuario.getPeso());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());
        usuarioRepository.save(usuarioAtualizado);
        return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(usuarioAtualizado));
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
    public ResponseEntity<String> enviarEmail(@RequestBody EmailDTO emailDTO) {

        if (validEmailExistente(emailDTO.getPara()) == true){

            emailService.enviarEmail(emailDTO.getPara(), emailDTO.getNome());
            return ResponseEntity.ok().body("E-mail enviado com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("E-mail não existe!");
        }

    }

    private boolean validEmailExistente(String email) {
        return usuarioRepository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(email));
    }

    private Usuario procurarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }
}