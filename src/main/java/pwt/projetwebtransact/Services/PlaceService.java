package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Place;
import pwt.projetwebtransact.Repositories.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place addNewPlace(Place place) {
        placeRepository.save(place);
        return place;
    }

    public List<Place> fetchAllPlaces() {
        return placeRepository.findAll();
    }
}
