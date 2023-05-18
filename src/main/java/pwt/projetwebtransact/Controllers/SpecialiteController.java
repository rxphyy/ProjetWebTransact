package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Specialite;
import pwt.projetwebtransact.Services.SpecialiteService;

import java.util.List;

// Controller 'Specialite' qui s'occupe des pages concernant les spécialités
@Controller
@AllArgsConstructor
public class SpecialiteController {

    // Définition des services nécessaires au Controller
    private SpecialiteService specialiteService;

    /**
     * (GET) Retourne toutes les spécialités.
     * @return Une liste avec toutes les spécialités
     */
    @GetMapping("/specialites")
    public List<Specialite> fetchAllSpecialites() {
        return specialiteService.fetchAllSpecialites();
    }
}
