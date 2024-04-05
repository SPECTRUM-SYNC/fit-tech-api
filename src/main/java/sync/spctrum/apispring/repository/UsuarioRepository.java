package sync.spctrum.apispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sync.spctrum.apispring.entity.Usuario;

/**
 * The interface Usuario repository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
