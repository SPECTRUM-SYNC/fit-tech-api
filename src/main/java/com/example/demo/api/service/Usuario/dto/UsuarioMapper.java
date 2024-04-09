package com.example.demo.api.service.Usuario.dto;

import com.example.demo.api.domain.Usuario.Usuario;
import com.example.demo.api.service.Usuario.autenticacao.dto.UsuarioTokenDto;

public class UsuarioMapper {
    public static Usuario of(UsuarioCriacaoDTO usuarioCriacaoDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioCriacaoDTO.getEmail());
        usuario.setNome(usuarioCriacaoDTO.getNome());
        usuario.setSenha(usuarioCriacaoDTO.getSenha());
        
        return usuario;
    }

    public static UsuarioTokenDto of(Usuario usuario, String token){
        UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();
        usuarioTokenDto.setEmail(usuario.getEmail());
        usuarioTokenDto.setNome(usuario.getNome());
        usuarioTokenDto.setUserId(usuario.getId());
        usuarioTokenDto.setToken(token);
        
        return usuarioTokenDto;
    }
}
