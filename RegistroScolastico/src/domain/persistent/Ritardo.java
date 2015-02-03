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

public class Ritardo implements domain.persistent.IPersistentModel {
	public Ritardo() {
	}
	
	private int ID;
	
	private domain.persistent.PermessoEntrata permessoEntrata;
	
	private domain.persistent.PermessoEntrata permesso;
	
	private domain.persistent.Appello appello;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setAppello(domain.persistent.Appello value) {
		this.appello = value;
	}
	
	public domain.persistent.Appello getAppello() {
		return appello;
	}
	
	public void setPermesso(domain.persistent.PermessoEntrata value) {
		this.permesso = value;
	}
	
	public domain.persistent.PermessoEntrata getPermesso() {
		return permesso;
	}
	
	public void setPermessoEntrata(domain.persistent.PermessoEntrata value) {
		this.permessoEntrata = value;
	}
	
	public domain.persistent.PermessoEntrata getPermessoEntrata() {
		return permessoEntrata;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
