package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import service.RSPersistentManager;
import domain.error.ErrorMessage;
import domain.model.Appello;
import domain.model.AppelloCriteria;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAppelli;
import domain.model.Studente;
import domain.model.StudenteCriteria;

public class FaiAppelloController {
	

	public FaiAppelloController() {

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
			RegistroAppelli registroAppelliCorrente = classeCorrente.getRegistroAppelli();
			registroAppelliCorrente.avviaAppello();

			try {
				PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
				try {
					RSPersistentManager.instance().getSession().save(registroAppelliCorrente.getAppelloOdierno());
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
			RegistroAppelli registroAppelliCorrente = classeCorrente.getRegistroAppelli();
			
			if(idStudenti.length >0){
				studenteCriteria.ID.in(idStudenti);
				studenti.addAll(studenteCriteria.list());
			}
			
			for(Studente studente : studenti){
				libretti.add(studente.getLibrettoAssenze());
			}
			
			registroAppelliCorrente.registraAssenze(libretti);
			
			try{
				PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
				try {
					RSPersistentManager.instance().getSession().save(registroAppelliCorrente.getAppelloOdierno());
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
		
		return classeCorrente.getRegistroAppelli().getAppelloOdierno();

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
		return classeCorrente.getRegistroAppelli().getAppelloByData(data);
		
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
		
		if ( classeCorrente.getRegistroAppelli().esisteAppello(appelloCorrente)){		
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
		
		RegistroAppelli registroAppelliCorrente = classeCorrente.getRegistroAppelli();
		
		return registroAppelliCorrente.getAppelli().values();
		
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
		
		RegistroAppelli registroAppelliCorrente = classeCorrente.getRegistroAppelli();
		return registroAppelliCorrente.isAppelloOdiernoAvviabile();
	}
	
	public HashMap<Studente, Boolean> getAssenzeCompito(int idClasse, int idAppello) {

		HashMap<Studente, Boolean> rit;
		HashMap<Studente, Assenza> assenze;
		
		assenze = getAssenzeNoException(idClasse, idAppello);
		rit = new HashMap<Studente, Boolean>();
		boolean b;
		if(assenze != null){
			for(Studente studente : assenze.keySet()){
				if(assenze.get(studente) == null){
					b=false;
				}else{
					b=true;
				}
				rit.put(studente, b);
			}
		}else{

		}	
		return rit;
	}
	
	
	public HashMap<Studente, Boolean> getAssenzeCompito(int idClasse, LocalDate data){

		ClasseCriteria classeCriteria;
		Classe classe;
		RegistroAppelli registroAppelli;
		Appello appello;
		HashMap<Studente, Boolean> assenzePrese;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.STUDENTI_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		classe = classeCriteria.uniqueClasse();
		registroAppelli = classe.getRegistroAppelli();
		appello = registroAppelli.getAppelloByData(data);
		
		if(appello != null){
			assenzePrese = getAssenzeCompito(idClasse, appello.getID());
		}else{
			assenzePrese = new HashMap<Studente, Boolean>();
		}
		
		return assenzePrese;
	}
	
	
	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 * @return Map<idStudente, Assenza>
	 * @throws PersistentException 
	 */
	public HashMap<Studente, Assenza> getAssenze(int idClasse, int idAppello) {
		
		HashMap<Studente, Assenza> rit;
		
		rit = getAssenzeNoException(idClasse, idAppello);
		
		if (rit == null){
			throw new IllegalStateException(ErrorMessage.ASSENZE_UNRECORDED);
		}
		
		return rit;
	}
	
	public Collection<Studente> getSoloPresenti(int idClasse, LocalDate data){

		Collection<Studente> studentiPresenti = new LinkedList<Studente>();
		ClasseCriteria classeCriteria;
		Classe classe;
		RegistroAppelli registroAppelli;
		Appello appello;
		Map<Studente, Boolean> boolAssenze;
		
		try {
			classeCriteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.STUDENTI_UNLOADED);
		}
		
		classeCriteria.ID.eq(idClasse);
		classe = classeCriteria.uniqueClasse();
		registroAppelli = classe.getRegistroAppelli();
		appello = registroAppelli.getAppelloByData(data);
		
		if(appello.getAssenzePrese()){

			boolAssenze = getAssenzeCompito(idClasse, appello.getID());
			for (Studente studente : boolAssenze.keySet()) {
				if(! boolAssenze.get(studente)){
					studentiPresenti.add(studente);
				}
			}	
		}else{
			throw new IllegalStateException(ErrorMessage.ASSENZE_UNRECORDED);
		}
		
		return studentiPresenti;
	}
	
	private HashMap<Studente, Assenza> getAssenzeNoException(int idClasse, int idAppello){

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
		
		HashMap<Studente, Assenza> rit;
		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Studente, Assenza>();
			classeCriteria.ID.eq(idClasse);
			Classe classeCorrente = classeCriteria.uniqueClasse();
	
			for(Studente studente : classeCorrente.getStudenti()){
				rit.put(studente, studente.getLibrettoAssenze().getAssenza(appelloCorrente));
				
			}
			
		}else{
			rit = null;
		}
		return rit;
	}

}
