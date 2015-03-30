/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model.compitoInClasse;

import domain.model.Argomento;
import domain.model.Studente;
import domain.model.Voto;

public interface CompitoInClasseState {
	public abstract void setInfo(domain.model.compitoInClasse.CompitoInClasse compitoInClasse, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<Argomento> argomenti);
	
	public abstract void inserisciVoti(domain.model.compitoInClasse.CompitoInClasse compito, java.util.Map<Studente, Voto> mapVoti);
	
	public abstract void svolgi(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void annulla(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void disannulla(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void chiudi(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract void elimina(domain.model.compitoInClasse.CompitoInClasse compitoInClasse);
	
	public abstract CompitoInClasseStateEnum getStateEnum();
	
}
//ORM Hash:afebb4641f068c64fa718856bd16ff97