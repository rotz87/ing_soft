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

public class Docente {
	public Docente() {
	}
	
	private int ID;
	
	private String nome;
	
	private String cognome;
	
	private java.util.Set<domain.model.Classe> classi = new java.util.LinkedHashSet<domain.model.Classe>();
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
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
		return String.valueOf(getID());
	}
	
}
