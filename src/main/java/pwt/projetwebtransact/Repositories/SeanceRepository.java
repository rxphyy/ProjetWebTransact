package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Entities.Seance;

import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
