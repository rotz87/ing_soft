package domain;

import java.util.*;

public class Assenza {

	List<Appello> appelli;
	
	public Assenza(){
		
	}
	
	public Assenza (List<Appello> appelli){
		//per le prove, probabilmente è da togliere
		this.appelli = appelli;
		
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
		
//		Calendar ultimaData = appelli.get(0).getDataCalendar();
		Date ultimaData = appelli.get(0).getData();

//		int ultimoGiorno = ultimaData.get(Calendar.DAY_OF_MONTH);
		int ultimoGiorno = ultimaData.getDay();
		
		// probabilmente è conveniente tenere un oggetto opposito che datiene la data odierna
//		int giornoOdierno =  new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		int giornoOdierno = new GregorianCalendar().getTime().getDay();

		if(giornoOdierno-1 == ultimoGiorno){
		// bosogna usare i metodi di confronto per le date, cosi non funziona a cavallo di due mesi
			inseribile = true;
		}else{
			inseribile = false;
		}
		
		System.out.println("Inseribile : " + inseribile + " | ultimo giorno: " + ultimoGiorno);
		return inseribile;
	}

}