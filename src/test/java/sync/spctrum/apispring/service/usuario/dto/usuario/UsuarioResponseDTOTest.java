package sync.spctrum.apispring.service.usuario.dto.usuario;

import org.junit.jupiter.api.Test;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UsuarioResponseDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UsuarioResponseDTO#UsuarioResponseDTO()}
     *   <li>{@link UsuarioResponseDTO#setAltura(Integer)}
     *   <li>{@link UsuarioResponseDTO#setContaAtiva(Boolean)}
     *   <li>{@link UsuarioResponseDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioResponseDTO#setEmail(String)}
     *   <li>{@link UsuarioResponseDTO#setGenero(String)}
     *   <li>{@link UsuarioResponseDTO#setId(Long)}
     *   <li>{@link UsuarioResponseDTO#setImg(String)}
     *   <li>{@link UsuarioResponseDTO#setMeta(String)}
     *   <li>{@link UsuarioResponseDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioResponseDTO#setNome(String)}
     *   <li>{@link UsuarioResponseDTO#setObjetivo(ObjetivoResponseDTO)}
     *   <li>{@link UsuarioResponseDTO#setPeso(Double)}
     *   <li>{@link UsuarioResponseDTO#setPontuacao(int)}
     *   <li>{@link UsuarioResponseDTO#getAltura()}
     *   <li>{@link UsuarioResponseDTO#getContaAtiva()}
     *   <li>{@link UsuarioResponseDTO#getDataNascimento()}
     *   <li>{@link UsuarioResponseDTO#getEmail()}
     *   <li>{@link UsuarioResponseDTO#getGenero()}
     *   <li>{@link UsuarioResponseDTO#getId()}
     *   <li>{@link UsuarioResponseDTO#getImg()}
     *   <li>{@link UsuarioResponseDTO#getMeta()}
     *   <li>{@link UsuarioResponseDTO#getNivelCondicao()}
     *   <li>{@link UsuarioResponseDTO#getNome()}
     *   <li>{@link UsuarioResponseDTO#getObjetivo()}
     *   <li>{@link UsuarioResponseDTO#getPeso()}
     *   <li>{@link UsuarioResponseDTO#getPontuacao()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        UsuarioResponseDTO actualUsuarioResponseDTO = new UsuarioResponseDTO();
        actualUsuarioResponseDTO.setAltura(1);
        actualUsuarioResponseDTO.setContaAtiva(true);
        Date dataNascimento = mock(Date.class);
        actualUsuarioResponseDTO.setDataNascimento(dataNascimento);
        actualUsuarioResponseDTO.setEmail("jane.doe@example.org");
        actualUsuarioResponseDTO.setGenero("Genero");
        actualUsuarioResponseDTO.setId(1L);
        actualUsuarioResponseDTO.setImg("Img");
        actualUsuarioResponseDTO.setMeta("Meta");
        actualUsuarioResponseDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioResponseDTO.setNome("Nome");
        ObjetivoResponseDTO objetivo = new ObjetivoResponseDTO();
        actualUsuarioResponseDTO.setObjetivo(objetivo);
        actualUsuarioResponseDTO.setPeso(10.0d);
        actualUsuarioResponseDTO.setPontuacao(1);
        Integer actualAltura = actualUsuarioResponseDTO.getAltura();
        Boolean actualContaAtiva = actualUsuarioResponseDTO.getContaAtiva();
        Date actualDataNascimento = actualUsuarioResponseDTO.getDataNascimento();
        String actualEmail = actualUsuarioResponseDTO.getEmail();
        String actualGenero = actualUsuarioResponseDTO.getGenero();
        Long actualId = actualUsuarioResponseDTO.getId();
        String actualImg = actualUsuarioResponseDTO.getImg();
        String actualMeta = actualUsuarioResponseDTO.getMeta();
        String actualNivelCondicao = actualUsuarioResponseDTO.getNivelCondicao();
        String actualNome = actualUsuarioResponseDTO.getNome();
        ObjetivoResponseDTO actualObjetivo = actualUsuarioResponseDTO.getObjetivo();
        Double actualPeso = actualUsuarioResponseDTO.getPeso();
        int actualPontuacao = actualUsuarioResponseDTO.getPontuacao();

        // Assert that nothing has changed
        assertEquals("Genero", actualGenero);
        assertEquals("Img", actualImg);
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualNome);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1, actualAltura.intValue());
        assertEquals(1, actualPontuacao);
        assertEquals(10.0d, actualPeso.doubleValue());
        assertEquals(1L, actualId.longValue());
        assertTrue(actualContaAtiva);
        assertSame(objetivo, actualObjetivo);
        assertSame(dataNascimento, actualDataNascimento);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link UsuarioResponseDTO#UsuarioResponseDTO(Long, String, String, String, Date, String, Double, Integer, String, String, Boolean, int, ObjetivoResponseDTO)}
     *   <li>{@link UsuarioResponseDTO#setAltura(Integer)}
     *   <li>{@link UsuarioResponseDTO#setContaAtiva(Boolean)}
     *   <li>{@link UsuarioResponseDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioResponseDTO#setEmail(String)}
     *   <li>{@link UsuarioResponseDTO#setGenero(String)}
     *   <li>{@link UsuarioResponseDTO#setId(Long)}
     *   <li>{@link UsuarioResponseDTO#setImg(String)}
     *   <li>{@link UsuarioResponseDTO#setMeta(String)}
     *   <li>{@link UsuarioResponseDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioResponseDTO#setNome(String)}
     *   <li>{@link UsuarioResponseDTO#setObjetivo(ObjetivoResponseDTO)}
     *   <li>{@link UsuarioResponseDTO#setPeso(Double)}
     *   <li>{@link UsuarioResponseDTO#setPontuacao(int)}
     *   <li>{@link UsuarioResponseDTO#getAltura()}
     *   <li>{@link UsuarioResponseDTO#getContaAtiva()}
     *   <li>{@link UsuarioResponseDTO#getDataNascimento()}
     *   <li>{@link UsuarioResponseDTO#getEmail()}
     *   <li>{@link UsuarioResponseDTO#getGenero()}
     *   <li>{@link UsuarioResponseDTO#getId()}
     *   <li>{@link UsuarioResponseDTO#getImg()}
     *   <li>{@link UsuarioResponseDTO#getMeta()}
     *   <li>{@link UsuarioResponseDTO#getNivelCondicao()}
     *   <li>{@link UsuarioResponseDTO#getNome()}
     *   <li>{@link UsuarioResponseDTO#getObjetivo()}
     *   <li>{@link UsuarioResponseDTO#getPeso()}
     *   <li>{@link UsuarioResponseDTO#getPontuacao()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        Date dataNascimento = mock(Date.class);

        // Act
        UsuarioResponseDTO actualUsuarioResponseDTO = new UsuarioResponseDTO(1L, "Nome", "jane.doe@example.org", "Img",
                dataNascimento, "Genero", 10.0d, 1, "Nivel Condicao", "Meta", true, 1, new ObjetivoResponseDTO());
        actualUsuarioResponseDTO.setAltura(1);
        actualUsuarioResponseDTO.setContaAtiva(true);
        Date dataNascimento2 = mock(Date.class);
        actualUsuarioResponseDTO.setDataNascimento(dataNascimento2);
        actualUsuarioResponseDTO.setEmail("jane.doe@example.org");
        actualUsuarioResponseDTO.setGenero("Genero");
        actualUsuarioResponseDTO.setId(1L);
        actualUsuarioResponseDTO.setImg("Img");
        actualUsuarioResponseDTO.setMeta("Meta");
        actualUsuarioResponseDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioResponseDTO.setNome("Nome");
        ObjetivoResponseDTO objetivo = new ObjetivoResponseDTO();
        actualUsuarioResponseDTO.setObjetivo(objetivo);
        actualUsuarioResponseDTO.setPeso(10.0d);
        actualUsuarioResponseDTO.setPontuacao(1);
        Integer actualAltura = actualUsuarioResponseDTO.getAltura();
        Boolean actualContaAtiva = actualUsuarioResponseDTO.getContaAtiva();
        Date actualDataNascimento = actualUsuarioResponseDTO.getDataNascimento();
        String actualEmail = actualUsuarioResponseDTO.getEmail();
        String actualGenero = actualUsuarioResponseDTO.getGenero();
        Long actualId = actualUsuarioResponseDTO.getId();
        String actualImg = actualUsuarioResponseDTO.getImg();
        String actualMeta = actualUsuarioResponseDTO.getMeta();
        String actualNivelCondicao = actualUsuarioResponseDTO.getNivelCondicao();
        String actualNome = actualUsuarioResponseDTO.getNome();
        ObjetivoResponseDTO actualObjetivo = actualUsuarioResponseDTO.getObjetivo();
        Double actualPeso = actualUsuarioResponseDTO.getPeso();
        int actualPontuacao = actualUsuarioResponseDTO.getPontuacao();

        // Assert that nothing has changed
        assertEquals("Genero", actualGenero);
        assertEquals("Img", actualImg);
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualNome);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1, actualAltura.intValue());
        assertEquals(1, actualPontuacao);
        assertEquals(10.0d, actualPeso.doubleValue());
        assertEquals(1L, actualId.longValue());
        assertTrue(actualContaAtiva);
        assertSame(objetivo, actualObjetivo);
        assertSame(dataNascimento2, actualDataNascimento);
    }
}
