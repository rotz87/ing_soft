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

public class Calendario {
	public Calendario() {
	}
	
	private int ID;
	
	private java.util.Set<domain.model.Giorno> giorniFestivi = new java.util.HashSet<domain.model.Giorno>();
	
	private java.util.List<domain.model.GiornoSettimanale> giorniSettimanaliFestivi = new java.util.LinkedList<domain.model.GiornoSettimanale>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	/**
	 * private LocalDate dataOdierna;
	 */
	public void setGiorniFestivi(java.util.Set<domain.model.Giorno> value) {
		this.giorniFestivi = value;
	}
	
	/**
	 * private LocalDate dataOdierna;
	 */
	public java.util.Set<domain.model.Giorno> getGiorniFestivi() {
		return giorniFestivi;
	}
	
	
	public void setGiorniSettimanaliFestivi(java.util.List<domain.model.GiornoSettimanale> value) {
		this.giorniSettimanaliFestivi = value;
	}
	
	public java.util.List<domain.model.GiornoSettimanale> getGiorniSettimanaliFestivi() {
		return giorniSettimanaliFestivi;
	}
	
	
	private domain.implementor.CalendarioImp implementor =  new domain.implementor.CalendarioImp();
	
	private static domain.model.Calendario instance;
	
	/**
	 * public LocalDate prendiDataOdierna(){
	 * 
	 * return implementor.prendiDataOdierna(this);
	 * }
	 */
	public boolean isFestivo(org.joda.time.LocalDate data) {
		return this.implementor.isFestivo(this, data);
	}
	
	public static synchronized domain.model.Calendario getInstance() {
		if (instance == null){
				instance = new Calendario();
			}
			return instance;
	}
	
	public org.joda.time.LocalDate getDataOdierna() {
		return this.implementor.getDataOdierna();
	}
	
	public boolean isOggiFestivo() {
		return this.implementor.isOggiFestivo(this);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
