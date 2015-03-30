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
	
	private String _nome;
	
	private java.util.List<domain.model.Classe> _classi = new java.util.LinkedList<domain.model.Classe>();
	
	private java.util.List<domain.model.Docente> _docenti = new java.util.LinkedList<domain.model.Docente>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_nome(String value) {
		this._nome = value;
	}
	
	private String get_nome() {
		return _nome;
	}
	
	private void set_classi(java.util.List<domain.model.Classe> value) {
		this._classi = value;
	}
	
	private java.util.List<domain.model.Classe> get_classi() {
		return _classi;
	}
	
	
	private void set_docenti(java.util.List<domain.model.Docente> value) {
		this._docenti = value;
	}
	
	private java.util.List<domain.model.Docente> get_docenti() {
		return _docenti;
	}
	
	
	public java.util.List<Classe> getClassi() {
		return this._classi;
	}
	
	public java.util.List<Docente> getDocenti() {
		return this._docenti;
	}
	
	public String getNome() {
		return this._nome;
	}
	
	public void setNome(String nome) {
		this._nome = nome;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
