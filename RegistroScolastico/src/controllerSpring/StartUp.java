package controllerSpring;

import service.DBFake;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * Inizializza gli oggetti dopo l'avvio del server
 * @author marco
 *
 */



@Singleton 
@Component
public class StartUp {
	
	@PostConstruct
    public void start() {
		
		DBFake.getInstance();
		
//		System.out.println("URLs Registro Scolastico:");
//		System.out.println(ControllerLinkBuilder.linkTo(AppelloController.class, 0L).toString());
//		ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(AppelloController.class, 0L).
//					getStudenti(0L, 0L)).withRel("studenti"));
		
		
    }

}
