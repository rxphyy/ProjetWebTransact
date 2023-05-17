package pwt.projetwebtransact.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String Nom;
    @OneToMany(mappedBy = "ville")
    private Collection<Etablissement> etablissements;

    public Ville(String nom) {
        Nom = nom;
    }
}
