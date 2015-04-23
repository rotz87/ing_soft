package domain.model.compitoCommand;

import domain.error.ErrorMessage;
import domain.model.compitoInClasse.CompitoInClasse;

public class SetDaSvolgereCommand  implements CompitoCommand {

	@Override
	public void execute(CompitoInClasse compito) {
		//Lo stato saSvolgere non può essere raggiunto da nessuno stato!!
		//Il compito "nasce" daSvolgere ma poi non può più tornarci
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
		
	}

}
