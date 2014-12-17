package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.LocalDate;

public class Appello {

	private Date data;
	private Calendar dataCalendar;
	private LocalDate dataL;

	public Appello(){
//		this.data = new Date();
		
		dataCalendar = new GregorianCalendar();
		this.data = dataCalendar.getTime();
		dataL = DataOggi.getInstance().getDataOdierna();
		
	}
	
//	public Appello(Date data) {
//
//		// costruttore inserito per le prove, probabilmente non serve!!		
//		this.data = data;
//		//da cambiare
//		this.dataCalendar = new GregorianCalendar(data.getYear(), data.getMonth(), data.getDate());
//	}
	
	public Appello(LocalDate data) {

		dataL = new LocalDate(data);
	}

	public Date getData() {
		
			return this.data;
		
	}
	
	public Calendar getDataCalendar(){
//		System.out.println("passo per getDataCalendar " + dataCalendar.getTime());
		return dataCalendar;
	}
	
	public LocalDate getDataL() {
		
		return this.dataL;
	
}

//	public void setData(Date data) {
//		this.data = data;
//	}

}