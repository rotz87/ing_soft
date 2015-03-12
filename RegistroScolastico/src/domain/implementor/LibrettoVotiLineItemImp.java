package domain.implementor;

import domain.model.CompitoInClasse;
import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;

public class LibrettoVotiLineItemImp {

	public void inizialize(LibrettoVotiLineItem lineItem, CompitoInClasse compito) {
		lineItem.setCompitoInClasse(compito);
		
	}

	public void inizialize(LibrettoVotiLineItem lineItem, CompitoInClasse compito, Voto voto) {
		inizialize(lineItem, compito);
		lineItem.setVoto(voto);
		
	}

	public void aggiungiVoto(LibrettoVotiLineItem lineItem, Voto voto) {
		lineItem.setVoto(voto);
		
	}


}