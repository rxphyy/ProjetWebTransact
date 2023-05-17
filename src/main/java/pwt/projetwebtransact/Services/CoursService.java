package pwt.projetwebtransact.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwt.projetwebtransact.Entities.Cours;
import pwt.projetwebtransact.Repositories.CoursRepository;

import java.util.List;

@Service
public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    public Cours addNewCours(Cours cours) {
        coursRepository.save(cours);
        return cours;
    }

    public List<Cours> fetchAllCours() {
        return coursRepository.findAll();
    }

    public Cours fetchCoursByID(Long coursId) {
        return coursRepository.findById(coursId).get();
    }
}
