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
	
	private int idDocente;
	
	private String nome;
	
	private String cognome;
	
	private java.util.Set<domain.model.Classe> classi = new java.util.HashSet<domain.model.Classe>();
	
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
	
	private void setIdDocente(int value) {
		this.idDocente = value;
	}
	
	public int getIdDocente() {
		return idDocente;
	}
	
	public int getORMID() {
		return getIdDocente();
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
		return String.valueOf(getIdDocente());
	}
	
}
