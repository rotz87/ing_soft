package domain;

import java.util.*;

public class LibrettoAssenze {

	Collection<Assenza> giustificate;
	Collection<Assenza> nonGiustificate;
	private Studente studente;

	public LibrettoAssenze(Studente stud){
		this.studente = stud;
		
	}
	
	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(Appello appello) {
		// TODO - implement LibrettoAssenze.segnaAssenza
		
		System.out.println("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
	}

	private Assenza getUltimaAssenzaNonGiustificata() {
		// TODO - implement LibrettoAssenze.getUltimaAssenzaNonGiustificata
		throw new UnsupportedOperationException();
	}

}