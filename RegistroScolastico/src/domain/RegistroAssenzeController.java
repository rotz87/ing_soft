package domain;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDate;
import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.idSeekLeafPlanner;

public class RegistroAssenzeController {

	private Appello appelloOdierno;
	private MapAppelli appelli;
	private Map <String, LibrettoAssenze> librettiAssenze;
	
	public RegistroAssenzeController(){
		appelli = new MapAppelli();
	}
	
	/**
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(String[] idStudenti) {
		// TODO - implement RegistroAssenzeController.registraAssenze
		
		for (String idStudente : idStudenti){

			
//			LibrettoAssenze mioLibretto = librettiAssenze.get(idStudente);
//			System.out.println(librettiAssenze.get(idStudente));
			librettiAssenze.get(idStudente).segnaAssenza(this.getAppelloOdierno());
		}
		
	}

	public Appello getAppelloOdierno() {
		return this.appelloOdierno;
	}

	public void setAppelloOdierno(Appello appelloOdierno) {
		this.appelloOdierno = appelloOdierno;
	}

	
	public MapAppelli getAppelli() {
		return appelli;
	}

	public void setAppelli(MapAppelli appelli) {
		this.appelli = appelli;
	}
	
	
	public Map<String, LibrettoAssenze> getLibrettiAssenze() {
		return librettiAssenze;
	}

	public void setLibrettiAssenze(Map<String, LibrettoAssenze> librettiAssenze) {
		this.librettiAssenze = librettiAssenze;
	}
	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello già fatto
	 * bottone visualizza dell'interfaccia
	 */
	public Appello getAppelloByData(LocalDate data){
		return appelli.get(data);
	}

	public void avviaAppello() {
		// TODO - implement RegistroAssenzeController.avviaAppello
//		QUANDO SI AVVIA L'APPELLO BISOGN SPOSTARE QUELLO VECCHI SE ESITE NELLA MAPAPPELLI
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
			
			
//		}
	}
	
	/**
	 * @deprecated 
	 * Metodo inserito per le prove, forse è da togliere
	 * @param librettiAssenze
	 */
	public void assengaLibretti (Map<String, LibrettoAssenze> librettiAssenze){
		// Per le prove, forse è da togliere!!
		this.librettiAssenze = librettiAssenze;
		
//		if (this.librettiAssenze ==null){System.out.println("this.librettiAssenze è NULL !");}else{System.out.println("this.librettiAssenze NON è NULL !");}
//		if (librettiAssenze ==null){System.out.println("librettiAssenze è NULL !");}else{System.out.println("this.librettiAssenze NON è NULL !");}
		
	}
	
	public class MapAppelli extends HashMap<LocalDate, Appello>{}
}