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
@Table("presentation") // Spécifie la table correspondante dans la base de données
public class Presentation {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    @ManyToOne(cascade = CascadeType.ALL) // Indique une relation many-to-one (plusieurs présentations sont associées à une salle)
    private Salle salle;

    @ManyToOne(cascade = CascadeType.ALL) // Indique une relation many-to-one (plusieurs présentations sont associées à un cours)
    private Cours cours;

    @OneToMany(mappedBy = "ID") // Indique une relation one-to-many (une présentation a plusieurs coupons)
    private Collection<Coupon> coupons;

    @OneToOne(cascade = CascadeType.ALL) // Indique une relation one-to-one (une présentation est associée à une séance)
    private Seance seance;

    public Presentation(Salle salle, Cours cours) {
        this.salle = salle;
        this.cours = cours;
    }
}
