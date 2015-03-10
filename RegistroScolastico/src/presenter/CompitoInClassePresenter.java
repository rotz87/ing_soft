package presenter;

import java.net.URI;
import java.util.LinkedHashSet;
import java.util.LinkedList;

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
		public String getCompitiInClasse(@PathVariable int idClasse, @PathVariable int idRegistroDocente) {
			
			return new String("SONO IN GETCOMPITI! "+ idClasse + " " +idRegistroDocente);
			
		}
	  
	  @RequestMapping(value = "/{idCompitoInClasse}", method = RequestMethod.PUT)
	  public ResponseEntity<?> InserisciInfoCompito(@PathVariable int idClasse, @PathVariable int idRegistroDocente, @PathVariable int idCompitoInClasse,  @RequestBody CompitoInClasseRS campitoRS ){
		  CompitoInClasseController compitoController;
		  
		  compitoController = new CompitoInClasseController();
		  
		  //compitoController.inserisciInfoCompito(idRegistroDocente, campitoRS.getIdCompito(), campitoRS.getData(), campitoRS.getOraInizio(), campitoRS.getOraFine(), null);
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
