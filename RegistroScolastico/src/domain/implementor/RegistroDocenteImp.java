package domain.implementor;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import service.Stampa;
import domain.controller.ErrorMessage;
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

	public void inserisciInfoCompito(RegistroDocente registroDocente, CompitoInClasse compito, Date data,
			Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
//		if(registroDocente.isCompitoPresente(compito)){
			compito.setInfo(data, oraInizio, oraFine, argomenti);
//		}else{
//			throw new IllegalStateException(ErrorMessage.COMPITO_INEXISTENT);
//		}
		
	}

	public boolean isCompitoPresente(RegistroDocente registroDocente, CompitoInClasse compito) {
		
		return registroDocente.getCompitiInClasse().contains(compito);
		
	}
	
	

}
