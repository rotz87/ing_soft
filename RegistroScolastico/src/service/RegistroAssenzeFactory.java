package service;


import domain.RegistroAssenzeController;
import domain.Classe;


public abstract class RegistroAssenzeFactory {
	
	/**
	 * Restituisce il RegistroAssenzeController della classe passata come parametro.
	 * 
	 * @param classe
	 * @return
	 */
	abstract public RegistroAssenzeController createRegistroAssenze(Classe classe);

}
