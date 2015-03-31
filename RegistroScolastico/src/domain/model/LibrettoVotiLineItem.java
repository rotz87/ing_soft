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

public class LibrettoVotiLineItem {
	public LibrettoVotiLineItem() {
	}
	
	private int ID;
	
	private domain.model.Voto _voto;
	
	private domain.model.compitoInClasse.CompitoInClasse _compitoInClasse;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_compitoInClasse(domain.model.compitoInClasse.CompitoInClasse value) {
		this._compitoInClasse = value;
	}
	
	private domain.model.compitoInClasse.CompitoInClasse get_compitoInClasse() {
		return _compitoInClasse;
	}
	
	private void set_voto(domain.model.Voto value) {
		this._voto = value;
	}
	
	private domain.model.Voto get_voto() {
		return _voto;
	}
	
	private domain.implementor.LibrettoVotiLineItemImp implementor = new domain.implementor.LibrettoVotiLineItemImp();;
	
	public void aggiungiVoto(domain.model.Voto voto) {
		this.implementor.aggiungiVoto(this, voto);
	}
	
	public LibrettoVotiLineItem(domain.model.compitoInClasse.CompitoInClasse compito) {
		this.implementor.inizialize(this,compito);
	}
	
	public LibrettoVotiLineItem(domain.model.compitoInClasse.CompitoInClasse compito, domain.model.Voto voto) {
		this.implementor.inizialize(this, compito, voto);
	}
	
	public domain.model.Voto getVoto() {
		return this._voto;
	}
	
	public void setVoto(domain.model.Voto voto) {
		this._voto = voto;
	}
	
	public domain.model.compitoInClasse.CompitoInClasse getCompitoInClasse() {
		return this._compitoInClasse;
	}
	
	public void setCompitoInClasse(domain.model.compitoInClasse.CompitoInClasse compitoInClasse) {
		this._compitoInClasse = compitoInClasse;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
