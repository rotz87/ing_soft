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

public class Argomento {
	public Argomento() {
	}
	
	private int ID;
	
	private String nome;
	
	private String descrizione;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	private domain.implementor.ArgomentoImp implementor = new domain.implementor.ArgomentoImp();
	
	public Argomento(String nome, String descrizione) {
		this.implementor.inizialize(this, nome, descrizione);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
