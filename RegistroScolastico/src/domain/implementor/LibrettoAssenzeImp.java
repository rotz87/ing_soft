package domain.implementor;

import java.util.Collections;
import java.util.ListIterator;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.LibrettoAssenze;
import domain.model.Studente;

public class LibrettoAssenzeImp {


	public LibrettoAssenzeImp(){
	}
	

	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(LibrettoAssenze librettoAssenze, Appello appello) {
		
//		Stampa.stampaln("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		boolean inseribile = false;
		Assenza ultimaAssenzaNonGiustificata = null;
		
		if(!(librettoAssenze.getNonGiustificate().isEmpty())){
			
			ultimaAssenzaNonGiustificata = getUltimaAssenzaNonGiustificata(librettoAssenze);
			inseribile = ultimaAssenzaNonGiustificata.isInseribile(appello);	
		}
		

		// dall'alt del SD
		if (inseribile){
			
			ultimaAssenzaNonGiustificata.inserisciAppelloAssenza(appello);
		}else{
			
			Assenza nuovaAssenza = new Assenza();
			librettoAssenze.getNonGiustificate().add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
		}
		
	}

	public Assenza getUltimaAssenzaNonGiustificata(LibrettoAssenze librettoAssenze) {
		return Collections.max(librettoAssenze.getNonGiustificate());
	}
	
	public boolean esisteAssenza(LibrettoAssenze librettoAssenze, Appello appello){
		boolean rit = false;
		 ListIterator<Assenza> listIteratorNG = librettoAssenze.getNonGiustificate().listIterator();
	        while (listIteratorNG.hasNext() && rit == false) {
	        	Assenza assenza = listIteratorNG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        ListIterator<Assenza> listIteratorG = librettoAssenze.getGiustificate().listIterator();
	        while (listIteratorG.hasNext() && rit == false) {
	        	Assenza assenza = listIteratorG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        return rit;
	}
	
	public Assenza getAssenza(LibrettoAssenze librettoAssenze, Appello appello){

		Assenza rit = null;
		
		ListIterator<Assenza> listIteratorNG = librettoAssenze.getNonGiustificate().listIterator();
        while (listIteratorNG.hasNext()) {
        	Assenza assenza = listIteratorNG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
        ListIterator<Assenza> listIteratorG = librettoAssenze.getGiustificate().listIterator();
        while (listIteratorG.hasNext()) {
        	Assenza assenza = listIteratorG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
		
		return rit;
	}

	/**
	 * 
	 * @param librettoAssenze
	 */
	public void inizialize(LibrettoAssenze librettoAssenze) {
		// TODO - implement LibrettoAssenzeImp.inizialize
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param librettoAssenze
	 * @param studente
	 */
	public void inizialize(LibrettoAssenze librettoAssenze, Studente studente) {
		// TODO - implement LibrettoAssenzeImp.inizialize
		throw new UnsupportedOperationException();
	}

}