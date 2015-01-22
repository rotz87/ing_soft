package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import service.DBFake;
import domain.controller.FaiAppelloController;
import domain.model.Assenza;
import domain.model.Studente;

public class TestGetAssenze {
	public static void main(String[] args) throws IOException{
		
		DBFake.getInstance();
		
// lettura intero da tastiera
		System.out.println("Inserire codice appello (0 per uscire) ->");
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
			
			
			System.out.println("VISUALIZZAZIONE STUDENTI  _________________________ \n \n");
			for(Studente studente : studenti){
				System.out.println("STUDENTE : "+studente.getNome() +" "+studente.getCognome());
			}
			System.out.println("________________________________________FINE");
			System.out.println();
			
			System.out.println();
			System.out.println("VISUALIZZAZIONE STUDENTI E BOOLEAN ASSENZE _________________________ \n \n");
			Iterator entries = mapStudBool.entrySet().iterator();
			while (entries.hasNext()) {
			  Entry thisEntry = (Entry) entries.next();
			  Studente stud = (Studente)thisEntry.getKey();
			  Boolean isAssente = (Boolean)thisEntry.getValue();
			  System.out.print("STUDENTE : "+stud.getNome() +" "+stud.getCognome()+" (id = "+stud.getId()+") :");
			  System.out.println("ASSENTE :"+ isAssente);
			  
			}
			System.out.println("________________________________________FINE");
			System.out.println();
			
			HashMap<Long, Assenza>  mapIdStudAss = controlloreAppello.getAssenze(new Long(1), idAppello);
			
		
			System.out.println();
			System.out.println("VISUALIZZAZIONE ID_STUDENTI E ASSENZE _________________________ \n \n");
			Iterator entries2 = mapIdStudAss.entrySet().iterator();
			while (entries2.hasNext()) {
			  Entry thisEntry = (Entry) entries2.next();
			  Long idStud = (Long)thisEntry.getKey();
			  Assenza assenza = (Assenza)thisEntry.getValue();
			  System.out.print("ID_STUDENTE : " + idStud+" :");
			  System.out.println("ASSENZA :"+ assenza);
			  
			}
			System.out.println("________________________________________FINE");
			System.out.println();
			
// lettura intero da tastiera
			System.out.println("Inserire codice appello (0 per uscire) ->");
			
			buffer = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
			
			string=buffer.readLine();
			number = Long.parseLong(string);
//fine lettura
		}	
	}
}
