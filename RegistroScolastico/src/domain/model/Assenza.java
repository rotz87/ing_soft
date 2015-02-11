package domain.model;


import java.util.LinkedList;

import org.joda.time.LocalDate;

import domain.implementor.AssenzaImp;
import service.Stampa;

public class Assenza {

	private LinkedList<Appello> appelli;
	private Giustificazione giustificazione;
	private AssenzaImp implementor;
	
	/**
	 * 
	 */
	public Assenza(){
		implementor = new AssenzaImp();
		implementor.inizialize(this);
	}
	
	/**
	 * Costruttore dell'Assenza, prende come parametro una LinkedList di appelli.
	 * @param appelli
	 */
	public Assenza (Assenza assenza , LinkedList<Appello> appelli){
		implementor = new AssenzaImp();
		implementor.inizialize(this, appelli);
	}

	public LinkedList<Appello> getAppelli() {
		return appelli;
	}

	public void setAppelli(LinkedList<Appello> appelli) {
		this.appelli = appelli;
	}
	
	
	public Giustificazione getGiustificazione() {
		return giustificazione;
	}

	public void setGiustificazione(Giustificazione giustificazione) {
		this.giustificazione = giustificazione;
	}

	public Appello getUltimoAppelloAssenza() {
		return implementor.getUltimoAppelloAssenza(this);
	}

	/**
	 * Aggiunge una nuova data(Appello) alla lista di date(appelli) dell'assenza.
	 * @param appello
	 */
	public void inserisciAppelloAssenza(Appello appello) {
		implementor.inserisciAppelloAssenza(this, appello);
		
	}

	/**
	 * Controlla se la data dell'appello passato è inseribile nell'assenza,
	 * ossia se la data dell'appello passato è contigua all'ultima data dell'assenza
	 * @param appello
	 */
	public boolean isInseribile(Appello appello) {
		return implementor.isInseribile(this, appello);
	}


	public boolean isCertificatoMedicoRichiesto(){
		return implementor.isCertificatoMedicoRichiesto(this);
	}
	
	public boolean esisteAppello(Appello appello){
		return implementor.esisteAppello(this, appello);

	}

	
}