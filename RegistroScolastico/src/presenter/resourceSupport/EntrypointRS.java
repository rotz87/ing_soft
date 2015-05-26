package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.CalendarioPresenter;
import presenter.ClassePresenter;
import presenter.VotiPresenter;

public class EntrypointRS extends ResourceSupport {
	
	public EntrypointRS(){
		
		this.add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(CalendarioPresenter.class).
		getDatesInfo()).withRel("calendario"));
		
		this.add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClassePresenter.class).
		getClassi()).withRel("classi"));
		
		
		this.add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(VotiPresenter.class).
		getContent()).withRel("voti"));
		
		
	}

}
