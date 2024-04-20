package sync.spctrum.apispring.service.usuario.dto.usuario;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioUpdateDTO {


    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    private String img;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    private Double peso;

    @NotBlank(message = "Gênero não pode ser nulo")
    private String genero;

    @NotBlank(message = "É preciso descrever o nivel de condição do usuário")
    private String nivelCondicao;
}
