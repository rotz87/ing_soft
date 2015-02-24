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

public class Appello {
	public Appello() {
	}
	
	private int ID;
	
	private java.util.Date data;
	
	private boolean assenzePrese;
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
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
	
	public void setAssenzePrese(boolean value) {
		this.assenzePrese = value;
	}
	
	public boolean getAssenzePrese() {
		return assenzePrese;
	}
	
	private domain.implementor.AppelloImp implementor = new domain.implementor.AppelloImp();
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 */
	public Appello(org.joda.time.LocalDate data) {
		this.implementor.inizialize(this, data);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
