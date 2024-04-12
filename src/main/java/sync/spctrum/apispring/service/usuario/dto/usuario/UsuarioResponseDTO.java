package sync.spctrum.apispring.service.usuario.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.domain.Objetivo.Objetivo;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoCreateDTO;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Boolean genero;
    private Double peso;
    private String nivelCondicao;
    private Boolean contaAtiva;
    private ObjetivoResponseDTO objetivo;

    public String getGenero() {
        return genero ? "Masculino" : "femeas";
    }
}
