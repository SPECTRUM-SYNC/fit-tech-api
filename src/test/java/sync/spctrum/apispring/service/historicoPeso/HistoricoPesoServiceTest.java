package sync.spctrum.apispring.service.historicoPeso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.HistoricoPeso.Repository.HistoricoPesoRepository;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceDuplicate;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

@ContextConfiguration(classes = {HistoricoPesoService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class HistoricoPesoServiceTest {
    @MockBean
    private HistoricoPesoRepository historicoPesoRepository;

    @Autowired
    private HistoricoPesoService historicoPesoService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioService usuarioService;

    /**
     * Method under test:
     * {@link HistoricoPesoService#postPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    void testPostPeso() {
        // Arrange
        when(historicoPesoRepository.existsByDataPostagemAndId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenReturn(true);

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
        usuario2.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

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
        usuario3.setObjetivo(objetivo2);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");
        when(usuarioService.procurarUsuarioPorId(Mockito.<Long>any())).thenReturn(usuario3);

        // Act and Assert
        assertThrows(ResourceDuplicate.class,
                () -> historicoPesoService.postPeso(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d), 1L));
        verify(historicoPesoRepository).existsByDataPostagemAndId(isA(LocalDate.class), eq(1L));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
    }

    /**
     * Method under test:
     * {@link HistoricoPesoService#postPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    void testPostPeso2() {
        // Arrange
        when(usuarioService.procurarUsuarioPorId(Mockito.<Long>any()))
                .thenThrow(new ResourceDuplicate("Limite de uma atualização diária de peso."));

        // Act and Assert
        assertThrows(ResourceDuplicate.class,
                () -> historicoPesoService.postPeso(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d), 1L));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
    }

    /**
     * Method under test:
     * {@link HistoricoPesoService#postPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    void testPostPeso3() {
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

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);
        when(historicoPesoRepository.save(Mockito.<HistoricoPeso>any())).thenReturn(historicoPeso);
        when(historicoPesoRepository.existsByDataPostagemAndId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenReturn(false);

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

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(usuario3);

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
        usuario4.setObjetivo(objetivo3);
        usuario4.setPeso(10.0d);
        usuario4.setPontuacao(1);
        usuario4.setSenha("Senha");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario4);

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
        usuario5.setObjetivo(objetivo4);
        usuario5.setPeso(10.0d);
        usuario5.setPontuacao(1);
        usuario5.setSenha("Senha");
        when(usuarioService.procurarUsuarioPorId(Mockito.<Long>any())).thenReturn(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.preUpdate();
        usuario6.setAltura(1);
        usuario6.setContaAtiva(true);
        usuario6.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario6.setEmail("jane.doe@example.org");
        usuario6.setGenero("Genero");
        usuario6.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario6.setId(1L);
        usuario6.setImg("Img");
        usuario6.setMeta("Meta");
        usuario6.setNivelCondicao("Nivel Condicao");
        usuario6.setNome("Nome");
        usuario6.setObjetivo(new Objetivo());
        usuario6.setPeso(10.0d);
        usuario6.setPontuacao(1);
        usuario6.setSenha("Senha");

        Objetivo objetivo5 = new Objetivo();
        objetivo5.setId(1L);
        objetivo5.setObjetivo("Objetivo");
        objetivo5.setUsuario(usuario6);

        Usuario usuario7 = new Usuario();
        usuario7.preUpdate();
        usuario7.setAltura(1);
        usuario7.setContaAtiva(true);
        usuario7.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario7.setEmail("jane.doe@example.org");
        usuario7.setGenero("Genero");
        usuario7.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario7.setId(1L);
        usuario7.setImg("Img");
        usuario7.setMeta("Meta");
        usuario7.setNivelCondicao("Nivel Condicao");
        usuario7.setNome("Nome");
        usuario7.setObjetivo(objetivo5);
        usuario7.setPeso(10.0d);
        usuario7.setPontuacao(1);
        usuario7.setSenha("Senha");

        Objetivo objetivo6 = new Objetivo();
        objetivo6.setId(1L);
        objetivo6.setObjetivo("Objetivo");
        objetivo6.setUsuario(usuario7);

        Usuario usuario8 = new Usuario();
        usuario8.preUpdate();
        usuario8.setAltura(1);
        usuario8.setContaAtiva(true);
        usuario8.setDataNascimento(
                java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario8.setEmail("jane.doe@example.org");
        usuario8.setGenero("Genero");
        usuario8.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario8.setId(1L);
        usuario8.setImg("Img");
        usuario8.setMeta("Meta");
        usuario8.setNivelCondicao("Nivel Condicao");
        usuario8.setNome("Nome");
        usuario8.setObjetivo(objetivo6);
        usuario8.setPeso(10.0d);
        usuario8.setPontuacao(1);
        usuario8.setSenha("Senha");
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario8);

        // Act
        HistoricoPesoResponseDTO actualPostPesoResult = historicoPesoService
                .postPeso(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d), 1L);

        // Assert
        verify(historicoPesoRepository).save(isA(HistoricoPeso.class));
        verify(usuarioRepository).save(isA(Usuario.class));
        verify(historicoPesoRepository).existsByDataPostagemAndId(isA(LocalDate.class), eq(1L));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario9 = actualPostPesoResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario9.getDataNascimento()));
        assertEquals("1970-01-01", actualPostPesoResult.getDataPostagem().toString());
        assertEquals("Genero", usuario9.getGenero());
        assertEquals("Img", usuario9.getImg());
        assertEquals("Meta", usuario9.getMeta());
        assertEquals("Nivel Condicao", usuario9.getNivelCondicao());
        assertEquals("Nome", usuario9.getNome());
        ObjetivoResponseDTO objetivo7 = usuario9.getObjetivo();
        assertEquals("Objetivo", objetivo7.getObjetivo());
        assertEquals("jane.doe@example.org", usuario9.getEmail());
        assertEquals(1, usuario9.getAltura().intValue());
        assertEquals(1, usuario9.getPontuacao());
        assertEquals(10.0d, actualPostPesoResult.getPeso().doubleValue());
        assertEquals(10.0d, actualPostPesoResult.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario9.getPeso().doubleValue());
        assertEquals(1L, actualPostPesoResult.getId().longValue());
        assertEquals(1L, objetivo7.getId().longValue());
        assertEquals(1L, usuario9.getId().longValue());
        assertTrue(usuario9.getContaAtiva());
    }

    /**
     * Method under test:
     * {@link HistoricoPesoService#postPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    void testPostPeso4() {
        // Arrange
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

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);
        when(historicoPesoRepository.save(Mockito.<HistoricoPeso>any())).thenReturn(historicoPeso);
        when(historicoPesoRepository.existsByDataPostagemAndId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenReturn(false);

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
        usuario3.setObjetivo(new Objetivo());
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(1L);
        objetivo3.setObjetivo("Objetivo");
        objetivo3.setUsuario(usuario3);

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
        usuario4.setObjetivo(objetivo3);
        usuario4.setPeso(10.0d);
        usuario4.setPontuacao(1);
        usuario4.setSenha("Senha");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(1);
        usuario5.setContaAtiva(true);
        usuario5.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("jane.doe@example.org");
        usuario5.setGenero("Genero");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(1L);
        usuario5.setImg("Img");
        usuario5.setMeta("Meta");
        usuario5.setNivelCondicao("Nivel Condicao");
        usuario5.setNome("Nome");
        usuario5.setObjetivo(objetivo4);
        usuario5.setPeso(10.0d);
        usuario5.setPontuacao(1);
        usuario5.setSenha("Senha");
        when(usuarioService.procurarUsuarioPorId(Mockito.<Long>any())).thenReturn(usuario5);
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenThrow(new ResourceDuplicate("Obj"));

        // Act and Assert
        assertThrows(ResourceDuplicate.class,
                () -> historicoPesoService.postPeso(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d), 1L));
        verify(historicoPesoRepository).save(isA(HistoricoPeso.class));
        verify(usuarioRepository).save(isA(Usuario.class));
        verify(historicoPesoRepository).existsByDataPostagemAndId(isA(LocalDate.class), eq(1L));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
    }

    /**
     * Method under test: {@link HistoricoPesoService#getId(Long)}
     */
    @Test
    void testGetId() {
        // Arrange
        when(historicoPesoRepository.findAllByUsuario_Id(Mockito.<Long>any())).thenReturn(new ArrayList<>());

        // Act
        List<HistoricoPesoResponseDTO> actualId = historicoPesoService.getId(1L);

        // Assert
        verify(historicoPesoRepository).findAllByUsuario_Id(eq(1L));
        assertTrue(actualId.isEmpty());
    }

    /**
     * Method under test: {@link HistoricoPesoService#getId(Long)}
     */
    @Test
    void testGetId2() {
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

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);

        ArrayList<HistoricoPeso> historicoPesoList = new ArrayList<>();
        historicoPesoList.add(historicoPeso);
        when(historicoPesoRepository.findAllByUsuario_Id(Mockito.<Long>any())).thenReturn(historicoPesoList);

        // Act
        List<HistoricoPesoResponseDTO> actualId = historicoPesoService.getId(1L);

        // Assert
        verify(historicoPesoRepository).findAllByUsuario_Id(eq(1L));
        assertEquals(1, actualId.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualId.get(0);
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
     * Method under test: {@link HistoricoPesoService#getId(Long)}
     */
    @Test
    void testGetId3() {
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

        HistoricoPeso historicoPeso2 = new HistoricoPeso();
        historicoPeso2.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso2.setId(2L);
        historicoPeso2.setPeso(0.5d);
        historicoPeso2.setPesoMeta(0.5d);
        historicoPeso2.setUsuario(usuario4);

        ArrayList<HistoricoPeso> historicoPesoList = new ArrayList<>();
        historicoPesoList.add(historicoPeso2);
        historicoPesoList.add(historicoPeso);
        when(historicoPesoRepository.findAllByUsuario_Id(Mockito.<Long>any())).thenReturn(historicoPesoList);

        // Act
        List<HistoricoPesoResponseDTO> actualId = historicoPesoService.getId(1L);

        // Assert
        verify(historicoPesoRepository).findAllByUsuario_Id(eq(1L));
        assertEquals(2, actualId.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualId.get(0);
        UsuarioResponseDTO usuario5 = getResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario5.getDataNascimento()));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult2 = actualId.get(1);
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
     * Method under test: {@link HistoricoPesoService#getId(Long)}
     */
    @Test
    void testGetId4() {
        // Arrange
        when(historicoPesoRepository.findAllByUsuario_Id(Mockito.<Long>any())).thenThrow(new ResourceDuplicate("Obj"));

        // Act and Assert
        assertThrows(ResourceDuplicate.class, () -> historicoPesoService.getId(1L));
        verify(historicoPesoRepository).findAllByUsuario_Id(eq(1L));
    }

    /**
     * Method under test: {@link HistoricoPesoService#getGrafics(Long)}
     */
    @Test
    void testGetGrafics() {
        // Arrange
        when(historicoPesoRepository.findAllTop3ByUserId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

        // Act
        List<HistoricoPesoResponseDTO> actualGrafics = historicoPesoService.getGrafics(1L);

        // Assert
        verify(historicoPesoRepository).findAllTop3ByUserId(eq(1L));
        assertTrue(actualGrafics.isEmpty());
    }

    /**
     * Method under test: {@link HistoricoPesoService#getGrafics(Long)}
     */
    @Test
    void testGetGrafics2() {
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

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);

        ArrayList<HistoricoPeso> historicoPesoList = new ArrayList<>();
        historicoPesoList.add(historicoPeso);
        when(historicoPesoRepository.findAllTop3ByUserId(Mockito.<Long>any())).thenReturn(historicoPesoList);

        // Act
        List<HistoricoPesoResponseDTO> actualGrafics = historicoPesoService.getGrafics(1L);

        // Assert
        verify(historicoPesoRepository).findAllTop3ByUserId(eq(1L));
        assertEquals(1, actualGrafics.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualGrafics.get(0);
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
     * Method under test: {@link HistoricoPesoService#getGrafics(Long)}
     */
    @Test
    void testGetGrafics3() {
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

        HistoricoPeso historicoPeso2 = new HistoricoPeso();
        historicoPeso2.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso2.setId(2L);
        historicoPeso2.setPeso(0.5d);
        historicoPeso2.setPesoMeta(0.5d);
        historicoPeso2.setUsuario(usuario4);

        ArrayList<HistoricoPeso> historicoPesoList = new ArrayList<>();
        historicoPesoList.add(historicoPeso2);
        historicoPesoList.add(historicoPeso);
        when(historicoPesoRepository.findAllTop3ByUserId(Mockito.<Long>any())).thenReturn(historicoPesoList);

        // Act
        List<HistoricoPesoResponseDTO> actualGrafics = historicoPesoService.getGrafics(1L);

        // Assert
        verify(historicoPesoRepository).findAllTop3ByUserId(eq(1L));
        assertEquals(2, actualGrafics.size());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult = actualGrafics.get(0);
        UsuarioResponseDTO usuario5 = getResult.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario5.getDataNascimento()));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO getResult2 = actualGrafics.get(1);
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
     * Method under test: {@link HistoricoPesoService#getGrafics(Long)}
     */
    @Test
    void testGetGrafics4() {
        // Arrange
        when(historicoPesoRepository.findAllTop3ByUserId(Mockito.<Long>any())).thenThrow(new ResourceDuplicate("Obj"));

        // Act and Assert
        assertThrows(ResourceDuplicate.class, () -> historicoPesoService.getGrafics(1L));
        verify(historicoPesoRepository).findAllTop3ByUserId(eq(1L));
    }

    /**
     * Method under test: {@link HistoricoPesoService#getUserId(Long)}
     */
    @Test
    void testGetUserId() {
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

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);
        Optional<HistoricoPeso> ofResult = Optional.of(historicoPeso);
        when(historicoPesoRepository.findAllTop1ByUserId(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        HistoricoPesoResponseDTO actualUserId = historicoPesoService.getUserId(1L);

        // Assert
        verify(historicoPesoRepository).findAllTop1ByUserId(eq(1L));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        UsuarioResponseDTO usuario3 = actualUserId.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario3.getDataNascimento()));
        assertEquals("1970-01-01", actualUserId.getDataPostagem().toString());
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
        assertEquals(10.0d, actualUserId.getPeso().doubleValue());
        assertEquals(10.0d, actualUserId.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario3.getPeso().doubleValue());
        assertEquals(1L, actualUserId.getId().longValue());
        assertEquals(1L, objetivo2.getId().longValue());
        assertEquals(1L, usuario3.getId().longValue());
        assertTrue(usuario3.getContaAtiva());
    }

    /**
     * Method under test: {@link HistoricoPesoService#getUserId(Long)}
     */
    @Test
    void testGetUserId2() {
        // Arrange
        Optional<HistoricoPeso> emptyResult = Optional.empty();
        when(historicoPesoRepository.findAllTop1ByUserId(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> historicoPesoService.getUserId(1L));
        verify(historicoPesoRepository).findAllTop1ByUserId(eq(1L));
    }

    /**
     * Method under test: {@link HistoricoPesoService#getUserId(Long)}
     */
    @Test
    void testGetUserId3() {
        // Arrange
        when(historicoPesoRepository.findAllTop1ByUserId(Mockito.<Long>any()))
                .thenThrow(new ResourceDuplicate("Usuário não encontrado"));

        // Act and Assert
        assertThrows(ResourceDuplicate.class, () -> historicoPesoService.getUserId(1L));
        verify(historicoPesoRepository).findAllTop1ByUserId(eq(1L));
    }
}
