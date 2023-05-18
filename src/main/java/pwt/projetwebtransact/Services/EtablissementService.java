package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Repositories.EtablissementRepository;
import pwt.projetwebtransact.Repositories.VilleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtablissementService {

    // Définition des repositories nécessaires au Service
    private EtablissementRepository etablissementRepository;
    private VilleRepository villeRepository;


    /**
     * Enregistre les établissements fournis.
     * @param etablissements Liste des établissements à enregistrer
     */
    public void saveAll(List<Etablissement> etablissements) {
        etablissementRepository.saveAll(etablissements);
    }


    /**
     * Retourne les établissements pour une ville.
     * @param villeId Id de la ville consultée
     * @return Liste des établissements de la ville
     */
    public List<Etablissement> fetchAllEtablissementsByVilleId(Long villeId) {
        Ville villeToFind = villeRepository.findById(villeId).get();    // On trouve la ville correspondant à l'Id
        return etablissementRepository.findEtablissementsByVille(villeToFind);  // On retourne les établissements correspondants
    }

    /**
     * Retourne l'établissement pour un Id donné.
     * @param etablissementId Id de l'établissement voulu
     * @return Établissement correspondant à l'Id
     */
    public Etablissement fetchEtablissementById(Long etablissementId) {
        return etablissementRepository.findById(etablissementId).get();
    }
}
