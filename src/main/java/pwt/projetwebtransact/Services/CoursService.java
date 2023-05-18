package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Repositories.CoursRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursService {

    // Définition des repositories nécessaires au Service
    private CoursRepository coursRepository;


    /**
     * Enregistre les cours fournis.
     * @param cours Liste des cours à enregistrer
     */
    public void saveAll(List<Cours> cours) {
        coursRepository.saveAll(cours);
    }

    /**
     * Retourne tous les cours.
     * @return Liste de tous les cours
     */
    public List<Cours> fetchAllCours() {
        return coursRepository.findAll();   // On retourne tous les cours de la base de données
    }

    /**
     * Retourne le cours pour un Id donné.
     * @param coursId Id du cours voulu
     * @return Cours correspondant à l'Id
     */
    public Cours fetchCoursByID(Long coursId) {
        return coursRepository.findById(coursId).get();
    }
}
