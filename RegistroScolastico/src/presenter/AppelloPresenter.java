package presenter;


import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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

import presenter.resourceSupport.AppelliContainerRS;
import presenter.resourceSupport.AppelloRS;
import presenter.resourceSupport.AssentiContainerRS;
import service.Stampa;
import domain.controller.DocenteController;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Calendario;


@RestController
@RequestMapping("/classi/{idClasse}/appelli")
public class AppelloPresenter {
	
//	  private int idDocenteProva = 31;
	  
	
	  @RequestMapping(method = RequestMethod.POST)
	  ResponseEntity<?> creaAppello(@PathVariable int idClasse) {
		  HttpHeaders httpHeaders;
		  FaiAppelloController fAController;
		  DocenteController docenteController;
	  	
		  Link linkAppello;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.CREATED;
		  
		  fAController = new FaiAppelloController();
		  docenteController = new DocenteController();
		  
		  fAController.avviaAppello(idClasse, docenteController.getIdDocenteProva());
	
		  //serve solo il link: si potrebbero passare meno parametri
		  linkAppello = new AppelloRS(fAController.getAppelloOdierno(idClasse), idClasse).getLink("self");
		  httpHeaders.setLocation(URI.create(linkAppello.getHref()));

	
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	
	  }
		
	  
		@RequestMapping(value = "/{idAppello}", method = RequestMethod.GET)
		public AppelloRS getAppello(@PathVariable int idAppello, @PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			
			fAController = new FaiAppelloController();
			
			appello = fAController.getAppello(idClasse, idAppello);
			return new AppelloRS(appello, idClasse);
			
		}
		
		
		@RequestMapping(method = RequestMethod.GET)
		public AppelliContainerRS getAppelli(@PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Collection<Appello> appelli;
			Collection<AppelloRS> appelliRS;
			Boolean appelloAvviabile;
			Date dataAppelloOdierno;

			fAController = new FaiAppelloController();
			appelli = fAController.getAppelli(idClasse);
			appelliRS = new LinkedList<AppelloRS>();
			
			
			for (Appello appello : appelli) {
				appelliRS.add(new AppelloRS(appello, idClasse));
			}
			
			appelloAvviabile = fAController.isAppelloOdiernoAvviabile(idClasse);
			dataAppelloOdierno = Calendario.getInstance().getDataOdierna().toDate();
			
			return new AppelliContainerRS(appelloAvviabile, dataAppelloOdierno, appelliRS);

		}
		
	
		@RequestMapping(value = "/{idAppello}/assenti", method = RequestMethod.POST)
		public ResponseEntity<?> inserisciAssenze(@PathVariable int idAppello, @PathVariable int idClasse, @RequestBody AssentiContainerRS assenti){
			FaiAppelloController fAController;
			DocenteController docenteController;
			
			Integer[] idAssenti;
			int i;
			
			fAController = new FaiAppelloController();
			docenteController = new DocenteController();
			
			HttpHeaders httpHeaders;
			httpHeaders = new HttpHeaders();
			HttpStatus httpStatus = HttpStatus.CREATED;
			
			idAssenti = new Integer[assenti.assenti.size()];
			i=0;
			for(Integer idAssente: assenti.assenti){
				idAssenti[i] = idAssente;
				i++;
			}
			
			fAController.registraAssenze(idAssenti, idClasse, docenteController.getIdDocenteProva());
			
			return new ResponseEntity<>(null, httpHeaders, httpStatus);
		}
		
		
		/**
		 * Restituisce gli id degli studenti assenti
		 * 
		 * @param idAppello
		 * @param idClasse
		 * @return Collection<idStudentiAssenti>
		 */
		@RequestMapping(value = "/{idAppello}/assenti", method = RequestMethod.GET)
		public AssentiContainerRS getAssenti(@PathVariable int idAppello, @PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			AssentiContainerRS assenti;
			HashMap<Integer, Assenza> assenze;

			fAController = new FaiAppelloController();
			appello = fAController.getAppello(idClasse, idAppello);
			assenti = new AssentiContainerRS();
			
			if(fAController.getAppello(idClasse, idAppello).getAssenzePrese()){
				assenze = fAController.getAssenze(idClasse, appello.getID());
				for (Integer idS : assenze.keySet()) {
					if(assenze.get(idS)!=null){
						assenti.assenti.add(idS);
					}
				}
			}
			
			return assenti;
		}
		
}