package sync.spctrum.apispring.service.historicoPeso.dto.peso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class HistoricoPesoCreateDTOTest {
    /**
     * Method under test:
     * {@link HistoricoPesoCreateDTO#HistoricoPesoCreateDTO(LocalDate, Double, Double)}
     */
    @Test
    void testNewHistoricoPesoCreateDTO() {
        // Arrange
        LocalDate dataPostagem = LocalDate.of(1970, 1, 1);

        // Act
        HistoricoPesoCreateDTO actualHistoricoPesoCreateDTO = new HistoricoPesoCreateDTO(dataPostagem, 10.0d, 10.0d);

        // Assert
        LocalDate dataPostagem2 = actualHistoricoPesoCreateDTO.getDataPostagem();
        assertEquals("1970-01-01", dataPostagem2.toString());
        assertEquals(10.0d, actualHistoricoPesoCreateDTO.getPeso().doubleValue());
        assertEquals(10.0d, actualHistoricoPesoCreateDTO.getPesoMeta().doubleValue());
        assertSame(dataPostagem, dataPostagem2);
    }
}
