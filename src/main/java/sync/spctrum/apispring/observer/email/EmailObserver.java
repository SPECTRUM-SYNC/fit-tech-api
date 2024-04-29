package sync.spctrum.apispring.observer.email;

import sync.spctrum.apispring.observer.Observer;
import sync.spctrum.apispring.domain.Usuario.Usuario;
import sync.spctrum.apispring.service.email.EmailService;

public class EmailObserver implements Observer {

    private EmailService emailService;

    public EmailObserver(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void atualizar(String email) {
        // Lógica para enviar o e-mail de redefinição de senha
        Usuario usuario = new Usuario();

        String assunto = "Redefinição de Senha";
        String corpo = "Olá, você solicitou a redefinição de senha. " +
                "Clique no link abaixo para redefinir sua senha.";
        String nome = usuario.getNome();
        emailService.enviarEmail(email, nome);
    }
}