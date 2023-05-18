package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Services.CoursService;
import pwt.projetwebtransact.Services.SeanceService;

// Controller 'Seance' qui s'occupe des pages concernant les séances
@Controller
@AllArgsConstructor
public class SeanceController {

    // Définition des services nécessaires au Controller
    private SeanceService seanceService;
    private CoursService coursService;

    /**
     * (GET) Affiche toutes les séances d'un cours.
     * @param etablissementId Id de l'établissement consulté (Pour le bouton Retourner)
     * @param coursId Id du cours consulté
     * @param villeId Id de la ville consultée
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'seances' qui affiche les séances d'un cours
     */
    @GetMapping("/seances")
    public String fetchSeancesByCours(@RequestParam Long coursId, @RequestParam Long etablissementId, @RequestParam Long villeId, Model model) {
        Cours cours = coursService.fetchCoursByID(coursId);
        model.addAttribute("cours", cours);
        model.addAttribute("etablissementId", etablissementId);
        model.addAttribute("villeId", villeId);
        model.addAttribute("seances", seanceService.fetchSeancesByCours(cours));
        return "seances";
    }
}
