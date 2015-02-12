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

public class UscitaAnticipata {
	public UscitaAnticipata() {
	}
	
	private int ID;
	
	private domain.model.Appello appello;
	
	private domain.model.PermessoUscita permesso;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setPermesso(domain.model.PermessoUscita value) {
		this.permesso = value;
	}
	
	public domain.model.PermessoUscita getPermesso() {
		return permesso;
	}
	
	public void setAppello(domain.model.Appello value) {
		this.appello = value;
	}
	
	public domain.model.Appello getAppello() {
		return appello;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
