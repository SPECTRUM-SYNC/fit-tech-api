package sync.spctrum.apispring.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.usuario.QuickSort;
import sync.spctrum.apispring.exception.ResourceDuplicate;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The type Usuario controller.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    /**
     * Instantiates a new Usuario controller.
     *
     * @param usuarioRepository the usuario repository
     */
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Listar response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<Usuario> usuarioList = usuarioRepository.findAll();

        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("");
        }
        return ResponseEntity.status(201).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }

    /**
     * Find by user response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findByUser(@PathVariable Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.status(200).body(UsuarioMapper.toRespostaDTO(user.get()));
        }
        throw new ResourceNotFound(id);
    }


    /**
     * Listar ordem alfabetica response entity.
     *
     * @return the response entity
     */
    @GetMapping("/ordemAlfabetica")
    public ResponseEntity<List<UsuarioResponseDTO>> listarOrdemAlfabetica() {
        List<Usuario> usuarioList = usuarioRepository.findAll();

        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("");
        }

        QuickSort.quickSort(usuarioList, 0, usuarioList.size() - 1);

        return ResponseEntity.status(200).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }


    /**
     * Listar status usuario response entity.
     *
     * @param contaAtiva the conta ativa
     * @return the response entity
     */
    @GetMapping("/statusUsuario/{contaAtiva}")
    public ResponseEntity<List<UsuarioResponseDTO>> listarStatusUsuario(@PathVariable Boolean contaAtiva) {
        List<Usuario> usuarioList = usuarioRepository.findAll().stream().filter(usuario -> usuario.getContaAtiva().equals(contaAtiva)).toList();

        if (usuarioList.isEmpty()) {
            throw new ResourceNotFound("");
        }

        return ResponseEntity.status(200).body(UsuarioMapper.toListRespostaDTO(usuarioList));
    }


    /**
     * Cadastrar response entity.
     *
     * @param usuario the usuario
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrar(@Valid @RequestBody UsuarioCreateDTO usuario) {

        if (emailExiste(usuario.getEmail())) {
            throw new ResourceDuplicate(usuario.getNome());
        }

        Usuario user = UsuarioMapper.toEntity(usuario);
        user.setContaAtiva(true);
        Usuario newUser = usuarioRepository.save(user);

        return ResponseEntity.status(201).body(findByUser(newUser.getId()).getBody());
    }

    /**
     * Atualizar response entity.
     *
     * @param usuario the usuario
     * @param id      the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@Valid @RequestBody UsuarioCreateDTO usuario, @PathVariable Long id) {

        if (emailExisteOutroUsuario(usuario.getEmail(), id)) {
            throw new ResourceDuplicate(usuario.getNome());
        }

        UsuarioResponseDTO usuarioAtualizado = findByUser(id).getBody();

        if (usuarioAtualizado == null) {
            throw new ResourceNotFound(id);
        }

        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
        usuarioAtualizado.setGenero(usuario.getGenero());
        usuarioAtualizado.setPeso(usuario.getPeso());
        usuarioAtualizado.setNivelCondicao(usuario.getNivelCondicao());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setContaAtiva(true);

        return ResponseEntity.status(200).body(usuarioAtualizado);
    }


    /**
     * Status conta response entity.
     *
     * @param id         the id
     * @param contaAtiva the conta ativa
     * @return the response entity
     */
    @PutMapping("/{id}/inativar/{contaAtiva}")
    public ResponseEntity<UsuarioResponseDTO> statusConta(@PathVariable Long id, @PathVariable Boolean contaAtiva) {
        UsuarioResponseDTO usuario = findByUser(id).getBody();

        if (usuario == null) {
            throw new ResourceNotFound(id);
        }

        usuario.setContaAtiva(contaAtiva);
        return ResponseEntity.status(200).body(usuario);
    }


    /**
     * Deletar total response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTotal(@PathVariable Long id) {
        UsuarioResponseDTO usuario = findByUser(id).getBody();

        if (usuario == null) {
            throw new ResourceNotFound(id);
        }
        usuarioRepository.delete(UsuarioMapper.toEntity(usuario));
        return ResponseEntity.status(200).build();
    }


    private boolean emailExisteOutroUsuario(String email, Long id) {

        return usuarioRepository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(email) && !Objects.equals(usuario.getId(), id));
    }

    private boolean emailExiste(String email) {

        return usuarioRepository.findAll().stream().anyMatch(usuario -> usuario.getEmail().equals(email));
    }
}

