package sync.spctrum.apispring.service.historicoPeso.dto.modelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

class HistoricoPesoMapperTest {
    /**
     * Method under test:
     * {@link HistoricoPesoMapper#toEntity(HistoricoPesoCreateDTO, Usuario)}
     */
    @Test
    void testToEntity() {
        // Arrange
        HistoricoPesoCreateDTO pesoDTO = new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d);

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

        // Act
        HistoricoPeso actualToEntityResult = HistoricoPesoMapper.toEntity(pesoDTO, usuario2);

        // Assert
        assertEquals("1970-01-01", actualToEntityResult.getDataPostagem().toString());
        assertEquals(1, actualToEntityResult.getUsuario().getAltura().intValue());
        assertEquals(10.0d, actualToEntityResult.getPeso().doubleValue());
        assertEquals(10.0d, actualToEntityResult.getPesoMeta().doubleValue());
    }

    /**
     * Method under test:
     * {@link HistoricoPesoMapper#toEntity(HistoricoPesoCreateDTO, Usuario)}
     */
    @Test
    void testToEntity2() {
        // Arrange
        HistoricoPesoCreateDTO pesoDTO = mock(HistoricoPesoCreateDTO.class);
        when(pesoDTO.getPeso()).thenReturn(10.0d);
        when(pesoDTO.getPesoMeta()).thenReturn(10.0d);
        when(pesoDTO.getDataPostagem()).thenReturn(LocalDate.of(1970, 1, 1));

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

        // Act
        HistoricoPeso actualToEntityResult = HistoricoPesoMapper.toEntity(pesoDTO, usuario2);

        // Assert
        verify(pesoDTO).getDataPostagem();
        verify(pesoDTO).getPeso();
        verify(pesoDTO).getPesoMeta();
        assertEquals("1970-01-01", actualToEntityResult.getDataPostagem().toString());
        assertEquals(1, actualToEntityResult.getUsuario().getAltura().intValue());
        assertEquals(10.0d, actualToEntityResult.getPeso().doubleValue());
        assertEquals(10.0d, actualToEntityResult.getPesoMeta().doubleValue());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(List)}
     */
    @Test
    void testToResponse() {
        // Arrange and Act
        List<HistoricoPesoResponseDTO> actualToResponseResult = HistoricoPesoMapper.toResponse(new ArrayList<>());

        // Assert
        assertTrue(actualToResponseResult.isEmpty());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(List)}
     */
    @Test
    void testToResponse2() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);

        ArrayList<HistoricoPeso> pesos = new ArrayList<>();
        pesos.add(historicoPeso);

        // Act
        List<HistoricoPesoResponseDTO> actualToResponseResult = HistoricoPesoMapper.toResponse(pesos);

        // Assert
        assertEquals(1, actualToResponseResult.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualToResponseResult.get(0);
        UsuarioResponseDTO usuario3 = getResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario3.getDataNascimento()));
        assertEquals("1970-01-01", getResult.getDataPostagem().toString());
        assertEquals("Genero", usuario3.getGenero());
        assertEquals("Img", usuario3.getImg());
        assertEquals("Meta", usuario3.getMeta());
        assertEquals("Nivel Condicao", usuario3.getNivelCondicao());
        assertEquals("Nome", usuario3.getNome());
        ObjetivoResponseDTO objetivo2 = usuario3.getObjetivo();
        assertEquals("Objetivo", objetivo2.getObjetivo());
        assertEquals("jane.doe@example.org", usuario3.getEmail());
        assertEquals(1, usuario3.getAltura().intValue());
        assertEquals(1, usuario3.getPontuacao());
        assertEquals(10.0d, getResult.getPeso().doubleValue());
        assertEquals(10.0d, getResult.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario3.getPeso().doubleValue());
        assertEquals(1L, getResult.getId().longValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, usuario3.getId().longValue());
        assertTrue(usuario3.getContaAtiva());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(List)}
     */
    @Test
    void testToResponse3() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(0);
        usuario3.setContaAtiva(false);
        usuario3.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("john.smith@example.org");
        usuario3.setGenero("42");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(2L);
        usuario3.setImg("42");
        usuario3.setMeta("42");
        usuario3.setNivelCondicao("42");
        usuario3.setNome("42");
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(0);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("42");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(2L);
        objetivo2.setObjetivo("42");
        objetivo2.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(0);
        usuario4.setContaAtiva(false);
        usuario4.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("john.smith@example.org");
        usuario4.setGenero("42");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(2L);
        usuario4.setImg("42");
        usuario4.setMeta("42");
        usuario4.setNivelCondicao("42");
        usuario4.setNome("42");
        usuario4.setObjetivo(objetivo2);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(0);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        HistoricoPeso historicoPeso2 = new HistoricoPeso();
        historicoPeso2.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso2.setId(2L);
        historicoPeso2.setPeso(0.5d);
        historicoPeso2.setPesoMeta(0.5d);
        historicoPeso2.setUsuario(usuario4);

        ArrayList<HistoricoPeso> pesos = new ArrayList<>();
        pesos.add(historicoPeso2);
        pesos.add(historicoPeso);

        // Act
        List<HistoricoPesoResponseDTO> actualToResponseResult = HistoricoPesoMapper.toResponse(pesos);

        // Assert
        assertEquals(2, actualToResponseResult.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualToResponseResult.get(0);
        UsuarioResponseDTO usuario5 = getResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario5.getDataNascimento()));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult2 = actualToResponseResult.get(1);
        UsuarioResponseDTO usuario6 = getResult2.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat2.format(usuario6.getDataNascimento()));
        assertEquals("1970-01-01", getResult.getDataPostagem().toString());
        assertEquals("1970-01-01", getResult2.getDataPostagem().toString());
        ObjetivoResponseDTO objetivo3 = usuario5.getObjetivo();
        assertEquals("42", objetivo3.getObjetivo());
        assertEquals("42", usuario5.getGenero());
        assertEquals("42", usuario5.getImg());
        assertEquals("42", usuario5.getMeta());
        assertEquals("42", usuario5.getNivelCondicao());
        assertEquals("42", usuario5.getNome());
        assertEquals("Genero", usuario6.getGenero());
        assertEquals("Img", usuario6.getImg());
        assertEquals("Meta", usuario6.getMeta());
        assertEquals("Nivel Condicao", usuario6.getNivelCondicao());
        assertEquals("Nome", usuario6.getNome());
        ObjetivoResponseDTO objetivo4 = usuario6.getObjetivo();
        assertEquals("Objetivo", objetivo4.getObjetivo());
        assertEquals("jane.doe@example.org", usuario6.getEmail());
        assertEquals("john.smith@example.org", usuario5.getEmail());
        assertEquals(0, usuario5.getAltura().intValue());
        assertEquals(0, usuario5.getPontuacao());
        assertEquals(0.5d, getResult.getPeso().doubleValue());
        assertEquals(0.5d, getResult.getPesoMeta().doubleValue());
        assertEquals(0.5d, usuario5.getPeso().doubleValue());
        assertEquals(1, usuario6.getAltura().intValue());
        assertEquals(1, usuario6.getPontuacao());
        assertEquals(10.0d, getResult2.getPeso().doubleValue());
        assertEquals(10.0d, getResult2.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario6.getPeso().doubleValue());
        assertEquals(1L, getResult2.getId().longValue());
        assertEquals(1L, objetivo4.getId().longValue());
        assertEquals(1L, usuario6.getId().longValue());
        assertEquals(2L, getResult.getId().longValue());
        assertEquals(2L, objetivo3.getId().longValue());
        assertEquals(2L, usuario5.getId().longValue());
        assertFalse(usuario5.getContaAtiva());
        assertTrue(usuario6.getContaAtiva());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(HistoricoPeso)}
     */
    @Test
    void testToResponse4() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        HistoricoPeso peso = new HistoricoPeso();
        peso.setDataPostagem(LocalDate.of(1970, 1, 1));
        peso.setId(1L);
        peso.setPeso(10.0d);
        peso.setPesoMeta(10.0d);
        peso.setUsuario(usuario2);

        // Act
        HistoricoPesoResponseDTO actualToResponseResult = HistoricoPesoMapper.toResponse(peso);

        // Assert
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario3 = actualToResponseResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario3.getDataNascimento()));
        assertEquals("1970-01-01", actualToResponseResult.getDataPostagem().toString());
        assertEquals("Genero", usuario3.getGenero());
        assertEquals("Img", usuario3.getImg());
        assertEquals("Meta", usuario3.getMeta());
        assertEquals("Nivel Condicao", usuario3.getNivelCondicao());
        assertEquals("Nome", usuario3.getNome());
        ObjetivoResponseDTO objetivo2 = usuario3.getObjetivo();
        assertEquals("Objetivo", objetivo2.getObjetivo());
        assertEquals("jane.doe@example.org", usuario3.getEmail());
        assertEquals(1, usuario3.getAltura().intValue());
        assertEquals(1, usuario3.getPontuacao());
        assertEquals(10.0d, actualToResponseResult.getPeso().doubleValue());
        assertEquals(10.0d, actualToResponseResult.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario3.getPeso().doubleValue());
        assertEquals(1L, actualToResponseResult.getId().longValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, usuario3.getId().longValue());
        assertTrue(usuario3.getContaAtiva());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(HistoricoPeso)}
     */
    @Test
    void testToResponse5() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(1);
        usuario3.setContaAtiva(true);
        usuario3.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("jane.doe@example.org");
        usuario3.setGenero("Genero");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(1L);
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(1);
        usuario4.setContaAtiva(true);
        usuario4.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("jane.doe@example.org");
        usuario4.setGenero("Genero");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(1L);
        usuario4.setImg("Img");
        usuario4.setMeta("Meta");
        usuario4.setNivelCondicao("Nivel Condicao");
        usuario4.setNome("Nome");
        usuario4.setObjetivo(objetivo2);
        usuario4.setPeso(10.0d);
        usuario4.setPontuacao(1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("Senha");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(1);
        usuario5.setContaAtiva(true);
        usuario5.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("jane.doe@example.org");
        usuario5.setGenero("Genero");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(1L);
        usuario5.setImg("Img");
        usuario5.setMeta("Meta");
        usuario5.setNivelCondicao("Nivel Condicao");
        usuario5.setNome("Nome");
        usuario5.setObjetivo(objetivo3);
        usuario5.setPeso(10.0d);
        usuario5.setPontuacao(1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");
        HistoricoPeso peso = mock(HistoricoPeso.class);
        when(peso.getPeso()).thenReturn(10.0d);
        when(peso.getPesoMeta()).thenReturn(10.0d);
        when(peso.getId()).thenReturn(1L);
        when(peso.getDataPostagem()).thenReturn(LocalDate.of(1970, 1, 1));
        when(peso.getUsuario()).thenReturn(usuario5);
        doNothing().when(peso).setDataPostagem(Mockito.<LocalDate>any());
        doNothing().when(peso).setId(Mockito.<Long>any());
        doNothing().when(peso).setPeso(Mockito.<Double>any());
        doNothing().when(peso).setPesoMeta(Mockito.<Double>any());
        doNothing().when(peso).setUsuario(Mockito.<Usuario>any());
        peso.setDataPostagem(LocalDate.of(1970, 1, 1));
        peso.setId(1L);
        peso.setPeso(10.0d);
        peso.setPesoMeta(10.0d);
        peso.setUsuario(usuario2);

        // Act
        HistoricoPesoResponseDTO actualToResponseResult = HistoricoPesoMapper.toResponse(peso);

        // Assert
        verify(peso).getDataPostagem();
        verify(peso).getId();
        verify(peso).getPeso();
        verify(peso).getPesoMeta();
        verify(peso, atLeast(1)).getUsuario();
        verify(peso).setDataPostagem(isA(LocalDate.class));
        verify(peso).setId(eq(1L));
        verify(peso).setPeso(eq(10.0d));
        verify(peso).setPesoMeta(eq(10.0d));
        verify(peso).setUsuario(isA(Usuario.class));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario6 = actualToResponseResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario6.getDataNascimento()));
        assertEquals("1970-01-01", actualToResponseResult.getDataPostagem().toString());
        assertEquals("Genero", usuario6.getGenero());
        assertEquals("Img", usuario6.getImg());
        assertEquals("Meta", usuario6.getMeta());
        assertEquals("Nivel Condicao", usuario6.getNivelCondicao());
        assertEquals("Nome", usuario6.getNome());
        ObjetivoResponseDTO objetivo4 = usuario6.getObjetivo();
        assertEquals("Objetivo", objetivo4.getObjetivo());
        assertEquals("jane.doe@example.org", usuario6.getEmail());
        assertEquals(1, usuario6.getAltura().intValue());
        assertEquals(1, usuario6.getPontuacao());
        assertEquals(10.0d, actualToResponseResult.getPeso().doubleValue());
        assertEquals(10.0d, actualToResponseResult.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario6.getPeso().doubleValue());
        assertEquals(1L, actualToResponseResult.getId().longValue());
        assertEquals(1L, objetivo4.getId().longValue());
        assertEquals(1L, usuario6.getId().longValue());
        assertTrue(usuario6.getContaAtiva());
    }

    /**
     * Method under test: {@link HistoricoPesoMapper#toResponse(HistoricoPeso)}
     */
    @Test
    void testToResponse6() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Genero");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Img");
        usuario.setMeta("Meta");
        usuario.setNivelCondicao("Nivel Condicao");
        usuario.setNome("Nome");
        usuario.setObjetivo(new Objetivo());
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Genero");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Img");
        usuario2.setMeta("Meta");
        usuario2.setNivelCondicao("Nivel Condicao");
        usuario2.setNome("Nome");
        usuario2.setObjetivo(objetivo);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(1);
        usuario3.setContaAtiva(true);
        usuario3.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("jane.doe@example.org");
        usuario3.setGenero("Genero");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(1L);
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(1);
        usuario4.setContaAtiva(true);
        usuario4.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("jane.doe@example.org");
        usuario4.setGenero("Genero");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(1L);
        usuario4.setImg("Img");
        usuario4.setMeta("Meta");
        usuario4.setNivelCondicao("Nivel Condicao");
        usuario4.setNome("Nome");
        usuario4.setObjetivo(objetivo2);
        usuario4.setPeso(10.0d);
        usuario4.setPontuacao(1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("Senha");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(1);
        usuario5.setContaAtiva(true);
        usuario5.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("jane.doe@example.org");
        usuario5.setGenero("Genero");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(1L);
        usuario5.setImg("Img");
        usuario5.setMeta("Meta");
        usuario5.setNivelCondicao("Nivel Condicao");
        usuario5.setNome("Nome");
        usuario5.setObjetivo(objetivo3);
        usuario5.setPeso(10.0d);
        usuario5.setPontuacao(1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");
        HistoricoPeso peso = mock(HistoricoPeso.class);
        when(peso.getPeso()).thenReturn(10.0d);
        when(peso.getPesoMeta()).thenReturn(10.0d);
        when(peso.getId()).thenReturn(1L);
        when(peso.getDataPostagem()).thenReturn(null);
        when(peso.getUsuario()).thenReturn(usuario5);
        doNothing().when(peso).setDataPostagem(Mockito.<LocalDate>any());
        doNothing().when(peso).setId(Mockito.<Long>any());
        doNothing().when(peso).setPeso(Mockito.<Double>any());
        doNothing().when(peso).setPesoMeta(Mockito.<Double>any());
        doNothing().when(peso).setUsuario(Mockito.<Usuario>any());
        peso.setDataPostagem(LocalDate.of(1970, 1, 1));
        peso.setId(1L);
        peso.setPeso(10.0d);
        peso.setPesoMeta(10.0d);
        peso.setUsuario(usuario2);

        // Act
        HistoricoPesoResponseDTO actualToResponseResult = HistoricoPesoMapper.toResponse(peso);

        // Assert
        verify(peso).getDataPostagem();
        verify(peso).getId();
        verify(peso).getPeso();
        verify(peso).getPesoMeta();
        verify(peso, atLeast(1)).getUsuario();
        verify(peso).setDataPostagem(isA(LocalDate.class));
        verify(peso).setId(eq(1L));
        verify(peso).setPeso(eq(10.0d));
        verify(peso).setPesoMeta(eq(10.0d));
        verify(peso).setUsuario(isA(Usuario.class));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario6 = actualToResponseResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario6.getDataNascimento()));
        assertEquals("Genero", usuario6.getGenero());
        assertEquals("Img", usuario6.getImg());
        assertEquals("Meta", usuario6.getMeta());
        assertEquals("Nivel Condicao", usuario6.getNivelCondicao());
        assertEquals("Nome", usuario6.getNome());
        ObjetivoResponseDTO objetivo4 = usuario6.getObjetivo();
        assertEquals("Objetivo", objetivo4.getObjetivo());
        assertEquals("jane.doe@example.org", usuario6.getEmail());
        assertNull(actualToResponseResult.getDataPostagem());
        assertEquals(1, usuario6.getAltura().intValue());
        assertEquals(1, usuario6.getPontuacao());
        assertEquals(10.0d, actualToResponseResult.getPeso().doubleValue());
        assertEquals(10.0d, actualToResponseResult.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario6.getPeso().doubleValue());
        assertEquals(1L, actualToResponseResult.getId().longValue());
        assertEquals(1L, objetivo4.getId().longValue());
        assertEquals(1L, usuario6.getId().longValue());
        assertTrue(usuario6.getContaAtiva());
    }
}
