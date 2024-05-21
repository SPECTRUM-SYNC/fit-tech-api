package sync.spctrum.apispring.domain.Treino.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    @Query(value = "select t from Treino t where t.usuario.id = :id AND t.descricao = 'Diario' order by t.dataTreino DESC LIMIT 7")
    List<Treino> findAllByUsuario_Id(Long id);

    Optional<Treino> findByDataTreinoAndUsuarioIdAndDescricao(LocalDate time, Long id, String descricao);

    List<Treino> findByDataTreinoAndUsuarioId(LocalDate time, Long id);

    @Query("SELECT new sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO(" +
            "CASE FUNCTION('DAYOFWEEK', t.dataTreino) " +
            "WHEN 1 THEN 'dom' " +
            "WHEN 2 THEN 'seg' " +
            "WHEN 3 THEN 'ter' " +
            "WHEN 4 THEN 'qua' " +
            "WHEN 5 THEN 'qui' " +
            "WHEN 6 THEN 'sex' " +
            "WHEN 7 THEN 'sáb' " +
            "END, " +
            "COUNT(t)) " +
            "FROM Treino t " +
            "WHERE t.usuario.id = :id AND t.status = 'Feito' " +
            "GROUP BY FUNCTION('DAYOFWEEK', t.dataTreino) " +
            "ORDER BY " +
            "CASE FUNCTION('DAYOFWEEK', t.dataTreino) " +
            "WHEN 2 THEN 1 " +
            "WHEN 3 THEN 2 " +
            "WHEN 4 THEN 3 " +
            "WHEN 5 THEN 4 " +
            "WHEN 6 THEN 5 " +
            "WHEN 7 THEN 6 " +
            "WHEN 1 THEN 7 " +
            "END")
    List<TreinoCountDTO> countTreinosByDiaDaSemana(Long id);
}
