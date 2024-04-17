package sync.spctrum.apispring.service;

import java.util.ArrayList;
import java.util.List;
import sync.spctrum.apispring.Observer.Observer;

public class UsuarioRedefinicaoSenha {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificarObservers(String email) {
        for (Observer observer : observers) {
            observer.atualizar(email);
        }
    }

    // Método que simula a redefinição de senha
    public void solicitarRedefinicaoSenha(String email) {
        // Lógica para redefinir a senha
        // ...
        // Notificar os observers (enviar e-mail)
        notificarObservers(email);
    }
}
