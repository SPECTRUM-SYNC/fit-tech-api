package sync.spctrum.apispring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import sync.spctrum.apispring.domain.HistoricoPeso.HistoricoPeso;
import sync.spctrum.apispring.domain.HistoricoPeso.Repository.HistoricoPesoRepository;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Configuration
@Profile("test")
public class Population implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    private final HistoricoPesoRepository historicoPesoRepository;

    private final PasswordEncoder passwordEncoder;

    public Population(UsuarioRepository usuarioRepository, HistoricoPesoRepository historicoPesoRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.historicoPesoRepository = historicoPesoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        Calendar calendario = Calendar.getInstance();

        Usuario m1 = new Usuario();

        calendario.set(2000, Calendar.SEPTEMBER, 13);
        Date dataUser = calendario.getTime();

        m1.setNome("Winycios");
        m1.setEmail("winycios@gmail.com");
        m1.setSenha(passwordEncoder.encode("Madalena13#"));
        m1.setMeta("PerderPeso");
        m1.setDataNascimento(dataUser);
        m1.setGenero("Homem");
        m1.setPeso(65.0);
        m1.setAltura(175);
        m1.setNivelCondicao("Basico");
        m1.setContaAtiva(true);
        m1.setPontuacao(10);
        m1.setObjetivo(new Objetivo(1L, "Ser forte", m1));

        calendario.set(2004, Calendar.AUGUST, 8);
        Date dataUser2 = calendario.getTime();

        Usuario m2 = new Usuario();
        m2.setNome("Ana");
        m2.setEmail("ana@gmail.com");
        m2.setSenha(passwordEncoder.encode("Madalena15#"));
        m2.setMeta("PerderPeso");
        m2.setDataNascimento(dataUser2);
        m2.setGenero("Mulher");
        m2.setPeso(70.8);
        m2.setAltura(160);
        m2.setNivelCondicao("Basico");
        m2.setContaAtiva(false);
        m2.setPontuacao(3);
        m2.setObjetivo(new Objetivo(2L, "Ser Feliz", m2));

        calendario.set(1995, Calendar.APRIL, 20);
        Date dataUser3 = calendario.getTime();

        Usuario m3 = new Usuario();
        m3.setNome("Gustavo");
        m3.setEmail("gustavo@gmail.com");
        m3.setSenha(passwordEncoder.encode("Madalena1#"));
        m3.setMeta("GanharMassa");
        m3.setDataNascimento(dataUser3);
        m3.setGenero("Homem");
        m3.setPeso(100.0);
        m3.setAltura(180);
        m3.setNivelCondicao("Basico");
        m3.setContaAtiva(true);
        m3.setPontuacao(1);
        m3.setObjetivo(new Objetivo(3L, "Pegar mulher", m3));

        usuarioRepository.saveAll(Arrays.asList(m1, m2, m3));


        HistoricoPeso hp1 = new HistoricoPeso(null, LocalDate.of(2021, Calendar.JUNE, 17), 50.0, 60.0, m1);

        HistoricoPeso hp2 = new HistoricoPeso(null, LocalDate.of(2021, Calendar.JUNE, 18), 60.0, 60.0, m1);

        HistoricoPeso hp3 = new HistoricoPeso(null, LocalDate.of(2021, Calendar.JUNE, 22), 62.0, 70.0, m1);

        HistoricoPeso hp4 = new HistoricoPeso(null, LocalDate.of(2021, Calendar.JUNE, 27), 62.0, 70.0, m1);

        historicoPesoRepository.saveAll(Arrays.asList(hp1, hp2, hp3, hp4));
    }
}
