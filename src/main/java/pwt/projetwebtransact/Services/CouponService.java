package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Coupon;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Repositories.CouponRepository;
import pwt.projetwebtransact.Repositories.SeanceRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private SeanceRepository seanceRepository;

    public Coupon addNewCoupon(Coupon coupon) {
        couponRepository.save(coupon);
        return coupon;
    }

    public List<Coupon> fetchAllCouponsForSeanceId(Long seanceId) {
        Seance seance = seanceRepository.findById(seanceId).get();
        return couponRepository.findAllByPresentationID(seance.getPresentation().getID());
    }

    public List<Coupon> fetchAllCouponsReservesForSeanceId(Long seanceId) {
        Seance seance = seanceRepository.findById(seanceId).get();
        return couponRepository.findAllByPresentationID(seance.getPresentation().getID())
                .stream()
                .filter(coupon -> coupon.isReserve() && coupon.getTarif() > 0.0)
                .sorted(Comparator.comparingDouble(Coupon::getTarif))
                .collect(Collectors.toList());
    }

}
