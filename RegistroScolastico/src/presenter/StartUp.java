package presenter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.orm.PersistentException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
public class StartUp implements ApplicationListener{
	
	@PostConstruct
    public void start() {
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("RegistroScolastico.cfg.xml");
//		DBFake.getInstance();
		
		
		try {
			GiornoFestivoCriteria giornoFC = new GiornoFestivoCriteria();
			GiornoSettimanaleFestivoCriteria giornoSFC = new GiornoSettimanaleFestivoCriteria();
			Calendario.getInstance().getGiorniFestivi().addAll(giornoFC.list());
			Calendario.getInstance().getGiorniSettimanaliFestivi().addAll(giornoSFC.list());

			
		} catch (PersistentException e) {
			// XXX sarebbe da mettere un log Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			//Stempa.stampaln("EVENTO");
			
        }
		
	}

}
