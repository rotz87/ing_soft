package domain.implementor;

import java.sql.Time;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;




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
//		if(registroDocente.isCompitoPresente(compito)){
			compito.setInfo(data, oraInizio, oraFine, argomenti);
//		}else{
//			throw new IllegalStateException(ErrorMessage.COMPITO_INEXISTENT);
//		}
		
	}

	public boolean isCompitoPresente(RegistroDocente registroDocente, CompitoInClasse compito) {
		
		return registroDocente.getCompitiInClasse().contains(compito);
		
	}

	public void inserisciVoti(RegistroDocente registroDocente, CompitoInClasse compito, Studente[] studenti, Voto[] voti) {
		Collection<Studente> studentiCollection = new LinkedList<Studente>();
		Collection<Voto> votiCollection = new LinkedList<Voto>();
		
		for(Studente studente: studenti){
			studentiCollection.add(studente);
		}
		for(Voto voto: voti){
			votiCollection.add(voto);
		}
		
		RegistroAssenze registroAssezne = registroDocente.getClasse().getRegistroAssenze();
		LocalDate data = new LocalDate(compito.getData());
		if(registroAssezne.checkPresenti(data, studentiCollection)){
			Iterator<Studente> iteratorStud = studentiCollection.iterator();
			Iterator<Voto> iteratorVoto = votiCollection.iterator();

			while(iteratorStud.hasNext() && iteratorVoto.hasNext()) {
			    Studente studente = iteratorStud.next();
			    Voto voto = iteratorVoto.next();
			    studente.getLibrettoVoti().makeLineItem(compito);
			    studente.getLibrettoVoti().getLibrettoLineItem(compito).aggiungiVoto(voto);
			}
//			while(iteratorStud.hasNext()) {
//			    Studente studente = iteratorStud.next();
//
//			    studente.getLibrettoVoti().makeLineItem(compito);
//			    
//
//			}
//			iteratorStud = studentiCollection.iterator();
//			while(iteratorStud.hasNext() && iteratorVoto.hasNext()) {
//			    Studente studente = iteratorStud.next();
//			    Voto voto = iteratorVoto.next();
////			    studente.getLibrettoVoti().makeLineItem(compito);
//			    studente.getLibrettoVoti().getLibrettoLineItem(compito).aggiungiVoto(voto);
//			}
			
			
		}else{
			throw new IllegalStateException(ErrorMessage.LISTA_STUDENTI_WRONG);
		}
		
	}
	
	

}
