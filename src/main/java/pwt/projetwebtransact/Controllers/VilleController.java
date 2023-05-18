package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Services.VilleService;

// Controller 'Ville' qui s'occupe des pages concernant les villes
@Controller
@AllArgsConstructor
public class VilleController {
    // Définition des services nécessaires au Controller
    private VilleService villeService;

    /**
     * (GET) Affiche toutes les villes.
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'villes' qui affiche les villes
     */
    @GetMapping(path = "/villes")
    public String fetchAllVilles(Model model) {
        // Ajout d'une liste de toutes les villes au Model qui sera envoyé au modèle
        model.addAttribute("villes", villeService.fetchAllVilles());
        return "villes";
    }
}
