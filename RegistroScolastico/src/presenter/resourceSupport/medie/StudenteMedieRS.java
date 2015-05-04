package presenter.resourceSupport.medie;

import domain.error.DomainCheckedException;
import domain.model.Studente;
import domain.model.Voto;
import presenter.resourceSupport.StudenteRS;
import presenter.resourceSupport.voto.VotoRS;

public class StudenteMedieRS extends StudenteRS {
	private VotoRS mediaScritto = null;
	private VotoRS mediaOrale = null;
	private VotoRS mediaTotale = null;
	
	public StudenteMedieRS() {
		super();
	}
	
	

	public StudenteMedieRS(Studente studente, Voto mediaScritto, Voto mediaOrale, Voto mediaTotale) throws DomainCheckedException {
		super(studente);
		if (mediaScritto != null){
			this.mediaScritto = new VotoRS(mediaScritto);
		}
		if (mediaOrale != null){
			this.mediaOrale = new VotoRS(mediaOrale);
		}
		if(mediaTotale != null){
			this.mediaTotale = new VotoRS(mediaTotale);
		}
	}



	public VotoRS getMediaScritto() {
		return mediaScritto;
	}

	public void setMediaScritto(VotoRS mediaScritto) {
		this.mediaScritto = mediaScritto;
	}

	public VotoRS getMediaOrale() {
		return mediaOrale;
	}

	public void setMediaOrale(VotoRS mediaOrale) {
		this.mediaOrale = mediaOrale;
	}

	public VotoRS getMediaTotale() {
		return mediaTotale;
	}

	public void setMediaTotale(VotoRS mediaTotale) {
		this.mediaTotale = mediaTotale;
	}
	
	

}
