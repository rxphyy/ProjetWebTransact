package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
