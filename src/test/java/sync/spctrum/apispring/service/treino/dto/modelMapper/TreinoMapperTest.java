package sync.spctrum.apispring.service.treino.dto.modelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCreateDTO;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoResponseDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

class TreinoMapperTest {
    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoCreateDTO)}
     */
    @Test
    void testToEntity() {
        // Arrange
        TreinoCreateDTO treinoDTO = new TreinoCreateDTO();
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuarioId(1L);

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertNull(usuario.getAltura());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoCreateDTO)}
     */
    @Test
    void testToEntity2() {
        // Arrange
        TreinoCreateDTO treinoDTO = mock(TreinoCreateDTO.class);
        when(treinoDTO.getUsuarioId()).thenReturn(1L);
        when(treinoDTO.getDescricao()).thenReturn("Descricao");
        when(treinoDTO.getStatus()).thenReturn("Status");
        when(treinoDTO.getTipoTreino()).thenReturn("Tipo Treino");
        when(treinoDTO.getDataTreino()).thenReturn(LocalDate.of(1970, 1, 1));
        doNothing().when(treinoDTO).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treinoDTO).setDescricao(Mockito.<String>any());
        doNothing().when(treinoDTO).setStatus(Mockito.<String>any());
        doNothing().when(treinoDTO).setTipoTreino(Mockito.<String>any());
        doNothing().when(treinoDTO).setUsuarioId(Mockito.<Long>any());
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuarioId(1L);

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        verify(treinoDTO).getDataTreino();
        verify(treinoDTO).getDescricao();
        verify(treinoDTO).getStatus();
        verify(treinoDTO).getTipoTreino();
        verify(treinoDTO, atLeast(1)).getUsuarioId();
        verify(treinoDTO).setDataTreino(isA(LocalDate.class));
        verify(treinoDTO).setDescricao(eq("Descricao"));
        verify(treinoDTO).setStatus(eq("Status"));
        verify(treinoDTO).setTipoTreino(eq("Tipo Treino"));
        verify(treinoDTO).setUsuarioId(eq(1L));
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertNull(usuario.getAltura());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoCreateDTO)}
     */
    @Test
    void testToEntity3() {
        // Arrange
        TreinoCreateDTO treinoDTO = mock(TreinoCreateDTO.class);
        when(treinoDTO.getUsuarioId()).thenReturn(1L);
        when(treinoDTO.getDescricao()).thenReturn("Descricao");
        when(treinoDTO.getStatus()).thenReturn("Status");
        when(treinoDTO.getTipoTreino()).thenReturn("Tipo Treino");
        when(treinoDTO.getDataTreino()).thenReturn(null);
        doNothing().when(treinoDTO).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treinoDTO).setDescricao(Mockito.<String>any());
        doNothing().when(treinoDTO).setStatus(Mockito.<String>any());
        doNothing().when(treinoDTO).setTipoTreino(Mockito.<String>any());
        doNothing().when(treinoDTO).setUsuarioId(Mockito.<Long>any());
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuarioId(1L);

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        verify(treinoDTO).getDataTreino();
        verify(treinoDTO).getDescricao();
        verify(treinoDTO).getStatus();
        verify(treinoDTO).getTipoTreino();
        verify(treinoDTO, atLeast(1)).getUsuarioId();
        verify(treinoDTO).setDataTreino(isA(LocalDate.class));
        verify(treinoDTO).setDescricao(eq("Descricao"));
        verify(treinoDTO).setStatus(eq("Status"));
        verify(treinoDTO).setTipoTreino(eq("Tipo Treino"));
        verify(treinoDTO).setUsuarioId(eq(1L));
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertNull(usuario.getAltura());
        assertNull(actualToEntityResult.getDataTreino());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoResponseDTO)}
     */
    @Test
    void testToEntity4() {
        // Arrange
        TreinoResponseDTO treinoDTO = new TreinoResponseDTO();
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setId(1L);
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuario(new UsuarioResponseDTO());

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertNull(usuario.getContaAtiva());
        assertNull(usuario.getPeso());
        assertNull(usuario.getAltura());
        assertNull(usuario.getId());
        assertNull(usuario.getEmail());
        assertNull(usuario.getGenero());
        assertNull(usuario.getImg());
        assertNull(usuario.getMeta());
        assertNull(usuario.getNivelCondicao());
        assertNull(usuario.getNome());
        assertNull(usuario.getHoraSenhaAtualizacao());
        assertNull(usuario.getDataNascimento());
        assertEquals(0, usuario.getPontuacao());
        assertEquals(1L, actualToEntityResult.getId().longValue());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoResponseDTO)}
     */
    @Test
    void testToEntity5() {
        // Arrange
        TreinoResponseDTO treinoDTO = mock(TreinoResponseDTO.class);
        when(treinoDTO.getId()).thenReturn(1L);
        when(treinoDTO.getDescricao()).thenReturn("Descricao");
        when(treinoDTO.getStatus()).thenReturn("Status");
        when(treinoDTO.getTipoTreino()).thenReturn("Tipo Treino");
        when(treinoDTO.getDataTreino()).thenReturn(LocalDate.of(1970, 1, 1));
        when(treinoDTO.getUsuario()).thenReturn(new UsuarioResponseDTO());
        doNothing().when(treinoDTO).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treinoDTO).setDescricao(Mockito.<String>any());
        doNothing().when(treinoDTO).setId(Mockito.<Long>any());
        doNothing().when(treinoDTO).setStatus(Mockito.<String>any());
        doNothing().when(treinoDTO).setTipoTreino(Mockito.<String>any());
        doNothing().when(treinoDTO).setUsuario(Mockito.<UsuarioResponseDTO>any());
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setId(1L);
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuario(new UsuarioResponseDTO());

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        verify(treinoDTO).getDataTreino();
        verify(treinoDTO).getDescricao();
        verify(treinoDTO).getId();
        verify(treinoDTO).getStatus();
        verify(treinoDTO).getTipoTreino();
        verify(treinoDTO, atLeast(1)).getUsuario();
        verify(treinoDTO).setDataTreino(isA(LocalDate.class));
        verify(treinoDTO).setDescricao(eq("Descricao"));
        verify(treinoDTO).setId(eq(1L));
        verify(treinoDTO).setStatus(eq("Status"));
        verify(treinoDTO).setTipoTreino(eq("Tipo Treino"));
        verify(treinoDTO).setUsuario(isA(UsuarioResponseDTO.class));
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertNull(usuario.getContaAtiva());
        assertNull(usuario.getPeso());
        assertNull(usuario.getAltura());
        assertNull(usuario.getId());
        assertNull(usuario.getEmail());
        assertNull(usuario.getGenero());
        assertNull(usuario.getImg());
        assertNull(usuario.getMeta());
        assertNull(usuario.getNivelCondicao());
        assertNull(usuario.getNome());
        assertNull(usuario.getHoraSenhaAtualizacao());
        assertNull(usuario.getDataNascimento());
        assertEquals(0, usuario.getPontuacao());
        assertEquals(1L, actualToEntityResult.getId().longValue());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoResponseDTO)}
     */
    @Test
    void testToEntity6() {
        // Arrange
        TreinoResponseDTO treinoDTO = mock(TreinoResponseDTO.class);
        when(treinoDTO.getId()).thenReturn(1L);
        when(treinoDTO.getDescricao()).thenReturn("Descricao");
        when(treinoDTO.getStatus()).thenReturn("Status");
        when(treinoDTO.getTipoTreino()).thenReturn("Tipo Treino");
        when(treinoDTO.getDataTreino()).thenReturn(LocalDate.of(1970, 1, 1));
        Date dataNascimento = mock(Date.class);
        when(treinoDTO.getUsuario()).thenReturn(new UsuarioResponseDTO(1L, "Nome", "jane.doe@example.org", "Img",
                dataNascimento, "Genero", 10.0d, 1, "Nivel Condicao", "Meta", true, 1, new ObjetivoResponseDTO()));
        doNothing().when(treinoDTO).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treinoDTO).setDescricao(Mockito.<String>any());
        doNothing().when(treinoDTO).setId(Mockito.<Long>any());
        doNothing().when(treinoDTO).setStatus(Mockito.<String>any());
        doNothing().when(treinoDTO).setTipoTreino(Mockito.<String>any());
        doNothing().when(treinoDTO).setUsuario(Mockito.<UsuarioResponseDTO>any());
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setId(1L);
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuario(new UsuarioResponseDTO());

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        verify(treinoDTO).getDataTreino();
        verify(treinoDTO).getDescricao();
        verify(treinoDTO).getId();
        verify(treinoDTO).getStatus();
        verify(treinoDTO).getTipoTreino();
        verify(treinoDTO, atLeast(1)).getUsuario();
        verify(treinoDTO).setDataTreino(isA(LocalDate.class));
        verify(treinoDTO).setDescricao(eq("Descricao"));
        verify(treinoDTO).setId(eq(1L));
        verify(treinoDTO).setStatus(eq("Status"));
        verify(treinoDTO).setTipoTreino(eq("Tipo Treino"));
        verify(treinoDTO).setUsuario(isA(UsuarioResponseDTO.class));
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertEquals("Genero", usuario.getGenero());
        assertEquals("Img", usuario.getImg());
        assertEquals("Meta", usuario.getMeta());
        assertEquals("Nivel Condicao", usuario.getNivelCondicao());
        assertEquals("Nome", usuario.getNome());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        assertEquals("jane.doe@example.org", usuario.getEmail());
        Objetivo objetivo = usuario.getObjetivo();
        Usuario usuario2 = objetivo.getUsuario();
        assertNull(usuario2.getAltura());
        assertNull(objetivo.getId());
        assertNull(usuario2.getId());
        assertNull(objetivo.getObjetivo());
        assertNull(usuario.getHoraSenhaAtualizacao());
        assertEquals(1, usuario.getAltura().intValue());
        assertEquals(1, usuario.getPontuacao());
        assertEquals(10.0d, usuario.getPeso().doubleValue());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
        assertTrue(usuario.getContaAtiva());
    }

    /**
     * Method under test: {@link TreinoMapper#toEntity(TreinoResponseDTO)}
     */
    @Test
    void testToEntity7() {
        // Arrange
        TreinoResponseDTO treinoDTO = mock(TreinoResponseDTO.class);
        when(treinoDTO.getId()).thenReturn(1L);
        when(treinoDTO.getDescricao()).thenReturn("Descricao");
        when(treinoDTO.getStatus()).thenReturn("Status");
        when(treinoDTO.getTipoTreino()).thenReturn("Tipo Treino");
        when(treinoDTO.getDataTreino()).thenReturn(LocalDate.of(1970, 1, 1));
        Date dataNascimento = mock(Date.class);
        when(treinoDTO.getUsuario())
                .thenReturn(new UsuarioResponseDTO(1L, "Nome", "jane.doe@example.org", "Img", dataNascimento, "Genero", 10.0d,
                        1, "Nivel Condicao", "Meta", true, 1, new ObjetivoResponseDTO(1L, "Objetivo")));
        doNothing().when(treinoDTO).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treinoDTO).setDescricao(Mockito.<String>any());
        doNothing().when(treinoDTO).setId(Mockito.<Long>any());
        doNothing().when(treinoDTO).setStatus(Mockito.<String>any());
        doNothing().when(treinoDTO).setTipoTreino(Mockito.<String>any());
        doNothing().when(treinoDTO).setUsuario(Mockito.<UsuarioResponseDTO>any());
        treinoDTO.setDataTreino(LocalDate.of(1970, 1, 1));
        treinoDTO.setDescricao("Descricao");
        treinoDTO.setId(1L);
        treinoDTO.setStatus("Status");
        treinoDTO.setTipoTreino("Tipo Treino");
        treinoDTO.setUsuario(new UsuarioResponseDTO());

        // Act
        Treino actualToEntityResult = TreinoMapper.toEntity(treinoDTO);

        // Assert
        verify(treinoDTO).getDataTreino();
        verify(treinoDTO).getDescricao();
        verify(treinoDTO).getId();
        verify(treinoDTO).getStatus();
        verify(treinoDTO).getTipoTreino();
        verify(treinoDTO, atLeast(1)).getUsuario();
        verify(treinoDTO).setDataTreino(isA(LocalDate.class));
        verify(treinoDTO).setDescricao(eq("Descricao"));
        verify(treinoDTO).setId(eq(1L));
        verify(treinoDTO).setStatus(eq("Status"));
        verify(treinoDTO).setTipoTreino(eq("Tipo Treino"));
        verify(treinoDTO).setUsuario(isA(UsuarioResponseDTO.class));
        assertEquals("1970-01-01", actualToEntityResult.getDataTreino().toString());
        assertEquals("Descricao", actualToEntityResult.getDescricao());
        Usuario usuario = actualToEntityResult.getUsuario();
        assertEquals("Genero", usuario.getGenero());
        assertEquals("Img", usuario.getImg());
        assertEquals("Meta", usuario.getMeta());
        assertEquals("Nivel Condicao", usuario.getNivelCondicao());
        assertEquals("Nome", usuario.getNome());
        Objetivo objetivo = usuario.getObjetivo();
        Usuario usuario2 = objetivo.getUsuario();
        Objetivo objetivo2 = usuario2.getObjetivo();
        assertEquals("Objetivo", objetivo2.getObjetivo());
        assertEquals("Objetivo", objetivo.getObjetivo());
        assertEquals("Status", actualToEntityResult.getStatus());
        assertEquals("Tipo Treino", actualToEntityResult.getTipoTreino());
        assertEquals("jane.doe@example.org", usuario.getEmail());
        assertNull(usuario2.getAltura());
        assertNull(usuario.getHoraSenhaAtualizacao());
        assertNull(objetivo2.getUsuario());
        assertEquals(1, usuario.getAltura().intValue());
        assertEquals(1, usuario.getPontuacao());
        assertEquals(10.0d, usuario.getPeso().doubleValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, objetivo.getId().longValue());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertEquals(1L, usuario2.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
        assertTrue(usuario.getContaAtiva());
    }

    /**
     * Method under test: {@link TreinoMapper#toRespostaDTO(Treino)}
     */
    @Test
    void testToRespostaDTO() {
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
        usuario2.setSenha("Senha");

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

        // Act
        TreinoResponseDTO actualToRespostaDTOResult = TreinoMapper.toRespostaDTO(treino);

        // Assert
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario3 = actualToRespostaDTOResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario3.getDataNascimento()));
        assertEquals("1970-01-01", actualToRespostaDTOResult.getDataTreino().toString());
        assertEquals("Descricao", actualToRespostaDTOResult.getDescricao());
        assertEquals("Genero", usuario3.getGenero());
        assertEquals("Img", usuario3.getImg());
        assertEquals("Meta", usuario3.getMeta());
        assertEquals("Nivel Condicao", usuario3.getNivelCondicao());
        assertEquals("Nome", usuario3.getNome());
        ObjetivoResponseDTO objetivo2 = usuario3.getObjetivo();
        assertEquals("Objetivo", objetivo2.getObjetivo());
        assertEquals("Status", actualToRespostaDTOResult.getStatus());
        assertEquals("Tipo Treino", actualToRespostaDTOResult.getTipoTreino());
        assertEquals("jane.doe@example.org", usuario3.getEmail());
        assertEquals(1, usuario3.getAltura().intValue());
        assertEquals(1, usuario3.getPontuacao());
        assertEquals(10.0d, usuario3.getPeso().doubleValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertEquals(1L, usuario3.getId().longValue());
        assertTrue(usuario3.getContaAtiva());
    }

    /**
     * Method under test: {@link TreinoMapper#toRespostaDTO(Treino)}
     */
    @Test
    void testToRespostaDTO2() {
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
        usuario5.setSenha("Senha");
        Treino treino = mock(Treino.class);
        when(treino.getId()).thenReturn(1L);
        when(treino.getDescricao()).thenReturn("Descricao");
        when(treino.getStatus()).thenReturn("Status");
        when(treino.getTipoTreino()).thenReturn("Tipo Treino");
        when(treino.getDataTreino()).thenReturn(LocalDate.of(1970, 1, 1));
        when(treino.getUsuario()).thenReturn(usuario5);
        doNothing().when(treino).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treino).setDescricao(Mockito.<String>any());
        doNothing().when(treino).setId(Mockito.<Long>any());
        doNothing().when(treino).setStatus(Mockito.<String>any());
        doNothing().when(treino).setTipoTreino(Mockito.<String>any());
        doNothing().when(treino).setUsuario(Mockito.<Usuario>any());
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

        // Act
        TreinoResponseDTO actualToRespostaDTOResult = TreinoMapper.toRespostaDTO(treino);

        // Assert
        verify(treino).getDataTreino();
        verify(treino).getDescricao();
        verify(treino).getId();
        verify(treino).getStatus();
        verify(treino).getTipoTreino();
        verify(treino, atLeast(1)).getUsuario();
        verify(treino).setDataTreino(isA(LocalDate.class));
        verify(treino).setDescricao(eq("Descricao"));
        verify(treino).setId(eq(1L));
        verify(treino).setStatus(eq("Status"));
        verify(treino).setTipoTreino(eq("Tipo Treino"));
        verify(treino).setUsuario(isA(Usuario.class));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario6 = actualToRespostaDTOResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario6.getDataNascimento()));
        assertEquals("1970-01-01", actualToRespostaDTOResult.getDataTreino().toString());
        assertEquals("Descricao", actualToRespostaDTOResult.getDescricao());
        assertEquals("Genero", usuario6.getGenero());
        assertEquals("Img", usuario6.getImg());
        assertEquals("Meta", usuario6.getMeta());
        assertEquals("Nivel Condicao", usuario6.getNivelCondicao());
        assertEquals("Nome", usuario6.getNome());
        ObjetivoResponseDTO objetivo4 = usuario6.getObjetivo();
        assertEquals("Objetivo", objetivo4.getObjetivo());
        assertEquals("Status", actualToRespostaDTOResult.getStatus());
        assertEquals("Tipo Treino", actualToRespostaDTOResult.getTipoTreino());
        assertEquals("jane.doe@example.org", usuario6.getEmail());
        assertEquals(1, usuario6.getAltura().intValue());
        assertEquals(1, usuario6.getPontuacao());
        assertEquals(10.0d, usuario6.getPeso().doubleValue());
        assertEquals(1L, objetivo4.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertEquals(1L, usuario6.getId().longValue());
        assertTrue(usuario6.getContaAtiva());
    }

    /**
     * Method under test: {@link TreinoMapper#toRespostaDTO(Treino)}
     */
    @Test
    void testToRespostaDTO3() {
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
        usuario5.setSenha("Senha");
        Treino treino = mock(Treino.class);
        when(treino.getId()).thenReturn(1L);
        when(treino.getDescricao()).thenReturn("Descricao");
        when(treino.getStatus()).thenReturn("Status");
        when(treino.getTipoTreino()).thenReturn("Tipo Treino");
        when(treino.getDataTreino()).thenReturn(null);
        when(treino.getUsuario()).thenReturn(usuario5);
        doNothing().when(treino).setDataTreino(Mockito.<LocalDate>any());
        doNothing().when(treino).setDescricao(Mockito.<String>any());
        doNothing().when(treino).setId(Mockito.<Long>any());
        doNothing().when(treino).setStatus(Mockito.<String>any());
        doNothing().when(treino).setTipoTreino(Mockito.<String>any());
        doNothing().when(treino).setUsuario(Mockito.<Usuario>any());
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

        // Act
        TreinoResponseDTO actualToRespostaDTOResult = TreinoMapper.toRespostaDTO(treino);

        // Assert
        verify(treino).getDataTreino();
        verify(treino).getDescricao();
        verify(treino).getId();
        verify(treino).getStatus();
        verify(treino).getTipoTreino();
        verify(treino, atLeast(1)).getUsuario();
        verify(treino).setDataTreino(isA(LocalDate.class));
        verify(treino).setDescricao(eq("Descricao"));
        verify(treino).setId(eq(1L));
        verify(treino).setStatus(eq("Status"));
        verify(treino).setTipoTreino(eq("Tipo Treino"));
        verify(treino).setUsuario(isA(Usuario.class));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario6 = actualToRespostaDTOResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario6.getDataNascimento()));
        assertEquals("Descricao", actualToRespostaDTOResult.getDescricao());
        assertEquals("Genero", usuario6.getGenero());
        assertEquals("Img", usuario6.getImg());
        assertEquals("Meta", usuario6.getMeta());
        assertEquals("Nivel Condicao", usuario6.getNivelCondicao());
        assertEquals("Nome", usuario6.getNome());
        ObjetivoResponseDTO objetivo4 = usuario6.getObjetivo();
        assertEquals("Objetivo", objetivo4.getObjetivo());
        assertEquals("Status", actualToRespostaDTOResult.getStatus());
        assertEquals("Tipo Treino", actualToRespostaDTOResult.getTipoTreino());
        assertEquals("jane.doe@example.org", usuario6.getEmail());
        assertNull(actualToRespostaDTOResult.getDataTreino());
        assertEquals(1, usuario6.getAltura().intValue());
        assertEquals(1, usuario6.getPontuacao());
        assertEquals(10.0d, usuario6.getPeso().doubleValue());
        assertEquals(1L, objetivo4.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertEquals(1L, usuario6.getId().longValue());
        assertTrue(usuario6.getContaAtiva());
    }

    /**
     * Method under test: {@link TreinoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO() {
        // Arrange and Act
        List<TreinoResponseDTO> actualToListRespostaDTOResult = TreinoMapper.toListRespostaDTO(new ArrayList<>());

        // Assert
        assertTrue(actualToListRespostaDTOResult.isEmpty());
    }

    /**
     * Method under test: {@link TreinoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO2() {
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
        usuario2.setSenha("Senha");

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

        ArrayList<Treino> treinos = new ArrayList<>();
        treinos.add(treino);

        // Act
        List<TreinoResponseDTO> actualToListRespostaDTOResult = TreinoMapper.toListRespostaDTO(treinos);

        // Assert
        assertEquals(1, actualToListRespostaDTOResult.size());
    }

    /**
     * Method under test: {@link TreinoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO3() {
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
        usuario2.setSenha("Senha");

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

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
        usuario4.setSenha("42");

        Treino treino2 = new Treino();
        treino2.setDataTreino(LocalDate.of(1970, 1, 1));
        treino2.setDescricao("42");
        treino2.setId(2L);
        treino2.setStatus("42");
        treino2.setTipoTreino("42");
        treino2.setUsuario(usuario4);

        ArrayList<Treino> treinos = new ArrayList<>();
        treinos.add(treino2);
        treinos.add(treino);

        // Act
        List<TreinoResponseDTO> actualToListRespostaDTOResult = TreinoMapper.toListRespostaDTO(treinos);

        // Assert
        assertEquals(2, actualToListRespostaDTOResult.size());
    }
}
