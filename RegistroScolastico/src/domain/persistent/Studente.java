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
package domain.persistent;

public class Studente implements domain.persistent.IPersistentModel {
	public Studente() {
	}
	
	private long id;
	
	private domain.persistent.Indirizzo indrizzo;
	
	private String nome;
	
	private String cognome;
	
	private String codiceFiscale;
	
	private void setId(long value) {
		this.id = value;
	}
	
	public long getId() {
		return id;
	}
	
	public long getORMID() {
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
	
	public void setIndrizzo(domain.persistent.Indirizzo value) {
		this.indrizzo = value;
	}
	
	public domain.persistent.Indirizzo getIndrizzo() {
		return indrizzo;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
