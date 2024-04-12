package sync.spctrum.apispring.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(Object obj) {
        super("Recurso não encontrado. ID: " + obj);
    }
}
