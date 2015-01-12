package domain;

import java.util.*;

public class Scuola {

	private Map<Long, Classe> classi;
	private Map<Long, Docente> docenti;
	
	public Scuola() {
		classi = new TreeMap<Long, Classe>();
		docenti = new TreeMap<Long, Docente>();
	}
	
	/**Per le prove
	 * 
	 */
	public void setClassi( Map<Long, Classe> classi){
		this.classi = classi;
	}
	
	/**Per le prove
	 * 
	 */
	public void setDocenti( Map<Long, Docente> docenti){
		this.docenti = docenti;
	}
	
	public Classe getCalsseById(Long idClasse){
		return classi.get(idClasse);
	}
	
	public Docente getDocenteById(Long idDocente){
		return docenti.get(idDocente);
	}

}