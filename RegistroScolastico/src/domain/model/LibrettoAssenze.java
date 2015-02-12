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
	
	private domain.model.Studente studente;
	
	private java.util.List<domain.model.Assenza> giustificate = new java.util.LinkedList<domain.model.Assenza>();
	
	private java.util.List<domain.model.Assenza> nonGiustificate = new java.util.LinkedList<domain.model.Assenza>();
	
	private java.util.List<domain.model.Ritardo> ritardi = new java.util.LinkedList<domain.model.Ritardo>();
	
	private java.util.List<domain.model.UscitaAnticipata> uscite = new java.util.LinkedList<domain.model.UscitaAnticipata>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setGiustificate(java.util.List<domain.model.Assenza> value) {
		this.giustificate = value;
	}
	
	public java.util.List<domain.model.Assenza> getGiustificate() {
		return giustificate;
	}
	
	
	public void setNonGiustificate(java.util.List<domain.model.Assenza> value) {
		this.nonGiustificate = value;
	}
	
	public java.util.List<domain.model.Assenza> getNonGiustificate() {
		return nonGiustificate;
	}
	
	
	public void setStudente(domain.model.Studente value) {
		this.studente = value;
	}
	
	public domain.model.Studente getStudente() {
		return studente;
	}
	
	public void setRitardi(java.util.List<domain.model.Ritardo> value) {
		this.ritardi = value;
	}
	
	public java.util.List<domain.model.Ritardo> getRitardi() {
		return ritardi;
	}
	
	
	public void setUscite(java.util.List<domain.model.UscitaAnticipata> value) {
		this.uscite = value;
	}
	
	public java.util.List<domain.model.UscitaAnticipata> getUscite() {
		return uscite;
	}
	
	
	private domain.implementor.LibrettoAssenzeImp implementor = new domain.implementor.LibrettoAssenzeImp();
	
	public void segnaAssenza(domain.model.Appello appello) {
		this.implementor.segnaAssenza(this, appello);
	}
	
	public domain.model.Assenza getUltimaAssenzaNonGiustificata() {
		return this.implementor.getUltimaAssenzaNonGiustificata(this);
	}
	
	public LibrettoAssenze(domain.model.Studente stud) {
		this.implementor.inizialize(this, stud);
	}
	
	public boolean esisteAssenza(domain.model.Appello appello) {
		return this.implementor.esisteAssenza(this, appello);
	}
	
	public domain.model.Assenza getAssenza(domain.model.Appello appello) {
		return this.implementor.getAssenza(this, appello);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
