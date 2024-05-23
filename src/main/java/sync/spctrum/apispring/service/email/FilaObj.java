package sync.spctrum.apispring.service.email;

import sync.spctrum.apispring.domain.Usuario.Usuario;

public class FilaObj {
    private int tamanho;
    private Usuario[] fila;

    public FilaObj(int capacidade) {
        this.fila = new Usuario[capacidade];
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        if (fila[0] == null){
            return true;
        }
        return false;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void insert(Usuario usuario) {
        fila[tamanho] = usuario;
        tamanho++;
    }

    public Usuario poll() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return null;
        } else {
            Usuario primeiroElemento = fila[0];
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
            return primeiroElemento;
        }
    }

}
