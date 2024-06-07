package sync.spctrum.apispring.service.receita.dto.receita;

import lombok.Data;

@Data
public class ReceitaResponseDTO {


    private Long id;
    private String nome;
    private String[] ingredientes;
    private String modoPreparo;
    private String calorias;
    private String tempoPreparo;
    private String tipo;
    private String proteina;
    private String carboidratos;
    private String gorduras;
    private String acucar;
    private Integer qtdSelecionada;
}
