package presenter.resourceSupport;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.AppelloPresenter;
import presenter.CompitoInClassePresenter;
import presenter.RegistroDocentePresenter;
import domain.model.RegistroDocente;

public class RegistroDocenteRS extends ResourceSupport {
	private Integer idRegistroDocente;
	private String materia;
	
	public RegistroDocenteRS(){
		
	}
	
	public RegistroDocenteRS(RegistroDocente registroDocente, int idClasse){
			setIdRegistroDocente(registroDocente.getID());
			setMateria(registroDocente.getMateria().getNome());
			
			//links
			
			add(ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(RegistroDocentePresenter.class, idClasse, registroDocente.getID()).
						getArgomentiSvolti(idClasse, registroDocente.getID())).withRel("argomentiSvolti"));

			add(ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(RegistroDocentePresenter.class, idClasse, registroDocente.getID()).
						getMedie(idRegistroDocente, 1417388400000L, 1434060000000L, "MediaScartaPeggioreStrategy")).withRel("medie"));
			
			
			add(ControllerLinkBuilder.linkTo(
					ControllerLinkBuilder.methodOn(CompitoInClassePresenter.class, idClasse, registroDocente.getID()).
					getCompitiInClasse(idClasse, registroDocente.getID())).withRel("compitiInClasse"));
			
		}
	
	public Integer getIdRegistroDocente() {
		return idRegistroDocente;
	}
	
	public void setIdRegistroDocente(Integer idRegistroDocente) {
		this.idRegistroDocente = idRegistroDocente;
	}
	
	public String getMateria() {
		return materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}


}
