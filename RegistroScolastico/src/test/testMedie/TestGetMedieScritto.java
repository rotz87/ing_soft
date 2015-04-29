package test.testMedie;

import java.sql.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.orm.PersistentException;

import controller.CompitoInClasseController;
import controller.MedieController;
import sviluppo.Stampa;
import domain.error.ErrorMessage;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;
import domain.model.mediaStrategy.MediaAritmeticaStrategy;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;

public class TestGetMedieScritto {
	
	public static void main(String[] args) {
		Map<Studente, Voto> mapVoti;
		int idRegistroProva = 1;
		Date dataInizio = Date.valueOf("2014-12-01");
		Date dataFine = Date.valueOf("2015-01-31");
		
		MedieController medieController = new MedieController();
		
		medieController.setStrategiaRegistro(idRegistroProva, new MediaAritmeticaStrategy());
		mapVoti = medieController.getMedieScritto(idRegistroProva, dataInizio, dataFine);
		
		for(Studente studente : mapVoti.keySet()){
			Stampa.stampaln("Studente: "+ studente.getNome() + " "+ studente.getCognome() +": ");
			Stampa.stampaln("voto: "+mapVoti.get(studente).getVoto());
			Stampa.stampaln();
		}
		
	}
	
}
