package domain.model.compitoInClasse;

import org.apache.tomcat.jni.Error;

import domain.controller.ErrorMessage;
import domain.model.*;

public abstract class CompitoInClasseStateImp implements CompitoInClasseState {

	protected final String WRONG_STATE =" Lo stato del compito non consente di eseguire l'operazione richiesta ";
	/**
	 * 
	 * @param compitoInClasse
	 * @param data
	 * @param oraInizio
	 * @param oraFine
	 * @param argomenti
	 */
	public void setInfo(CompitoInClasse compitoInClasse, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<Argomento> argomenti) {
		throw new IllegalStateException(WRONG_STATE);
	}

	/**
	 * 
	 * @param compito
	 * @param mapVoti
	 */
	public void inserisciVoti(CompitoInClasse compito, java.util.Map<Studente, Voto> mapVoti) {
		throw new IllegalStateException(WRONG_STATE);
	}


	/**
	 * 
	 * @param compitoInClasse
	 */
	public void annulla(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void disannulla(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void chiudi(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void elimina(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(WRONG_STATE);
	}

	/**
	 * 
	 * @param compitoInClasse
	 */
	public void svolgi(CompitoInClasse compitoInClasse) {
		throw new IllegalStateException(WRONG_STATE);
	}
}