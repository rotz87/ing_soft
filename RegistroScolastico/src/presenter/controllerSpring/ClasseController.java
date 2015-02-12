package presenter.controllerSpring;


import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.AppelliContainerRS;
import presenter.resourceSupport.AppelloRS;
import presenter.resourceSupport.ClasseMenuRS;
import presenter.resourceSupport.StudenteAppelloRS;
import service.DBFake;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.Studente;


@RestController
@RequestMapping("/classi")
public class ClasseController {
	
	private int idDocenteProva = 1;
	
	/**
	 * Non utilizza un controller del dominio, accede direttamente al DB per prendere il docente.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<ClasseMenuRS> getClassi() {
		
		Collection<Classe> classi;
		Collection<ClasseMenuRS> classiMenu;
		Docente docente;
		
		docente = DBFake.getInstance().getDocenteById(this.idDocenteProva);
		classi = docente.getClassi();
		classiMenu = new LinkedList<ClasseMenuRS>();
		
		for (Classe classe : classi) {
			classiMenu.add(new ClasseMenuRS(classe));
		}
		
		
		return classiMenu;
	}
	
	
	@RequestMapping(value = "/{idClasse}/studenti", method = RequestMethod.GET)
	public Collection<StudenteAppelloRS> getStudenti(@PathVariable int idClasse) {
		
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
