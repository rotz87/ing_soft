package domain.controller;

import java.util.Collection;

import org.hibernate.exception.DataException;
import org.orm.PersistentException;

import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.Studente;

public class ClasseController {
	
	public ClasseController() {
		
	}

	public Collection<Classe> getClassi(int idDocente){
		
			Docente docente = null;
			DocenteCriteria criteria = null;
			
			try {
				criteria = new DocenteCriteria();
			} catch (PersistentException e) {
				e.printStackTrace();
				throw new RuntimeException(ErrorMessage.CLASSI_UNLOADED);
			}
			
			criteria.ID.eq(idDocente);

			docente = criteria.uniqueDocente();

			return docente.getClassi();
			
	}
	
	public Collection<Studente> getStudenti(int idClasse){
		
		Classe classe;
		ClasseCriteria criteria;
		
		criteria = null;
		
		try {
			criteria = new ClasseCriteria();
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new RuntimeException(ErrorMessage.STUDENTI_UNLOADED);
		}
		criteria.ID.eq(idClasse);
		classe = criteria.uniqueClasse();
		
		return classe.getStudenti();
		
	}

	
}
