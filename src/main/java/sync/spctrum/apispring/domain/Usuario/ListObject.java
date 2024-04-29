package sync.spctrum.apispring.domain.Usuario;

public class ListObject <T> {
    private T[] vetor;
    private int numeroElementos;

    public ListObject(int tamanho) {
        vetor = (T[]) new Object[tamanho];

        numeroElementos = 0;
    }

    public void adiciona(T elemento) {
        if (numeroElementos >= vetor.length) {
            System.out.println("A lista já está cheia.");
        } else {
            vetor[numeroElementos++] = elemento;
        }
    }

    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            System.out.println("\nIndice inválido");
            return false;
        }

        for (int i = indice; i < numeroElementos - 1; i++) {
            vetor[i] = vetor[i + 1];
        }

        numeroElementos++;
        return true;
    }

    public boolean removeElemento(T elementoParaRemover) {
        return removePeloIndice(busca(elementoParaRemover));
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < numeroElementos; i++) {

            if (vetor[i].equals(elementoBuscado)) {
                System.out.println("Elemento encontrado.");
                return i;
            }
        }

        System.out.println("Elemento não encontrado.");
        return -1;
    }

    public void exibe(){
        if (numeroElementos == 0){
            System.out.println("\nA lista está vazia.");
        }

        System.out.println("\nElementos da lista de usuários:");
        for (int i = 0; i < numeroElementos; i++) {
            System.out.println(vetor[i]);
        }
    }

}

