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
	
	
	public void avviaAppello(int idClasse, int idDocente) throws PersistentException {

		ClasseCriteria classeCriteria = new ClasseCriteria();
		DocenteCriteria docenteCriteria = new DocenteCriteria();
		Classe classeCorrente;
		Docente docenteCorrente;
		
		classeCriteria.ID.eq(idClasse);
		classeCorrente = classeCriteria.uniqueClasse();
		
		docenteCriteria.ID.eq(idDocente);
		docenteCorrente = docenteCriteria.uniqueDocente();
		
//		Stempa.stampaln("docente corrente: " + docenteCorrente.getCognome());
//		Stempa.stampaln("classe corrente: " + classeCorrente.getNome());
//		Stempa.stampaln("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();

			PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
			try {
				RSPersistentManager.instance().getSession().save(registroAssenzeCorrente.getAppelloOdierno());
				t.commit();
			}
			catch (PersistentException e) {
				t.rollback();
				throw e;
			}
			
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(Integer[] idStudenti, int idClasse, int idDocente) throws PersistentException {
		
		ClasseCriteria classeCriteria = new ClasseCriteria();
		DocenteCriteria docenteCriteria = new DocenteCriteria();
		StudenteCriteria studenteCriteria = new StudenteCriteria();
		Classe classeCorrente;
		Docente docenteCorrente;
		List<LibrettoAssenze> libretti = new LinkedList<LibrettoAssenze>();
		List<Studente> studenti = new LinkedList<Studente>();
		
		classeCriteria.ID.eq(idClasse);
		classeCorrente = classeCriteria.uniqueClasse();
		
		docenteCriteria.ID.eq(idDocente);
		docenteCorrente = docenteCriteria.uniqueDocente();
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			studenteCriteria.ID.in(idStudenti);
			
//			LibrettoAssenzeCriteria librettoAssenzeCriteria = new LibrettoAssenzeCriteria();
//			librettoAssenzeCriteria.studenteId.in(idStudenti);
//			libretti = librettoAssenzeCriteria.list();
			studenti.addAll(studenteCriteria.list());
			
			for(Studente studente : studenti){
				libretti.add(studente.getLibrettoAssenze());
			}
			
			registroAssenzeCorrente.registraAssenze(libretti);
			
			PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
			try {
			
				for(LibrettoAssenze libAss : libretti){
					RSPersistentManager.instance().getSession().save(libAss.getUltimaAssenzaNonGiustificata());
//					RSPersistentManager.instance().
				}
				t.commit();
			}
			catch (PersistentException e) {
				t.rollback();
				throw e;
			}
			
//			RSPersistentManager.instance().getSession().update(librettoAssenzeCriteria.listLibrettoAssenze());
//			RSPersistentManager.instance().getSession().update(registroAssenzeCorrente);

		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO A METTERE LE ASSENZE PER QUESTA CLASSE");
		}

	}
	
	public Appello getAppelloOdierno(int idClasse) throws PersistentException{
		ClasseCriteria classeCriteria = new ClasseCriteria();
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		return classeCorrente.getRegistroAssenze().getAppelloOdierno();
		
//		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
//		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloOdierno();
		
		
	}
	
	public Appello getAppello(int idClasse, LocalDate data) throws PersistentException{
		ClasseCriteria classeCriteria = new ClasseCriteria();
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		return classeCorrente.getRegistroAssenze().getAppelloByData(data);
//		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public Appello getAppello(int idClasse, int idAppello) throws PersistentException{
		ClasseCriteria classeCriteria = new ClasseCriteria();
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		AppelloCriteria appelloCriteria = new AppelloCriteria();
		appelloCriteria.ID.eq(idAppello);
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
			
			return appelloCorrente;
		}else{
			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
		}
		
//		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
//		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
//		
//		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
//		
//			return DBFake.getInstance().getAppelloById(idAppello);
//		}else{
//			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
//		}
	}
	
	public Collection<Appello> getAppelli(int idClasse) throws PersistentException{
		ClasseCriteria classeCriteria = new ClasseCriteria();
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.getAppelli().values();
		
//		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
//		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
//		return registroAssenzeCorrente.getAppelli().values();		
	}
	
	public boolean isAppelloOdiernoAvviabile(int idClasse) throws PersistentException{
		
//		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		ClasseCriteria classeCriteria = new ClasseCriteria();
		classeCriteria.ID.eq(idClasse);
		Classe classeCorrente = classeCriteria.uniqueClasse();
		
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.isAppelloOdiernoAvviabile();
	}
	
	public HashMap<Studente, Boolean>  getBoolAssenze(int idClasse, int idAppello) throws PersistentException{
		AppelloCriteria appelloCriteria = new AppelloCriteria();
		ClasseCriteria classeCriteria = new ClasseCriteria();
		
		appelloCriteria.ID.eq(idAppello);
		
//		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		HashMap<Studente, Boolean> rit;
		
		if(appelloCorrente == null){
			throw new IllegalStateException("APPELLO INESISTENTE");
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
			throw new IllegalStateException("ASSENZE NON PRESE");
		}
	}
	
	
	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 * @return Map<idStudente, Assenza>
	 * @throws PersistentException 
	 */
	public HashMap<Integer, Assenza>  getAssenze(int idClasse, int idAppello) throws PersistentException{
//		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		AppelloCriteria appelloCriteria = new AppelloCriteria();
		ClasseCriteria classeCriteria = new ClasseCriteria();
		
		appelloCriteria.ID.eq(idAppello);
		
		Appello appelloCorrente = appelloCriteria.uniqueAppello();
		
		HashMap<Integer, Assenza> rit;
		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Integer, Assenza>();
//			Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			classeCriteria.ID.eq(idClasse);
			Classe classeCorrente = classeCriteria.uniqueClasse();
			RegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(Studente studente : classeCorrente.getStudenti()){
				rit.put(studente.getID(), studente.getLibrettoAssenze().getAssenza(appelloCorrente));
				
			}
			
			return rit;
		}else{
			throw new IllegalStateException("ASSENZE NON PRESE");
		}
	}
	

}
