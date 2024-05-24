package sync.spctrum.apispring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sync.spctrum.apispring.api.configuration.security.AutenticacaoProvider;
import sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.HistoricoPeso.Repository.HistoricoPesoRepository;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.historicoPeso.HistoricoPesoService;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO;
import sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoResponseDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.usuario.UsuarioService;
import sync.spctrum.apispring.service.usuario.autenticacao.AutenticacaoService;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

@ContextConfiguration(classes = {HistoricoPesoController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class HistoricoPesoControllerTest {
    @Autowired
    private HistoricoPesoController historicoPesoController;

    @MockBean
    private HistoricoPesoService historicoPesoService;

    /**
     * Method under test:
     * {@link HistoricoPesoController#cadastrarPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    void testCadastrarPeso() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Senha");

        HistoricoPeso historicoPeso = new HistoricoPeso();
        historicoPeso.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPeso.setId(1L);
        historicoPeso.setPeso(10.0d);
        historicoPeso.setPesoMeta(10.0d);
        historicoPeso.setUsuario(usuario2);
        HistoricoPesoRepository historicoPesoRepository = mock(HistoricoPesoRepository.class);
        when(historicoPesoRepository.existsByDataPostagemAndId(Mockito.<LocalDate>any(), Mockito.<Long>any()))
                .thenReturn(false);
        when(historicoPesoRepository.save(Mockito.<HistoricoPeso>any())).thenReturn(historicoPeso);
        Usuario usuario3 = mock(Usuario.class);
        doNothing().when(usuario3).setPeso(Mockito.<Double>any());
        Optional<Usuario> ofResult = Optional.of(usuario3);
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);
        UsuarioService usuarioService = new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt,
                authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService()));

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
        usuario4.setObjetivo(new Objetivo());
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

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(1L);
        objetivo4.setObjetivo("Objetivo");
        objetivo4.setUsuario(usuario5);

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
        usuario6.setObjetivo(objetivo4);
        usuario6.setPeso(10.0d);
        usuario6.setPontuacao(1);
        usuario6.setReceitas(new ArrayList<>());
        usuario6.setSenha("Senha");
        UsuarioRepository usuarioRepository3 = mock(UsuarioRepository.class);
        when(usuarioRepository3.save(Mockito.<Usuario>any())).thenReturn(usuario6);
        HistoricoPesoController historicoPesoController = new HistoricoPesoController(
                new HistoricoPesoService(historicoPesoRepository, usuarioService, usuarioRepository3));

        // Act
        ResponseEntity<HistoricoPesoResponseDTO> actualCadastrarPesoResult = historicoPesoController
                .cadastrarPeso(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d), 1L);

        // Assert
        verify(usuarioRepository).findById(eq(1L));
        verify(historicoPesoRepository).save(isA(HistoricoPeso.class));
        verify(usuarioRepository3).save(isA(Usuario.class));
        verify(historicoPesoRepository).existsByDataPostagemAndId(isA(LocalDate.class), eq(1L));
        verify(usuario3).setPeso(eq(10.0d));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HistoricoPesoResponseDTO body = actualCadastrarPesoResult.getBody();
        UsuarioResponseDTO usuario7 = body.getUsuario();
        assertEquals("1969-12-31", simpleDateFormat.format(usuario7.getDataNascimento()));
        assertEquals("1970-01-01", body.getDataPostagem().toString());
        assertEquals("Genero", usuario7.getGenero());
        assertEquals("Img", usuario7.getImg());
        assertEquals("Meta", usuario7.getMeta());
        assertEquals("Nivel Condicao", usuario7.getNivelCondicao());
        assertEquals("Nome", usuario7.getNome());
        ObjetivoResponseDTO objetivo5 = usuario7.getObjetivo();
        assertEquals("Objetivo", objetivo5.getObjetivo());
        assertEquals("jane.doe@example.org", usuario7.getEmail());
        assertEquals(1, usuario7.getAltura().intValue());
        assertEquals(1, usuario7.getPontuacao());
        assertEquals(10.0d, body.getPeso().doubleValue());
        assertEquals(10.0d, body.getPesoMeta().doubleValue());
        assertEquals(10.0d, usuario7.getPeso().doubleValue());
        assertEquals(1L, body.getId().longValue());
        assertEquals(1L, objetivo5.getId().longValue());
        assertEquals(1L, usuario7.getId().longValue());
        assertEquals(201, actualCadastrarPesoResult.getStatusCodeValue());
        assertTrue(actualCadastrarPesoResult.hasBody());
        assertTrue(actualCadastrarPesoResult.getHeaders().isEmpty());
        assertTrue(usuario7.getContaAtiva());
    }

    /**
     * Method under test:
     * {@link HistoricoPesoController#cadastrarPeso(HistoricoPesoCreateDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCadastrarPeso2() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDate` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: sync.spctrum.apispring.service.historicoPeso.dto.peso.HistoricoPesoCreateDTO["dataPostagem"])
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:77)
        //       at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1308)
        //       at com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer.serialize(UnsupportedTypeSerializer.java:35)
        //       at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:732)
        //       at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:772)
        //       at com.fasterxml.jackson.databind.ser.BeanSerializer.serialize(BeanSerializer.java:178)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:479)
        //       at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:318)
        //       at com.fasterxml.jackson.databind.ObjectMapper._writeValueAndClose(ObjectMapper.java:4719)
        //       at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:3964)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/pesos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new HistoricoPesoCreateDTO(LocalDate.of(1970, 1, 1), 10.0d, 10.0d)));

        // Act
        MockMvcBuilders.standaloneSetup(historicoPesoController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link HistoricoPesoController#procurarPorId(Long)}
     */
    @Test
    void testProcurarPorId() throws Exception {
        // Arrange
        when(historicoPesoService.getId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pesos/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(historicoPesoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link HistoricoPesoController#procurarPorId(Long)}
     */
    @Test
    void testProcurarPorId2() throws Exception {
        // Arrange
        HistoricoPesoResponseDTO historicoPesoResponseDTO = new HistoricoPesoResponseDTO();
        historicoPesoResponseDTO.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPesoResponseDTO.setId(1L);
        historicoPesoResponseDTO.setPeso(10.0d);
        historicoPesoResponseDTO.setPesoMeta(10.0d);
        historicoPesoResponseDTO.setUsuario(new UsuarioResponseDTO());

        ArrayList<HistoricoPesoResponseDTO> historicoPesoResponseDTOList = new ArrayList<>();
        historicoPesoResponseDTOList.add(historicoPesoResponseDTO);
        when(historicoPesoService.getId(Mockito.<Long>any())).thenReturn(historicoPesoResponseDTOList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pesos/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(historicoPesoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><dataPostagem>1970</dataPostagem><dataPostagem>1</dataPostagem><dataPostagem>1"
                                        + "</dataPostagem><peso>10.0</peso><pesoMeta>10.0</pesoMeta><usuario><id/><nome/><email/><img/><dataNascimento"
                                        + "/><genero/><peso/><altura/><nivelCondicao/><meta/><contaAtiva/><pontuacao>0</pontuacao><objetivo/><"
                                        + "/usuario></item></List>"));
    }

    /**
     * Method under test: {@link HistoricoPesoController#procurarPorIdLimit1(Long)}
     */
    @Test
    void testProcurarPorIdLimit1() throws Exception {
        // Arrange
        HistoricoPesoResponseDTO historicoPesoResponseDTO = new HistoricoPesoResponseDTO();
        historicoPesoResponseDTO.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPesoResponseDTO.setId(1L);
        historicoPesoResponseDTO.setPeso(10.0d);
        historicoPesoResponseDTO.setPesoMeta(10.0d);
        historicoPesoResponseDTO.setUsuario(new UsuarioResponseDTO());
        when(historicoPesoService.getUserId(Mockito.<Long>any())).thenReturn(historicoPesoResponseDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pesos/ultima-insercao/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(historicoPesoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<HistoricoPesoResponseDTO><id>1</id><dataPostagem>1970</dataPostagem><dataPostagem>1</dataPostagem>"
                                        + "<dataPostagem>1</dataPostagem><peso>10.0</peso><pesoMeta>10.0</pesoMeta><usuario><id/><nome/><email/"
                                        + "><img/><dataNascimento/><genero/><peso/><altura/><nivelCondicao/><meta/><contaAtiva/><pontuacao>0<"
                                        + "/pontuacao><objetivo/></usuario></HistoricoPesoResponseDTO>"));
    }

    /**
     * Method under test: {@link HistoricoPesoController#procurarPorIdLimit3(Long)}
     */
    @Test
    void testProcurarPorIdLimit3() throws Exception {
        // Arrange
        when(historicoPesoService.getGrafics(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pesos/historico-grafico/{id}", 1L);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(historicoPesoController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link HistoricoPesoController#procurarPorIdLimit3(Long)}
     */
    @Test
    void testProcurarPorIdLimit32() throws Exception {
        // Arrange
        HistoricoPesoResponseDTO historicoPesoResponseDTO = new HistoricoPesoResponseDTO();
        historicoPesoResponseDTO.setDataPostagem(LocalDate.of(1970, 1, 1));
        historicoPesoResponseDTO.setId(1L);
        historicoPesoResponseDTO.setPeso(10.0d);
        historicoPesoResponseDTO.setPesoMeta(10.0d);
        historicoPesoResponseDTO.setUsuario(new UsuarioResponseDTO());

        ArrayList<HistoricoPesoResponseDTO> historicoPesoResponseDTOList = new ArrayList<>();
        historicoPesoResponseDTOList.add(historicoPesoResponseDTO);
        when(historicoPesoService.getGrafics(Mockito.<Long>any())).thenReturn(historicoPesoResponseDTOList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pesos/historico-grafico/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(historicoPesoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><dataPostagem>1970</dataPostagem><dataPostagem>1</dataPostagem><dataPostagem>1"
                                        + "</dataPostagem><peso>10.0</peso><pesoMeta>10.0</pesoMeta><usuario><id/><nome/><email/><img/><dataNascimento"
                                        + "/><genero/><peso/><altura/><nivelCondicao/><meta/><contaAtiva/><pontuacao>0</pontuacao><objetivo/><"
                                        + "/usuario></item></List>"));
    }
}
