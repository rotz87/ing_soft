package domain.implementor;

import org.joda.time.LocalDate;

import domain.model.Appello;

public class AppelloImp {
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 * @param data
	 */
	
	public AppelloImp() {

	}

	public void inizialize(Appello appello, LocalDate data){
		appello.setData(data.toDate()) ;
		appello.setAssenzePrese(false);

	}
	

}