package domain.model.compitoInClasse;

public class CompitoChiuso extends CompitoInClasseStateImp {
	
	static private CompitoChiuso instance;

	private CompitoChiuso() {
	}

	static public CompitoChiuso getInstance() {
		if (CompitoChiuso.instance == null) {
			CompitoChiuso.instance = new CompitoChiuso();
		}
		return CompitoChiuso.instance;
	}
}