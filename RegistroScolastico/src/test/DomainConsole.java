package test;
import domain.*;

public class DomainConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("prova");
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		regAssCtrl.avviaAppello();
//		if ( regAssCtrl.getAppelloOdierno()!= null){
			System.out.println("la data è : "+ regAssCtrl.getAppelloOdierno().getData().toString());

//		}

	}

}
