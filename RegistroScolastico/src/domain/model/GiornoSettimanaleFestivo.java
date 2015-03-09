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

public class GiornoSettimanaleFestivo {
	public GiornoSettimanaleFestivo() {
	}
	
	private int ID;
	
	private int giorno;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setGiorno(int value) {
		this.giorno = value;
		this.giorno = this.implementor.checkGiorno(value);
	}
	
	public int getGiorno() {
		return giorno;
	}
	
	private domain.implementor.GiornoSettimanaleFestivoImp implementor = new domain.implementor.GiornoSettimanaleFestivoImp();
	
	public boolean equals(java.lang.Object obj) {
		return this.implementor.equals(this, obj);
	}
	
	public GiornoSettimanaleFestivo(int giorno) {
		this.implementor.inizialize(this, giorno);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
