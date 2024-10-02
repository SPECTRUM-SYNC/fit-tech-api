package sync.spctrum.apispring.service.email.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link EmailDTO#setNome(String)}
     *   <li>{@link EmailDTO#setPara(String)}
     *   <li>{@link EmailDTO#getNome()}
     *   <li>{@link EmailDTO#getPara()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        EmailDTO emailDTO = new EmailDTO();

        // Act
        emailDTO.setNome("Nome");
        emailDTO.setPara("Para");
        String actualNome = emailDTO.getNome();

        // Assert that nothing has changed
        assertEquals("Nome", actualNome);
        assertEquals("Para", emailDTO.getPara());
    }
}
