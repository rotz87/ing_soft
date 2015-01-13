package domain;

import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.LocalDate;

public class DataOggi {

	private static DataOggi instance; 
	private LocalDate dataOdierna;
	private  TreeSet<LocalDate> giorniFestivi;
	private LinkedList<Integer> giorniSettimanaliFestivi;
	
	/**
	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
	 */
	private DataOggi(){
		dataOdierna = this.calcolaDataOdierna();
		giorniFestivi = new TreeSet<LocalDate>();

	}
	
	public static synchronized DataOggi getInstance(){
		if (instance == null){
			instance = new DataOggi();
		}
		return instance;
	}
	
	public LocalDate getDataOdierna(){

		LocalDate data =  this.calcolaDataOdierna();
		if(!(dataOdierna.isEqual(data))){
			this.dataOdierna = data;
		}
		return dataOdierna;	
	}
	
	private LocalDate calcolaDataOdierna(){
		return new LocalDate(2014,12,17);
	}
	
	public boolean isFestivo(LocalDate data){
		boolean festivo = false;
		
		festivo = giorniSettimanaliFestivi.contains(new Integer(data.dayOfWeek().get()));
		if (!festivo){
			festivo = giorniFestivi.contains(data);
		}
		
		return festivo;
	}
}
