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

public class Indirizzo {
	public Indirizzo() {
	}
	
	private int ID;
	
	private String _via;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_via(String value) {
		this._via = value;
	}
	
	private String get_via() {
		return _via;
	}
	
	public String getVia() {
		return this._via;
	}
	
	public void setVia(String via) {
		this._via = via;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
