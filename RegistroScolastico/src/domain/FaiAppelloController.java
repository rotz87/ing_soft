package domain;

import org.joda.time.LocalDate;

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
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO A METTERE LE ASSENZE PER QUESTA CLASSE");
		}
		
	}
	
	public Appello getAppelloOdierno(Long idClasse){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloOdierno();
		
	}
	
	public Appello getAppello(Long idClasse, LocalDate data){
		
		return DBFake.getInstance().getClasseById(idClasse).getRegistroAssenze().getAppelloByData(data);
		
	}
	
	public Appello getAppello(Long idClasse, long idAppello){
		Appello appelloCorrente = DBFake.getInstance().getAppelloById(idAppello);
		Classe classeCorrente = DBFake.getInstance().getClasseById(idClasse);
		
		if ( classeCorrente.getRegistroAssenze().esisteAppello(appelloCorrente)){
		
			return DBFake.getInstance().getAppelloById(idAppello);
		}else{
			throw new IllegalStateException("L'appello selezionato non appartiene alla classe selezionata");
		}
	}

}