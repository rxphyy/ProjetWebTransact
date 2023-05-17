package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Services.VilleService;

import java.util.List;

@CrossOrigin
@Controller
@AllArgsConstructor
public class VilleController {

    private VilleService villeService;

    @GetMapping(path = "/villes")
    public String fetchAllVilles(Model model) {
        model.addAttribute("villes", villeService.fetchAllVilles());
        return "villes";
    }

    @PostMapping("/addVille")
    public Ville addVille(@RequestBody String name) {
        Ville newVille = new Ville();
        newVille.setNom(name);
        return villeService.addNewVille(newVille);
    }
}
