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

public class Assenza implements java.lang.Comparable<Assenza> {
	public Assenza() {
	}
	
	private int ID;
	
	private domain.model.Giustificazione _giustificazione;
	
	private java.util.Set<domain.model.Appello> _appelli = new java.util.LinkedHashSet<domain.model.Appello>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_giustificazione(domain.model.Giustificazione value) {
		this._giustificazione = value;
	}
	
	private domain.model.Giustificazione get_giustificazione() {
		return _giustificazione;
	}
	
	public void set_appelli(java.util.Set<domain.model.Appello> value) {
		this._appelli = value;
	}
	
	public java.util.Set<domain.model.Appello> get_appelli() {
		return _appelli;
	}
	
	
	private domain.implementor.AssenzaImp implementor = new domain.implementor.AssenzaImp();
	
	public static final int giorniCertificatoMedico = 5;
	
	public domain.model.Appello getUltimoAppelloAssenza() {
		return this.implementor.getUltimoAppelloAssenza(this);
	}
	
	/**
	 * Aggiunge una nuova data(Appello) alla lista di date(appelli) dell'assenza.
	 */
	public void inserisciAppelloAssenza(domain.model.Appello appello) {
		this.implementor.inserisciAppelloAssenza(this, appello);
	}
	
	/**
	 * Controlla se la data dell'appello passato Ã¨ inseribile nell'assenza,
	 * ossia se la data dell'appello passato Ã¨ contigua all'ultima data dell'assenza
	 */
	public boolean isInseribile(domain.model.Appello appello) {
		return this.implementor.isInseribile(this, appello);
	}
	
	public boolean isCertificatoMedicoRichiesto() {
		return this.implementor.isCertificatoMedicoRichiesto(this);
	}
	
	public boolean esisteAppello(domain.model.Appello appello) {
		return this.implementor.esisteAppello(this, appello);
	}
	
	public int compareTo(domain.model.Assenza assenza) {
		return this.implementor.compareTo(this, assenza);
	}
	
	public domain.model.Giustificazione getGiustificazione() {
		return this._giustificazione;
	}
	
	public void setGiustificazione(domain.model.Giustificazione giustificazione) {
		this._giustificazione = giustificazione;
	}
	
	public java.util.Set<Appello> getAppelli() {
		return this._appelli;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
