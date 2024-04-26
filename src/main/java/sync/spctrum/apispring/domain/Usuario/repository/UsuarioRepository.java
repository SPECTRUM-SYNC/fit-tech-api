package sync.spctrum.apispring.domain.Usuario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.Usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT Usuario FROM Usuario order by pontuacao ASC", nativeQuery = true)
    List<Usuario> topUsuarios();
}
