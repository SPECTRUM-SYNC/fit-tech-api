package sync.spctrum.apispring.service.usuario.autenticacao.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioLoginDTO {

  @Schema(description = "Email do usuário", example = "winycios@gmail.com")
  @NotBlank
  private String email;

  @Schema(description = "Senha do usuário", example = "Madalena13#")
  @NotBlank
  private String senha;
}
