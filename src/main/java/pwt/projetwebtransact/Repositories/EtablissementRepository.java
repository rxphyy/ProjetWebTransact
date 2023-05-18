package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Ville;

import java.util.List;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    /**
     * Recherche les établissements d'une ville.
     *
     * @param ville la ville recherchée
     * @return une liste d'établissements correspondant à la ville spécifiée
     */
    List<Etablissement> findEtablissementsByVille(Ville ville);
}
