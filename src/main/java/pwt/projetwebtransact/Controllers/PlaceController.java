package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Coupon;
import pwt.projetwebtransact.Entities.Place;
import pwt.projetwebtransact.Services.CouponService;
import pwt.projetwebtransact.Services.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping("/places")
    public List<Place> fetchAllPlaces() {
        return placeService.fetchAllPlaces();
    }

    @PostMapping("/addPlace")
    public Place addPlaces(@RequestBody Place place) {
        return placeService.addNewPlace(place);
    }
}
