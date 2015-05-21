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
	
	private java.util.Set<domain.model.LibrettoVotiLineItem> _libVotiLineItems = new java.util.LinkedHashSet<domain.model.LibrettoVotiLineItem>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_libVotiLineItems(java.util.Set<domain.model.LibrettoVotiLineItem> value) {
		this._libVotiLineItems = value;
	}
	
	private java.util.Set<domain.model.LibrettoVotiLineItem> get_libVotiLineItems() {
		return _libVotiLineItems;
	}
	
	
	private domain.implementor.LibrettoVotiImp implementor = new domain.implementor.LibrettoVotiImp();
	
	public void makeLineItem(domain.model.compitoInClasse.CompitoInClasse compito) {
		this.implementor.makeLineItem(this, compito);
	}
	
	public domain.model.LibrettoVotiLineItem getLibrettoLineItem(domain.model.compitoInClasse.CompitoInClasse compito) {
		return this.implementor.getLibrettoVotiLineItem(this, compito);
	}
	
	public java.util.Set<LibrettoVotiLineItem> getLibVotiLineItems() {
		return this._libVotiLineItems;
	}
	
	public boolean esisteLineItem(domain.model.compitoInClasse.CompitoInClasse compito) {
		return this.implementor.esisteLineItem(this, compito);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
