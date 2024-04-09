 package com.example.demo.api.configuration.security;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springdoc.core.SwaggerUiConfigProperties.Csrf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.api.configuration.jwt.GerenciadorTokenJwt;
import com.example.demo.api.service.Usuario.autenticacao.AutenticacaoService;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguracao {
    private static final String ORIGEM_PERMITIDAS = "*";

    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private AutenticacaoEntryPoint autenticacaoJwtEntryPoint;
    
    private static final AntPathRequestMatcher[] URL_PERMITIDAS = {
        new AntPathRequestMatcher("/swagger-ui/**"),
        new AntPathRequestMatcher("/swagger-ui.html"),
        new AntPathRequestMatcher("/swagger-resources"),
        new AntPathRequestMatcher("/swagger-resources/**"),    
        new AntPathRequestMatcher("/configuration/ui"),
        new AntPathRequestMatcher("/configuration/security"),
        new AntPathRequestMatcher("/api/public/**"),
        new AntPathRequestMatcher("/api/public/authenticate"),
        new AntPathRequestMatcher("/webjars/**"),
        new AntPathRequestMatcher("/v3/api-docs/**"),
        new AntPathRequestMatcher("/actuator/*"),
        new AntPathRequestMatcher("/usuarios/login/**"),
        new AntPathRequestMatcher("/h2-console/**"),
        new AntPathRequestMatcher("/error/**")
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .cors(Customizer.withDefaults())
        .csrf(CsrfConfigurer<HttpSecurity>::disable) 
        .authorizeHttpRequests(authorize -> authorize.requestMatchers(URL_PERMITIDAS).permitAll()
        .anyRequest().authenticated()
        ).exceptionHandling(handling -> handling.authenticationEntryPoint(autenticacaoJwtEntryPoint))
         .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtAutenticacaoFilterBean(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AutenticacaoEntryPoint jwAutenticacaoEntryPointBean(){
        return new AutenticacaoEntryPoint();
    }
    @Bean
    public AutenticacaoFilter jwtAutenticacaoFilterBean(){
        return new AutenticacaoFilter(autenticacaoService, jwtAuthenticationUtilBean());
    }
    @Bean
    public GerenciadorTokenJwt jwtAuthenticationUtilBean(){
        return new GerenciadorTokenJwt();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSourceBean(){
        CorsConfiguration configuracao = new CorsConfiguration();
        configuracao.applyPermitDefaultValues();
        configuracao.setAllowedMethods(
            Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.PATCH.name(),
                HttpMethod.DELETE.name(),
                HttpMethod.OPTIONS.name(),
                HttpMethod.HEAD.name(),
                HttpMethod.TRACE.name()
            )   
        );

        configuracao.setExposedHeaders(List.of(HttpHeaders.CONTENT_DISPOSITION));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuracao);
        
        return source;
        
    }
}