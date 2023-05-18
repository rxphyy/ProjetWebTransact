package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Entity // Indique que la classe est une entité persistante
@Data // Génère automatiquement les méthodes getters, setters, toString, equals, hashCode, etc.
@NoArgsConstructor // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Table("cours") // Spécifie la table correspondante dans la base de données
public class Cours {
    @Id // Indique que le champ suivant est une clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie la stratégie de génération de la valeur de la clé primaire
    private long ID;
    private int Code;
    private String Titre;
    private String Description;
    private int NbrCredits;
    private double Duree;
    @OneToMany(cascade = CascadeType.ALL) // Indique une relation one-to-many (un cours a plusieurs présentations)
    private List<Presentation> presentations = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL) // Indique une relation one-to-one (un cours a une spécialité)
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
