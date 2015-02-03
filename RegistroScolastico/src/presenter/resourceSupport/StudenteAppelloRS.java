package presenter.resourceSupport;


import org.springframework.hateoas.ResourceSupport;

import domain.model.MStudente;


public class StudenteAppelloRS extends ResourceSupport{

	private long idStudente;
	private String nome;
	private String cognome;
	public StudenteAppelloRS(MStudente studente) {
		
		this.idStudente = studente.getId();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		
		//inserire links
		
	}

	public long getIdStudente() {
		return idStudente;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
}
