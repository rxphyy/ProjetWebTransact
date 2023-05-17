package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Services.EtablissementService;
import pwt.projetwebtransact.Services.VilleService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class EtablissementController {
    private EtablissementService etablissementService;
    private VilleService villeService;

    @GetMapping("/etablissements/{villeId}")
    public String fetchAllEtablissementsByVilleId(@PathVariable Long villeId, Model model) {
        Ville ville = villeService.fetchVilleById(villeId);
        model.addAttribute("ville", ville);
        model.addAttribute("etablissements", etablissementService.fetchAllEtablissementsByVilleId(villeId));
        return "etablissements";
    }

    @PostMapping("/addEtablissement")
    public Etablissement addEtablissement(@RequestBody Etablissement etablissement) {
        return etablissementService.addNewEtablissement(etablissement);
    }
}
