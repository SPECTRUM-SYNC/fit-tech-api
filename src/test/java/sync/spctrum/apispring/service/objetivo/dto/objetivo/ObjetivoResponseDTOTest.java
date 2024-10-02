package sync.spctrum.apispring.service.objetivo.dto.objetivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjetivoResponseDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ObjetivoResponseDTO#ObjetivoResponseDTO()}
     *   <li>{@link ObjetivoResponseDTO#setId(Long)}
     *   <li>{@link ObjetivoResponseDTO#setObjetivo(String)}
     *   <li>{@link ObjetivoResponseDTO#getId()}
     *   <li>{@link ObjetivoResponseDTO#getObjetivo()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        ObjetivoResponseDTO actualObjetivoResponseDTO = new ObjetivoResponseDTO();
        actualObjetivoResponseDTO.setId(1L);
        actualObjetivoResponseDTO.setObjetivo("Objetivo");
        Long actualId = actualObjetivoResponseDTO.getId();

        // Assert that nothing has changed
        assertEquals("Objetivo", actualObjetivoResponseDTO.getObjetivo());
        assertEquals(1L, actualId.longValue());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ObjetivoResponseDTO#ObjetivoResponseDTO(Long, String)}
     *   <li>{@link ObjetivoResponseDTO#setId(Long)}
     *   <li>{@link ObjetivoResponseDTO#setObjetivo(String)}
     *   <li>{@link ObjetivoResponseDTO#getId()}
     *   <li>{@link ObjetivoResponseDTO#getObjetivo()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        ObjetivoResponseDTO actualObjetivoResponseDTO = new ObjetivoResponseDTO(1L, "Objetivo");
        actualObjetivoResponseDTO.setId(1L);
        actualObjetivoResponseDTO.setObjetivo("Objetivo");
        Long actualId = actualObjetivoResponseDTO.getId();

        // Assert that nothing has changed
        assertEquals("Objetivo", actualObjetivoResponseDTO.getObjetivo());
        assertEquals(1L, actualId.longValue());
    }
}
