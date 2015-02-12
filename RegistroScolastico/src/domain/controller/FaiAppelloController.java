package domain.controller;

import java.util.Collection;
import java.util.HashMap;

import org.joda.time.LocalDate;

import service.DBFake;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.RegistroAssenze;
import domain.model.Studente;

public class FaiAppelloController {
//	private Scuola scuola;

	public FaiAppelloController() {
//		scuola = new Scuola();
	}
	
	
	public void avviaAppello(int idClasse, int idDocente) {

		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		Docente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
//		Stempa.stampaln("docente corrente: " + docenteCorrente.getCognome());
//		Stempa.stampaln("classe corrente: " + classeCorrente.getNome());
//		Stempa.stampaln("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
			DBFake.getInstance().storeAppello(registroAssenzeCorrente.getAppelloOdierno());
			
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(Integer[] idStudenti, int idClasse, int idDocente) {
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		Docente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			Studente[] studenti = new Studente[idStudenti.length];
			int i = 0;
			for (Integer idStudente : idStudenti){
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
	
	public Appello getAppelloOdierno(int idClasse){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloOdierno();
		
	}
	
	public Appello getAppello(int idClasse, LocalDate data){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public Appello getAppello(int idClasse, int idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
		
			return DBFake.getInstance().getAppelloById(idAppello);
		}else{
			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
		}
	}
	
	public Collection<Appello> getAppelli(int idClasse){
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.getAppelliRegistro().values();		
	}
	
	public boolean isAppelloOdiernoAvviabile(int idClasse){
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
		return registroAssenzeCorrente.isAppelloOdiernoAvviabile();
	}
	
	public HashMap<Studente, Boolean>  getBoolAssenze(int idClasse, int idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<Studente, Boolean> rit;

		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Studente, Boolean>();
			Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			RegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(Studente studente : classeCorrente.getStudenti()){
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
	public HashMap<Integer, Assenza>  getAssenze(int idClasse, int idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<Integer, Assenza> rit;
		if(appelloCorrente.getAssenzePrese()){

			rit = new HashMap<Integer, Assenza>();
			Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
			RegistroAssenze registroCorrente = classeCorrente.getRegistroAssenze();
	
			for(Studente studente : classeCorrente.getStudenti()){
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
	public Collection<Studente> getStudenti(int idClasse){
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		return classeCorrente.getStudenti();
	}

}
