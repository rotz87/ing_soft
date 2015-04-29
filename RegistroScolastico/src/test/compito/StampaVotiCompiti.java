package test.compito;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.orm.PersistentException;

import controller.CompitoInClasseController;
import sviluppo.Stampa;

import java.util.List;
import java.util.Map.Entry;

import domain.model.compitoInClasse.CompitoInClasseCriteria;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.Studente;
import domain.model.Voto;

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
