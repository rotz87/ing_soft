package domain.model;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import domain.persistent.RegistroAssenze;


public class MRegistroAssenze  extends AModel<RegistroAssenze>{

//	private MapAppelli appelli;
//	private Map <MStudente, MLibrettoAssenze> librettiAssenze;
//	
	/**
	 * Costrurrore senza parametri.
	 */
	public MRegistroAssenze() {
		appelli = new MapAppelli();
	}
	

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(MStudente[] Studenti) {
		MAppello appelloCorrente = getAppelloOdierno();
		if (!(appelloCorrente.isAssenzePrese())){
			for (MStudente studente : Studenti){
				
					librettiAssenze.get(studente).segnaAssenza(appelloCorrente);
	
			}
			appelloCorrente.setAssenzePrese(true);
		}else{
			throw new IllegalStateException("ASSENZE GIA' PRESE!");
		}
	}

	public MAppello getAppelloOdierno() {
		
		MAppello appelloOdierno = null;
		LocalDate dataDiRiferimento = MCalendario.getInstance().getDataOdierna();
		if(this.esisteAppello(dataDiRiferimento)){
			appelloOdierno = appelli.get(dataDiRiferimento);
		}else{
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello() {
		LocalDate dataRif = MCalendario.getInstance().getDataOdierna();
		if(!(this.esisteAppello(dataRif))){
//			//debug
//			Appello nuovoAppello = new Appello(dataRif);
//			appelli.put(dataRif, nuovoAppello);
//			Stempa.stampaln("-------------------------------------------------------------------------------------->id appello : "+nuovoAppello.getIdAppello());
//			//fine debug
			if(!MCalendario.getInstance().isOggiFestivo()){
				appelli.put(dataRif, new MAppello(dataRif));
			}else{
				throw new IllegalStateException(" APPELLO NON AVVIABILE PER OGGI ");
			}
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
	public MAppello getAppelloByData(org.joda.time.LocalDate data) {
		return appelli.get(data);
	}

	/**
	 * @deprecated 
	 * Metodo inserito per le prove, forse è da togliere
	 * @param librettiAssenze
	 */
	public void assengaLibretti(java.util.Map<MStudente, MLibrettoAssenze> librettiAssenze) {
		// Per le prove, forse è da togliere!!
				this.librettiAssenze = librettiAssenze;
	}

	public MapAppelli getAppelli() {
		return appelli;
	}
	
	public Map<MStudente, MLibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<MStudente, MLibrettoAssenze> librettiAssenze) {
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
	
	public boolean esisteAppello(MAppello appello){
//		boolean rit = false;
//
//		if(appelli.containsValue(appello)){
//			rit = true;
//		}else{
//			rit = false;
//		}
		return appelli.containsValue(appello);
	
	}
//	
//	public boolean isAppelloAvviabile(LocalDate data){
//
//		return Calendario.getInstance().isFestivo(data);
//	}
	
	public boolean isAppelloOdiernoAvviabile(){
		Boolean festivo, esiste, avviabile;
		
		avviabile = false;
		festivo = MCalendario.getInstance().isOggiFestivo();
		if(!festivo){
			esiste = this.esisteAppello(MCalendario.getInstance().getDataOdierna());
			if(!esiste){
				avviabile = true;
			}
		}
		
		return avviabile;
	}
	
	public MLibrettoAssenze getLibretto(MStudente studente){
		return this.librettiAssenze.get(studente);
	}

	public class MapAppelli extends TreeMap<LocalDate, MAppello> {
		
	}

}