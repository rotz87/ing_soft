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

public class GiornoFestivo {
	public GiornoFestivo() {
	}
	
	private int ID;
	
	private java.util.Date data;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		java.util.Date data;
		data = new java.util.Date(this.data.getTime());
		return data;
	}
	
	private domain.implementor.GiornoFestivoImp implementor = new domain.implementor.GiornoFestivoImp();
	
	public boolean equals(java.lang.Object obj) {
		return this.implementor.equals(this, obj);
	}
	
	public GiornoFestivo(java.util.Date data) {
		this.implementor.inizialize(this, data);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
