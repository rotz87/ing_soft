package test;

import java.util.Collection;

import service.DBFake;
import domain.*;

public class TestStampaStudenti {

	public static void main(String[] args){
		DBFake.getInstance();
		Classe classe;
		Collection<Studente> collStud;
		System.out.println("STAMPA STUDENTI PER CLASSE ");
		for(Long i = 1L; i<5; i++){
			classe = DBFake.getInstance().getClasseById(i);
			collStud = classe.getStudenti();
			System.out.println();
			System.out.println("----- inizio classe ---------");
			System.out.println("i = " +i);
			System.out.print("idClasse = " +classe.getIdClasse());
			System.out.println(" " +classe.getNome());
			System.out.println();
			for(Studente stud : collStud){
				System.out.println("id = " +stud.getId() + " | " + stud.getNome() + " " + stud.getCognome());
			}
			
			System.out.println("----- fine classe ---------");
		}
		
		
	}
	
}
