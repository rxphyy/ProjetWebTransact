package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.*;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.PresentationService;
import pwt.projetwebtransact.Services.SalleService;
import pwt.projetwebtransact.Services.VilleService;

@Controller
@RequestMapping("/")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

    @Autowired
    private EtablissementService etablissementService;

    @Autowired
    private SalleService salleService;

    @GetMapping("/details")
    public String fetchPresentationsByEtablissement(@RequestParam Long etablissementId, @RequestParam Long villeId, Model model) {
        Etablissement etablissement = etablissementService.fetchEtablissementById(etablissementId);
        model.addAttribute("etablissement", etablissement);
        model.addAttribute("villeId", villeId);
        model.addAttribute("presentations", presentationService.fetchPresentationsByEtablissement(etablissement));
        return "details";
    }

    // Requête GET pour récupérer les présentations par salleId
    @GetMapping("/presentationsParSalle/{salleId}")
    public String fetchPresentationsBySalle(@PathVariable Long salleId, Model model) {
        // Récupérer la salle par salleId
        Salle salle = salleService.fetchSalleById(salleId);
        model.addAttribute("salle", salle);
        // Récupérer les présentations par salle
        model.addAttribute("presentations", presentationService.fetchPresentationsBySalle(salle));
        return "presentationsParSalle"; // Retourner le nom de la vue à afficher
    }

    // Requête POST pour ajouter une nouvelle présentation
    @PostMapping("/addPresentation")
    public Presentation addPresentations(@RequestBody Presentation presentation) {
        return presentationService.addNewPresentation(presentation); // Ajouter et retourner la présentation nouvellement ajoutée
    }
}
