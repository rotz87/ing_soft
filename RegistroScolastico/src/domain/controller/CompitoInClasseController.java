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
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.ErrorMessage;
import domain.model.RSPersistentManager;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;
import domain.model.Studente;
import domain.model.StudenteCriteria;
import domain.model.Voto;
import domain.model.VotoCriteria;

public class CompitoInClasseController {

	
	public CompitoInClasse creaCompito(int idRegistroDocente, int idDocente) {

		RegistroDocente registroDocente;
		Docente docente;
		CompitoInClasse compito;

		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		docente = getDocenteById(idDocente);
		
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
	public void inserisciVoti(int idClasse, int idRegistroDocente, int idCompito, Map<Integer, Byte> mapVotiGUI) {

		StudenteCriteria studenteCriteria;
		VotoCriteria votoCriteria;
		DocenteController docenteController;
		Docente docente;
		
		Classe classe;
		RegistroDocente registroDocente;
		CompitoInClasse compito;
		Map<Studente, Voto> mapVoti;
		Studente studente;
		Voto voto;
		
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		docenteController = new DocenteController();
		docente = getDocenteById(docenteController.getIdDocenteProva());
		
		mapVoti = new HashMap<Studente, Voto>();

		compito = getCompitoInCLasseByID(idCompito);

		if(docente.haRegistroDocente(registroDocente) ){
			if(registroDocente.getCompitiInClasse().contains(compito)){
				if (registroDocente.getClasse().equals(classe)){
					
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
//					registroDocente = compito.getInsegnamento();
//					
//					registroDocente.inserisciVoti(compito, mapVoti);
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
					
				}else{
					throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
				}
			}else{
				throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
			}
		}else{
			throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
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
	public void inserisciInfoCompito(int idClasse, int idRegistroDocente, int idCompito, java.sql.Date data, Time oraInizio, Time oraFine, int[] idArgomenti) {

		CompitoInClasse compito;
		RegistroDocente registroDocente;
		ArgomentoCriteria argomentoCriteria;
		Collection<Argomento> argomenti;
		Docente docente;
		DocenteController docenteController;

		Classe classe;
		Classe classeReg;

		java.sql.Date dataCorretta;
		boolean isDataCorretta;

		argomenti = new LinkedHashSet<Argomento>();
		docenteController = new DocenteController();
		docente = getDocenteById(docenteController.getIdDocenteProva());
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		try{

			argomentoCriteria = new ArgomentoCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compito = getCompitoInCLasseByID(idCompito);
		
		if(docente.haRegistroDocente(registroDocente) ){
			if(registroDocente.getCompitiInClasse().contains(compito)){
				if (registroDocente.getClasse().equals(classe)){
					registroDocente = getRegistroDocenteById(idRegistroDocente);
					
					if(idArgomenti.length > 0){
						argomentoCriteria.ID.in(idArgomenti);
						argomenti.addAll(argomentoCriteria.list());
					}
			
					//Controllo correttezza data
					classeReg = registroDocente.getClasse();
					isDataCorretta = isDataCompitoCorretta(data, classeReg);
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
				}else{
					throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
				}
			}else{
				throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
			}
		}else{
			throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}				
	}
	

	
	public void eliminaCompito(int idClasse, int idRegistroDocente, int idCompitoInClasse){

		CompitoInClasse compito;

		RegistroDocente registroDocente;
		Docente docente;
		DocenteController docenteController;

		Classe classe;
		
		docenteController = new DocenteController();
		docente = getDocenteById(docenteController.getIdDocenteProva());
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		compito = getCompitoInCLasseByID(idCompitoInClasse);
		
		if(docente.haRegistroDocente(registroDocente) ){
			if(registroDocente.getCompitiInClasse().contains(compito)){
				if (registroDocente.getClasse().equals(classe)){
		
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
				}else{
					throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
				}
			}else{
				throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
			}
		}else{
		throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}
	}

	public CompitoInClasse getCompitoInCLasse(int idClasse, int idRegistroDocente, int idCompitoInClasse) {
		RegistroDocente registroDocente;
		Classe classe;
		CompitoInClasse compito;
		
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		classe = getClasseById(idClasse);
		compito = getCompitoInCLasseByID(idCompitoInClasse);
		
		if(!registroDocente.getClasse().equals(classe) ){
			throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
		}else if(!registroDocente.getCompitiInClasse().contains(compito)){
			throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
		}

		return compito;
	}

	public Set<CompitoInClasse> getCompitiInCLasse(int idClasse, int idRegistroDocente){
//XXX - RISOLTO bisogna controllare che il registro docente appartenga alla classe??
		Classe classe;
		RegistroDocente registroDocente;
		
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		if(!registroDocente.getClasse().equals(classe) ){
			throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
		}
		
		return registroDocente.getCompitiInClasse();
		
	}
	
	public Map<Studente, Voto> getVotiCompito(int idClasse, int idRegistroDocente, int idCompito){
		CompitoInClasse compito;
		HashMap<Studente, Voto> rit;
		Classe classeCompito;
		Classe classe;
		RegistroDocente registroDocente;
		
		
		compito = getCompitoInCLasseByID(idCompito);
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		rit = new HashMap<Studente, Voto>();
		classeCompito = compito.getInsegnamento().getClasse();

		if(!registroDocente.getClasse().equals(classe) ){
			throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
		}else if(!registroDocente.getCompitiInClasse().contains(compito)){
			throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
		}
		
		for(Studente studente: classeCompito.getStudenti()){
			if(studente.getLibrettoVoti().getLibrettoLineItem(compito) != null){
				rit.put(studente, studente.getLibrettoVoti().getLibrettoLineItem(compito).getVoto());
			}else{
				rit.put(studente, null); 
			}
		}
		
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
			compito = getCompitoInCLasseByID(idCompito);
			rit =  appelloController.getAssenzeCompito(compito.getInsegnamento().getClasse().getID(), appello.getID());
		}else{
			rit = new HashMap<Studente, Boolean>();
		};
		
		return rit;
		
	}
	
	public void changeState(int idClasse, int idRegistroDocente, int idCompito, CompitoInClasseStateEnum statoFuturo){
		
		CompitoInClasse compito;
		CompitoInClasseStateEnum statoAttuale;
		Docente docente;
		DocenteController docenteController;
		RegistroDocente registroDocente;
		Classe classe;
		
		docenteController = new DocenteController();
		docente = getDocenteById(docenteController.getIdDocenteProva());
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		compito = getCompitoInCLasseByID(idCompito);
		
		if(docente.haRegistroDocente(registroDocente) ){
			if(registroDocente.getCompitiInClasse().contains(compito)){
				if (registroDocente.getClasse().equals(classe)){
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
				}else{
					throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
				}
			}else{
				throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
			}
		}else{
		throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}
		
	}
	
	private void svolgiCompito(int idCompitoInClasse){

		CompitoInClasse compito;

		compito = getCompitoInCLasseByID(idCompitoInClasse);
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

	private void annullaCompito(int idCompitoInClasse) {

		CompitoInClasse compito;
		
		compito = getCompitoInCLasseByID(idCompitoInClasse);
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

		compito = getCompitoInCLasseByID(idCompitoInClasse);
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

		compito = getCompitoInCLasseByID(idCompitoInClasse);
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
	
	private Appello getAppello(int idCompito){
		CompitoInClasse compito;
		FaiAppelloController appelloController;
		LocalDate localDate;
		Date sqlDate;
		Appello rit = null;
		
		
		appelloController = new FaiAppelloController();
		compito = getCompitoInCLasseByID(idCompito);
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
	

	private CompitoInClasse getCompitoInCLasseByID(int idCompitoInClasse) {
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
	
	private Classe getClasseById(int idClasse){
		ClasseCriteria classeCriteria;

		Classe classe;

		try{

			classeCriteria = new ClasseCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.CLASSE_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		classe = classeCriteria.uniqueClasse();
		
		return classe;
	}
	
	private RegistroDocente getRegistroDocenteById(int idRegistroDocente){
		RegistroDocenteCriteria regDocCriteria;

		RegistroDocente registroDocente;

		try{
			regDocCriteria = new RegistroDocenteCriteria();

		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.REGISTRO_DOCENTE_UNLOADED);
		}
		
		regDocCriteria.ID.eq(idRegistroDocente);
		registroDocente = regDocCriteria.uniqueRegistroDocente();
		
		return registroDocente;
	}
	
	private Docente getDocenteById(int idDocente){

		DocenteCriteria docenteCriteria;

		Docente docente;

		try {

			docenteCriteria = new DocenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.DOCENTE_UNLOADED);
		}
				
		docenteCriteria.ID.eq(idDocente);
		docente = docenteCriteria.uniqueDocente();
		
		return docente;
	}
	


}