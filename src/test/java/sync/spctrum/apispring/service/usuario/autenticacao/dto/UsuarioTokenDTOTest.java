package sync.spctrum.apispring.service.usuario.autenticacao.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UsuarioTokenDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UsuarioTokenDTO#setEmail(String)}
     *   <li>{@link UsuarioTokenDTO#setNome(String)}
     *   <li>{@link UsuarioTokenDTO#setToken(String)}
     *   <li>{@link UsuarioTokenDTO#setUserId(Long)}
     *   <li>{@link UsuarioTokenDTO#getEmail()}
     *   <li>{@link UsuarioTokenDTO#getNome()}
     *   <li>{@link UsuarioTokenDTO#getToken()}
     *   <li>{@link UsuarioTokenDTO#getUserId()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        UsuarioTokenDTO usuarioTokenDTO = new UsuarioTokenDTO();

        // Act
        usuarioTokenDTO.setEmail("jane.doe@example.org");
        usuarioTokenDTO.setNome("Nome");
        usuarioTokenDTO.setToken("ABC123");
        usuarioTokenDTO.setUserId(1L);
        String actualEmail = usuarioTokenDTO.getEmail();
        String actualNome = usuarioTokenDTO.getNome();
        String actualToken = usuarioTokenDTO.getToken();

        // Assert that nothing has changed
        assertEquals("ABC123", actualToken);
        assertEquals("Nome", actualNome);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1L, usuarioTokenDTO.getUserId().longValue());
    }
}
