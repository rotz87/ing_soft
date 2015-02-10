package domain.model;

import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.LocalDate;

public class Calendario {

	private static Calendario instance; 
	private LocalDate dataOdierna;
	private  TreeSet<LocalDate> giorniFestivi;
	private LinkedList<Integer> giorniSettimanaliFestivi;
	
	
	private Calendario(){
		dataOdierna = this.calcolaDataOdierna();
		giorniFestivi = new TreeSet<LocalDate>();
		giorniSettimanaliFestivi = new LinkedList<Integer>();
//		giorniSettimanaliFestivi.add(6);
		giorniSettimanaliFestivi.add(7);
		
		giorniFestivi.add(new LocalDate(2014,12,8));
		giorniFestivi.add(new LocalDate(2014,12,25));
		giorniFestivi.add(new LocalDate(2014,12,26));

	}
	
	public static synchronized Calendario getInstance(){
		if (instance == null){
			instance = new Calendario();
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
	
	/**
	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
	 */
	private LocalDate calcolaDataOdierna(){
		return new LocalDate(2014,12,17);//a regime deve prendere la data odierna affettiva per ora per i test prende la data de 17 12 2014
	}
	
	public boolean isFestivo(LocalDate data){
		boolean festivo = false;
		
		festivo = giorniSettimanaliFestivi.contains(new Integer(data.dayOfWeek().get()));
		if (!festivo){
			festivo = giorniFestivi.contains(data);
		}
		
		return festivo;
	}
	
	public boolean isOggiFestivo(){
		return this.isFestivo(this.getDataOdierna());
	}
}
