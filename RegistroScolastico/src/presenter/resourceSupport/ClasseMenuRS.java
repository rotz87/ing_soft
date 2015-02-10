package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Classe;

public class ClasseMenuRS extends ResourceSupport {
	
	private long idClasse;
	private String nome;
	
	
	public ClasseMenuRS(Classe classe){
		setIdClasse(classe.getIdClasse());
		setNome(classe.getNome());
	}
	
	
	public long getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(long idClasse) {
		this.idClasse = idClasse;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
