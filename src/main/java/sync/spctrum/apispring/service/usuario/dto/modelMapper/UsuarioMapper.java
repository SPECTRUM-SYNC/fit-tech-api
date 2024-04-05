package sync.spctrum.apispring.service.usuario.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.util.List;

/**
 * The type Usuario mapper.
 */
@Configuration
public class UsuarioMapper {

    private static final ModelMapper model = new ModelMapper();


    /**
     * To entity usuario.
     *
     * @param usuarioDTO the usuario dto
     * @return the usuario
     */
// converte um DTO para entidade
    public static Usuario toEntity(UsuarioResponseDTO usuarioDTO) {
        return model.map(usuarioDTO, Usuario.class);
    }

    /**
     * To entity usuario.
     *
     * @param usuarioDTO the usuario dto
     * @return the usuario
     */
    public static Usuario toEntity(UsuarioCreateDTO usuarioDTO) {
        return model.map(usuarioDTO, Usuario.class);
    }


    /**
     * To resposta dto usuario response dto.
     *
     * @param usuario the usuario
     * @return the usuario response dto
     */
// converte usuario para UsuarioResponseDTO
    public static UsuarioResponseDTO toRespostaDTO(Usuario usuario) {
        return model.map(usuario, UsuarioResponseDTO.class);
    }


// converte uma List<Usuario> para List<UsuarioResponseDTO>

    /**
     * To list resposta dto list.
     *
     * @param usuarios the usuarios
     * @return the list
     */
    public static List<UsuarioResponseDTO> toListRespostaDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toRespostaDTO).toList();
    }
}

