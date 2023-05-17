package pwt.projetwebtransact.Controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// Controlleur gérant les erreurs
@ControllerAdvice
public class ErrorController {

    // Gère les exceptions de type générique Exception
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "redirect:/"; // Redirige l'utilisateur vers la page d'accueil
    }

    // Gère les exceptions de type ChangeSetPersister.NotFoundException
    // et définit la réponse HTTP sur HttpStatus.NOT_FOUND (404)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public String handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        return "redirect:/"; // Redirige l'utilisateur vers la page d'accueil
    }
}