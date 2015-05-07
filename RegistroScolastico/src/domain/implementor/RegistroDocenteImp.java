package domain.implementor;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.joda.time.LocalDate;

import domain.error.ErrorMessage;
import domain.model.Argomento;
import domain.model.Classe;
import domain.model.LibrettoVotiLineItem;
import domain.model.RegistroAssenze;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.mediaStrategy.IMediaStrategy;

public class RegistroDocenteImp {

	public CompitoInClasse creaCompito(RegistroDocente registroDocente) {
		CompitoInClasse compito;
		Set<CompitoInClasse> compitiInClasse;
		
		compito = new CompitoInClasse(registroDocente);
		
		compitiInClasse = registroDocente.getCompitiInClasse();
		compitiInClasse.add(compito);
		
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

	public void eliminCompito(RegistroDocente registroDocente, CompitoInClasse compitoInClasse) {
		registroDocente.getCompitiInClasse().remove(compitoInClasse);		
	}

	public boolean contain(RegistroDocente registroDocente,	CompitoInClasse compito) {
		return registroDocente.getCompitiInClasse().contains(compito);
	}

	public boolean haClasse(RegistroDocente registroDocente, Classe classe) {
		return registroDocente.getClasse().equals(classe);
	}
	
	private java.util.Map<Studente, java.util.Collection<Voto>> getVotiScritto(RegistroDocente registroDocente, java.sql.Date dataInizio, java.sql.Date dataFine) {
		 Map<Studente, Collection<Voto>> rit = new HashMap<Studente, Collection<Voto>>();
		 Classe classe;
		 LocalDate lDataInizio;
		 LocalDate lDataFine;
		 LocalDate lDataCompito;
		 LibrettoVotiLineItem libVotiLI;
		 
		 classe = registroDocente.getClasse();
		 lDataInizio = new LocalDate(dataInizio);
		 lDataFine = new LocalDate(dataFine);
		
		for(Studente studente: classe.getStudenti()){
			Collection<Voto> collectionVoti = new LinkedList<Voto>();
			for(CompitoInClasse compito : registroDocente.getCompitiInClasse()){
				lDataCompito = new LocalDate(compito.getData());
				libVotiLI = studente.getLibrettoVoti().getLibrettoLineItem(compito);
				if(libVotiLI != null && (lDataCompito.isAfter(lDataInizio) || lDataCompito.isEqual(lDataInizio)) && (lDataCompito.isBefore(lDataFine) || lDataCompito.isEqual(lDataFine))){
					collectionVoti.add(libVotiLI.getVoto());
				}
			}
			rit.put(studente, collectionVoti);
		}
		
		return rit;
	}

	private java.util.Map<Studente, java.util.Collection<Voto>> getVotiOrali(java.sql.Date dataInizio, java.sql.Date dataFine) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	private java.util.Map<Studente, java.util.Collection<Voto>> getVotiMisti(java.sql.Date dataInizio, java.sql.Date dataFine) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}

	public Map<Studente, Voto> calcolaMediaScritto(RegistroDocente registroDocente, Date dataInizio, Date dataFine) {
		 Map<Studente, Collection<Voto>> mapVotiScritto;
		 IMediaStrategy strategia = registroDocente.getMediaStrategy();
		 Voto mediaScritto;
		 Map<Studente, Voto> rit;

		 
		 rit = new HashMap<Studente, Voto>();
		 mapVotiScritto = getVotiScritto(registroDocente, dataInizio, dataFine);
		
		 for(Studente studente : mapVotiScritto.keySet()){
			 mediaScritto = strategia.calcolaMedia(mapVotiScritto.get(studente));
			 rit.put(studente, mediaScritto);
		 }
		 
		return rit;
	}


}
