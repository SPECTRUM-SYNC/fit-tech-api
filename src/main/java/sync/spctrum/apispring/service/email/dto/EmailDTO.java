package sync.spctrum.apispring.service.email.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDTO {

    private String para;
    private String assunto;
    private String corpo;

}
