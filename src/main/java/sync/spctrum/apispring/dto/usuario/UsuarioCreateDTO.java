package sync.spctrum.apispring.dto.usuario;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The type Usuario create dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioCreateDTO {


    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Email não pode ser nulo")
    @Email
    private String email;

    @NotBlank(message = "Senha não pode ser nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Senha invalida")
    private String senha;

    @Past
    private LocalDate dataNascimento;

    private Boolean genero;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    private Double peso;

    @NotBlank(message = "É preciso descrever o nivel de condição do usuário")
    private String nivelCondicao;
}
