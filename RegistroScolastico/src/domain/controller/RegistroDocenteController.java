package domain.controller;

import org.orm.PersistentException;

import domain.error.ErrorMessage;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;

public class RegistroDocenteController {
	
	public RegistroDocente getRegistroDocente(int idRegistroDocente){
		
		RegistroDocenteCriteria criteria;
		RegistroDocente registroDocente;
		
		criteria = null;
		registroDocente = null;
		
		try {
			criteria = new RegistroDocenteCriteria();
			criteria.ID.eq(idRegistroDocente);
			registroDocente = criteria.uniqueRegistroDocente();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.REGISTRO_DOCENTE_UNLOADED);
		}
		
		return registroDocente;
	}

}
