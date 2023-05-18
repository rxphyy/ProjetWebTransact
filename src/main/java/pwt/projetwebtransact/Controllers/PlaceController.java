package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Place;
import pwt.projetwebtransact.Services.PlaceService;

import java.util.List;

// Controller 'Place' qui s'occupe des pages concernant les places
@Controller
@AllArgsConstructor
public class PlaceController {

    // Définition des services nécessaires au Controller
    private PlaceService placeService;

    /**
     * (GET) Retourne toutes les places.
     * @return Une liste de toutes les places
     */
    @GetMapping("/places")
    public List<Place> fetchAllPlaces() {
        return placeService.fetchAllPlaces();
    }
}
