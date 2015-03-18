package domain.implementor;

import java.sql.Time;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;




import java.util.Map;

import org.joda.time.LocalDate;




import service.Stampa;
import domain.controller.ErrorMessage;
import domain.model.Argomento;
import domain.model.CompitoInClasse;
import domain.model.RegistroAssenze;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;

public class RegistroDocenteImp {

	public CompitoInClasse creaCompito(RegistroDocente registroDocente) {
		CompitoInClasse compito;
		
		compito = new CompitoInClasse();
		compito.setInsegnamento(registroDocente);
		registroDocente.getCompitiInClasse().add(compito);
		
		return compito;
	}

	public void inserisciInfoCompito(RegistroDocente registroDocente, CompitoInClasse compito, java.sql.Date data,
			Time oraInizio, Time oraFine, Collection<Argomento> argomenti) {
		
		if(registroDocente.isCompitoPresente(compito)){
			compito.setInfo(data, oraInizio, oraFine, argomenti);
		}else{
			throw new IllegalStateException(ErrorMessage.COMPITO_INEXISTENT);
		}
		
	}

	public boolean isCompitoPresente(RegistroDocente registroDocente, CompitoInClasse compito) {
		
		return registroDocente.getCompitiInClasse().contains(compito);
		
	}

	public void inserisciVoti(RegistroDocente registroDocente, CompitoInClasse compito, Map<Studente, Voto> mapVoti ) {
		RegistroAssenze registroAssezne = registroDocente.getClasse().getRegistroAssenze();
		LocalDate data = new LocalDate(compito.getData());
		if(registroAssezne.checkPresenti(data, mapVoti.keySet())){
			for (Studente studente : mapVoti.keySet()) {
			    studente.getLibrettoVoti().makeLineItem(compito);
			    studente.getLibrettoVoti().getLibrettoLineItem(compito).aggiungiVoto(mapVoti.get(studente));
			}
		}else{
			throw new IllegalStateException(ErrorMessage.LISTA_STUDENTI_WRONG);
		}
		
	}
	
	

}
