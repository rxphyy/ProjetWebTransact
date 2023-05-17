package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("salle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Numero;
    private String Nom;
    @ManyToOne
    private Etablissement etablissement;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Presentation> presentations = new ArrayList<>();

    public Salle(int numero, String nom, Etablissement etablissement) {
        Numero = numero;
        Nom = nom;
        this.etablissement = etablissement;
    }
}
