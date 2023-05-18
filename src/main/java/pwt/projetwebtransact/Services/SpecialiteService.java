package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Specialite;
import pwt.projetwebtransact.Repositories.SpecialiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecialiteService {

    // Définition des repositories nécessaires au Service
    private SpecialiteRepository specialiteRepository;


    /**
     * Enregistre les spécialités fournies.
     * @param specialites Liste des spécialités à enregistrer
     */
    public void saveAll(List<Specialite> specialites) {
        specialiteRepository.saveAll(specialites);
    }

    /**
     * Retourne toutes les spécialités.
     * @return Liste de toutes les spécialités
     */
    public List<Specialite> fetchAllSpecialites() {
        return specialiteRepository.findAll();
    }
}
