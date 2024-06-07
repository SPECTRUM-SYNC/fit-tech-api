package sync.spctrum.apispring.service.receita;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import com.google.gson.Gson;

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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

@ContextConfiguration(classes = {ReceitaService.class, Gson.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ReceitaServiceTest {
    @Autowired
    private ReceitaService receitaService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    /**
     * Method under test: {@link ReceitaService#desserializarReceita(String)}
     */
    @Test
    void testDesserializarReceita() {
        // Arrange, Act and Assert
        assertNull(receitaService.desserializarReceita(""));
    }

    /**
     * Method under test: {@link ReceitaService#desserializarListaReceitas(String)}
     */
    @Test
    void testDesserializarListaReceitas() {
        // Arrange, Act and Assert
        assertNull(receitaService.desserializarListaReceitas(""));
    }

    /**
     * Method under test:
     * {@link ReceitaService#desserializarListaReceitas(String, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDesserializarListaReceitas2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field private final java.time.LocalDate java.time.LocalDateTime.date accessible: module java.base does not "opens java.time" to unnamed module @161d6189
        //       at com.google.gson.internal.reflect.UnsafeReflectionAccessor.makeAccessible(UnsafeReflectionAccessor.java:44)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:159)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:102)
        //       at com.google.gson.Gson.getAdapter(Gson.java:458)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.createBoundField(ReflectiveTypeAdapterFactory.java:117)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:166)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:102)
        //       at com.google.gson.Gson.getAdapter(Gson.java:458)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.createBoundField(ReflectiveTypeAdapterFactory.java:117)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.getBoundFields(ReflectiveTypeAdapterFactory.java:166)
        //       at com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(ReflectiveTypeAdapterFactory.java:102)
        //       at com.google.gson.Gson.getAdapter(Gson.java:458)
        //       at com.google.gson.internal.bind.CollectionTypeAdapterFactory.create(CollectionTypeAdapterFactory.java:53)
        //       at com.google.gson.Gson.getAdapter(Gson.java:458)
        //       at com.google.gson.Gson.fromJson(Gson.java:931)
        //       at com.google.gson.Gson.fromJson(Gson.java:897)
        //       at com.google.gson.Gson.fromJson(Gson.java:846)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.desserializarListaReceitas(ReceitaService.java:41)
        //       at sync.spctrum.apispring.service.receita.ReceitaService.desserializarListaReceitas(ReceitaService.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

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
        Optional<Usuario> ofResult = Optional.of(usuario2);
        when(usuarioRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        receitaService.desserializarListaReceitas("Json", 1L);
    }
}
