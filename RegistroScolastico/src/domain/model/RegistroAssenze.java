package domain.model;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import domain.implementor.RegistroAssenzeImp;


public class RegistroAssenze {

	private TreeMap<LocalDate, Appello> appelli;
	private Map <Studente, LibrettoAssenze> librettiAssenze;
	private RegistroAssenzeImp implementor;
	
	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenze() {
		this.implementor = new RegistroAssenzeImp();
		this.implementor.inizialize(this);
	}
	

	public TreeMap<LocalDate, Appello> getAppelli() {
		return appelli;
	}

	public void setAppelli(TreeMap<LocalDate, Appello> appelli) {
		this.appelli = appelli;
	}

	public Map<Studente, LibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<Studente, LibrettoAssenze> librettiAssenze) {
		this.librettiAssenze = librettiAssenze;
	}

	
	/**Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(Studente[] studenti) {
		
		implementor.registraAssenze(this, studenti);

	}

	public Appello getAppelloOdierno() {
		
		return implementor.getAppelloOdierno(this);

	}

	public void avviaAppello() {
		
		implementor.avviaAppello(this);
		
	}


	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello già fatto
	 * bottone visualizza dell'interfaccia
	 * @param data
	 */
	public Appello getAppelloByData(LocalDate data) {
		return implementor.getAppelloByData(this, data);
	}


	public boolean esisteAppello(LocalDate dataDiRiferimento){

		return implementor.esisteAppello(this, dataDiRiferimento);
	
	}
	
	public boolean esisteAppello(Appello appello){
		
		return implementor.esisteAppello(this, appello);
	
	}
	
	public boolean isAppelloOdiernoAvviabile(){
		return implementor.isAppelloOdiernoAvviabile(this);
//		Boolean festivo, esiste, avviabile;
//		
//		avviabile = false;
//		festivo = Calendario.getInstance().isOggiFestivo();
//		if(!festivo){
//			esiste = this.esisteAppello(Calendario.getInstance().prendiDataOdierna());
//			if(!esiste){
//				avviabile = true;
//			}
//		}
//		
//		return avviabile;
	}
	
	public LibrettoAssenze getLibretto(Studente studente){
		return implementor.getLibretto(this, studente);
	}


}