package controller;

import org.orm.PersistentException;

import domain.error.ErrorMessage;
import domain.model.Docente;
import domain.model.DocenteCriteria;

public class DocenteController {
	
	public int getIdDocenteProva(){
		String cognome = "Rossi";
//		String cognome = "Bianchi";
		
		DocenteCriteria criteria;
		Docente docente;
		
		criteria = null;
		
		try {
			criteria = new DocenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.DOCENTE_UNLOADED);
		}
		criteria._cognome.eq(cognome);
		
		docente = criteria.uniqueDocente();
		
		return docente.getID();
	}
	
}
