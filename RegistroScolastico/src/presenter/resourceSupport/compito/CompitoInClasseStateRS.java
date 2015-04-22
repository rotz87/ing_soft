package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import service.Stampa;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;

public class CompitoInClasseStateRS extends ResourceSupport{
	
	CompitoInClasseStateEnum state;

	private CompitoInClasseStateRS(){
		
	}
	
	public CompitoInClasseStateRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		
//		Stampa.stampaln("compito: "+compito);
//		Stampa.stampaln("compitogetState(): "+compito.getState());
//		Stampa.stampaln("compitogetState().getStateEnum():  "+compito.getState().getStateEnum());
		
		this.state = compito.getState().getStateEnum();
		
		
		
		//FIXME bisogna inserire come link filgi: Argomenti e studenti e come padre RegistroDocente
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
//					getStudentiAppello(idClasse)).withRel("studenti"));
//		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, idRegistroDocente).
//					getCompitoInClasse(idClasse, idRegistroDocente, this.idCompito)).withSelfRel());
	}

	public CompitoInClasseStateEnum getState() {
		return this.state;
	}

	public void setState(CompitoInClasseStateEnum stateEnum) {
		this.state = stateEnum;
	}
	
	
}
