package sync.spctrum.apispring.service.usuario.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioCreateDTO {

    @Size(min = 3, max = 80)
    @Schema(description = "Nome do usuário", example = "Rafael Reis")
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @Email
    @NotBlank(message = "Email não pode ser nulo")
    @Schema(description = "Email do usuário", example = "rafael.reis@sptech.school")
    private String email;

    @NotBlank(message = "Senha não pode ser nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Senha inválida")
    @Schema(description = "Senha do usuário", example = "Madalena13#")
    private String senha;

    @Schema(description = "Endereço da imagem", example = "")
    private String img;

    public UsuarioCreateDTO(String nome, String email, String senha, String img) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.img = img;
    }
}
