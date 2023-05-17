package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Entities.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
}
