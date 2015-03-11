package domain.controller;

import java.nio.channels.IllegalSelectorException;
import java.sql.Time;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.joda.time.LocalTime;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import service.Stampa;
import domain.model.Argomento;
import domain.model.ArgomentoCriteria;
import domain.model.CompitoInClasse;
import domain.model.CompitoInClasseCriteria;
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
					e.printStackTrace();//TODO
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

	/**
	 * 
	 * @param idCompito
	 * @param data
	 * @param oraInizio
	 * @param oraFine La durata è intesa in minuti.
	 * @param idArgomeni
	 */
	public void inserisciInfoCompito(int idRegistroDocente, int idCompito, java.sql.Date data, Time oraInizio, Time oraFine, int[] idArgomenti) {
		CompitoInClasseCriteria compitoCriteria;
		CompitoInClasse compito;
		RegistroDocenteCriteria regDocCriteria;
		RegistroDocente registroDocente;
		ArgomentoCriteria argomentoCriteria;
		Collection<Argomento> argomenti;
		
		argomenti = new LinkedHashSet<Argomento>();
		
		try{
			compitoCriteria = new CompitoInClasseCriteria();
			regDocCriteria = new RegistroDocenteCriteria();
			argomentoCriteria = new ArgomentoCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compitoCriteria.ID.eq(idCompito);
		compito = compitoCriteria.uniqueCompitoInClasse();
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		argomentoCriteria.ID.in(idArgomenti);
		argomenti.addAll(argomentoCriteria.list());
		
		if(registroDocente.isCompitoPresente(compito)){
			registroDocente.inserisciInfoCompito(compito, data, oraInizio, oraFine, argomenti);
			try {
				PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
				try {
					RSPersistentManager.instance().getSession().update(compito);
					t.commit();
				}
				catch (PersistentException e) {
					t.rollback();
					throw e;
				}
			} catch (PersistentException e) {
				throw new RuntimeException(ErrorMessage.COMPITO_NON_AGGIORNABILE);
			}
		}else{
			throw new IllegalStateException(ErrorMessage.COMPITO_INEXISTENT);
		}
		
	}

	public CompitoInClasse getCompitoInCLasse(int idCompitoInClasse) {
		CompitoInClasseCriteria compitoCriteria;
		CompitoInClasse compito;
		
		try{
			compitoCriteria = new CompitoInClasseCriteria();
			
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compitoCriteria.ID.eq(idCompitoInClasse);
		compito = compitoCriteria.uniqueCompitoInClasse();
		
		return compito;
	}

	public Set<CompitoInClasse> getCompitiInCLasse(int idClasse, int idRegistroDocente){
// bisogna controllare che il registro docente appartenga alla classe??
		RegistroDocenteCriteria regDocCriteria;
		RegistroDocente registroDocente;

		try{
			
			regDocCriteria = new RegistroDocenteCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITI_UNLOADED);
		}
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		return registroDocente.getCompitiInClasse();
	}
	
	
}