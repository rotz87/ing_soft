package presenter.controllerSpring;


import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.AppelliContainerRS;
import presenter.resourceSupport.AppelloRS;
import presenter.resourceSupport.AssentiContainerRS;
import presenter.resourceSupport.StudenteAppelloRS;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Calendario;
import domain.model.Studente;


@RestController
@RequestMapping("/classi")
public class ClasseController {
	
	
	@RequestMapping(value = "/{idClasse}/studenti", method = RequestMethod.GET)
	public Collection<StudenteAppelloRS> getStudenti(@PathVariable long idClasse) {
		
		FaiAppelloController fAController;
		Collection<Studente> studenti;
		Collection<StudenteAppelloRS> studentiRS;
		
		fAController = new FaiAppelloController();
		studentiRS = new LinkedList<StudenteAppelloRS>();
		
		studenti = fAController.getStudenti(idClasse);
		for (Studente studente : studenti) {
			studentiRS.add(new StudenteAppelloRS(studente));
		}
		
		return studentiRS;
	}

}
