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
	
	private domain.model.Indirizzo _indirizzo;
	
	private String _nome;
	
	private String _cognome;
	
	private String _codiceFiscale;
	
	private java.sql.Date _dataNascita;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_nome(String value) {
		this._nome = value;
	}
	
	private String get_nome() {
		return _nome;
	}
	
	private void set_cognome(String value) {
		this._cognome = value;
	}
	
	private String get_cognome() {
		return _cognome;
	}
	
	private void set_codiceFiscale(String value) {
		this._codiceFiscale = value;
	}
	
	private String get_codiceFiscale() {
		return _codiceFiscale;
	}
	
	private void set_dataNascita(java.sql.Date value) {
		this._dataNascita = value;
	}
	
	private java.sql.Date get_dataNascita() {
		return _dataNascita;
	}
	
	private void set_indirizzo(domain.model.Indirizzo value) {
		this._indirizzo = value;
	}
	
	private domain.model.Indirizzo get_indirizzo() {
		return _indirizzo;
	}
	
	public String getNome() {
		return this._nome;
	}
	
	public void setNome(String nome) {
		this._nome = nome;
	}
	
	public String getCognome() {
		return this._cognome;
	}
	
	public void setCognome(String cognome) {
		this._cognome = cognome;
	}
	
	public String getCodiceFiscale() {
		return this._codiceFiscale;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this._codiceFiscale = codiceFiscale;
	}
	
	public java.sql.Date getDataNascita() {
		return this._dataNascita;
	}
	
	public void setDataNascita(java.sql.Date dataNascita) {
		this._dataNascita = dataNascita;
	}
	
	public domain.model.Indirizzo getIndirizzo() {
		return this._indirizzo;
	}
	
	public void setIndirizzo(domain.model.Indirizzo indirizzo) {
		this._indirizzo = indirizzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
