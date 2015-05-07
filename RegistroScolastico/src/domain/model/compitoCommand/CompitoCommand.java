package domain.model.compitoCommand;

import domain.model.compitoInClasse.CompitoInClasse;

public interface CompitoCommand {

	/**
	 * 
	 * @param compito
	 */
	public void execute(CompitoInClasse compito);

}