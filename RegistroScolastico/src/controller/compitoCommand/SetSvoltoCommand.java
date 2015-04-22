package controller.compitoCommand;

import domain.model.compitoInClasse.*;

public class SetSvoltoCommand implements CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito) {
		compito.setSvolto();
	}

}