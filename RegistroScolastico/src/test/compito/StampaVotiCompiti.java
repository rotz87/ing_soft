package test.compito;

import java.util.LinkedList;
import java.util.List;

import org.orm.PersistentException;

import sviluppo.Stampa;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;

public class StampaVotiCompiti {

	public static void main(String[] args) {
		CompitoInClasseCriteria compitoCriteria;
		List<CompitoInClasse> compiti = new LinkedList<CompitoInClasse>();

		try {
			compitoCriteria = new CompitoInClasseCriteria();
			compiti.addAll(compitoCriteria.list());
			Stampa.stampaln("\n \n \n \t VISUALIZZAZIONE DI TUTTI I COMPITI PRESENTI NEL DATABASE \n \n \n");
			for(CompitoInClasse compito : compiti){
				TestGetVotiCompito.stampaVotiCompito(compito.getID());
			}
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	}
	


}
