package domain.implementor;


import java.util.Collections;
import java.util.LinkedList;

import org.apache.activemq.filter.function.makeListFunction;
import org.hsqldb.lib.Collection;
import org.joda.time.LocalDate;

import service.Stampa;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Calendario;

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

	}
	
	public void inizialize(Assenza assenza, java.util.Set<Appello> appelli){
		assenza.setAppelli(appelli);
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
		Stampa.stampaln();
		Stampa.stampaln("=====I=== AssenzaImp.isInseribile() =========");
		Stampa.stampaln();
		Stampa.stampaln("ultimoAppello: "+ultimoAppello.getData());
		Stampa.stampaln("ultimaDataPlus: "+ultimaDataPlus);
		Stampa.stampaln("attuale: "+attuale);
		Stampa.stampaln("inseribile: "+inseribile);
		Stampa.stampaln();
		Stampa.stampaln("=====F=== AssenzaImp.isInseribile() =========");
		Stampa.stampaln();
		
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
//		int x = ultimaData.getDayOfYear() -primaData.getDayOfYear()+1;
//		Stampa.stampaln("\n differenza tra i giorni:"+ x +"\n ");
		return rit;
	}
	
	public boolean esisteAppello(Assenza assenza, Appello appello){
		return assenza.getAppelli().contains(appello);
	}
	public int compareTo(Assenza that, Assenza assenza) {
		
		return that.getUltimoAppelloAssenza().compareTo(assenza.getUltimoAppelloAssenza());
	}

	
}