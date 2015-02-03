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
import domain.model.MAppello;
import domain.model.MCalendario;
import domain.model.MClasse;
import domain.model.MDocente;
import domain.model.MStudente;


@RestController
@RequestMapping("/classi")
public class ClasseController {
	
	private long idDocenteProva = 1;
	
	/**
	 * Non utilizza un controller del dominio, accede direttamente al DB per prendere il docente.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<ClasseMenuRS> getClassi() {
		
		Collection<MClasse> classi;
		Collection<ClasseMenuRS> classiMenu;
		MDocente docente;
		
		docente = DBFake.getInstance().getDocenteById(this.idDocenteProva);
		classi = docente.getClassi();
		classiMenu = new LinkedList<ClasseMenuRS>();
		
		for (MClasse classe : classi) {
			classiMenu.add(new ClasseMenuRS(classe));
		}
		
		
		return classiMenu;
	}
	
	
	@RequestMapping(value = "/{idClasse}/studenti", method = RequestMethod.GET)
	public Collection<StudenteAppelloRS> getStudenti(@PathVariable long idClasse) {
		
		FaiAppelloController fAController;
		Collection<MStudente> studenti;
		Collection<StudenteAppelloRS> studentiRS;
		
		fAController = new FaiAppelloController();
		studentiRS = new LinkedList<StudenteAppelloRS>();
		
		studenti = fAController.getStudenti(idClasse);
		for (MStudente studente : studenti) {
			studentiRS.add(new StudenteAppelloRS(studente));
		}
		
		return studentiRS;
	}

}
