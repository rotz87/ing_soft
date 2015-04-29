package presenter.resourceSupport.medie;

import domain.model.Studente;
import domain.model.Voto;
import presenter.resourceSupport.StudenteRS;

public class StudenteMedieRS extends StudenteRS {
	private String mediaScritto = null;
	private String mediaOrale = null;
	private String mediaTotale = null;
	
	public StudenteMedieRS() {
		super();
	}
	
	

	public StudenteMedieRS(Studente studente, Voto mediaScritto, Voto mediaOrale, Voto mediaTotale) {
		super(studente);
		if (mediaScritto != null){
			this.mediaScritto = String.valueOf(mediaScritto.getValore());
		}
		if (mediaOrale != null){
			this.mediaOrale = String.valueOf(mediaOrale.getValore());
		}
		if(mediaTotale != null){
			this.mediaTotale = String.valueOf(mediaTotale.getValore());
		}
	}



	public String getMediaScritto() {
		return mediaScritto;
	}

	public void setMediaScritto(String mediaScritto) {
		this.mediaScritto = mediaScritto;
	}

	public String getMediaOrale() {
		return mediaOrale;
	}

	public void setMediaOrale(String mediaOrale) {
		this.mediaOrale = mediaOrale;
	}

	public String getMediaTotale() {
		return mediaTotale;
	}

	public void setMediaTotale(String mediaTotale) {
		this.mediaTotale = mediaTotale;
	}
	
	

}
