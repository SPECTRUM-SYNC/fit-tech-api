package sync.spctrum.apispring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.usuario.dto.modelMapper.UsuarioMapper;
import sync.spctrum.apispring.service.usuario.dto.usuario.UsuarioCreateDTO;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Population implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) {

        UsuarioCreateDTO m1 = new UsuarioCreateDTO("Winycios", "winycios@gmail.com", "Madalena13#", LocalDate.of(2008, 2, 15), true, 64.5, "Basico", new ObjetivoCreateDTO("oi"));
        UsuarioCreateDTO m2 = new UsuarioCreateDTO("Ana", "Ana@gmail.com", "Madalena15#", LocalDate.of(2007, 5, 13), false, 70.8, "Basico", new ObjetivoCreateDTO("oi"));
        UsuarioCreateDTO m3 = new UsuarioCreateDTO("Gustavo", "Gustavo@gmail.com", "Madalena1#", LocalDate.of(2005, 1, 10), true, 100.0, "Basico", new ObjetivoCreateDTO("oi"));

        List<Usuario> usuarios = Arrays.asList(UsuarioMapper.toEntity(m1), UsuarioMapper.toEntity(m2),UsuarioMapper.toEntity(m3));
        usuarios.get(0).setContaAtiva(true);
        usuarios.get(1).setContaAtiva(true);
        usuarios.get(2).setContaAtiva(true);

        usuarioRepository.saveAll(usuarios);
    }
}
