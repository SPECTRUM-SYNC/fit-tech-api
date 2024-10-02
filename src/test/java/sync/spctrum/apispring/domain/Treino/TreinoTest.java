package sync.spctrum.apispring.domain.Treino;

import org.junit.jupiter.api.Test;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class TreinoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Treino#Treino()}
     *   <li>{@link Treino#setDataTreino(LocalDate)}
     *   <li>{@link Treino#setDescricao(String)}
     *   <li>{@link Treino#setId(Long)}
     *   <li>{@link Treino#setStatus(String)}
     *   <li>{@link Treino#setTipoTreino(String)}
     *   <li>{@link Treino#setUsuario(Usuario)}
     *   <li>{@link Treino#getDataTreino()}
     *   <li>{@link Treino#getDescricao()}
     *   <li>{@link Treino#getId()}
     *   <li>{@link Treino#getStatus()}
     *   <li>{@link Treino#getTipoTreino()}
     *   <li>{@link Treino#getUsuario()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        Treino actualTreino = new Treino();
        LocalDate dataTreino = LocalDate.of(1970, 1, 1);
        actualTreino.setDataTreino(dataTreino);
        actualTreino.setDescricao("Descricao");
        actualTreino.setId(1L);
        actualTreino.setStatus("Status");
        actualTreino.setTipoTreino("Tipo Treino");
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
        actualTreino.setUsuario(usuario2);
        LocalDate actualDataTreino = actualTreino.getDataTreino();
        String actualDescricao = actualTreino.getDescricao();
        Long actualId = actualTreino.getId();
        String actualStatus = actualTreino.getStatus();
        String actualTipoTreino = actualTreino.getTipoTreino();
        Usuario actualUsuario = actualTreino.getUsuario();

        // Assert that nothing has changed
        assertEquals("Descricao", actualDescricao);
        assertEquals("Status", actualStatus);
        assertEquals("Tipo Treino", actualTipoTreino);
        assertEquals(1L, actualId.longValue());
        assertSame(usuario2, actualUsuario);
        assertSame(dataTreino, actualDataTreino);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Treino#Treino(Long, String, LocalDate, String, String, Usuario)}
     *   <li>{@link Treino#setDataTreino(LocalDate)}
     *   <li>{@link Treino#setDescricao(String)}
     *   <li>{@link Treino#setId(Long)}
     *   <li>{@link Treino#setStatus(String)}
     *   <li>{@link Treino#setTipoTreino(String)}
     *   <li>{@link Treino#setUsuario(Usuario)}
     *   <li>{@link Treino#getDataTreino()}
     *   <li>{@link Treino#getDescricao()}
     *   <li>{@link Treino#getId()}
     *   <li>{@link Treino#getStatus()}
     *   <li>{@link Treino#getTipoTreino()}
     *   <li>{@link Treino#getUsuario()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange
        LocalDate dataTreino = LocalDate.of(1970, 1, 1);

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
        Treino actualTreino = new Treino(1L, "Descricao", dataTreino, "Tipo Treino", "Status", usuario2);
        LocalDate dataTreino2 = LocalDate.of(1970, 1, 1);
        actualTreino.setDataTreino(dataTreino2);
        actualTreino.setDescricao("Descricao");
        actualTreino.setId(1L);
        actualTreino.setStatus("Status");
        actualTreino.setTipoTreino("Tipo Treino");
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
        actualTreino.setUsuario(usuario4);
        LocalDate actualDataTreino = actualTreino.getDataTreino();
        String actualDescricao = actualTreino.getDescricao();
        Long actualId = actualTreino.getId();
        String actualStatus = actualTreino.getStatus();
        String actualTipoTreino = actualTreino.getTipoTreino();
        Usuario actualUsuario = actualTreino.getUsuario();

        // Assert that nothing has changed
        assertEquals("Descricao", actualDescricao);
        assertEquals("Status", actualStatus);
        assertEquals("Tipo Treino", actualTipoTreino);
        assertEquals(1L, actualId.longValue());
        assertSame(usuario4, actualUsuario);
        assertSame(dataTreino2, actualDataTreino);
    }
}
