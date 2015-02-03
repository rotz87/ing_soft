package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.MAssenza;

public class AssenzaAppelloRS extends ResourceSupport {
	
	private long idAssenza;

	public AssenzaAppelloRS(MAssenza assenza) {
		setIdAssenza(/*assenza.getId()*/0L);
	}

	public long getIdAssenza() {
		return idAssenza;
	}

	public void setIdAssenza(long idAssenza) {
		this.idAssenza = idAssenza;
	}
	
}
