package test.compito;

import java.sql.Time;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.orm.PersistentException;

import controller.CompitoInClasseController;
import controller.DocenteController;
import ormsamples.CreateRegistroScolasticoData;
import sviluppo.Stampa;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;

public class TestInserisciInfoCompito {

	public static void main(String[] args) {

		CompitoInClasseController controlloreCompito; 
		int idRegistroDocenteProva = 1;
		int idDocenteProva = 31;
		int idClasseProva = 1;
		int idCompitoProva = 1;//<<----------------------------------
		CompitoInClasse compito = null;
		LocalDate dataCompito = new LocalDate(2014,12,19);
//		Time oraInizio = new Time(10, 0, 0);
//		Time oraFine = new Time(12, 0, 0);
		Time oraInizio = Time.valueOf("10:0:0");
		Time oraFine = Time.valueOf("12:0:0");
		int[] idArgomenti = {1, 3};
		 
		
		controlloreCompito = new CompitoInClasseController();
		
		try {
			
			try {
				java.sql.Date sqlDate = new java.sql.Date(dataCompito.toDate().getTime());
				controlloreCompito.inserisciInfoCompito(idClasseProva, idRegistroDocenteProva, idCompitoProva, sqlDate, oraInizio, oraFine, idArgomenti);
			}
			finally {
				service.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try{
			CompitoInClasseCriteria compitoCriteria = new CompitoInClasseCriteria();
			compitoCriteria.ID.eq(idCompitoProva);
			compito = compitoCriteria.uniqueCompitoInClasse();

			Stampa.stampaln("Compito: " + compito.getID() +" "+ compito.getData() +" "+ compito.getOraInizio()  +" "+ compito.getOraFine() +" "+ compito.getArgomentiEsaminati());
		}catch(PersistentException e){
			e.printStackTrace();
		}
	}
}
