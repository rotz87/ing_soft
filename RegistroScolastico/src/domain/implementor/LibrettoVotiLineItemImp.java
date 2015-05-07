package domain.implementor;

import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;
import domain.model.compitoInClasse.CompitoInClasse;

public class LibrettoVotiLineItemImp {

	/**
	 * 
	 * @param lineItem
	 * @param compito
	 */
	public void inizialize(LibrettoVotiLineItem lineItem, CompitoInClasse compito) {
		lineItem.setCompitoInClasse(compito);
		
	}

	/**
	 * 
	 * @param lineItem
	 * @param compito
	 * @param voto
	 */
	public void inizialize(LibrettoVotiLineItem lineItem, CompitoInClasse compito, Voto voto) {
		inizialize(lineItem, compito);
		lineItem.setVoto(voto);
		
	}

	/**
	 * 
	 * @param lineItem
	 * @param voto
	 */
	public void aggiungiVoto(LibrettoVotiLineItem lineItem, Voto voto) {
		Voto votoAttuale;
		
		votoAttuale = lineItem.getVoto();
		if(votoAttuale == null){
			votoAttuale = new Voto();
			votoAttuale.setVoto(voto);
			lineItem.setVoto(votoAttuale);
		}else{
			votoAttuale.setVoto(voto);
		}

	}


}