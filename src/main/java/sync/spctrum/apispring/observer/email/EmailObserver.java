package sync.spctrum.apispring.observer.email;

import sync.spctrum.apispring.Observer.Observer;
import sync.spctrum.apispring.service.email.EmailService;

public class EmailObserver implements Observer {

    private EmailService emailService;

    public EmailObserver(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void atualizar(String email) {
        // Lógica para enviar o e-mail de redefinição de senha
        String assunto = "Redefinição de Senha";
        String corpo = "Olá, você solicitou a redefinição de senha. " +
                "Clique no link abaixo para redefinir sua senha.";
        emailService.enviarEmail(email, assunto, corpo);
    }
}