package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "etablissement")
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Code;
    private String Titre;
    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL)
    private Collection<Salle> salles;
    @ManyToOne
    private Ville ville;

    public Etablissement(int code, String titre, Ville ville) {
        Code = code;
        Titre = titre;
        this.ville = ville;
    }

    public Etablissement(int code, String titre) {
        Code = code;
        Titre = titre;
    }
}
