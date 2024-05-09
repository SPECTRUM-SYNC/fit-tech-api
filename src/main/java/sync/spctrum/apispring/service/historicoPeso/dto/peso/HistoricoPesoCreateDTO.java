package sync.spctrum.apispring.service.historicoPeso.dto.peso;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class HistoricoPesoCreateDTO {

    private Date dataPostagem;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    @NotNull(message = "Peso não pode ser nulo")
    private Double peso;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    @NotNull(message = "Peso não pode ser nulo")
    private Double pesoMeta;

    public HistoricoPesoCreateDTO(Date dataPostagem, Double peso, Double pesoMeta) {
        this.dataPostagem = dataPostagem;
        this.peso = peso;
        this.pesoMeta = pesoMeta;
    }
}
