package controllerSpring;


import domain.Appello;
import domain.Assenza;
import domain.Calendario;
import domain.FaiAppelloController;
import domain.Studente;
import resourceSupport.AppelliContainerRS;
import resourceSupport.AppelloRS;
import resourceSupport.AssentiContainerRS;
import resourceSupport.StudenteAppelloRS;

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
