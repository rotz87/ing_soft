package presenter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.springframework.stereotype.Component;

import controller.StartUpController;

/**
 * Inizializza gli oggetti dopo l'avvio del server
 * @author marco
 *
 */
@Singleton 
@Component
public class StartUp /*implements ApplicationListener*/{
	
	@PostConstruct
    public void start() {
		
		StartUpController startUpController = new StartUpController();
		startUpController.start();

    }
}
