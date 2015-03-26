/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model.compitoInClasse;

public class CompitoInClasseState {
	public void setInfo(domain.model.compitoInClasse.CompitoInClasse compitoInClasse, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<domain.model.Argomento> argomenti) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void inserisciVoti(domain.model.compitoInClasse.CompitoInClasse compito, java.util.Map<domain.model.Studente, domain.model.Voto> mapVoti) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setInsegnamento(domain.model.compitoInClasse.CompitoInClasse compito, domain.model.RegistroDocente registroDocente) {
		compito.set_insegnamento(registroDocente);
	}
	
}
//ORM Hash:397c454b7523be5e384d64339c14840b