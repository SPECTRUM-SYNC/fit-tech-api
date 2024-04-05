package com.example.demo.service.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Usuario.Usuario;
import com.example.demo.domain.Usuario.reposository.UsuarioRepository;
import com.example.demo.service.Usuario.dto.UsuarioCriacaoDTO;
import com.example.demo.service.Usuario.dto.UsuarioMapper;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(UsuarioCriacaoDTO usuarioCriacaoDTO){
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDTO);
        this.usuarioRepository.save(novoUsuario);
    }
}
