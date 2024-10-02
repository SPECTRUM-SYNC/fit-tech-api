package sync.spctrum.apispring.service.historicoPeso.dto.peso;

import lombok.Data;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.time.LocalDate;

@Data
public class HistoricoPesoResponseDTO {

    private Long id;
    private LocalDate dataPostagem;
    private Double peso;
    private Double pesoMeta;
    private UsuarioResponseDTO usuario;
}
