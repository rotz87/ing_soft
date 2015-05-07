package presenter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.joda.time.LocalDate;
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
		
		try {
			GiornoFestivoCriteria giornoFC = new GiornoFestivoCriteria();
			GiornoSettimanaleFestivoCriteria giornoSFC = new GiornoSettimanaleFestivoCriteria();
			Calendario.getInstance().getGiorniFestivi().addAll(giornoFC.list());
			Calendario.getInstance().getGiorniSettimanaliFestivi().addAll(giornoSFC.list());
			Calendario.getInstance().setInizioLezioni(new LocalDate(2014,12,01));
			Calendario.getInstance().setFineLezioni(new  LocalDate(2015,6,12));

			
		} catch (PersistentException e) {
			// si potrebbe mettere un log 
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
