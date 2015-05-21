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

/**
 * ConterrÃ  il registro delle assenze.
 * Per il momento non verrÃ  implementata in questo UC.
 * @author marco
 */
public class Classe {
	public Classe() {
	}
	
	private int ID;
	
	private domain.model.RegistroAppelli _registroAppelli;
	
	private String _nome;
	
	private java.util.Set<domain.model.Studente> _studenti = new java.util.LinkedHashSet<domain.model.Studente>();
	
	private void set_nome(String value) {
		this._nome = value;
	}
	
	private String get_nome() {
		return _nome;
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
	
	private void set_registroAppelli(domain.model.RegistroAppelli value) {
		this._registroAppelli = value;
	}
	
	private domain.model.RegistroAppelli get_registroAppelli() {
		return _registroAppelli;
	}
	
	public void set_studenti(java.util.Set<domain.model.Studente> value) {
		this._studenti = value;
	}
	
	public java.util.Set<domain.model.Studente> get_studenti() {
		return _studenti;
	}
	
	
	private domain.implementor.ClasseImp implementor = new domain.implementor.ClasseImp();
	
	public Classe(String nome) {
		this.implementor.inizialize(this, nome);
	}
	
	public Classe(String nome, domain.model.RegistroAppelli registroAppelli) {
		this.implementor.inizialize(this, nome, registroAppelli);
	}
	
	public String getNome() {
		return this._nome;
	}
	
	public void setNome(String nome) {
		this._nome = nome;
	}
	
	public domain.model.RegistroAppelli getRegistroAppelli() {
		return this._registroAppelli;
	}
	
	public void setRegistroAppelli(domain.model.RegistroAppelli registroAppelli) {
		this._registroAppelli = registroAppelli;
	}
	
	public java.util.Set<Studente> getStudenti() {
		return this._studenti;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
