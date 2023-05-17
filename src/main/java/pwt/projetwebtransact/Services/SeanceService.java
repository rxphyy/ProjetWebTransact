package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Seance;
import pwt.projetwebtransact.Repositories.SalleRepository;
import pwt.projetwebtransact.Repositories.SeanceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;

    public Seance addNewSeance(Seance seance) {
        seanceRepository.save(seance);
        return seance;
    }

    public List<Seance> fetchAllSeances() {
        return seanceRepository.findAll();
    }

    public List<Seance> fetchSeancesByCours(Cours cours) {
        List<Seance> seancesToReturn = new ArrayList<>();
        for (Presentation presentation : cours.getPresentations()) {
            seancesToReturn.add(presentation.getSeance());
        }
        return seancesToReturn;
    }
}
