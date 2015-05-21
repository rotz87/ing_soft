package controller;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.time.LocalDate;
import org.orm.PersistentException;

import domain.error.ErrorMessage;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.GiornoFestivo;
import domain.model.RegistroAppelli;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;
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

	/**
	 * Restituisce una collection di date che è data dall'unione delle date festive del calendario
	 *  e delle date passate non festive che non hanno un appello (un compito in classe non può essere 
	 *  fissato in una data passata per la quale non esiste un appello)
	 * 
	 * @param idClasse
	 * @return
	 */
	
	public Collection<LocalDate> getDateFestiveOSenzaAppello(int idClasse){
		Classe classe;
		RegistroAppelli registroAppelli;
				
		classe = getClasseById(idClasse);
		registroAppelli = classe.getRegistroAppelli();

		return registroAppelli.getDateFestiveOSenzaAppello();
	}

	public Collection<RegistroDocente> getRegistriDocente(int idClasse, int idDocente) {
		Docente docente;
		DocenteCriteria docenteCriteria;
		RegistroDocenteCriteria registroDocenteCriteria;
		Collection<RegistroDocente> registri;
		
		docenteCriteria = null;
		registri = new LinkedList<RegistroDocente>();
		
		try {
			docenteCriteria = new DocenteCriteria();
			registroDocenteCriteria = new RegistroDocenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.REGISTRO_DOCENTE_UNLOADED);
		}

		docenteCriteria.ID.eq(idDocente);

		docente = docenteCriteria.uniqueDocente();
		
		registroDocenteCriteria._classeId.eq(idClasse);
		
		registri.addAll(registroDocenteCriteria.list());
		
		registri.retainAll(docente.getRegistriDocente());
		
		return registri;
	}
	
	public Classe getClasseById(int idClasse){
		Classe classe;
		ClasseCriteria classeCriteria;

		classeCriteria = null;

		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.CLASSE_UNLOADED);
		}
		classeCriteria.ID.eq(idClasse);
		classe = classeCriteria.uniqueClasse();
		return classe;
	}
}
