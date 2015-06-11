package domain.implementor;

import domain.model.LibrettoVoti;
import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;
import domain.model.compitoInClasse.CompitoInClasse;

public class LibrettoVotiImp {

	/**
	 * 
	 * @param librettoVoti
	 * @param compito
	 */
	public void makeLineItem(LibrettoVoti librettoVoti, CompitoInClasse compito, Voto voto) {
		LibrettoVotiLineItem lineItem;
		lineItem = librettoVoti.getLibrettoLineItem(compito);
		if(lineItem == null){
			lineItem = new LibrettoVotiLineItem(compito);
			librettoVoti.getLibVotiLineItems().add(lineItem);
		}
		lineItem.aggiungiVoto(voto);
	}

	/**
	 * 
	 * @param librettoVoti
	 * @param compito
	 */
	public LibrettoVotiLineItem getLibrettoVotiLineItem(LibrettoVoti librettoVoti, CompitoInClasse compito) {
		LibrettoVotiLineItem rit = null;
		for(LibrettoVotiLineItem lineItem: librettoVoti.getLibVotiLineItems()){
			if(lineItem.getCompitoInClasse() == compito){
				rit = lineItem;
			}
		}
		
		return rit;
	}
	
	public boolean esisteLineItem(LibrettoVoti librettoVoti, CompitoInClasse compito){
		boolean rit = false;
		for(LibrettoVotiLineItem lineItem: librettoVoti.getLibVotiLineItems()){
			if(lineItem.getCompitoInClasse() == compito){
				rit = true;
			}
		}
		return rit;
	}
}