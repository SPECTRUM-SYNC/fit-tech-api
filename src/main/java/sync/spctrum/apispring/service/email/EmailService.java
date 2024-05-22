package sync.spctrum.apispring.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.domain.Usuario.repository.UsuarioRepository;
import sync.spctrum.apispring.service.usuario.autenticacao.dto.UsuarioTokenDTO;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

@Service
@EnableScheduling
public class EmailService {

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    private final UsuarioRepository usuarioRepository;

    private final Deque<Usuario> resetQueue = new ArrayDeque<>(2);

    public EmailService(PasswordEncoder passwordEncoder, JavaMailSender javaMailSender, UsuarioRepository usuarioRepository, ConversionService conversionService) {
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
        this.usuarioRepository = usuarioRepository;
    }

    public void enviarEmailRedefinicaoSenha(String destinatario, String novaSenha) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            solicitarRedefinicaoSenha(destinatario);
            helper.setTo(destinatario);
            helper.setSubject("Redefinição de Senha");
            helper.setText(
                    "Olá " + destinatario + "," +
                            "<br /><br />Você solicitou uma redefinição de senha para sua conta" +
                            "<br />Sua senha foi redefinida: " + novaSenha +
                            "<br /><br />Lembre-se, nunca compartilhe sua senha com ninguém!" +
                            "<br/><br>" +
                            "Obrigado! <br/>" +
                            "Equipe de Suporte", true
            );
            removerPrimeiraSolicitacaoSenha();
        } catch (MessagingException | InterruptedException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    public void removerPrimeiraSolicitacaoSenha() throws InterruptedException {
        if (!resetQueue.isEmpty()){
            try {
                Thread.sleep(60000);
                resetQueue.removeFirst();
            } catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    public boolean solicitarRedefinicaoSenha(String email){
        if (!isPermitidoRedefinicaoSenha(email)){
            Usuario usuario = usuarioRepository.findByEmailEqualsIgnoreCase(email)
                    .orElseThrow(() -> new ResponseStatusException(404, "Email ainda não cadastrado", null));

            resetQueue.add(usuario);
            return true;

        }
        throw new ResponseStatusException(429, "Limite de solicitações excedido. Aguarde 1 minuto e tente novamente.", null);
    }

    public String gerarNovaSenha(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%¨&*()_+-={`^}:><.,/?|";
        return RandomStringUtils.random(10, caracteres);
    }

    private boolean isPermitidoRedefinicaoSenha(String email) {return resetQueue.size() == 2;}
}
