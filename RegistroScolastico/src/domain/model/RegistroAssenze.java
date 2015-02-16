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

public class RegistroAssenze {
	public RegistroAssenze() {
	}
	
	private int ID;
	
	private java.util.Map<Integer, domain.model.LibrettoAssenze> librettiAssenze = new java.util.HashMap<Integer, domain.model.LibrettoAssenze>();
	
	private java.util.Map<Integer, domain.model.Appello> appelliRegistro = new java.util.HashMap<Integer, domain.model.Appello>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setLibrettiAssenze(java.util.Map<Integer, domain.model.LibrettoAssenze> value) {
		this.librettiAssenze = value;
	}
	
	public java.util.Map<Integer, domain.model.LibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}
	
	
	public void setAppelliRegistro(java.util.Map<Integer, domain.model.Appello> value) {
		this.appelliRegistro = value;
	}
	
	public java.util.Map<Integer, domain.model.Appello> getAppelliRegistro() {
		return appelliRegistro;
	}
	
	
	private domain.implementor.RegistroAssenzeImp implementor = new domain.implementor.RegistroAssenzeImp();
	
	public void avviaAppello() {
		this.implementor.avviaAppello(this);
	}
	
	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello giÃ  fatto
	 * bottone visualizza dell'interfaccia
	 */
	public domain.model.Appello getAppelloByData(org.joda.time.LocalDate data) {
		return this.implementor.getAppelloByData(this, data);
	}
	
	/**
	 * Riceve un vettore di studenti per cui segnare le assenze
	 */
	public void registraAssenze(domain.model.Studente[] studenti) {
		this.implementor.registraAssenze(this, studenti);
	}
	
	public domain.model.Appello getAppelloOdierno() {
		return this.implementor.getAppelloOdierno(this);
	}
	
	public boolean esisteAppello(domain.model.Appello appello) {
		return this.implementor.esisteAppello(this, appello);
	}
	
	public boolean esisteAppello(org.joda.time.LocalDate dataDiRiferimento) {
		return this.implementor.esisteAppello(this, dataDiRiferimento);
	}
	
	public boolean isAppelloOdiernoAvviabile() {
		return this.implementor.isAppelloOdiernoAvviabile(this);
	}
	
	public domain.model.LibrettoAssenze getLibretto(domain.model.Studente studente) {
		return this.implementor.getLibretto(this, studente);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
