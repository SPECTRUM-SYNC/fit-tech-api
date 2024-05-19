package sync.spctrum.apispring.service.treino;

import org.springframework.stereotype.Service;
import sync.spctrum.apispring.domain.Treino.Repository.TreinoRepository;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.usuario.UsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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


    public Boolean findByTreinoAndUser(Long id) {
        Optional<Treino> treino = treinoRepository.findByDataTreinoAndUsuarioId(LocalDate.now(), id);
        return treino.isPresent();
    }

    public Treino existsByDataTreinoAndId(Long id) {
        Optional<Treino> treino = treinoRepository.findByDataTreinoAndUsuarioId(LocalDate.now(), id);
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
}
