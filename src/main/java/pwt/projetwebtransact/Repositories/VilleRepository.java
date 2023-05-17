package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Specialite;
import pwt.projetwebtransact.Entities.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
}
