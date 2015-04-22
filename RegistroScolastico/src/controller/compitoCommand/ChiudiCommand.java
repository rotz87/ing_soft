package controller.compitoCommand;

import domain.model.compitoInClasse.*;

public class ChiudiCommand implements CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito) {
		compito.chiudi();
	}

}