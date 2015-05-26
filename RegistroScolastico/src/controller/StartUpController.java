package controller;

import org.joda.time.LocalDate;
import org.orm.PersistentException;

import domain.model.Calendario;
import domain.model.GiornoFestivoCriteria;
import domain.model.GiornoSettimanaleFestivoCriteria;

public class StartUpController {
	
    public void start() {
		
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
}
