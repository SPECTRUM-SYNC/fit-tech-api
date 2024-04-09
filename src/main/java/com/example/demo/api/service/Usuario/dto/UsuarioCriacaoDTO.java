package com.example.demo.api.service.Usuario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioCriacaoDTO {
    @Size(min = 3, max = 10)
    private String nome;

    @Email
    @Schema(description = "Email do usuário", example = "Robertinho_top1valorant@gmail.com")
    private String email;

    @Size(min = 6, max = 20)
    private String senha;

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
