package sync.spctrum.apispring.service.email;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

@ContextConfiguration(classes = {EmailService.class, PasswordEncoder.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class EmailServiceTest {
    @MockBean
    private ConversionService conversionService;

    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UsuarioRepository usuarioRepository;

    /**
     * Method under test:
     * {@link EmailService#enviarEmailRedefinicaoSenha(String, String)}
     */
    @Test
    void testEnviarEmailRedefinicaoSenha() throws MailException {
        // Arrange
        doNothing().when(javaMailSender).send(Mockito.<MimeMessage>any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));

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
        Optional<Usuario> ofResult = Optional.of(usuario2);
        when(usuarioRepository.findByEmailEqualsIgnoreCase(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        emailService.enviarEmailRedefinicaoSenha("Destinatario", "Nova Senha");

        // Assert
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send(isA(MimeMessage.class));
        verify(usuarioRepository).findByEmailEqualsIgnoreCase(eq("Destinatario"));
        FilaObj filaObj = emailService.resetQueue;
        assertEquals(1, filaObj.getTamanho());
        assertFalse(filaObj.isEmpty());
    }

    /**
     * Method under test:
     * {@link EmailService#enviarEmailRedefinicaoSenha(String, String)}
     */
    @Test
    void testEnviarEmailRedefinicaoSenha2() {
        // Arrange
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));

        // Act and Assert
        assertThrows(ResponseStatusException.class,
                () -> emailService.enviarEmailRedefinicaoSenha("Destinatario", "Nova Senha"));
        verify(javaMailSender).createMimeMessage();
    }

    /**
     * Method under test:
     * {@link EmailService#enviarEmailRedefinicaoSenha(String, String)}
     */
    @Test
    void testEnviarEmailRedefinicaoSenha3() {
        // Arrange
        when(javaMailSender.createMimeMessage()).thenReturn(mock(MimeMessage.class));

        // Act and Assert
        assertThrows(ResponseStatusException.class,
                () -> emailService.enviarEmailRedefinicaoSenha("Destinatario", "Nova Senha"));
        verify(javaMailSender).createMimeMessage();
    }

    /**
     * Method under test: {@link EmailService#removerPrimeiraSolicitacaoSenha()}
     */
    @Test
    void testRemoverPrimeiraSolicitacaoSenha() throws InterruptedException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        EmailService emailService = new EmailService(passwordEncoder, javaMailSender, usuarioRepository,
                new ApplicationConversionService());

        // Act
        emailService.removerPrimeiraSolicitacaoSenha();

        // Assert that nothing has changed
        assertEquals(0, emailService.resetQueue.getTamanho());
    }

    /**
     * Method under test: {@link EmailService#removerPrimeiraSolicitacaoSenha()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoverPrimeiraSolicitacaoSenha2() throws InterruptedException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@3943ee80 testClass = sync.spctrum.apispring.service.email.DiffblueFakeClass212, locations = [], classes = [sync.spctrum.apispring.service.email.EmailService, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@19e5a990, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@63e150ea, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@cf8fb4dc, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5e55b293], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        emailService.removerPrimeiraSolicitacaoSenha();
    }

    /**
     * Method under test: {@link EmailService#solicitarRedefinicaoSenha(String)}
     */
    @Test
    void testSolicitarRedefinicaoSenha() throws InterruptedException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> ofResult = Optional.of(mock(Usuario.class));
        when(usuarioRepository.findByEmailEqualsIgnoreCase(Mockito.<String>any())).thenReturn(ofResult);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        EmailService emailService = new EmailService(passwordEncoder, javaMailSender, usuarioRepository,
                new ApplicationConversionService());

        // Act
        boolean actualSolicitarRedefinicaoSenhaResult = emailService.solicitarRedefinicaoSenha("jane.doe@example.org");

        // Assert
        verify(usuarioRepository).findByEmailEqualsIgnoreCase(eq("jane.doe@example.org"));
        FilaObj filaObj = emailService.resetQueue;
        assertEquals(1, filaObj.getTamanho());
        assertFalse(filaObj.isEmpty());
        assertTrue(actualSolicitarRedefinicaoSenhaResult);
    }

    /**
     * Method under test: {@link EmailService#solicitarRedefinicaoSenha(String)}
     */
    @Test
    void testSolicitarRedefinicaoSenha2() throws InterruptedException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findByEmailEqualsIgnoreCase(Mockito.<String>any())).thenReturn(emptyResult);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        // Act and Assert
        assertThrows(ResponseStatusException.class,
                () -> (new EmailService(passwordEncoder, javaMailSender, usuarioRepository, new ApplicationConversionService()))
                        .solicitarRedefinicaoSenha("jane.doe@example.org"));
        verify(usuarioRepository).findByEmailEqualsIgnoreCase(eq("jane.doe@example.org"));
    }

    /**
     * Method under test: {@link EmailService#solicitarRedefinicaoSenha(String)}
     */
    @Test
    void testSolicitarRedefinicaoSenha3() throws InterruptedException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        when(usuarioRepository.findByEmailEqualsIgnoreCase(Mockito.<String>any()))
                .thenThrow(new RuntimeException("Email ainda não cadastrado"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        // Act and Assert
        assertThrows(RuntimeException.class,
                () -> (new EmailService(passwordEncoder, javaMailSender, usuarioRepository, new ApplicationConversionService()))
                        .solicitarRedefinicaoSenha("jane.doe@example.org"));
        verify(usuarioRepository).findByEmailEqualsIgnoreCase(eq("jane.doe@example.org"));
    }

    /**
     * Method under test: {@link EmailService#solicitarRedefinicaoSenha(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSolicitarRedefinicaoSenha4() throws InterruptedException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@2fd96ae testClass = sync.spctrum.apispring.service.email.DiffblueFakeClass214, locations = [], classes = [sync.spctrum.apispring.service.email.EmailService, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@19e5a990, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@63e150ea, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@cf8fb4dc, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5e55b293], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        emailService.solicitarRedefinicaoSenha("jane.doe@example.org");
    }

    /**
     * Method under test: {@link EmailService#gerarNovaSenha()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGerarNovaSenha() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@d6dfec1 testClass = sync.spctrum.apispring.service.email.DiffblueFakeClass210, locations = [], classes = [sync.spctrum.apispring.service.email.EmailService, org.springframework.security.crypto.password.PasswordEncoder], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@19e5a990, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@63e150ea, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@cf8fb4dc, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5e55b293], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

        // Arrange and Act
        emailService.gerarNovaSenha();
    }
}
