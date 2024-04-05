package sync.spctrum.apispring.dto.usuario;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Usuario response dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Boolean genero;
    private Double peso;
    private String nivelCondicao;
    private Boolean contaAtiva;


    /**
     * Gets Genero.
     *
     * @return the Genero
     */
    public String getGenero() {
        return genero ? "Masculino" : "femeas";
    }
}
