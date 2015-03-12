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

public class Voto {
	public Voto() {
	}
	
	private int ID;
	
	private byte voto;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setVoto(byte value) {
		this.voto = value;
	}
	
	public byte getVoto() {
		return voto;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
