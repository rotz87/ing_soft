package test.compito;

import ormsamples.CreateRegistroScolasticoData;
import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.model.CompitoInClasse;

public class testCreaCompito {

	public static void main(String[] args) {

		CompitoInClasseController controlloreCompito; 
		int idRegistroDocenteProva = 1;
		int idDocenteProva = 31;
		CompitoInClasse compito = null;
		
		controlloreCompito = new CompitoInClasseController();
		
		try {
			
			try {
				compito = controlloreCompito.creaCompito(idRegistroDocenteProva, idDocenteProva);
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
