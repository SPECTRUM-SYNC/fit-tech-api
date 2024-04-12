package sync.spctrum.apispring.domain.Usuario;

import jakarta.persistence.*;
import lombok.*;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Boolean genero;
    private Double peso;
    private String nivelCondicao;
    private Boolean contaAtiva;

    @ManyToOne()
    @JoinColumn(name="objetivo_id", nullable=false)
    private Objetivo objetivo;
}
