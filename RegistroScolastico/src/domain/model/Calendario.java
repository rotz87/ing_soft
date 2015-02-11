package domain.model;

import java.util.Date;
import java.util.LinkedList;
//import java.util.TreeSet;

import org.joda.time.LocalDate;

import domain.implementor.CalendarioImp;

public class Calendario {

	private static Calendario instance; 
//	private LocalDate dataOdierna;
	private MyTreeSetDate giorniFestivi;
	private LinkedList<Integer> giorniSettimanaliFestivi;
	private CalendarioImp implementor;
	
	
	private Calendario(){
		implementor = new CalendarioImp();
		implementor.inizialize(this);


	}
	
	public static synchronized Calendario getInstance(){
		if (instance == null){
			instance = new Calendario();
		}
		return instance;
	}
	
	
	public LocalDate getDataOdierna() {
		return implementor.getDataOdierna();
	}


	public MyTreeSetDate getGiorniFestivi() {
		return giorniFestivi;
	}

	public void setGiorniFestivi(MyTreeSetDate giorniFestivi) {
		this.giorniFestivi = giorniFestivi;
	}

	public LinkedList<Integer> getGiorniSettimanaliFestivi() {
		return giorniSettimanaliFestivi;
	}

	public void setGiorniSettimanaliFestivi(LinkedList<Integer> giorniSettimanaliFestivi) {
		this.giorniSettimanaliFestivi = giorniSettimanaliFestivi;
	}

//	public LocalDate prendiDataOdierna(){
//
//		return implementor.prendiDataOdierna(this);
//	}
	

	public boolean isFestivo(LocalDate data){
		return implementor.isFestivo(this, data);
	}
	
	public boolean isOggiFestivo(){
		return implementor.isOggiFestivo(this);
	}
}
