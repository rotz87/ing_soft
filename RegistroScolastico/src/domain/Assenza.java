package domain;


import java.util.*;

import org.joda.time.LocalDate;

public class Assenza {

	LinkedList<Appello> appelli;
	
	public Assenza(){
		appelli = new LinkedList<Appello>();
//		System.out.println(" Sono nel costruttore senza parametri di assenza");
	}
	
	public Assenza (LinkedList<Appello> appelli){
		//per le prove, probabilmente è da togliere
		
		this.appelli = appelli;
//		System.out.println("------------------- \n Sono nel costruttore di assenza | appelli: " + appelli + " | this.appelli : "+ this.appelli + "\n ---------------------");
		
	}

	public Appello getUltimoAppelloAssenza() {
		// TODO - implement Assenza.getUltimoAppelloAssenza
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param appello
	 */
	public void inserisciAppelloAssenza(Appello appello) {
		// TODO - implement Assenza.inserisciAppelloAssenza
		try{
			//togliere la if e spostare il corpo nel costruttore
//			if (appelli == null){appelli = new LinkedList<Appello>();}
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
	 * 
	 * @param appello
	 */
	public boolean isInseribile(Appello appello) {
		boolean inseribile = false;
		
//		LocalDate ultimaData = appelli.getLast().getDataL();

		LocalDate ultimaDataPlus = appelli.getLast().getDataL().plusDays(1);
		LocalDate oggi = DataOggi.getInstance().getDataOdierna();
		
		if(ultimaDataPlus.isEqual(oggi)){
			inseribile = true;
		}else{
			inseribile = false;
		}
		
//confronto con l'uso di calendar
//		Calendar ultimaDataC = appelli.getLast().getDataCalendar();
////		System.out.println("ultimaData = " + appelli.getLast().getData());
////		System.out.println("ultimaDataC = " + ultimaDataC);
//		int ultimoGiornoC = ultimaDataC.get(Calendar.DAY_OF_MONTH);
//		ultimaDataC.set(Calendar.DAY_OF_MONTH, ultimoGiornoC+1);
//		
//		Calendar dataOggi = new GregorianCalendar();
//		
//		boolean condizione = ((ultimaDataC.get(Calendar.DAY_OF_MONTH)==dataOggi.get(Calendar.DAY_OF_MONTH)) && (ultimaDataC.get(Calendar.MONTH)==dataOggi.get(Calendar.MONTH))&& (ultimaDataC.get(Calendar.YEAR)==dataOggi.get(Calendar.YEAR)));
//		// 
//		
//		if (condizione){
//			inseribile = true;
//		}else{
//			inseribile = false;
//		}
		//confronto con l'uso di calendar FINE		
		
//	//vecchio confronto
//		Date ultimaData = appelli.getLast().getData();
//
//
//		int ultimoGiorno = ultimaData.getDay();
//		
//		// probabilmente è conveniente tenere un oggetto opposito che datiene la data odierna
//		int giornoOdierno = new GregorianCalendar().getTime().getDay();
//
//		if(giornoOdierno-1 == ultimoGiorno){
//		// bosogna usare i metodi di confronto per le date, così non funziona a cavallo di due mesi
//			inseribile = true;
//		}else{
//			inseribile = false;
//		}
//		//fine vecchio confronto
		
//		System.out.println("Inseribile : " + inseribile + "  | utlimaDataPlus : " +ultimaDataPlus + " | oggi : " + oggi );
		return inseribile;
	}

	public LinkedList<Appello> getAppelli() {
		return appelli;
	}

	public void setAppelli(LinkedList<Appello> appelli) {
		this.appelli = appelli;
	}

	
}