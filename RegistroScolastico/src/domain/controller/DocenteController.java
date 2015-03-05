package domain.controller;

import org.orm.PersistentException;

import domain.model.Docente;
import domain.model.DocenteCriteria;

public class DocenteController {
	
	public int getIdDocenteProva(){
		String cognome = "Rossi";
		
		DocenteCriteria criteria;
		Docente docente;
		
		criteria = null;
		
		try {
			criteria = new DocenteCriteria();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(ErrorMessage.DOCENTE_UNLOADED);
		}
		criteria.cognome.eq(cognome);
		
		docente = criteria.uniqueDocente();
		
		return docente.getID();
	}
	
}
