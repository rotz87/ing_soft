package domain.model.compitoCommand;

import domain.model.compitoInClasse.*;

public interface CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito);

}