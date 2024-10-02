package sync.spctrum.apispring.service.usuario.autenticacao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {AutenticacaoService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AutenticacaoServiceTest {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    /**
     * Method under test: {@link AutenticacaoService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        when(usuarioRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = autenticacaoService.loadUserByUsername("janedoe");

        // Assert
        verify(usuarioRepository).findByEmail(eq("janedoe"));
        assertEquals("Senha", actualLoadUserByUsernameResult.getPassword());
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
    }

    /**
     * Method under test: {@link AutenticacaoService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // Arrange
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> autenticacaoService.loadUserByUsername("janedoe"));
        verify(usuarioRepository).findByEmail(eq("janedoe"));
    }

    /**
     * Method under test: {@link AutenticacaoService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        // Arrange
        when(usuarioRepository.findByEmail(Mockito.<String>any()))
                .thenThrow(new UsernameNotFoundException("usuario: %s nao encontrado"));

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> autenticacaoService.loadUserByUsername("janedoe"));
        verify(usuarioRepository).findByEmail(eq("janedoe"));
    }

    /**
     * Method under test: {@link AutenticacaoService#loadUserByGoogle(String)}
     */
    @Test
    void testLoadUserByGoogle() throws UsernameNotFoundException {
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
        when(usuarioRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByGoogleResult = autenticacaoService.loadUserByGoogle("janedoe");

        // Assert
        verify(usuarioRepository).findByEmail(eq("janedoe"));
        assertEquals("jane.doe@example.org", actualLoadUserByGoogleResult.getPassword());
    }

    /**
     * Method under test: {@link AutenticacaoService#loadUserByGoogle(String)}
     */
    @Test
    void testLoadUserByGoogle2() throws UsernameNotFoundException {
        // Arrange
        Optional<Usuario> emptyResult = Optional.empty();
        when(usuarioRepository.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> autenticacaoService.loadUserByGoogle("janedoe"));
        verify(usuarioRepository).findByEmail(eq("janedoe"));
    }

    /**
     * Method under test: {@link AutenticacaoService#loadUserByGoogle(String)}
     */
    @Test
    void testLoadUserByGoogle3() throws UsernameNotFoundException {
        // Arrange
        when(usuarioRepository.findByEmail(Mockito.<String>any()))
                .thenThrow(new UsernameNotFoundException("usuario: %s nao encontrado"));

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () -> autenticacaoService.loadUserByGoogle("janedoe"));
        verify(usuarioRepository).findByEmail(eq("janedoe"));
    }
}
