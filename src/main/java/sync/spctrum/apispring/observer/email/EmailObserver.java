package sync.spctrum.apispring.observer.email;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.observer.Observer;
import sync.spctrum.apispring.service.email.EmailService;
@EnableScheduling
public class EmailObserver implements Observer {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public EmailObserver(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public void atualizar(String email) {

        if(email == null) { return; }
        Usuario usuario = usuarioRepository.findByEmailEqualsIgnoreCase(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não encontado."));

        if(usuario == null) {return;}
        String novaSenha = emailService.gerarNovaSenha();
        String senhaCriptografada = passwordEncoder.encode(novaSenha);
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);

        emailService.enviarEmailRedefinicaoSenha(email, novaSenha);

    }
}