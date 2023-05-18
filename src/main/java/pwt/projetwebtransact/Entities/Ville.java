package pwt.projetwebtransact.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("ville") // Spécifie la table correspondante dans la base de données
public class Ville {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private String Nom;
    @OneToMany(mappedBy = "ville") // Indique une relation one-to-many inverse (une ville a plusieurs établissements)
    private Collection<Etablissement> etablissements;

    public Ville(String nom) {
        Nom = nom;
    }
}
