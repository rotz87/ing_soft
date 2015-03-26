package domain.model.compitoInClasse;

public class CompitoAnnullato extends CompitoInClasseStateImp {
	
	static private CompitoAnnullato instance;

	private CompitoAnnullato() {
	}

	static public CompitoAnnullato getInstance() {
		if (CompitoAnnullato.instance == null) {
			CompitoAnnullato.instance = new CompitoAnnullato();
		}
		return CompitoAnnullato.instance;
	}
	
	@Override
	public void disannulla(CompitoInClasse compitoInClasse) {
		compitoInClasse.set_state(CompitoSvolto.getInstance());
	}
}