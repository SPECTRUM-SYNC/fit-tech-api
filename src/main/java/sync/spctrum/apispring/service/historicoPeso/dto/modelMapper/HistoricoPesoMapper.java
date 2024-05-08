package sync.spctrum.apispring.service.historicoPeso.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;

import java.util.List;

@Configuration
public class HistoricoPesoMapper {

    private static final ModelMapper model = new ModelMapper();

    public static HistoricoPeso toEntity(HistoricoPesoCreateDTO pesoDTO, Usuario usuario) {
        HistoricoPeso historicoPeso = new HistoricoPeso();

        historicoPeso.setPeso(pesoDTO.getPeso());
        historicoPeso.setPesoMeta(pesoDTO.getPesoMeta());
        historicoPeso.setDataPostagem(pesoDTO.getDataPostagem());
        historicoPeso.setUsuario(usuario);

        return historicoPeso;
    }

    public static HistoricoPesoResponseDTO toResponse(HistoricoPeso peso) {
        return model.map(peso, HistoricoPesoResponseDTO.class);
    }

    public static List<HistoricoPesoResponseDTO> toResponse(List<HistoricoPeso> pesos) {
        return pesos.stream().map(HistoricoPesoMapper::toResponse).toList();
    }
}

