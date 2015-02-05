package domain.model;

import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.LocalDate;

import domain.persistent.Calendario;

public class MCalendario  extends AModel<Calendario>{

	private static MCalendario instance; 
//	private LocalDate dataOdierna;
//	private  TreeSet<LocalDate> giorniFestivi;
//	private LinkedList<Integer> giorniSettimanaliFestivi;
	
	
	private MCalendario(){
//		dataOdierna = this.calcolaDataOdierna();
		getPersistentModel().setDataOdierna( this.calcolaDataOdierna());
//		giorniFestivi = new TreeSet<LocalDate>();
		getPersistentModel().getGiorniFestivi() =  new TreeSet<LocalDate>();
//		giorniSettimanaliFestivi = new LinkedList<Integer>();
		getPersistentModel().getGiorniSettimanaliFestivi()  = new LinkedList<Integer>();
//		giorniSettimanaliFestivi.add(6);
//		giorniSettimanaliFestivi.add(7);
		getPersistentModel().getGiorniSettimanaliFestivi().add(7);
		
		getPersistentModel().getGiorniFestivi().add(new LocalDate(2014,12,8));
		getPersistentModel().getGiorniFestivi().add(new LocalDate(2014,12,25));
		getPersistentModel().getGiorniFestivi().add(new LocalDate(2014,12,26));

	}
	
	public static synchronized MCalendario getInstance(){
		if (instance == null){
			instance = new MCalendario();
		}
		return instance;
	}
	
	public LocalDate getDataOdierna(){

		LocalDate data =  this.calcolaDataOdierna();
		if(!(new LocalDate(getPersistentModel().getDataOdierna()).isEqual(data))){
//			this.dataOdierna = data;
			getPersistentModel().setDataOdierna(data.toDate());
		}
		return new LocalDate(getPersistentModel().getDataOdierna());	
	}
	
	/**
	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
	 */
	private LocalDate calcolaDataOdierna(){
		return new LocalDate(2014,12,17);//a regime deve prendere la data odierna affettiva per ora per i test prende la data de 17 12 2014
	}
	
	public boolean isFestivo(LocalDate data){
		boolean festivo = false;
		
		festivo = getPersistentModel().getGiorniSettimanaliFestivi().contains(new Integer(data.dayOfWeek().get()));
		if (!festivo){
			festivo =  getPersistentModel().getGiorniSettimanaliFestivi().contains(data);
		}
		
		return festivo;
	}
	
	public boolean isOggiFestivo(){
		return this.isFestivo(this.getDataOdierna());
	}
}
