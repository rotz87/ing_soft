/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model;

public class Studente extends domain.model.Persona {
	public Studente() {
	}
	
	private domain.model.LibrettoVoti librettoVoti;
	
	private domain.model.LibrettoAssenze librettoAssenze;
	
	public void setLibrettoAssenze(domain.model.LibrettoAssenze value) {
		this.librettoAssenze = value;
	}
	
	public domain.model.LibrettoAssenze getLibrettoAssenze() {
		return librettoAssenze;
	}
	
	public void setLibrettoVoti(domain.model.LibrettoVoti value) {
		this.librettoVoti = value;
	}
	
	public domain.model.LibrettoVoti getLibrettoVoti() {
		return librettoVoti;
	}
	
	private domain.implementor.StudenteImp implementor = new domain.implementor.StudenteImp();
	
	public Studente(String nome, String cognome) {
		this.implementor.inizialize(this, nome, cognome);
	}
	
	public Studente(long id, String nome, String cognome, domain.model.Indirizzo indrizzo, String codiceFiscale) {
		this.implementor.inizialize(this, nome, cognome, indrizzo, codiceFiscale);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
