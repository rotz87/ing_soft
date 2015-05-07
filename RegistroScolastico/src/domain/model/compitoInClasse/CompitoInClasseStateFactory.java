package domain.model.compitoInClasse;

import java.lang.reflect.InvocationTargetException;

import domain.error.DomainCheckedException;
import domain.error.ErrorMessage;

public class CompitoInClasseStateFactory {

	private final String packageName = CompitoInClasseState.class.getPackage().getName();
	static private CompitoInClasseStateFactory instance;

	private CompitoInClasseStateFactory() {
		
	}

	static public CompitoInClasseStateFactory getInstance() {
		if (CompitoInClasseStateFactory.instance == null) {
			CompitoInClasseStateFactory.instance = new CompitoInClasseStateFactory();
		}
		return CompitoInClasseStateFactory.instance;
	}

	public CompitoInClasseState create(String statoString) throws DomainCheckedException {
		Object obj = null;
		try {
			obj = Class.forName(this.packageName+"."+statoString).getDeclaredMethod("getInstance").invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			throw new DomainCheckedException(ErrorMessage.STATO_UNISTANZIABLE);
		}
		return (CompitoInClasseState)obj;
	}
	
	public String create(CompitoInClasseState state){
		return state.getClass().getSimpleName().toString();
	}
}
