package sync.spctrum.apispring.service.receita;

import com.google.gson.Gson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Receita.Receita;
import sync.spctrum.apispring.domain.Receita.repository.ReceitaRepository;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.exception.ResourceNotFound;
import sync.spctrum.apispring.service.dallE.ImageGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ReceitaService.class, Gson.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class ReceitaServiceDiffblueTest {

    @MockBean
    private ImageGenerator imageGenerator;

    @MockBean
    private ReceitaRepository receitaRepository;

    @MockBean
    private ReceitaService receitaService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    /**
     * Method under test: {@link ReceitaService#init()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInit() {

        // Arrange and Act
        receitaService.init();
    }

    /**
     * Method under test: {@link ReceitaService#desserializarReceita(String)}
     */
    @Test
    void testDesserializarReceita() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertNull(
                (new ReceitaService(usuarioRepository, receitaRepository, gson, new ImageGenerator(mock(RestTemplate.class))))
                        .desserializarReceita(""));
    }

    /**
     * Method under test: {@link ReceitaService#desserializarReceita(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDesserializarReceita2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@6fda7d2 testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass366, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@48779f01 key = [@org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        // Arrange and Act
        receitaService.desserializarReceita("Json");
    }

    /**
     * Method under test: {@link ReceitaService#desserializarListaReceitas(String)}
     */
    @Test
    void testDesserializarListaReceitas() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertNull(
                (new ReceitaService(usuarioRepository, receitaRepository, gson, new ImageGenerator(mock(RestTemplate.class))))
                        .desserializarListaReceitas(null));
    }

    /**
     * Method under test: {@link ReceitaService#desserializarListaReceitas(String)}
     */
    @Test
    void testDesserializarListaReceitas2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertNull(
                (new ReceitaService(usuarioRepository, receitaRepository, gson, new ImageGenerator(mock(RestTemplate.class))))
                        .desserializarListaReceitas(""));
    }

    /**
     * Method under test: {@link ReceitaService#desserializarListaReceitas(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDesserializarListaReceitas3() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@54e213fa testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass188, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@e35595a key = [@org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        // Arrange and Act
        receitaService.desserializarListaReceitas("Json");
    }

    /**
     * Method under test:
     * {@link ReceitaService#desserializarListaReceitas(String, Long)}
     */
    @Test
    void testDesserializarListaReceitas4() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> (new ReceitaService(usuarioRepository, receitaRepository, gson,
                new ImageGenerator(mock(RestTemplate.class)))).desserializarListaReceitas("Json", 1L));
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test:
     * {@link ReceitaService#desserializarListaReceitas(String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDesserializarListaReceitas5() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@33d1b9d5 testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass345, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@4760df5a key = [@org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        // Arrange and Act
        receitaService.desserializarListaReceitas("Json", 1L);
    }

    /**
     * Method under test:
     * {@link ReceitaService#desserializarReceitaExtra(String, Long)}
     */
    @Test
    void testDesserializarReceitaExtra() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> (new ReceitaService(usuarioRepository, receitaRepository, gson,
                new ImageGenerator(mock(RestTemplate.class)))).desserializarReceitaExtra("Json", 1L));
        verify(usuarioRepository).findById(eq(1L));
    }

    /**
     * Method under test:
     * {@link ReceitaService#desserializarReceitaExtra(String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDesserializarReceitaExtra2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@189207f testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass523, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@3e6ad74e key = [@org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        // Arrange and Act
        receitaService.desserializarReceitaExtra("Json", 1L);
    }

    /**
     * Method under test: {@link ReceitaService#cadastrarImage(Receita)}
     */
    @Test
    void testCadastrarImage() throws IOException {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        Gson gson = new Gson();
        ReceitaService receitaService = new ReceitaService(usuarioRepository, receitaRepository, gson,
                new ImageGenerator(mock(RestTemplate.class)));
        Receita receita = mock(Receita.class);
        when(receita.getNome()).thenThrow(new ResourceNotFound("Not all who wander are lost"));

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> receitaService.cadastrarImage(receita));
        verify(receita).getNome();
    }

    /**
     * Method under test: {@link ReceitaService#cadastrarImage(Receita)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCadastrarImage2() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@6accdc9d testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass1, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@13a454d0 key = [@org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        Receita receita = new Receita();
        receita.setAcucar("Acucar");
        receita.setCalorias("Calorias");
        receita.setCarboidratos("Carboidratos");
        receita.setDataCriacao(LocalDate.of(1970, 1, 1));
        receita.setGorduras("Gorduras");
        receita.setId(1L);
        receita.setImage("Image");
        receita.setIngredientes(new String[]{"Ingredientes"});
        receita.setModoPreparo("Modo Preparo");
        receita.setNome("Nome");
        receita.setProteina("Proteina");
        receita.setQtdSelecionada(1);
        receita.setTempoPreparo("Tempo Preparo");
        receita.setTipo("Tipo");
        receita.setUsuario(usuario2);

        // Act
        receitaService.cadastrarImage(receita);
    }

    /**
     * Method under test: {@link ReceitaService#findByReceitasWhereUsuarioId(Long)}
     */
    @Test
    void testFindByReceitasWhereUsuarioId() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        ArrayList<Receita> receitaList = new ArrayList<>();
        when(receitaRepository.findAllByUsuario_IdAndDataCriacao(Mockito.<Long>any(), Mockito.<LocalDate>any()))
                .thenReturn(receitaList);
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Gson gson = new Gson();

        // Act
        List<Receita> actualFindByReceitasWhereUsuarioIdResult = (new ReceitaService(usuarioRepository, receitaRepository,
                gson, new ImageGenerator(mock(RestTemplate.class)))).findByReceitasWhereUsuarioId(1L);

        // Assert
        verify(receitaRepository).findAllByUsuario_IdAndDataCriacao(eq(1L), isA(LocalDate.class));
        assertTrue(actualFindByReceitasWhereUsuarioIdResult.isEmpty());
        assertSame(receitaList, actualFindByReceitasWhereUsuarioIdResult);
    }

    /**
     * Method under test: {@link ReceitaService#findByReceitasWhereUsuarioId(Long)}
     */
    @Test
    void testFindByReceitasWhereUsuarioId2() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        ReceitaRepository receitaRepository = mock(ReceitaRepository.class);
        when(receitaRepository.findAllByUsuario_IdAndDataCriacao(Mockito.<Long>any(), Mockito.<LocalDate>any()))
                .thenThrow(new ResourceNotFound("Not all who wander are lost"));
        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        Gson gson = new Gson();

        // Act and Assert
        assertThrows(ResourceNotFound.class, () -> (new ReceitaService(usuarioRepository, receitaRepository, gson,
                new ImageGenerator(mock(RestTemplate.class)))).findByReceitasWhereUsuarioId(1L));
        verify(receitaRepository).findAllByUsuario_IdAndDataCriacao(eq(1L), isA(LocalDate.class));
    }

    /**
     * Method under test: {@link ReceitaService#findByReceitasWhereUsuarioId(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByReceitasWhereUsuarioId3() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   com.diffblue.fuzztest.shared.proxy.BeanInstantiationException: Could not instantiate bean: receitaService defined in null
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   java.lang.IllegalStateException: Failed to load ApplicationContext for [MergedContextConfiguration@525470ce testClass = sync.spctrum.apispring.service.receita.DiffblueFakeClass544, locations = [], classes = [sync.spctrum.apispring.service.receita.ReceitaService, com.google.gson.Gson], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [[ImportsContextCustomizer@1e42c6be key = [@org.springframework.context.annotation.PropertySource(name="", factory=org.springframework.core.io.support.PropertySourceFactory.class, ignoreResourceNotFound=false, encoding="", value=/* Warning type mismatch! "java.lang.String[classpath:application-test.properties]" */), @org.springframework.boot.context.properties.EnableConfigurationProperties({}), @org.springframework.context.annotation.Import(value={org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.class}), @org.springframework.test.context.ContextConfiguration(classes={sync.spctrum.apispring.service.receita.ReceitaService.class, com.google.gson.Gson.class}, inheritInitializers=true, inheritLocations=true, initializers={}, loader=org.springframework.test.context.ContextLoader.class, locations={}, name="", value={})]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@7643a675, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@7059d579, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@f797fad7, org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@778b5ca7], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:180)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
        //       at java.base/java.util.Optional.map(Optional.java:260)
        //   org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'receitaService': Invocation of init method failed
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:222)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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
        //   java.lang.IllegalArgumentException: Invalid connection string.
        //       at com.azure.storage.common.implementation.connectionstring.ConnectionSettings.fromConnectionString(ConnectionSettings.java:81)
        //       at com.azure.storage.common.implementation.connectionstring.StorageConnectionString.create(StorageConnectionString.java:105)
        //       at com.azure.storage.blob.BlobServiceClientBuilder.connectionString(BlobServiceClientBuilder.java:323)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.init(ReceitaService.java:61)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMethod.invoke(InitDestroyAnnotationBeanPostProcessor.java:457)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:401)
        //       at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:219)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:422)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778)
        //       at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
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

        // Arrange and Act
        receitaService.findByReceitasWhereUsuarioId(1L);
    }
}
