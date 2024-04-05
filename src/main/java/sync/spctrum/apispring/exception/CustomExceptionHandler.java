package sync.spctrum.apispring.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sync.spctrum.apispring.exception.Modelo.ModeloError;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Custom exception handler.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handle validation exceptions response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
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

    // Excessão para recurso não encontrado
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ModeloError> resourceNotFound(ResourceNotFound e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ModeloError err = new ModeloError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // Excessão para recurso duplicado
    @ExceptionHandler(ResourceDuplicate.class)
    public ResponseEntity<ModeloError> resourceDuplicte(ResourceDuplicate e, HttpServletRequest request) {
        String error = "Recurso já existente";
        HttpStatus status = HttpStatus.CONFLICT;
        ModeloError err = new ModeloError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
