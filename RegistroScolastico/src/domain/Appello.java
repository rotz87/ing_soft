package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Appello {

	private Date data;
	private Calendar dataCalendar;

	public Appello(){
//		this.data = new Date();
		
		dataCalendar = new GregorianCalendar();
		this.data = dataCalendar.getTime();
		
	}
	
	public Appello(Date data) {
//		super();
		this.data = data;
	}

	public Date getData() {
		
			return this.data;
		
	}
	
	public Calendar getDataCalendar(){
		
		return dataCalendar;
	}

//	public void setData(Date data) {
//		this.data = data;
//	}

}