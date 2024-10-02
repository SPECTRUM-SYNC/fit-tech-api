package sync.spctrum.apispring.service.usuario.autenticacao.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioLoginDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UsuarioLoginDTO#setEmail(String)}
     *   <li>{@link UsuarioLoginDTO#setSenha(String)}
     *   <li>{@link UsuarioLoginDTO#getEmail()}
     *   <li>{@link UsuarioLoginDTO#getSenha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        UsuarioLoginDTO usuarioLoginDTO = new UsuarioLoginDTO();

        // Act
        usuarioLoginDTO.setEmail("jane.doe@example.org");
        usuarioLoginDTO.setSenha("Senha");
        String actualEmail = usuarioLoginDTO.getEmail();

        // Assert that nothing has changed
        assertEquals("Senha", usuarioLoginDTO.getSenha());
        assertEquals("jane.doe@example.org", actualEmail);
    }
}
