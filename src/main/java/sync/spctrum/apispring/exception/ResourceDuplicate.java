package sync.spctrum.apispring.exception;

public class ResourceDuplicate extends RuntimeException {
    public ResourceDuplicate(Object obj) {
        super("Usuario já existente: Nome: " + obj);
    }
}
