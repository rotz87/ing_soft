package test.compito;

import sviluppo.Stampa;
import controller.CompitoInClasseController;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;

public class TestCompitoArgomenti {

	public static void main(String[] args) {

		CompitoInClasseController controlloreCompito; 
		int idRegistroDocenteProva = 1;
		int idClasseProva = 1;
		int idDocenteProva = 31;
		int idCompitoProva = 1;
		CompitoInClasse compito = null;

		
		controlloreCompito = new CompitoInClasseController();
		
		try {
			
			compito = controlloreCompito.getCompitoInCLasse(idClasseProva,idRegistroDocenteProva,idCompitoProva);
			
			for(Argomento arg : compito.getArgomentiEsaminati()){
				Stampa.stampaln("Argomento: "+ arg.getID() + ", nome: " + arg.getNome() + ", descrizione: "+arg.getDescrizione()+", data: "+arg.getData()+".");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
