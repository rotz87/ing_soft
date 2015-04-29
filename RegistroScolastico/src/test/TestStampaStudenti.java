package test;

import java.util.Collection;

import org.orm.PersistentException;

import sviluppo.Stampa;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Studente;

public class TestStampaStudenti {

	public static void main(String[] args){
		try{
			ClasseCriteria classeC;
			Classe classe;
			Collection<Studente> collStud;
			Stampa.stampaln("STAMPA STUDENTI PER CLASSE ");
			for(int i = 1; i<5; i++){
				
	//			classe = DBFake.getInstance().getClasseById(i);
				classeC = new ClasseCriteria();
				classeC.ID.eq(i);
				classe = classeC.uniqueClasse();
				Stampa.stampaln("Classe: "+classe);
				
				collStud = classe.getStudenti();
				Stampa.stampaln();
				Stampa.stampaln("----- inizio classe ---------");
				Stampa.stampaln("i = " +i);
				Stampa.stampa("idClasse = " +classe.getID());
				Stampa.stampaln(" " +classe.getNome());
				Stampa.stampaln();
				for(Studente stud : collStud){
					Stampa.stampaln("id = " +stud.getID() + " | " + stud.getNome() + " " + stud.getCognome());
				}
				
				Stampa.stampaln("----- fine classe ---------");
			}
		}catch(PersistentException e){
			e.printStackTrace();
		}
		
	}
	
}
