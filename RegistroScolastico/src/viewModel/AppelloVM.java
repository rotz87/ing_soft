package viewModel;

import domain.Studente;

import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author marco
 *
 */
public class AppelloVM {
	
	Collection<StudenteAppelloVM> studenti;

	public AppelloVM() {} //for json
	
	public AppelloVM(Collection<Studente> studenti) {
		this.studenti = new LinkedList<StudenteAppelloVM>();
		setStudenti(studenti);
	}

	public Collection<StudenteAppelloVM> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(Collection<StudenteAppelloVM> studenti){
		this.studenti.clear();
		this.studenti = studenti;
		
	}
	
	/**
	 * 
	 * 
	 * @param studenti
	 */
	protected void setStudenti(Collection<Studente> studenti){
		this.studenti.clear();
		
		for (Studente studente : studenti) {
			this.studenti.add(new StudenteAppelloVM(studente, false));
		}
	}
}
