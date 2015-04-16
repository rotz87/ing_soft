package test.compito;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.orm.PersistentException;

import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;
import domain.model.ErrorMessage;
import domain.model.Studente;
import domain.model.Voto;

public class TestGetVotiCompito {
	
	public static void main(String[] args) {
		int idCompitoInClasse = 1;
		
		stampaVotiCompito(idCompitoInClasse);
	}
	public static void stampaVotiCompito(int idCompitoInClasse){
		CompitoInClasseCriteria compitoCriteria;
		CompitoInClasse compito;

		try{
			compitoCriteria = new CompitoInClasseCriteria();
			
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compitoCriteria.ID.eq(idCompitoInClasse);
		compito = compitoCriteria.uniqueCompitoInClasse();
		
		try {
			try {
				CompitoInClasseController compitoController = new CompitoInClasseController();
				Map<Studente, Voto> mapVoti = compitoController.getVotiCompito(compito.getInsegnamento().getClasse().getID(), compito.getInsegnamento().getID(), idCompitoInClasse);
				Stampa.stampaln();
				Stampa.stampaln("VISUALIZZAZIONE STUDENTI E VOTI COMPITO CON ID = "+idCompitoInClasse+ "_________________________ \n \n");
				Iterator entries = mapVoti.entrySet().iterator();
				while (entries.hasNext()) {
				  Entry thisEntry = (Entry) entries.next();
				  Studente stud = (Studente)thisEntry.getKey();
				  Voto voto  = (Voto)thisEntry.getValue();
				  
				  Stampa.stampa("STUDENTE : "+stud.getNome() +" "+stud.getCognome()+" (id = "+stud.getID()+") :");
				  Stampa.stampaln("VOTO :"+ voto);
				  
				}
				Stampa.stampaln("___________________________________________________________________________FINE");
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
