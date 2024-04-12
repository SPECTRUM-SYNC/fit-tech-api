package sync.spctrum.apispring.service.objetivo.dto.objetivo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObjetivoResponseDTO {

    private Long id;
    private String objetivo;
}
