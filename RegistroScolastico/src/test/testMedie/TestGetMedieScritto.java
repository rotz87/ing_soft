package test.testMedie;

import java.sql.Date;
import java.util.Map;

import sviluppo.Stampa;
import controller.MedieController;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.mediaStrategy.MediaAritmeticaStrategy;

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
			Stampa.stampaln("voto: "+mapVoti.get(studente).getValore());
			Stampa.stampaln();
		}
		
	}
	
}
