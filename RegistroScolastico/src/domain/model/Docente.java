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

public class Docente extends domain.model.Persona {
	public Docente() {
	}
	
	private java.util.Set<domain.model.RegistroDocente> _registriDocente = new java.util.LinkedHashSet<domain.model.RegistroDocente>();
	
	private void set_registriDocente(java.util.Set<domain.model.RegistroDocente> value) {
		this._registriDocente = value;
	}
	
	private java.util.Set<domain.model.RegistroDocente> get_registriDocente() {
		return _registriDocente;
	}
	
	
	private domain.implementor.DocenteImp implementor =  new domain.implementor.DocenteImp();
	
	public Docente(String nome, String cognome) {
		this.implementor.inizialize(this, nome, cognome);
	}
	
	public java.util.Set<domain.model.Classe> getClassi() {
		return this.implementor.getClassi(this);
	}
	
	public java.util.Set<RegistroDocente> getRegistriDocente() {
		return this._registriDocente;
	}
	
	public boolean haRegistroDocente(domain.model.RegistroDocente registro) {
		return this.implementor.haRegistroDocente(this, registro);
	}
	
	public boolean isInsegnante(domain.model.Classe classe) {
		return this.implementor.isInsegnante(this, classe);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
