package test.compito;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.model.CompitoInClasse;
import domain.model.Studente;
import domain.model.Voto;

public class TestGetVotiCompito {

	public static void main(String[] args) {
		int idCompitoInClasse = 1;
		stampaVotiCompito(idCompitoInClasse);
	}
	public static void stampaVotiCompito(int idCompitoInClasse){
		try {
			try {
				CompitoInClasseController compitoController = new CompitoInClasseController();
				Map<Studente, Voto> mapVoti = compitoController.getVotiCompito(idCompitoInClasse);
				Stampa.stampaln();
				Stampa.stampaln("VISUALIZZAZIONE STUDENTI E VOTI _________________________ \n \n");
				Iterator entries = mapVoti.entrySet().iterator();
				while (entries.hasNext()) {
				  Entry thisEntry = (Entry) entries.next();
				  Studente stud = (Studente)thisEntry.getKey();
				  Voto voto  = (Voto)thisEntry.getValue();
				  
				  Stampa.stampa("STUDENTE : "+stud.getNome() +" "+stud.getCognome()+" (id = "+stud.getID()+") :");
				  Stampa.stampaln("VOTO :"+ voto);
				  
				}
				Stampa.stampaln("________________________________________FINE");
				Stampa.stampaln();
			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
