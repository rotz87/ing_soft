package presenter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import sviluppo.Stampa;
import controller.StartUpController;
import domain.model.Calendario;
import domain.model.GiornoFestivoCriteria;
import domain.model.GiornoSettimanaleFestivoCriteria;

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
