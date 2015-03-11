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
		java.sql.Date sqlDate = new java.sql.Date(data.toDate().getTime());
		appello.setData(sqlDate) ;
		appello.setAssenzePrese(false);

	}

	public int compareTo(Appello that, Appello appello) {
		return that.getData().compareTo(appello.getData());
	}
	

}