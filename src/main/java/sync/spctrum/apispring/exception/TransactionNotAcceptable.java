package sync.spctrum.apispring.exception;

public class TransactionNotAcceptable extends RuntimeException{

    public TransactionNotAcceptable(String obj) {
        super(obj);
    }
}
