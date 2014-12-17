package domain;

import org.joda.time.LocalDate;

public class DataOggi {

	private static DataOggi instance;
	private LocalDate dataOdierna;
	
	private DataOggi(){
		dataOdierna = new LocalDate();
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
