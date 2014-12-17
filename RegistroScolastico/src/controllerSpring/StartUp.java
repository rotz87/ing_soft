package controllerSpring;

import test.InitRegistraAssenzeServer;

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
		
		InitRegistraAssenzeServer.main(null);
		
    }

}
