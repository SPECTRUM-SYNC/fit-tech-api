package sync.spctrum.apispring.domain.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The type Pessoa.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    /**
     * Gerar relatorio.
     */
    public void gerarRelatorio() {}
}
