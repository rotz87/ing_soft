package controller;

import java.sql.Date;
import java.util.Map;

import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.mediaStrategy.IMediaStrategy;

public class MedieController {

	public Map<Studente, Voto> getMedieScritto(int idRegistroDocente, Date dataInizio, Date dataFine, IMediaStrategy strategia){

		RegistroDocente registroDocente;
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		registroDocente.setMediaStrategy(strategia);
		
		return registroDocente.calcolaMediaScritto(dataInizio, dataFine);
	}
	
//	public void setStrategiaRegistro(int idRegistroDocente, IMediaStrategy strategia){
//		RegistroDocente registroDocente;
//		registroDocente = getRegistroDocenteById(idRegistroDocente);
//		
//		registroDocente.setMediaStrategy(strategia);
//	}
	
	private RegistroDocente getRegistroDocenteById(int idRegistroDocente){
		RegistroDocenteController registroDocenteController;
		registroDocenteController = new RegistroDocenteController();
		return registroDocenteController.getRegistroDocente(idRegistroDocente);
	}
	
}
