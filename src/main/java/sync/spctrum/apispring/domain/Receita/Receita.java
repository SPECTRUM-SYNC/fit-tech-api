package sync.spctrum.apispring.domain.Receita;

import com.azure.core.annotation.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Receita {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private String[] ingredientes;
    private String modoPreparo;
    private int calorias;
    private String tempoPreparo;
    private String tipo;
    private int proteina;
    private int carboidratos;
    private int gorduras;
    private int acucar;
    private Long idUser;
    
}
