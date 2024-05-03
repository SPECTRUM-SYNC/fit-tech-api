package sync.spctrum.apispring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class Population implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public Population(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        Usuario m1 = new Usuario();
        m1.setNome("Winycios");
        m1.setEmail("winycios@gmail.com");
        m1.setSenha(passwordEncoder.encode("Madalena13#"));
        m1.setMeta("Perder peso");
        m1.setDataNascimento(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneOffset.UTC).toInstant()));
        m1.setGenero("Homem");
        m1.setPeso(64.5);
        m1.setAltura(175);
        m1.setNivelCondicao("Basico");
        m1.setContaAtiva(true);
        m1.setPontuacao(10);
        m1.setObjetivo(new Objetivo(1L, "Ser forte", m1));

        Usuario m2 = new Usuario();
        m2.setNome("Ana");
        m2.setEmail("ana@gmail.com");
        m2.setSenha(passwordEncoder.encode("Madalena15#"));
        m2.setMeta("Perder peso");
        m1.setDataNascimento(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneOffset.UTC).toInstant()));
        m2.setGenero("Mulher");
        m2.setPeso(70.8);
        m2.setAltura(160);
        m2.setNivelCondicao("Basico");
        m2.setContaAtiva(false);
        m2.setPontuacao(3);
        m2.setObjetivo(new Objetivo(2L, "Ser Feliz", m2));

        Usuario m3 = new Usuario();
        m3.setNome("Gustavo");
        m3.setEmail("gustavo@gmail.com");
        m3.setSenha(passwordEncoder.encode("Madalena1#"));
        m3.setMeta("Ganhar massa muscular");
        m1.setDataNascimento(Date.from(LocalDate.of(2000, 10, 10).atStartOfDay(ZoneOffset.UTC).toInstant()));
        m3.setGenero("Homem");
        m3.setPeso(100.0);
        m3.setAltura(180);
        m3.setNivelCondicao("Basico");
        m3.setContaAtiva(true);
        m3.setPontuacao(1);
        m3.setObjetivo(new Objetivo(3L, "Pegar mulher", m3));

        usuarioRepository.saveAll(Arrays.asList(m1, m2, m3));
    }
}
