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

public class RegistroAssenze implements domain.persistent.IPersistentModel {
	public RegistroAssenze() {
	}
	
	private int ID;
	
	private domain.persistent.Appello appelloOdierno;
	
	private java.util.Set librettiAssenze = new java.util.HashSet();
	
	private java.util.Set appelli = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setAppelloOdierno(domain.persistent.Appello value) {
		this.appelloOdierno = value;
	}
	
	public domain.persistent.Appello getAppelloOdierno() {
		return appelloOdierno;
	}
	
	public void setLibrettiAssenze(java.util.Set value) {
		this.librettiAssenze = value;
	}
	
	public java.util.Set getLibrettiAssenze() {
		return librettiAssenze;
	}
	
	
	public void setAppelli(java.util.Set value) {
		this.appelli = value;
	}
	
	public java.util.Set getAppelli() {
		return appelli;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
