package domain.controller;

import org.orm.PersistentException;

import domain.model.Docente;
import domain.model.DocenteCriteria;

public class DocenteController {
	
	public int getIdDocenteProva() throws PersistentException{
		String cognome = "Rossi";
		
		DocenteCriteria criteria;
		Docente docente;
		
		criteria = new DocenteCriteria();
		criteria.cognome.eq(cognome);
		
		docente = criteria.uniqueDocente();
		
		return docente.getID();
	}
	
}
