package domain;

import service.DBFake;

public class FaiAppelloController {
//	private Scuola scuola;

	public FaiAppelloController() {
//		scuola = new Scuola();
	}
	
	
	public void avviaAppello(Long idClasse, Long idDocente) {
		Classe classeCorrente = DBFake.getInstance().getCalsseById(idClasse);
		Docente docenteCorrente = DBFake.getInstance().getDocenteById(idDocente);
		
//		System.out.println("docente corrente: " + docenteCorrente.getCognome());
//		System.out.println("classe corrente: " + classeCorrente.getNome());
//		System.out.println("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public void registraAssenze(Long[] idStudenti, Long idClasse, Long idDocente) {
		Classe classeCorrente = DBFake.getInstance().getCalsseById(idClasse);
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

}