package com.example.demo.domain.Usuario;

import java.time.LocalDate;

import com.example.demo.domain.Pessoa.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String senha;
    private String cpf = "cpf";
    private LocalDate dataNascimento = LocalDate.now();
    private String genero = "genero";
    private Double peso = 0.0;
    private String nivelCondicao = "nivelCondicao";
    private Boolean contaAtiva = true;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    public Usuario(int id, String nome, String email, String senha, LocalDate dataNascimento, String genero,
            Double peso, String nivelCondicao, Boolean contaAtiva) {
        super(id, nome, email, senha);
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.nivelCondicao = nivelCondicao;
        this.contaAtiva = contaAtiva;
    }
    public Usuario() {
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNivelCondicao() {
        return nivelCondicao;
    }

    public void setNivelCondicao(String nivelCondicao) {
        this.nivelCondicao = nivelCondicao;
    }

    public Boolean getContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(Boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
