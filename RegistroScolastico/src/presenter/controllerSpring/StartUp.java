package presenter.controllerSpring;

import service.DBFake;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

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
		
		DBFake.getInstance();
		
    }

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			//System.out.println("EVENTO");
        }
		
	}

}
