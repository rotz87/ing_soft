package controller;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import service.RSPersistentManager;
import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;
import domain.model.Appello;
import domain.model.Argomento;
import domain.model.ArgomentoCriteria;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.StudenteCriteria;
import domain.model.Voto;
import domain.model.compitoCommand.CompitoCommand;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseCriteria;
import domain.model.compitoInClasse.CompitoInClasseState;

public class CompitoInClasseController {

	
	public CompitoInClasse creaCompito(int idClasse, int idRegistroDocente, int idDocente) {

		RegistroDocente registroDocente;
		Docente docente;
		CompitoInClasse compito;
		Classe classe;

		registroDocente = getRegistroDocenteById(idRegistroDocente);
		classe = getClasseById(idClasse);
		docente = getDocenteById(idDocente);
		
		if(docente.haRegistroDocente(registroDocente)){
			if(registroDocente.getClasse().equals(classe)){
				compito = registroDocente.creaCompito();
				try {
					PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
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
				throw new IllegalStateException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
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
	public void inserisciVoti(int idClasse, int idRegistroDocente, int idCompito, Map<Integer, Voto> mapVotiGUI) {

		StudenteCriteria studenteCriteria;
		CompitoInClasse compito;
		Map<Studente, Voto> mapVoti;
		Studente studente;
		Voto voto;
				
		mapVoti = new HashMap<Studente, Voto>();
		compito = getCompitoInCLasseByID(idCompito);

		try{
			checkCompito(idClasse, idRegistroDocente, compito);
			try {
				//trasforma mapVotiGUI in mapVoti
				for(Integer idS : mapVotiGUI.keySet()){
					studenteCriteria = new StudenteCriteria();
					studenteCriteria.ID.eq(idS);
					studente = studenteCriteria.uniqueStudente();
		
					voto = mapVotiGUI.get(idS);
					mapVoti.put(studente, voto);
				}
				
			} catch (PersistentException e) {
				throw new RuntimeException(ErrorMessage.VOTI_UNLOADED);
			}
			compito.inserisciVoti(mapVoti);
			
			try {
				PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
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
				throw new RuntimeException(ErrorMessage.VOTI_NON_INSERIBILI);
			}
					
		}catch(DomainCheckedException e){
			throw new IllegalStateException(e.getMessage());
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
		Classe classeReg;
		java.sql.Date dataCorretta;
		boolean isDataCorretta;
		
		argomenti = new LinkedHashSet<Argomento>();
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		try{

			argomentoCriteria = new ArgomentoCriteria();
		}catch (PersistentException e){
			throw new  RuntimeException(ErrorMessage.COMPITO_UNLOADED);
		}
		
		compito = getCompitoInCLasseByID(idCompito);
		
		try{
			checkCompito(idClasse, idRegistroDocente, compito);
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
			
			updateCompitoDB(compito);
			
			if(!isDataCorretta){
				throw new IllegalStateException(ErrorMessage.DATA_WRONG);
			}
		}catch(DomainCheckedException e){
			throw new IllegalStateException(e.getMessage());
		}			
	}
	

	
	public void eliminaCompito(int idClasse, int idRegistroDocente, int idCompitoInClasse){

		CompitoInClasse compito;		
		compito = getCompitoInCLasseByID(idCompitoInClasse);
		
		try{
			checkCompito(idClasse, idRegistroDocente, compito);
			compito.elimina();
			
			try {
				PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
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
		}catch(DomainCheckedException e ){
			throw new IllegalStateException(e.getMessage());
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

	
	public void cambiaStatoCompito(int idClasse, int idRegistroDocente, int idCompitoInClasse, CompitoInClasseState statoFuturo) {

		CompitoInClasse compito;
		CompitoCommand command;
		compito = getCompitoInCLasseByID(idCompitoInClasse);
		
		try{
			checkCompito(idClasse, idRegistroDocente, compito);
			command = statoFuturo.getCompitoCommand();
			command.execute(compito);
			updateCompitoDB(compito);
		}catch(DomainCheckedException e){
			throw new IllegalStateException(e.getMessage());
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
		RegistroDocenteController registroDocenteController;
		registroDocenteController = new RegistroDocenteController();
		return registroDocenteController.getRegistroDocente(idRegistroDocente);
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
	
	private void checkCompito(int idClasse, int idRegistroDocente, CompitoInClasse compito) throws DomainCheckedException{

		Docente docente;
		DocenteController docenteController;
		RegistroDocente registroDocente;
		Classe classe;
		
		docenteController = new DocenteController();
		docente = getDocenteById(docenteController.getIdDocenteProva());
		classe = getClasseById(idClasse);
		registroDocente = getRegistroDocenteById(idRegistroDocente);
		
		if(!docente.haRegistroDocente(registroDocente) ){
			throw new DomainCheckedException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}else if (!registroDocente.contain(compito)){
			throw new DomainCheckedException(ErrorMessage.COMPITO_NOT_BELONGING_REGISTRO);
		}else if(!registroDocente.haClasse(classe)){
			throw new DomainCheckedException(ErrorMessage.REGISTRO_DOCENTE_UNBELONGING);
		}
	}
	
	private void updateCompitoDB(CompitoInClasse compito){
		try {
			PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
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
	}

	
}