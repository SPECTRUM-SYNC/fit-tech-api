package sync.spctrum.apispring.service.objetivo.dto.objetivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjetivoCreateDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ObjetivoCreateDTO#ObjetivoCreateDTO()}
     *   <li>{@link ObjetivoCreateDTO#setObjetivo(String)}
     *   <li>{@link ObjetivoCreateDTO#getObjetivo()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ObjetivoCreateDTO actualObjetivoCreateDTO = new ObjetivoCreateDTO();
        actualObjetivoCreateDTO.setObjetivo("Objetivo");

        // Assert that nothing has changed
        assertEquals("Objetivo", actualObjetivoCreateDTO.getObjetivo());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ObjetivoCreateDTO#ObjetivoCreateDTO(String)}
     *   <li>{@link ObjetivoCreateDTO#setObjetivo(String)}
     *   <li>{@link ObjetivoCreateDTO#getObjetivo()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ObjetivoCreateDTO actualObjetivoCreateDTO = new ObjetivoCreateDTO("Objetivo");
        actualObjetivoCreateDTO.setObjetivo("Objetivo");

        // Assert that nothing has changed
        assertEquals("Objetivo", actualObjetivoCreateDTO.getObjetivo());
    }
}
