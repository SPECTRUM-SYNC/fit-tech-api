package sync.spctrum.apispring.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sync.spctrum.apispring.exception.modelo.ModeloError;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ModeloError> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });
        ModeloError err = new ModeloError(Instant.now(), 401, "Erro de validação", errors.toString(),
                request.getRequestURI());
        return ResponseEntity.status(401).body(err);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ModeloError> resourceNotFound(ResourceNotFound e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ModeloError err = new ModeloError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceDuplicate.class)
    public ResponseEntity<ModeloError> resourceDuplicte(ResourceDuplicate e, HttpServletRequest request) {
        String error = "Recurso já existente";
        HttpStatus status = HttpStatus.CONFLICT;
        ModeloError err = new ModeloError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(TransactionNotAcceptable.class)
    public ResponseEntity<ModeloError> transactionNotAcceptable(TransactionNotAcceptable e, HttpServletRequest request) {
        String error = "Transação não aceita";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ModeloError err = new ModeloError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
