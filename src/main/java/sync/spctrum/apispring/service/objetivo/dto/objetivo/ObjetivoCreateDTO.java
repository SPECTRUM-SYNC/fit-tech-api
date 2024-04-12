package sync.spctrum.apispring.service.objetivo.dto.objetivo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObjetivoCreateDTO {

    @NotBlank(message = "Objetivo não pode ser nulo")
    private String objetivo;
}
