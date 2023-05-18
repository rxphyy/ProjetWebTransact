package pwt.projetwebtransact.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Etablissement;
import pwt.projetwebtransact.Entities.Presentation;
import pwt.projetwebtransact.Entities.Salle;
import pwt.projetwebtransact.Repositories.PresentationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PresentationService {

    // Définition des repositories nécessaires au Service
    private PresentationRepository presentationRepository;


    /**
     * Enregistre les présentations fournies.
     * @param presentations Liste des présentations à enregistrer
     */
    public void saveAll(List<Presentation> presentations) {
        presentationRepository.saveAll(presentations);
    }


    /**
     * Retourne les présentations pour un établissement.
     * @param etablissement Établissement consulté
     * @return Liste des présentations de l'établissement
     */
    public List<Presentation> fetchPresentationsByEtablissement(Etablissement etablissement) {
        return etablissement.getSalles().stream().flatMap(salle -> presentationRepository.findPresentationsBySalle(salle).stream())
                .collect(Collectors.toList());
    }
}
