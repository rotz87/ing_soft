package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import sviluppo.Stampa;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateFactory;

public class CompitoInClasseStateRS extends ResourceSupport{
	
	String state;

	private CompitoInClasseStateRS(){
		
	}
	
	public CompitoInClasseStateRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		
		this.state = CompitoInClasseStateFactory.getInstance().create(compito.getState());
		
		
		
		//FIXME bisogna inserire come link filgi: Argomenti e studenti e come padre RegistroDocente
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
//					getStudentiAppello(idClasse)).withRel("studenti"));
//		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, idRegistroDocente).
//					getCompitoInClasse(idClasse, idRegistroDocente, this.idCompito)).withSelfRel());
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
	
}
