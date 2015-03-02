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
		  
		  try{
				  fAController.avviaAppello(idClasse, docenteController.getIdDocenteProva());
				  Stampa.stampaln("Appello odierno: "+fAController.getAppelloOdierno(idClasse).getID() + " | " + fAController.getAppelloOdierno(idClasse).getData());
	
			  //serve solo il link: si potrebbero passare meno parametri
			  linkAppello = new AppelloRS(fAController.getAppelloOdierno(idClasse), idClasse).getLink("self");
			  httpHeaders.setLocation(URI.create(linkAppello.getHref()));
		  }catch(IllegalStateException ISE){
			  httpStatus = HttpStatus.FORBIDDEN;
	//				  Stempa.stampaln("AppelloController:"+ISE.getMessage());
		  }catch(Exception PE){
			  // TODO Auto-generated catch block
			  httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
			  Stampa.stampaln("creaAppello - SERVICE_UNAVAILABLE");
			  //TODO far ritornare uno stato http coerente con l'errore
		  }
	
		  return new ResponseEntity<>(null, httpHeaders, httpStatus);
	
	  }
		
	  
		@RequestMapping(value = "/{idAppello}", method = RequestMethod.GET)
		public AppelloRS getAppello(@PathVariable int idAppello, @PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			
			fAController = new FaiAppelloController();
			try {
				appello = fAController.getAppello(idClasse, idAppello);
				return new AppelloRS(appello, idClasse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;// TODO far ritornare uno stato http coerente con l'errore
			}
			
			
		}
		
		
		@RequestMapping(method = RequestMethod.GET)
		public AppelliContainerRS getAppelli(@PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Collection<Appello> appelli;
			Collection<AppelloRS> appelliRS;
			Boolean appelloAvviabile;
			Date dataAppelloOdierno;
			try{
				fAController = new FaiAppelloController();
				appelli = fAController.getAppelli(idClasse);
				appelliRS = new LinkedList<AppelloRS>();
				
				
				for (Appello appello : appelli) {
					appelliRS.add(new AppelloRS(appello, idClasse));
				}
				
				appelloAvviabile = fAController.isAppelloOdiernoAvviabile(idClasse);
				dataAppelloOdierno = Calendario.getInstance().getDataOdierna().toDate();
				
				return new AppelliContainerRS(appelloAvviabile, dataAppelloOdierno, appelliRS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null; // TODO far ritornare uno stato http coerente con l'errore
			}
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
			
			try{
				Stampa.stampaln("inserisciAssenze.registraAssenze-PRIMA");
				fAController.registraAssenze(idAssenti, idClasse, docenteController.getIdDocenteProva());
				Stampa.stampaln("inserisciAssenze.registraAssenze-DOPO");
			}catch(IllegalStateException ISE){
				httpStatus = HttpStatus.FORBIDDEN;
				ISE.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
				Stampa.stampaln("inserisciAssenze.registraAssenze-SERVICE_UNAVAILABLE");
				//TODO far ritornare uno stato http coerente con l'errore
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
		public AssentiContainerRS getAssenti(@PathVariable int idAppello, @PathVariable int idClasse) {
			
			FaiAppelloController fAController;
			Appello appello;
			AssentiContainerRS assenti;
			HashMap<Integer, Assenza> assenze;
			
			try {
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null; // TODO far ritornare uno stato http coerente con l'errore
			}
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