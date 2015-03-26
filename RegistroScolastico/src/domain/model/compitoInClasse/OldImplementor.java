package domain.model.compitoInClasse;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Map;

import domain.model.Argomento;
import domain.model.Studente;
import domain.model.Voto;

public class OldImplementor extends CompitoInClasseState {

	static private OldImplementor instance;

	private OldImplementor() {
	}

	static public OldImplementor getInstance() {
		if (OldImplementor.instance == null) {
			OldImplementor.instance = new OldImplementor();
		}
		return OldImplementor.instance;
	}
	
	@Override
	public void setInfo(CompitoInClasse compitoInClasse, Date data,
			Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		compitoInClasse.set_data(data);
		compitoInClasse.set_oraInizio(oraInizio);
		compitoInClasse.set_oraFine(oraFine);

		compitoInClasse.get_argomentiEsaminati().clear();
		compitoInClasse.get_argomentiEsaminati().addAll(argomenti);
	}

	@Override
	public void inserisciVoti(CompitoInClasse compito,
			Map<Studente, Voto> mapVoti) {
		compito.get_insegnamento().inserisciVoti(compito, mapVoti);

	}

}
