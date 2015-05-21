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

public class Giustificazione {
	public Giustificazione() {
	}
	
	private int ID;
	
	private boolean _confermata;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_confermata(boolean value) {
		this._confermata = value;
	}
	
	private boolean get_confermata() {
		return _confermata;
	}
	
	public boolean getConfermata() {
		return this._confermata;
	}
	
	public void setConfermata(boolean confermata) {
		this._confermata = confermata;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
