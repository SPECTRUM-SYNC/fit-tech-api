package sync.spctrum.apispring.service.usuario.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sync.spctrum.apispring.service.objetivo.dto.objetivo.ObjetivoResponseDTO;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String img;
    private Date dataNascimento;
    private String genero;
    private Double peso;
    private Integer altura;
    private String nivelCondicao;
    private String meta;
    private Boolean contaAtiva;
    private int pontuacao;
    private ObjetivoResponseDTO objetivo;
}
