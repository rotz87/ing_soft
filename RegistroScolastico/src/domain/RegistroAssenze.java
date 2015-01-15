package domain;

import java.util.*;

import org.joda.time.*;


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
		Appello appelloCorrente = getAppelloOdierno();
		if (!(appelloCorrente.isAssenzePrese())){
			for (Studente studente : Studenti){
				
					librettiAssenze.get(studente).segnaAssenza(appelloCorrente);
	
			}
			appelloCorrente.setAssenzePrese(true);
		}else{
			throw new IllegalStateException("ASSENZE GIA' PRESE!");
		}
	}

	public Appello getAppelloOdierno() {
		
		Appello appelloOdierno = null;
		LocalDate dataDiRiferimento = Calendario.getInstance().getDataOdierna();
		if(this.esisteAppello(dataDiRiferimento)){
			appelloOdierno = appelli.get(dataDiRiferimento);
		}else{
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello() {
		LocalDate dataRif = Calendario.getInstance().getDataOdierna();
		if(!(this.esisteAppello(dataRif))){
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
	
	public Map<Studente, LibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<Studente, LibrettoAssenze> librettiAssenze) {
		this.librettiAssenze = librettiAssenze;
	}

	public boolean esisteAppello(LocalDate dataDiRiferimento){
//		boolean rit = false;
//
//		if(appelli.containsKey(dataDiRiferimento)){
//			rit = true;
//		}else{
//			rit = false;
//		}
		return appelli.containsKey(dataDiRiferimento);
	
	}
	
	public boolean esisteAppello(Appello appello){
//		boolean rit = false;
//
//		if(appelli.containsValue(appello)){
//			rit = true;
//		}else{
//			rit = false;
//		}
		return appelli.containsValue(appello);
	
	}
	
	public LibrettoAssenze getLibretto(Studente studente){
		return this.librettiAssenze.get(studente);
	}

	public class MapAppelli extends TreeMap<LocalDate, Appello> {
		
	}

}