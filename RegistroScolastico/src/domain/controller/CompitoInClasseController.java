package domain.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.activemq.filter.function.inListFunction;
import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import service.Stampa;
import domain.model.Appello;
import domain.model.Argomento;
import domain.model.ArgomentoCriteria;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;
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
	 * @param idVoti
	 */
	public void inserisciVoti(int idCompito, Map<Integer, Byte> mapVotiGUI) {

		StudenteCriteria studenteCriteria;
		VotoCriteria votoCriteria;
		
		CompitoInClasse compito;
		Map<Studente, Voto> mapVoti;
		Studente studente;
		Voto voto;
		
		
		mapVoti = new HashMap<Studente, Voto>();

		compito = getCompitoInCLasse(idCompito);
		
		try {
			
			//trasforma mapVotiGUI in mapVoti
			for(Integer idS : mapVotiGUI.keySet()){
				studenteCriteria = new StudenteCriteria();
				votoCriteria = new VotoCriteria();
				
				studenteCriteria.ID.eq(idS);
				votoCriteria._voto.eq(mapVotiGUI.get(idS));
				
				studente = studenteCriteria.uniqueStudente();
				voto = votoCriteria.uniqueVoto();
				if(voto != null){//FIXME in questo modo i voti voti che vengono successivamente rimessi a null non vengono considerati e rimane il voto vecchio
					mapVoti.put(studente, voto);
				}
			}
			
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.VOTI_UNLOADED);
		}
		//////////////////////////////////////////////////
//		registroDocente = compito.getInsegnamento();
//		
//		registroDocente.inserisciVoti(compito, mapVoti);
		///////////////////////////////////////////////////
		compito.inserisciVoti(mapVoti);
		
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

		CompitoInClasse compito;
		RegistroDocenteCriteria regDocCriteria;
		RegistroDocente registroDocente;
		ArgomentoCriteria argomentoCriteria;
		Collection<Argomento> argomenti;

		Classe classe;

		java.sql.Date dataCorretta;
		boolean isDataCorretta;
		
		
		argomenti = new LinkedHashSet<Argomento>();
		
		try{

			regDocCriteria = new RegistroDocenteCriteria();
			argomentoCriteria = new ArgomentoCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compito = getCompitoInCLasse(idCompito);
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		if(idArgomenti.length > 0){
			argomentoCriteria.ID.in(idArgomenti);
			argomenti.addAll(argomentoCriteria.list());
		}

		//Controllo correttezza data
		classe = registroDocente.getClasse();
		isDataCorretta = isDataCompitoCorretta(data, classe);
		dataCorretta = data;
		if(!isDataCorretta){
			dataCorretta = compito.getData();
		}
		compito.setInfo(dataCorretta, oraInizio, oraFine, argomenti);
//		registroDocente.inserisciInfoCompito(compito, dataCorretta, oraInizio, oraFine, argomenti);
		
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
		
		if(!isDataCorretta){
			throw new IllegalStateException(ErrorMessage.DATA_WRONG);
		}
		
	}
	
	private void svolgiCompito(int idCompitoInClasse){

		CompitoInClasse compito;

		compito = getCompitoInCLasse(idCompitoInClasse);
		compito.svolgi();
		
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
			throw new RuntimeException(ErrorMessage.COMPITO_NON_AGGIORNABILE);
		}
		
		
	}
	
	public void eliminaCompito(int idCompitoInClasse){
		CompitoInClasseCriteria compitoCriteria;
		CompitoInClasse compito;
		
		compito = getCompitoInCLasse(idCompitoInClasse);
		compito.elimina();
		
		try {
			PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
			try {
				RSPersistentManager.instance().getSession().delete(compito);
				t.commit();
			}
			catch (PersistentException e) {
				t.rollback();
				throw e;
			}
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.COMPITO_NON_ELIMINABILE);
		}
	}
	


	private void annullaCompito(int idCompitoInClasse) {

		CompitoInClasse compito;
		
		compito = getCompitoInCLasse(idCompitoInClasse);
		compito.annulla();
		
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
			throw new RuntimeException(ErrorMessage.COMPITO_NON_AGGIORNABILE);
		}
		
	}
	
	private void disannullaCompito(int idCompitoInClasse) {

		CompitoInClasse compito;

		compito = getCompitoInCLasse(idCompitoInClasse);
		compito.disannulla();
		
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
			throw new RuntimeException(ErrorMessage.COMPITO_NON_AGGIORNABILE);
		}
		
	}
	
	private void chiudiCompito(int idCompitoInClasse) {

		CompitoInClasse compito;

		compito = getCompitoInCLasse(idCompitoInClasse);
		compito.chiudi();
		
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
			throw new RuntimeException(ErrorMessage.COMPITO_NON_AGGIORNABILE);
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
//XXX bisogna controllare che il registro docente appartenga alla classe??
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
		Appello rit = null;
		
		
		appelloController = new FaiAppelloController();
		compito = getCompitoInCLasse(idCompito);
		sqlDate = compito.getData();
		
		if(sqlDate != null){
			localDate = new LocalDate(sqlDate);
			rit =  appelloController.getAppello(compito.getInsegnamento().getClasse().getID(), localDate);
		}
//		else{ 
//			throw new IllegalStateException(ErrorMessage.COMPITO_WITHOUT_DATE);
//		}
		
		return rit;
 
	}
	
	public Map<Studente, Boolean>  getAssenzeCompito(int idCompito) {
		Appello appello;
		CompitoInClasse compito;
		FaiAppelloController appelloController;
		Map<Studente, Boolean> rit;
		
		
		appelloController = new FaiAppelloController();
		appello = getAppello(idCompito);
		
		if(appello != null  && !appello.getAssenzePrese()){
			compito = getCompitoInCLasse(idCompito);
			rit =  appelloController.getAssenzeCompito(compito.getInsegnamento().getClasse().getID(), appello.getID());
		}else{
			rit = new HashMap<Studente, Boolean>();
		};
		
		return rit;
		
	}
	
	private boolean isDataCompitoCorretta(java.sql.Date data, Classe classe){
		
		ClasseController classeController;
		Collection<LocalDate> dateFestive;
		LocalDate localDate;
		boolean rit;
		
		rit = true;
		classeController = new ClasseController();
		localDate = new LocalDate(data);
		
		dateFestive = classeController.getDateFestive(classe.getID());
		
		if(dateFestive.contains(localDate) || !Calendario.getInstance().isInAnnoCorrente(data)){
			rit = false;
		}

		return rit;
	}
	
	public void changeState(int idCompito, CompitoInClasseStateEnum statoFuturo){
		
		CompitoInClasse compito;
		CompitoInClasseStateEnum statoAttuale;
		
		compito = getCompitoInCLasse(idCompito);
		statoAttuale = compito.getState().getStateEnum();
		
		switch (statoFuturo) {

		  case SVOLTO:
			  
			  switch (statoAttuale) {
			  	case DA_SVOLGERE:
			  		svolgiCompito(idCompito);
				break;
				
			  	case ANNULLATO:
					disannullaCompito(idCompito);
				break;

				default:
					throw new IllegalStateException(ErrorMessage.COMPITO_STATE_UNCHANGEABLE);
			  }
			  
		  break;
		
		  case ANNULLATO:
			  annullaCompito(idCompito);
		  break;
		  
		  case CHIUSO:
			  chiudiCompito(idCompito);
		  break;
		  
		  default:
			  throw new IllegalStateException(ErrorMessage.COMPITO_STATE_UNCHANGEABLE);
	  }
	
		
	}


}