package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.PresentationService;
import pwt.projetwebtransact.Services.SalleService;

import java.util.List;

@Controller
@RequestMapping("/")
public class SalleController {
    @Autowired
    private SalleService salleService;

    @Autowired
    private EtablissementService etablissementService;

    @GetMapping("/sallesParEtablissement")
    public String fetchAllSallesByEtablissement(@RequestParam Long etablissementId, @RequestParam Long villeId, Model model) {
        Etablissement etablissement = etablissementService.fetchEtablissementById(etablissementId);
        model.addAttribute("etablissement", etablissement);
        model.addAttribute("villeId", villeId);
        model.addAttribute("salles", salleService.fetchAllSallesByEtablissementId(etablissementId));
        return "sallesParEtablissement";
    }

    @GetMapping("/sallesParEtablissment")
    public List<Salle> fetchAllSalles() {
        return salleService.fetchAllSalles();
    }

    @PostMapping("/addSalle")
    public Salle addSalles(@RequestBody Salle salle) {
        return salleService.addNewSalle(salle);
    }
}
