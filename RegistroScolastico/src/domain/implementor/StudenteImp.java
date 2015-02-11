package domain.implementor;

import domain.model.Indirizzo;
import domain.model.Studente;

public class StudenteImp {

	public StudenteImp(){

	}
	
	public void inizialize(Studente studente, String nome, String cognome){
		studente.setNome(nome);
		studente.setCognome(cognome);
	}
	
	public void inizialize(Studente studente, String nome, String cognome, Indirizzo indrizzo, String codiceFiscale) {
		inizialize(studente, nome, cognome);
		studente.setIndrizzo(indrizzo);
		studente.setCodiceFiscale(codiceFiscale);
	}

}