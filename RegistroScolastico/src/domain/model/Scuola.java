package domain.model;

import java.util.List;
/**
 * @deprecated
 * @author Fabio
 *
 */
public class Scuola {

	private List<Classe> classi;
	private List<Docente> docenti;
	
	public Scuola() {

	}
	
	/**Per le prove
	 * 
	 */
	public void setClassi( List<Classe> classi){
		this.classi = classi;
	}
	
	/**Per le prove
	 * 
	 */
	public void setDocenti(List<Docente> docenti){
		this.docenti = docenti;
	}
	

}