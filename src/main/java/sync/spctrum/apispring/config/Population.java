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
@Profile("dev")
public class Population implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    }
}
