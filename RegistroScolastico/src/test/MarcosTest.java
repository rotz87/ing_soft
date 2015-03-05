package test;

import org.joda.time.LocalDate;

import service.Stampa;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.LibrettoAssenze;
import domain.model.LibrettoAssenzeCriteria;

public class MarcosTest {
	
	
	static public void stampaLibretto(LibrettoAssenze librettoAssenze){
		  for (Assenza assNG : librettoAssenze.getNonGiustificate()) {
			  Stampa.stampaln("---------Inizio Assenza-------- ");
			  for (Appello app : assNG.getAppelli()){
				  Stampa.stampaln("data dell'appello dell'assenza : "+app.getData().toString());
			  }
			  if(assNG.isCertificatoMedicoRichiesto()){
				  Stampa.stampaln(" \n E' richiesto il certificato medico !! \n");  
			  }
			  Stampa.stampaln("-------Fine Assenza--------\n");
				
			}
	}

	public static void main(String[] args) {
		
		LibrettoAssenze librettoIvo = null;
		Appello appello = null;

		try {			
			LibrettoAssenzeCriteria librettoAssenzeCriteria = new LibrettoAssenzeCriteria();
			
			
			
			try {
				librettoAssenzeCriteria.studenteId.eq(5);
				librettoIvo = librettoAssenzeCriteria.uniqueLibrettoAssenze();
				
				stampaLibretto(librettoIvo);
				
//				appello = new Appello(new LocalDate(2014,12,10));
//				librettoIvo.segnaAssenza(appello);
//				
//				System.out.println("======================== Dopo segna assenza1 ========================");
//				stampaLibretto(librettoIvo);
				
				appello = new Appello(new LocalDate(2014,12,17));
				librettoIvo.segnaAssenza(appello);
				
				System.out.println("======================== Dopo segna assenza2 ========================");
				stampaLibretto(librettoIvo);
				
				appello = new Appello(new LocalDate(2014,12,18));
				librettoIvo.segnaAssenza(appello);
				
				System.out.println("======================== Dopo segna assenza3 ========================");
				stampaLibretto(librettoIvo);
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
