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
	
	private domain.model.LibrettoVoti _librettoVoti;
	
	private domain.model.LibrettoAssenze _librettoAssenze;
	
	private void set_librettoAssenze(domain.model.LibrettoAssenze value) {
		this._librettoAssenze = value;
	}
	
	private domain.model.LibrettoAssenze get_librettoAssenze() {
		return _librettoAssenze;
	}
	
	private void set_librettoVoti(domain.model.LibrettoVoti value) {
		this._librettoVoti = value;
	}
	
	private domain.model.LibrettoVoti get_librettoVoti() {
		return _librettoVoti;
	}
	
	private domain.implementor.StudenteImp implementor = new domain.implementor.StudenteImp();
	
	public Studente(String nome, String cognome) {
		this.implementor.inizialize(this, nome, cognome);
	}
	
	public Studente(long id, String nome, String cognome, domain.model.Indirizzo indrizzo, String codiceFiscale) {
		this.implementor.inizialize(this, nome, cognome, indrizzo, codiceFiscale);
	}
	
	public domain.model.LibrettoVoti getLibrettoVoti() {
		return this._librettoVoti;
	}
	
	public void setLibrettoVoti(domain.model.LibrettoVoti librettoVoti) {
		this._librettoVoti = librettoVoti;
	}
	
	public domain.model.LibrettoAssenze getLibrettoAssenze() {
		return this._librettoAssenze;
	}
	
	public void setLibrettoAssenze(domain.model.LibrettoAssenze librettoAssenze) {
		this._librettoAssenze = librettoAssenze;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
