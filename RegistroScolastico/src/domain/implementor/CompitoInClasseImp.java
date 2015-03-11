package domain.implementor;

import java.sql.Time;
import java.util.Collection;


import domain.model.Argomento;
import domain.model.CompitoInClasse;

public class CompitoInClasseImp {

	public void setInfo(CompitoInClasse compitoInClasse, java.sql.Date data,
			Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		compitoInClasse.setData(data);
		compitoInClasse.setOraInizio(oraInizio);
		compitoInClasse.setOraFine(oraFine);
		compitoInClasse.setArgomentiEsaminati((java.util.Set<Argomento>)argomenti);
		
	}

}