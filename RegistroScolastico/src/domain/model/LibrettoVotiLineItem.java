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

public class LibrettoVotiLineItem {
	public LibrettoVotiLineItem() {
	}
	
	private int ID;
	
	private domain.model.Voto voto;
	
	private domain.model.CompitoInClasse compitoInClasse;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCompitoInClasse(domain.model.CompitoInClasse value) {
		this.compitoInClasse = value;
	}
	
	public domain.model.CompitoInClasse getCompitoInClasse() {
		return compitoInClasse;
	}
	
	public void setVoto(domain.model.Voto value) {
		this.voto = value;
	}
	
	public domain.model.Voto getVoto() {
		return voto;
	}
	
	public void aggiungiVoto(domain.model.Voto voto) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
