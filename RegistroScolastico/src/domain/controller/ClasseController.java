package domain.controller;

import java.util.Collection;

import org.orm.PersistentException;

import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.RSPersistentManager;
import domain.model.Studente;

public class ClasseController {
	
	public ClasseController() {
		
	}

	public Collection<Classe> getClassi(int idDocente) throws PersistentException{
		
			Docente docente = null;
			DocenteCriteria criteria = null;
			
			criteria = new DocenteCriteria();
			criteria.ID.eq(idDocente);

			docente = criteria.uniqueDocente();

			return docente.getClassi();
			
	}
	
	public Collection<Studente> getStudenti(int idClasse) throws PersistentException {
		
		Classe classe;
		ClasseCriteria criteria;
		
		criteria = new ClasseCriteria();
		criteria.ID.eq(idClasse);
		classe = criteria.uniqueClasse();
		
		return classe.getStudenti();
		
	}

	
}
