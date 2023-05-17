package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Services.CoursService;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.SalleService;
import pwt.projetwebtransact.Services.SeanceService;

import java.util.List;

@Controller
@RequestMapping("/")
public class SeanceController {
    @Autowired
    private SeanceService seanceService;

    @Autowired
    private CoursService coursService;

    @GetMapping("/seances")
    public String fetchSeancesByCours(@RequestParam Long coursId, @RequestParam Long etablissementId, @RequestParam Long villeId, Model model) {
        Cours cours = coursService.fetchCoursByID(coursId);
        model.addAttribute("coursId", coursId);
        model.addAttribute("etablissementId", etablissementId);
        model.addAttribute("villeId", villeId);
        model.addAttribute("seances", seanceService.fetchSeancesByCours(cours));
        return "seances";
    }

    @PostMapping("/addSeance")
    public Seance addSeance(@RequestBody Seance salle) {
        return seanceService.addNewSeance(salle);
    }
}
