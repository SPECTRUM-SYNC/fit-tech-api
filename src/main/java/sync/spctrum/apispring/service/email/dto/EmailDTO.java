package sync.spctrum.apispring.service.email.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDTO {

    @Email
    private String para;
    private String nome;

}
