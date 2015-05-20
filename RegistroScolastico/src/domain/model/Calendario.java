package domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Calendario {

	private Collection<GiornoFestivo> giorniFestivi = new LinkedList<GiornoFestivo>();
	private Collection<GiornoSettimanaleFestivo> giorniSettimanaliFestivi = new LinkedList<GiornoSettimanaleFestivo>();
	private LocalDate dataOdierna;
	private LocalDate inizioLezioni;
	private LocalDate fineLezioni;

	final private LocalDate dataZero = new LocalDate(0L);
	private static Calendario instance;

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
	 * 
	 * @param data
	 */
	public boolean isFestivo(LocalDate data){
		boolean festivo = false;
		
		festivo = isSettimanaleFestivo(data);
		
		if (!festivo){
			festivo = isFestivoSemplice(data);
		}
		
		return festivo;
		
	}
	
	public boolean isFestivoSemplice(LocalDate data){
		boolean festivo;
		java.sql.Date sqlDate = new java.sql.Date(data.toDate().getTime());
		festivo = getGiorniFestivi().contains(new GiornoFestivo(sqlDate));
		return festivo;
	}
	
	public boolean isSettimanaleFestivo(LocalDate data){
		boolean festivo;
		festivo = getGiorniSettimanaliFestivi().contains(new GiornoSettimanaleFestivo(data.getDayOfWeek()));
		return festivo;
	}

	public boolean isOggiFestivo() {
		return isFestivo(getDataOdierna());
	}
	
	public int getDaysFromZero(Date data){
		LocalDate lData = new LocalDate(data);
		return Days.daysBetween(dataZero, lData).getDays();
		
	}
	
	public Collection<LocalDate> getDateFestiveSempliciFuture(){
		Collection<LocalDate> rit = new LinkedList<LocalDate>();
		
		for(LocalDate data = calcolaDataOdierna(); data.isBefore(this.fineLezioni); data = data.plusDays(1) ){
			if(isFestivoSemplice(data)){
				rit.add(data);
			}
		}

		return rit;
		
	}
	
	public boolean isInAnnoCorrente(java.sql.Date data){
		
		LocalDate localDate;
		boolean rit;
		
		localDate = new LocalDate(data);
		
		rit = localDate.isAfter(this.inizioLezioni.minusDays(1)) && localDate.isBefore(this.fineLezioni.plusDays(1));
		
		return rit;
		
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

	public LocalDate getInizioLezioni() {
		return inizioLezioni;
	}

	public void setInizioLezioni(LocalDate inizioLezioni) {
		this.inizioLezioni = inizioLezioni;
	}

	public LocalDate getFineLezioni() {
		return fineLezioni;
	}

	public void setFineLezioni(LocalDate fineLezioni) {
		this.fineLezioni = fineLezioni;
	}
}