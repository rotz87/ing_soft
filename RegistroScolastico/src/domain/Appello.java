package domain;

import java.util.Date;
import java.util.GregorianCalendar;

public class Appello {

	private Date data;

	public Appello(){
//		this.data = new Date();
		
		GregorianCalendar g = new GregorianCalendar();
		this.data = g.getTime();
		
	}
	
	public Appello(Date data) {
//		super();
		this.data = data;
	}

	public Date getData() {
		
			return this.data;
		
	}

//	public void setData(Date data) {
//		this.data = data;
//	}

}