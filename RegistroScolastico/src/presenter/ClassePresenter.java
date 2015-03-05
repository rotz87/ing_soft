package presenter;


import java.util.Collection;
import java.util.LinkedList;

//import org.orm.PersistentException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.ClasseMenuRS;
import presenter.resourceSupport.StudenteAppelloRS;
import domain.controller.ClasseController;
import domain.controller.DocenteController;
import domain.model.Classe;
import domain.model.Docente;
//import domain.model.DocenteCriteria;
import domain.model.Studente;

@RestController
@RequestMapping("/classi")
public class ClassePresenter {
	

	
	/**
	 * Non utilizza un controller del dominio, accede direttamente al DB per prendere il docente.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<ClasseMenuRS> getClassi() {
		
		Collection<Classe> classi;
		Collection<ClasseMenuRS> classiMenu;
		Docente docente;
		domain.controller.ClasseController classeController;
		DocenteController docenteController;
		classeController= new domain.controller.ClasseController();
		docenteController = new DocenteController();
		try {
			classi = classeController.getClassi(docenteController.getIdDocenteProva());
			classiMenu = new LinkedList<ClasseMenuRS>();
			
			for (Classe classe : classi) {
				classiMenu.add(new ClasseMenuRS(classe));
			}
			
			return classiMenu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;  //TODO far ritornare uno stato http coerente con l'errore
		}
	}
	
	/*TODO Con il path /{idClasse}/studenti si intendono studenti generici (con tutti i dati), mentre
	 * esso ritorna StudenteAppelloRS
	*/
	@RequestMapping(value = "/{idClasse}/studenti", method = RequestMethod.GET)
	public Collection<StudenteAppelloRS> getStudentiAppello(@PathVariable int idClasse) {
		
		ClasseController classeController;
		Collection<Studente> studenti;
		Collection<StudenteAppelloRS> studentiRS;
		
		studenti = null;
		classeController = new ClasseController();
		studentiRS = new LinkedList<StudenteAppelloRS>();
		
		try {
			studenti = classeController.getStudenti(idClasse);
			for (Studente studente : studenti) {
				studentiRS.add(new StudenteAppelloRS(studente));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentiRS;
	}
	
}
