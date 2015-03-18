package test.compito;

import java.util.Collection;

import org.joda.time.LocalDate;

import presenter.ClassePresenter;
import presenter.StartUp;
import service.Stampa;
import domain.controller.ClasseController;
import domain.model.Calendario;

public class TestDateFestive {

	public static void main(String[] args) {

		ClasseController classeController;
		Collection<LocalDate> dateFestive;
//		Stampa.stampaln(Calendario.getInstance().getGiorniFestivi());
//		Stampa.stampaln(Calendario.getInstance().getGiorniSettimanaliFestivi());

		new StartUp().start();
		classeController = new ClasseController();
//		dateFestive = Calendario.getInstance().getDateFestive();
		dateFestive = classeController.getDateFestive(1);
		
		for (LocalDate data : dateFestive) {
			Stampa.stampaln(data);
		}
		Stampa.stampaln();
		Stampa.stampaln(Calendario.getInstance().getFineLezioni());
		Stampa.stampaln();
		
		ClassePresenter classePresenter = new ClassePresenter();
		classePresenter.getDateFestive(1);
		for (Long l : classePresenter.getDateFestive(1)) {
			Stampa.stampaln("--------------------");
			Stampa.stampaln(new LocalDate(l));
			Stampa.stampaln(l);
		}
		Stampa.stampaln("--------------------");
	}

}
