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

public class Scuola {
	public Scuola() {
	}
	
	private int ID;
	
	private java.util.List<domain.model.Classe> classi = new java.util.LinkedList<domain.model.Classe>();
	
	private java.util.List<domain.model.Docente> docenti = new java.util.LinkedList<domain.model.Docente>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setClassi(java.util.List<domain.model.Classe> value) {
		this.classi = value;
	}
	
	public java.util.List<domain.model.Classe> getClassi() {
		return classi;
	}
	
	
	public void setDocenti(java.util.List<domain.model.Docente> value) {
		this.docenti = value;
	}
	
	public java.util.List<domain.model.Docente> getDocenti() {
		return docenti;
	}
	
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
