package sync.spctrum.apispring.service.usuario.autenticacao.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioTokenDTO {

  private Long userId;
  private String nome;
  private String email;
  private String token;
}
