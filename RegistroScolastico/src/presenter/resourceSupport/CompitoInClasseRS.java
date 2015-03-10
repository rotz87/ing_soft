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
	
	private long data;
	
	private long oraInizio;
	
	private long oraFine;
	

	
	public CompitoInClasseRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		this.idCompito = compito.getID();
		this.data = compito.getData().getTime();
		this.oraInizio = compito.getOraInizio().getTime();
		this.oraFine = compito.getOraFine().getTime();

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

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

	public long getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(long oraInizio) {
		this.oraInizio = oraInizio;
	}

	public long getOraFine() {
		return oraFine;
	}

	public void setOraFine(long oraFine) {
		this.oraFine = oraFine;
	}
	
}
