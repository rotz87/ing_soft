package domain.controller;

import java.nio.channels.IllegalSelectorException;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import service.Stampa;
import domain.model.Appello;
import domain.model.Argomento;
import domain.model.ArgomentoCriteria;
import domain.model.Classe;
import domain.model.CompitoInClasse;
import domain.model.CompitoInClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.RSPersistentManager;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;
import domain.model.Studente;
import domain.model.StudenteCriteria;
import domain.model.Voto;
import domain.model.VotoCriteria;

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
	public void inserisciVoti(int idCompito, Map<Integer, Byte> mapVotiGUI) {

		CompitoInClasseCriteria compitoCriteria;
		StudenteCriteria studenteCriteria;
		VotoCriteria votoCriteria;
		
		CompitoInClasse compito;
		RegistroDocente registroDocente;
		Map<Studente, Voto> mapVoti;
		Studente studente;
		Voto voto;
		
		mapVoti = new HashMap<Studente, Voto>();
		
		try {
			compitoCriteria = new CompitoInClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compitoCriteria.ID.eq(idCompito);
		compito = compitoCriteria.uniqueCompitoInClasse();
		
		try {
			for(Integer idS : mapVotiGUI.keySet()){
				studenteCriteria = new StudenteCriteria();
				votoCriteria = new VotoCriteria();
				
				studenteCriteria.ID.eq(idS);
				votoCriteria.voto.eq(mapVotiGUI.get(idS));
				
				studente = studenteCriteria.uniqueStudente();
				voto = votoCriteria.uniqueVoto();
				
				mapVoti.put(studente, voto);
			}
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.VOTI_UNLOADED);
		}
		
		registroDocente = compito.getInsegnamento();
		
		registroDocente.inserisciVoti(compito, mapVoti);
		
		try {
			PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
			try {
				for(Studente s: mapVoti.keySet()){
					RSPersistentManager.instance().getSession().save(s.getLibrettoVoti());
				}
				t.commit();
			}
			catch (PersistentException e) {
				t.rollback();
				throw e;
			}
		} catch (PersistentException e) {
			Stampa.stampaln("getCause: "+e.getCause());
			Stampa.stampaln();

			throw new RuntimeException(ErrorMessage.VOTI_NON_INSERIBILI);
		}
		
		
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
		
		if(idArgomenti.length > 0){
			argomentoCriteria.ID.in(idArgomenti);
			argomenti.addAll(argomentoCriteria.list());
		}
		
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
	
	public Map<Studente, Voto> getVotiCompito(int idCompito){
		CompitoInClasse compito;
		HashMap<Studente, Voto> rit;
		Classe classe;
		
		compito = getCompitoInCLasse(idCompito);
		rit = new HashMap<Studente, Voto>();
		classe = compito.getInsegnamento().getClasse();
		
		for(Studente studente: classe.getStudenti()){
			if(studente.getLibrettoVoti().getLibrettoLineItem(compito) != null){
				rit.put(studente, studente.getLibrettoVoti().getLibrettoLineItem(compito).getVoto());
			}else{
				rit.put(studente, null); 
			}
		}
		
		return rit;
	}
	
	private Appello getAppello(int idCompito){
		CompitoInClasse compito;
		FaiAppelloController appelloController;
		LocalDate localDate;
		Date sqlDate;
		
		appelloController = new FaiAppelloController();
		compito = getCompitoInCLasse(idCompito);
		sqlDate = compito.getData();
		
		if(sqlDate != null){
		localDate = new LocalDate(sqlDate);
		}else{
			throw new IllegalStateException(ErrorMessage.COMPITO_WITHOUT_DATE);
		}
		
		return appelloController.getAppello(compito.getInsegnamento().getClasse().getID(), localDate);
 
	}
	
	public Map<Studente, Boolean>  getAssenzeCompito(int idCompito) {
		Appello appello;
		CompitoInClasse compito;
		FaiAppelloController appelloController;
		
		appello = getAppello(idCompito);
		compito = getCompitoInCLasse(idCompito);
		appelloController = new FaiAppelloController();
		
		Stampa.stampaln("ClasseID: "+compito.getInsegnamento().getClasse().getID());
		Stampa.stampaln("AppelloID: "+ appello.getID());
		
		return appelloController.getBoolAssenze(compito.getInsegnamento().getClasse().getID(), appello.getID());
		
	}
}