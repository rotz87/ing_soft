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

public class LibrettoAssenze implements domain.persistent.IPersistentModel {
	public LibrettoAssenze() {
	}
	
	private int ID;
	
	private domain.persistent.Studente studente;
	
	private java.util.Set giustificate = new java.util.HashSet();
	
	private java.util.Set nonGiustificate = new java.util.HashSet();
	
	private java.util.Set ritardi = new java.util.HashSet();
	
	private java.util.Set uscite = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setGiustificate(java.util.Set value) {
		this.giustificate = value;
	}
	
	public java.util.Set getGiustificate() {
		return giustificate;
	}
	
	
	public void setNonGiustificate(java.util.Set value) {
		this.nonGiustificate = value;
	}
	
	public java.util.Set getNonGiustificate() {
		return nonGiustificate;
	}
	
	
	public void setStudente(domain.persistent.Studente value) {
		this.studente = value;
	}
	
	public domain.persistent.Studente getStudente() {
		return studente;
	}
	
	public void setRitardi(java.util.Set value) {
		this.ritardi = value;
	}
	
	public java.util.Set getRitardi() {
		return ritardi;
	}
	
	
	public void setUscite(java.util.Set value) {
		this.uscite = value;
	}
	
	public java.util.Set getUscite() {
		return uscite;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
