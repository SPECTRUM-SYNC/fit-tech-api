package sync.spctrum.apispring.domain.Usuario.repository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void test() {
        System.out.println(usuarioRepository.findAll());
    }

    /**
     * Method under test: {@link UsuarioRepository#findByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByEmail() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: interface sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@1916ac9c testClass = sync.spctrum.apispring.domain.Usuario.repository.DiffblueFakeClass1533, locations = [], classes = [sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@18550e1b, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@642442f7, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5d9231ad], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'usuarioRepository': Failed to instantiate [sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository]: Specified class is an interface
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1317)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1202)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:562)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:962)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.BeanInstantiationException: Failed to instantiate [sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository]: Specified class is an interface
        //       at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:77)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1311)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1202)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:562)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326)
        //       at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324)
        //       at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
        //       at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975)
        //       at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:962)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:221)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:110)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:212)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

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
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(objetivo2);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");

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
        usuario4.setObjetivo(new Objetivo());
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(-1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(-1);
        usuario5.setContaAtiva(false);
        usuario5.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("john.smith@example.org");
        usuario5.setGenero("42");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(2L);
        usuario5.setImg("42");
        usuario5.setMeta("42");
        usuario5.setNivelCondicao("42");
        usuario5.setNome("42");
        usuario5.setObjetivo(objetivo3);
        usuario5.setPeso(0.5d);
        usuario5.setPontuacao(-1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.preUpdate();
        usuario6.setAltura(-1);
        usuario6.setContaAtiva(false);
        usuario6.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario6.setEmail("john.smith@example.org");
        usuario6.setGenero("42");
        usuario6.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario6.setImg("42");
        usuario6.setMeta("42");
        usuario6.setNivelCondicao("42");
        usuario6.setNome("42");
        usuario6.setObjetivo(objetivo4);
        usuario6.setPeso(0.5d);
        usuario6.setPontuacao(-1);
        usuario6.setReceitas(new ArrayList<>());
        usuario6.setSenha("42");
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario6);

        // Act
        usuarioRepository.findByEmail("jane.doe@example.org");
    }

    /**
     * Method under test: {@link UsuarioRepository#topUsuarios()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTopUsuarios() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@50041ec1 testClass = sync.spctrum.apispring.domain.Usuario.repository.DiffblueFakeClass1921, locations = [], classes = [sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@18550e1b, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@642442f7, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5d9231ad], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

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
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(objetivo2);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");

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
        usuario4.setObjetivo(new Objetivo());
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(-1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(-1);
        usuario5.setContaAtiva(false);
        usuario5.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("john.smith@example.org");
        usuario5.setGenero("42");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(2L);
        usuario5.setImg("42");
        usuario5.setMeta("42");
        usuario5.setNivelCondicao("42");
        usuario5.setNome("42");
        usuario5.setObjetivo(objetivo3);
        usuario5.setPeso(0.5d);
        usuario5.setPontuacao(-1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.preUpdate();
        usuario6.setAltura(-1);
        usuario6.setContaAtiva(false);
        usuario6.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario6.setEmail("john.smith@example.org");
        usuario6.setGenero("42");
        usuario6.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario6.setImg("42");
        usuario6.setMeta("42");
        usuario6.setNivelCondicao("42");
        usuario6.setNome("42");
        usuario6.setObjetivo(objetivo4);
        usuario6.setPeso(0.5d);
        usuario6.setPontuacao(-1);
        usuario6.setReceitas(new ArrayList<>());
        usuario6.setSenha("42");
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario6);

        // Act
        usuarioRepository.topUsuarios();
    }

    /**
     * Method under test:
     * {@link UsuarioRepository#findByEmailEqualsIgnoreCase(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByEmailEqualsIgnoreCase() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@e074423 testClass = sync.spctrum.apispring.domain.Usuario.repository.DiffblueFakeClass1727, locations = [], classes = [sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@18550e1b, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@642442f7, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@5d9231ad], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   See https://diff.blue/R026 to resolve this issue.

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
        usuario3.setImg("Img");
        usuario3.setMeta("Meta");
        usuario3.setNivelCondicao("Nivel Condicao");
        usuario3.setNome("Nome");
        usuario3.setObjetivo(objetivo2);
        usuario3.setPeso(10.0d);
        usuario3.setPontuacao(1);
        usuario3.setReceitas(new ArrayList<>());
        usuario3.setSenha("Senha");

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
        usuario4.setObjetivo(new Objetivo());
        usuario4.setPeso(0.5d);
        usuario4.setPontuacao(-1);
        usuario4.setReceitas(new ArrayList<>());
        usuario4.setSenha("42");

        Objetivo objetivo3 = new Objetivo();
        objetivo3.setId(2L);
        objetivo3.setObjetivo("42");
        objetivo3.setUsuario(usuario4);

        Usuario usuario5 = new Usuario();
        usuario5.preUpdate();
        usuario5.setAltura(-1);
        usuario5.setContaAtiva(false);
        usuario5.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario5.setEmail("john.smith@example.org");
        usuario5.setGenero("42");
        usuario5.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario5.setId(2L);
        usuario5.setImg("42");
        usuario5.setMeta("42");
        usuario5.setNivelCondicao("42");
        usuario5.setNome("42");
        usuario5.setObjetivo(objetivo3);
        usuario5.setPeso(0.5d);
        usuario5.setPontuacao(-1);
        usuario5.setReceitas(new ArrayList<>());
        usuario5.setSenha("42");

        Objetivo objetivo4 = new Objetivo();
        objetivo4.setId(2L);
        objetivo4.setObjetivo("42");
        objetivo4.setUsuario(usuario5);

        Usuario usuario6 = new Usuario();
        usuario6.preUpdate();
        usuario6.setAltura(-1);
        usuario6.setContaAtiva(false);
        usuario6.setDataNascimento(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        usuario6.setEmail("john.smith@example.org");
        usuario6.setGenero("42");
        usuario6.setHoraSenhaAtualizacao(LocalDate.of(1970, 1, 1).atStartOfDay());
        usuario6.setImg("42");
        usuario6.setMeta("42");
        usuario6.setNivelCondicao("42");
        usuario6.setNome("42");
        usuario6.setObjetivo(objetivo4);
        usuario6.setPeso(0.5d);
        usuario6.setPontuacao(-1);
        usuario6.setReceitas(new ArrayList<>());
        usuario6.setSenha("42");
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario6);

        // Act
        usuarioRepository.findByEmailEqualsIgnoreCase("jane.doe@example.org");
    }
}