package test;

import java.util.HashMap;
import java.util.Map;

import domain.*;

public class TestRegistraAssenze {
	public static void main(String[] args) {
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		
		Map<String, LibrettoAssenze> librettiDaAssegnare;
		librettiDaAssegnare = new HashMap<String, LibrettoAssenze>();
		
		librettiDaAssegnare.put("maccio", new LibrettoAssenze(new Studente("Maccio", "Capatonda")));
		librettiDaAssegnare.put("Herbert", new LibrettoAssenze(new Studente("Herbert", "Ballerina")));
		librettiDaAssegnare.put("Ivo", new LibrettoAssenze(new Studente("Ivo", "Avido")));
		librettiDaAssegnare.put("Piero", new LibrettoAssenze(new Studente("Piero", "Peluria")));
		librettiDaAssegnare.put("Marino", new LibrettoAssenze(new Studente("Marino", "Peluria")));
		
		regAssCtrl.assengaLibretti(librettiDaAssegnare);
		
		String[] listaIdStud = {"Maccio","Piero","Ivo"};
		
		
		regAssCtrl.registraAssenze(listaIdStud);
	}

}
