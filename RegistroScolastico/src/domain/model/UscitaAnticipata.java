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
	
	private domain.model.Appello _appello;
	
	private domain.model.PermessoUscita _permesso;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_permesso(domain.model.PermessoUscita value) {
		this._permesso = value;
	}
	
	private domain.model.PermessoUscita get_permesso() {
		return _permesso;
	}
	
	private void set_appello(domain.model.Appello value) {
		this._appello = value;
	}
	
	private domain.model.Appello get_appello() {
		return _appello;
	}
	
	public domain.model.Appello getAppello() {
		return this._appello;
	}
	
	public void setAppello(domain.model.Appello appello) {
		this._appello = appello;
	}
	
	public domain.model.PermessoUscita getPermesso() {
		return this._permesso;
	}
	
	public void setPermesso(domain.model.PermessoUscita permesso) {
		this._permesso = permesso;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
