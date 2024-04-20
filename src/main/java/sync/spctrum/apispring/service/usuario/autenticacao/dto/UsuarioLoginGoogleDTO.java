package sync.spctrum.apispring.service.usuario.autenticacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@SecondaryRow
public class UsuarioLoginGoogleDTO {

    @NotBlank
    @Schema(description = "Email do usuário", example = "winycios@gmail.com")
    private String email;

    @NotBlank
    @Schema(description = "Nome do usuário", example = "Winycios")
    private String nome;
}
