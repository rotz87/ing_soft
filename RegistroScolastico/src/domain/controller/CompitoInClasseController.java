package domain.controller;

import java.nio.channels.IllegalSelectorException;

import org.joda.time.LocalTime;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.model.CompitoInClasse;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.RSPersistentManager;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;

public class CompitoInClasseController {

	public CompitoInClasse creaCompito(int idRegistroDocente, int idDocente) {
		RegistroDocenteCriteria regDocCriteria;
		DocenteCriteria docenteCriteria;
		RegistroDocente registroDocente;
		Docente docente;
		CompitoInClasse compito;
		
		try {
			regDocCriteria = new RegistroDocenteCriteria();
			docenteCriteria = new DocenteCriteria();
	
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.COMPITO_UNCREABLE);
		}
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		docenteCriteria.ID.eq(idDocente);
		docente = docenteCriteria.uniqueDocente();
		
		if(docente.haRegistroDocente(registroDocente)){
			compito = registroDocente.creaCompito();
			try {
				PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
				try {
					RSPersistentManager.instance().getSession().save(compito);
					t.commit();
				}
				catch (PersistentException e) {
					t.rollback();
					throw e;
				}
			} catch (PersistentException e) {
				throw new RuntimeException(ErrorMessage.COMPITO_UNCREABLE);
			}
			
			
		}else{
			throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}
		return compito;
	}

	/**
	 * 
	 * @param idCompito
	 * @param data
	 * @param ora
	 * @param durata La durata è intesa in minuti.
	 * @param idArgomeni
	 */
	public void inserisciDatiCompito(int idCompito, java.util.Date data, LocalTime ora, int durata, int[] idArgomeni) {
		// TODO - implement CompitoInClasseController.inserisciDatiCompito
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCompito
	 * @param idStudenti
	 */
	public void inserisciStudenti(int idCompito, int[] idStudenti) {
		// TODO - implement CompitoInClasseController.inserisciStudenti
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCompito
	 * @param idStudenti
	 * @param idVoti
	 */
	public void inserisciVoti(int idCompito, int[] idStudenti, int[] idVoti) {
		// TODO - implement CompitoInClasseController.inserisciVoti
		throw new UnsupportedOperationException();
	}

}