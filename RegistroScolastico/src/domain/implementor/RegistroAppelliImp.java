package domain.implementor;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.time.LocalDate;

import domain.error.ErrorMessage;
import domain.model.Appello;
import domain.model.Calendario;
import domain.model.GiornoFestivo;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAppelli;
import domain.model.Studente;


public class RegistroAppelliImp {
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAppelliImp() {

	}

	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(RegistroAppelli registroAppelli, Collection<LibrettoAssenze> libretti) {
		
		Appello appelloCorrente = getAppelloOdierno(registroAppelli);
		if (!(appelloCorrente.getAssenzePrese())){
			for (LibrettoAssenze libretto : libretti){
					libretto.segnaAssenza(appelloCorrente);
					
			}
			appelloCorrente.setAssenzePrese(true);
		}else{
			throw new IllegalStateException(ErrorMessage.ASSENZE_PRESE);
		}
	}

	public Appello getAppelloOdierno(RegistroAppelli registroAppelli) {
		
		Appello appelloOdierno = null;
		LocalDate dataDiRiferimento = Calendario.getInstance().getDataOdierna();
		if(this.esisteAppello(registroAppelli, dataDiRiferimento)){
			
			appelloOdierno = registroAppelli.getAppelli().get(Calendario.getInstance().getDaysFromZero(dataDiRiferimento.toDate()));

		}else{
			throw new IllegalStateException(ErrorMessage.APPELLO_ODIERNO_INEXISTENT);
		}
		return appelloOdierno;
	}

	public void avviaAppello(RegistroAppelli registroAppelli) {
		Appello appello;
		LocalDate dataRif;
		
		dataRif = Calendario.getInstance().getDataOdierna();

		if(!(this.esisteAppello(registroAppelli, dataRif))){
			if(!Calendario.getInstance().isOggiFestivo()){
				appello = new Appello(dataRif);
				registroAppelli.getAppelli().put(Calendario.getInstance().getDaysFromZero(dataRif.toDate()), appello);
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
	public Appello getAppelloByData(RegistroAppelli registroAppelli, org.joda.time.LocalDate data) {
		int dataInt = Calendario.getInstance().getDaysFromZero(data.toDate());
		return registroAppelli.getAppelli().get(dataInt);
		
	}


	public boolean esisteAppello(RegistroAppelli registroAppelli, LocalDate dataDiRiferimento){

		return registroAppelli.getAppelli().containsKey(Calendario.getInstance().getDaysFromZero(dataDiRiferimento.toDate()));
	
	}
	
	public boolean esisteAppello(RegistroAppelli registroAppelli, Appello appello){

		return registroAppelli.getAppelli().containsValue(appello);
	
	}
	
	public boolean isAppelloOdiernoAvviabile(RegistroAppelli registroAppelli){
		Boolean festivo, esiste, avviabile;
		
		avviabile = false;
		festivo = Calendario.getInstance().isOggiFestivo();
		if(!festivo){
			esiste = registroAppelli.esisteAppello(Calendario.getInstance().getDataOdierna());
			if(!esiste){
				avviabile = true;
			}
		}
		
		return avviabile;
	}
	

	public boolean checkPresenti(RegistroAppelli registro, LocalDate data, Collection<Studente> studenti) {
		boolean rit = true;
		Appello appello = registro.getAppelloByData(data);
		
		for(Studente studente : studenti ){
			rit = rit && (!studente.getLibrettoAssenze().esisteAssenza(appello));
		}
		return rit;
	}

	public Collection<LocalDate>getDateNonFestivePassateSenzaAppello(RegistroAppelli registro) {
		Collection<LocalDate> rit = new LinkedList<LocalDate>();
		Calendario cal = Calendario.getInstance();
		
		for(LocalDate data = cal.getInizioLezioni(); data.isBefore(cal.getDataOdierna()); data = data.plusDays(1)){
			if(!cal.isFestivo(data) && !registro.esisteAppello(data)){
				rit.add(data);
			}
		}
		
		return rit;
	}

	public Collection<LocalDate> getDateFestiveOSenzaAppello(RegistroAppelli registroAppelli) {
		
		Collection<LocalDate> rit;

		rit = new LinkedList<LocalDate>();
		
		rit.addAll(registroAppelli.getDateNonFestivePassateSenzaAppello());
		for(GiornoFestivo ggf : Calendario.getInstance().getGiorniFestivi()){
			rit.add(new LocalDate(ggf.getData()));
		}
		
		return rit;
	}

}