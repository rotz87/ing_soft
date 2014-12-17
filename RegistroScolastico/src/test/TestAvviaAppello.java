package test;

import java.util.Iterator;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import domain.*;

public class TestAvviaAppello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate dataTest = new LocalDate(2014,12,16);
		Appello appelloPrecedente = new Appello(dataTest);
		
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		
		regAssCtrl.setAppelloOdierno(appelloPrecedente);
		regAssCtrl.getAppelli().put(dataTest, appelloPrecedente);
		
		try{
			regAssCtrl.avviaAppello();
		}catch(IllegalStateException ISE){
			System.out.println(ISE.getMessage() );
		}
		
//		if ( regAssCtrl.getAppelloOdierno()!= null){
//			System.out.println("la data è : "+ regAssCtrl.getAppelloOdierno().getData().toString());
			LocalDate dataAppello = regAssCtrl.getAppelloOdierno().getDataL();
			int gg = dataAppello.getDayOfMonth();
			int mm = dataAppello.getMonthOfYear();
			int aa = dataAppello.getYear();
			System.out.println("la LocalDate è " + gg + "/" + mm + "/" + aa );
			try{
				regAssCtrl.avviaAppello();
			}catch(IllegalStateException ISE){
				System.out.println(ISE.getMessage() );
			}

			System.out.println();
			System.out.println("APPELLI REGISTRATI NEL REGISTRO: " );
			System.out.println();
			
			Iterator entries = regAssCtrl.getAppelli().entrySet().iterator();
			while (entries.hasNext()) {
				  Entry thisEntry = (Entry) entries.next();
				  LocalDate data = (LocalDate)thisEntry.getKey();
				  Appello appello = (Appello)thisEntry.getValue();
				  
				  System.out.println("data : " + data );
				  System.out.println("Appello : " + appello );
				  System.out.println("--------------------: " );
			}
			System.out.println();
	}

}
