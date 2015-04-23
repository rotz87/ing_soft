package controller;

import java.sql.Date;
import java.util.Map;

import org.orm.PersistentException;

import domain.error.ErrorMessage;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.mediaStrategy.IMediaStrategy;

public class MedieController {

	public Map<Studente, Voto> getMedieScritto(int idRegistroDocente, Date dataInizio, Date dataFine){

		RegistroDocente registroDocente;
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		return registroDocente.calcolaMediaScritto(dataInizio, dataFine);
	}
	
	public void setStrategiaRegistro(int idRegistroDocente, IMediaStrategy strategia){
		RegistroDocente registroDocente;
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		registroDocente.setMediaStrategy(strategia);
	}
	
	private RegistroDocente getRegistroDocenteById(int idRegistroDocente){// FIXME duplicato dello stesso metodo in CompitoInClasseController
		RegistroDocenteCriteria regDocCriteria;

		RegistroDocente registroDocente;

		try{
			regDocCriteria = new RegistroDocenteCriteria();

		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.REGISTRO_DOCENTE_UNLOADED);
		}
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		return registroDocente;
	}
	
}
