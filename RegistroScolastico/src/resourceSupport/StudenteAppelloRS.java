package resourceSupport;


import domain.Studente;

import org.springframework.hateoas.ResourceSupport;


public class StudenteAppelloRS extends ResourceSupport{

	private long idStudente;
	private String nome;
	private String cognome;
	private boolean assente;

	
	public StudenteAppelloRS(Studente studente, boolean assente) {
		
		this.idStudente = studente.getId();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		
		this.assente = assente;
		
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

	public boolean isAssente() {
		return assente;
	}
	
}
