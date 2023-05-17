package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Repositories.SeanceRepository;
import pwt.projetwebtransact.Repositories.VilleRepository;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    private VilleRepository villeRepository;

    public Ville addNewVille(Ville ville) {
        villeRepository.save(ville);
        return ville;
    }

    public List<Ville> fetchAllVilles() {
        return villeRepository.findAll();
    }
    public Ville fetchVilleById(Long villeId) {
        return villeRepository.findById(villeId).get();
    }
}
