package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Argomento;

public class ArgomentoRS extends ResourceSupport{
	private String nome;
	private String descrizione;
	
	public ArgomentoRS(Argomento argomento){
		this.nome = argomento.getNome();
		this.descrizione = argomento.getDescrizione();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	
}
