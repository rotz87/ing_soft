package presenter.resourceSupport;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.AppelloPresenter;
import presenter.ClassePresenter;
import presenter.CompitoInClassePresenter;
import domain.model.CompitoInClasse;

public class CompitoInClasseRS extends ResourceSupport{
	
	private int idCompito;
	
	private java.util.Date data;
	
	private java.sql.Time oraInizio;
	
	private java.sql.Time oraFine;
	

	
	public CompitoInClasseRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		this.idCompito = compito.getID();
		this.data = compito.getData();
		this.oraInizio = compito.getOraInizio();
		this.oraFine = compito.getOraFine();

		//TODO bisogna inserire come link filgi: Argomenti e studenti e come padre RegistroDocente
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
//					getStudentiAppello(idClasse)).withRel("studenti"));
//		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		this.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, idRegistroDocente).
					getCompitoInClasse(idClasse, idRegistroDocente, this.idCompito)).withSelfRel());
	}

	public int getIdCompito() {
		return idCompito;
	}

	public void setIdCompito(int idCompito) {
		this.idCompito = idCompito;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public java.sql.Time getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(java.sql.Time oraInizio) {
		this.oraInizio = oraInizio;
	}

	public java.sql.Time getOraFine() {
		return oraFine;
	}

	public void setOraFine(java.sql.Time oraFine) {
		this.oraFine = oraFine;
	}
	
}
