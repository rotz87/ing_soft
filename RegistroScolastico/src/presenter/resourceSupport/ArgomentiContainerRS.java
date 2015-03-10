package presenter.resourceSupport;

import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Argomento;

public class ArgomentiContainerRS extends ResourceSupport{
	private Collection<ArgomentoRS> argomenti;
	
	public ArgomentiContainerRS(Collection<ArgomentoRS> argomenti){
		setArgomenti(argomenti);
	}

	public Collection<ArgomentoRS> getArgomenti() {
		return argomenti;
	}

	public void setArgomenti(Collection<ArgomentoRS> argomenti) {
		this.argomenti = argomenti;
	}
	
	
}
