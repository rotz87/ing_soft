package domain;


import java.util.*;

import org.joda.time.LocalDate;

public class Assenza {

	private LinkedList<Appello> appelli;
	Collection<Appello> appello;
	private Giustificazione giustificazione;
	
	/**
	 * 
	 */
	public Assenza(){
		appelli = new LinkedList<Appello>();
	}
	
	/**
	 * Costruttore dell'Assenza, prende come parametro una LinkedList di appelli.
	 * @param appelli
	 */
	public Assenza (LinkedList<Appello> appelli){		
		this.appelli = appelli;
	}

	public Appello getUltimoAppelloAssenza() {
		return appelli.getLast();
	}

	/**
	 * Aggiunge una nuova data(Appello) alla lista di date(appelli) dell'assenza.
	 * @param appello
	 */
	public void inserisciAppelloAssenza(Appello appello) {
		try{
			appelli.add(appello);
		}catch (NullPointerException NPE){
			System.out.println("----------------------------------------- ");
			System.out.println("sono nel catch !! ");
			System.out.println("appelli: "+ appelli);
			System.out.println("appello: "+ appello);
			System.out.println("-----------------------------------------. ");
		}
	}

	/**
	 * Controlla se la data dell'appello passato è inseribile nell'assenza,
	 * ossia se la data dell'appello passato è contigua all'ultima data dell'assenza
	 * @param appello
	 */
	public boolean isInseribile(Appello appello) {
		boolean inseribile = false;
		
		LocalDate ultimaDataPlus = appelli.getLast().getDataL().plusDays(1);
		LocalDate oggi = DataOggi.getInstance().getDataOdierna();
		
		if(ultimaDataPlus.isEqual(oggi)){
			inseribile = true;
		}else{
			inseribile = false;
		}
		
		return inseribile;
	}

	public LinkedList<Appello> getAppelli() {
		return appelli;
	}

	public void setAppelli(LinkedList<Appello> appelli) {
		this.appelli = appelli;
	}

	
}