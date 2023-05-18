package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("seance") // Spécifie la table correspondante dans la base de données
public class Seance {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Code;
    private String HeureDebut;
    @OneToOne // Indique une relation one-to-one (une séance est associée à une présentation)
    private Presentation presentation;

    public Seance(int code, String heureDebut) {
        Code = code;
        HeureDebut = heureDebut;
    }
}
