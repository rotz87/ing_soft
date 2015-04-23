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
	
	private int _giorno;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_giorno(int value) {
		this._giorno = value;
	}
	
	private int get_giorno() {
		return _giorno;
	}
	
	private domain.implementor.GiornoSettimanaleFestivoImp implementor = new domain.implementor.GiornoSettimanaleFestivoImp();
	
	public boolean equals(java.lang.Object obj) {
		return this.implementor.equals(this, obj);
	}
	
	public GiornoSettimanaleFestivo(int giorno) {
		this.implementor.inizialize(this, giorno);
	}
	
	public int getGiorno() {
		return this._giorno;
	}
	
	public void setGiorno(int giorno) {
		//this._giorno = giorno;
		this._giorno = this.implementor.checkGiorno(giorno);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
