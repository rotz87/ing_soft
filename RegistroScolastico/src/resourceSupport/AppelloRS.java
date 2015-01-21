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

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import controllerSpring.AppelloController;
import controllerSpring.ClasseController;

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


	public AppelloRS(Appello appello, long idClasse) {
		
		this.idAppello = appello.getIdAppello();
		this.data = appello.getData().toDate();
		this.assenzePrese = appello.isAssenzePrese();
//da togliere
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(AppelloController.class, idClasse).
//					getStudenti(idClasse, idAppello)).withRel("studenti"));
		this.add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClasseController.class, idClasse).
			getStudenti(idClasse)).withRel("studenti"));
		this.add(ControllerLinkBuilder.linkTo(AppelloController.class, idClasse).withRel(Link.REL_PREVIOUS));
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


	public boolean isAssenzePrese() {
		return assenzePrese;
	}


	public void setAssenzePrese(boolean assenzePrese) {
		this.assenzePrese = assenzePrese;
	}
	
	
}
