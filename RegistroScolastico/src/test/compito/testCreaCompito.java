package test.compito;

import controller.CompitoInClasseController;
import controller.DocenteController;
import ormsamples.CreateRegistroScolasticoData;
import service.Stampa;
import domain.model.compitoInClasse.CompitoInClasse;

public class testCreaCompito {

	public static void main(String[] args) {

		CompitoInClasseController controlloreCompito; 
		int idClasseProva = 1;
		int idRegistroDocenteProva = 1;
		int idDocenteProva = 31;
		CompitoInClasse compito = null;
		
		controlloreCompito = new CompitoInClasseController();
		
		try {
			
			try {
				compito = controlloreCompito.creaCompito(idClasseProva, idRegistroDocenteProva, idDocenteProva);
			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Stampa.stampa("Compito: " + compito);
		
		
		

	}

}
