package pwt.projetwebtransact.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("specialite")
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Code;
    private String Titre;
    @OneToMany
    private List<Cours> cours;

    public Specialite(int code, String titre) {
        Code = code;
        Titre = titre;
    }
}
