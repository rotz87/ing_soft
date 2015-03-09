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

public class CompitoInClasse {
	public CompitoInClasse() {
	}
	
	private int ID;
	
	private domain.model.RegistroDocente insegnamento;
	
	private java.util.Set<domain.model.Argomento> argomentiEsaminati = new java.util.LinkedHashSet<domain.model.Argomento>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setInsegnamento(domain.model.RegistroDocente value) {
		this.insegnamento = value;
	}
	
	public domain.model.RegistroDocente getInsegnamento() {
		return insegnamento;
	}
	
	public void setArgomentiEsaminati(java.util.Set<domain.model.Argomento> value) {
		this.argomentiEsaminati = value;
	}
	
	public java.util.Set<domain.model.Argomento> getArgomentiEsaminati() {
		return argomentiEsaminati;
	}
	
	
	private java.util.Date data;
	
	public void setDati(java.util.Date data, java.sql.Time ora, int durata, domain.model.Argomento argomenti) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
