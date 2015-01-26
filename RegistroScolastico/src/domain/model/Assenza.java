package domain.model;


import java.util.LinkedList;

import org.joda.time.LocalDate;

import service.Stampa;

public class Assenza {

	private LinkedList<Appello> appelli;
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
			Stampa.stampaln("----------------------------------------- ");
			Stampa.stampaln("sono nel catch !! ");
			Stampa.stampaln("appelli: "+ appelli);
			Stampa.stampaln("appello: "+ appello);
			Stampa.stampaln("-----------------------------------------. ");
		}
	}

	/**
	 * Controlla se la data dell'appello passato è inseribile nell'assenza,
	 * ossia se la data dell'appello passato è contigua all'ultima data dell'assenza
	 * @param appello
	 */
	public boolean isInseribile(Appello appello) {
		boolean inseribile = false;
//		Stampa.stampaln("\n >>>>>>>>>> passo per isInseribile ");
		LocalDate ultimaDataPlus = appelli.getLast().getData().plusDays(1);
		LocalDate oggi = Calendario.getInstance().getDataOdierna();//per le prove, a regime usare la riga di sotto
//		LocalDate oggi = appello.getDataL();
//		Stampa.stampaln("appelli.getLast().getDataL(): "+appelli.getLast().getDataL());
//		Stampa.stampaln("ultimaDataPlus: "+ultimaDataPlus);
//		Stampa.stampaln("oggi: "+oggi);
		
		if(ultimaDataPlus.isEqual(oggi)){
			inseribile = true;
		}else{
			inseribile = false;
		}
//		Stampa.stampaln("inseribile: "+inseribile);
//		Stampa.stampaln(" >>>>>>>>>> esco da isInseribile \n");
		return inseribile;
	}

	public LinkedList<Appello> getAppelli() {
		return appelli;
	}

	public void setAppelli(LinkedList<Appello> appelli) {
		this.appelli = appelli;
	}
	
	public boolean isCertificatoMedicoRichiesto(){
		boolean rit = false;
				
		if((appelli.getLast().getData().getDayOfYear() - appelli.getFirst().getData().getDayOfYear())+1 >= 5){
			rit = true;
		}
		int x = (appelli.getLast().getData().getDayOfYear() - appelli.getFirst().getData().getDayOfYear())+1;
		Stampa.stampaln("\n differenza tra i giorni:"+ x +"\n ");
		return rit;
	}
	
	public boolean esisteAppello(Appello appello){
		return appelli.contains(appello);
	}

	
}