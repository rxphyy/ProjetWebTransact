package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Repositories.VilleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VilleService {

    // Définition des repositories nécessaires au Service
    private VilleRepository villeRepository;


    /**
     * Enregistre les villes fournies.
     * @param villes Liste des villes à enregistrer
     */
    public void saveAll(List<Ville> villes) {
        villeRepository.saveAll(villes);
    }

    /**
     * Retourne toutes les villes.
     * @return Liste de toutes les villes
     */
    public List<Ville> fetchAllVilles() {
        return villeRepository.findAll();
    }


    /**
     * Retourne la ville pour un Id donné.
     * @param villeId Id de la ville voulue
     * @return Ville correspondante à l'Id
     */
    public Ville fetchVilleById(Long villeId) {
        return villeRepository.findById(villeId).get();
    }
}
