package domain.model;


import java.util.LinkedList;

import java.util.Set;

import org.joda.time.LocalDate;
import org.orm.PersistentManager;

import domain.persistent.Appello;
import domain.persistent.Assenza;
import service.Stampa;



public class MAssenza  extends AModel<Assenza> {

//	private LinkedList<MAppello> appelli;
//	private MGiustificazione giustificazione;
	
	/**
	 * 
	 */
	public MAssenza(){
		getPersistentModel().getAppelli() = new LinkedList<MAppello>();
	}
	
	/**
	 * Costruttore dell'Assenza, prende come parametro una LinkedList di appelli.
	 * @param appelli
	 */
	public MAssenza (LinkedList<Appello> appelli){		
		getPersistentModel().setAppelli(appelli); 
	}

	public MAppello getUltimoAppelloAssenza() {
		return getPersistentModel().getAppelli().getLast();
	}

	/**
	 * Aggiunge una nuova data(Appello) alla lista di date(appelli) dell'assenza.
	 * @param appello
	 */
	public void inserisciAppelloAssenza(MAppello appello) {
		try{
			getPersistentModel().getAppelli().add(appello.getPersistentModel());
		}catch (NullPointerException NPE){
			Stampa.stampaln("----------------------------------------- ");
			Stampa.stampaln("sono nel catch !! ");
//			Stampa.stampaln("appelli: "+ appelli);
			Stampa.stampaln("appello: "+ appello);
			Stampa.stampaln("-----------------------------------------. ");
		}
	}

	/**
	 * Controlla se la data dell'appello passato è inseribile nell'assenza,
	 * ossia se la data dell'appello passato è contigua all'ultima data dell'assenza
	 * @param appello
	 */
	public boolean isInseribile(MAppello appello) {
		boolean inseribile = false;
//		Stampa.stampaln("\n >>>>>>>>>> passo per isInseribile ");
		LocalDate ultimaDataPlus = getPersistentModel().getAppelli().getLast().getData().plusDays(1);
		LocalDate oggi = MCalendario.getInstance().getDataOdierna();//per le prove, a regime usare la riga di sotto
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

//	public LinkedList<Appello> getAppelli() {
////		return appelli;
//		return this.getPersistentModel().getAppelli();
//	}
	
//	public void setAppelli(LinkedList<MAppello> appelli) {
//		this.appelli = appelli;
//	}
//	
	public boolean isCertificatoMedicoRichiesto(){
		boolean rit = false;
				
		if((getPersistentModel().getAppelli().getLast().getData().getDayOfYear() - getPersistentModel().getAppelli().getFirst().getData().getDayOfYear())+1 >= 5){
			rit = true;
		}
		int x = (getPersistentModel().getAppelli().getLast().getData().getDayOfYear() - getPersistentModel().getAppelli().getFirst().getData().getDayOfYear())+1;
		Stampa.stampaln("\n differenza tra i giorni:"+ x +"\n ");
		return rit;
	}
	
	public boolean esisteAppello(MAppello appello){
		return getPersistentModel().getAppelli().contains(appello.getPersistentModel());
	}

	
}