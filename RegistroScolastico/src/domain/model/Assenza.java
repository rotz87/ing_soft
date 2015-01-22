package domain.model;


import java.util.*;

import org.joda.time.LocalDate;

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
//		System.out.println("\n >>>>>>>>>> passo per isInseribile ");
		LocalDate ultimaDataPlus = appelli.getLast().getData().plusDays(1);
		LocalDate oggi = Calendario.getInstance().getDataOdierna();//per le prove, a regime usare la riga di sotto
//		LocalDate oggi = appello.getDataL();
//		System.out.println("appelli.getLast().getDataL(): "+appelli.getLast().getDataL());
//		System.out.println("ultimaDataPlus: "+ultimaDataPlus);
//		System.out.println("oggi: "+oggi);
		
		if(ultimaDataPlus.isEqual(oggi)){
			inseribile = true;
		}else{
			inseribile = false;
		}
//		System.out.println("inseribile: "+inseribile);
//		System.out.println(" >>>>>>>>>> esco da isInseribile \n");
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
		System.out.println("\n differenza tra i giorni:"+ x +"\n ");
		return rit;
	}
	
	public boolean esisteAppello(Appello appello){
		return appelli.contains(appello);
	}

	
}