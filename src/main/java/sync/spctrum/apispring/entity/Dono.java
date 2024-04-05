package sync.spctrum.apispring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Dono.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dono extends Pessoa{
    private String cnpj;
    private String certificacao;
    private String cref;
    private String academia;
}
