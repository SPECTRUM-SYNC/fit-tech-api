package sync.spctrum.apispring.domain.Treino;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDate dataTreino;
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;
}
