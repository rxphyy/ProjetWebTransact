package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Code;
    private String Titre;
    private String Description;
    private int NbrCredits;
    private double Duree;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Presentation> presentations = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Specialite specialite;

    public Cours(int code, String titre, String description, int nbrCredits, double duree, Specialite specialite) {
        Code = code;
        Titre = titre;
        Description = description;
        NbrCredits = nbrCredits;
        Duree = duree;
        this.specialite = specialite;
    }
}
