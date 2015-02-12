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
	
	private int idClasse;
	
	private domain.model.RegistroAssenze registroAssenze;
	
	private String nome;
	
	private java.util.Set<domain.model.Studente> studenti = new java.util.HashSet<domain.model.Studente>();
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setIdClasse(int value) {
		this.idClasse = value;
	}
	
	public int getIdClasse() {
		return idClasse;
	}
	
	public int getORMID() {
		return getIdClasse();
	}
	
	public void setRegistroAssenze(domain.model.RegistroAssenze value) {
		this.registroAssenze = value;
	}
	
	public domain.model.RegistroAssenze getRegistroAssenze() {
		return registroAssenze;
	}
	
	public void setStudenti(java.util.Set<domain.model.Studente> value) {
		this.studenti = value;
	}
	
	public java.util.Set<domain.model.Studente> getStudenti() {
		return studenti;
	}
	
	
	private domain.implementor.ClasseImp implementor = new domain.implementor.ClasseImp();
	
	public Classe(String nome) {
		this.implementor.inizialize(this, nome);
	}
	
	public Classe(String nome, domain.model.RegistroAssenze registroAssenze) {
		this.implementor.inizialize(this, nome, registroAssenze);
	}
	
	public void setIdClasse(long idClasse) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getIdClasse());
	}
	
}
