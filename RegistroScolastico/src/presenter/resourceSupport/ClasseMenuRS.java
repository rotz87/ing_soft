package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Classe;

public class ClasseMenuRS extends ResourceSupport {
	
	private int idClasse;
	private String nome;
	
	public ClasseMenuRS(){
		
	}
	
	public ClasseMenuRS(Classe classe){
		setIdClasse(classe.getID());
		setNome(classe.getNome());
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
