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

public abstract class Persona {
	public Persona() {
	}
	
	private int ID;
	
	private domain.model.Indirizzo indirizzo;
	
	private String nome;
	
	private String cognome;
	
	private String codiceFiscale;
	
	private java.sql.Date dataNascita;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
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
	
	public void setDataNascita(java.sql.Date value) {
		this.dataNascita = value;
	}
	
	public java.sql.Date getDataNascita() {
		return dataNascita;
	}
	
	public void setIndirizzo(domain.model.Indirizzo value) {
		this.indirizzo = value;
	}
	
	public domain.model.Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
