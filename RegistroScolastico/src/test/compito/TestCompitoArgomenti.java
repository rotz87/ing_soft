package test.compito;

import java.sql.Time;

import org.joda.time.LocalDate;
import org.orm.PersistentException;

import controller.CompitoInClasseController;
import service.Stampa;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;

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
