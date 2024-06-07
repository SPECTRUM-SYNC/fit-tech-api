package sync.spctrum.apispring.domain.Receita;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SerializedName("Nome")
    private String nome;

    @SerializedName("Ingredientes")
    private String[] ingredientes;

    @SerializedName("Modo de preparo")
    private String modoPreparo;

    @SerializedName("Calorias")
    private String calorias;

    @SerializedName("Tempo de preparo")
    private String tempoPreparo;

    @SerializedName("Tipo")
    private String tipo;

    @SerializedName("Proteina")
    private String proteina;

    @SerializedName("Carboidratos")
    private String carboidratos;

    @SerializedName("Gorduras")
    private String gorduras;

    @SerializedName("Acucar")
    private String acucar;

    private LocalDate dataCriacao;

    private Integer qtdSelecionada;

    @ManyToOne
    private Usuario usuario;
}
