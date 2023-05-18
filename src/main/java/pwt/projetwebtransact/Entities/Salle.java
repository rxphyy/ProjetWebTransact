package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("salle") // Spécifie la table correspondante dans la base de données
public class Salle {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Numero;
    private String Nom;
    @ManyToOne // Indique une relation many-to-one (plusieurs salles sont associées à un établissement)
    private Etablissement etablissement;

    @OneToMany(cascade = CascadeType.ALL) // Indique une relation one-to-many (une salle a plusieurs présentations)
    private Collection<Presentation> presentations = new ArrayList<>();

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL) // Indique une relation one-to-many (une salle a plusieurs places)
    private List<Place> places = new ArrayList<>();

    public Salle(int numero, String nom, Etablissement etablissement) {
        Numero = numero;
        Nom = nom;
        this.etablissement = etablissement;
    }
}
