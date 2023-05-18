package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Salle;

import java.util.List;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {
    /**
     * Recherche les présentations d'une salle.
     *
     * @param salle la salle consultée
     * @return une liste des présentations de la salle
     */
    List<Presentation> findPresentationsBySalle(Salle salle);
}
