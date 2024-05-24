package sync.spctrum.apispring.service.objetivo.dto.modelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

class ObjetivoMapperTest {
    /**
     * Method under test: {@link ObjetivoMapper#toEntity(ObjetivoCreateDTO)}
     */
    @Test
    void testToEntity() {
        // Arrange, Act and Assert
        assertEquals("Objetivo", ObjetivoMapper.toEntity(new ObjetivoCreateDTO("Objetivo")).getObjetivo());
        assertEquals("42", ObjetivoMapper.toEntity(new ObjetivoCreateDTO("42")).getObjetivo());
        assertNull(ObjetivoMapper.toEntity(new ObjetivoCreateDTO()).getObjetivo());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toEntity(ObjetivoCreateDTO)}
     */
    @Test
    void testToEntity2() {
        // Arrange
        ObjetivoCreateDTO objetivoDTO = mock(ObjetivoCreateDTO.class);
        when(objetivoDTO.getObjetivo()).thenReturn("Objetivo");

        // Act
        Objetivo actualToEntityResult = ObjetivoMapper.toEntity(objetivoDTO);

        // Assert
        verify(objetivoDTO).getObjetivo();
        assertEquals("Objetivo", actualToEntityResult.getObjetivo());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toEntity(ObjetivoResponseDTO)}
     */
    @Test
    void testToEntity3() {
        // Arrange and Act
        Objetivo actualToEntityResult = ObjetivoMapper.toEntity(new ObjetivoResponseDTO());

        // Assert
        assertNull(actualToEntityResult.getId());
        assertNull(actualToEntityResult.getObjetivo());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toEntity(ObjetivoResponseDTO)}
     */
    @Test
    void testToEntity4() {
        // Arrange and Act
        Objetivo actualToEntityResult = ObjetivoMapper.toEntity(new ObjetivoResponseDTO(1L, "Objetivo"));

        // Assert
        assertEquals("Objetivo", actualToEntityResult.getObjetivo());
        assertEquals(1L, actualToEntityResult.getId().longValue());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toEntity(ObjetivoResponseDTO)}
     */
    @Test
    void testToEntity5() {
        // Arrange
        ObjetivoResponseDTO objetivoDTO = mock(ObjetivoResponseDTO.class);
        when(objetivoDTO.getId()).thenReturn(1L);
        when(objetivoDTO.getObjetivo()).thenReturn("Objetivo");

        // Act
        Objetivo actualToEntityResult = ObjetivoMapper.toEntity(objetivoDTO);

        // Assert
        verify(objetivoDTO).getId();
        verify(objetivoDTO).getObjetivo();
        assertEquals("Objetivo", actualToEntityResult.getObjetivo());
        assertEquals(1L, actualToEntityResult.getId().longValue());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toObjetivoDTO(Objetivo)}
     */
    @Test
    void testToObjetivoDTO() {
        // Arrange
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
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

        // Act
        ObjetivoResponseDTO actualToObjetivoDTOResult = ObjetivoMapper.toObjetivoDTO(objetivo2);

        // Assert
        assertEquals("Objetivo", actualToObjetivoDTOResult.getObjetivo());
        assertEquals(1L, actualToObjetivoDTOResult.getId().longValue());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toObjetivoDTO(Objetivo)}
     */
    @Test
    void testToObjetivoDTO2() {
        // Arrange
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
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
        Objetivo objetivo2 = mock(Objetivo.class);
        when(objetivo2.getId()).thenReturn(1L);
        when(objetivo2.getObjetivo()).thenReturn("Objetivo");
        doNothing().when(objetivo2).setId(Mockito.<Long>any());
        doNothing().when(objetivo2).setObjetivo(Mockito.<String>any());
        doNothing().when(objetivo2).setUsuario(Mockito.<Usuario>any());
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

        // Act
        ObjetivoResponseDTO actualToObjetivoDTOResult = ObjetivoMapper.toObjetivoDTO(objetivo2);

        // Assert
        verify(objetivo2).getId();
        verify(objetivo2).getObjetivo();
        verify(objetivo2).setId(eq(1L));
        verify(objetivo2).setObjetivo(eq("Objetivo"));
        verify(objetivo2).setUsuario(isA(Usuario.class));
        assertEquals("Objetivo", actualToObjetivoDTOResult.getObjetivo());
        assertEquals(1L, actualToObjetivoDTOResult.getId().longValue());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO() {
        // Arrange and Act
        List<ObjetivoResponseDTO> actualToListRespostaDTOResult = ObjetivoMapper.toListRespostaDTO(new ArrayList<>());

        // Assert
        assertTrue(actualToListRespostaDTOResult.isEmpty());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO2() {
        // Arrange
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
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

        ArrayList<Objetivo> objetivos = new ArrayList<>();
        objetivos.add(objetivo2);

        // Act
        List<ObjetivoResponseDTO> actualToListRespostaDTOResult = ObjetivoMapper.toListRespostaDTO(objetivos);

        // Assert
        assertEquals(1, actualToListRespostaDTOResult.size());
        ObjetivoResponseDTO getResult = actualToListRespostaDTOResult.get(0);
        assertEquals("Objetivo", getResult.getObjetivo());
        assertEquals(1L, getResult.getId().longValue());
    }

    /**
     * Method under test: {@link ObjetivoMapper#toListRespostaDTO(List)}
     */
    @Test
    void testToListRespostaDTO3() {
        // Arrange
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
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(0);
        usuario3.setContaAtiva(false);
        usuario3.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(0);
        usuario4.setContaAtiva(false);
        usuario4.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("john.smith@example.org");
        usuario4.setGenero("42");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(2L);
        usuario4.setImg("42");
        usuario4.setMeta("42");
        usuario4.setNivelCondicao("42");
        usuario4.setNome("42");
        usuario4.setObjetivo(objetivo3);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(0);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario4);

        ArrayList<Objetivo> objetivos = new ArrayList<>();
        objetivos.add(objetivo4);
        objetivos.add(objetivo2);

        // Act
        List<ObjetivoResponseDTO> actualToListRespostaDTOResult = ObjetivoMapper.toListRespostaDTO(objetivos);

        // Assert
        assertEquals(2, actualToListRespostaDTOResult.size());
        ObjetivoResponseDTO getResult = actualToListRespostaDTOResult.get(0);
        assertEquals("42", getResult.getObjetivo());
        ObjetivoResponseDTO getResult2 = actualToListRespostaDTOResult.get(1);
        assertEquals("Objetivo", getResult2.getObjetivo());
        assertEquals(1L, getResult2.getId().longValue());
        assertEquals(2L, getResult.getId().longValue());
    }
}
