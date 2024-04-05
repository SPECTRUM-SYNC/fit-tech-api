package sync.spctrum.apispring.exception;

/**
 * Exceção personalizada para representar problemas relacionados a rcursos duplicados
 */
public class ResourceDuplicate extends RuntimeException {

    /**
     * Cria uma nova instância de ResourceDuplicate com uma mensagem descritiva.
     *
     * @param obj valor ou ID passado.
     */
    public ResourceDuplicate(Object obj) {
        super("Usuario já existente: Nome: " + obj);
    }
}
