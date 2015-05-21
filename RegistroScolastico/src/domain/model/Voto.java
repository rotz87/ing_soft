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

public class Voto implements java.lang.Comparable<Voto> {
	public Voto() {
	}
	
	private int ID;
	
	private Float _valore;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_valore(Float value) {
		this._valore = value;
	}
	
	private Float get_valore() {
		return _valore;
	}
	
	private domain.implementor.VotoImp implementor = new domain.implementor.VotoImp();
	
	/**
	 *  
	 */
	public static final Float MIN_VAL = 0f;
	
	public static final Float MAX_VAL = 10.2f;
	
	public Float getValore() {
		return this._valore;
	}
	
	public void setValore(Float valore) {
		valore = this.implementor.normalizzaValore(valore);
		this._valore = valore;
	}
	
	public int compareTo(domain.model.Voto voto) {
		return this.implementor.compareTo(this, voto);
	}
	
	public Voto(Float valore) {
		this.implementor.inizialize(this, valore);
	}
	
	public void setVoto(domain.model.Voto voto) {
		this.implementor.setVoto(this, voto);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
