package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import presenter.resourceSupport.StudenteRS;
import domain.model.Studente;
import domain.model.Voto;

public class StudenteCompitoRS extends StudenteRS {

	private Byte voto;
	private boolean assente;
	
	public StudenteCompitoRS(){
		super();
	}
	
	public StudenteCompitoRS(Studente studente, Voto voto, boolean assente){
		super(studente);
		this.assente = assente;
		this.voto = null;
		if(voto!=null){
			this.voto = voto.getVoto();
		}
		
		// XXX INSERIRE I LINKS
	}

	public Byte getVoto() {
		return voto;
	}

	public void setVoto(Byte voto) {
		this.voto = voto;
	}

	public boolean getAssente() {
		return assente;
	}

	public void setAssente(boolean assente) {
		this.assente = assente;
	}
	
	
}
