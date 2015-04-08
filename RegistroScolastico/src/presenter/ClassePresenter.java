package presenter;


import java.util.Collection;
import java.util.LinkedList;










import org.joda.time.DateTime;
import org.joda.time.LocalDate;
//import org.orm.PersistentException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.ClasseMenuRS;
import presenter.resourceSupport.DateFestiveRS;
import presenter.resourceSupport.RegistroDocenteRS;
import presenter.resourceSupport.appello.StudenteAppelloRS;
import domain.controller.ClasseController;
import domain.controller.DocenteController;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.RegistroDocente;
//import domain.model.DocenteCriteria;
import domain.model.Studente;

@RestController
//@RequestMapping("/classi")
@RequestMapping(ApiPath.CLASSI)
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

		classi = classeController.getClassi(docenteController.getIdDocenteProva());
		classiMenu = new LinkedList<ClasseMenuRS>();
		
		for (Classe classe : classi) {
			classiMenu.add(new ClasseMenuRS(classe));
		}
		
		return classiMenu;
	}
	
	/*FIXME Con il path /{idClasse}/studenti si intendono studenti generici (con tutti i dati), mentre
	 * esso ritorna StudenteAppelloRS
	*/
//	@RequestMapping(value = "/{idClasse}/studenti", method = RequestMethod.GET)
	@RequestMapping(value = ApiPath.CLASSE_STUDENTI, method = RequestMethod.GET)
	public Collection<StudenteAppelloRS> getStudentiAppello(@PathVariable int idClasse) {
		
		ClasseController classeController;
		Collection<Studente> studenti;
		Collection<StudenteAppelloRS> studentiRS;
		
		studenti = null;
		classeController = new ClasseController();
		studentiRS = new LinkedList<StudenteAppelloRS>();
		
		studenti = classeController.getStudenti(idClasse);
		for (Studente studente : studenti) {
			studentiRS.add(new StudenteAppelloRS(studente));
		}
		
		return studentiRS;
	}
	
//	@RequestMapping(value = "/{idClasse}/dateFestive", method = RequestMethod.GET)
//	@RequestMapping(value = ApiPath.CLASSE_FESTIVI, method = RequestMethod.GET)
//	public Collection<Long> getDateFestive(@PathVariable int idClasse) {
//		
//		ClasseController classeController;
//		Collection<LocalDate> date;
//		Collection<Long> dateLong;
//		
//		date = null;
//		classeController = new ClasseController();
//		dateLong = new LinkedList<Long>();
//		
//		date = classeController.getDateFestive(idClasse);
//		
//		
//		for (LocalDate data : date) {
////			java.sql.Date sqlData = new java.sql.Date(data.toDate().getTime());
////			dateLong.add(sqlData.getTime());
//			
////			DateTime dt = data.toDateTimeAtStartOfDay().plusHours(12);
////			dateLong.add(dt.getMillis());
//			
//			dateLong.add(data.toDate().getTime());
//			
//		}
//		
//		return dateLong;
//	}
	
	@RequestMapping(value = ApiPath.CLASSE_FESTIVI, method = RequestMethod.GET)
	public DateFestiveRS getDateFestive(@PathVariable int idClasse) {
		
		ClasseController classeController;
		Collection<LocalDate> date;
		Collection<GiornoSettimanaleFestivo> giorniSettimanali;
		DateFestiveRS dateFestiveRS;
		
		classeController = new ClasseController();

		date = classeController.getDateFestive(idClasse);
		giorniSettimanali = Calendario.getInstance().getGiorniSettimanaliFestivi();
		
		dateFestiveRS = new DateFestiveRS(date, giorniSettimanali);

		return dateFestiveRS;
	}
	
//	@RequestMapping(value = "/{idClasse}/registriDocente", method = RequestMethod.GET)
	@RequestMapping(value = ApiPath.CLASSE_REGISTRI_DOCENTE, method = RequestMethod.GET)
	public Collection<RegistroDocenteRS> getRegistriDocente(@PathVariable int idClasse) {
		ClasseController classeController;
		DocenteController docenteController;
		Collection<RegistroDocente> registri;
		Collection<RegistroDocenteRS> registriRS;
		
		classeController = new ClasseController();
		docenteController = new DocenteController();
		registriRS = new LinkedList<RegistroDocenteRS>();
		
		registri = classeController.getRegistriDocente(idClasse, docenteController.getIdDocenteProva());
		
		for(RegistroDocente registro : registri){
			registriRS.add(new RegistroDocenteRS(registro));
		}
		return registriRS;
	}
}