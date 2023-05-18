package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("specialite") // Spécifie la table correspondante dans la base de données
public class Specialite {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Code;
    private String Titre;
    @OneToMany // Indique une relation one-to-many (une spécialité a plusieurs cours)
    private List<Cours> cours;

    public Specialite(int code, String titre) {
        Code = code;
        Titre = titre;
    }
}
