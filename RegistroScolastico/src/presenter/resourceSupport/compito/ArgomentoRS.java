package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Argomento;

public class ArgomentoRS extends ResourceSupport{
	
	private int idArgomento;
	private String nome;
	private String descrizione;
	private Long data;
	
	public ArgomentoRS(){
		
	}
	
	public ArgomentoRS(Argomento argomento){
		this.idArgomento = argomento.getID();
		this.nome = argomento.getNome();
		this.descrizione = argomento.getDescrizione();
		if(argomento.getData() != null){
			this.data = argomento.getData().getTime();
		}
	}

	
	public void setIdArgomento(int idArgomento) {
		this.idArgomento = idArgomento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setData(Long data) {
		this.data = data;
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

	public Long getData() {
		return data;
	}


}
