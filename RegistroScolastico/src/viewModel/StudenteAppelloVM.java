package viewModel;

import domain.Studente;

import java.util.Calendar;
import java.util.Date;

public class StudenteAppelloVM {

	private long id;
	private String nome;
	private String cognome;
	private boolean assente;

	public StudenteAppelloVM(Studente studente, boolean assente) {
		
		this.id = studente.getId();
		this.nome = studente.getNome();
		this.cognome = studente.getCognome();
		
		this.assente = assente;
		
	}

	public long getId() {
		return id;
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
