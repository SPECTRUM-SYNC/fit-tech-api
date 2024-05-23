package sync.spctrum.apispring.service.treino.dto.treino;


public class TreinoCountDTO {

    private String diaDaSemana;
    private Long quantidadeTreinos;


    public TreinoCountDTO(String diaDaSemana, Long quantidadeTreinos) {
        this.diaDaSemana = diaDaSemana;
        this.quantidadeTreinos = quantidadeTreinos;
    }

    public TreinoCountDTO() {
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Long getQuantidadeTreinos() {
        return quantidadeTreinos;
    }

    public void setQuantidadeTreinos(Long quantidadeTreinos) {
        this.quantidadeTreinos = quantidadeTreinos;
    }
}
