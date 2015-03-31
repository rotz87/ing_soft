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

public class Materia {
	public Materia() {
	}
	
	private int ID;
	
	private String _nome;
	
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
