package domain;

import org.joda.time.LocalDate;

public class DataOggi {

	private static DataOggi instance;
	private LocalDate dataOdierna;
	
	/**
	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
	 */
	private DataOggi(){
		dataOdierna = new LocalDate(2014,12,17);
	}
	
	public static synchronized DataOggi getInstance(){
		if (instance == null){
			instance = new DataOggi();
		}
		return instance;
	}
	
	public LocalDate getDataOdierna(){
		return dataOdierna;
	}
}
