package pwt.projetwebtransact.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwt.projetwebtransact.Entities.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
