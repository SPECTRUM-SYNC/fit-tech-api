package sync.spctrum.apispring.domain.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String img;
    private String meta;
    private Date dataNascimento;
    private String genero;
    private Double peso;
    private Integer altura;
    private String nivelCondicao;
    private Boolean contaAtiva;
    private int pontuacao;
    private LocalDateTime horaSenhaAtualizacao;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Objetivo objetivo;

    // personalizado
    public Usuario(String nome, String email, String senha, String img, String meta, Date dataNascimento, String genero, Double peso, Integer altura, String nivelCondicao, Boolean contaAtiva, int pontuacao, Objetivo objetivo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.img = img;
        this.meta = meta;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
        this.nivelCondicao = nivelCondicao;
        this.contaAtiva = contaAtiva;
        this.pontuacao = pontuacao;
        this.objetivo = objetivo;
    }

    @PreUpdate
    public void preUpdate(){
        this.horaSenhaAtualizacao = LocalDateTime.now();
    }
}