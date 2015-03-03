package domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Calendario {

	private static Calendario instance;
	private Collection<GiornoFestivo> giorniFestivi = new LinkedList<GiornoFestivo>();
	private Collection<GiornoSettimanaleFestivo> giorniSettimanaliFestivi = new LinkedList<GiornoSettimanaleFestivo>();
	private LocalDate dataOdierna;
	final private LocalDate dataZero = new LocalDate(0L);

	private Calendario(){
		this.dataOdierna = calcolaDataOdierna();
	}
	
	public static synchronized Calendario getInstance() {
		if(instance == null){
			instance = new Calendario();
		}
		return instance;
	}

	public org.joda.time.LocalDate getDataOdierna() {
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
	
	/**
	 * public LocalDate prendiDataOdierna(){
	 * 
	 * return implementor.prendiDataOdierna(this);
	 * }
	 * @param data
	 */
	public boolean isFestivo(LocalDate data){
		boolean festivo = false;
		
		festivo = getGiorniSettimanaliFestivi().contains(new GiornoSettimanaleFestivo(data.getDayOfWeek()));
				
		if (!festivo){
			festivo = getGiorniFestivi().contains(new GiornoFestivo(data.toDate()));
		}
				
		return festivo;
	}

	public boolean isOggiFestivo() {
		return isFestivo(getDataOdierna());
	}
	
	public int getDaysFromZero(Date data){
		LocalDate lData = new LocalDate(data);
		return Days.daysBetween(dataZero, lData).getDays();
		
	}

	public Collection<GiornoSettimanaleFestivo> getGiorniSettimanaliFestivi() {
		return this.giorniSettimanaliFestivi;
	}

	/**
	 * 
	 * @param giorniSettimanaliFestivi
	 */
	public void setGiorniSettimanaliFestivi(LinkedList<GiornoSettimanaleFestivo> giorniSettimanaliFestivi) {
		this.giorniSettimanaliFestivi = giorniSettimanaliFestivi;
	}

	public Collection<GiornoFestivo> getGiorniFestivi() {
		return giorniFestivi;
	}

	public void setGiorniFestivi(LinkedList<GiornoFestivo> giorniFestivi) {
		this.giorniFestivi = giorniFestivi;
	}

}