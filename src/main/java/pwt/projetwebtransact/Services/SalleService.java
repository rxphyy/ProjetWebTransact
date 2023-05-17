package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Repositories.EtablissementRepository;
import pwt.projetwebtransact.Repositories.PresentationRepository;
import pwt.projetwebtransact.Repositories.SalleRepository;

import java.util.List;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private EtablissementRepository etablissementRepository;

    public Salle addNewSalle(Salle salle) {
        salleRepository.save(salle);
        return salle;
    }

    public List<Salle> fetchAllSalles() {
        return salleRepository.findAll();
    }

    public List<Salle> fetchAllSallesByEtablissementId(Long etablissementId) {
        Etablissement etablissement = etablissementRepository.findById(etablissementId).get();
        return salleRepository.findSallesByEtablissement(etablissement);
    }

    public Salle fetchSalleById(Long salleId) {
        return salleRepository.findById(salleId).get();
    }
}
