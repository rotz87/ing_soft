package service;

import java.util.Map;
import java.util.TreeMap;

import domain.*;



public class DBFake {
	
	private static DBFake instance;
	
	private Map<Long, Classe> classi;
	private Map<Long, Docente> docenti;
	private Map<Long, Studente> tuttiGliStudenti;
	  // Private constructor prevents instantiation from other classes
	private DBFake() {
		  classi = new TreeMap<Long, Classe>();
		  docenti = new TreeMap<Long, Docente>();
		  tuttiGliStudenti = new TreeMap<Long, Studente>();
	}
	 
	  /**
	   * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
	   * or the first access to SingletonHolder.INSTANCE, not before.
	   */


	public static synchronized DBFake getInstance() {
	    if(DBFake.instance == null){
	    	DBFake.instance = new DBFake();
	    }
	    return DBFake.instance;
	}
	
	public void setClassi( Map<Long, Classe> classi){
		this.classi = classi;
	}

	public void setDocenti( Map<Long, Docente> docenti){
		this.docenti = docenti;
	}
	
	public void setStudenti(Map<Long, Studente> studenti){
		this.tuttiGliStudenti = studenti;
	}
	
	public Classe getCalsseById(Long idClasse){
		return classi.get(idClasse);
	}
	
	public Docente getDocenteById(Long idDocente){
		return docenti.get(idDocente);
	}
	public Studente getStudenteById(Long idStudente){
		return tuttiGliStudenti.get(idStudente);
	}
	
}
