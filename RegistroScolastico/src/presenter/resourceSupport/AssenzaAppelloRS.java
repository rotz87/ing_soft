package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Assenza;

public class AssenzaAppelloRS extends ResourceSupport {
	
	private int idAssenza;

	public AssenzaAppelloRS(Assenza assenza) {
		setIdAssenza(assenza.getID());
	}

	public int getIdAssenza() {
		return idAssenza;
	}

	public void setIdAssenza(int idAssenza) {
		this.idAssenza = idAssenza;
	}
	
}
