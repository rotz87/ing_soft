package domain;

import java.util.Date;

public class Appello {

	private Date data;

	public Appello(){
		this.data = new Date();
		
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