package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;

public class CompitoInClasseStateRS extends ResourceSupport{
	
	CompitoInClasseStateEnum state;

	private CompitoInClasseStateRS(){
		
	}
	
	public CompitoInClasseStateRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		
		this.state = compito.getState().getStateEnum();
		
		//TODO bisogna inserire come link filgi: Argomenti e studenti e come padre RegistroDocente
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
//					getStudentiAppello(idClasse)).withRel("studenti"));
//		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		
		//TODO
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, idRegistroDocente).
//					getCompitoInClasse(idClasse, idRegistroDocente, this.idCompito)).withSelfRel());
	}

	public CompitoInClasseStateEnum getStateEnum() {
		return this.state;
	}

	public void setStateEnum(CompitoInClasseStateEnum stateEnum) {
		this.state = stateEnum;
	}
	
	
}
