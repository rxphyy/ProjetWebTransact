package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Coupon;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Repositories.CouponRepository;
import pwt.projetwebtransact.Repositories.SeanceRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static pwt.projetwebtransact.ProjetWebTransactApplication.random;

@Service
@AllArgsConstructor
public class CouponService {

    // Définition des repositories nécessaires au Service
    private CouponRepository couponRepository;
    private SeanceRepository seanceRepository;


    /**
     * Enregistre les coupons fournis.
     * @param coupons Liste des coupons à enregistrer
     */
    public void saveAll(List<Coupon> coupons) {
        couponRepository.saveAll(coupons);  // On enregistre les coupons en base de données
    }

    /**
     * S'occupe de l'achat des coupons fournis.
     * @param couponIds Liste des Ids des coupons à acheter
     * @param clientName Nom du client qui achète
     */
    public void processCouponsPurchase(List<Long> couponIds, String clientName) {
        if (couponIds != null) {    // Si les coupons ne sont pas null
            for (Long couponId: couponIds) {    // On boucle dans la liste d'Ids de coupons
                Coupon coupon = couponRepository.findById(couponId).get();  // On trouve le coupon correspondant à l'Id
                coupon.setReserve(true);    // On le met 'réservé'
                coupon.setNomClient(clientName);    // On met à jour le nom du client
                coupon.setCodePaiement(random(10000, 40000));   // On génère un code de paiement
                couponRepository.save(coupon);  // On enregistre le coupon en base de données
            }
        }
    }

    /**
     * Retourne les coupons pour une séance.
     * @param seanceId Id de la séance consultée
     * @return Liste des coupons de la séance, triés par tarif
     */
    public List<Coupon> fetchCouponsNonReservesForSeanceId(Long seanceId) {
        Seance seance = seanceRepository.findById(seanceId).get();  // On trouve la séance correspondant à l'Id
        return couponRepository.findAllByPresentationID(seance.getPresentation().getID()).stream()  // On filtre pour la séance choisie
                .filter(coupon -> !coupon.isReserve())  // On filtre les coupons qui ne sont Reserve = false
                .sorted(Comparator.comparingDouble(Coupon::getTarif))   // On trie par tarif
                .collect(Collectors.toList());
    }
}
