package sync.spctrum.apispring.service.usuario.dto.modelMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

class UsuarioMapperTest {
    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioCreateDTO)}
     */
    @Test
    void testToEntity() {
        // Arrange and Act
        Usuario actualToEntityResult = UsuarioMapper
                .toEntity(new UsuarioCreateDTO("Nome", "jane.doe@example.org", "Senha", "Img"));

        // Assert
        assertEquals("Img", actualToEntityResult.getImg());
        assertEquals("Nome", actualToEntityResult.getNome());
        assertEquals("Senha", actualToEntityResult.getSenha());
        assertEquals("jane.doe@example.org", actualToEntityResult.getEmail());
    }

    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioCreateDTO)}
     */
    @Test
    void testToEntity2() {
        // Arrange
        UsuarioCreateDTO usuarioDTO = mock(UsuarioCreateDTO.class);
        when(usuarioDTO.getEmail()).thenReturn("jane.doe@example.org");
        when(usuarioDTO.getImg()).thenReturn("Img");
        when(usuarioDTO.getNome()).thenReturn("Nome");
        when(usuarioDTO.getSenha()).thenReturn("Senha");

        // Act
        Usuario actualToEntityResult = UsuarioMapper.toEntity(usuarioDTO);

        // Assert
        verify(usuarioDTO).getEmail();
        verify(usuarioDTO).getImg();
        verify(usuarioDTO).getNome();
        verify(usuarioDTO).getSenha();
        assertEquals("Img", actualToEntityResult.getImg());
        assertEquals("Nome", actualToEntityResult.getNome());
        assertEquals("Senha", actualToEntityResult.getSenha());
        assertEquals("jane.doe@example.org", actualToEntityResult.getEmail());
    }

    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioCreateDTO)}
     */
    @Test
    void testToEntity3() {
        // Arrange
        UsuarioCreateDTO usuarioDTO = mock(UsuarioCreateDTO.class);
        when(usuarioDTO.getEmail()).thenReturn("foo");
        when(usuarioDTO.getImg()).thenReturn("foo");
        when(usuarioDTO.getNome()).thenReturn("Nome");
        when(usuarioDTO.getSenha()).thenReturn("Senha");

        // Act
        Usuario actualToEntityResult = UsuarioMapper.toEntity(usuarioDTO);

        // Assert
        verify(usuarioDTO).getEmail();
        verify(usuarioDTO).getImg();
        verify(usuarioDTO).getNome();
        verify(usuarioDTO).getSenha();
        assertEquals("Nome", actualToEntityResult.getNome());
        assertEquals("Senha", actualToEntityResult.getSenha());
        assertEquals("foo", actualToEntityResult.getEmail());
        assertEquals("foo", actualToEntityResult.getImg());
    }

    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioResponseDTO)}
     */
    @Test
    void testToEntity4() {
        // Arrange and Act
        Usuario actualToEntityResult = UsuarioMapper.toEntity(new UsuarioResponseDTO());

        // Assert
        assertNull(actualToEntityResult.getContaAtiva());
        assertNull(actualToEntityResult.getPeso());
        assertNull(actualToEntityResult.getAltura());
        assertNull(actualToEntityResult.getId());
        assertNull(actualToEntityResult.getEmail());
        assertNull(actualToEntityResult.getGenero());
        assertNull(actualToEntityResult.getImg());
        assertNull(actualToEntityResult.getMeta());
        assertNull(actualToEntityResult.getNivelCondicao());
        assertNull(actualToEntityResult.getNome());
        assertNull(actualToEntityResult.getDataNascimento());
        assertEquals(0, actualToEntityResult.getPontuacao());
    }

    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioResponseDTO)}
     */
    @Test
    void testToEntity5() {
        // Arrange
        Date dataNascimento = mock(Date.class);

        // Act
        Usuario actualToEntityResult = UsuarioMapper.toEntity(new UsuarioResponseDTO(1L, "Nome", "jane.doe@example.org",
                "Img", dataNascimento, "Genero", 10.0d, 1, "Nivel Condicao", "Meta", true, 1, new ObjetivoResponseDTO()));

        // Assert
        assertEquals("Genero", actualToEntityResult.getGenero());
        assertEquals("Img", actualToEntityResult.getImg());
        assertEquals("Meta", actualToEntityResult.getMeta());
        assertEquals("Nivel Condicao", actualToEntityResult.getNivelCondicao());
        assertEquals("Nome", actualToEntityResult.getNome());
        assertEquals("jane.doe@example.org", actualToEntityResult.getEmail());
        Objetivo objetivo = actualToEntityResult.getObjetivo();
        Usuario usuario = objetivo.getUsuario();
        assertNull(usuario.getAltura());
        assertNull(objetivo.getId());
        assertNull(usuario.getId());
        assertNull(objetivo.getObjetivo());
        assertEquals(1, actualToEntityResult.getAltura().intValue());
        assertEquals(1, actualToEntityResult.getPontuacao());
        assertEquals(10.0d, actualToEntityResult.getPeso().doubleValue());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertTrue(actualToEntityResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioMapper#toEntity(UsuarioResponseDTO)}
     */
    @Test
    void testToEntity6() {
        // Arrange
        Date dataNascimento = mock(Date.class);

        // Act
        Usuario actualToEntityResult = UsuarioMapper
                .toEntity(new UsuarioResponseDTO(1L, "Nome", "jane.doe@example.org", "Img", dataNascimento, "Genero", 10.0d, 1,
                        "Nivel Condicao", "Meta", true, 1, new ObjetivoResponseDTO(1L, "Objetivo")));

        // Assert
        assertEquals("Genero", actualToEntityResult.getGenero());
        assertEquals("Img", actualToEntityResult.getImg());
        assertEquals("Meta", actualToEntityResult.getMeta());
        assertEquals("Nivel Condicao", actualToEntityResult.getNivelCondicao());
        assertEquals("Nome", actualToEntityResult.getNome());
        Objetivo objetivo = actualToEntityResult.getObjetivo();
        Usuario usuario = objetivo.getUsuario();
        Objetivo objetivo2 = usuario.getObjetivo();
        assertEquals("Objetivo", objetivo2.getObjetivo());
        assertEquals("Objetivo", objetivo.getObjetivo());
        assertEquals("jane.doe@example.org", actualToEntityResult.getEmail());
        assertNull(usuario.getAltura());
        assertNull(objetivo2.getUsuario());
        assertEquals(1, actualToEntityResult.getAltura().intValue());
        assertEquals(1, actualToEntityResult.getPontuacao());
        assertEquals(10.0d, actualToEntityResult.getPeso().doubleValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, objetivo.getId().longValue());
        assertEquals(1L, usuario.getId().longValue());
        assertEquals(1L, actualToEntityResult.getId().longValue());
        assertTrue(actualToEntityResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioMapper#toRespostaDTO(Usuario)}
     */
    @Test
    void testToRespostaDTO() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        // Act
        UsuarioResponseDTO actualToRespostaDTOResult = UsuarioMapper.toRespostaDTO(usuario2);

        // Assert
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("1969-12-31", simpleDateFormat.format(actualToRespostaDTOResult.getDataNascimento()));
        assertEquals("Genero", actualToRespostaDTOResult.getGenero());
        assertEquals("Img", actualToRespostaDTOResult.getImg());
        assertEquals("Meta", actualToRespostaDTOResult.getMeta());
        assertEquals("Nivel Condicao", actualToRespostaDTOResult.getNivelCondicao());
        assertEquals("Nome", actualToRespostaDTOResult.getNome());
        ObjetivoResponseDTO objetivo3 = actualToRespostaDTOResult.getObjetivo();
        assertEquals("Objetivo", objetivo3.getObjetivo());
        assertEquals("jane.doe@example.org", actualToRespostaDTOResult.getEmail());
        assertEquals(1, actualToRespostaDTOResult.getAltura().intValue());
        assertEquals(1, actualToRespostaDTOResult.getPontuacao());
        assertEquals(10.0d, actualToRespostaDTOResult.getPeso().doubleValue());
        assertEquals(1L, objetivo3.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertTrue(actualToRespostaDTOResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioMapper#toRespostaDTO(Usuario)}
     */
    @Test
    void testToRespostaDTO2() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo3);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario2);

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
        usuario3.setObjetivo(objetivo4);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");

        Objetivo objetivo5 = new Objetivo();
        objetivo5.setId(1L);
        objetivo5.setObjetivo("Objetivo");
        objetivo5.setUsuario(usuario3);
        Usuario usuario4 = mock(Usuario.class);
        when(usuario4.getPontuacao()).thenReturn(1);
        when(usuario4.getContaAtiva()).thenReturn(true);
        when(usuario4.getPeso()).thenReturn(10.0d);
        when(usuario4.getAltura()).thenReturn(1);
        when(usuario4.getId()).thenReturn(1L);
        when(usuario4.getEmail()).thenReturn("jane.doe@example.org");
        when(usuario4.getGenero()).thenReturn("Genero");
        when(usuario4.getImg()).thenReturn("Img");
        when(usuario4.getMeta()).thenReturn("Meta");
        when(usuario4.getNivelCondicao()).thenReturn("Nivel Condicao");
        when(usuario4.getNome()).thenReturn("Nome");
        when(usuario4.getDataNascimento())
                .thenReturn(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(usuario4.getObjetivo()).thenReturn(objetivo5);
        doNothing().when(usuario4).preUpdate();
        doNothing().when(usuario4).setAltura(Mockito.<Integer>any());
        doNothing().when(usuario4).setContaAtiva(Mockito.<Boolean>any());
        doNothing().when(usuario4).setDataNascimento(Mockito.<java.util.Date>any());
        doNothing().when(usuario4).setEmail(Mockito.<String>any());
        doNothing().when(usuario4).setGenero(Mockito.<String>any());
        doNothing().when(usuario4).setHoraSenhaAtualizacao(Mockito.<LocalDateTime>any());
        doNothing().when(usuario4).setId(Mockito.<Long>any());
        doNothing().when(usuario4).setImg(Mockito.<String>any());
        doNothing().when(usuario4).setMeta(Mockito.<String>any());
        doNothing().when(usuario4).setNivelCondicao(Mockito.<String>any());
        doNothing().when(usuario4).setNome(Mockito.<String>any());
        doNothing().when(usuario4).setObjetivo(Mockito.<Objetivo>any());
        doNothing().when(usuario4).setPeso(Mockito.<Double>any());
        doNothing().when(usuario4).setPontuacao(anyInt());
        doNothing().when(usuario4).setSenha(Mockito.<String>any());
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

        // Act
        UsuarioResponseDTO actualToRespostaDTOResult = UsuarioMapper.toRespostaDTO(usuario4);

        // Assert
        verify(usuario4).getAltura();
        verify(usuario4).getContaAtiva();
        verify(usuario4).getDataNascimento();
        verify(usuario4).getEmail();
        verify(usuario4).getGenero();
        verify(usuario4).getId();
        verify(usuario4).getImg();
        verify(usuario4).getMeta();
        verify(usuario4).getNivelCondicao();
        verify(usuario4).getNome();
        verify(usuario4, atLeast(1)).getObjetivo();
        verify(usuario4).getPeso();
        verify(usuario4).getPontuacao();
        verify(usuario4).preUpdate();
        verify(usuario4).setAltura(eq(1));
        verify(usuario4).setContaAtiva(eq(true));
        verify(usuario4).setDataNascimento(isA(java.util.Date.class));
        verify(usuario4).setEmail(eq("jane.doe@example.org"));
        verify(usuario4).setGenero(eq("Genero"));
        verify(usuario4).setHoraSenhaAtualizacao(isA(LocalDateTime.class));
        verify(usuario4).setId(eq(1L));
        verify(usuario4).setImg(eq("Img"));
        verify(usuario4).setMeta(eq("Meta"));
        verify(usuario4).setNivelCondicao(eq("Nivel Condicao"));
        verify(usuario4).setNome(eq("Nome"));
        verify(usuario4).setObjetivo(isA(Objetivo.class));
        verify(usuario4).setPeso(eq(10.0d));
        verify(usuario4).setPontuacao(eq(1));
        verify(usuario4).setSenha(eq("Senha"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("1969-12-31", simpleDateFormat.format(actualToRespostaDTOResult.getDataNascimento()));
        assertEquals("Genero", actualToRespostaDTOResult.getGenero());
        assertEquals("Img", actualToRespostaDTOResult.getImg());
        assertEquals("Meta", actualToRespostaDTOResult.getMeta());
        assertEquals("Nivel Condicao", actualToRespostaDTOResult.getNivelCondicao());
        assertEquals("Nome", actualToRespostaDTOResult.getNome());
        ObjetivoResponseDTO objetivo6 = actualToRespostaDTOResult.getObjetivo();
        assertEquals("Objetivo", objetivo6.getObjetivo());
        assertEquals("jane.doe@example.org", actualToRespostaDTOResult.getEmail());
        assertEquals(1, actualToRespostaDTOResult.getAltura().intValue());
        assertEquals(1, actualToRespostaDTOResult.getPontuacao());
        assertEquals(10.0d, actualToRespostaDTOResult.getPeso().doubleValue());
        assertEquals(1L, objetivo6.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertTrue(actualToRespostaDTOResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioMapper#toRespostaDTO(Usuario)}
     */
    @Test
    void testToRespostaDTO3() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo3);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario2);

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
        usuario3.setObjetivo(objetivo4);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");

        Objetivo objetivo5 = new Objetivo();
        objetivo5.setId(1L);
        objetivo5.setObjetivo("Objetivo");
        objetivo5.setUsuario(usuario3);
        Usuario usuario4 = mock(Usuario.class);
        when(usuario4.getPontuacao()).thenReturn(1);
        when(usuario4.getContaAtiva()).thenReturn(true);
        when(usuario4.getPeso()).thenReturn(10.0d);
        when(usuario4.getAltura()).thenReturn(1);
        when(usuario4.getId()).thenReturn(1L);
        when(usuario4.getEmail()).thenReturn("jane.doe@example.org");
        when(usuario4.getGenero()).thenReturn("Genero");
        when(usuario4.getImg()).thenReturn("Img");
        when(usuario4.getMeta()).thenReturn("Meta");
        when(usuario4.getNivelCondicao()).thenReturn("Nivel Condicao");
        when(usuario4.getNome()).thenReturn("Nome");
        when(usuario4.getDataNascimento()).thenReturn(null);
        when(usuario4.getObjetivo()).thenReturn(objetivo5);
        doNothing().when(usuario4).preUpdate();
        doNothing().when(usuario4).setAltura(Mockito.<Integer>any());
        doNothing().when(usuario4).setContaAtiva(Mockito.<Boolean>any());
        doNothing().when(usuario4).setDataNascimento(Mockito.<java.util.Date>any());
        doNothing().when(usuario4).setEmail(Mockito.<String>any());
        doNothing().when(usuario4).setGenero(Mockito.<String>any());
        doNothing().when(usuario4).setHoraSenhaAtualizacao(Mockito.<LocalDateTime>any());
        doNothing().when(usuario4).setId(Mockito.<Long>any());
        doNothing().when(usuario4).setImg(Mockito.<String>any());
        doNothing().when(usuario4).setMeta(Mockito.<String>any());
        doNothing().when(usuario4).setNivelCondicao(Mockito.<String>any());
        doNothing().when(usuario4).setNome(Mockito.<String>any());
        doNothing().when(usuario4).setObjetivo(Mockito.<Objetivo>any());
        doNothing().when(usuario4).setPeso(Mockito.<Double>any());
        doNothing().when(usuario4).setPontuacao(anyInt());
        doNothing().when(usuario4).setSenha(Mockito.<String>any());
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

        // Act
        UsuarioResponseDTO actualToRespostaDTOResult = UsuarioMapper.toRespostaDTO(usuario4);

        // Assert
        verify(usuario4).getAltura();
        verify(usuario4).getContaAtiva();
        verify(usuario4).getDataNascimento();
        verify(usuario4).getEmail();
        verify(usuario4).getGenero();
        verify(usuario4).getId();
        verify(usuario4).getImg();
        verify(usuario4).getMeta();
        verify(usuario4).getNivelCondicao();
        verify(usuario4).getNome();
        verify(usuario4, atLeast(1)).getObjetivo();
        verify(usuario4).getPeso();
        verify(usuario4).getPontuacao();
        verify(usuario4).preUpdate();
        verify(usuario4).setAltura(eq(1));
        verify(usuario4).setContaAtiva(eq(true));
        verify(usuario4).setDataNascimento(isA(java.util.Date.class));
        verify(usuario4).setEmail(eq("jane.doe@example.org"));
        verify(usuario4).setGenero(eq("Genero"));
        verify(usuario4).setHoraSenhaAtualizacao(isA(LocalDateTime.class));
        verify(usuario4).setId(eq(1L));
        verify(usuario4).setImg(eq("Img"));
        verify(usuario4).setMeta(eq("Meta"));
        verify(usuario4).setNivelCondicao(eq("Nivel Condicao"));
        verify(usuario4).setNome(eq("Nome"));
        verify(usuario4).setObjetivo(isA(Objetivo.class));
        verify(usuario4).setPeso(eq(10.0d));
        verify(usuario4).setPontuacao(eq(1));
        verify(usuario4).setSenha(eq("Senha"));
        assertEquals("Genero", actualToRespostaDTOResult.getGenero());
        assertEquals("Img", actualToRespostaDTOResult.getImg());
        assertEquals("Meta", actualToRespostaDTOResult.getMeta());
        assertEquals("Nivel Condicao", actualToRespostaDTOResult.getNivelCondicao());
        assertEquals("Nome", actualToRespostaDTOResult.getNome());
        ObjetivoResponseDTO objetivo6 = actualToRespostaDTOResult.getObjetivo();
        assertEquals("Objetivo", objetivo6.getObjetivo());
        assertEquals("jane.doe@example.org", actualToRespostaDTOResult.getEmail());
        assertNull(actualToRespostaDTOResult.getDataNascimento());
        assertEquals(1, actualToRespostaDTOResult.getAltura().intValue());
        assertEquals(1, actualToRespostaDTOResult.getPontuacao());
        assertEquals(10.0d, actualToRespostaDTOResult.getPeso().doubleValue());
        assertEquals(1L, objetivo6.getId().longValue());
        assertEquals(1L, actualToRespostaDTOResult.getId().longValue());
        assertTrue(actualToRespostaDTOResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO() {
        // Arrange and Act
        List<UsuarioResponseDTO> actualToListRespostaDTOResult = UsuarioMapper.toListRespostaDTO(new ArrayList<>());

        // Assert
        assertTrue(actualToListRespostaDTOResult.isEmpty());
    }

    /**
     * Method under test: {@link UsuarioMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO2() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario2);

        // Act
        List<UsuarioResponseDTO> actualToListRespostaDTOResult = UsuarioMapper.toListRespostaDTO(usuarios);

        // Assert
        assertEquals(1, actualToListRespostaDTOResult.size());
    }

    /**
     * Method under test: {@link UsuarioMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO3() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(new Usuario());

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
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(0);
        usuario3.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario3);

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
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(0);
        usuario4.setSenha("42");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario4);
        usuarios.add(usuario2);

        // Act
        List<UsuarioResponseDTO> actualToListRespostaDTOResult = UsuarioMapper.toListRespostaDTO(usuarios);

        // Assert
        assertEquals(2, actualToListRespostaDTOResult.size());
    }

    /**
     * Method under test: {@link UsuarioMapper#toToken(Usuario, String)}
     */
    @Test
    void testToToken() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        // Act
        UsuarioTokenDTO actualToTokenResult = UsuarioMapper.toToken(usuario2, "ABC123");

        // Assert
        assertEquals("ABC123", actualToTokenResult.getToken());
        assertEquals("Nome", actualToTokenResult.getNome());
        assertEquals("jane.doe@example.org", actualToTokenResult.getEmail());
        assertEquals(1L, actualToTokenResult.getUserId().longValue());
    }

    /**
     * Method under test: {@link UsuarioMapper#toToken(Usuario, String)}
     */
    @Test
    void testToToken2() {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");
        objetivo.setUsuario(new Usuario());

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
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);
        Usuario usuario2 = mock(Usuario.class);
        when(usuario2.getId()).thenReturn(1L);
        when(usuario2.getEmail()).thenReturn("jane.doe@example.org");
        when(usuario2.getNome()).thenReturn("Nome");
        doNothing().when(usuario2).preUpdate();
        doNothing().when(usuario2).setAltura(Mockito.<Integer>any());
        doNothing().when(usuario2).setContaAtiva(Mockito.<Boolean>any());
        doNothing().when(usuario2).setDataNascimento(Mockito.<java.util.Date>any());
        doNothing().when(usuario2).setEmail(Mockito.<String>any());
        doNothing().when(usuario2).setGenero(Mockito.<String>any());
        doNothing().when(usuario2).setHoraSenhaAtualizacao(Mockito.<LocalDateTime>any());
        doNothing().when(usuario2).setId(Mockito.<Long>any());
        doNothing().when(usuario2).setImg(Mockito.<String>any());
        doNothing().when(usuario2).setMeta(Mockito.<String>any());
        doNothing().when(usuario2).setNivelCondicao(Mockito.<String>any());
        doNothing().when(usuario2).setNome(Mockito.<String>any());
        doNothing().when(usuario2).setObjetivo(Mockito.<Objetivo>any());
        doNothing().when(usuario2).setPeso(Mockito.<Double>any());
        doNothing().when(usuario2).setPontuacao(anyInt());
        doNothing().when(usuario2).setSenha(Mockito.<String>any());
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
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setSenha("Senha");

        // Act
        UsuarioTokenDTO actualToTokenResult = UsuarioMapper.toToken(usuario2, "ABC123");

        // Assert
        verify(usuario2).getEmail();
        verify(usuario2).getId();
        verify(usuario2).getNome();
        verify(usuario2).preUpdate();
        verify(usuario2).setAltura(eq(1));
        verify(usuario2).setContaAtiva(eq(true));
        verify(usuario2).setDataNascimento(isA(java.util.Date.class));
        verify(usuario2).setEmail(eq("jane.doe@example.org"));
        verify(usuario2).setGenero(eq("Genero"));
        verify(usuario2).setHoraSenhaAtualizacao(isA(LocalDateTime.class));
        verify(usuario2).setId(eq(1L));
        verify(usuario2).setImg(eq("Img"));
        verify(usuario2).setMeta(eq("Meta"));
        verify(usuario2).setNivelCondicao(eq("Nivel Condicao"));
        verify(usuario2).setNome(eq("Nome"));
        verify(usuario2).setObjetivo(isA(Objetivo.class));
        verify(usuario2).setPeso(eq(10.0d));
        verify(usuario2).setPontuacao(eq(1));
        verify(usuario2).setSenha(eq("Senha"));
        assertEquals("ABC123", actualToTokenResult.getToken());
        assertEquals("Nome", actualToTokenResult.getNome());
        assertEquals("jane.doe@example.org", actualToTokenResult.getEmail());
        assertEquals(1L, actualToTokenResult.getUserId().longValue());
    }
}
