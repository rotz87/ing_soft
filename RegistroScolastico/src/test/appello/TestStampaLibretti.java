package test.appello;

import java.util.List;

import domain.model.Classe;
import domain.model.ClasseCriteria;

public class TestStampaLibretti {

	public static void main(String[] args) {
		
		ClasseCriteria classeC = null;
		
		 
		try {			
			classeC = new ClasseCriteria();
			
			try {
				
				for (Classe classe :  (List<Classe>) classeC.list()) {
					System.out.println("======================== INIZIO CLASSE ========================");
					TestFaiLAppelloController1.stampaLibretti(classe);
					System.out.println("======================== FINE CLASSE ========================");
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
