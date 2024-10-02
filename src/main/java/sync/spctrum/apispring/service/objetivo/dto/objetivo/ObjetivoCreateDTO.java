package sync.spctrum.apispring.service.objetivo.dto.objetivo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObjetivoCreateDTO {

    @NotBlank(message = "Objetivo não pode ser nulo")
    private String objetivo;
}
