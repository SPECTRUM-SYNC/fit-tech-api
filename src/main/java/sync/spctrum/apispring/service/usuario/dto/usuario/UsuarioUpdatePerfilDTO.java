package sync.spctrum.apispring.service.usuario.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioUpdatePerfilDTO {


    @Size(min = 3, max = 80)
    @Schema(description = "Nome do usuário", example = "Rafael Reis")
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @Max(value = 250)
    @Min(value = 120)
    @NotNull(message = "Altura não pode ser nulo")
    private Integer altura;

    @Past
    @NotNull
    private Date dataNascimento;

    @NotBlank
    private String meta;

    @NotBlank(message = "É preciso descrever o nivel de condição do usuário")
    private String nivelCondicao;
}
