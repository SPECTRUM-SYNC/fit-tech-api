package sync.spctrum.apispring.entity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.entity.Usuario;
import sync.spctrum.apispring.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


/**
 * The type Population.
 */
@Configuration
public class Population implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void run(String... args) throws Exception {

        Usuario m1 = new Usuario(null, "Winycios", "winycios@gmail.com", "Madalena13#", LocalDate.of(2008, 2, 15), true, 64.5, "Basico", true);
        Usuario m2 = new Usuario(null, "Ana", "Ana@gmail.com", "Madalena15#", LocalDate.of(2007, 5, 13), false, 70.8, "Basico", true);
        Usuario m3 = new Usuario(null, "Gustavo", "Gustavo@gmail.com", "Madalena1#", LocalDate.of(2005, 1, 10), true, 100.0, "Basico", true);

        List<Usuario> marcas = Arrays.asList(m1, m2, m3);
        usuarioRepository.saveAll(marcas);
    }
}
