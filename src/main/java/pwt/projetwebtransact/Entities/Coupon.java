package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Code;
    private String NomClient;
    private double Tarif;
    private int CodePaiement;
    private boolean Reserve;
    @ManyToOne
    private Place place;
    @ManyToOne
    private Presentation presentation;
}
