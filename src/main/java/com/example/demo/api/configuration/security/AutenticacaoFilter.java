package com.example.demo.api.configuration.security;

import com.example.demo.api.configuration.jwt.GerenciadorTokenJwt;
import com.example.demo.api.service.Usuario.autenticacao.AutenticacaoService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class AutenticacaoFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(AutenticacaoFilter.class.getName());
    private final AutenticacaoService autenticacaoService;
    
    private final GerenciadorTokenJwt jwtTokenManager;

    public AutenticacaoFilter(AutenticacaoService autenticacaoService, GerenciadorTokenJwt jwtTokenManager) {
        this.autenticacaoService = autenticacaoService;
        this.jwtTokenManager = jwtTokenManager;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String ussername = null;
        String jwtToken = null;

        String requestTokenHeader = request.getHeader("Authorization");

        if(Objects.nonNull(requestTokenHeader) &&  requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);

           // try {

            //}catch (ExpiredJwtException exe){
              //  LOGGER.info("[FALHA AUTENTICACAO] - Token expirado, usuario: {} - {}", exe.getClaims().getSubject(), exe.getMessage());
              //    LOGGER.trace("[FALHA AUTENTICACAO] - Token expirado, usuario: {} - {}", exe.getClaims().getSubject(), exe.getMessage());
            //}

            try {
                ussername = jwtTokenManager.getUsernameFromToken(jwtToken);
            } catch (ExpiredJwtException e) {
                LOGGER.warning("Token expirado");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            } catch (Exception e) {
                LOGGER.warning("Erro ao buscar o token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        if(ussername != null && SecurityContextHolder.getContext().getAuthentication() == null){
            addUsernameInContext(request, ussername, jwtToken);
        }
        filterChain.doFilter(request, response);
    }

    private void addUsernameInContext(HttpServletRequest request, String ussername, String jwtToken) {
        UserDetails userDetails = autenticacaoService.loadUserByUsername(ussername);

        if(jwtTokenManager.validateToken(jwtToken, userDetails)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }
    }
}
