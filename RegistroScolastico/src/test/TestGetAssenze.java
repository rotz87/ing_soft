package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import service.DBFake;
import service.Stampa;
import domain.controller.FaiAppelloController;
import domain.model.Assenza;
import domain.model.Studente;

public class TestGetAssenze {
	public static void main(String[] args) throws IOException{
		
		DBFake.getInstance();
		
// lettura intero da tastiera
		Stampa.stampaln("Inserire codice appello (0 per uscire) ->");
		java.io.BufferedReader buffer;
		String string;
		long number;
		
		
		buffer = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		
		string=buffer.readLine();
		number = Long.parseLong(string);
//fine lettura

		int input = 5;//<-----------------------------------------------

//			Long idAppello = new Long(input);


			FaiAppelloController controlloreAppello = new FaiAppelloController();
			
			controlloreAppello.avviaAppello(new Long(1), new Long(1));
			
			Long[] listaIdStudAssenti = {new Long(3), new Long(1), new Long(5), new Long(2)};
			
			HashSet<Studente> studenti = (HashSet<Studente>) controlloreAppello.getStudenti(1L);
	
			controlloreAppello.registraAssenze(listaIdStudAssenti,new Long(1), new Long(1) );
	
		while(number != 0){
			Long idAppello = number;
			
			HashMap<Studente, Boolean>  mapStudBool = controlloreAppello.getBoolAssenze(new Long(1), idAppello);
			
			
			Stampa.stampaln("VISUALIZZAZIONE STUDENTI  _________________________ \n \n");
			for(Studente studente : studenti){
				Stampa.stampaln("STUDENTE : "+studente.getNome() +" "+studente.getCognome());
			}
			Stampa.stampaln("________________________________________FINE");
			Stampa.stampaln();
			
			Stampa.stampaln();
			Stampa.stampaln("VISUALIZZAZIONE STUDENTI E BOOLEAN ASSENZE _________________________ \n \n");
			Iterator entries = mapStudBool.entrySet().iterator();
			while (entries.hasNext()) {
			  Entry thisEntry = (Entry) entries.next();
			  Studente stud = (Studente)thisEntry.getKey();
			  Boolean isAssente = (Boolean)thisEntry.getValue();
			  Stampa.stampa("STUDENTE : "+stud.getNome() +" "+stud.getCognome()+" (id = "+stud.getId()+") :");
			  Stampa.stampaln("ASSENTE :"+ isAssente);
			  
			}
			Stampa.stampaln("________________________________________FINE");
			Stampa.stampaln();
			
			HashMap<Long, Assenza>  mapIdStudAss = controlloreAppello.getAssenze(new Long(1), idAppello);
			
		
			Stampa.stampaln();
			Stampa.stampaln("VISUALIZZAZIONE ID_STUDENTI E ASSENZE _________________________ \n \n");
			Iterator entries2 = mapIdStudAss.entrySet().iterator();
			while (entries2.hasNext()) {
			  Entry thisEntry = (Entry) entries2.next();
			  Long idStud = (Long)thisEntry.getKey();
			  Assenza assenza = (Assenza)thisEntry.getValue();
			  Stampa.stampa("ID_STUDENTE : " + idStud+" :");
			  Stampa.stampaln("ASSENZA :"+ assenza);
			  
			}
			Stampa.stampaln("________________________________________FINE");
			Stampa.stampaln();
			
// lettura intero da tastiera
			Stampa.stampaln("Inserire codice appello (0 per uscire) ->");
			
			buffer = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
			
			string=buffer.readLine();
			number = Long.parseLong(string);
//fine lettura
		}	
	}
}
