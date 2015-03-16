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
	
	private java.util.Set<domain.model.LibrettoVotiLineItem> libVotiLineItems = new java.util.LinkedHashSet<domain.model.LibrettoVotiLineItem>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLibVotiLineItems(java.util.Set<domain.model.LibrettoVotiLineItem> value) {
		this.libVotiLineItems = value;
	}
	
	public java.util.Set<domain.model.LibrettoVotiLineItem> getLibVotiLineItems() {
		return libVotiLineItems;
	}
	
	
	private domain.implementor.LibrettoVotiImp implementor = new domain.implementor.LibrettoVotiImp();
	
	public void makeLineItem(domain.model.CompitoInClasse compito) {
		this.implementor.makeLineItem(this, compito);
	}
	
	public domain.model.LibrettoVotiLineItem getLibrettoLineItem(domain.model.CompitoInClasse compito) {
		return this.implementor.getLibrettoVotiLineItem(this, compito);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
