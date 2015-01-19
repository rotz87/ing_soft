package resourceSupport;

import domain.Appello;
import domain.Assenza;
import domain.Studente;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

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
	private boolean assenzePrese;
	private LinkedList<StudenteAppelloRS> studenti;
	private LinkedList<AssenzaAppelloRS> assenze;


	public AppelloRS(Appello appello, long idClasse, Collection<Studente> studenti, Map<Long, Assenza> assenze) {
		
		this.idAppello = appello.getIdAppello();
		this.data = appello.getData().toDate();
		this.assenzePrese = appello.isAssenzePrese();
		
		this.studenti = new LinkedList<StudenteAppelloRS>();
		setStudenti(studenti);
		
		this.assenze = new LinkedList<AssenzaAppelloRS>();
		setAssenze(assenze);
		
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

	
	public Collection<StudenteAppelloRS> getStudenti() {
		
		return this.studenti;
		
	}


	public void setStudenti(Collection<Studente> studenti) {
		
		this.studenti.clear();
		for (Studente studente : studenti) {
			this.studenti.add(new StudenteAppelloRS(studente));
		}
		
	}


	public LinkedList<AssenzaAppelloRS> getAssenze() {
		return assenze;
	}


	public void setAssenze(Map<Long, Assenza> assenze) {
		Assenza assenza;
		
		this.assenze.clear();
		for (StudenteAppelloRS studente : this.studenti) {
			assenza = assenze.get(studente.getIdStudente());
			if (assenza != null){
				this.assenze.add(new AssenzaAppelloRS(assenza));
			}else{
				this.assenze.add(null);
			}
			
		}
	}


	public boolean isAssenzePrese() {
		return assenzePrese;
	}


	public void setAssenzePrese(boolean assenzePrese) {
		this.assenzePrese = assenzePrese;
	}
	
	
}
