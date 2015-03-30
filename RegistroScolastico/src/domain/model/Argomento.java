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

public class Argomento {
	public Argomento() {
	}
	
	private int ID;
	
	private String _nome;
	
	private String _descrizione;
	
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
	
	private void set_descrizione(String value) {
		this._descrizione = value;
	}
	
	private String get_descrizione() {
		return _descrizione;
	}
	
	private domain.implementor.ArgomentoImp implementor = new domain.implementor.ArgomentoImp();
	
	public Argomento(String nome, String descrizione) {
		this.implementor.inizialize(this, nome, descrizione);
	}
	
	public String getNome() {
		return this._nome;
	}
	
	public void setNome(String nome) {
		this._nome = nome;
	}
	
	public String getDescrizione() {
		return this._descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this._descrizione = descrizione;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
