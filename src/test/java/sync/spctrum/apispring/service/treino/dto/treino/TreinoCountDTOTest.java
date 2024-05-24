package sync.spctrum.apispring.service.treino.dto.treino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TreinoCountDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link TreinoCountDTO#TreinoCountDTO()}
     *   <li>{@link TreinoCountDTO#setDiaDaSemana(String)}
     *   <li>{@link TreinoCountDTO#setQuantidadeTreinos(Long)}
     *   <li>{@link TreinoCountDTO#getDiaDaSemana()}
     *   <li>{@link TreinoCountDTO#getQuantidadeTreinos()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        TreinoCountDTO actualTreinoCountDTO = new TreinoCountDTO();
        actualTreinoCountDTO.setDiaDaSemana("Dia Da Semana");
        actualTreinoCountDTO.setQuantidadeTreinos(1L);
        String actualDiaDaSemana = actualTreinoCountDTO.getDiaDaSemana();

        // Assert that nothing has changed
        assertEquals("Dia Da Semana", actualDiaDaSemana);
        assertEquals(1L, actualTreinoCountDTO.getQuantidadeTreinos().longValue());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link TreinoCountDTO#TreinoCountDTO(String, Long)}
     *   <li>{@link TreinoCountDTO#setDiaDaSemana(String)}
     *   <li>{@link TreinoCountDTO#setQuantidadeTreinos(Long)}
     *   <li>{@link TreinoCountDTO#getDiaDaSemana()}
     *   <li>{@link TreinoCountDTO#getQuantidadeTreinos()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        TreinoCountDTO actualTreinoCountDTO = new TreinoCountDTO("Dia Da Semana", 1L);
        actualTreinoCountDTO.setDiaDaSemana("Dia Da Semana");
        actualTreinoCountDTO.setQuantidadeTreinos(1L);
        String actualDiaDaSemana = actualTreinoCountDTO.getDiaDaSemana();

        // Assert that nothing has changed
        assertEquals("Dia Da Semana", actualDiaDaSemana);
        assertEquals(1L, actualTreinoCountDTO.getQuantidadeTreinos().longValue());
    }
}
