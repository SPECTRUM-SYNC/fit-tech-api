package sync.spctrum.apispring.domain.Objetivo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Objetivo implements Serializable {

    @Id
    @Column(name = "usuario_id")
    private Long id;
    private String objetivo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
