package service;

import domain.Classe;
import domain.RegistroAssenzeController;

public class TestRegistroAssenzeFactory extends RegistroAssenzeFactory {

	private static TestRegistroAssenzeFactory instance;

	private RegistroAssenzeController registroAssenzeController;
	
	private TestRegistroAssenzeFactory() {
	}

	public static TestRegistroAssenzeFactory getInstance() {
		if (TestRegistroAssenzeFactory.instance == null) {
			TestRegistroAssenzeFactory.instance = new TestRegistroAssenzeFactory();
		}
		return TestRegistroAssenzeFactory.instance;
	}
	
	
	
	/**
	 * crea un RegistroAssenzeController singleton,
	 * senza considerare una classe.
	 * 
	 */
	@Override
	public RegistroAssenzeController createRegistroAssenze(Classe classe) {
		
		
		
		return this.registroAssenzeController;
	}

}
