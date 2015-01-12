package domain;

import java.nio.channels.IllegalSelectorException;

public class FaiAppelloController {
	private Scuola scuola;

	public FaiAppelloController() {
		scuola = new Scuola();
	}
	
	public void avviaAppello(Long idClasse, Long idDocente) {
		Classe classeCorrente = scuola.getCalsseById(idClasse);
		Docente docenteCorrente = scuola.getDocenteById(idDocente);
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(String[] idStudenti, Long idClasse, Long idDocente) {
		Classe classeCorrente = scuola.getCalsseById(idClasse);
		Docente docenteCorrente = scuola.getDocenteById(idDocente);
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			Studente[] studenti = new Studente[0];
			int i = 0;
			for (String idStudente : idStudenti){
				//da modificare quando la classe avrà lìelenco degli studenti!!!
				studenti[i] = registroAssenzeCorrente.getLibrettiAssenze().get(idStudente).getStudente();
				i++;
			}
			registroAssenzeCorrente.registraAssenze(studenti);
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}

}