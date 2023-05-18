package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("etablissement") // Spécifie la table correspondante dans la base de données
public class Etablissement {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Code;
    private String Titre;
    @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL) // Indique une relation one-to-many (un établissement a plusieurs salles)
    private Collection<Salle> salles;
    @ManyToOne // Indique une relation many-to-one (plusieurs établissements appartiennent à une ville)
    private Ville ville;

    public Etablissement(int code, String titre, Ville ville) {
        Code = code;
        Titre = titre;
        this.ville = ville;
    }
}
