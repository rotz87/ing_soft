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
		System.out.println("appelli: "+ appelli);
		appelli.add(appello);
	}

	/**
	 * 
	 * @param appello
	 */
	public boolean isInseribile(Appello appello) {
		boolean inseribile = false;
		
		Date ultimaData = appelli.get(0).getData();
		int ultimoGiorno = ultimaData.getDay();
		
		// probabilmente è conveniente tenere un oggetto opposito che datiene la data odierna
		Date dataOdierna = new GregorianCalendar().getTime();
		int giornoOdierno = dataOdierna.getDay();
		
		if(giornoOdierno-1 == ultimoGiorno){
			inseribile = true;
		}else{
			inseribile = false;
		}
		
		System.out.println("Inseribile : " + inseribile);
		return inseribile;
	}

}