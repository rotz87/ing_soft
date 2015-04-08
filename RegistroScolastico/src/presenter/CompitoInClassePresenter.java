package presenter;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.jgroups.protocols.DELAY;
import org.joda.time.LocalDate;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.compito.ArgomentiContainerRS;
import presenter.resourceSupport.compito.ArgomentoRS;
import presenter.resourceSupport.compito.CompitoInClasseRS;
import presenter.resourceSupport.compito.CompitoInClasseStateRS;
import presenter.resourceSupport.compito.StudenteCompitoRS;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.controller.FaiAppelloController;
import domain.model.Argomento;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;


@RestController
//@RequestMapping("/classi/{idClasse}/registriDocente/{idRegistroDocente}/compiti")
@RequestMapping(ApiPath.REGISTRO_DOCENTE_COMPITI)
public class CompitoInClassePresenter {

	
	  @RequestMapping(method = RequestMethod.POST)
	  public ResponseEntity<?> creaCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
		  HttpHeaders httpHeaders;
		  CompitoInClasseController compitoController;
		  DocenteController docenteController;
		  CompitoInClasse compito;
	  	
		  Link linkCompito;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.CREATED;
		  
		  compitoController = new CompitoInClasseController();
		  docenteController = new DocenteController();
		  
		  compito = compitoController.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
		  
		  linkCompito = new CompitoInClasseRS(compito, idClasse, idRegistroDocente).getLink("self");
		  httpHeaders.setLocation(URI.create(linkCompito.getHref()));

	
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	
	  }

	  
//	  @RequestMapping(value = "/{idCompitoInClasse}",  method = RequestMethod.GET)
	  @RequestMapping(value = ApiPath.ID_COMPITO,  method = RequestMethod.GET)
	  public CompitoInClasseRS getCompitoInClasse(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
				
		CompitoInClasseController compitoController;
		CompitoInClasse compito;
		CompitoInClasseRS compitoInClasseRS;
		
		compitoController = new CompitoInClasseController();
		
		compito = compitoController.getCompitoInCLasse(idClasse, idRegistroDocente, idCompitoInClasse);
		
		compitoInClasseRS = new CompitoInClasseRS(compito, idClasse, idRegistroDocente);
		
		return compitoInClasseRS;
				
	  }
	  
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/state",  method = RequestMethod.GET)
	  @RequestMapping(value = ApiPath.COMPITO_STATE,  method = RequestMethod.GET)
	  public CompitoInClasseStateRS getCompitoState(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
				
		CompitoInClasseController compitoController;
		CompitoInClasse compito;
		CompitoInClasseStateRS compitoStateRS;
		
		compitoController = new CompitoInClasseController();
		
		compito = compitoController.getCompitoInCLasse(idClasse, idRegistroDocente, idCompitoInClasse);
		
		compitoStateRS = new CompitoInClasseStateRS(compito, idClasse, idRegistroDocente);
		
		return compitoStateRS;
				
	  }
	  
	  
	  @RequestMapping( method = RequestMethod.GET)
	  public CompitoInClasseRS[] getCompitiInClasse(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
			
//		return new String("SONO IN GETCOMPITI! "+ idClasse + " " +idRegistroDocente);
		Collection<CompitoInClasse> compitiCollection;
		CompitoInClasseController compitoController;
		compitoController = new CompitoInClasseController();
		
		compitiCollection = compitoController.getCompitiInCLasse(idClasse, idRegistroDocente);
		int size = compitiCollection.size();
		
		CompitoInClasseRS[] compitiRS = new CompitoInClasseRS[size];
		
		  
		  int i = 0;
		  for(CompitoInClasse compito : compitiCollection){
			  compitiRS[i] = new CompitoInClasseRS(compito, idClasse, idRegistroDocente);
			  i++;
		  }
		  
		  
		  return compitiRS;
			
		}
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}", method = RequestMethod.PUT)
	  @RequestMapping(value = ApiPath.ID_COMPITO, method = RequestMethod.PUT)
	  public ResponseEntity<?> inserisciInfoCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse,  @RequestBody CompitoInClasseRS compitoRS ){
		  CompitoInClasseController compitoController;
		  int[] idArgomenti;

		  java.sql.Date dataCompito = null;
		  java.sql.Time oraInizio = null;
		  java.sql.Time oraFine = null;

		  idArgomenti = new int[compitoRS.getArgomentiRS().size()];
		  
		  compitoController = new CompitoInClasseController();
		  
		  if(compitoRS.getData() != null){
			  dataCompito = new java.sql.Date(compitoRS.getData());
		  }
		  if(compitoRS.getOraInizio() != null){
			  oraInizio = new java.sql.Time(compitoRS.getOraInizio());
		  }
		  if(compitoRS.getOraFine() != null){
			  oraFine = new java.sql.Time(compitoRS.getOraFine());
		  }
		  int i = 0;
		  for(ArgomentoRS argomentoRS : compitoRS.getArgomentiRS()){
			  idArgomenti[i] = argomentoRS.getIdArgomento();
			  i++;
		  }
		  
		  compitoController.inserisciInfoCompito(idClasse, idRegistroDocente, compitoRS.getIdCompito(), dataCompito, oraInizio, oraFine, idArgomenti);
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/state", method = RequestMethod.PUT)
	  @RequestMapping(value = ApiPath.COMPITO_STATE, method = RequestMethod.PUT)
	  public ResponseEntity<?> updateCompitoState(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse, @RequestBody CompitoInClasseStateRS compitoState) {
		  
		  CompitoInClasseController compitoInClasseController;
		  
		  compitoInClasseController = new CompitoInClasseController();
		  
		  compitoInClasseController.changeState(idClasse, idRegistroDocente, idCompitoInClasse, compitoState.getState());
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/state", method = RequestMethod.DELETE)
	  @RequestMapping(value = ApiPath.COMPITO_STATE, method = RequestMethod.DELETE)
	  public ResponseEntity<?> eliminaCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
		   
		  CompitoInClasseController compitoInClasseController;
		  
		  compitoInClasseController = new CompitoInClasseController();
		  
		  compitoInClasseController.eliminaCompito(idClasse, idRegistroDocente, idCompitoInClasse);
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/argomenti", method = RequestMethod.GET)
	  @RequestMapping(value = ApiPath.COMPITO_ARGOMENTI, method = RequestMethod.GET)
	  public ArgomentiContainerRS getArgomentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
		  CompitoInClasseController compitoController;
		  CompitoInClasse compito;
		  LinkedList<ArgomentoRS> argomentiRS = new LinkedList<ArgomentoRS>();

		  compitoController = new CompitoInClasseController();
		  compito = compitoController.getCompitoInCLasse(idClasse, idRegistroDocente, idCompitoInClasse);
		  for(Argomento argomento : compito.getArgomentiEsaminati()){
			  argomentiRS.add(new ArgomentoRS(argomento));
		  }
		  
		  
		  return new ArgomentiContainerRS(argomentiRS);
		  
	  }
	  
/**
	 * 
	 * @param idClasse
	 * @param idRegistroDocente
	 * @param idCompitoInClasse
	 * @param data
	 */
	  
//	  @RequestMapping(value="/{idCompitoInClasse}/studenti", method=RequestMethod.GET, params={"data"})
	  @RequestMapping(value= ApiPath.COMPITO_STUDENTI, method=RequestMethod.GET, params={"data"})
	  public Collection<StudenteCompitoRS> getStudentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse, @RequestParam("data") long data) {
		  
		  //FIXME Controllare i parametri che non servono
		  
		  CompitoInClasseController compitoInClasseController;
		  FaiAppelloController faiAppelloController;
		  Map<Studente, Boolean> assenze;
		  Map<Studente, Voto> voti;
		  Collection<StudenteCompitoRS> studentiCompito;
		  LocalDate localDate;

		  compitoInClasseController = new CompitoInClasseController();
		  faiAppelloController = new FaiAppelloController();

		  localDate = new LocalDate(data);
		  assenze = faiAppelloController.getAssenzeCompito(idClasse, localDate);
		  voti = compitoInClasseController.getVotiCompito(idClasse, idRegistroDocente, idCompitoInClasse);
		  
		  studentiCompito = new LinkedList<StudenteCompitoRS>();
		  /*
		   * Il ciclo FOR deve scorrere le assenze, perché se le assenze sono vuote
		   * significa che non c'è un appello con le assenze registrate, corrispondente alla data richiesta.
		   * 
		   */
		  for (Studente studente : assenze.keySet()) {
			studentiCompito.add(new StudenteCompitoRS(studente, voti.get(studente), assenze.get(studente)));
		  }
		  
		  return studentiCompito;
		  
	  }
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/studenti", method = RequestMethod.PUT)
	  @RequestMapping(value= ApiPath.COMPITO_STUDENTI,  method = RequestMethod.PUT)
	  public ResponseEntity<?> updateStudentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse, @RequestBody StudenteCompitoRS[] studentiCompito) {
		   
		  CompitoInClasseController compitoInClasseController;
		  Map<Integer, Byte> mapVoti;
		  
		  compitoInClasseController = new CompitoInClasseController();
		  mapVoti = new HashMap<Integer, Byte>();
		  
		  for(StudenteCompitoRS studenteConpitoRS : studentiCompito){
			  mapVoti.put(studenteConpitoRS.getIdStudente(), studenteConpitoRS.getVoto());
		  }
		  
		  compitoInClasseController.inserisciVoti(idClasse, idRegistroDocente, idCompitoInClasse, mapVoti);
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
}
