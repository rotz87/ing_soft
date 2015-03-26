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

public class Appello implements java.lang.Comparable<Appello> {
	public Appello() {
	}
	
	private int ID;
	
	private java.sql.Date _data;
	
	private boolean _assenzePrese;
	
	private void set_data(java.sql.Date value) {
		this._data = value;
	}
	
	private java.sql.Date get_data() {
		return _data;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_assenzePrese(boolean value) {
		this._assenzePrese = value;
	}
	
	private boolean get_assenzePrese() {
		return _assenzePrese;
	}
	
	private domain.implementor.AppelloImp implementor = new domain.implementor.AppelloImp();
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 */
	public Appello(org.joda.time.LocalDate data) {
		this.implementor.inizialize(this, data);
	}
	
	public int compareTo(domain.model.Appello appello) {
		return this.implementor.compareTo(this, appello);
	}
	
	public java.sql.Date getData() {
		return this._data;
	}
	
	public void setData(java.sql.Date data) {
		this._data = data;
	}
	
	public boolean getAssenzePrese() {
		return this._assenzePrese;
	}
	
	public void setAssenzePrese(boolean assenzePrese) {
		this._assenzePrese = assenzePrese;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
