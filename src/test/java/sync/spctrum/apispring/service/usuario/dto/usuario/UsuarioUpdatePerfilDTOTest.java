package sync.spctrum.apispring.service.usuario.dto.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class UsuarioUpdatePerfilDTOTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UsuarioUpdatePerfilDTO#UsuarioUpdatePerfilDTO()}
     *   <li>{@link UsuarioUpdatePerfilDTO#setAltura(Integer)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setMeta(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setNome(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#getAltura()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getDataNascimento()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getMeta()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getNivelCondicao()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getNome()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        UsuarioUpdatePerfilDTO actualUsuarioUpdatePerfilDTO = new UsuarioUpdatePerfilDTO();
        actualUsuarioUpdatePerfilDTO.setAltura(1);
        Date dataNascimento = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualUsuarioUpdatePerfilDTO.setDataNascimento(dataNascimento);
        actualUsuarioUpdatePerfilDTO.setMeta("Meta");
        actualUsuarioUpdatePerfilDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioUpdatePerfilDTO.setNome("Nome");
        Integer actualAltura = actualUsuarioUpdatePerfilDTO.getAltura();
        Date actualDataNascimento = actualUsuarioUpdatePerfilDTO.getDataNascimento();
        String actualMeta = actualUsuarioUpdatePerfilDTO.getMeta();
        String actualNivelCondicao = actualUsuarioUpdatePerfilDTO.getNivelCondicao();

        // Assert that nothing has changed
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualUsuarioUpdatePerfilDTO.getNome());
        assertEquals(1, actualAltura.intValue());
        assertSame(dataNascimento, actualDataNascimento);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link UsuarioUpdatePerfilDTO#UsuarioUpdatePerfilDTO(String, Integer, Date, String, String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setAltura(Integer)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setDataNascimento(Date)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setMeta(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setNivelCondicao(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#setNome(String)}
     *   <li>{@link UsuarioUpdatePerfilDTO#getAltura()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getDataNascimento()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getMeta()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getNivelCondicao()}
     *   <li>{@link UsuarioUpdatePerfilDTO#getNome()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        UsuarioUpdatePerfilDTO actualUsuarioUpdatePerfilDTO = new UsuarioUpdatePerfilDTO("Nome", 1,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), "Meta",
                "Nivel Condicao");
        actualUsuarioUpdatePerfilDTO.setAltura(1);
        Date dataNascimento = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualUsuarioUpdatePerfilDTO.setDataNascimento(dataNascimento);
        actualUsuarioUpdatePerfilDTO.setMeta("Meta");
        actualUsuarioUpdatePerfilDTO.setNivelCondicao("Nivel Condicao");
        actualUsuarioUpdatePerfilDTO.setNome("Nome");
        Integer actualAltura = actualUsuarioUpdatePerfilDTO.getAltura();
        Date actualDataNascimento = actualUsuarioUpdatePerfilDTO.getDataNascimento();
        String actualMeta = actualUsuarioUpdatePerfilDTO.getMeta();
        String actualNivelCondicao = actualUsuarioUpdatePerfilDTO.getNivelCondicao();

        // Assert that nothing has changed
        assertEquals("Meta", actualMeta);
        assertEquals("Nivel Condicao", actualNivelCondicao);
        assertEquals("Nome", actualUsuarioUpdatePerfilDTO.getNome());
        assertEquals(1, actualAltura.intValue());
        assertSame(dataNascimento, actualDataNascimento);
    }
}
