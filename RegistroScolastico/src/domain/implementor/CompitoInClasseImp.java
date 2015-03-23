package domain.implementor;

import java.sql.Time;
import java.util.Collection;
import java.util.Map;

import domain.model.Argomento;
import domain.model.CompitoInClasse;
import domain.model.Studente;
import domain.model.Voto;

public class CompitoInClasseImp {

	public void setInfo(CompitoInClasse compitoInClasse, java.sql.Date data,
			Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		compitoInClasse.setData(data);
		compitoInClasse.setOraInizio(oraInizio);
		compitoInClasse.setOraFine(oraFine);

		compitoInClasse.getArgomentiEsaminati().clear();
		compitoInClasse.getArgomentiEsaminati().addAll(argomenti);
		
	}

	public void inserisciVoti(CompitoInClasse compito, Map<Studente, Voto> mapVoti) {
				
		compito.getInsegnamento().inserisciVoti(compito, mapVoti);
		
		
	}

}