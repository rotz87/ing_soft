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

public class LibrettoVoti {
	public LibrettoVoti() {
	}
	
	private int ID;
	
	private domain.model.LibrettoVotiLineItem libVotiLineItems;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLibVotiLineItems(domain.model.LibrettoVotiLineItem value) {
		this.libVotiLineItems = value;
	}
	
	public domain.model.LibrettoVotiLineItem getLibVotiLineItems() {
		return libVotiLineItems;
	}
	
	public void makeLineItem(domain.model.CompitoInClasse compito) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public domain.model.LibrettoVotiLineItem getLibrettoLineItem(domain.model.CompitoInClasse compito) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
