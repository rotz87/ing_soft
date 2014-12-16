package domain;

import java.util.*;

public class LibrettoAssenze {

	Collection<Assenza> giustificate;
	List<Assenza> nonGiustificate;
	private Studente studente;

	public LibrettoAssenze(Studente stud){
		this.studente = stud;
		
	}
	
	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(Appello appello) {
		
		System.out.println("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		
		Assenza ultimaAssenzaNonGiustificata = this.getUltimaAssenzaNonGiustificata();
		boolean inseribile = ultimaAssenzaNonGiustificata.isInseribile(appello);
		
		// dall'alt del SD
		if (inseribile){
			
			ultimaAssenzaNonGiustificata.inserisciAppelloAssenza(appello);
		}else{
			
			Assenza nuovaAssenza = new Assenza();
			nonGiustificate.add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
		}
		
	}

	private Assenza getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
		System.out.println("passo per getUltimaAssenzaNonGiustificata!!");
		return nonGiustificate.get(0);
	}
	
	public void assengnaAssenzeNonGiustificate(List<Assenza> nonGistificate){
		//per le prove, probablmente è da togliere
		this.nonGiustificate = nonGistificate;
	}

}