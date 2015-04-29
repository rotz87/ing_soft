package test.appello;

import java.util.Collection;

import org.joda.time.LocalDate;

import controller.FaiAppelloController;
import sviluppo.Stampa;
import domain.model.Studente;
import domain.model.StudenteCriteria;

public class TestGetPresenti {

	public static void main(String[] args) {
		
		
	try {
			
			try {
				FaiAppelloController appelloController = new FaiAppelloController();
				
				
				
				Collection<Studente> presenti = appelloController.getSoloPresenti(1, new LocalDate(2014,12,16));
				
				for(Studente stud : presenti){
					Stampa.stampaln("Studente "+ stud.getID()+" " + stud.getNome()+" "+stud.getCognome());
				}
			}
			finally {
				service.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
