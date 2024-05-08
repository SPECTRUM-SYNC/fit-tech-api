package sync.spctrum.apispring.domain.HistoricoPeso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataPostagem;
    private Double peso;
    private Double pesoMeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
