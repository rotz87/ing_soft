package test.appello;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.orm.PersistentException;

import controller.ClasseController;
import controller.FaiAppelloController;
import service.Stampa;
import domain.model.Assenza;
import domain.model.Studente;

public class TestGetAssenze {
	public static void main(String[] args) throws IOException{
		
//		DBFake.getInstance();
		
		// lettura intero da tastiera
		Stampa.stampaln("Inserire codice appello (0 per uscire) ->");
		java.io.BufferedReader buffer;
		String string;
		int number;
		FaiAppelloController controlloreAppello;
		ClasseController controlloreClasse;
		
		
		buffer = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		
		string=buffer.readLine();
		number = Integer.parseInt(string);
		//fine lettura

		int input = 5;//<-----------------------------------------------

//			Long idAppello = new Long(input);


		 controlloreAppello = new FaiAppelloController();
		 controlloreClasse = new ClasseController();
		
		try {
//			controlloreAppello.avviaAppello(1, 1);

			Integer[] listaIdStudAssenti = {3, 1, 5, 2};
			
			HashSet<Studente> studenti = new HashSet<Studente>();
					studenti.addAll( controlloreClasse.getStudenti(1));
	
//			controlloreAppello.registraAssenze(listaIdStudAssenti,1, 1 );
			
		
			while(number != 0){
				try{
				int idAppello = number;
				
				HashMap<Studente, Boolean>  mapStudBool = controlloreAppello.getAssenzeCompito(1, idAppello);
				
				
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
				  Stampa.stampa("STUDENTE : "+stud.getNome() +" "+stud.getCognome()+" (id = "+stud.getID()+") :");
				  Stampa.stampaln("ASSENTE :"+ isAssente);
				  
				}
				Stampa.stampaln("________________________________________FINE");
				Stampa.stampaln();
				
				HashMap<Studente, Assenza>  mapIdStudAss = controlloreAppello.getAssenze(1, idAppello);
				
			
				Stampa.stampaln();
				Stampa.stampaln("VISUALIZZAZIONE ID_STUDENTI E ASSENZE _________________________ \n \n");
				Iterator entries2 = mapIdStudAss.entrySet().iterator();
				while (entries2.hasNext()) {
				  Entry thisEntry = (Entry) entries2.next();
				  Studente stud = (Studente)thisEntry.getKey();
				  Assenza assenza = (Assenza)thisEntry.getValue();
				  Stampa.stampa("ID_STUDENTE : " + stud.getID()+" :");
				  Stampa.stampaln("ASSENZA :"+ assenza);
				  
				}
				Stampa.stampaln("________________________________________FINE");
				Stampa.stampaln();
				}catch(IllegalStateException ise){
					Stampa.stampaln("ECCEZZIONE " + ise.getMessage());
				}
				catch(Exception e){
					Stampa.stampaln("ECCEZZIONE " + e.getMessage());
				}
				// lettura intero da tastiera
				Stampa.stampaln("Inserire codice appello (0 per uscire) ->");
				
				buffer = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
				
				string=buffer.readLine();
				number = Integer.parseInt(string);
				//fine lettura
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
