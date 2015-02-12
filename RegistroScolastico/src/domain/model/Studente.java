/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model;

public class Studente {
	public Studente() {
	}
	
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private String codiceFiscale;
	
	private Integer indrizzo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setIndrizzo(int value) {
		setIndrizzo(new Integer(value));
	}
	
	public void setIndrizzo(Integer value) {
		this.indrizzo = value;
	}
	
	public Integer getIndrizzo() {
		return indrizzo;
	}
	
	private domain.implementor.StudenteImp implementor = new domain.implementor.StudenteImp();
	
	public Studente(String nome, String cognome) {
		this.implementor.inizialize(this, nome, cognome);
	}
	
	public Studente(long id, String nome, String cognome, domain.model.Indirizzo indrizzo, String codiceFiscale) {
		this.implementor.inizialize(this, nome, cognome, indrizzo, codiceFiscale);
	}
	
	public void setId(long id) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setIndrizzo(domain.model.Indirizzo indrizzo) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
