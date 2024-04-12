package sync.spctrum.apispring.domain.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public void gerarRelatorio() {}
}
