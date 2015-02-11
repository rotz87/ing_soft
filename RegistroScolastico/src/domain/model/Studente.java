package domain.model;

import domain.implementor.StudenteImp;

public class Studente {
	
	private long id;
	private String nome;
	private String cognome;
	private Indirizzo indrizzo;
	private String codiceFiscale;
	private StudenteImp implementor;
	
	public Studente(String nome, String cognome){
		this.implementor = new StudenteImp();
		implementor.inizialize(this, nome, cognome);
	}
	
	
	
	public Studente(long id, String nome, String cognome, Indirizzo indrizzo, String codiceFiscale) {
		this.implementor = new StudenteImp();
		implementor.inizialize(this, nome, cognome, indrizzo, codiceFiscale);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Indirizzo getIndrizzo() {
		return indrizzo;
	}

	public void setIndrizzo(Indirizzo indrizzo) {
		this.indrizzo = indrizzo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}