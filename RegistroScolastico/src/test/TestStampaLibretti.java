package test;

import java.util.List;

import org.joda.time.LocalDate;

import domain.model.Appello;
import domain.model.LibrettoAssenzeCriteria;
import domain.model.RegistroAssenze;
import domain.model.RegistroAssenzeCriteria;

public class TestStampaLibretti {

	public static void main(String[] args) {
		
		RegistroAssenzeCriteria registroAC = null;
		
		try {			
			registroAC = new RegistroAssenzeCriteria();
			
			try {
				
				for (RegistroAssenze registroAssenze :  (List<RegistroAssenze>) registroAC.list()) {
					System.out.println("======================== INIZIO CLASSE ========================");
					TestFaiLAppelloController1.stampaLibretti(registroAssenze);
					System.out.println("======================== FINE CLASSE ========================");
				}
			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
