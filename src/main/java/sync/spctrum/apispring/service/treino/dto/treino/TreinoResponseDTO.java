package sync.spctrum.apispring.service.treino.dto.treino;

import lombok.Data;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.time.LocalDate;

@Data
public class TreinoResponseDTO {

    private Long id;
    private String descricao;
    private LocalDate dataTreino;
    private String status;
    private UsuarioResponseDTO usuario;
}
