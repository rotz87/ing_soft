/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model.compitoInClasse;

import domain.model.Argomento;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoCommand.CompitoCommand;

public interface CompitoInClasseState {
	public abstract void setInfo(domain.model.compitoInClasse.CompitoInClasse compitoInClasse, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<Argomento> argomenti);
	
	public abstract void inserisciVoti(domain.model.compitoInClasse.CompitoInClasse compito, java.util.Map<Studente, Voto> mapVoti);
	
	public abstract void setSvolto(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void annulla(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void chiudi(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void elimina(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
//	public abstract domain.model.compitoInClasse.CompitoInClasseStateEnum getStateEnum();
//	
//	public abstract void setStateEnum(CompitoInClasseStateEnum stateEmum);
	
	public abstract CompitoCommand getCompitoCommand();
	
	
	
}
//ORM Hash:b668739f755106798c4b0ecd2dbf889f