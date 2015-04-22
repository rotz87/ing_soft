package domain.model.compitoInClasse;

public class CompitoAnnullato extends CompitoInClasseStateImp {
	
	static private CompitoAnnullato instance;
	
	private CompitoInClasseStateEnum stateEnum;//final = CompitoInClasseStateEnum.ANNULLATO;

	private CompitoAnnullato() {
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
	
	@Override
	public CompitoInClasseStateEnum getStateEnum() {
		return this.stateEnum;
	}
	
	public void setStateEnum(CompitoInClasseStateEnum stateEmum){
		this.stateEnum = stateEmum;
	}
}