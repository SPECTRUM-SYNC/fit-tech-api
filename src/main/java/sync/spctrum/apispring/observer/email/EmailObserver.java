package sync.spctrum.apispring.observer.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.observer.Observer;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.email.EmailService;
import sync.spctrum.apispring.service.usuario.UsuarioService;

public class EmailObserver implements Observer {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    public EmailObserver(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, EmailService emailService, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.usuarioService = usuarioService;
    }

    @Override
    public void atualizar(String email) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não encontado."));

        // Gerar nova senha e criptografá-la
        String novaSenha = usuarioService.gerarNovaSenha();
        String senhaCriptografada = passwordEncoder.encode(novaSenha);
        usuario.setSenha(senhaCriptografada);
        usuarioRepository.save(usuario);

        // Enviar email de redefinição de senha com a nova senha
        emailService.enviarEmailRedefinicaoSenha(email, novaSenha);
    }
}