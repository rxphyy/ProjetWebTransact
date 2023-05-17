package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Services.CoursService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursController {
    @Autowired
    private CoursService coursService;

    @GetMapping("/cours")
    public List<Cours> fetchAllCours() {
        return coursService.fetchAllCours();
    }

    @PostMapping("/addCoupon")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addNewCours(cours);
    }
}
