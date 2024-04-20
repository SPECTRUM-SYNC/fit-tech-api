package sync.spctrum.apispring.exception;

public class ResourceDuplicate extends RuntimeException {
    public ResourceDuplicate(String obj) {
        super(obj);
    }
}
