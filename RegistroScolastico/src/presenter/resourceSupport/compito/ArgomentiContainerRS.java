package presenter.resourceSupport.compito;
/**
 * FIXME probabilmente da eliminare
 */
import java.util.Collection;

import org.springframework.hateoas.ResourceSupport;

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
