package sync.spctrum.apispring.domain.Objetivo;

import jakarta.persistence.*;
import lombok.*;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Objetivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String objetivo;

    @OneToMany(mappedBy="objetivo", fetch = FetchType.EAGER)
    private Usuario usuario;

}
