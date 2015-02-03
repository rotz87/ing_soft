package test;

import java.util.Collection;

import service.DBFake;
import service.Stampa;
import domain.model.MClasse;
import domain.model.MStudente;

public class TestStampaStudenti {

	public static void main(String[] args){
		DBFake.getInstance();
		MClasse classe;
		Collection<MStudente> collStud;
		Stampa.stampaln("STAMPA STUDENTI PER CLASSE ");
		for(Long i = 1L; i<5; i++){
			classe = DBFake.getInstance().getClasseById(i);
			collStud = classe.getStudenti();
			Stampa.stampaln();
			Stampa.stampaln("----- inizio classe ---------");
			Stampa.stampaln("i = " +i);
			Stampa.stampa("idClasse = " +classe.getIdClasse());
			Stampa.stampaln(" " +classe.getNome());
			Stampa.stampaln();
			for(MStudente stud : collStud){
				Stampa.stampaln("id = " +stud.getId() + " | " + stud.getNome() + " " + stud.getCognome());
			}
			
			Stampa.stampaln("----- fine classe ---------");
		}
		
		
	}
	
}
