package presenter.resourceSupport.medie;

import org.springframework.hateoas.ResourceSupport;

public class ParametriMedieRS extends ResourceSupport {
	
	private long dataInizio;
	private long dataFine;
	private String strategia;
	
	public ParametriMedieRS() {
		super();
	}

	public long getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(long dataInizio) {
		this.dataInizio = dataInizio;
	}

	public long getDataFine() {
		return dataFine;
	}

	public void setDataFine(long dataFine) {
		this.dataFine = dataFine;
	}

	public String getStrategia() {
		return strategia;
	}

	public void setStrategia(String strategia) {
		this.strategia = strategia;
	}
	
	

}
