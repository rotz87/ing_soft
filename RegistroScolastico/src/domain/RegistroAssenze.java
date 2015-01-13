package domain;

import java.util.*;

import org.joda.time.*;

import domain.RegistroAssenzeController.MapAppelli;

public class RegistroAssenze {

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
			
			LocalDate dataDiRiferimento = DataOggi.getInstance().getDataOdierna();
			
			if(this.esisteAppelloData(dataDiRiferimento)){
			
				librettiAssenze.get(studente).segnaAssenza(this.appelli.get(dataDiRiferimento));
			}else{
				
			}
			
//			librettiAssenze.get(studente).segnaAssenza(this.getAppelloOdierno());
		}
	}

	public Appello getAppelloOdierno() {
		
		Appello appelloOdierno = null;
		LocalDate dataDiRiferimento = DataOggi.getInstance().getDataOdierna();
		if(this.esisteAppelloData(dataDiRiferimento)){
			appelloOdierno = appelli.get(dataDiRiferimento);
		}else{
			appelloOdierno = null;
		}
		return appelloOdierno;
	}
	

//	public void setAppelloOdierno(Appello appelloOdierno) {
//		this.appelloOdierno = appelloOdierno;
//	}
	
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
		LocalDate dataRif = DataOggi.getInstance().getDataOdierna();
		if(!(this.esisteAppelloData(dataRif))){
			appelli.put(dataRif, new Appello(dataRif));
		}else{
			throw new IllegalStateException(" -- ATTENZIONE L'APPELLO ODIERNO E' GIA' STATO AVVIATO -- ");
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

	private boolean esisteAppelloData(LocalDate dataDiRiferimento){
		boolean rit = false;

		if(appelli.containsKey(dataDiRiferimento)){
			rit = true;
		}else{
			rit = false;
		}
		return rit;
	
	}

	public class MapAppelli extends TreeMap<LocalDate, Appello> {
	}

}