package controllerSpring;

import service.DBFake;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

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
		
    }

}
