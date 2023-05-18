package pwt.projetwebtransact.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controller 'Home' qui s'occupe de la page d'accueil de l'application
@Controller
public class HomeController {

    /** (GET) Retourne le modèle 'Home' (page par défaut de l'application). */
    @GetMapping(path = "/")
    public String Homepage() {
        return "home"; // Retourne le modèle 'home' qui contient une page d'accueil
    }

    // TODO: Add places
    // TODO: Comment code
}
