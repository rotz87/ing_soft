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

public class Calendario implements domain.persistent.IPersistentModel {
	public Calendario() {
	}
	
	private int ID;
	
	private domain.persistent.Calendario instance;
	
	private java.util.Date dataOdierna;
	
	private java.util.Date[] giorniFestivi;
	
	private Integer[] giorniSettimanaliFestivi;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDataOdierna(java.util.Date value) {
		this.dataOdierna = value;
	}
	
	public java.util.Date getDataOdierna() {
		return dataOdierna;
	}
	
	public void setGiorniFestivi(java.util.Date[] value) {
		this.giorniFestivi = value;
	}
	
	public java.util.Date[] getGiorniFestivi() {
		return giorniFestivi;
	}
	
	public void setGiorniSettimanaliFestivi(Integer[] value) {
		this.giorniSettimanaliFestivi = value;
	}
	
	public Integer[] getGiorniSettimanaliFestivi() {
		return giorniSettimanaliFestivi;
	}
	
	public void setInstance(domain.persistent.Calendario value) {
		this.instance = value;
	}
	
	public domain.persistent.Calendario getInstance() {
		return instance;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
