package sync.spctrum.apispring.service.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;
import sync.spctrum.apispring.api.configuration.security.AutenticacaoProvider;
import sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.exception.TransactionNotAcceptable;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.AutenticacaoService;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioLoginGoogleDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioResponseDTO;

@ContextConfiguration(classes = {UsuarioService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class UsuarioServiceTest {
    @MockBean
    private EmailService emailService;

    @MockBean
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private UsuarioService usuarioService;

    /**
     * Method under test: {@link UsuarioService#init()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInit() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5302 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.init();
    }

    /**
     * Method under test: {@link UsuarioService#usuariosPontuacao()}
     */
    @Test
    void testUsuariosPontuacao() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.topUsuarios()).thenReturn(new ArrayList<>());

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act
        List<UsuarioResponseDTO> actualUsuariosPontuacaoResult = (new UsuarioService(passwordEncoder, usuarioRepository,
                gerenciadorTokenJwt, authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                .usuariosPontuacao();

        // Assert
        verify(usuarioRepository).topUsuarios();
        assertTrue(actualUsuariosPontuacaoResult.isEmpty());
    }

    /**
     * Method under test: {@link UsuarioService#usuariosPontuacao()}
     */
    @Test
    void testUsuariosPontuacao2() {
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

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario2);
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.topUsuarios()).thenReturn(usuarioList);

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act
        List<UsuarioResponseDTO> actualUsuariosPontuacaoResult = (new UsuarioService(passwordEncoder, usuarioRepository,
                gerenciadorTokenJwt, authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                .usuariosPontuacao();

        // Assert
        verify(usuarioRepository).topUsuarios();
        assertEquals(1, actualUsuariosPontuacaoResult.size());
    }

    /**
     * Method under test: {@link UsuarioService#usuariosPontuacao()}
     */
    @Test
    void testUsuariosPontuacao3() {
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

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(new Usuario());

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
        usuario4.setPontuacao(0);
        usuario4.setSenha("42");

        ArrayList<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario4);
        usuarioList.add(usuario2);
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.topUsuarios()).thenReturn(usuarioList);

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act
        List<UsuarioResponseDTO> actualUsuariosPontuacaoResult = (new UsuarioService(passwordEncoder, usuarioRepository,
                gerenciadorTokenJwt, authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                .usuariosPontuacao();

        // Assert
        verify(usuarioRepository).topUsuarios();
        assertEquals(2, actualUsuariosPontuacaoResult.size());
    }

    /**
     * Method under test: {@link UsuarioService#usuariosPontuacao()}
     */
    @Test
    void testUsuariosPontuacao4() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.topUsuarios()).thenThrow(new TransactionNotAcceptable("Obj"));

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act and Assert
        assertThrows(TransactionNotAcceptable.class,
                () -> (new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt, authenticationManager,
                        new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                        .usuariosPontuacao());
        verify(usuarioRepository).topUsuarios();
    }

    /**
     * Method under test: {@link UsuarioService#usuariosPontuacao()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUsuariosPontuacao5() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5324 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.usuariosPontuacao();
    }

    /**
     * Method under test: {@link UsuarioService#criarUsuario(UsuarioCreateDTO)}
     */
    @Test
    void testCriarUsuario() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

        Objetivo objetivo2 = new Objetivo();
        objetivo2.setId(1L);
        objetivo2.setObjetivo("Objetivo");
        objetivo2.setUsuario(usuario2);

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
        usuario3.setObjetivo(objetivo2);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setSenha("Senha");
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.save(Mockito.<Usuario>any())).thenReturn(usuario3);

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

        // Act
        UsuarioResponseDTO actualCriarUsuarioResult = usuarioService
                .criarUsuario(new UsuarioCreateDTO("Nome", "jane.doe@example.org", "Senha", "Img"));

        // Assert
        verify(usuarioRepository, atLeast(1)).save(Mockito.<Usuario>any());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals("1969-12-31", simpleDateFormat.format(actualCriarUsuarioResult.getDataNascimento()));
        assertEquals("Genero", actualCriarUsuarioResult.getGenero());
        assertEquals("Img", actualCriarUsuarioResult.getImg());
        assertEquals("Meta", actualCriarUsuarioResult.getMeta());
        assertEquals("Nivel Condicao", actualCriarUsuarioResult.getNivelCondicao());
        assertEquals("Nome", actualCriarUsuarioResult.getNome());
        assertEquals("jane.doe@example.org", actualCriarUsuarioResult.getEmail());
        ObjetivoResponseDTO objetivo3 = actualCriarUsuarioResult.getObjetivo();
        assertNull(objetivo3.getObjetivo());
        assertEquals(1, actualCriarUsuarioResult.getAltura().intValue());
        assertEquals(1, actualCriarUsuarioResult.getPontuacao());
        assertEquals(10.0d, actualCriarUsuarioResult.getPeso().doubleValue());
        assertEquals(1L, objetivo3.getId().longValue());
        assertEquals(1L, actualCriarUsuarioResult.getId().longValue());
        assertTrue(actualCriarUsuarioResult.getContaAtiva());
    }

    /**
     * Method under test: {@link UsuarioService#criarUsuario(UsuarioCreateDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCriarUsuario2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5277 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.criarUsuario(new UsuarioCreateDTO("Nome", "jane.doe@example.org", "Senha", "Img"));
    }

    /**
     * Method under test: {@link UsuarioService#atualizarImage(Long, MultipartFile)}
     */
    @Test
    void testAtualizarImage() throws IOException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        Usuario usuario = mock(Usuario.class);
        when(usuario.getNome()).thenThrow(new ResourceNotFound("Not all who wander are lost"));
        Optional<Usuario> ofResult = Optional.of(usuario);
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

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> usuarioService.atualizarImage(1L,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
        verify(usuarioRepository).findById(eq(1L));
        verify(usuario).getNome();
    }

    /**
     * Method under test: {@link UsuarioService#atualizarImage(Long, MultipartFile)}
     */
    @Test
    void testAtualizarImage2() throws IOException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

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

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> usuarioService.atualizarImage(1L,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link UsuarioService#atualizarImage(Long, MultipartFile)}
     */
    @Test
    void testAtualizarImage3() throws IOException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);
        UsuarioService usuarioService = new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt,
                authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService()));
        MultipartFile imageFile = mock(MultipartFile.class);
        when(imageFile.getInputStream()).thenThrow(new IOException("%s_%d"));

        // Act and Assert
        assertThrows(TransactionNotAcceptable.class, () -> usuarioService.atualizarImage(1L, imageFile));
        verify(imageFile).getInputStream();
    }

    /**
     * Method under test: {@link UsuarioService#atualizarImage(Long, MultipartFile)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAtualizarImage4() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5001 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.atualizarImage(1L,
                new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    }

    /**
     * Method under test: {@link UsuarioService#autenticar(UsuarioLoginDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAutenticar() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5096 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange
        UsuarioLoginDTO usuarioLoginDto = new UsuarioLoginDTO();
        usuarioLoginDto.setEmail("jane.doe@example.org");
        usuarioLoginDto.setSenha("Senha");

        // Act
        usuarioService.autenticar(usuarioLoginDto);
    }

    /**
     * Method under test:
     * {@link UsuarioService#autenticarGoogle(UsuarioLoginGoogleDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAutenticarGoogle() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5271 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.autenticarGoogle(new UsuarioLoginGoogleDTO());
    }

    /**
     * Method under test: {@link UsuarioService#procurarUsuarioPorId(Long)}
     */
    @Test
    void testProcurarUsuarioPorId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> ofResult = Optional.of(mock(Usuario.class));
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

        // Act
        (new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt, authenticationManager,
                new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                .procurarUsuarioPorId(1L);

        // Assert
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link UsuarioService#procurarUsuarioPorId(Long)}
     */
    @Test
    void testProcurarUsuarioPorId2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act and Assert
        assertThrows(ResourceNotFound.class,
                () -> (new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt, authenticationManager,
                        new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                        .procurarUsuarioPorId(1L));
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link UsuarioService#procurarUsuarioPorId(Long)}
     */
    @Test
    void testProcurarUsuarioPorId3() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenThrow(new TransactionNotAcceptable("Obj"));

        ArrayList<AuthenticationProvider> providers = new ArrayList<>();
        AutenticacaoService usuarioAutorizacaoService = new AutenticacaoService();
        providers.add(new AutenticacaoProvider(usuarioAutorizacaoService, new BCryptPasswordEncoder()));
        ProviderManager authenticationManager = new ProviderManager(providers);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        GerenciadorTokenJwt gerenciadorTokenJwt = new GerenciadorTokenJwt();
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository2 = mock(UsuarioRepository.class);

        // Act and Assert
        assertThrows(TransactionNotAcceptable.class,
                () -> (new UsuarioService(passwordEncoder, usuarioRepository, gerenciadorTokenJwt, authenticationManager,
                        new EmailService(passwordEncoder2, javaMailSender, usuarioRepository2, new ApplicationConversionService())))
                        .procurarUsuarioPorId(1L));
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test: {@link UsuarioService#procurarUsuarioPorId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testProcurarUsuarioPorId4() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //   - org.springframework.security.crypto.password.PasswordEncoder
        //   when running class:
        //   package sync.spctrum.apispring.service.usuario;
        //   @org.springframework.boot.context.properties.EnableConfigurationProperties
        //   @org.springframework.context.annotation.PropertySource(value = "classpath:application-test.properties")
        //   @org.springframework.test.context.ContextConfiguration(classes = {sync.spctrum.apispring.service.usuario.UsuarioService.class})
        //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
        //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
        //   public class DiffblueFakeClass5306 {
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.service.email.EmailService emailService;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.api.configuration.security.jwt.GerenciadorTokenJwt gerenciadorTokenJwt;
        //     @org.springframework.boot.test.mock.mockito.MockBean sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository usuarioRepository;
        //     @org.springframework.beans.factory.annotation.Autowired sync.spctrum.apispring.service.usuario.UsuarioService usuarioService;
        //     @org.junit.Test // if JUnit 4
        //     @org.junit.jupiter.api.Test // if JUnit 5
        //     public void testSpringContextLoads() {}
        //   }
        //   See https://diff.blue/R027 to resolve this issue.

        // Arrange and Act
        usuarioService.procurarUsuarioPorId(1L);
    }
}
