package domain.model;

import java.util.Date;

import org.joda.time.LocalDate;

import service.Stampa;
import domain.implementor.AppelloImp;

public class Appello {

	private long idAppello;
	private boolean assenzePrese;
	private Date data;
	private AppelloImp implementor;


	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 * @param data
	 */
	
	public Appello(LocalDate data) {
		implementor = new AppelloImp();
		implementor.inizialize(this, data);


	}

	
	public Date getData() {
		
		return this.data;
	
	}

	public void setData(Date data) {
		this.data = data;
	}


	public long getIdAppello() {
		return idAppello;
	}

	public void setIdAppello(long idAppello) {
		this.idAppello = idAppello;
	}
	

	public boolean isAssenzePrese() {
		return assenzePrese;
	}


	public void setAssenzePrese(boolean assenzePrese) {
		this.assenzePrese = assenzePrese;
	}
	
}