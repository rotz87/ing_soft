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

public class Assenza {
	public Assenza() {
	}
	
	private int ID;
	
	private domain.model.Giustificazione giustificazione;
	
	private java.util.Set<domain.model.Appello> appelli = new java.util.LinkedHashSet<domain.model.Appello>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setGiustificazione(domain.model.Giustificazione value) {
		this.giustificazione = value;
	}
	
	public domain.model.Giustificazione getGiustificazione() {
		return giustificazione;
	}
	
	public void setAppelli(java.util.Set<domain.model.Appello> value) {
		this.appelli = value;
	}
	
	public java.util.Set<domain.model.Appello> getAppelli() {
		return appelli;
	}
	
	
	private domain.implementor.AssenzaImp implementor = new domain.implementor.AssenzaImp();
	
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
	
	/**
	 * Costruttore dell'Assenza, prende come parametro una LinkedList di appelli.
	 */
	public Assenza(java.util.LinkedHashSet<Appello> appelli) {
		this.implementor.inizialize(this, appelli);
	}
	
	public boolean isCertificatoMedicoRichiesto() {
		return this.implementor.isCertificatoMedicoRichiesto(this);
	}
	
	public boolean esisteAppello(domain.model.Appello appello) {
		return this.implementor.esisteAppello(this, appello);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
