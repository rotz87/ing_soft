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
	
	private java.util.Set<domain.model.Classe> classi = new java.util.LinkedHashSet<domain.model.Classe>();
	
	public void setClassi(java.util.Set<domain.model.Classe> value) {
		this.classi = value;
	}
	
	public java.util.Set<domain.model.Classe> getClassi() {
		return classi;
	}
	
	
	private domain.implementor.DocenteImp implementor =  new domain.implementor.DocenteImp();
	
	public Docente(String nome, String cognome) {
		this.implementor.inizialize(this, nome, cognome);
	}
	
	public boolean isInsegnante(domain.model.Classe classe) {
		return this.implementor.isInsegnante(this, classe);
	}
	
	public String toString() {
		return super.toString();
	}
	
}
