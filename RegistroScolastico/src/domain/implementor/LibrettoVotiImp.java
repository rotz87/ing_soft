package domain.implementor;

import service.Stampa;
import domain.controller.ErrorMessage;
import domain.model.LibrettoVoti;
import domain.model.LibrettoVotiLineItem;
import domain.model.compitoInClasse.*;

public class LibrettoVotiImp {

	/**
	 * 
	 * @param librettoVoti
	 * @param compito
	 */
	public void makeLineItem(LibrettoVoti librettoVoti, CompitoInClasse compito) {
		LibrettoVotiLineItem lineItem;
		if(librettoVoti.getLibrettoLineItem(compito) ==  null){
			lineItem = new LibrettoVotiLineItem(compito);
			librettoVoti.getLibVotiLineItems().add(lineItem);
		}
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
		
//		if(rit == null){
//			throw new IllegalStateException(ErrorMessage.COMPITO_NOT_BELONGING);
//		}
		return rit;
	}
}