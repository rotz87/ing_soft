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
	
	private java.sql.Date data;
	
	private java.sql.Time oraInizio;
	
	private java.sql.Time oraFine;
	
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
	
	public void setData(java.sql.Date value) {
		this.data = value;
	}
	
	public java.sql.Date getData() {
		return data;
	}
	
	public void setOraInizio(java.sql.Time value) {
		this.oraInizio = value;
	}
	
	public java.sql.Time getOraInizio() {
		return oraInizio;
	}
	
	public void setOraFine(java.sql.Time value) {
		this.oraFine = value;
	}
	
	public java.sql.Time getOraFine() {
		return oraFine;
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
	
	
	private domain.implementor.CompitoInClasseImp implementor = new domain.implementor.CompitoInClasseImp();
	
	public void setInfo(java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<domain.model.Argomento> argomenti) {
		this.implementor.setInfo(this, data, oraInizio, oraFine, argomenti);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
