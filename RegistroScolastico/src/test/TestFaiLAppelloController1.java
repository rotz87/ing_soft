package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import service.DBFake;
import domain.*;

public class TestFaiLAppelloController1 {
	public static void main(String[] args){
		//creazione dal controller FaiAppelloConreoller
		FaiAppelloController controlloreAppello = new FaiAppelloController();
		
		//TEST DEL METODO
//		System.out.println("studenti della 1A : " + primaA.getStudenti() );
		
		stampaLibretti(DBFake.getInstance().getClasseById(new Long(1)).getRegistroAssenze());
		
		try{

			controlloreAppello.avviaAppello(new Long(1), new Long(1));
//			controlloreAppello.avviaAppello(new Long(1), new Long(2));
		}catch(IllegalStateException ISE){
			System.out.println("Messaggio dell'eccezione: "+ISE.getMessage());
		}
		Long[] listaIdStudAssenti = {new Long(3), new Long(1), new Long(5), new Long(2)};
		try{
			controlloreAppello.registraAssenze(listaIdStudAssenti,new Long(1), new Long(1) );
		}catch(IllegalStateException ISE){
			System.out.println("Messaggio dell'eccezione: "+ISE.getMessage());
		}
		catch(NullPointerException NPE){
			System.out.println("NULL POITER EXCEPTION: "+NPE.getMessage());
		}
		
		
		//Stampa dei libretti
		stampaLibretti(DBFake.getInstance().getClasseById(new Long(1)).getRegistroAssenze());
		

	}
	
	private static void stampaLibretti(RegistroAssenze regAss){
		System.out.println();
		System.out.println("VISUALIZZAZIONE ASSENZE NON GIUSTIFICATE DEGLI STUDENTI _________________________ \n \n");
		Iterator entries = regAss.getLibrettiAssenze().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Studente Stud = (Studente)thisEntry.getKey();
		  LibrettoAssenze libAss = (LibrettoAssenze)thisEntry.getValue();
		  System.out.println("STUDENTE : "+libAss.getStudente().getNome() +" "+libAss.getStudente().getCognome());
		  System.out.println("ASSENZE NON GIUSTIFICATE : \n");
		  if (/*libAss.getNonGiustificate() != null && */ (!(libAss.getNonGiustificate().isEmpty()))){
			  for (Assenza assNG : libAss.getNonGiustificate()) {
				  System.out.println("---------Inizio Assenza-------- ");
				  for (Appello app : assNG.getAppelli()){
					  System.out.println("data dell'appello dell'assenza : "+app.getData().toString());
				  }
				  if(assNG.isCertificatoMedicoRichiesto()){
					  System.out.println(" \n E' richiesto il certificato medico !! \n");  
				  }
				  System.out.println("-------Fine Assenza--------\n");
					
				}
			  System.out.println("-------fine studente---------- \n \n");
			}else{ System.out.println("\n non ci sono assenze non giustificate \n");}
		}
		System.out.println("________________________________________FINE");
		System.out.println();
		
	}
}
