package sync.spctrum.apispring.domain.Dono;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Pessoa.Pessoa;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dono extends Pessoa {
    private String cnpj;
    private String certificacao;
    private String cref;
    private String academia;
}
