package domain.implementor;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import domain.model.Argomento;
import domain.model.CompitoInClasse;
import domain.model.RegistroDocente;

public class RegistroDocenteImp {

	public CompitoInClasse creaCompito(RegistroDocente registroDocente) {
		CompitoInClasse compito;
		
		compito = new CompitoInClasse();
		compito.setInsegnamento(registroDocente);
		registroDocente.getCompitiInClasse().add(compito);
		
		return compito;
	}

	public void inserisciInfoCompito(RegistroDocente registroDocente,
			CompitoInClasse compito, Date data, Time oraInizio, Time oraFine,
			Collection<Argomento> argomenti) {
		// TODO Auto-generated method stub
		
	}

	public boolean isCompitoPresente(RegistroDocente registroDocente,
			CompitoInClasse compito) {
		// TODO Auto-generated method stub
		return true;
		
	}
	
	

}
