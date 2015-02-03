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

/**
 * ConterrÃ  il registro delle assenze.
 * Per il momento non verrÃ  implementata in questo UC.
 * @author marco
 */
public class Classe implements domain.persistent.IPersistentModel {
	public Classe() {
	}
	
	private long idClasse;
	
	private domain.persistent.RegistroAssenze registroAssenze;
	
	private String nome;
	
	private java.util.Set studenti = new java.util.HashSet();
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	private void setIdClasse(long value) {
		this.idClasse = value;
	}
	
	public long getIdClasse() {
		return idClasse;
	}
	
	public long getORMID() {
		return getIdClasse();
	}
	
	public void setRegistroAssenze(domain.persistent.RegistroAssenze value) {
		this.registroAssenze = value;
	}
	
	public domain.persistent.RegistroAssenze getRegistroAssenze() {
		return registroAssenze;
	}
	
	public void setStudenti(java.util.Set value) {
		this.studenti = value;
	}
	
	public java.util.Set getStudenti() {
		return studenti;
	}
	
	
	public String toString() {
		return String.valueOf(getIdClasse());
	}
	
}
