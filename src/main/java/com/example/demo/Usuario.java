package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Usuario extends Pessoa{

    //    private String cpf;
    private LocalDate dataNascimento;
    private String genero;
    private Double peso;
    private String nivelCondicao;
    private Boolean contaAtiva;

/*
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

 */

    public Usuario(int id, String nome, String email, String senha, LocalDate dataNascimento, String genero, Double peso, String nivelCondicao, Boolean contaAtiva) {
        super(id, nome, email, senha);
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.peso = peso;
        this.nivelCondicao = nivelCondicao;
        this.contaAtiva = contaAtiva;
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
}
