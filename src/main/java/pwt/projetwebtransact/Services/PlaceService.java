package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Place;
import pwt.projetwebtransact.Repositories.PlaceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService {

    // Définition des repositories nécessaires au Service
    private PlaceRepository placeRepository;


    /**
     * Enregistre les places fournies.
     * @param places Liste des places à enregistrer
     */
    public void saveAll(List<Place> places) {
        placeRepository.saveAll(places);
    }

    /**
     * Retourne toutes les places.
     * @return Liste de toutes les places
     */
    public List<Place> fetchAllPlaces() {
        return placeRepository.findAll();
    }
}
