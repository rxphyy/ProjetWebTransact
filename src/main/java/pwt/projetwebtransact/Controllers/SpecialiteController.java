package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Entities.Specialite;
import pwt.projetwebtransact.Services.SeanceService;
import pwt.projetwebtransact.Services.SpecialiteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpecialiteController {
    @Autowired
    private SpecialiteService specialiteService;

    @GetMapping("/specialites")
    public List<Specialite> fetchAllSpecialites() {
        return specialiteService.fetchAllSpecialites();
    }

    @PostMapping("/addSpecialite")
    public Specialite addSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.addNewSpecialite(specialite);
    }
}
