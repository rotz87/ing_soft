package test;


import org.joda.time.LocalDate;

import service.Stampa;
import domain.model.Calendario;
import domain.model.Giorno;

public class TestCalendarioDB {
	public static void main(String[] args){
		Stampa.stampaln("giorni festivi: " + Calendario.getInstance().getGiorniFestivi());
		
		LocalDate localDate = new LocalDate(2014,12,17);
		Giorno gg = new Giorno();
		gg.setData(localDate.toDate());
		
		for (domain.model.Giorno g : Calendario.getInstance().getGiorniFestivi()){
			Stampa.stampaln();
			Stampa.stampa(g.getData());
			Stampa.stampa("  equals: "+gg.equals(g));
			Stampa.stampaln();
		}
		
		
		
		Boolean contains = Calendario.getInstance().getGiorniFestivi().contains(gg);
		Stampa.stampaln();
		Stampa.stampaln("contains: "+contains);
	}
}
