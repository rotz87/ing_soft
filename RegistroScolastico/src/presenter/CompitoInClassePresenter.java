package presenter;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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

import presenter.resourceSupport.appello.AppelloRS;
import presenter.resourceSupport.compito.ArgomentiContainerRS;
import presenter.resourceSupport.compito.ArgomentoRS;
import presenter.resourceSupport.compito.CompitoInClasseRS;
import presenter.resourceSupport.compito.StudenteCompitoRS;
import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.controller.FaiAppelloController;
import domain.model.Argomento;
import domain.model.Calendario;
import domain.model.CompitoInClasse;
import domain.model.Studente;
import domain.model.Voto;


@RestController
@RequestMapping("/classi/{idClasse}/registroDocente/{idRegistroDocente}/compiti")
public class CompitoInClassePresenter {

	
	  @RequestMapping(method = RequestMethod.POST)
	  	ResponseEntity<?> creaCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
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

	  
	  @RequestMapping(value = "/{idCompitoInClasse}",  method = RequestMethod.GET)
			public CompitoInClasseRS getCompitoInClasse(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
				
			  	CompitoInClasseController compitoController;
				CompitoInClasse compito;
				CompitoInClasseRS compitoInClasseRS;
				
				compitoController = new CompitoInClasseController();
				
				compito = compitoController.getCompitoInCLasse(idCompitoInClasse);
				
				compitoInClasseRS = new CompitoInClasseRS(compito, idClasse, idRegistroDocente);
				
				return compitoInClasseRS;
				
	  }
	  
	  
	  @RequestMapping( method = RequestMethod.GET)
		public CompitoInClasseRS[] getCompitiInClasse(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
			
//			return new String("SONO IN GETCOMPITI! "+ idClasse + " " +idRegistroDocente);
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
	  
	  @RequestMapping(value = "/{idCompitoInClasse}", method = RequestMethod.PUT)
	  public ResponseEntity<?> inserisciInfoCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse,  @RequestBody CompitoInClasseRS compitoRS ){
		  CompitoInClasseController compitoController;
		  int[] idArgomenti = new int[compitoRS.getArgomentiRS().size()];

		  compitoController = new CompitoInClasseController();
		  
		  java.sql.Date dataCompito = new java.sql.Date(compitoRS.getData());
		  java.sql.Time oraInizio = new java.sql.Time(compitoRS.getOraInizio());
		  java.sql.Time oraFine = new java.sql.Time(compitoRS.getOraFine());
		  
		  int i = 0;
		  for(ArgomentoRS argomentoRS : compitoRS.getArgomentiRS()){
			  idArgomenti[i] = argomentoRS.getIdArgomento();
			  i++;
		  }
		  
		  compitoController.inserisciInfoCompito(idRegistroDocente, compitoRS.getIdCompito(), dataCompito, oraInizio, oraFine, idArgomenti);
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
	  
	  @RequestMapping(value = "/{idCompitoInClasse}/argomenti", method = RequestMethod.GET)
	  public ArgomentiContainerRS getArgomentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
		  CompitoInClasseController compitoController;
		  CompitoInClasse compito;
		  LinkedList<ArgomentoRS> argomentiRS = new LinkedList<ArgomentoRS>();

		  compitoController = new CompitoInClasseController();
		  compito = compitoController.getCompitoInCLasse(idCompitoInClasse);
		  for(Argomento argomento : compito.getArgomentiEsaminati()){
			  argomentiRS.add(new ArgomentoRS(argomento));
		  }
		  
		  
		  return new ArgomentiContainerRS(argomentiRS);
		  
	  }
	  
//	  @RequestMapping(value = "/{idCompitoInClasse}/studenti", method = RequestMethod.GET)
//	  public Collection<StudenteCompitoRS> getStudentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse) {
//		  
//		  //TODO Controllare i parametri che non servono
//		  
//		  CompitoInClasseController compitoInClasseController;
//		  Map<Studente, Boolean> assenze;
//		  Map<Studente, Voto> voti;
//		  Collection<StudenteCompitoRS> studentiCompito;
//
//		  compitoInClasseController = new CompitoInClasseController();
//
//		  assenze = compitoInClasseController.getAssenzeCompito(idCompitoInClasse);
//		  voti = compitoInClasseController.getVotiCompito(idCompitoInClasse);
//		  
//		  studentiCompito = new LinkedList<StudenteCompitoRS>();
//		  for (Studente studente : assenze.keySet()) {
//			studentiCompito.add(new StudenteCompitoRS(studente, voti.get(studente), assenze.get(studente)));
//		  }
//		  
//		  return studentiCompito;
//		  
//	  }
	  
	  @RequestMapping(value = "/{idCompitoInClasse}/studenti", method = RequestMethod.GET, params = {"data"})
	  public Collection<StudenteCompitoRS> getStudentiCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse, @RequestParam(value="data") long data) {
		  
		  //TODO Controllare i parametri che non servono
		  
		  CompitoInClasseController compitoInClasseController;
		  FaiAppelloController faiAppelloController;
		  Map<Studente, Boolean> assenze;
		  Map<Studente, Voto> voti;
		  Collection<StudenteCompitoRS> studentiCompito;
		  LocalDate localDate;

		  compitoInClasseController = new CompitoInClasseController();
		  faiAppelloController = new FaiAppelloController();

		  localDate = new LocalDate(data);
		  assenze = faiAppelloController.getBoolAssenze(idClasse, localDate);
		  voti = compitoInClasseController.getVotiCompito(idCompitoInClasse);
		  
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
	  
	  @RequestMapping(value = "/{idCompitoInClasse}/studenti", method = RequestMethod.PUT)
	  public ResponseEntity<?> updateStudentiCompito(@PathVariable int idCompitoInClasse, @RequestBody StudenteCompitoRS[] studentiCompito) {
		   
		  CompitoInClasseController compitoInClasseController;
		  Map<Integer, Byte> mapVoti;
		  
		  compitoInClasseController = new CompitoInClasseController();
		  mapVoti = new HashMap<Integer, Byte>();
		  
		  for(StudenteCompitoRS studenteConpitoRS : studentiCompito){
			  mapVoti.put(studenteConpitoRS.getIdStudente(), studenteConpitoRS.getVoto());
		  }
		  
		  compitoInClasseController.inserisciVoti(idCompitoInClasse, mapVoti);
		  
		  HttpHeaders httpHeaders;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.OK;
		  
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	  }
}
