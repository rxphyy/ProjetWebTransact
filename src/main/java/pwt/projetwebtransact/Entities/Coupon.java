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
@Table("coupon") // Spécifie la table correspondante dans la base de données
public class Coupon {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Code;
    private String NomClient;
    private double Tarif;
    private int CodePaiement;
    private boolean Reserve;
    @ManyToOne // Indique une relation ManyToOne (plusieurs coupons peuvent être associés à une place)
    private Place place;
    @ManyToOne // Indique une relation ManyToOne (plusieurs coupons peuvent être associés à une présentation)
    private Presentation presentation;
}
