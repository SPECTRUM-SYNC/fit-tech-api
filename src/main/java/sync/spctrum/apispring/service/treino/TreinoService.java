package sync.spctrum.apispring.service.treino;

import org.springframework.stereotype.Service;
import sync.spctrum.apispring.domain.Treino.Repository.TreinoRepository;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;

import java.time.LocalDate;
import java.util.*;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    private final UsuarioService usuarioService;

    public TreinoService(TreinoRepository treinoRepository, UsuarioService usuarioService) {
        this.treinoRepository = treinoRepository;
        this.usuarioService = usuarioService;
    }

    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }

    public List<Treino> findAllByUsuarioId(Long id) {
        return treinoRepository.findAllByUsuario_Id(id);
    }

    public List<Treino> findByDataTreinoAndUsuarioId(Long id) {
        return treinoRepository.findByDataTreinoAndUsuarioId(LocalDate.now(), id);
    }

    public Boolean findByTreinoAndUser(Long id) {
        Optional<Treino> treino = treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(LocalDate.now(), id, "Diario");
        return treino.isPresent();
    }

    public List<TreinoCountDTO> getTreinosPorDiaDaSemana(Long usuarioId) {
        List<TreinoCountDTO> treinoCounts = treinoRepository.countTreinosByDiaDaSemana(usuarioId);

        Map<String, Long> countsMap = new HashMap<>();
        for (TreinoCountDTO count : treinoCounts) {
            countsMap.put(count.getDiaDaSemana(), count.getQuantidadeTreinos());
        }

        String[] diasDaSemana = {"seg", "ter", "qua", "qui", "sex", "sáb", "dom"};
        List<TreinoCountDTO> result = new ArrayList<>();

        for (String dia : diasDaSemana) {
            result.add(new TreinoCountDTO(dia, countsMap.getOrDefault(dia, 0L)));
        }

        return result;
    }

    public Treino existsByDataTreinoAndId(Long id) {
        Optional<Treino> treino = treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(LocalDate.now(), id, "Diario");
        return treino.orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }

    public Treino findById(Long id) {
        return treinoRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID : " + id));
    }

    public Treino save(Treino treino, Long usuarioId) {
        treino.setId(null);
        treino.setUsuario(usuarioService.procurarUsuarioPorId(usuarioId));
        return treinoRepository.save(treino);
    }

    public Treino putStatusTreino(Long id) {
        Treino treino = existsByDataTreinoAndId(id);
        treino.setStatus("Feito");
        return treinoRepository.save(treino);
    }
}
