package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Coupon;
import pwt.projetwebtransact.Entities.Presentation;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    public default List<Coupon> findAllByPresentationID(Long presentationId) {
        List<Coupon> couponsToReturn = new ArrayList<>();
        for (Coupon coupon: findAll()) {
            if (coupon.getPresentation().getID() == presentationId) {
                couponsToReturn.add(coupon);
            }
        }
        return couponsToReturn;
    }
}
