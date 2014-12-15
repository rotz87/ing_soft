package domain;

public class Studente {
	
	private String nome;
	private String cognome;
	private Indirizzo indrizzo;
	private String codiceFiscale;
	
	public Studente(String nome, String cognome){
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
}