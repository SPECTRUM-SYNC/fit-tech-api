package sync.spctrum.apispring.service.usuario.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioUpdateDTO {


    @Size(min = 3, max = 80)
    @Schema(description = "Nome do usuário", example = "Rafael Reis")
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Senha não pode ser nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Senha inválida")
    @Schema(description = "Senha do usuário", example = "Madalena13#")
    private String senha;

    @Schema(description = "Endereço da imagem", example = "")
    private String img;

    @NotBlank(message = "Gênero não pode ser nulo")
    @Schema(description = "Genero do usuario", example = "Masculino")
    private String genero;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    @NotNull(message = "Peso não pode ser nulo")
    private Double peso;

    @Max(value = 250)
    @Min(value = 120)
    @NotNull(message = "Altura não pode ser nulo")
    private Integer altura;

    @Past
    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String meta;

    @NotBlank(message = "É preciso descrever o nivel de condição do usuário")
    private String nivelCondicao;
}
