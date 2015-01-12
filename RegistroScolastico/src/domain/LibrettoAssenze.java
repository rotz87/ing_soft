package domain;

import java.util.*;

public class LibrettoAssenze {

	private Collection<Assenza> giustificate;
	private List<Assenza> nonGiustificate;
	private Studente studente;
	private Collection<Ritardo> ritardi;
	private Collection<UscitaAnticipata> uscite;

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public LibrettoAssenze(Studente stud){
		this.studente = stud;
		
	}
	
	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(Appello appello) {
		
//		System.out.println("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		
		Assenza ultimaAssenzaNonGiustificata = this.getUltimaAssenzaNonGiustificata();
		boolean inseribile = ultimaAssenzaNonGiustificata.isInseribile(appello);
		
		// dall'alt del SD
		if (inseribile){
			
			ultimaAssenzaNonGiustificata.inserisciAppelloAssenza(appello);
//			System.out.println("accodo l'assenza " );
		}else{
			
			Assenza nuovaAssenza = new Assenza();
			nonGiustificate.add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
//			System.out.println("creo l'assenza " );
		}
		
	}

	private Assenza getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
//		System.out.println("passo per getUltimaAssenzaNonGiustificata!!");
		return nonGiustificate.get(0);
	}
	
	public void assengnaAssenzeNonGiustificate(List<Assenza> nonGistificate){
		//per le prove, probablmente è da togliere
		this.nonGiustificate = nonGistificate;
	}

	public Collection<Assenza> getGiustificate() {
		return giustificate;
	}

	public void setGiustificate(Collection<Assenza> giustificate) {
		this.giustificate = giustificate;
	}

	public List<Assenza> getNonGiustificate() {
		return nonGiustificate;
	}

	public void setNonGiustificate(List<Assenza> nonGiustificate) {
		this.nonGiustificate = nonGiustificate;
	}

}