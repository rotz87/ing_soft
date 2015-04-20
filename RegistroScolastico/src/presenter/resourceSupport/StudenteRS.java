package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Studente;

public abstract class StudenteRS extends ResourceSupport {
	
	private int idStudente;
	private String nome;
	private String cognome;
	
	public StudenteRS(){
		
	}
	
	public StudenteRS(Studente studente){

		this.idStudente = studente.getID();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		
	}

	public int getIdStudente() {
		return idStudente;
	}

	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	

}
