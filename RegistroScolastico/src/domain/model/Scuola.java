package domain.model;

import java.util.List;

/**
 *
 */
public class Scuola {

	private List<Classe> classi;
	private List<Docente> docenti;
	
	public Scuola() {

	}
	

	public List<Classe> getClassi() {
		return classi;
	}


	public List<Docente> getDocenti() {
		return docenti;
	}


	public void setClassi( List<Classe> classi){
		this.classi = classi;
	}
	
	public void setDocenti(List<Docente> docenti){
		this.docenti = docenti;
	}
	

}