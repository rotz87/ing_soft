package domain.implementor;


import java.util.LinkedList;

import org.joda.time.LocalDate;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Calendario;
import service.Stampa;

public class AssenzaImp {

	
	/**
	 * 
	 */
	public AssenzaImp(){
//		appelli = new LinkedList<AppelloImp>();
	}
	public AssenzaImp(Assenza assenza){
//		appelli = new LinkedList<AppelloImp>();
	}
	
	public void inizialize(Assenza assenza){
		assenza.setAppelli(new LinkedList<Appello>());
	}
	
	public void inizialize(Assenza assenza, LinkedList<Appello> appelli){
		assenza.setAppelli(appelli);
	}
	

	public Appello getUltimoAppelloAssenza(Assenza assenza) {
		//return (( java.util.LinkedList<domain.model.Appello>)(assenza.getAppelli())).getLast();
		
		return (Appello)(( org.hibernate.collection.internal.PersistentBag)(assenza.getAppelli())).get(assenza.getAppelli().size()-1);
	}

	/**
	 * Aggiunge una nuova data(Appello) alla lista di date(appelli) dell'assenza.
	 * @param appello
	 */
	public void inserisciAppelloAssenza(Assenza assenza, Appello appello) {
		try{
			assenza.getAppelli().add(appello);
		}catch (NullPointerException NPE){
			Stampa.stampaln("----------------------------------------- ");
			Stampa.stampaln("sono nel catch !! ");
			Stampa.stampaln("appelli: "+ assenza.getAppelli());
			Stampa.stampaln("appello: "+ appello);
			Stampa.stampaln("-----------------------------------------. ");
		}
	}

	/**
	 * Controlla se la data dell'appello passato è inseribile nell'assenza,
	 * ossia se la data dell'appello passato è contigua all'ultima data dell'assenza
	 * @param appello
	 */
	public boolean isInseribile(Assenza assenza, Appello appello) {
		boolean inseribile = false;
		Stampa.stampaln("\n >>>>>>>>>> passo per isInseribile ");
		Stampa.stampaln("assenza.getAppelliAssenza(): "+assenza.getAppelli());
		LinkedList<Appello> appelliAssenza = new LinkedList<Appello>();
		for(Appello app : assenza.getAppelli()){
			appelliAssenza.add(app);	
			Stampa.stampaln("for: ");
		}
		LocalDate ultimaDataPlus = new LocalDate(appelliAssenza.getLast().getData()).plusDays(1);
//		LocalDate ultimaDataPlus = new LocalDate(((java.util.LinkedList<Appello>)assenza.getAppelliAssenza()).getLast().getData()).plusDays(1);
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
	
	public boolean isCertificatoMedicoRichiesto(Assenza assenza){
		boolean rit = false;
				
		if((new LocalDate(((java.util.LinkedList<Appello>)assenza.getAppelli()).getLast().getData()).getDayOfYear() - new LocalDate(((java.util.LinkedList<Appello>)assenza.getAppelli()).getFirst().getData()).getDayOfYear())+1 >= 5){
			rit = true;
		}
		int x = (new LocalDate(((java.util.LinkedList<Appello>)assenza.getAppelli()).getLast().getData()).getDayOfYear() - new LocalDate(((java.util.LinkedList<Appello>)assenza.getAppelli()).getFirst().getData()).getDayOfYear())+1;
		Stampa.stampaln("\n differenza tra i giorni:"+ x +"\n ");
		return rit;
	}
	
	public boolean esisteAppello(Assenza assenza, Appello appello){
		return assenza.getAppelli().contains(appello);
	}

	
}