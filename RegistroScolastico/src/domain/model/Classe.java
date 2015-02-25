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
	
	private domain.model.RegistroAssenze registroAssenze;
	
	private String nome;
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
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
	
	public void setRegistroAssenze(domain.model.RegistroAssenze value) {
		this.registroAssenze = value;
	}
	
	public domain.model.RegistroAssenze getRegistroAssenze() {
		return registroAssenze;
	}
	
	private domain.implementor.ClasseImp implementor = new domain.implementor.ClasseImp();
	
	public Classe(String nome) {
		this.implementor.inizialize(this, nome);
	}
	
	public Classe(String nome, domain.model.RegistroAssenze registroAssenze) {
		this.implementor.inizialize(this, nome, registroAssenze);
	}
	
	public java.util.Set<Studente> getStudenti() {
		return this.implementor.getStudenti(this);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
