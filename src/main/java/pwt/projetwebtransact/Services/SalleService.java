package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Repositories.EtablissementRepository;
import pwt.projetwebtransact.Repositories.SalleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SalleService {

    // Définition des repositories nécessaires au Service
    private SalleRepository salleRepository;
    private EtablissementRepository etablissementRepository;


    /**
     * Enregistre les salles fournies.
     * @param salles Liste des salles à enregistrer
     */
    public void saveAll(List<Salle> salles) {
        salleRepository.saveAll(salles);
    }


    /**
     * Retourne les salles pour un établissement.
     * @param etablissementId Id de l'établissement consulté
     * @return Liste des salles de l'établissement
     */
    public List<Salle> fetchAllSallesByEtablissementId(Long etablissementId) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).get();  // On trouve l'établissement correspondant à l'Id
        return salleRepository.findSallesByEtablissement(etablissement);    // On retourne les salles correspondantes
    }
}
