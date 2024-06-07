package sync.spctrum.apispring.domain.HistoricoPeso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;

class HistoricoPesoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link HistoricoPeso#HistoricoPeso()}
     *   <li>{@link HistoricoPeso#setDataPostagem(LocalDate)}
     *   <li>{@link HistoricoPeso#setId(Long)}
     *   <li>{@link HistoricoPeso#setPeso(Double)}
     *   <li>{@link HistoricoPeso#setPesoMeta(Double)}
     *   <li>{@link HistoricoPeso#setUsuario(Usuario)}
     *   <li>{@link HistoricoPeso#getDataPostagem()}
     *   <li>{@link HistoricoPeso#getId()}
     *   <li>{@link HistoricoPeso#getPeso()}
     *   <li>{@link HistoricoPeso#getPesoMeta()}
     *   <li>{@link HistoricoPeso#getUsuario()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        HistoricoPeso actualHistoricoPeso = new HistoricoPeso();
        LocalDate dataPostagem = LocalDate.of(1970, 1, 1);
        actualHistoricoPeso.setDataPostagem(dataPostagem);
        actualHistoricoPeso.setId(1L);
        actualHistoricoPeso.setPeso(10.0d);
        actualHistoricoPeso.setPesoMeta(10.0d);
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");
        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);
        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");
        actualHistoricoPeso.setUsuario(usuario2);
        LocalDate actualDataPostagem = actualHistoricoPeso.getDataPostagem();
        Long actualId = actualHistoricoPeso.getId();
        Double actualPeso = actualHistoricoPeso.getPeso();
        Double actualPesoMeta = actualHistoricoPeso.getPesoMeta();
        Usuario actualUsuario = actualHistoricoPeso.getUsuario();

        // Assert that nothing has changed
        assertEquals(10.0d, actualPeso.doubleValue());
        assertEquals(10.0d, actualPesoMeta.doubleValue());
        assertEquals(1L, actualId.longValue());
        assertSame(usuario2, actualUsuario);
        assertSame(dataPostagem, actualDataPostagem);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link HistoricoPeso#HistoricoPeso(Long, LocalDate, Double, Double, Usuario)}
     *   <li>{@link HistoricoPeso#setDataPostagem(LocalDate)}
     *   <li>{@link HistoricoPeso#setId(Long)}
     *   <li>{@link HistoricoPeso#setPeso(Double)}
     *   <li>{@link HistoricoPeso#setPesoMeta(Double)}
     *   <li>{@link HistoricoPeso#setUsuario(Usuario)}
     *   <li>{@link HistoricoPeso#getDataPostagem()}
     *   <li>{@link HistoricoPeso#getId()}
     *   <li>{@link HistoricoPeso#getPeso()}
     *   <li>{@link HistoricoPeso#getPesoMeta()}
     *   <li>{@link HistoricoPeso#getUsuario()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        LocalDate dataPostagem = LocalDate.of(1970, 1, 1);

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        // Act
        HistoricoPeso actualHistoricoPeso = new HistoricoPeso(1L, dataPostagem, 10.0d, 10.0d, usuario2);
        LocalDate dataPostagem2 = LocalDate.of(1970, 1, 1);
        actualHistoricoPeso.setDataPostagem(dataPostagem2);
        actualHistoricoPeso.setId(1L);
        actualHistoricoPeso.setPeso(10.0d);
        actualHistoricoPeso.setPesoMeta(10.0d);
        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(new Usuario());
        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(1);
        usuario3.setContaAtiva(true);
        usuario3.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("jane.doe@example.org");
        usuario3.setGenero("Genero");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(1L);
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");
        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario3);
        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(1);
        usuario4.setContaAtiva(true);
        usuario4.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("jane.doe@example.org");
        usuario4.setGenero("Genero");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(1L);
        usuario4.setImg("Img");
        usuario4.setMeta("Meta");
        usuario4.setNivelCondicao("Nivel Condicao");
        usuario4.setNome("Nome");
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(10.0d);
        usuario4.setPontuacao(1);
        usuario4.setSenha("Senha");
        actualHistoricoPeso.setUsuario(usuario4);
        LocalDate actualDataPostagem = actualHistoricoPeso.getDataPostagem();
        Long actualId = actualHistoricoPeso.getId();
        Double actualPeso = actualHistoricoPeso.getPeso();
        Double actualPesoMeta = actualHistoricoPeso.getPesoMeta();
        Usuario actualUsuario = actualHistoricoPeso.getUsuario();

        // Assert that nothing has changed
        assertEquals(10.0d, actualPeso.doubleValue());
        assertEquals(10.0d, actualPesoMeta.doubleValue());
        assertEquals(1L, actualId.longValue());
        assertSame(usuario4, actualUsuario);
        assertSame(dataPostagem2, actualDataPostagem);
    }
}
