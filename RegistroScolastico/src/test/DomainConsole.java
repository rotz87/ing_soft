package test;
import java.util.Calendar;

import domain.*;

public class DomainConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("prova");
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		regAssCtrl.avviaAppello();
//		if ( regAssCtrl.getAppelloOdierno()!= null){
			System.out.println("la data è : "+ regAssCtrl.getAppelloOdierno().getData().toString());
			Calendar cal = regAssCtrl.getAppelloOdierno().getDataCalendar();
			int gg = cal.get(Calendar.DAY_OF_MONTH);
			int mm = cal.get(Calendar.MONTH);
			int aa = cal.get(Calendar.YEAR);
			System.out.println("la data calendar è " + gg + "/" + mm + "/" + aa );
	

	}

}
