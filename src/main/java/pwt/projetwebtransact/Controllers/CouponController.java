package pwt.projetwebtransact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pwt.projetwebtransact.Entities.Coupon;
import pwt.projetwebtransact.Services.CouponService;

import java.util.List;


@Controller
@RequestMapping("/")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public String fetchCouponsReservesForSeance(@RequestParam Long seanceId, Model model) {
        model.addAttribute("coupons", couponService.fetchAllCouponsReservesForSeanceId(seanceId));
        return "coupons";
    }

    @GetMapping("/couponsReserves")
    public String fetchAllCouponsForSeance(@RequestParam Long seanceId, Model model) {
        model.addAttribute("coupons", couponService.fetchAllCouponsForSeanceId(seanceId));
        return "coupons";
    }

    // TODO: Finish purchase endpoint
    @PostMapping("/couponsPurchase")
    public String couponsPurchase(@RequestParam("clientName") String clientName,
                                  @RequestParam(value = "selectedCoupons", required = false) List<Integer> selectedCoupons) {
        return "coupons";
    }
}
