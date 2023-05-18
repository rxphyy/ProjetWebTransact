package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Services.CoursService;

import java.util.List;

// Controller 'Cours' qui s'occupe des pages concernant les cours
@Controller
@AllArgsConstructor
public class CoursController {

    // Définition des services nécessaires au Controller
    private CoursService coursService;

    /**
     * (GET) Retourne tous les cours.
     * @return Une liste de tous les cours
     */
    @GetMapping("/cours")
    public List<Cours> fetchAllCours() {
        return coursService.fetchAllCours();
    }
}
