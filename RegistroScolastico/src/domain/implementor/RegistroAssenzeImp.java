package domain.implementor;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import domain.model.Appello;
import domain.model.Calendario;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;


public class RegistroAssenzeImp {

//	private MapAppelli appelli;
//	private Map <StudenteImp, LibrettoAssenzeImp> librettiAssenze;
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenzeImp() {

	}
	
	public void inizialize(RegistroAssenze registroAsenze){
		registroAsenze.setAppelli(new TreeMap<LocalDate, Appello>());
	}
	

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(RegistroAssenze registroAssenze, Studente[] Studenti) {
		Appello appelloCorrente = getAppelloOdierno(registroAssenze);
		if (!(appelloCorrente.isAssenzePrese())){
			for (Studente studente : Studenti){
				
					registroAssenze.getLibrettiAssenze().get(studente).segnaAssenza(appelloCorrente);
	
			}
			appelloCorrente.setAssenzePrese(true);
		}else{
			throw new IllegalStateException("ASSENZE GIA' PRESE!");
		}
	}

	public Appello getAppelloOdierno(RegistroAssenze registroAssenze) {
		
		Appello appelloOdierno = null;
		LocalDate dataDiRiferimento = Calendario.getInstance().getDataOdierna();
		if(this.esisteAppello(registroAssenze, dataDiRiferimento)){
			appelloOdierno = registroAssenze.getAppelli().get(dataDiRiferimento);
		}else{
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello(RegistroAssenze registroAssenze) {
		LocalDate dataRif = Calendario.getInstance().getDataOdierna();
		if(!(this.esisteAppello(registroAssenze, dataRif))){
//			//debug
//			Appello nuovoAppello = new Appello(dataRif);
//			appelli.put(dataRif, nuovoAppello);
//			Stempa.stampaln("-------------------------------------------------------------------------------------->id appello : "+nuovoAppello.getIdAppello());
//			//fine debug
			if(!Calendario.getInstance().isOggiFestivo()){
				registroAssenze.getAppelli().put(dataRif, new Appello(dataRif));
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
	public Appello getAppelloByData(RegistroAssenze registroAssenze, org.joda.time.LocalDate data) {
		return registroAssenze.getAppelli().get(data);
	}


	public boolean esisteAppello(RegistroAssenze registroAssenze, LocalDate dataDiRiferimento){

		return registroAssenze.getAppelli().containsKey(dataDiRiferimento);
	
	}
	
	public boolean esisteAppello(RegistroAssenze registroAssenze, Appello appello){

		return registroAssenze.getAppelli().containsValue(appello);
	
	}
	
	public boolean isAppelloOdiernoAvviabile(RegistroAssenze registroAssenze){
		Boolean festivo, esiste, avviabile;
		
		avviabile = false;
		festivo = Calendario.getInstance().isOggiFestivo();
		if(!festivo){
			esiste = registroAssenze.esisteAppello(Calendario.getInstance().getDataOdierna());
			if(!esiste){
				avviabile = true;
			}
		}
		
		return avviabile;
	}
	
	public LibrettoAssenze getLibretto(RegistroAssenze registroAssenze, Studente studente){
		return registroAssenze.getLibrettiAssenze().get(studente);
	}

}