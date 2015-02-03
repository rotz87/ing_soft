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

public class Assenza implements domain.persistent.IPersistentModel {
	public Assenza() {
	}
	
	private int ID;
	
	private domain.persistent.Giustificazione giustificazione;
	
	private java.util.Set appello = new java.util.HashSet();
	
	private java.util.Set appelliAssenza = new java.util.HashSet();
	
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
	
	public void setAppello(java.util.Set value) {
		this.appello = value;
	}
	
	public java.util.Set getAppello() {
		return appello;
	}
	
	
	public void setGiustificazione(domain.persistent.Giustificazione value) {
		this.giustificazione = value;
	}
	
	public domain.persistent.Giustificazione getGiustificazione() {
		return giustificazione;
	}
	
	public void setAppelliAssenza(java.util.Set value) {
		this.appelliAssenza = value;
	}
	
	public java.util.Set getAppelliAssenza() {
		return appelliAssenza;
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
