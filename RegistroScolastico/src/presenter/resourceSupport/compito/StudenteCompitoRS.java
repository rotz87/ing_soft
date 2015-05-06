package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import presenter.resourceSupport.StudenteRS;
import presenter.resourceSupport.voto.VotoRS;
import domain.error.DomainCheckedException;
import domain.model.Studente;
import domain.model.Voto;

public class StudenteCompitoRS extends StudenteRS {

	private VotoRS voto;
	private boolean assente;
	
	public StudenteCompitoRS(){
		super();
	}
	
	public StudenteCompitoRS(Studente studente, Voto voto, boolean assente) throws DomainCheckedException{
		super(studente);
		this.assente = assente;
		this.voto = null;
//		if(voto!=null){
			this.voto = new VotoRS(voto);
//		}
		
		// XXX INSERIRE I LINKS
	}

	public VotoRS getVoto() {
		return voto;
	}

	public void setVoto(VotoRS voto) {
		this.voto = voto;
	}

	public boolean getAssente() {
		return assente;
	}

	public void setAssente(boolean assente) {
		this.assente = assente;
	}
	
	
}
