package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Specialite;
import pwt.projetwebtransact.Repositories.SeanceRepository;
import pwt.projetwebtransact.Repositories.SpecialiteRepository;

import java.util.List;

@Service
public class SpecialiteService {
    @Autowired
    private SpecialiteRepository specialiteRepository;

    public Specialite addNewSpecialite(Specialite specialite) {
        specialiteRepository.save(specialite);
        return specialite;
    }

    public List<Specialite> fetchAllSpecialites() {
        return specialiteRepository.findAll();
    }
}
