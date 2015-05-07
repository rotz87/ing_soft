package test.testMedie;

import java.util.Collection;
import java.util.LinkedList;

import org.orm.PersistentException;

import sviluppo.Stampa;
import domain.error.ErrorMessage;
import domain.model.LibrettoVotiLineItem;
import domain.model.Studente;
import domain.model.StudenteCriteria;

public class TestGetVotiPerStudente {

	public static void main(String[] args) {
		
		StudenteCriteria studenteCriteria;
		Collection<Studente> studenti;
		
		studenti = new LinkedList<Studente>();

		try {

			studenteCriteria = new StudenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.DOCENTE_UNLOADED);
		}
				
		studenti.addAll(studenteCriteria.list());
		
		Stampa.stampaln("STAMPA VOTI PER STUDENTE: ");
		Stampa.stampaln();
		
		for (Studente studente : studenti){
			Stampa.stampaln("STUDENTE --------------------------------------");
			Stampa.stampaln();
			Stampa.stampa(studente.getCognome());
			Stampa.stampa("  ");
			Stampa.stampa(studente.getNome());
			Stampa.stampa("  ");
			Stampa.stampa("ID: ");
			Stampa.stampa(studente.getID());
			Stampa.stampa("  ");
			Stampa.stampa("ID Libretto: ");
			Stampa.stampa(studente.getLibrettoVoti().getID());
			Stampa.stampaln();
			Stampa.stampaln();
			for(LibrettoVotiLineItem lvli : studente.getLibrettoVoti().getLibVotiLineItems()){
				Stampa.stampa(" --- Compito --- ");
				Stampa.stampa(" id = ");
				Stampa.stampa(lvli.getCompitoInClasse().getID());
				Stampa.stampa("  ");
				Stampa.stampa(" data =  ");
				Stampa.stampa(lvli.getCompitoInClasse().getData());
				Stampa.stampa("  ");
				Stampa.stampa(" voto = ");
				Stampa.stampa(lvli.getVoto().getValore());
				Stampa.stampa("  ");
				Stampa.stampaln();
				
			}
			Stampa.stampaln();
		}
	}
}
