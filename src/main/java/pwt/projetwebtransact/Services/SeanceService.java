package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Repositories.SeanceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SeanceService {

    // Définition des repositories nécessaires au Service
    private SeanceRepository seanceRepository;


    /**
     * Enregistre les séances fournies.
     * @param seances Liste des séances à enregistrer
     */
    public void saveAll(List<Seance> seances) {
        seanceRepository.saveAll(seances);
    }

    /**
     * Retourne la séance pour un Id donné.
     * @param seanceId Id de la séance voulue
     * @return Séance correspondant à l'Id
     */
    public Seance findById(Long seanceId) {
        return seanceRepository.findById(seanceId).get();
    }

    /**
     * Retourne les séances pour un cours.
     * @param cours Cours consulté
     * @return Liste des séances du cours
     */
    public List<Seance> fetchSeancesByCours(Cours cours) {
        List<Seance> seancesToReturn = new ArrayList<>();   // On déclare une liste vide qui recevra les séances correspondantes
        for (Presentation presentation : cours.getPresentations()) {    // On boucle à travers les présentations du cours donné
            seancesToReturn.add(presentation.getSeance());  // On ajoute la présentation courante à la liste vide
        }
        return seancesToReturn;     // On retourne la liste
    }
}
