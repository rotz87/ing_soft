package domain.model.compitoCommand;

import domain.model.compitoInClasse.CompitoInClasse;

public class SetSvoltoCommand implements CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito) {
		compito.setSvolto();
	}

}