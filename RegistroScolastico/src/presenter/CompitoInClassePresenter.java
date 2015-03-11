package presenter;

import java.net.URI;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.hibernate.metamodel.relational.Size;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import presenter.resourceSupport.AppelloRS;
import presenter.resourceSupport.ArgomentiContainerRS;
import presenter.resourceSupport.ArgomentoRS;
import presenter.resourceSupport.AssentiContainerRS;
import presenter.resourceSupport.CompitoInClasseRS;
import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.CompitoInClasse;
import domain.model.Argomento;;


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
				
				compitoController = new CompitoInClasseController();
				
				compito = compitoController.getCompitoInCLasse(idCompitoInClasse);
				
				return new CompitoInClasseRS(compito, idClasse, idRegistroDocente);
				
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
		  HttpStatus httpStatus = HttpStatus.CREATED;
		  
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
}
