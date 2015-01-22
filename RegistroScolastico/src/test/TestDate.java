package test;

import java.awt.*;
import java.util.*;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import domain.model.Calendario;

public class TestDate {
	public static void main(String[] args){
		
		GregorianCalendar g = new GregorianCalendar(2014,1,5);
		System.out.println(g.getTime());
		
		 DateTime dt = new DateTime();
		 System.out.println(dt);
		 
		 LocalTime lt = new LocalTime();
		 System.out.println(lt);
		 
		 LocalDate ld = new LocalDate();
		 System.out.println(ld);
		 LocalDate ldplus = ld.plusDays(1);
		 System.out.println("ldPlus " +ldplus);
		 
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
//			System.out.println("passo per l'else if: " );
		// entro nel ciclo se il giorno dopo l'ultimo giorno di assenza è festivo
			 while(calendarioFestivi.contains(ultimaDataPlus) && true/*iterator.hasNext()*/){
	//			 iterator.next();
				 ultimaDataPlus = ultimaDataPlus.plusDays(1);
//				 System.out.println("passo per il while: " );
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
			
			System.out.println("ultimaData: "+ ultimaData);
			System.out.println("ultimaDataPlus: "+ ultimaDataPlus);
			System.out.println("oggi: "+ oggi);
			System.out.println("inseribile: "+ inseribile);
			
			
//			System.out.println("_____________________________________");
//			LinkedList<Integer> pippo = new LinkedList<Integer>();
//			pippo.add(new Integer(1));
//			pippo.add(new Integer(2));
//			LocalDate localDate = new LocalDate(2015,01,12);
//			System.out.println("day of week: " + localDate.getDayOfWeek());
//			System.out.println("contain: " + pippo.contains(localDate.getDayOfWeek()));
			
	}

}
