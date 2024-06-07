package sync.spctrum.apispring.domain.Receita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sync.spctrum.apispring.domain.Receita.Receita;

import java.time.LocalDate;
import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findAllByUsuario_IdAndDataCriacao(Long id, LocalDate data);
}