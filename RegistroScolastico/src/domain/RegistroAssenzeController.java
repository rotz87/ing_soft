package domain;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.steps.idSeekLeafPlanner;

public class RegistroAssenzeController {

	private Appello appelloOdierno;
	private Map <String, LibrettoAssenze> librettiAssenze;

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

	public void avviaAppello() {
		// TODO - implement RegistroAssenzeController.avviaAppello
		
//		if(this.appelloOdierno != null){//sarebbe da mettere se l'ultimo appello è di ieri o prima creane uno nuono alreimenti non farlo creare
			this.appelloOdierno = new Appello();
			
			
//		}
	}

	public void assengaLibretti (Map<String, LibrettoAssenze> librettiAssenze){
		// Per le prove, forse è da togliere!!
		this.librettiAssenze = librettiAssenze;
		
//		if (this.librettiAssenze ==null){System.out.println("this.librettiAssenze è NULL !");}else{System.out.println("this.librettiAssenze NON è NULL !");}
//		if (librettiAssenze ==null){System.out.println("librettiAssenze è NULL !");}else{System.out.println("this.librettiAssenze NON è NULL !");}
		
	}
	
}