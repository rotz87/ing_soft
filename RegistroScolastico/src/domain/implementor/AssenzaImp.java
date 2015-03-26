package domain.implementor;


import java.util.Collections;

import org.joda.time.LocalDate;

import service.Stampa;
import domain.model.Appello;
import domain.model.Assenza;

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
	
	public Appello getUltimoAppelloAssenza(Assenza assenza) {

		return Collections.max(assenza.getAppelli());
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

		Appello ultimoAppello = Collections.max(assenza.getAppelli());
		LocalDate ultimaDataPlus = new LocalDate(ultimoAppello.getData()).plusDays(1);
		LocalDate attuale = new LocalDate(appello.getData());
		//LocalDate oggi = Calendario.getInstance().getDataOdierna();//per le prove, a regime usare la riga di sotto

		
		if(ultimaDataPlus.isEqual(attuale)){
			inseribile = true;
		}else{
			inseribile = false;
		}
		
		return inseribile;
	}
	
	public boolean isCertificatoMedicoRichiesto(Assenza assenza){
		boolean rit = false;
		
		Appello ultimoAppello = Collections.max(assenza.getAppelli());
		Appello primoAppello = Collections.min(assenza.getAppelli());
		
		LocalDate ultimaData = new LocalDate(ultimoAppello.getData());
		LocalDate primaData = new LocalDate(primoAppello.getData());
				
		if(ultimaData.getDayOfYear() - primaData.getDayOfYear()+1 >= Assenza.giorniCertificatoMedico){
			rit = true;
		}
		return rit;
	}
	
	public boolean esisteAppello(Assenza assenza, Appello appello){
		
		//Se appello == null non ha senso vedere se esiste 
		if(appello == null){
			throw new NullPointerException();
		}
		
		return assenza.getAppelli().contains(appello);
	}
	
	public int compareTo(Assenza that, Assenza assenza) {
		
		return that.getUltimoAppelloAssenza().compareTo(assenza.getUltimoAppelloAssenza());
	}


	
}