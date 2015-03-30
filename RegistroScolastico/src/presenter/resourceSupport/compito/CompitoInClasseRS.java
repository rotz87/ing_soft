package presenter.resourceSupport.compito;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.AppelloPresenter;
import presenter.ClassePresenter;
import presenter.CompitoInClassePresenter;
import service.Stampa;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;

public class CompitoInClasseRS extends ResourceSupport{
	
	private int idCompito;
	
	private Long data = null;
	
	private Long oraInizio = null;
	
	private Long oraFine = null;
	
	private Collection<ArgomentoRS> argomentiRS = new LinkedList<ArgomentoRS>();

	private CompitoInClasseRS(){
		
	}
	
	public CompitoInClasseRS(CompitoInClasse compito, int idClasse, int idRegistroDocente){
		this.idCompito = compito.getID();
		if(compito.getData() != null){
			this.data = compito.getData().getTime();
		}
		if(compito.getOraInizio() != null){
			this.oraInizio = compito.getOraInizio().getTime();
		}
		if(compito.getOraFine() != null){
			this.oraFine = compito.getOraFine().getTime();
		}
		for(Argomento argomento : compito.getArgomentiEsaminati()){
			this.argomentiRS.add(new ArgomentoRS(argomento));
		}
		
		//TODO bisogna inserire come link filgi: Argomenti e studenti e come padre RegistroDocente
		
//		this.add(ControllerLinkBuilder.linkTo(
//				ControllerLinkBuilder.methodOn(ClassePresenter.class, idClasse).
//					getStudentiAppello(idClasse)).withRel("studenti"));
//		this.add(ControllerLinkBuilder.linkTo(AppelloPresenter.class, idClasse).withRel(Link.REL_PREVIOUS));
		this.add(ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, idRegistroDocente).
					getCompitoInClasse(idClasse, idRegistroDocente, this.idCompito)).withSelfRel());
	}
	
	

	public CompitoInClasseRS(int idCompito, Long data, Long oraInizio, Long oraFine, Collection<ArgomentoRS> argomentiRS) {
		this.idCompito = idCompito;
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.argomentiRS = argomentiRS;
		
		//TODO inserire i links
	}

	public int getIdCompito() {
		return idCompito;
	}

	public void setIdCompito(int idCompito) {
		this.idCompito = idCompito;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public Long getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(Long oraInizio) {
		this.oraInizio = oraInizio;
	}

	public Long getOraFine() {
		return oraFine;
	}

	public void setOraFine(Long oraFine) {
		this.oraFine = oraFine;
	}

	public Collection<ArgomentoRS> getArgomentiRS() {
		return argomentiRS;
	}
	
}
