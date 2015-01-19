package domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.joda.time.LocalDate;

import scala.collection.Map;
import service.DBFake;

public class FaiAppelloController {
//	private Scuola scuola;

	public FaiAppelloController() {
//		scuola = new Scuola();
	}
	
	
	public void avviaAppello(Long idClasse, Long idDocente) {

		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		Docente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
//		System.out.println("docente corrente: " + docenteCorrente.getCognome());
//		System.out.println("classe corrente: " + classeCorrente.getNome());
//		System.out.println("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
			DBFake.getInstance().storeAppello(registroAssenzeCorrente.getAppelloOdierno());
			
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(Long[] idStudenti, Long idClasse, Long idDocente) {
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		Docente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			Studente[] studenti = new Studente[idStudenti.length];
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
	
	public Appello getAppelloOdierno(Long idClasse){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloOdierno();
		
	}
	
	public Appello getAppello(Long idClasse, LocalDate data){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public Appello getAppello(Long idClasse, Long idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
		
			return DBFake.getInstance().getAppelloById(idAppello);
		}else{
			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
		}
	}
	
	public HashMap<Studente, Boolean>  getBoolAssenze(Long idClasse, Long idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<Studente, Boolean> rit;
		if(appelloCorrente.isAssenzePrese()){

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
	
	public HashMap<Long, Assenza>  getAssenze(Long idClasse, Long idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		HashMap<Long, Assenza> rit;
		if(appelloCorrente.isAssenzePrese()){

			rit = new HashMap<Long, Assenza>();
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
	
	public Collection getStudenti(Long idClasse){
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		return classeCorrente.getStudenti();
	}

}