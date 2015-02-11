package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import domain.model.Appello;
import service.Stampa;

//import org.orm.util.ORMMap;
//
//import domain.persistent.RegistroScolasticoPersistentManager;



public class TestDate {
	public static void main(String[] args){

		GregorianCalendar g = new GregorianCalendar(2014,1,5);
		Stampa.stampaln(g.getTime());
		
		 DateTime dt = new DateTime();
		 Stampa.stampaln(dt);
		 
		 LocalTime lt = new LocalTime();
		 Stampa.stampaln(lt);
		 
		 LocalDate ld = new LocalDate();
		 Stampa.stampaln(ld);
		 LocalDate ldplus = ld.plusDays(1);
		 Stampa.stampaln("ldPlus " +ldplus);
		 
// --- STRATEGIA FESTIVI + DOMENICA NO SCUOLA
// il sabato in questa strategia è considerato giorno scolastico
		 
		 TreeSet<LocalDate> calendarioFestivi = new TreeSet<LocalDate>();
		 calendarioFestivi.add(new LocalDate(2014,12,10));
		 calendarioFestivi.add(new LocalDate(2014,12,11));
		 calendarioFestivi.add(new LocalDate(2014,12,12));
		 calendarioFestivi.add(new LocalDate(2014,12,13));
		 calendarioFestivi.add(new LocalDate(2014,12,25));
		 calendarioFestivi.add(new LocalDate(2014,12,26));
		 calendarioFestivi.add(new LocalDate(2014,12,27));
		 
		 LocalDate ultimaData = new LocalDate(2014,12,9);//<<-- ULTIMA DATA DELL'ASSENZA a regime bisogna prenderla dalla list di date dellassenza
		 
		 LocalDate oggi = new LocalDate(2014,12,15); //<<-- data di riferimento

		 boolean inseribile = false;
		 
		 // nel metodo che farà questi controlli si immagina che la data oggi sia passata per parametro
		 // di domenica o in un giorno festivo non si può rientrare a scuola
		 if(oggi.getDayOfWeek()== 7 || calendarioFestivi.contains(oggi)){
			 throw new IllegalStateException( "NON PUOI CREARE UNA' ASSENZA PER QUESTO GIORNO : "+oggi);
		 }
		 
		 LocalDate ultimaDataPlus = ultimaData.plusDays(1);
		 LocalDate dataPotRientro = ultimaDataPlus;
		 
		Iterator<LocalDate> iterator = calendarioFestivi.iterator();

		if(ultimaDataPlus.getDayOfWeek() == 7 && !((calendarioFestivi.contains(ultimaDataPlus)))){
			ultimaDataPlus = ultimaDataPlus.plusDays(1);
		}else if(calendarioFestivi.contains(ultimaDataPlus)) {
//			Stempa.stampaln("passo per l'else if: " );
		// entro nel ciclo se il giorno dopo l'ultimo giorno di assenza è festivo
			 while(calendarioFestivi.contains(ultimaDataPlus) && true/*iterator.hasNext()*/){
	//			 iterator.next();
				 ultimaDataPlus = ultimaDataPlus.plusDays(1);
//				 Stempa.stampaln("passo per il while: " );
			 }//end while
		}
		 if(ultimaDataPlus.getDayOfWeek()==7){
			 ultimaDataPlus = ultimaDataPlus.plusDays(1);
		 }

			if(ultimaDataPlus.isEqual(oggi)){
				inseribile = true;
			}else{
				inseribile = false;
			}
// --- FINE STRATEGIA FESTIVI + DOMENICA NO SCUOLA
			
			Stampa.stampaln("ultimaData: "+ ultimaData);
			Stampa.stampaln("ultimaDataPlus: "+ ultimaDataPlus);
			Stampa.stampaln("oggi: "+ oggi);
			Stampa.stampaln("inseribile: "+ inseribile);
			
			
//			Stampa.stampaln("_____________________________________");
//			LinkedList<Integer> pippo = new LinkedList<Integer>();
//			pippo.add(new Integer(1));
//			pippo.add(new Integer(2));
//			LocalDate localDate = new LocalDate(2015,01,12);
//			Stampa.stampaln("day of week: " + localDate.getDayOfWeek());
//			Stampa.stampaln("contain: " + pippo.contains(localDate.getDayOfWeek()));

			
			Stampa.stampaln("_________________________________________________ ");
			
			LocalDate data = new LocalDate(2015,01,25);
			//data.get
			java.util.Date d = data.toDate();
			DateTime dtime = new DateTime(d);
			Object o = new Object();
			LocalDate dd = new LocalDate(d);
			
//			LocalDate dd2 = new LocalDate();
//			java.util.Date utilDate = dd2.toDate();
			
//			LocalDate aa = new LocalDate(d, d.toInstant());
//			Stampa.stampaln("aa: " +aa);

			Stampa.stampaln("dtime: " + dtime);
			Stampa.stampaln("localDate: " + data);
			Stampa.stampaln("Date: " + d + " getMonth " + d.getMonth());
			Stampa.stampaln("data convertita da Date a LocalDate: " + dd);
			
	}

}
