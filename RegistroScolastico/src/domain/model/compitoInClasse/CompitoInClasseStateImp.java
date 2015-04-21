package domain.model.compitoInClasse;

import org.apache.tomcat.jni.Error;

import domain.error.ErrorMessage;
import domain.model.*;

public abstract class CompitoInClasseStateImp implements CompitoInClasseState {

	
	/**
	 * 
	 * @param compitoInClasse
	 * @param data
	 * @param oraInizio
	 * @param oraFine
	 * @param argomenti
	 */
	public void setInfo(CompitoInClasse compitoInClasse, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<Argomento> argomenti) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}

	/**
	 * 
	 * @param compito
	 * @param mapVoti
	 */
	public void inserisciVoti(CompitoInClasse compito, java.util.Map<Studente, Voto> mapVoti) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}


	/**
	 * 
	 * @param compitoInClasse
	 */
	public void annulla(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void chiudi(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void elimina(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void setSvolto(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(ErrorMessage.WRONG_STATE);
	}

	public CompitoInClasseStateEnum getStateEnum() {
		throw new UnsupportedOperationException();
	}
	
	public void setStateEnum(CompitoInClasseStateEnum stateEmum){
		throw new UnsupportedOperationException();
	}
}