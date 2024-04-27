package sync.spctrum.apispring.service.email;

import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import sync.spctrum.apispring.domain.Usuario.Usuario;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmail(String para, String nome) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        Usuario usuario = new Usuario();

        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%¨&*()_+-={`^}:><.,/?|";
        String novaSenha = RandomStringUtils.random(10,caracteres);
        usuario.setSenha(novaSenha);

        try {
            helper.setTo(para);
            helper.setSubject("Redefinição de Senha");
            helper.setText(
                    "Olá "+nome+"," +
                    "<br /><br />Você solicitou uma redefinição de senha para sua conta" +
                    "<br />Sua senha foi redefinida: "+novaSenha+
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
