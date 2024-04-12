package sync.spctrum.apispring.service.usuario.dto.usuario;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.service.objetivo.dto.modelMapper.ObjetivoMapper;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;

import java.time.LocalDate;

@AllArgsConstructor
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
    private Objetivo objetivo;

    public UsuarioCreateDTO(String nome, String email, String senha, LocalDate dataNascimento, Boolean genero, Double peso, String nivelCondicao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.nivelCondicao = nivelCondicao;
    }

    public UsuarioCreateDTO(String nome, String email, String senha, LocalDate dataNascimento, Boolean genero, Double peso, String nivelCondicao, ObjetivoCreateDTO objetivo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.nivelCondicao = nivelCondicao;
        this.objetivo = ObjetivoMapper.toEntity(objetivo);
    }
}
