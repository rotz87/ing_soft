package domain.model.compitoInClasse;

import domain.model.compitoCommand.AnnullaCommand;

public class CompitoAnnullato extends CompitoInClasseStateImp {
	
	static private CompitoAnnullato instance;	

	private CompitoAnnullato() {
		super.compitoCommand = new AnnullaCommand();
	}

	static public CompitoAnnullato getInstance() {
		if (CompitoAnnullato.instance == null) {
			CompitoAnnullato.instance = new CompitoAnnullato();
		}
		return CompitoAnnullato.instance;
	}
	
	@Override
	public void setSvolto(CompitoInClasse compitoInClasse) {
		compitoInClasse.set_state(CompitoSvolto.getInstance());
	}

}