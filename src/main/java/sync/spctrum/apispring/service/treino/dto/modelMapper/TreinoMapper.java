package sync.spctrum.apispring.service.treino.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCreateDTO;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoResponseDTO;

import java.util.List;

@Configuration
public class TreinoMapper {

    private static final ModelMapper model = new ModelMapper();

    public static Treino toEntity(TreinoResponseDTO treinoDTO) {
        return model.map(treinoDTO, Treino.class);
    }

    public static Treino toEntity(TreinoCreateDTO treinoDTO) {
        return model.map(treinoDTO, Treino.class);
    }

    public static TreinoResponseDTO toRespostaDTO(Treino treino) {
        return model.map(treino, TreinoResponseDTO.class);
    }


    public static List<TreinoResponseDTO> toListRespostaDTO(List<Treino> treinos) {
        return treinos.stream().map(TreinoMapper::toRespostaDTO).toList();
    }
}
