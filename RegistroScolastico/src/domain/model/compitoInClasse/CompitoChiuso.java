package domain.model.compitoInClasse;

import domain.model.compitoCommand.ChiudiCommand;

public class CompitoChiuso extends CompitoInClasseStateImp {
	
	static private CompitoChiuso instance;

	private CompitoChiuso() {
		super.compitoCommand = new ChiudiCommand();
	}

	static public CompitoChiuso getInstance() {
		if (CompitoChiuso.instance == null) {
			CompitoChiuso.instance = new CompitoChiuso();
		}
		return CompitoChiuso.instance;
	}

	public boolean isChiuso(){
		return true;
	}
}