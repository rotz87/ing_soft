package domain;

import java.util.*;

import org.joda.time.*;

import domain.RegistroAssenzeController.MapAppelli;

public class RegistroAssenze {

	/**
	 * @deprecated
	 */
	private Appello appelloOdierno;
	private MapAppelli appelli;
	private Map <Studente, LibrettoAssenze> librettiAssenze;
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenze() {
		appelli = new MapAppelli();
	}
	

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(Studente[] Studenti) {
		for (Studente studente : Studenti){

//			LibrettoAssenze mioLibretto = librettiAssenze.get(idStudente);
//			System.out.println(librettiAssenze.get(idStudente));
			librettiAssenze.get(studente).segnaAssenza(this.getAppelloOdierno());
		}
	}

	public Appello getAppelloOdierno() {
		return this.appelloOdierno;
	}
	

	public void setAppelloOdierno(Appello appelloOdierno) {
		this.appelloOdierno = appelloOdierno;
	}
	
	/**Serve questo metodo????
	 * 
	 * @param id
	 */
	public Appello getAppelloById(long id) {
		Appello appello = null;
		boolean trovato = false;
		Iterator<Appello> i = this.appelli.values().iterator();
		
		while(!trovato && i.hasNext()){
			appello = i.next();
			if(appello.getIdAppello() == id){
				trovato = true;
			}
		}
	
		return appello;
	}



	public void avviaAppello() {
//		QUANDO SI AVVIA L'APPELLO BISOGNA SPOSTARE QUELLO VECCHIO SE ESITE NELLA MAPAPPELLI
//		if(this.appelloOdierno != null){//sarebbe da mettere se l'ultimo appello è di ieri o prima creane uno nuono alreimenti non farlo creare
		if(this.appelloOdierno != null){
			LocalDate oggi = DataOggi.getInstance().getDataOdierna();
			LocalDate dataAppello = appelloOdierno.getDataL();
			if(oggi.isEqual(dataAppello)){
//				System.out.println("LANCIO L'ECCEZIONE");
				throw new IllegalStateException("ATTENZIONE L'APPELLO ODIERNO E' GIA' STATO AVVIATO");
			}else{
				this.appelloOdierno = new Appello();
				appelli.put(appelloOdierno.getDataL(),appelloOdierno);
//				System.out.println("appello odierno not null, sto nell'else");
			}
			
		}else{
			this.appelloOdierno = new Appello();
			appelli.put(appelloOdierno.getDataL(),appelloOdierno);
//			System.out.println("appello null, creazione dell'appello");
		}
	}




	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello già fatto
	 * bottone visualizza dell'interfaccia
	 * @param data
	 */
	public Appello getAppelloByData(org.joda.time.LocalDate data) {
		return appelli.get(data);
	}

	/**
	 * @deprecated 
	 * Metodo inserito per le prove, forse è da togliere
	 * @param librettiAssenze
	 */
	public void assengaLibretti(java.util.Map<Studente, LibrettoAssenze> librettiAssenze) {
		// Per le prove, forse è da togliere!!
				this.librettiAssenze = librettiAssenze;
	}
	
	public MapAppelli getAppelli() {
		return appelli;
	}

	public void setAppelli(MapAppelli appelli) {
		this.appelli = appelli;
	}
	
	
	public Map<Studente, LibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<Studente, LibrettoAssenze> librettiAssenze) {
		this.librettiAssenze = librettiAssenze;
	}


	public class MapAppelli extends HashMap<LocalDate, Appello> {
	}

}