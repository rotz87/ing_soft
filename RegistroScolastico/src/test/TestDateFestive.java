package test;

import org.joda.time.LocalDate;

import sviluppo.Stampa;
import controller.FaiAppelloController;
import domain.model.Calendario;

public class TestDateFestive {

	public static void main(String[] args) {
		FaiAppelloController appelloController;
		LocalDate data = new LocalDate(2014, 12, 5);
		appelloController = new FaiAppelloController();
		
		if(!Calendario.getInstance().isSettimanaleFestivo(data) && appelloController.getAppello(1, data) == null){
			Stampa.stampaln("True per la data: "+data+" "+data.toDate().getTime());
//			dateFestive.add(data);
		}else{
			Stampa.stampaln("False per la data: "+data+" "+data.toDate().getTime());
		}
	}

}
