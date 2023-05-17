package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Ville;
import pwt.projetwebtransact.Repositories.EtablissementRepository;
import pwt.projetwebtransact.Repositories.VilleRepository;

import java.util.List;

@Service
public class EtablissementService {
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private VilleRepository villeRepository;

    public Etablissement addNewEtablissement(Etablissement etablissement) {
        etablissementRepository.save(etablissement);
        return etablissement;
    }

    public List<Etablissement> fetchAllEtablissements() {
        return etablissementRepository.findAll();
    }

    public List<Etablissement> fetchAllEtablissementsByVilleId(Long villeId) {
        Ville villeToFind = villeRepository.findById(villeId).get();
        return etablissementRepository.findEtablissementsByVille(villeToFind);
    }

    public Etablissement fetchEtablissementById(Long etablissementId) {
        return etablissementRepository.findById(etablissementId).get();
    }
}
