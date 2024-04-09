package com.example.demo.api.service.Usuario.autenticacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.api.domain.Usuario.Usuario;
import com.example.demo.api.domain.Usuario.reposository.UsuarioRepository;
import com.example.demo.api.service.Usuario.autenticacao.dto.UsuarioDetalhesDto;

@Service
public class AutenticacaoService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(username);

        if(usuarioOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("%s não encontrado", username));
        }

        return new UsuarioDetalhesDto(usuarioOpt.get());
    }
}
