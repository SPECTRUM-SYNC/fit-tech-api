package sync.spctrum.apispring.service.treino;

import org.springframework.stereotype.Service;
import sync.spctrum.apispring.domain.Treino.Repository.TreinoRepository;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;

import java.time.DayOfWeek;
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


    private static final Map<DayOfWeek, String> DAY_OF_WEEK_MAP = new EnumMap<>(DayOfWeek.class);

    static {
        DAY_OF_WEEK_MAP.put(DayOfWeek.SUNDAY, "dom");
        DAY_OF_WEEK_MAP.put(DayOfWeek.MONDAY, "seg");
        DAY_OF_WEEK_MAP.put(DayOfWeek.TUESDAY, "ter");
        DAY_OF_WEEK_MAP.put(DayOfWeek.WEDNESDAY, "qua");
        DAY_OF_WEEK_MAP.put(DayOfWeek.THURSDAY, "qui");
        DAY_OF_WEEK_MAP.put(DayOfWeek.FRIDAY, "sex");
        DAY_OF_WEEK_MAP.put(DayOfWeek.SATURDAY, "sáb");
    }

    public List<TreinoCountDTO> getTreinosPorDiaDaSemana(Long id) {
        List<Object[]> results = treinoRepository.countTreinosByDiaDaSemana(id);
        Map<DayOfWeek, Long> dayOfWeekCountMap = new EnumMap<>(DayOfWeek.class);

        // Inicializa o mapa com todos os dias da semana definidos para 0
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            dayOfWeekCountMap.put(dayOfWeek, 0L);
        }

        // Atualiza o mapa com os valores reais obtidos da consulta
        for (Object[] result : results) {
            LocalDate localDate = (LocalDate) result[0];
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            Long count = ((Number) result[1]).longValue();
            dayOfWeekCountMap.put(dayOfWeek, dayOfWeekCountMap.get(dayOfWeek) + count);
        }

        // Converte o mapa em uma lista de TreinoCountDTO
        List<TreinoCountDTO> treinoCountDTOList = new ArrayList<>();
        for (Map.Entry<DayOfWeek, Long> entry : dayOfWeekCountMap.entrySet()) {
            String diaDaSemana = DAY_OF_WEEK_MAP.get(entry.getKey());
            treinoCountDTOList.add(new TreinoCountDTO(diaDaSemana, entry.getValue()));
        }

        return treinoCountDTOList;
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
