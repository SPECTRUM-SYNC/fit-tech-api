package sync.spctrum.apispring.service.receita.dto.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.service.receita.dto.receita.ReceitaResponseDTO;

import java.util.List;

@Configuration
public class ReceitaMapper {

    private static final ModelMapper model = new ModelMapper();

    public static ReceitaResponseDTO toRespostaDTO(Receita receita) {
        return model.map(receita, ReceitaResponseDTO.class);
    }


    public static List<ReceitaResponseDTO> toListRespostaDTO(List<Receita> receitas) {
        return receitas.stream().map(ReceitaMapper::toRespostaDTO).toList();
    }
}
