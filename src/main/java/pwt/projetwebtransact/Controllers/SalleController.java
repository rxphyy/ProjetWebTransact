package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.*;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.SalleService;

// Controller 'Salle' qui s'occupe des pages concernant les salles
@Controller
@AllArgsConstructor
public class SalleController {

    // Définition des services nécessaires au Controller
    private SalleService salleService;
    private EtablissementService etablissementService;


    // FIXME: Cet endpoint n'est pas utilisé, donc son modèle 'sallesParEtablissement' n'existe plus.
    /**
     * (GET) Affiche toutes les salles d'un établissement.
     * @param etablissementId Id de l'établissement à consulter
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'sallesParÉtablissement' qui affiche les salles d'un établissement
     */
    @GetMapping("/sallesParEtablissement")
    public String fetchAllSallesByEtablissement(@RequestParam Long etablissementId, Model model) {
        Etablissement etablissement = etablissementService.fetchEtablissementById(etablissementId);
        model.addAttribute("etablissement", etablissement);
        model.addAttribute("villeId", etablissement.getVille().getID());
        model.addAttribute("salles", salleService.fetchAllSallesByEtablissementId(etablissementId));
        return "sallesParEtablissement";
    }
}
