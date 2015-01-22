package presenter.controllerSpring;


import java.util.Collection;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.StudenteAppelloRS;
import domain.controller.FaiAppelloController;
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
