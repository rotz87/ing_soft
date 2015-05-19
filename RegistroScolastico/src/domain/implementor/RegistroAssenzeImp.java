package domain.implementor;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.time.LocalDate;

import domain.error.ErrorMessage;
import domain.model.Appello;
import domain.model.Calendario;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;


public class RegistroAssenzeImp {
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenzeImp() {

	}

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(RegistroAssenze registroAssenze, Collection<LibrettoAssenze> libretti) {
		
		Appello appelloCorrente = getAppelloOdierno(registroAssenze);
		if (!(appelloCorrente.getAssenzePrese())){
			for (LibrettoAssenze libretto : libretti){
					libretto.segnaAssenza(appelloCorrente);
					
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
			
			appelloOdierno = registroAssenze.getAppelli().get(Calendario.getInstance().getDaysFromZero(dataDiRiferimento.toDate()));

		}else{
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello(RegistroAssenze registroAssenze) {
		Appello appello;
		LocalDate dataRif;
		
		dataRif = Calendario.getInstance().getDataOdierna();

		if(!(this.esisteAppello(registroAssenze, dataRif))){
			if(!Calendario.getInstance().isOggiFestivo()){
				appello = new Appello(dataRif);
				registroAssenze.getAppelli().put(Calendario.getInstance().getDaysFromZero(dataRif.toDate()), appello);
			}else{
				throw new IllegalStateException(ErrorMessage.APPELLO_NON_AVVIABILE_OGGI);
			}
		}else{
			throw new IllegalStateException(ErrorMessage.APPELLO_ALREADY_EXIST);
		}
		
	}


	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello già fatto
	 * bottone visualizza dell'interfaccia
	 * @param data
	 */
	public Appello getAppelloByData(RegistroAssenze registroAssenze, org.joda.time.LocalDate data) {
		int dataInt = Calendario.getInstance().getDaysFromZero(data.toDate());
		return registroAssenze.getAppelli().get(dataInt);
		
	}


	public boolean esisteAppello(RegistroAssenze registroAssenze, LocalDate dataDiRiferimento){

		return registroAssenze.getAppelli().containsKey(Calendario.getInstance().getDaysFromZero(dataDiRiferimento.toDate()));
	
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
	

	public boolean checkPresenti(RegistroAssenze registro, LocalDate data, Collection<Studente> studenti) {
		boolean rit = true;
		Appello appello = registro.getAppelloByData(data);
		
		for(Studente studente : studenti ){
			rit = rit && (!studente.getLibrettoAssenze().esisteAssenza(appello));
		}
		return rit;
	}

	public Collection<LocalDate>getDateNonFestivePassateSenzaAppello(RegistroAssenze registro) {
		Collection<LocalDate> rit = new LinkedList<LocalDate>();
		Calendario cal = Calendario.getInstance();
		
		for(LocalDate data = cal.getInizioLezioni(); data.isBefore(cal.getDataOdierna()); data = data.plusDays(1)){
			if(!cal.isFestivo(data) && !registro.esisteAppello(data)){
				rit.add(data);
			}
		}
		
		return rit;
	}

}