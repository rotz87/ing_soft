package presenter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Inizializza gli oggetti dopo l'avvio del server
 * @author marco
 *
 */
@Singleton 
@Component
public class StartUp implements ApplicationListener{
	
	@PostConstruct
    public void start() {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("RegistroScolastico.cfg.xml");
//		DBFake.getInstance();
		
    }

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			//Stempa.stampaln("EVENTO");
			
        }
		
	}

}
