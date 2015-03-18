package domain.controller;

import java.util.Collection;

import org.hibernate.exception.DataException;
import org.joda.time.LocalDate;
import org.orm.PersistentException;

import domain.model.Appello;
import domain.model.Calendario;
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
			throw new RuntimeException(ErrorMessage.STUDENTI_UNLOADED);
		}
		criteria.ID.eq(idClasse);
		classe = criteria.uniqueClasse();
		
		return classe.getStudenti();
		
	}

	
	public Collection<LocalDate> getDateFestive(int idClasse){
		Collection<LocalDate> dateFestive;
		Collection<Appello> appelli;
		Collection<LocalDate> rit;
		FaiAppelloController appelloController;
		
		dateFestive = Calendario.getInstance().getDateFestive();
		appelloController = new FaiAppelloController();
		
		appelloController.getAppelli(idClasse);
		/**
		 * TODO
		 *	NON controlla che una data passata ammessa abbia effettivamente l'appello
		 *	Si dovrebbe controllare che non ci sia una data passata che non è contenuta nelle date festive e contemporaneamente non ha un appello
		 *  per il momento ritorna solo le date festive.
		 */
		rit = dateFestive;
		
		return rit;
	}
}
