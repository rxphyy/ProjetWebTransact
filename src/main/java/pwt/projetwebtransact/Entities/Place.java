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
@Table("place") // Spécifie la table correspondante dans la base de données
public class Place {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Numero;
    private int Position;
    @ManyToOne // Indique une relation many-to-one (plusieurs places appartiennent à une salle)
    private Salle salle;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL) // Indique une relation one-to-many (une place a plusieurs coupons)
    private Collection<Coupon> coupons;

    public Place(int numero, int position, Salle salle) {
        Numero = numero;
        Position = position;
        this.salle = salle;
    }
}
