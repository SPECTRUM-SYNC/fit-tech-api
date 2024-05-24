package sync.spctrum.apispring.service.usuario.dto.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UsuarioCreateDTOTest {
    /**
     * Method under test:
     * {@link UsuarioCreateDTO#UsuarioCreateDTO(String, String, String, String)}
     */
    @Test
    void testNewUsuarioCreateDTO() {
        // Arrange and Act
        UsuarioCreateDTO actualUsuarioCreateDTO = new UsuarioCreateDTO("Nome", "jane.doe@example.org", "Senha", "Img");

        // Assert
        assertEquals("Img", actualUsuarioCreateDTO.getImg());
        assertEquals("Nome", actualUsuarioCreateDTO.getNome());
        assertEquals("Senha", actualUsuarioCreateDTO.getSenha());
        assertEquals("jane.doe@example.org", actualUsuarioCreateDTO.getEmail());
    }
}
