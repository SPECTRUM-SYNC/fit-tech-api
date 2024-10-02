package sync.spctrum.apispring.domain.Treino.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.Treino.Treino;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    @Query(value = "select t from Treino t where t.usuario.id = :id AND t.descricao = 'Diario' order by t.dataTreino DESC LIMIT 7")
    List<Treino> findAllByUsuario_Id(Long id);

    Optional<Treino> findByDataTreinoAndUsuarioIdAndDescricao(LocalDate time, Long id, String descricao);

    List<Treino> findByDataTreinoAndUsuarioId(LocalDate time, Long id);

    @Query("SELECT t.dataTreino, COUNT(t) " +
            "FROM Treino t " +
            "WHERE t.usuario.id = :id AND t.status = 'Feito' " +
            "GROUP BY t.dataTreino")
    List<Object[]> countTreinosByDiaDaSemana(@Param("id") Long id);


}
