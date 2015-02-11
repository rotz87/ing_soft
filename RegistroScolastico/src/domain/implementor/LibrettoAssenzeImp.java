package domain.implementor;

import java.util.LinkedList;
import java.util.ListIterator;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.LibrettoAssenze;
import domain.model.Studente;

public class LibrettoAssenzeImp {


	public LibrettoAssenzeImp(){
	}
	
	public void inizialize(LibrettoAssenze librettoAssenze){
		librettoAssenze.setNonGiustificate(new LinkedList<Assenza>());
		librettoAssenze.setGiustificate(new LinkedList<Assenza>());
	}
	
	public void inizialize(LibrettoAssenze librettoAssenze, Studente studente){
		inizialize(librettoAssenze);
		librettoAssenze.setStudente(studente);
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
			ultimaAssenzaNonGiustificata = this.getUltimaAssenzaNonGiustificata(librettoAssenze);
//			Stempa.stampaln("\n libretto di:  "+ this.getStudente().getNome() +" "+ this.getStudente().getCognome());
//			Stempa.stampaln("ultimo appello dell'ultima assenza non giustificata "+ this.getUltimaAssenzaNonGiustificata().getUltimoAppelloAssenza().getDataL()+"\n");
			inseribile = ultimaAssenzaNonGiustificata.isInseribile(appello);	
		}
		

		// dall'alt del SD
		if (inseribile){
			
			ultimaAssenzaNonGiustificata.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("accodo l'assenza " );
		}else{
			
			Assenza nuovaAssenza = new Assenza();
			librettoAssenze.getNonGiustificate().add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("creo l'assenza " );
		}
		
	}

	public Assenza getUltimaAssenzaNonGiustificata(LibrettoAssenze librettoAssenze) {
		//probabilmente è da cambiare
//		Stempa.stampaln("nonGiustificate.get(0): "+nonGiustificate.get(nonGiustificate.size()-1).getUltimoAppelloAssenza().getDataL());

		return librettoAssenze.getNonGiustificate().get(librettoAssenze.getNonGiustificate().size()-1);
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

}