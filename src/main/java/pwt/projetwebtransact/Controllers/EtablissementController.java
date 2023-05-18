package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.VilleService;

// Controller 'Etablissement' qui s'occupe des pages concernant les établissements
@Controller
@AllArgsConstructor
public class EtablissementController {

    // Définition des services nécessaires au Controller
    private EtablissementService etablissementService;
    private VilleService villeService;

    /**
     * (GET) Affiche tous les établissements qui ont le bon villeId.
     * @param villeId ID de la ville à consulter
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'etablissements' qui affiche les établissements de la ville
     */
    @GetMapping("/etablissements/{villeId}")
    public String fetchAllEtablissementsByVilleId(@PathVariable Long villeId, Model model) {
        // On trouve la ville correspondant au villeId envoyé
        Ville ville = villeService.fetchVilleById(villeId);

        // On ajoute la ville au modèle afin d'afficher son nom dans la vue
        model.addAttribute("ville", ville);
        //On ajoute les établissements de la ville afin de les afficher dans la vue
        model.addAttribute("etablissements", etablissementService.fetchAllEtablissementsByVilleId(villeId));

        return "etablissements";
    }
}
