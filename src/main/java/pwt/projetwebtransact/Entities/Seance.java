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
@Table("seance")
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int Code;
    private String HeureDebut;
    @OneToOne
    private Presentation presentation;

    public Seance(int code, String heureDebut) {
        Code = code;
        HeureDebut = heureDebut;
    }
}
