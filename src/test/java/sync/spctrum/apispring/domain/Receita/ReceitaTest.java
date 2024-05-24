package sync.spctrum.apispring.domain.Receita;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;

class ReceitaTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Receita#setAcucar(String)}
     *   <li>{@link Receita#setCalorias(String)}
     *   <li>{@link Receita#setCarboidratos(String)}
     *   <li>{@link Receita#setGorduras(String)}
     *   <li>{@link Receita#setId(Long)}
     *   <li>{@link Receita#setIngredientes(String[])}
     *   <li>{@link Receita#setModoPreparo(String)}
     *   <li>{@link Receita#setNome(String)}
     *   <li>{@link Receita#setProteina(String)}
     *   <li>{@link Receita#setTempoPreparo(String)}
     *   <li>{@link Receita#setTipo(String)}
     *   <li>{@link Receita#setUsuario(Usuario)}
     *   <li>{@link Receita#getAcucar()}
     *   <li>{@link Receita#getCalorias()}
     *   <li>{@link Receita#getCarboidratos()}
     *   <li>{@link Receita#getGorduras()}
     *   <li>{@link Receita#getId()}
     *   <li>{@link Receita#getIngredientes()}
     *   <li>{@link Receita#getModoPreparo()}
     *   <li>{@link Receita#getNome()}
     *   <li>{@link Receita#getProteina()}
     *   <li>{@link Receita#getTempoPreparo()}
     *   <li>{@link Receita#getTipo()}
     *   <li>{@link Receita#getUsuario()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Receita receita = new Receita();

        // Act
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        String[] ingredientes = new String[]{"Ingredientes"};
        receita.setIngredientes(ingredientes);
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
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
        usuario.setReceitas(new ArrayList<>());
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
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");
        receita.setUsuario(usuario2);
        String actualAcucar = receita.getAcucar();
        String actualCalorias = receita.getCalorias();
        String actualCarboidratos = receita.getCarboidratos();
        String actualGorduras = receita.getGorduras();
        Long actualId = receita.getId();
        String[] actualIngredientes = receita.getIngredientes();
        String actualModoPreparo = receita.getModoPreparo();
        String actualNome = receita.getNome();
        String actualProteina = receita.getProteina();
        String actualTempoPreparo = receita.getTempoPreparo();
        String actualTipo = receita.getTipo();
        Usuario actualUsuario = receita.getUsuario();

        // Assert that nothing has changed
        assertEquals("Acucar", actualAcucar);
        assertEquals("Calorias", actualCalorias);
        assertEquals("Carboidratos", actualCarboidratos);
        assertEquals("Gorduras", actualGorduras);
        assertEquals("Modo Preparo", actualModoPreparo);
        assertEquals("Nome", actualNome);
        assertEquals("Proteina", actualProteina);
        assertEquals("Tempo Preparo", actualTempoPreparo);
        assertEquals("Tipo", actualTipo);
        assertEquals(1L, actualId.longValue());
        assertSame(usuario2, actualUsuario);
        assertSame(ingredientes, actualIngredientes);
    }
}
