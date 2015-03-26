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

public class LibrettoAssenze {
	public LibrettoAssenze() {
	}
	
	private int ID;
	
	private java.util.List<domain.model.Assenza> _giustificate = new java.util.LinkedList<domain.model.Assenza>();
	
	private java.util.List<domain.model.Assenza> _nonGiustificate = new java.util.LinkedList<domain.model.Assenza>();
	
	private java.util.List<domain.model.Ritardo> _ritardi = new java.util.LinkedList<domain.model.Ritardo>();
	
	private java.util.List<domain.model.UscitaAnticipata> _uscite = new java.util.LinkedList<domain.model.UscitaAnticipata>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_giustificate(java.util.List<domain.model.Assenza> value) {
		this._giustificate = value;
	}
	
	private java.util.List<domain.model.Assenza> get_giustificate() {
		return _giustificate;
	}
	
	
	private void set_nonGiustificate(java.util.List<domain.model.Assenza> value) {
		this._nonGiustificate = value;
	}
	
	private java.util.List<domain.model.Assenza> get_nonGiustificate() {
		return _nonGiustificate;
	}
	
	
	private void set_ritardi(java.util.List<domain.model.Ritardo> value) {
		this._ritardi = value;
	}
	
	private java.util.List<domain.model.Ritardo> get_ritardi() {
		return _ritardi;
	}
	
	
	private void set_uscite(java.util.List<domain.model.UscitaAnticipata> value) {
		this._uscite = value;
	}
	
	private java.util.List<domain.model.UscitaAnticipata> get_uscite() {
		return _uscite;
	}
	
	
	private domain.implementor.LibrettoAssenzeImp implementor = new domain.implementor.LibrettoAssenzeImp();
	
	public void segnaAssenza(domain.model.Appello appello) {
		this.implementor.segnaAssenza(this, appello);
	}
	
	public domain.model.Assenza getUltimaAssenzaNonGiustificata() {
		return this.implementor.getUltimaAssenzaNonGiustificata(this);
	}
	
	public boolean esisteAssenza(domain.model.Appello appello) {
		return this.implementor.esisteAssenza(this, appello);
	}
	
	public domain.model.Assenza getAssenza(domain.model.Appello appello) {
		return this.implementor.getAssenza(this, appello);
	}
	
	public java.util.List<Assenza> getGiustificate() {
		return this._giustificate;
	}
	
	public java.util.List<Assenza> getNonGiustificate() {
		return this._nonGiustificate;
	}
	
	public java.util.List<Ritardo> getRitardi() {
		return this._ritardi;
	}
	
	public java.util.List<UscitaAnticipata> getUscite() {
		return this._uscite;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
