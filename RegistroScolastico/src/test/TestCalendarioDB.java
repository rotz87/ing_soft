package test;


import org.joda.time.LocalDate;
import org.orm.PersistentException;

import service.Stampa;
import domain.model.Calendario;
import domain.model.GiornoFestivoCriteria;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.GiornoSettimanaleFestivoCriteria;

public class TestCalendarioDB {
	public static void main(String[] args){

		try {
			GiornoFestivoCriteria giornoFC = new GiornoFestivoCriteria();
			GiornoSettimanaleFestivoCriteria giornoSFC = new GiornoSettimanaleFestivoCriteria();
			Calendario.getInstance().getGiorniFestivi().addAll(giornoFC.list());
			Calendario.getInstance().getGiorniSettimanaliFestivi().addAll(giornoSFC.list());

			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Stampa.stampaln("giorni festivi: " + Calendario.getInstance().getGiorniFestivi());
		Stampa.stampaln("giorni settimanali festivi: " + Calendario.getInstance().getGiorniSettimanaliFestivi());
		
//		LocalDate localDate = new LocalDate(2014,12,17);
//		GiornoFestivo gg = new GiornoFestivo();
//		gg.setData(localDate.toDate());
//		
//		for (domain.model.GiornoFestivo g : Calendario.getInstance().getGiorniFestivi()){
//			Stampa.stampaln();
//			Stampa.stampa(g.getData());
//			Stampa.stampa("  equals: "+gg.equals(g));
//			Stampa.stampaln();
//		}
//		
//		
//		
//		Boolean contains = Calendario.getInstance().getGiorniFestivi().contains(gg);
//		Stampa.stampaln();
//		Stampa.stampaln("contains: "+contains);
////		
		LocalDate mecoledi = new LocalDate(2014,12,17);
		GiornoSettimanaleFestivo gsRif = new GiornoSettimanaleFestivo(mecoledi.getDayOfWeek());
		for (GiornoSettimanaleFestivo gs : Calendario.getInstance().getGiorniSettimanaliFestivi()){
			Stampa.stampaln();
			Stampa.stampa(gs.getGiorno());
			Stampa.stampa("  equals: "+gsRif.equals(gs));
			Stampa.stampaln();
		}
		
		Boolean contains = Calendario.getInstance().getGiorniSettimanaliFestivi().contains(gsRif);
		Stampa.stampaln();
		Stampa.stampaln("contains: "+contains);
		
//		LinkedList<Giorno> giorni = new LinkedList<Giorno>();
		
//		
//		LinkedHashSet <GiornoFestivo> giorni = new LinkedHashSet<GiornoFestivo>();
//		
//		GiornoFestivo giorno1 = new GiornoFestivo();
//		giorno1.setData(new LocalDate(2014,12,17).toDate());
//		giorni.add(giorno1);
//		
//		GiornoFestivo giorno2 = new GiornoFestivo();
//		giorno2.setData(new LocalDate(2014,12,18).toDate());
//		giorni.add(giorno2);
//		
//		GiornoFestivo giorno3 = new GiornoFestivo();
//		giorno3.setData(new LocalDate(2014,12,19).toDate());
//		giorni.add(giorno3);
//		
//		GiornoFestivo giornoRif = new GiornoFestivo();
//		giornoRif.setData(new LocalDate(2014,12,17).toDate());
//		
//		for (GiornoFestivo g : giorni){
//			Stampa.stampaln();
//			Stampa.stampa(g.getData());
//			Stampa.stampa("  equals: "+giornoRif.equals(g));
//			Stampa.stampaln();
//		}
//		
//		Boolean contains = giorni.contains(giornoRif);
//		Stampa.stampaln();
//		Stampa.stampaln("contains: "+contains);
//		Stampa.stampaln();
		
	}
}
