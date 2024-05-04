package sync.spctrum.apispring.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;

@Service
public class EmailService {

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    private final UsuarioRepository usuarioRepository;

    public EmailService(PasswordEncoder passwordEncoder, JavaMailSender javaMailSender, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.usuarioRepository = usuarioRepository;
    }

    public void enviarEmail(String para, String nome) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            Usuario user = usuarioRepository.findByEmail(para).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%¨&*()_+-={`^}:><.,/?|";
            String novaSenha = RandomStringUtils.random(10, caracteres);
            String senhaCriptografada = passwordEncoder.encode(novaSenha);
            user.setSenha(senhaCriptografada);
            usuarioRepository.save(user);

            helper.setTo(para);
            helper.setSubject("Redefinição de Senha");
            helper.setText(
                    "Olá " + nome + "," +
                            "<br /><br />Você solicitou uma redefinição de senha para sua conta" +
                            "<br />Sua senha foi redefinida: " + novaSenha +
                            "<br /><br />Lembre-se, nunca compartilhe sua senha com ninguém!" +
                            "<br/><br>" +
                            "Obrigado! <br/>" +
                            "Equipe de Suporte", true
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);
    }
}
