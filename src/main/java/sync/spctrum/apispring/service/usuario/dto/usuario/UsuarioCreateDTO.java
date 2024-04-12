package sync.spctrum.apispring.service.usuario.dto.usuario;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class UsuarioCreateDTO {


    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Email não pode ser nulo")
    @Email
    private String email;

    @NotBlank(message = "Senha não pode ser nulo")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,20}$", message = "Senha invalida")
    private String senha;

    @Past
    private LocalDate dataNascimento;

    private Boolean genero;

    @DecimalMax(value = "200.0")
    @DecimalMin(value = "40.0")
    private Double peso;

    @NotBlank(message = "É preciso descrever o nivel de condição do usuário")
    private String nivelCondicao;

    private Boolean contaAtiva = true;

    @ManyToOne
    @JoinColumn(name="objetivo_id", nullable=false)
    private Objetivo objetivo;

    public UsuarioCreateDTO(String nome, String email, String senha, LocalDate dataNascimento, Boolean genero, Double peso, String nivelCondicao, Objetivo objetivo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.nivelCondicao = nivelCondicao;
        this.objetivo = objetivo;
    }
}
