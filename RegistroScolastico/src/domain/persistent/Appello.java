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

public class Appello implements domain.persistent.IPersistentModel {
	public Appello() {
	}
	
	private long idAppello;
	
	private java.util.Date data;
	
	private boolean assenzePrese;
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
	}
	
	private void setIdAppello(long value) {
		this.idAppello = value;
	}
	
	public long getIdAppello() {
		return idAppello;
	}
	
	public long getORMID() {
		return getIdAppello();
	}
	
	public void setAssenzePrese(boolean value) {
		this.assenzePrese = value;
	}
	
	public boolean getAssenzePrese() {
		return assenzePrese;
	}
	
	public String toString() {
		return String.valueOf(getIdAppello());
	}
	
}
