package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Argomento;

public class ArgomentoRS extends ResourceSupport{
	
	int idArgomento;
	private String nome;
	private String descrizione;
	
	public ArgomentoRS(Argomento argomento){
		this.idArgomento = argomento.getID();
		this.nome = argomento.getNome();
		this.descrizione = argomento.getDescrizione();
	}
	

	public int getIdArgomento() {
		return idArgomento;
	}


	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
}
