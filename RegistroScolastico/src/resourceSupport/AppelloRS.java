package resourceSupport;

import domain.Appello;

import java.util.Date;
import java.util.HashMap;
import org.springframework.hateoas.ResourceSupport;

/**
 * Da completare: come fa l'appello a prendere una lista di studenti?
 * 
 * @author marco
 *
 */
public class AppelloRS extends ResourceSupport{
	
	private long idAppello;
	private Date data;
	private MapStudenti studenti;
	
	
	public AppelloRS(Appello appello) {
		this.idAppello = 0L;
		this.data = null;
		this.studenti = new MapStudenti();
	}
	
	
	public long getIdAppello() {
		return idAppello;
	}
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	public void addStudente(StudenteAppelloRS studente){
		studenti.put(Long.valueOf(studente.getIdStudente()), studente);
	}
	
	public StudenteAppelloRS getStudente(long id) {
		return studenti.get(id);
	}
	
	public void removeStudente(long id){
		studenti.remove(id);
	}
		
	
	private class MapStudenti extends HashMap<Long,StudenteAppelloRS>{}
	
}
