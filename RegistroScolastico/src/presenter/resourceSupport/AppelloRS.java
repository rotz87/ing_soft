package presenter.resourceSupport;

import java.util.Date;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.AppelloPresenter;
import presenter.ClassePresenter;
import domain.model.Appello;

/**
 * Da completare: come fa l'appello a prendere una lista di studenti?
 * 
 * @author marco
 *
 */
public class AppelloRS extends ResourceSupport{
	
	private int idAppello;
	private Date data;
	private boolean assenzePrese;


	public AppelloRS(Appello appello, int idClasse) {
		
		this.idAppello = appello.getID();
		this.data = appello.getData();
		this.assenzePrese = appello.getAssenzePrese();
//da togliere
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(AppelloController.class, idClasse).
//					getStudenti(idClasse, idAppello)).withRel("studenti"));
		this.add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
			getStudentiAppello(idClasse)).withRel("studenti"));
		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		this.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(AppelloPresenter.class, idClasse).
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
