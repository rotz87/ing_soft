package controllerSpring;


import domain.Appello;
import domain.Assenza;
import domain.FaiAppelloController;
import resourceSupport.AppelloRS;
import service.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
				  linkAppello = new AppelloRS(fAController.getAppelloOdierno(idClasse), idClasse, fAController.getStudenti(idClasse), null).getLink("self");
				  httpHeaders.setLocation(URI.create(linkAppello.getHref()));
		  }catch(IllegalStateException ISE){
				  httpStatus = HttpStatus.FORBIDDEN;
//				  System.out.println("AppelloController:"+ISE.getMessage());
		  }

		  return new ResponseEntity<>(null, httpHeaders, httpStatus);

	  }
		
	  
		@RequestMapping(value = "/{idAppello}", method = RequestMethod.GET)
		public AppelloRS getAppello(@PathVariable long idAppello, @PathVariable long idClasse) {
			
			System.out.println("idAppello="+Long.toString(idAppello));
			System.out.println("idClasse="+Long.toString(idClasse));
			
			FaiAppelloController fAController;
			Appello appello;
			HashMap<Long, Assenza> assenze;
			
			fAController = new FaiAppelloController();
			appello = fAController.getAppello(idClasse, idAppello);
			assenze = null;
			
			if(appello.isAssenzePrese()){
				assenze = fAController.getAssenze(idClasse, appello.getIdAppello());
			}
			
			return new AppelloRS(appello, idClasse, fAController.getStudenti(idClasse), assenze);
		}
	
		@RequestMapping(value = "/{idAppello}/assenti", method = RequestMethod.POST)
		public ResponseEntity<?> inserisciAssenze(@PathVariable long idAppello, @PathVariable long idClasse, @RequestBody long[] assenti){
			FaiAppelloController fAController;
			Appello appello;
			Long[] idAssenti;
			
			fAController = new FaiAppelloController();
			appello = fAController.getAppello(idClasse, idAppello);
			
			HttpHeaders httpHeaders;
			httpHeaders = new HttpHeaders();
			HttpStatus httpStatus = HttpStatus.CREATED;
			
			idAssenti = new Long[assenti.length];
			for(int i=0; i<assenti.length; i++){
				idAssenti[i] = assenti[i];
			}
			
			try{
				fAController.registraAssenze(idAssenti, idClasse, this.idDocenteProva);
				
			}catch(IllegalStateException ISE){
				httpStatus = HttpStatus.FORBIDDEN;
			}
			
			return new ResponseEntity<>(null, httpHeaders, httpStatus);
		}
		
//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@PathVariable long idAppello, @RequestBody Bookmark input) {
//
//        //this.validateUser(userId);
//    	
//    	Bookmark bookmark = new Bookmark(input.getUri(), input.getDescription());
//    	
//    	DBSingleton.getIstance().addBookmark(bookmark);
//    	
//    	DBSingleton.getIstance().getAccounts().get(username).addBookmark(bookmark);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//
//        Link forOneBookmark = new BookmarkResource(bookmark).getLink("self");
//        httpHeaders.setLocation(URI.create(forOneBookmark.getHref()));
//
//        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
//
//    }
//	
//    @RequestMapping(method = RequestMethod.GET)
//    public Collection<BookmarkResource> readBookmarks(@PathVariable String username) {
//
//        //this.validateUser(username);
//
//    	List<BookmarkResource> bookmarkResourceList = new LinkedList<BookmarkResource>();
//    	
//    	Map<Long, Bookmark> bookmarks = DBSingleton.getIstance().getAccounts().get(username).getBookmarks();
//    	for (Long id : bookmarks.keySet()) {  		
//    		bookmarkResourceList.add(new BookmarkResource(bookmarks.get(id)));
//		}
// 
//    	return (Collection<BookmarkResource>)bookmarkResourceList;
//        //return new Resources<BookmarkResource>(bookmarkResourceList);
//
//    }
//	
//	@RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET)
//	public BookmarkResource readBookmark(@PathVariable String username, @PathVariable Long bookmarkId) {
//		
//		DBSingleton db;
//		Account account;
//		Bookmark bookmark;
//		
//		account = null;
//		bookmark = null;
//		
//		db = DBSingleton.getIstance();
//		account = db.getAccounts().get(username);
//		if (account != null){
//			bookmark = account.getBookmarks().get(bookmarkId);
//		}
//		
//		//return null;
//		return new BookmarkResource(bookmark);
//		
//	}
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public Calendar getCalendar() {
//		
//		Calendar aaa = Calendar.getInstance();
//				aaa.set(2005, 11, 5);
//		
//		return aaa;
//		
//	}
	
}