package test;

import java.util.Iterator;
import java.util.Map.Entry;
import org.joda.time.LocalDate;

import domain.*;
import service.*;

public class TestAvviaAppello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate dataTest = new LocalDate(2014,12,16);
		Appello appelloPrecedente = new Appello(dataTest);
		
		RegistroAssenzeController regAssCtrl = FactoryHandler.getInstance().getRegistroAssenzeFactory().createRegistroAssenze(null);
		
		regAssCtrl.setAppelloOdierno(appelloPrecedente);
		regAssCtrl.getAppelli().put(appelloPrecedente.getDataL(), appelloPrecedente);

		try{
			regAssCtrl.avviaAppello();//cambiare, usare il nuovo controller
		}catch(IllegalStateException ISE){
			System.out.println(ISE.getMessage()+"prima eccezione" );
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
//				  Long idAppello = (Long)thisEntry.getKey();
				  Appello appello = (Appello)thisEntry.getValue();
				  
				  System.out.println("data : " + appello.getDataL() );
				  System.out.println("Appello : " + appello );
				  System.out.println("--------------------: " );
			}
			System.out.println();
	}

}
