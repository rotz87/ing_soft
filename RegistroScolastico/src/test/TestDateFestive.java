package test;

import org.joda.time.LocalDate;

import presenter.StartUp;
import sviluppo.Stampa;
import controller.RegistroDocenteController;
import domain.model.Calendario;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.RegistroAppelli;

public class TestDateFestive {

	public static void main(String[] args) {
//		FaiAppelloController appelloController;
//		LocalDate data = new LocalDate(2014, 12, 5);
//		appelloController = new FaiAppelloController();
		
//		if(!Calendario.getInstance().isSettimanaleFestivo(data) && appelloController.getAppello(1, data) == null){
//			Stampa.stampaln("True per la data: "+data+" "+data.toDate().getTime());
////			dateFestive.add(data);
//		}else{
//			Stampa.stampaln("False per la data: "+data+" "+data.toDate().getTime());
//		}
		
		new StartUp().start();
		
//		ClasseController classeController = new ClasseController();
////		Stampa.stampa(classeController.getDateFestive(1));
//		for(LocalDate data : classeController.getDateFestive(1)){
//			Stampa.stampaln(data);
//		}
		
		RegistroDocenteController registroDocenteController = new RegistroDocenteController();
		RegistroAppelli registroAssenze = registroDocenteController.getRegistroDocente(1).getClasse().getRegistroAppelli();
		
		for(LocalDate data : registroAssenze.getDateNonFestivePassateSenzaAppello()){
			Stampa.stampaln(data);
		}
		Stampa.stampaln();
		LocalDate localDate = new LocalDate(2014,12,7);
		Stampa.stampaln("Giorni settimanali festivi: "+Calendario.getInstance().getGiorniSettimanaliFestivi());
		Stampa.stampaln("localDate.getDayOfWeek(): "+localDate.getDayOfWeek());		
		Stampa.stampaln(Calendario.getInstance().getGiorniSettimanaliFestivi().contains(new GiornoSettimanaleFestivo(localDate.getDayOfWeek())));
		boolean contain = false;
		for(GiornoSettimanaleFestivo gf : Calendario.getInstance().getGiorniSettimanaliFestivi()){
			if(gf.getGiorno() == localDate.getDayOfWeek()){
				contain = true;
			}
		}
		Stampa.stampaln("contain a mano: "+contain);	
	}

}
