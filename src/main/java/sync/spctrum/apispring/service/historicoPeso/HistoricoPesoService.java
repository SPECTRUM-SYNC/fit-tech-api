package sync.spctrum.apispring.service.historicoPeso;

import org.springframework.stereotype.Service;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.HistoricoPeso.Repository.HistoricoPesoRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceDuplicate;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.historicoPeso.dto.modelMapper.HistoricoPesoMapper;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;

import java.util.List;

@Service
public class HistoricoPesoService {

    private final HistoricoPesoRepository historicoPesoRepository;

    private final UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;

    public HistoricoPesoService(HistoricoPesoRepository historicoPesoRepository, UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.historicoPesoRepository = historicoPesoRepository;
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    public HistoricoPesoResponseDTO postPeso(HistoricoPesoCreateDTO pesoDto, Long id) {
        Usuario user = usuarioService.procurarUsuarioPorId(id);

        if (!historicoPesoRepository.existsByDataPostagemAndId(pesoDto.getDataPostagem(), id)) {
            user.setPeso(pesoDto.getPeso());
            HistoricoPeso historicoPeso = historicoPesoRepository.save(HistoricoPesoMapper.toEntity(pesoDto, user));
            usuarioRepository.save(user);
            return HistoricoPesoMapper.toResponse(historicoPeso);
        }
        throw new ResourceDuplicate("Limite de uma atualização diária de peso.");
    }

    public List<HistoricoPesoResponseDTO> getId(Long id) {
        return HistoricoPesoMapper.toResponse(historicoPesoRepository.findAllByUsuario_Id(id));
    }

    public List<HistoricoPesoResponseDTO> getGrafics(Long id) {
        return HistoricoPesoMapper.toResponse(historicoPesoRepository.findAllTop3ByUserId(id));
    }

    public HistoricoPesoResponseDTO getUserId(Long id) {
        return HistoricoPesoMapper.toResponse(historicoPesoRepository.findAllTop1ByUserId(id).orElseThrow(() -> new ResourceNotFound("Usuário não encontrado")));
    }
}
