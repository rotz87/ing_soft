package domain.implementor;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;


public class RegistroAssenzeImp {

	private MapAppelli appelli;
	private Map <StudenteImp, LibrettoAssenzeImp> librettiAssenze;
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenzeImp() {
		appelli = new MapAppelli();
	}
	

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(StudenteImp[] Studenti) {
		AppelloImp appelloCorrente = getAppelloOdierno();
		if (!(appelloCorrente.isAssenzePrese())){
			for (StudenteImp studente : Studenti){
				
					librettiAssenze.get(studente).segnaAssenza(appelloCorrente);
	
			}
			appelloCorrente.setAssenzePrese(true);
		}else{
			throw new IllegalStateException("ASSENZE GIA' PRESE!");
		}
	}

	public AppelloImp getAppelloOdierno() {
		
		AppelloImp appelloOdierno = null;
		LocalDate dataDiRiferimento = CalendarioImp.getInstance().getDataOdierna();
		if(this.esisteAppello(dataDiRiferimento)){
			appelloOdierno = appelli.get(dataDiRiferimento);
		}else{
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello() {
		LocalDate dataRif = CalendarioImp.getInstance().getDataOdierna();
		if(!(this.esisteAppello(dataRif))){
//			//debug
//			Appello nuovoAppello = new Appello(dataRif);
//			appelli.put(dataRif, nuovoAppello);
//			Stempa.stampaln("-------------------------------------------------------------------------------------->id appello : "+nuovoAppello.getIdAppello());
//			//fine debug
			if(!CalendarioImp.getInstance().isOggiFestivo()){
				appelli.put(dataRif, new AppelloImp(dataRif));
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
	public AppelloImp getAppelloByData(org.joda.time.LocalDate data) {
		return appelli.get(data);
	}

	/**
	 * @deprecated 
	 * Metodo inserito per le prove, forse è da togliere
	 * @param librettiAssenze
	 */
	public void assengaLibretti(java.util.Map<StudenteImp, LibrettoAssenzeImp> librettiAssenze) {
		// Per le prove, forse è da togliere!!
				this.librettiAssenze = librettiAssenze;
	}

	public MapAppelli getAppelli() {
		return appelli;
	}
	
	public Map<StudenteImp, LibrettoAssenzeImp> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<StudenteImp, LibrettoAssenzeImp> librettiAssenze) {
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
	
	public boolean esisteAppello(AppelloImp appello){
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
		festivo = CalendarioImp.getInstance().isOggiFestivo();
		if(!festivo){
			esiste = this.esisteAppello(CalendarioImp.getInstance().getDataOdierna());
			if(!esiste){
				avviabile = true;
			}
		}
		
		return avviabile;
	}
	
	public LibrettoAssenzeImp getLibretto(StudenteImp studente){
		return this.librettiAssenze.get(studente);
	}

	public class MapAppelli extends TreeMap<LocalDate, AppelloImp> {
		
	}

}