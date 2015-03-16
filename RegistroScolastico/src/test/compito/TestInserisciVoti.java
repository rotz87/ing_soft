package test.compito;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;
import org.orm.PersistentException;

import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.model.CompitoInClasse;
import domain.model.CompitoInClasseCriteria;

public class TestInserisciVoti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	CompitoInClasseController controlloreCompito; 
	int idRegistroDocenteProva = 1;
	int idDocenteProva = 31;
	int idCompitoProva = 2;
	CompitoInClasse compito = null;
	
	int[] idStudenti = {1,8,9};
//	int[] idVoti = {10,80,90};
//	int[] idVoti = {1,8,9};
	byte[] voti = {1,8,9};
	Map<Integer, Byte> mapVoti;
	
	controlloreCompito = new CompitoInClasseController();
	mapVoti = new HashMap<Integer, Byte>();
	
	mapVoti.put(new Integer(1), new Byte((byte)1));
	mapVoti.put(new Integer(8), new Byte((byte)8));
	mapVoti.put(new Integer(9), new Byte((byte)9));
	
	try {
		
		try {
			
			controlloreCompito.inserisciVoti(idCompitoProva, mapVoti);
		}
		finally {
			domain.model.RSPersistentManager.instance().disposePersistentManager();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	Stampa.stampa("alla fine del test!");
	

}

}
