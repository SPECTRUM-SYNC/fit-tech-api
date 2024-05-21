package sync.spctrum.apispring.domain.HistoricoPeso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoPesoRepository extends JpaRepository<HistoricoPeso, Long> {

    @Query(value = "SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END FROM HistoricoPeso h WHERE h.dataPostagem = :date AND h.usuario.id = :id")
    boolean existsByDataPostagemAndId(LocalDate date, Long id);

    List<HistoricoPeso> findAllByUsuario_Id(Long id);

    @Query("SELECT h FROM HistoricoPeso h WHERE h.usuario.id = :id ORDER BY h.dataPostagem DESC LIMIT 3")
    List<HistoricoPeso> findAllTop3ByUserId(Long id);

    @Query("SELECT h FROM HistoricoPeso h WHERE h.usuario.id = :id ORDER BY h.dataPostagem DESC LIMIT 1")
    Optional<HistoricoPeso> findAllTop1ByUserId(Long id);
}
