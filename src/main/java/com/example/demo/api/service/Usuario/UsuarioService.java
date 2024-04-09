package com.example.demo.api.service.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.example.demo.api.configuration.jwt.GerenciadorTokenJwt;
import com.example.demo.api.domain.Usuario.Usuario;
import com.example.demo.api.domain.Usuario.reposository.UsuarioRepository;
import com.example.demo.api.service.Usuario.autenticacao.dto.UsuarioLoginDto;
import com.example.demo.api.service.Usuario.autenticacao.dto.UsuarioTokenDto;
import com.example.demo.api.service.Usuario.dto.UsuarioCriacaoDTO;
import com.example.demo.api.service.Usuario.dto.UsuarioMapper;



@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticatedAuthorizationManager authenticatedAuthorizationManager;

    public void criar(UsuarioCriacaoDTO usuarioCriacaoDTO){
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDTO);
        String senha = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senha);
        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto){
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
            usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication<Object> authentication = this.authenticatedAuthorizationManager.authenticated(credentials);
        
        Usuario usuarioAutenticacao = usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);
        
        return UsuarioMapper.of(usuarioAutenticacao, token);
    

    }
}
