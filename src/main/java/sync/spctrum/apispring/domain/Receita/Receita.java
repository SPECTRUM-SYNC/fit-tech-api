package sync.spctrum.apispring.domain.Receita;

import com.azure.core.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import io.jsonwebtoken.lang.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import sync.spctrum.apispring.domain.Usuario.Usuario;

@Getter
@Setter
@Entity
public class Receita {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
