package sync.spctrum.apispring.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message) {
        super("Recurso não encontrado. " + message);
    }
}
