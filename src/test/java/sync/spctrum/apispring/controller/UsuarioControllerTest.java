package sync.spctrum.apispring.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.apache.catalina.User;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.apache.catalina.users.MemoryUserDatabase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.email.dto.EmailDTO;
import sync.spctrum.apispring.service.historicoPeso.HistoricoPesoService;
import sync.spctrum.apispring.service.usuario.UsuarioService;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginGoogleDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioUpdateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioUpdatePerfilDTO;

@ContextConfiguration(classes = {UsuarioController.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class UsuarioControllerTest {
    @MockBean
    private EmailService emailService;

    @MockBean
    private HistoricoPesoService historicoPesoService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioService usuarioService;

    /**
     * Method under test: {@link UsuarioController#adicionarUsuarioRanking(Usuario)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAdicionarUsuarioRanking() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: sync.spctrum.apispring.domain.Usuario.Usuario["horaSenhaAtualizacao"])
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
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");
        String content = (new ObjectMapper()).writeValueAsString(usuario3);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/usuarios/adicionar-top-ranking")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(usuarioController).build().perform(requestBuilder);
    }

    /**
     * Method under test:
     * {@link UsuarioController#atualizarImagem(Long, MultipartFile)}
     */
    @Test
    void testAtualizarImagem() throws Exception {
        // Arrange
        DataInputStream contentStream = mock(DataInputStream.class);
        when(contentStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
        doNothing().when(contentStream).close();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch("/usuarios/imagem/{id}", "Uri Variables", "Uri Variables")
                .param("imageFile", String.valueOf(new MockMultipartFile("Name", contentStream)));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UsuarioController#buscarUsuarioRanking(Usuario)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBuscarUsuarioRanking() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
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

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Objetivo");

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

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");

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
        Objetivo objetivo3 = new Objetivo();
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        ArrayList<Receita> receitas = new ArrayList<>();
        usuario3.setReceitas(receitas);
        usuario3.setSenha("Senha");
        objetivo2.setUsuario(usuario3);
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        ArrayList<Receita> receitas2 = new ArrayList<>();
        usuario2.setReceitas(receitas2);
        usuario2.setSenha("Senha");
        objetivo.setUsuario(usuario2);
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        ArrayList<Receita> receitas3 = new ArrayList<>();
        usuario.setReceitas(receitas3);
        usuario.setSenha("Senha");
        Object[] uriVariables = new Object[]{usuario};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/buscar/{elemento}",
                uriVariables);
        Object[] controllers = new Object[]{usuarioController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UsuarioController#deletarUsuario(Long)}
     */
    @Test
    void testDeletarUsuario() throws Exception {
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
        Optional<Usuario> ofResult = Optional.of(usuario2);
        doNothing().when(usuarioRepository).delete(Mockito.<Usuario>any());
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/usuarios/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UsuarioController#downloadCSV()}
     */
    @Test
    void testDownloadCSV() throws Exception {
        // Arrange
        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/download");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/csv"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("NOME;PESO;GENERO;E-MAIL;STATUS CONTA;DATA NASC;NIVEL;META;ALTURA;PONTUACAO\n"));
    }

    /**
     * Method under test: {@link UsuarioController#downloadCSV()}
     */
    @Test
    void testDownloadCSV2() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("NOME");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("NOME");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("NOME");
        usuario.setMeta("NOME");
        usuario.setNivelCondicao("NOME");
        usuario.setNome("NOME");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("NOME");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("NOME");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("NOME");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("NOME");
        usuario2.setMeta("NOME");
        usuario2.setNivelCondicao("NOME");
        usuario2.setNome("NOME");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("NOME");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/download");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/csv"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("NOME;PESO;GENERO;E-MAIL;STATUS CONTA;DATA NASC;NIVEL;META;ALTURA;PONTUACAO\n"
                                + "NOME;10.0;NOME;jane.doe@example.org;Ativa;1969-12-31;NOME;NOME;1;1\n"));
    }

    /**
     * Method under test: {@link UsuarioController#downloadCSV()}
     */
    @Test
    void testDownloadCSV3() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("NOME");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("NOME");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("NOME");
        usuario.setMeta("NOME");
        usuario.setNivelCondicao("NOME");
        usuario.setNome("NOME");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("NOME");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("NOME");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("NOME");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("NOME");
        usuario2.setMeta("NOME");
        usuario2.setNivelCondicao("NOME");
        usuario2.setNome("NOME");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("NOME");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("PESO");
        objetivo3.setUsuario(new Usuario());

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(10);
        usuario3.setContaAtiva(false);
        usuario3.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario3.setEmail("john.smith@example.org");
        usuario3.setGenero("PESO");
        usuario3.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario3.setId(2L);
        usuario3.setImg("PESO");
        usuario3.setMeta("PESO");
        usuario3.setNivelCondicao("PESO");
        usuario3.setNome("PESO");
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(10);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("PESO");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("PESO");
        objetivo4.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(10);
        usuario4.setContaAtiva(false);
        usuario4.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario4.setEmail("john.smith@example.org");
        usuario4.setGenero("PESO");
        usuario4.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario4.setId(2L);
        usuario4.setImg("PESO");
        usuario4.setMeta("PESO");
        usuario4.setNivelCondicao("PESO");
        usuario4.setNome("PESO");
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(10);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("PESO");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario4);
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/download");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/csv"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("NOME;PESO;GENERO;E-MAIL;STATUS CONTA;DATA NASC;NIVEL;META;ALTURA;PONTUACAO\n"
                                + "PESO;0.5;PESO;john.smith@example.org;Desativa;1969-12-31;PESO;PESO;10;10\n"
                                + "NOME;10.0;NOME;jane.doe@example.org;Ativa;1969-12-31;NOME;NOME;1;1\n"));
    }

    /**
     * Method under test: {@link UsuarioController#enviarEmail(EmailDTO)}
     */
    @Test
    void testEnviarEmail() throws Exception {
        // Arrange
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setNome("Nome");
        emailDTO.setPara("Para");
        String content = (new ObjectMapper()).writeValueAsString(emailDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/usuarios/enviar-email")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UsuarioController#enviarEmail(EmailDTO)}
     */
    @Test
    void testEnviarEmail2() throws Exception {
        // Arrange
        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setNome("Nome");
        emailDTO.setPara("Email não encontrado");
        String content = (new ObjectMapper()).writeValueAsString(emailDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/usuarios/enviar-email")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UsuarioController#enviarEmail(EmailDTO)}
     */
    @Test
    void testEnviarEmail3() throws Exception {
        // Arrange
        when(emailService.gerarNovaSenha()).thenReturn("Gerar Nova Senha");
        doNothing().when(emailService).enviarEmailRedefinicaoSenha(Mockito.<String>any(), Mockito.<String>any());

        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Email não encontrado");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(8);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Email não encontrado");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Email não encontrado");
        usuario.setMeta("Email não encontrado");
        usuario.setNivelCondicao("Email não encontrado");
        usuario.setNome("Email não encontrado");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(8);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Email não encontrado");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Email não encontrado");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(8);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Email não encontrado");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Email não encontrado");
        usuario2.setMeta("Email não encontrado");
        usuario2.setNivelCondicao("Email não encontrado");
        usuario2.setNome("Email não encontrado");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(8);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Email não encontrado");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);

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
        usuario3.setReceitas(new ArrayList<>());
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
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("Senha");
        Optional<Usuario> ofResult = Optional.of(usuario4);

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
        usuario5.setObjetivo(new Objetivo());
        usuario5.setPeso(10.0d);
        usuario5.setPontuacao(1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");

        Objetivo objetivo5 = new Objetivo();
        objetivo5.setId(1L);
        objetivo5.setObjetivo("Objetivo");
        objetivo5.setUsuario(usuario5);

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
        usuario6.setObjetivo(objetivo5);
        usuario6.setPeso(10.0d);
        usuario6.setPontuacao(1);
        usuario6.setReceitas(new ArrayList<>());
        usuario6.setSenha("Senha");

        Objetivo objetivo6 = new Objetivo();
        objetivo6.setId(1L);
        objetivo6.setObjetivo("Objetivo");
        objetivo6.setUsuario(usuario6);

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
        usuario7.setObjetivo(objetivo6);
        usuario7.setPeso(10.0d);
        usuario7.setPontuacao(1);
        usuario7.setReceitas(new ArrayList<>());
        usuario7.setSenha("Senha");
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario7);
        when(usuarioRepository.findByEmailEqualsIgnoreCase(Mockito.<String>any())).thenReturn(ofResult);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        when(passwordEncoder.encode(Mockito.<CharSequence>any())).thenReturn("secret");

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setNome("Nome");
        emailDTO.setPara("jane.doe@example.org");
        String content = (new ObjectMapper()).writeValueAsString(emailDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/usuarios/enviar-email")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("Solicitação de redefinição de senha enviada com sucesso! Verifique seu email."));
    }

    /**
     * Method under test: {@link UsuarioController#exibirUsuariosRanking()}
     */
    @Test
    void testExibirUsuariosRanking() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/exibir");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UsuarioController#exibirUsuariosRanking()}
     */
    @Test
    void testExibirUsuariosRanking2() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/exibir");
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link UsuarioController#getListarOrdemAlfabetica()}
     */
    @Test
    void testGetListarOrdemAlfabetica() throws Exception {
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

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/ordemAlfabetica");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><img>Img</img><dataNascimento"
                                        + ">0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1</altura><nivelCondicao>Nivel"
                                        + " Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao><objetivo"
                                        + "><id>1</id><objetivo>Objetivo</objetivo></objetivo></item></List>"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarOrdemAlfabetica()}
     */
    @Test
    void testGetListarOrdemAlfabetica2() throws Exception {
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

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(new Usuario());

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(-1);
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
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(-1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(-1);
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
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(-1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario4);
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/ordemAlfabetica");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>2</id><nome>42</nome><email>john.smith@example.org</email><img>42</img><dataNascimento"
                                        + ">0</dataNascimento><genero>42</genero><peso>0.5</peso><altura>-1</altura><nivelCondicao>42</nivelCondicao"
                                        + "><meta>42</meta><contaAtiva>false</contaAtiva><pontuacao>-1</pontuacao><objetivo><id>2</id><objetivo"
                                        + ">42</objetivo></objetivo></item><item><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email"
                                        + "><img>Img</img><dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1"
                                        + "</altura><nivelCondicao>Nivel Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>true</contaAtiva"
                                        + "><pontuacao>1</pontuacao><objetivo><id>1</id><objetivo>Objetivo</objetivo></objetivo></item></List"
                                        + ">"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarTudo()}
     */
    @Test
    void testGetListarTudo() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Nenhum usuário encontrado");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Nenhum usuário encontrado");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Nenhum usuário encontrado");
        usuario.setMeta("Nenhum usuário encontrado");
        usuario.setNivelCondicao("Nenhum usuário encontrado");
        usuario.setNome("Nenhum usuário encontrado");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Nenhum usuário encontrado");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Nenhum usuário encontrado");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Nenhum usuário encontrado");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Nenhum usuário encontrado");
        usuario2.setMeta("Nenhum usuário encontrado");
        usuario2.setNivelCondicao("Nenhum usuário encontrado");
        usuario2.setNome("Nenhum usuário encontrado");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Nenhum usuário encontrado");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><nome>Nenhum usuário encontrado</nome><email>jane.doe@example.org</email><img>Nenhum"
                                        + " usuário encontrado</img><dataNascimento>0</dataNascimento><genero>Nenhum usuário encontrado</genero"
                                        + "><peso>10.0</peso><altura>1</altura><nivelCondicao>Nenhum usuário encontrado</nivelCondicao><meta>Nenhum"
                                        + " usuário encontrado</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao><objetivo><id>1</id>"
                                        + "<objetivo>Nenhum usuário encontrado</objetivo></objetivo></item></List>"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarTudo()}
     */
    @Test
    void testGetListarTudo2() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Nenhum usuário encontrado");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Nenhum usuário encontrado");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Nenhum usuário encontrado");
        usuario.setMeta("Nenhum usuário encontrado");
        usuario.setNivelCondicao("Nenhum usuário encontrado");
        usuario.setNome("Nenhum usuário encontrado");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Nenhum usuário encontrado");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Nenhum usuário encontrado");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Nenhum usuário encontrado");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Nenhum usuário encontrado");
        usuario2.setMeta("Nenhum usuário encontrado");
        usuario2.setNivelCondicao("Nenhum usuário encontrado");
        usuario2.setNome("Nenhum usuário encontrado");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Nenhum usuário encontrado");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(new Usuario());

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(1);
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
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(1);
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
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario4);
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>2</id><nome>42</nome><email>john.smith@example.org</email><img>42</img><dataNascimento"
                                        + ">0</dataNascimento><genero>42</genero><peso>0.5</peso><altura>1</altura><nivelCondicao>42</nivelCondicao"
                                        + "><meta>42</meta><contaAtiva>false</contaAtiva><pontuacao>1</pontuacao><objetivo><id>2</id><objetivo"
                                        + ">42</objetivo></objetivo></item><item><id>1</id><nome>Nenhum usuário encontrado</nome><email>jane.doe"
                                        + "@example.org</email><img>Nenhum usuário encontrado</img><dataNascimento>0</dataNascimento><genero>Nenhum"
                                        + " usuário encontrado</genero><peso>10.0</peso><altura>1</altura><nivelCondicao>Nenhum usuário"
                                        + " encontrado</nivelCondicao><meta>Nenhum usuário encontrado</meta><contaAtiva>true</contaAtiva><pontuacao"
                                        + ">1</pontuacao><objetivo><id>1</id><objetivo>Nenhum usuário encontrado</objetivo></objetivo></item><"
                                        + "/List>"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarUsuarioStatus(Boolean)}
     */
    @Test
    void testGetListarUsuarioStatus() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Nehuma conta %s encontrada");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Nehuma conta %s encontrada");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Nehuma conta %s encontrada");
        usuario.setMeta("Nehuma conta %s encontrada");
        usuario.setNivelCondicao("Nehuma conta %s encontrada");
        usuario.setNome("Nehuma conta %s encontrada");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Nehuma conta %s encontrada");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Nehuma conta %s encontrada");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Nehuma conta %s encontrada");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Nehuma conta %s encontrada");
        usuario2.setMeta("Nehuma conta %s encontrada");
        usuario2.setNivelCondicao("Nehuma conta %s encontrada");
        usuario2.setNome("Nehuma conta %s encontrada");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Nehuma conta %s encontrada");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/usuarios/statusUsuario");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("contaAtiva", String.valueOf(true));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><nome>Nehuma conta %s encontrada</nome><email>jane.doe@example.org</email><img>Nehuma"
                                        + " conta %s encontrada</img><dataNascimento>0</dataNascimento><genero>Nehuma conta %s encontrada</genero"
                                        + "><peso>10.0</peso><altura>1</altura><nivelCondicao>Nehuma conta %s encontrada</nivelCondicao><meta>Nehuma"
                                        + " conta %s encontrada</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao><objetivo><id>1</id>"
                                        + "<objetivo>Nehuma conta %s encontrada</objetivo></objetivo></item></List>"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarUsuarioStatus(Boolean)}
     */
    @Test
    void testGetListarUsuarioStatus2() throws Exception {
        // Arrange
        Objetivo objetivo = new Objetivo();
        objetivo.setId(1L);
        objetivo.setObjetivo("Nehuma conta %s encontrada");
        objetivo.setUsuario(new Usuario());

        Usuario usuario = new Usuario();
        usuario.preUpdate();
        usuario.setAltura(1);
        usuario.setContaAtiva(true);
        usuario.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario.setEmail("jane.doe@example.org");
        usuario.setGenero("Nehuma conta %s encontrada");
        usuario.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario.setId(1L);
        usuario.setImg("Nehuma conta %s encontrada");
        usuario.setMeta("Nehuma conta %s encontrada");
        usuario.setNivelCondicao("Nehuma conta %s encontrada");
        usuario.setNome("Nehuma conta %s encontrada");
        usuario.setObjetivo(objetivo);
        usuario.setPeso(10.0d);
        usuario.setPontuacao(1);
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Nehuma conta %s encontrada");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Nehuma conta %s encontrada");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(true);
        usuario2.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario2.setEmail("jane.doe@example.org");
        usuario2.setGenero("Nehuma conta %s encontrada");
        usuario2.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario2.setId(1L);
        usuario2.setImg("Nehuma conta %s encontrada");
        usuario2.setMeta("Nehuma conta %s encontrada");
        usuario2.setNivelCondicao("Nehuma conta %s encontrada");
        usuario2.setNome("Nehuma conta %s encontrada");
        usuario2.setObjetivo(objetivo2);
        usuario2.setPeso(10.0d);
        usuario2.setPontuacao(1);
        usuario2.setReceitas(new ArrayList<>());
        usuario2.setSenha("Nehuma conta %s encontrada");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(new Usuario());

        Usuario usuario3 = new Usuario();
        usuario3.preUpdate();
        usuario3.setAltura(200);
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
        usuario3.setObjetivo(objetivo3);
        usuario3.setPeso(0.5d);
        usuario3.setPontuacao(200);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.preUpdate();
        usuario4.setAltura(200);
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
        usuario4.setObjetivo(objetivo4);
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(200);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario4);
        usuarioList.add(usuario2);
        when(usuarioRepository.findAll()).thenReturn(usuarioList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/usuarios/statusUsuario");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("contaAtiva", String.valueOf(true));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<List><item><id>1</id><nome>Nehuma conta %s encontrada</nome><email>jane.doe@example.org</email><img>Nehuma"
                                        + " conta %s encontrada</img><dataNascimento>0</dataNascimento><genero>Nehuma conta %s encontrada</genero"
                                        + "><peso>10.0</peso><altura>1</altura><nivelCondicao>Nehuma conta %s encontrada</nivelCondicao><meta>Nehuma"
                                        + " conta %s encontrada</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao><objetivo><id>1</id>"
                                        + "<objetivo>Nehuma conta %s encontrada</objetivo></objetivo></item></List>"));
    }

    /**
     * Method under test: {@link UsuarioController#getListarUsuariosPontuacao()}
     */
    @Test
    void testGetListarUsuariosPontuacao() throws Exception {
        // Arrange
        when(usuarioService.usuariosPontuacao()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/pontuacao");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link UsuarioController#getUsuarioPorId(Long)}
     */
    @Test
    void testGetUsuarioPorId() throws Exception {
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
        Optional<Usuario> ofResult = Optional.of(usuario2);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/usuarios/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<UsuarioResponseDTO><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><img>Img</img>"
                                + "<dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1</altura><nivelCondicao"
                                + ">Nivel Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao"
                                + "><objetivo><id>1</id><objetivo>Objetivo</objetivo></objetivo></UsuarioResponseDTO>"));
    }

    /**
     * Method under test: {@link UsuarioController#inativarContaUsuario(Long)}
     */
    @Test
    void testInativarContaUsuario() throws Exception {
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
        Optional<Usuario> ofResult = Optional.of(usuario2);

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
        usuario3.setReceitas(new ArrayList<>());
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
        usuario4.setReceitas(new ArrayList<>());
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
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario5);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/usuarios/{id}/inativar", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<UsuarioResponseDTO><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><img>Img</img>"
                                + "<dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1</altura><nivelCondicao"
                                + ">Nivel Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>false</contaAtiva><pontuacao>1</pontuacao"
                                + "><objetivo><id>1</id><objetivo>Objetivo</objetivo></objetivo></UsuarioResponseDTO>"));
    }

    /**
     * Method under test: {@link UsuarioController#patchAtivarContaUsuario(Long)}
     */
    @Test
    void testPatchAtivarContaUsuario() throws Exception {
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
        usuario.setReceitas(new ArrayList<>());
        usuario.setSenha("Senha");

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.preUpdate();
        usuario2.setAltura(1);
        usuario2.setContaAtiva(false);
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
        Optional<Usuario> ofResult = Optional.of(usuario2);

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
        usuario3.setReceitas(new ArrayList<>());
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
        usuario4.setReceitas(new ArrayList<>());
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
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario5);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/usuarios/{id}/ativar", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<UsuarioResponseDTO><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><img>Img</img>"
                                + "<dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1</altura><nivelCondicao"
                                + ">Nivel Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>true</contaAtiva><pontuacao>1</pontuacao"
                                + "><objetivo><id>1</id><objetivo>Objetivo</objetivo></objetivo></UsuarioResponseDTO>"));
    }

    /**
     * Method under test:
     * {@link UsuarioController#postCadastrarUsuario(UsuarioCreateDTO)}
     */
    @Test
    void testPostCadastrarUsuario() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new UsuarioCreateDTO("Nome", "jane.doe@example.org", "Senha", "Img")));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link UsuarioController#postLoginGoogle(UsuarioLoginGoogleDTO)}
     */
    @Test
    void testPostLoginGoogle() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/usuarios/login/google")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new UsuarioLoginGoogleDTO()));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link UsuarioController#postLoginGoogle(UsuarioLoginGoogleDTO)}
     */
    @Test
    void testPostLoginGoogle2() throws Exception {
        // Arrange
        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/usuarios/login/google");
        postResult.principal(new UserDatabaseRealm.UserDatabasePrincipal(user, new MemoryUserDatabase()));
        MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new UsuarioLoginGoogleDTO()));

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link UsuarioController#postLoginUsuario(UsuarioLoginDTO)}
     */
    @Test
    void testPostLoginUsuario() throws Exception {
        // Arrange
        UsuarioTokenDTO usuarioTokenDTO = new UsuarioTokenDTO();
        usuarioTokenDTO.setEmail("jane.doe@example.org");
        usuarioTokenDTO.setNome("Nome");
        usuarioTokenDTO.setToken("ABC123");
        usuarioTokenDTO.setUserId(1L);
        when(usuarioService.autenticar(Mockito.<UsuarioLoginDTO>any())).thenReturn(usuarioTokenDTO);

        UsuarioLoginDTO usuarioLoginDTO = new UsuarioLoginDTO();
        usuarioLoginDTO.setEmail("jane.doe@example.org");
        usuarioLoginDTO.setSenha("Senha");
        String content = (new ObjectMapper()).writeValueAsString(usuarioLoginDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/usuarios/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<UsuarioTokenDTO><userId>1</userId><nome>Nome</nome><email>jane.doe@example.org</email><token>ABC123"
                                        + "</token></UsuarioTokenDTO>"));
    }

    /**
     * Method under test:
     * {@link UsuarioController#putAtualizarPerfil(UsuarioUpdatePerfilDTO, Long)}
     */
    @Test
    void testPutAtualizarPerfil() throws Exception {
        // Arrange
        UsuarioUpdatePerfilDTO usuarioUpdatePerfilDTO = new UsuarioUpdatePerfilDTO();
        usuarioUpdatePerfilDTO.setAltura(1);
        usuarioUpdatePerfilDTO
                .setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuarioUpdatePerfilDTO.setMeta("Meta");
        usuarioUpdatePerfilDTO.setNivelCondicao("Nivel Condicao");
        usuarioUpdatePerfilDTO.setNome("Nome");
        String content = (new ObjectMapper()).writeValueAsString(usuarioUpdatePerfilDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/usuarios/perfil/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test:
     * {@link UsuarioController#putAtualizarPerfil(UsuarioUpdatePerfilDTO, Long)}
     */
    @Test
    void testPutAtualizarPerfil2() throws Exception {
        // Arrange
        java.sql.Date dataNascimento = mock(java.sql.Date.class);
        when(dataNascimento.getTime()).thenReturn(10L);

        UsuarioUpdatePerfilDTO usuarioUpdatePerfilDTO = new UsuarioUpdatePerfilDTO();
        usuarioUpdatePerfilDTO.setAltura(1);
        usuarioUpdatePerfilDTO.setDataNascimento(dataNascimento);
        usuarioUpdatePerfilDTO.setMeta("Meta");
        usuarioUpdatePerfilDTO.setNivelCondicao("Nivel Condicao");
        usuarioUpdatePerfilDTO.setNome("Nome");
        String content = (new ObjectMapper()).writeValueAsString(usuarioUpdatePerfilDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/usuarios/perfil/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UsuarioController#putAtualizarPontuacao(Long)}
     */
    @Test
    void testPutAtualizarPontuacao() throws Exception {
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
        Optional<Usuario> ofResult = Optional.of(usuario2);

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
        usuario3.setReceitas(new ArrayList<>());
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
        usuario4.setReceitas(new ArrayList<>());
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
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("Senha");
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario5);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/usuarios/pontuacao/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<UsuarioResponseDTO><id>1</id><nome>Nome</nome><email>jane.doe@example.org</email><img>Img</img>"
                                + "<dataNascimento>0</dataNascimento><genero>Genero</genero><peso>10.0</peso><altura>1</altura><nivelCondicao"
                                + ">Nivel Condicao</nivelCondicao><meta>Meta</meta><contaAtiva>true</contaAtiva><pontuacao>21</pontuacao"
                                + "><objetivo><id>1</id><objetivo>Objetivo</objetivo></objetivo></UsuarioResponseDTO>"));
    }

    /**
     * Method under test:
     * {@link UsuarioController#putAtualizarUsuario(UsuarioUpdateDTO, Long)}
     */
    @Test
    void testPutAtualizarUsuario() throws Exception {
        // Arrange
        java.sql.Date dataNascimento = mock(java.sql.Date.class);
        when(dataNascimento.getTime()).thenReturn(10L);

        UsuarioUpdateDTO usuarioUpdateDTO = new UsuarioUpdateDTO();
        usuarioUpdateDTO.setAltura(1);
        usuarioUpdateDTO.setDataNascimento(dataNascimento);
        usuarioUpdateDTO.setGenero("Genero");
        usuarioUpdateDTO.setImg("Img");
        usuarioUpdateDTO.setMeta("Meta");
        usuarioUpdateDTO.setNivelCondicao("Nivel Condicao");
        usuarioUpdateDTO.setNome("Nome");
        usuarioUpdateDTO.setPeso(10.0d);
        usuarioUpdateDTO.setSenha("Senha");
        String content = (new ObjectMapper()).writeValueAsString(usuarioUpdateDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/usuarios/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(usuarioController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UsuarioController#removerUsuarioRanking(Usuario)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoverUsuarioRanking() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Java 8 date/time type `java.time.LocalDateTime` not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" to enable handling (through reference chain: sync.spctrum.apispring.domain.Usuario.Usuario["horaSenhaAtualizacao"])
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
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");
        String content = (new ObjectMapper()).writeValueAsString(usuario3);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/usuarios/remover")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(usuarioController).build().perform(requestBuilder);
    }
}
