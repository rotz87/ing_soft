package domain.model.compitoCommand;

import domain.model.compitoInClasse.*;

public class AnnullaCommand implements CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito) {
		compito.annulla();
	}

}