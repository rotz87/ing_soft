package presenter;


import java.sql.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

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
import presenter.resourceSupport.medie.MedieStretegyRS;
import presenter.resourceSupport.medie.ParametriMedieRS;
import presenter.resourceSupport.medie.StudenteMedieRS;
import domain.error.DomainCheckedException;
import domain.model.Argomento;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.mediaStrategy.IMediaStrategy;
import domain.model.mediaStrategy.MediaAritmeticaStrategy;
import domain.model.mediaStrategy.MediaStrategyFactory;


@RestController
@RequestMapping(ApiPath.REGISTRO_DOCENTE)
public class RegistroDocentePresenter {
	
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
		  strategy = null;// FIXME
//		  strategia = "MediaAritmeticaStrategy";// FIXME
		  try {
			strategy = MediaStrategyFactory.getInstance().create(strategia);
		} catch (DomainCheckedException e) {
			// FIXME Auto-generated catch block
//			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		  medieController.setStrategiaRegistro(idRegistroDocente, strategy);
		  
		  mapMedieScritto = medieController.getMedieScritto(idRegistroDocente, dataStrart, dataEnd);
		  
		  for(Studente studente : mapMedieScritto.keySet()){
			  studenteMedieRS = new StudenteMedieRS(studente, mapMedieScritto.get(studente), null, null);
			  rit.add(studenteMedieRS);
		  }

		  return rit;
	  }

	  @RequestMapping(value = ApiPath.STRATEGIE, method = RequestMethod.GET)
	  public Collection<MedieStretegyRS> getStrategie() {
		  Collection<MedieStretegyRS> strategie;
		  Set<Class<? extends IMediaStrategy>> subClassStrategie;

		  strategie = new LinkedList<MedieStretegyRS>();
		  subClassStrategie = MediaStrategyFactory.getInstance().getStrategySubclasses();
		  
		  for (Class<? extends IMediaStrategy> aClass : subClassStrategie){
			  strategie.add(new MedieStretegyRS(aClass));
		  }

		  return strategie;
	  }
}
