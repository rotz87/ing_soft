package presenter;
//package presenter.controllerSpring;
//
//import java.util.Collection;
//import java.util.LinkedList;
//
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import service.Stampa;
//
//@RestController
//@RequestMapping("/help")
//public class HelpController{
//	
//	private boolean linksCreated = false;
//	private LinkedList<String> links;
//	
//	@RequestMapping(method = RequestMethod.GET)
//	Collection<String> print(){
//		
//		if (!this.linksCreated){
//			
//			this.links = new LinkedList<String>();
//			
//			this.links.add(ControllerLinkBuilder.linkTo(
//					ControllerLinkBuilder.methodOn(ClasseController.class, 0L).
//						getStudenti(0)).toUri().toString());
//			this.links.add(ControllerLinkBuilder.linkTo(AppelloController.class, 0L).toUri().toString());
//			this.links.add(ControllerLinkBuilder.linkTo(
//					ControllerLinkBuilder.methodOn(AppelloController.class, 0L).
//						getAppello(0, 0)).toUri().toString());
//			this.linksCreated = true;
//		}
//		
//		Stampa.stampaln("URLs "+AppelloController.class.getName()+":");
//		
//		for (String link : this.links) {
//			Stampa.stampaln(link);
//		}
//		
//		Stampa.stampaln("Fine URLs "+AppelloController.class.getName()+".");
//		
//		return this.links;
//	}
//
//}
