package resourceSupport;

import domain.Appello;

import java.util.Date;
import java.util.HashMap;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import controllerSpring.AppelloController;

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
	
	
	public AppelloRS(Appello appello, long idClasse) {
		this.idAppello = appello.getIdAppello();
		this.data = null;
		this.studenti = new MapStudenti();
		
		this.add(ControllerLinkBuilder.linkTo(AppelloController.class, idClasse).withRel("appelli"));
		this.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(AppelloController.class, idClasse).
					getAppello(this.idAppello, idClasse)).withSelfRel());
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
