package domain.model;

import java.util.Collection;
import java.util.List;

import domain.implementor.LibrettoAssenzeImp;

public class LibrettoAssenze {

	private List<Assenza> giustificate;
	private List<Assenza> nonGiustificate;
	private Studente studente;
	private Collection<Ritardo> ritardi;
	private Collection<UscitaAnticipata> uscite;
	private LibrettoAssenzeImp implementor;

	public LibrettoAssenze(){
		this.implementor = new LibrettoAssenzeImp();
		this.implementor.inizialize(this);
	}
	
	public LibrettoAssenze(Studente stud){
		this.implementor = new LibrettoAssenzeImp();
		this.implementor.inizialize(this, stud);
		
	}
	
	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public List<Assenza> getGiustificate() {
		return giustificate;
	}

	public void setGiustificate(List<Assenza> giustificate) {
		this.giustificate = giustificate;
	}

	public List<Assenza> getNonGiustificate() {
		return nonGiustificate;
	}

	public void setNonGiustificate(List<Assenza> nonGiustificate) {
		this.nonGiustificate = nonGiustificate;
	}
	
	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(Appello appello) {
		this.implementor.segnaAssenza(this, appello);
	}

	public Assenza getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
//		Stampa.stampaln("nonGiustificate.get(0): "+nonGiustificate.get(nonGiustificate.size()-1).getUltimoAppelloAssenza().getDataL());
		return implementor.getUltimaAssenzaNonGiustificata(this);

	}
	
	public boolean esisteAssenza(Appello appello){
		return implementor.esisteAssenza(this, appello);
	}
	
	public Assenza getAssenza(Appello appello){
		return this.implementor.getAssenza(this, appello);

	}
	


}