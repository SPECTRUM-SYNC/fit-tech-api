package sync.spctrum.apispring.service.objetivo.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.util.List;

@Configuration
public class ObjetivoMapper {

    private static final ModelMapper model = new ModelMapper();

    public static Objetivo toEntity(ObjetivoResponseDTO objetivoDTO) {
        return model.map(objetivoDTO, Objetivo.class);
    }

    public static Objetivo toEntity(ObjetivoCreateDTO objetivoDTO) {
        return model.map(objetivoDTO, Objetivo.class);
    }

    public static ObjetivoResponseDTO toObjetivoDTO(Objetivo objetivo) {
        return model.map(objetivo, ObjetivoResponseDTO.class);
    }

    public static List<ObjetivoResponseDTO> toListRespostaDTO(List<Objetivo> objetivos) {
        return objetivos.stream().map(ObjetivoMapper::toObjetivoDTO).toList();
    }

}

