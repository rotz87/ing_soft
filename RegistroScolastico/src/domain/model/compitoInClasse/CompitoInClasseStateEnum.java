package domain.model.compitoInClasse;

import controller.compitoCommand.*;

public enum CompitoInClasseStateEnum {

	DA_SVOLGERE(CompitoDaSvolgere.getInstance(), null), 
	SVOLTO(CompitoSvolto.getInstance(), new SetSvoltoCommand()), 
	ANNULLATO(CompitoAnnullato.getInstance(), new AnnullaCommand()), 
	CHIUSO(CompitoChiuso.getInstance(), new ChiudiCommand());
	
	private CompitoInClasseState compitoState;
	private CompitoCommand compitoCommand;
	
	private CompitoInClasseStateEnum(CompitoInClasseState compitoState, CompitoCommand compitoCommand){
		this.compitoState = compitoState;
		this.compitoCommand = compitoCommand;
		this.compitoState.setStateEnum(this);
	}

	public CompitoInClasseState getCompitoState() {
		return compitoState;
	}

	public CompitoCommand getCompitoCommand() {
		return compitoCommand;
	}
	
	
	
}
