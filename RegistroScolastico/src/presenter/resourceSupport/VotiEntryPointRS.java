package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.VotiPresenter;

public class VotiEntryPointRS extends ResourceSupport {

	public VotiEntryPointRS() {
		
		add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(VotiPresenter.class).
				getFormatoVoti()).withRel("formatoVoti"));
		
		add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(VotiPresenter.class).
				getVotiConverterSubclasses()).withRel("votiConverters"));
		
	}

}
