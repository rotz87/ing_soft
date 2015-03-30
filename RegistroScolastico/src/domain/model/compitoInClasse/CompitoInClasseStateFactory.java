package domain.model.compitoInClasse;

import java.util.HashMap;
import java.util.Map;

public class CompitoInClasseStateFactory {

	private final Map<CompitoInClasseStateEnum, CompitoInClasseState> stati = new HashMap<CompitoInClasseStateEnum, CompitoInClasseState>();
	
	static private CompitoInClasseStateFactory instance;

	private CompitoInClasseStateFactory() {
		
		stati.put(CompitoDaSvolgere.getInstance().getStateEnum(), CompitoDaSvolgere.getInstance());
		stati.put(CompitoSvolto.getInstance().getStateEnum(), CompitoSvolto.getInstance());
		stati.put(CompitoAnnullato.getInstance().getStateEnum(), CompitoAnnullato.getInstance());
		stati.put(CompitoChiuso.getInstance().getStateEnum(), CompitoChiuso.getInstance());
		
	}

	static public CompitoInClasseStateFactory getInstance() {
		if (CompitoInClasseStateFactory.instance == null) {
			CompitoInClasseStateFactory.instance = new CompitoInClasseStateFactory();
		}
		return CompitoInClasseStateFactory.instance;
	}

	public CompitoInClasseState create(CompitoInClasseStateEnum statoEnum) {
		return stati.get(statoEnum);
	}
	
}
