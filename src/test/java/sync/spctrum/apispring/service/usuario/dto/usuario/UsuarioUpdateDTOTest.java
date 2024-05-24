package sync.spctrum.apispring.service.usuario.dto.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class UsuarioUpdateDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UsuarioUpdateDTO#UsuarioUpdateDTO()}
     *   <li>{@link UsuarioUpdateDTO#setAltura(Integer)}
     *   <li>{@link UsuarioUpdateDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioUpdateDTO#setGenero(String)}
     *   <li>{@link UsuarioUpdateDTO#setImg(String)}
     *   <li>{@link UsuarioUpdateDTO#setMeta(String)}
     *   <li>{@link UsuarioUpdateDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioUpdateDTO#setNome(String)}
     *   <li>{@link UsuarioUpdateDTO#setPeso(Double)}
     *   <li>{@link UsuarioUpdateDTO#setSenha(String)}
     *   <li>{@link UsuarioUpdateDTO#getAltura()}
     *   <li>{@link UsuarioUpdateDTO#getDataNascimento()}
     *   <li>{@link UsuarioUpdateDTO#getGenero()}
     *   <li>{@link UsuarioUpdateDTO#getImg()}
     *   <li>{@link UsuarioUpdateDTO#getMeta()}
     *   <li>{@link UsuarioUpdateDTO#getNivelCondicao()}
     *   <li>{@link UsuarioUpdateDTO#getNome()}
     *   <li>{@link UsuarioUpdateDTO#getPeso()}
     *   <li>{@link UsuarioUpdateDTO#getSenha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        UsuarioUpdateDTO actualUsuarioUpdateDTO = new UsuarioUpdateDTO();
        actualUsuarioUpdateDTO.setAltura(1);
        Date dataNascimento = mock(Date.class);
        actualUsuarioUpdateDTO.setDataNascimento(dataNascimento);
        actualUsuarioUpdateDTO.setGenero("Genero");
        actualUsuarioUpdateDTO.setImg("Img");
        actualUsuarioUpdateDTO.setMeta("Meta");
        actualUsuarioUpdateDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioUpdateDTO.setNome("Nome");
        actualUsuarioUpdateDTO.setPeso(10.0d);
        actualUsuarioUpdateDTO.setSenha("Senha");
        Integer actualAltura = actualUsuarioUpdateDTO.getAltura();
        Date actualDataNascimento = actualUsuarioUpdateDTO.getDataNascimento();
        String actualGenero = actualUsuarioUpdateDTO.getGenero();
        String actualImg = actualUsuarioUpdateDTO.getImg();
        String actualMeta = actualUsuarioUpdateDTO.getMeta();
        String actualNivelCondicao = actualUsuarioUpdateDTO.getNivelCondicao();
        String actualNome = actualUsuarioUpdateDTO.getNome();
        Double actualPeso = actualUsuarioUpdateDTO.getPeso();

        // Assert that nothing has changed
        assertEquals("Genero", actualGenero);
        assertEquals("Img", actualImg);
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualNome);
        assertEquals("Senha", actualUsuarioUpdateDTO.getSenha());
        assertEquals(1, actualAltura.intValue());
        assertEquals(10.0d, actualPeso.doubleValue());
        assertSame(dataNascimento, actualDataNascimento);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link UsuarioUpdateDTO#UsuarioUpdateDTO(String, String, String, String, Double, Integer, Date, String, String)}
     *   <li>{@link UsuarioUpdateDTO#setAltura(Integer)}
     *   <li>{@link UsuarioUpdateDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioUpdateDTO#setGenero(String)}
     *   <li>{@link UsuarioUpdateDTO#setImg(String)}
     *   <li>{@link UsuarioUpdateDTO#setMeta(String)}
     *   <li>{@link UsuarioUpdateDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioUpdateDTO#setNome(String)}
     *   <li>{@link UsuarioUpdateDTO#setPeso(Double)}
     *   <li>{@link UsuarioUpdateDTO#setSenha(String)}
     *   <li>{@link UsuarioUpdateDTO#getAltura()}
     *   <li>{@link UsuarioUpdateDTO#getDataNascimento()}
     *   <li>{@link UsuarioUpdateDTO#getGenero()}
     *   <li>{@link UsuarioUpdateDTO#getImg()}
     *   <li>{@link UsuarioUpdateDTO#getMeta()}
     *   <li>{@link UsuarioUpdateDTO#getNivelCondicao()}
     *   <li>{@link UsuarioUpdateDTO#getNome()}
     *   <li>{@link UsuarioUpdateDTO#getPeso()}
     *   <li>{@link UsuarioUpdateDTO#getSenha()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        UsuarioUpdateDTO actualUsuarioUpdateDTO = new UsuarioUpdateDTO("Nome", "Senha", "Img", "Genero", 10.0d, 1,
                mock(Date.class), "Meta", "Nivel Condicao");
        actualUsuarioUpdateDTO.setAltura(1);
        Date dataNascimento = mock(Date.class);
        actualUsuarioUpdateDTO.setDataNascimento(dataNascimento);
        actualUsuarioUpdateDTO.setGenero("Genero");
        actualUsuarioUpdateDTO.setImg("Img");
        actualUsuarioUpdateDTO.setMeta("Meta");
        actualUsuarioUpdateDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioUpdateDTO.setNome("Nome");
        actualUsuarioUpdateDTO.setPeso(10.0d);
        actualUsuarioUpdateDTO.setSenha("Senha");
        Integer actualAltura = actualUsuarioUpdateDTO.getAltura();
        Date actualDataNascimento = actualUsuarioUpdateDTO.getDataNascimento();
        String actualGenero = actualUsuarioUpdateDTO.getGenero();
        String actualImg = actualUsuarioUpdateDTO.getImg();
        String actualMeta = actualUsuarioUpdateDTO.getMeta();
        String actualNivelCondicao = actualUsuarioUpdateDTO.getNivelCondicao();
        String actualNome = actualUsuarioUpdateDTO.getNome();
        Double actualPeso = actualUsuarioUpdateDTO.getPeso();

        // Assert that nothing has changed
        assertEquals("Genero", actualGenero);
        assertEquals("Img", actualImg);
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualNome);
        assertEquals("Senha", actualUsuarioUpdateDTO.getSenha());
        assertEquals(1, actualAltura.intValue());
        assertEquals(10.0d, actualPeso.doubleValue());
        assertSame(dataNascimento, actualDataNascimento);
    }
}
