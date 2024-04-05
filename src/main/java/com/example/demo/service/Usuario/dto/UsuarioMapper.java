package com.example.demo.service.Usuario.dto;

import com.example.demo.domain.Usuario.Usuario;

public class UsuarioMapper {
    public static Usuario of(UsuarioCriacaoDTO usuarioCriacaoDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioCriacaoDTO.getEmail());
        usuario.setNome(usuarioCriacaoDTO.getNome());
        usuario.setSenha(usuarioCriacaoDTO.getSenha());
        
        return usuario;
    }
}
