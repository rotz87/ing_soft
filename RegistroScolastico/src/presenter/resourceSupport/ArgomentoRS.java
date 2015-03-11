package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Argomento;

public class ArgomentoRS extends ResourceSupport{
	
	private int idArgomento;
	private String nome;
	private String descrizione;
	
	public ArgomentoRS(){
		
	}
	
	public ArgomentoRS(Argomento argomento){
		this.idArgomento = argomento.getID();
		this.nome = argomento.getNome();
		this.descrizione = argomento.getDescrizione();
	}
	
	public ArgomentoRS(int idArgomento, String nome, String descrizione) {
		super();
		this.idArgomento = idArgomento;
		this.nome = nome;
		this.descrizione = descrizione;
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
