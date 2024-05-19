package sync.spctrum.apispring.service.treino.dto.treino;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TreinoCreateDTO {

    @NotBlank
    private String descricao;
    @NotNull
    private LocalDate dataTreino;
    @NotBlank
    private String status;
    @NotNull
    private Long usuarioId;
}
