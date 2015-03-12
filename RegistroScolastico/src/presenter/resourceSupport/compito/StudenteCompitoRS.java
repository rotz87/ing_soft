package presenter.resourceSupport.compito;

import org.springframework.hateoas.ResourceSupport;

import domain.model.Studente;
import domain.model.Voto;

public class StudenteCompitoRS extends ResourceSupport {
	private int idStudente;
	private String nome;
	private String cognome;
	private byte voto;
	private boolean assente;
	
	public StudenteCompitoRS(Studente studente, Voto voto, boolean assente){
		this.idStudente = studente.getID();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		this.voto = voto.getVoto();
		this.assente = assente;
	}
	
	public StudenteCompitoRS(int idStudente, byte voto){
		this.idStudente = idStudente;
		this.nome = null;
		this.cognome = null;
		this.voto = voto;
		this.assente = false;
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

	public byte getVoto() {
		return voto;
	}

	public void setVoto(byte voto) {
		this.voto = voto;
	}

	public boolean getAssente() {
		return assente;
	}

	public void setAssente(boolean assente) {
		this.assente = assente;
	}
	
	
}
