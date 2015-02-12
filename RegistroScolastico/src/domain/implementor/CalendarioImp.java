package domain.implementor;

import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.LocalDate;

import domain.model.Calendario;
import domain.model.MyTreeSetDate;

public class CalendarioImp {
	
	private LocalDate dataOdierna;
	
	public CalendarioImp(){
		this.dataOdierna = calcolaDataOdierna();
	}
	
	public void inizialize(Calendario calendario){
		this.dataOdierna = calcolaDataOdierna();

	}
	
	
	public LocalDate getDataOdierna(){

		LocalDate data =  this.calcolaDataOdierna();
		if(!(this.dataOdierna.isEqual(data))){
			this.dataOdierna = data;
		}
		return this.dataOdierna;	

	}
	
	/**
	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
	 */
	private LocalDate calcolaDataOdierna(){
		return new LocalDate(2014,12,17);//a regime deve prendere la data odierna affettiva per ora per i test prende la data de 17 12 2014
	}
	
	public boolean isFestivo(Calendario calendario, LocalDate data){
		boolean festivo = false;
		
		festivo = calendario.getGiorniSettimanaliFestivi().contains(new Integer(data.dayOfWeek().get()));
		if (!festivo){
			festivo = calendario.getGiorniFestivi().contains(data);
		}
		
		return festivo;
	}
	
	public boolean isOggiFestivo(Calendario calendario){
		
		return calendario.isFestivo(this.dataOdierna);
	}
}
