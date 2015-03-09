package domain.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.model.Appello;
import domain.model.AppelloCriteria;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.LibrettoAssenze;
import domain.model.LibrettoAssenzeCriteria;
import domain.model.RSPersistentManager;
import domain.model.RegistroAssenze;
import domain.model.Studente;
import domain.model.StudenteCriteria;
//import service.DBFake;

public class FaiAppelloController {
//	private Scuola scuola;

	public FaiAppelloController() {
//		scuola = new Scuola();
	}
	
	
	public void avviaAppello(int idClasse, int idDocente) {

		ClasseCriteria classeCriteria;
		DocenteCriteria docenteCriteria;
		Classe classeCorrente;
		Docente docenteCorrente;
		
		classeCriteria = null;
		docenteCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
			docenteCriteria = new DocenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.APPELLO_NON_AVVIABILE);
		}
		
		classeCriteria.ID.eq(idClasse);
		classeCorrente = classeCriteria.uniqueClasse();
		
		docenteCriteria.ID.eq(idDocente);
		docenteCorrente = docenteCriteria.uniqueDocente();
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();

			try {
				PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
				try {
					RSPersistentManager.instance().getSession().save(registroAssenzeCorrente.getAppelloOdierno());
					t.commit();
				}
				catch (PersistentException e) {
					t.rollback();
					throw e;
				}
			} catch (PersistentException e) {
				throw new RuntimeException(ErrorMessage.APPELLO_NON_AVVIABILE);
			}

			
		}else{
			throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}
		
	}
	
	public void registraAssenze(Integer[] idStudenti, int idClasse, int idDocente) {
		
		ClasseCriteria classeCriteria;
		DocenteCriteria docenteCriteria;
		StudenteCriteria studenteCriteria;
		Classe classeCorrente;
		Docente docenteCorrente;
		List<LibrettoAssenze> libretti = new LinkedList<LibrettoAssenze>();
		List<Studente> studenti = new LinkedList<Studente>();
		
		classeCriteria = null;
		docenteCriteria = null;
		studenteCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
			docenteCriteria = new DocenteCriteria();
			studenteCriteria = new StudenteCriteria();
		} catch (PersistentException e) {
			new RuntimeException(ErrorMessage.ASSENZE_UNRECORDABLE);
		}
		
		classeCriteria.ID.eq(idClasse);
		classeCorrente = classeCriteria.uniqueClasse();
		
		docenteCriteria.ID.eq(idDocente);
		docenteCorrente = docenteCriteria.uniqueDocente();
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			studenteCriteria.ID.in(idStudenti);
			
			studenti.addAll(studenteCriteria.list());
			
			for(Studente studente : studenti){
				libretti.add(studente.getLibrettoAssenze());
			}
			
			registroAssenzeCorrente.registraAssenze(libretti);
			
			try{
				PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
				try {
				
					for(LibrettoAssenze libAss : libretti){
						RSPersistentManager.instance().getSession().save(libAss.getUltimaAssenzaNonGiustificata());
					}
					t.commit();
				}
				catch (PersistentException e) {
					t.rollback();
					throw e;
				}
			}catch (PersistentException e) {
				new RuntimeException(ErrorMessage.ASSENZE_UNRECORDABLE);
			}

		}else{
			throw new IllegalStateException(ErrorMessage.DOCENTE_UNQUALIFIED);
		}

	}
	
	public Appello getAppelloOdierno(int idClasse) {
		ClasseCriteria classeCriteria;
		
		classeCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.APPELLO_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		return classeCorrente.getRegistroAssenze().getAppelloOdierno();

	}
	
	public Appello getAppello(int idClasse, LocalDate data) {
		
		ClasseCriteria classeCriteria;
		
		classeCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.APPELLO_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		return classeCorrente.getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public Appello getAppello(int idClasse, int idAppello) {

		ClasseCriteria classeCriteria;
		AppelloCriteria appelloCriteria;
		
		classeCriteria = null;
		appelloCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
			appelloCriteria = new AppelloCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.APPELLO_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		appelloCriteria.ID.eq(idAppello);
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
			
			return appelloCorrente;
		}else{
			throw new IllegalStateException(ErrorMessage.APPELLO_CLASSE_INCONSISTENT);
		}
		
	}
	
	public Collection<Appello> getAppelli(int idClasse) {
		
		ClasseCriteria classeCriteria;
		
		classeCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.APPELLI_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.getAppelli().values();
		
	}
	
	public boolean isAppelloOdiernoAvviabile(int idClasse) {

		ClasseCriteria classeCriteria;
		
		classeCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.CLASSE_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.isAppelloOdiernoAvviabile();
	}
	
	public HashMap<Studente, Boolean>  getBoolAssenze(int idClasse, int idAppello) {

		ClasseCriteria classeCriteria;
		AppelloCriteria appelloCriteria;
		
		classeCriteria = null;
		appelloCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
			appelloCriteria = new AppelloCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.ASSENZE_UNLOADED);
		}
		
		appelloCriteria.ID.eq(idAppello);
		
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		HashMap<Studente, Boolean> rit;
		
		if(appelloCorrente == null){
			throw new IllegalStateException(ErrorMessage.APPELLO_INEXISTENT);
		}

		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Studente, Boolean>();
//			Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			classeCriteria.ID.eq(idClasse);
			Classe classeCorrente = classeCriteria.uniqueClasse();
			RegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(Studente studente : classeCorrente.getStudenti()){
				rit.put(studente, studente.getLibrettoAssenze().esisteAssenza(appelloCorrente));
				
			}
			
			return rit;
		}else{
			throw new IllegalStateException(ErrorMessage.ASSENZE_UNRECORDED);
		}
	}
	
	
	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 * @return Map<idStudente, Assenza>
	 * @throws PersistentException 
	 */
	public HashMap<Integer, Assenza>  getAssenze(int idClasse, int idAppello) {

		ClasseCriteria classeCriteria;
		AppelloCriteria appelloCriteria;
		
		classeCriteria = null;
		appelloCriteria = null;
		
		try {
			classeCriteria = new ClasseCriteria();
			appelloCriteria = new AppelloCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.ASSENZE_UNLOADED);
		}
		
		appelloCriteria.ID.eq(idAppello);
		
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		
		HashMap<Integer, Assenza> rit;
		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Integer, Assenza>();
			classeCriteria.ID.eq(idClasse);
			Classe classeCorrente = classeCriteria.uniqueClasse();
			RegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(Studente studente : classeCorrente.getStudenti()){
				rit.put(studente.getID(), studente.getLibrettoAssenze().getAssenza(appelloCorrente));
				
			}
			
			return rit;
		}else{
			throw new IllegalStateException(ErrorMessage.ASSENZE_UNRECORDED);
		}
	}

	/**
	 * 
	 * @param idClasse
	 * @param idDocente
	 */
	public void avviaAppello(Long idClasse, Long idDocente) {
		// TODO - implement FaiAppelloController.avviaAppello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idStudenti
	 * @param idClasse
	 * @param idDocente
	 */
	public void registraAssenze(Long[] idStudenti, Long idClasse, Long idDocente) {
		// TODO - implement FaiAppelloController.registraAssenze
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 */
	public Appello getAppelloOdierno(Long idClasse) {
		// TODO - implement FaiAppelloController.getAppelloOdierno
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 * @param data
	 */
	public Appello getAppello(Long idClasse, org.joda.time.LocalDate data) {
		// TODO - implement FaiAppelloController.getAppello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 */
	public Appello getAppello(Long idClasse, long idAppello) {
		// TODO - implement FaiAppelloController.getAppello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 */
	public Appello getAppello(Long idClasse, Long idAppello) {
		// TODO - implement FaiAppelloController.getAppello
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 */
	public java.util.Collection<Appello> getAppelli(Long idClasse) {
		// TODO - implement FaiAppelloController.getAppelli
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 */
	public boolean isAppelloOdiernoAvviabile(long idClasse) {
		// TODO - implement FaiAppelloController.isAppelloOdiernoAvviabile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 */
	public java.util.HashMap<Studente, Boolean> getBoolAssenze(Long idClasse, Long idAppello) {
		// TODO - implement FaiAppelloController.getBoolAssenze
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 * @return Map<idStudente, Assenza>
	 */
	public java.util.HashMap<Long, Assenza> getAssenze(Long idClasse, Long idAppello) {
		// TODO - implement FaiAppelloController.getAssenze
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idClasse
	 */
	public java.util.Collection<Studente> getStudenti(Long idClasse) {
		// TODO - implement FaiAppelloController.getStudenti
		throw new UnsupportedOperationException();
	}
	

}
