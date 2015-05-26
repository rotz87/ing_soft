package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import presenter.AppelloPresenter;
import presenter.ClassePresenter;
import domain.model.Classe;

public class ClasseMenuRS extends ResourceSupport {
	
	private int idClasse;
	private String nome;
	
	public ClasseMenuRS(){
		
	}
	
	public ClasseMenuRS(Classe classe){
		setIdClasse(classe.getID());
		setNome(classe.getNome());
		
		
		//Links
		
		add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(AppelloPresenter.class, classe.getID()).
			getAppelli(classe.getID())).withRel("appelli"));
		
		add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClassePresenter.class).
			getDateFestive(classe.getID())).withRel("dateFestive"));
		
		add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClassePresenter.class).
			getRegistriDocente(classe.getID())).withRel("registriDocente"));
		
		add(ControllerLinkBuilder.linkTo(
		ControllerLinkBuilder.methodOn(ClassePresenter.class).
			getStudentiAppello(classe.getID())).withRel("studenti"));
		
		
		
	}
	
	
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
