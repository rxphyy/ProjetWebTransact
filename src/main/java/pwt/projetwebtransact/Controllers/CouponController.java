package pwt.projetwebtransact.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Services.CouponService;
import pwt.projetwebtransact.Services.SeanceService;

import java.util.List;

// Controller 'Coupon' qui s'occupe des pages concernant les coupons
@Controller
@AllArgsConstructor
public class CouponController {

    // Définition des services nécessaires au Controller
    private CouponService couponService;
    private SeanceService seanceService;

    /**
     * (GET) Affiche tous les coupons de la séance.
     * @param seanceId Id de la séance à consulter
     * @param model Modèle qui sera envoyé au modèle HTML
     * @return Le modèle 'coupons' qui affiche les coupons de la séance
     */
    @GetMapping("/coupons")
    public String fetchCouponsForSeance(@RequestParam Long seanceId, Model model) {
        model.addAttribute("coupons", couponService.fetchAllCouponsForSeanceId(seanceId));
        model.addAttribute("seance", seanceService.findById(seanceId));

        return "coupons";
    }

    /**
     * (POST) S'occupe de l'achat de coupons
     * @param model Modèle qui sera envoyé au modèle HTML
     * @param clientName Le nom du client qui achète
     * @param seanceId Id de la séance pour laquelle les coupons sont achetés
     * @param selectedCoupons Liste des coupons sélectionnés par le client
     * @return Le modèle 'coupons' qui affiche les coupons de la séance
     */
    @PostMapping("/coupons")
    public String couponsPurchase(@RequestParam String clientName, @RequestParam(value = "selectedCoupons", required = false) List<Long> selectedCoupons, @RequestParam Long seanceId, Model model) {
        couponService.processCouponsPurchase(selectedCoupons, clientName);
        model.addAttribute("coupons", couponService.fetchAllCouponsForSeanceId(seanceId));
        model.addAttribute("seance", seanceService.findById(seanceId));

        return "coupons";
    }
}
