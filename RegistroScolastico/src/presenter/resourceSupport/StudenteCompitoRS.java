package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Studente;
import domain.model.Voto;

public class StudenteCompitoRS extends ResourceSupport {
	private int idStudente;
	private String nome;
	private String cognome;
	private String voto;
	
	public StudenteCompitoRS(Studente studente, Voto voto){
		this.idStudente = studente.getID();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		this.voto = this.voto.toString();
	}

	public long getIdStudente() {
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

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	
}
