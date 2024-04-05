package sync.spctrum.apispring.exception.Modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * Modelo personalizado criado para representar uma excessão HTTP
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss'Z'", timezone = "GMT")
    /**
     * horario do ocorrido
     */
    private Instant timestamp;
    /**
     * Status HTTP
     */
    private Integer status;
    /**
     * Erro
     */
    private String error;
    /**
     * Descrição do erro
     */
    private String message;
    /**
     * Localização do arquivo
     */
    private String path;
}
