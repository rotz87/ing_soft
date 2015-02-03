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

/**
 * @deprecated
 * @author Fabio
 */
public class Scuola implements domain.persistent.IPersistentModel {
	public Scuola() {
	}
	
	private int ID;
	
	private java.util.Set classi = new java.util.HashSet();
	
	private java.util.Set docenti = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setClassi(java.util.Set value) {
		this.classi = value;
	}
	
	public java.util.Set getClassi() {
		return classi;
	}
	
	
	public void setDocenti(java.util.Set value) {
		this.docenti = value;
	}
	
	public java.util.Set getDocenti() {
		return docenti;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
