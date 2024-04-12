package sync.spctrum.apispring.domain.Objetivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Long> {
}
