package sync.spctrum.apispring.service.treino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Treino.Repository.TreinoRepository;
import sync.spctrum.apispring.domain.Treino.Treino;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.treino.dto.treino.TreinoCountDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;

@ContextConfiguration(classes = {TreinoService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class TreinoServiceTest {
    @MockBean
    private TreinoRepository treinoRepository;

    @Autowired
    private TreinoService treinoService;

    @MockBean
    private UsuarioService usuarioService;

    /**
     * Method under test: {@link TreinoService#findAll()}
     */
    @Test
    void testFindAll() {
        // Arrange
        ArrayList<Treino> treinoList = new ArrayList<>();
        when(treinoRepository.findAll()).thenReturn(treinoList);

        // Act
        List<Treino> actualFindAllResult = treinoService.findAll();

        // Assert
        verify(treinoRepository).findAll();
        assertTrue(actualFindAllResult.isEmpty());
        assertSame(treinoList, actualFindAllResult);
    }

    /**
     * Method under test: {@link TreinoService#findAll()}
     */
    @Test
    void testFindAll2() {
        // Arrange
        when(treinoRepository.findAll()).thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.findAll());
        verify(treinoRepository).findAll();
    }

    /**
     * Method under test: {@link TreinoService#findAllByUsuarioId(Long)}
     */
    @Test
    void testFindAllByUsuarioId() {
        // Arrange
        ArrayList<Treino> treinoList = new ArrayList<>();
        when(treinoRepository.findAllByUsuario_Id(Mockito.<Long>any())).thenReturn(treinoList);

        // Act
        List<Treino> actualFindAllByUsuarioIdResult = treinoService.findAllByUsuarioId(1L);

        // Assert
        verify(treinoRepository).findAllByUsuario_Id(eq(1L));
        assertTrue(actualFindAllByUsuarioIdResult.isEmpty());
        assertSame(treinoList, actualFindAllByUsuarioIdResult);
    }

    /**
     * Method under test: {@link TreinoService#findAllByUsuarioId(Long)}
     */
    @Test
    void testFindAllByUsuarioId2() {
        // Arrange
        when(treinoRepository.findAllByUsuario_Id(Mockito.<Long>any()))
                .thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.findAllByUsuarioId(1L));
        verify(treinoRepository).findAllByUsuario_Id(eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#findByDataTreinoAndUsuarioId(Long)}
     */
    @Test
    void testFindByDataTreinoAndUsuarioId() {
        // Arrange
        ArrayList<Treino> treinoList = new ArrayList<>();
        when(treinoRepository.findByDataTreinoAndUsuarioId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenReturn(treinoList);

        // Act
        List<Treino> actualFindByDataTreinoAndUsuarioIdResult = treinoService.findByDataTreinoAndUsuarioId(1L);

        // Assert
        verify(treinoRepository).findByDataTreinoAndUsuarioId(isA(LocalDate.class), eq(1L));
        assertTrue(actualFindByDataTreinoAndUsuarioIdResult.isEmpty());
        assertSame(treinoList, actualFindByDataTreinoAndUsuarioIdResult);
    }

    /**
     * Method under test: {@link TreinoService#findByDataTreinoAndUsuarioId(Long)}
     */
    @Test
    void testFindByDataTreinoAndUsuarioId2() {
        // Arrange
        when(treinoRepository.findByDataTreinoAndUsuarioId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.findByDataTreinoAndUsuarioId(1L));
        verify(treinoRepository).findByDataTreinoAndUsuarioId(isA(LocalDate.class), eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#findByTreinoAndUser(Long)}
     */
    @Test
    void testFindByTreinoAndUser() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        Optional<Treino> ofResult = Optional.of(treino);
        when(treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(Mockito.<LocalDate>any(), Mockito.<Long>any(),
                Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Boolean actualFindByTreinoAndUserResult = treinoService.findByTreinoAndUser(1L);

        // Assert
        verify(treinoRepository).findByDataTreinoAndUsuarioIdAndDescricao(isA(LocalDate.class), eq(1L), eq("Diario"));
        assertTrue(actualFindByTreinoAndUserResult);
    }

    /**
     * Method under test: {@link TreinoService#getTreinosPorDiaDaSemana(Long)}
     */
    @Test
    void testGetTreinosPorDiaDaSemana() {
        // Arrange
        when(treinoRepository.countTreinosByDiaDaSemana(Mockito.<Long>any())).thenReturn(new ArrayList<>());

        // Act
        List<TreinoCountDTO> actualTreinosPorDiaDaSemana = treinoService.getTreinosPorDiaDaSemana(1L);

        // Assert
        verify(treinoRepository).countTreinosByDiaDaSemana(eq(1L));
        assertEquals(7, actualTreinosPorDiaDaSemana.size());
        TreinoCountDTO getResult = actualTreinosPorDiaDaSemana.get(6);
        assertEquals("dom", getResult.getDiaDaSemana());
        TreinoCountDTO getResult2 = actualTreinosPorDiaDaSemana.get(2);
        assertEquals("qua", getResult2.getDiaDaSemana());
        TreinoCountDTO getResult3 = actualTreinosPorDiaDaSemana.get(3);
        assertEquals("qui", getResult3.getDiaDaSemana());
        TreinoCountDTO getResult4 = actualTreinosPorDiaDaSemana.get(5);
        assertEquals("sáb", getResult4.getDiaDaSemana());
        TreinoCountDTO getResult5 = actualTreinosPorDiaDaSemana.get(0);
        assertEquals("seg", getResult5.getDiaDaSemana());
        TreinoCountDTO getResult6 = actualTreinosPorDiaDaSemana.get(4);
        assertEquals("sex", getResult6.getDiaDaSemana());
        TreinoCountDTO getResult7 = actualTreinosPorDiaDaSemana.get(1);
        assertEquals("ter", getResult7.getDiaDaSemana());
        assertEquals(0L, getResult5.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult7.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult2.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult3.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult6.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult4.getQuantidadeTreinos().longValue());
        assertEquals(0L, getResult.getQuantidadeTreinos().longValue());
    }

    /**
     * Method under test: {@link TreinoService#getTreinosPorDiaDaSemana(Long)}
     */
    @Test
    void testGetTreinosPorDiaDaSemana2() {
        // Arrange
        when(treinoRepository.countTreinosByDiaDaSemana(Mockito.<Long>any()))
                .thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.getTreinosPorDiaDaSemana(1L));
        verify(treinoRepository).countTreinosByDiaDaSemana(eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#existsByDataTreinoAndId(Long)}
     */
    @Test
    void testExistsByDataTreinoAndId() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        Optional<Treino> ofResult = Optional.of(treino);
        when(treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(Mockito.<LocalDate>any(), Mockito.<Long>any(),
                Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Treino actualExistsByDataTreinoAndIdResult = treinoService.existsByDataTreinoAndId(1L);

        // Assert
        verify(treinoRepository).findByDataTreinoAndUsuarioIdAndDescricao(isA(LocalDate.class), eq(1L), eq("Diario"));
        assertSame(treino, actualExistsByDataTreinoAndIdResult);
    }

    /**
     * Method under test: {@link TreinoService#existsByDataTreinoAndId(Long)}
     */
    @Test
    void testExistsByDataTreinoAndId2() {
        // Arrange
        Optional<Treino> emptyResult = Optional.empty();
        when(treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(Mockito.<LocalDate>any(), Mockito.<Long>any(),
                Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.existsByDataTreinoAndId(1L));
        verify(treinoRepository).findByDataTreinoAndUsuarioIdAndDescricao(isA(LocalDate.class), eq(1L), eq("Diario"));
    }

    /**
     * Method under test: {@link TreinoService#findById(Long)}
     */
    @Test
    void testFindById() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        Optional<Treino> ofResult = Optional.of(treino);
        when(treinoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Treino actualFindByIdResult = treinoService.findById(1L);

        // Assert
        verify(treinoRepository).findById(eq(1L));
        assertSame(treino, actualFindByIdResult);
    }

    /**
     * Method under test: {@link TreinoService#findById(Long)}
     */
    @Test
    void testFindById2() {
        // Arrange
        Optional<Treino> emptyResult = Optional.empty();
        when(treinoRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.findById(1L));
        verify(treinoRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#findById(Long)}
     */
    @Test
    void testFindById3() {
        // Arrange
        when(treinoRepository.findById(Mockito.<Long>any())).thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.findById(1L));
        verify(treinoRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#save(Treino, Long)}
     */
    @Test
    void testSave() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        when(treinoRepository.save(Mockito.<Treino>any())).thenReturn(treino);

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

        Usuario usuario6 = new Usuario();
        usuario6.preUpdate();
        usuario6.setAltura(1);
        usuario6.setContaAtiva(true);
        usuario6.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
        usuario7.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

        Treino treino2 = new Treino();
        treino2.setDataTreino(LocalDate.of(1970, 1, 1));
        treino2.setDescricao("Descricao");
        treino2.setId(1L);
        treino2.setStatus("Status");
        treino2.setTipoTreino("Tipo Treino");
        treino2.setUsuario(usuario7);

        // Act
        Treino actualSaveResult = treinoService.save(treino2, 1L);

        // Assert
        verify(treinoRepository).save(isA(Treino.class));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
        assertNull(treino2.getId());
        assertEquals(1, treino2.getUsuario().getAltura().intValue());
        assertSame(treino, actualSaveResult);
    }

    /**
     * Method under test: {@link TreinoService#save(Treino, Long)}
     */
    @Test
    void testSave2() {
        // Arrange
        when(usuarioService.procurarUsuarioPorId(Mockito.<Long>any()))
                .thenThrow(new ResourceNotFound("Not all who wander are lost"));

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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.save(treino, 1L));
        verify(usuarioService).procurarUsuarioPorId(eq(1L));
    }

    /**
     * Method under test: {@link TreinoService#putStatusTreino(Long)}
     */
    @Test
    void testPutStatusTreino() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        Optional<Treino> ofResult = Optional.of(treino);

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(new Usuario());

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

        Treino treino2 = new Treino();
        treino2.setDataTreino(LocalDate.of(1970, 1, 1));
        treino2.setDescricao("Descricao");
        treino2.setId(1L);
        treino2.setStatus("Status");
        treino2.setTipoTreino("Tipo Treino");
        treino2.setUsuario(usuario4);
        when(treinoRepository.save(Mockito.<Treino>any())).thenReturn(treino2);
        when(treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(Mockito.<LocalDate>any(), Mockito.<Long>any(),
                Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Treino actualPutStatusTreinoResult = treinoService.putStatusTreino(1L);

        // Assert
        verify(treinoRepository).save(isA(Treino.class));
        verify(treinoRepository).findByDataTreinoAndUsuarioIdAndDescricao(isA(LocalDate.class), eq(1L), eq("Diario"));
        assertSame(treino2, actualPutStatusTreinoResult);
    }

    /**
     * Method under test: {@link TreinoService#putStatusTreino(Long)}
     */
    @Test
    void testPutStatusTreino2() {
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

        Treino treino = new Treino();
        treino.setDataTreino(LocalDate.of(1970, 1, 1));
        treino.setDescricao("Descricao");
        treino.setId(1L);
        treino.setStatus("Status");
        treino.setTipoTreino("Tipo Treino");
        treino.setUsuario(usuario2);
        Optional<Treino> ofResult = Optional.of(treino);
        when(treinoRepository.save(Mockito.<Treino>any())).thenThrow(new ResourceNotFound("Not all who wander are lost"));
        when(treinoRepository.findByDataTreinoAndUsuarioIdAndDescricao(Mockito.<LocalDate>any(), Mockito.<Long>any(),
                Mockito.<String>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> treinoService.putStatusTreino(1L));
        verify(treinoRepository).save(isA(Treino.class));
        verify(treinoRepository).findByDataTreinoAndUsuarioIdAndDescricao(isA(LocalDate.class), eq(1L), eq("Diario"));
    }
}
