package presenter;


import java.sql.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import controller.MedieController;
import controller.RegistroDocenteController;
import presenter.resourceSupport.appello.AppelloRS;
import presenter.resourceSupport.compito.ArgomentoRS;
import presenter.resourceSupport.medie.ParametriMedieRS;
import presenter.resourceSupport.medie.StudenteMedieRS;
import domain.model.Argomento;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.mediaStrategy.IMediaStrategy;
import domain.model.mediaStrategy.MediaStrategyFactory;


@RestController
//@RequestMapping("/classi/{idClasse}/registriDocente/{idRegistroDocente}")
@RequestMapping(ApiPath.REGISTRO_DOCENTE)
public class RegistroDocentePresenter {
	
//	@RequestMapping(value = "/argomentiSvolti",  method = RequestMethod.GET)
	@RequestMapping(value = ApiPath.ARGOMENTI_SVOLTI,  method = RequestMethod.GET)
	public Collection<ArgomentoRS> getArgomentiSvolti(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
		
		RegistroDocenteController registroDocenteController;
		RegistroDocente registroDocente;
		LinkedList<ArgomentoRS> argomentiRS;
		
		registroDocenteController = new RegistroDocenteController();
		registroDocente = registroDocenteController.getRegistroDocente(idRegistroDocente);
		argomentiRS = new LinkedList<ArgomentoRS>();
		
		for (Argomento argomento : registroDocente.getArgomentiSvolti()) {
			argomentiRS.add(new ArgomentoRS(argomento));
		}
		
		return argomentiRS;
	}
	
//	@RequestMapping(method = RequestMethod.GET, params = {"data"})
//	public AppelloRS getAppello(@PathVariable int idClasse, @RequestParam(value="data") long data)
	
	  @RequestMapping(value = ApiPath.MEDIE, method = RequestMethod.GET, params = {"dataInizio","dataFine","strategia"})
	  public Collection<StudenteMedieRS> getMedie(@PathVariable int idRegistroDocente, @RequestParam(value="dataInizio") long dataInizio,  @RequestParam(value="dataFine") long dataFine,  @RequestParam(value="strategia") String strategia) {
		  Map<Studente, Voto> mapMedieScritto;
		  Collection<StudenteMedieRS> rit;
		  StudenteMedieRS studenteMedieRS;
		  MedieController medieController;
		  IMediaStrategy strategy;
		  Date dataStrart;
		  Date dataEnd;
		  
		  dataStrart = new Date(dataInizio);
		  dataEnd = new Date(dataFine);
		  
		  medieController = new MedieController();
		  rit = new LinkedList<StudenteMedieRS>();
		  
		  //chiamare la factory e settate la strategia
		  strategy = MediaStrategyFactory.getInstance().create(strategia);
		  medieController.setStrategiaRegistro(idRegistroDocente, strategy);
		  
		  mapMedieScritto = medieController.getMedieScritto(idRegistroDocente, dataStrart, dataEnd);
		  
		  for(Studente studente : mapMedieScritto.keySet()){
			  studenteMedieRS = new StudenteMedieRS(studente, mapMedieScritto.get(studente), null, null);
			  rit.add(studenteMedieRS);
		  }

		  return rit;
	  }

}
