package domain.model.compitoInClasse;

import domain.model.compitoCommand.ChiudiCommand;
import domain.model.compitoCommand.CompitoCommand;

public class CompitoChiuso extends CompitoInClasseStateImp {
	
	static private CompitoChiuso instance;
	
//	private CompitoInClasseStateEnum stateEnum;//final = CompitoInClasseStateEnum.CHIUSO;

	private CompitoChiuso() {
		super.compitoCommand = new ChiudiCommand();
	}

	static public CompitoChiuso getInstance() {
		if (CompitoChiuso.instance == null) {
			CompitoChiuso.instance = new CompitoChiuso();
		}
		return CompitoChiuso.instance;
	}
	
//	@Override
//	public CompitoInClasseStateEnum getStateEnum() {
//		return this.stateEnum;
//	}
//	public void setStateEnum(CompitoInClasseStateEnum stateEmum){
//		this.stateEnum = stateEmum;
//	}
	

}