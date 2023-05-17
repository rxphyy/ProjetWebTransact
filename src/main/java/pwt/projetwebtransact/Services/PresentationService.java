package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Repositories.PresentationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresentationService {
    @Autowired
    private PresentationRepository presentationRepository;

    public Presentation addNewPresentation(Presentation presentation) {
        presentationRepository.save(presentation);
        return presentation;
    }

    public List<Presentation> fetchAllPresentations() {
        return presentationRepository.findAll();
    }

    public List<Presentation> fetchPresentationsByEtablissement(Etablissement etablissement) {
        return etablissement.getSalles().stream().flatMap(salle -> presentationRepository.findPresentationsBySalle(salle).stream())
                .collect(Collectors.toList());
    }

    public List<Presentation> fetchPresentationsBySalle(Salle salle) {
        return presentationRepository.findPresentationsBySalle(salle);
    }
}
