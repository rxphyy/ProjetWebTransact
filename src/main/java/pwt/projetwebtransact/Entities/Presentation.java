package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("presentation")
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne(cascade = CascadeType.ALL)
    private Salle salle;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cours cours;
    @OneToMany(mappedBy = "ID")
    private Collection<Coupon> coupons;
    @OneToOne(cascade = CascadeType.ALL)
    private Seance seance;

    public Presentation(Salle salle, Cours cours) {
        this.salle = salle;
        this.cours = cours;
    }
}
