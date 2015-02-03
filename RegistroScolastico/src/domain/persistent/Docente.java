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
package domain.persistent;

public class Docente implements domain.persistent.IPersistentModel {
	public Docente() {
	}
	
	private long idDocente;
	
	private String nome;
	
	private String cognome;
	
	private java.util.Set classi = new java.util.HashSet();
	
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
	
	private void setIdDocente(long value) {
		this.idDocente = value;
	}
	
	public long getIdDocente() {
		return idDocente;
	}
	
	public long getORMID() {
		return getIdDocente();
	}
	
	public void setClassi(java.util.Set value) {
		this.classi = value;
	}
	
	public java.util.Set getClassi() {
		return classi;
	}
	
	
	public String toString() {
		return String.valueOf(getIdDocente());
	}
	
}
