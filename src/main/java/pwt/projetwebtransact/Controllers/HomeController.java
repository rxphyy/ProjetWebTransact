package pwt.projetwebtransact.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class HomeController {

    // Mapping par défaut de l'application
    @GetMapping(path = "/")
    public String Homepage() {
        // Retourne le template 'home' qui contient une page d'accueil
        return "home";
    }
}
