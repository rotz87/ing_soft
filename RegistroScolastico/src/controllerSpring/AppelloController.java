package controllerSpring;


import domain.Appello;
import domain.Assenza;
import domain.Calendario;
import domain.FaiAppelloController;
import domain.Studente;
import resourceSupport.AppelliContainerRS;
import resourceSupport.AppelloRS;
import resourceSupport.AssentiContainerRS;
import resourceSupport.StudenteAppelloRS;

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


@RestController
@RequestMapping("/classi/{idClasse}/appelli")
public class AppelloController {
	
	  private long idDocenteProva = 1;
	
	  @RequestMapping(method = RequestMethod.POST)
	  ResponseEntity<?> creaAppello(@PathVariable long idClasse) {
		  HttpHeaders httpHeaders;
	
		  FaiAppelloController fAController;
	  	
		  Link linkAppello;
		  httpHeaders = new HttpHeaders();
		  HttpStatus httpStatus = HttpStatus.CREATED;
		  
		  fAController = new FaiAppelloController();
		  
		  try{
				  fAController.avviaAppello(idClasse, this.idDocenteProva);
				  System.out.println("Appello odierno: "+fAController.getAppelloOdierno(idClasse).getIdAppello() + " | " + fAController.getAppelloOdierno(idClasse).getData());
	
			  //serve solo il link: si potrebbero passare meno parametri
			  linkAppello = new AppelloRS(fAController.getAppelloOdierno(idClasse), idClasse).getLink("self");
			  httpHeaders.setLocation(URI.create(linkAppello.getHref()));
		  }catch(IllegalStateException ISE){
			  httpStatus = HttpStatus.FORBIDDEN;
	//				  System.out.println("AppelloController:"+ISE.getMessage());
		  }
	
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	
	  }
		
	  
		@RequestMapping(value = "/{idAppello}", method = RequestMethod.GET)
		public AppelloRS getAppello(@PathVariable long idAppello, @PathVariable long idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			
			fAController = new FaiAppelloController();
			appello = fAController.getAppello(idClasse, idAppello);
			
			return new AppelloRS(appello, idClasse);
		}
		
		
		@RequestMapping(method = RequestMethod.GET)
		public AppelliContainerRS getAppelli(@PathVariable long idClasse) {
			
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
		public ResponseEntity<?> inserisciAssenze(@PathVariable long idAppello, @PathVariable long idClasse, @RequestBody AssentiContainerRS assenti){
			FaiAppelloController fAController;
			Long[] idAssenti;
			int i;
			
			fAController = new FaiAppelloController();
			HttpHeaders httpHeaders;
			httpHeaders = new HttpHeaders();
			HttpStatus httpStatus = HttpStatus.CREATED;
			
			idAssenti = new Long[assenti.assenti.size()];
			i=0;
			for(Long idAssente: assenti.assenti){
				idAssenti[i] = idAssente;
				i++;
			}
			
			try{
				fAController.registraAssenze(idAssenti, idClasse, this.idDocenteProva);
				
			}catch(IllegalStateException ISE){
				httpStatus = HttpStatus.FORBIDDEN;
			}
			
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
		public AssentiContainerRS getAssenti(@PathVariable long idAppello, @PathVariable long idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			AssentiContainerRS assenti;
			HashMap<Long, Assenza> assenze;
			
			fAController = new FaiAppelloController();
			appello = fAController.getAppello(idClasse, idAppello);
			assenti = new AssentiContainerRS();
			
			if(fAController.getAppello(idClasse, idAppello).isAssenzePrese()){
				assenze = fAController.getAssenze(idClasse, appello.getIdAppello());
				for (Long idS : assenze.keySet()) {
					if(assenze.get(idS)!=null){
						assenti.assenti.add(idS);
					}
				}
			}
			
			return assenti;
		}
		
		
//		@RequestMapping(value = "/provap", method = RequestMethod.POST)
//		public ResponseEntity<?> provap(@PathVariable long idClasse, @RequestBody Collection<MyCont> appello) {
//			
//			HttpHeaders httpHeaders = new HttpHeaders();
//			HttpStatus httpStatus = HttpStatus.CREATED;
//			
//			
//			
//			return new ResponseEntity<>(null, httpHeaders, httpStatus);
//		}
//		
//		@RequestMapping(value = "/provag", method = RequestMethod.GET)
//		public Collection<Object> provag() {
//			
//			LinkedList<Object> lista;
//			
//			lista = new LinkedList<Object>();
//			
//			lista.add(new MyCont(1, "aaa"));
//			lista.add(new MyCont(2, "bbb"));
//			
//			lista.add(new MyCont1(true, null));
//			
//			return lista;
//		}
		
}