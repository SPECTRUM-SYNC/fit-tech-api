package sync.spctrum.apispring.service.historicoPeso.dto.peso;

import lombok.Data;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.util.Date;

@Data
public class HistoricoPesoResponseDTO {

    private Long id;
    private Date dataPostagem;
    private Double peso;
    private Double pesoMeta;
    private UsuarioResponseDTO usuario;
}
