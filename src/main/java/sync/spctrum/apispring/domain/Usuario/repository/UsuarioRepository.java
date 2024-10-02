package sync.spctrum.apispring.domain.Usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Query(value = "SELECT u FROM Usuario u order by u.pontuacao DESC limit 3")
    List<Usuario> topUsuarios();

    Optional<Usuario> findByEmailEqualsIgnoreCase(String email);
}
