package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.*;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.PresentationService;
import pwt.projetwebtransact.Services.SalleService;

// Controller 'Presentation' qui s'occupe des pages concernant les présentations
@Controller
@AllArgsConstructor
public class PresentationController {

    // Définition des services nécessaires au Controller
    private PresentationService presentationService;
    private EtablissementService etablissementService;
    private SalleService salleService;


    /**
     * (GET) Affiche les détails de l'établissement.
     * @param etablissementId ID de l'établissement à consulter
     * @param villeId ID de la ville de l'établissement (à consulter)
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'etablissements' qui affiche les établissements de la ville
     */
    @GetMapping("/details")
    public String fetchPresentationsByEtablissement(@RequestParam Long etablissementId, @RequestParam Long villeId, Model model) {
        Etablissement etablissement = etablissementService.fetchEtablissementById(etablissementId);
        model.addAttribute("etablissement", etablissement);
        //model.addAttribute("villeId", villeId);
        model.addAttribute("presentations", presentationService.fetchPresentationsByEtablissement(etablissement));
        return "details";
    }
}
