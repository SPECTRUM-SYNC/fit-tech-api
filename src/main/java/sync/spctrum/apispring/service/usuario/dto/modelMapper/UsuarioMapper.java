package sync.spctrum.apispring.service.usuario.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.util.List;

@Configuration
public class UsuarioMapper {

    private static final ModelMapper model = new ModelMapper();

    public static Usuario toEntity(UsuarioResponseDTO usuarioDTO) {
        return model.map(usuarioDTO, Usuario.class);
    }

    public static Usuario toEntity(UsuarioCreateDTO usuarioDTO) {
        return model.map(usuarioDTO, Usuario.class);
    }

    public static UsuarioResponseDTO toRespostaDTO(Usuario usuario) {
        return model.map(usuario, UsuarioResponseDTO.class);
    }


    public static List<UsuarioResponseDTO> toListRespostaDTO(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toRespostaDTO).toList();
    }

    public static UsuarioTokenDTO toToken(Usuario usuario, String token) {
        UsuarioTokenDTO usuarioTokenDto = new UsuarioTokenDTO();
        usuarioTokenDto.setUserId(usuario.getId());
        usuarioTokenDto.setEmail(usuario.getEmail());
        usuarioTokenDto.setNome(usuario.getNome());
        usuarioTokenDto.setToken(token);

        return usuarioTokenDto;
    }
}

