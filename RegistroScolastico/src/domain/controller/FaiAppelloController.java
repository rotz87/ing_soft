package domain.controller;

import java.util.Collection;
import java.util.HashMap;

import org.joda.time.LocalDate;

import service.DBFake;
import domain.model.MAppello;
import domain.model.MAssenza;
import domain.model.MClasse;
import domain.model.MDocente;
import domain.model.MRegistroAssenze;
import domain.model.MStudente;

public class FaiAppelloController {
//	private Scuola scuola;

	public FaiAppelloController() {
//		scuola = new Scuola();
	}
	
	
	public void avviaAppello(Long idClasse, Long idDocente) {

		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		MDocente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
//		Stempa.stampaln("docente corrente: " + docenteCorrente.getCognome());
//		Stempa.stampaln("classe corrente: " + classeCorrente.getNome());
//		Stempa.stampaln("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			MRegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
			DBFake.getInstance().storeAppello(registroAssenzeCorrente.getAppelloOdierno());
			
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(Long[] idStudenti, Long idClasse, Long idDocente) {
		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		MDocente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			MRegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			MStudente[] studenti = new MStudente[idStudenti.length];
			int i = 0;
			for (Long idStudente : idStudenti){
				studenti[i] = DBFake.getInstance().getStudenteById(idStudente);
				i++;
				
			}
			registroAssenzeCorrente.registraAssenze(studenti);
			//manca il slavataggio delle nuove assenze sun DB!!!!!
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO A METTERE LE ASSENZE PER QUESTA CLASSE");
		}
		//manca il slavataggio delle nuove assenze sun DB!!!!!
	}
	
	public MAppello getAppelloOdierno(Long idClasse){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloOdierno();
		
	}
	
	public MAppello getAppello(Long idClasse, LocalDate data){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public MAppello getAppello(Long idClasse, Long idAppello){
		MAppello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
		
			return DBFake.getInstance().getAppelloById(idAppello);
		}else{
			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
		}
	}
	
	public Collection<MAppello> getAppelli(Long idClasse){
		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		MRegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.getAppelli().values();		
	}
	
	public boolean isAppelloOdiernoAvviabile(long idClasse){
		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		MRegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.isAppelloOdiernoAvviabile();
	}
	
	public HashMap<MStudente, Boolean>  getBoolAssenze(Long idClasse, Long idAppello){
		MAppello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<MStudente, Boolean> rit;

		if(appelloCorrente.isAssenzePrese()){

			rit = new HashMap<MStudente, Boolean>();
			MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			MRegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(MStudente studente : classeCorrente.getStudenti()){
				rit.put(studente, registroCorrente.getLibretto(studente).esisteAssenza(appelloCorrente));
				
			}
			
			return rit;
		}else{
			throw new IllegalStateException("ASSENZE NON PRESE");
		}
	}
	
	
	/**
	 * 
	 * @param idClasse
	 * @param idAppello
	 * @return Map<idStudente, Assenza>
	 */
	public HashMap<Long, MAssenza>  getAssenze(Long idClasse, Long idAppello){
		MAppello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<Long, MAssenza> rit;
		if(appelloCorrente.isAssenzePrese()){

			rit = new HashMap<Long, MAssenza>();
			MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			MRegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(MStudente studente : classeCorrente.getStudenti()){
				rit.put(studente.getId(), registroCorrente.getLibretto(studente).getAssenza(appelloCorrente));
				
			}
			
			return rit;
		}else{
			throw new IllegalStateException("ASSENZE NON PRESE");
		}
	}
	
	/**
	 * @deprecated 
	 * Deprecated perché potrebbe essere una funzionalità di un altro controllore;
	 * ma in fin dei conti si tratta di una visualizzazione e potrebbe essere anche duplicata in diverdìsi controllori
	 * @param idClasse
	 * @return
	 */
	public Collection<MStudente> getStudenti(Long idClasse){
		MClasse classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		return classeCorrente.getStudenti();
	}

}
