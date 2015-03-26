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

public class RegistroDocente {
	public RegistroDocente() {
	}
	
	private int ID;
	
	private domain.model.Materia _materia;
	
	private domain.model.Classe _classe;
	
	private java.util.Set<domain.model.compitoInClasse.CompitoInClasse> _compitiInClasse = new java.util.LinkedHashSet<domain.model.compitoInClasse.CompitoInClasse>();
	
	private java.util.Set<domain.model.Argomento> _argomentiSvolti = new java.util.LinkedHashSet<domain.model.Argomento>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void set_classe(domain.model.Classe value) {
		this._classe = value;
	}
	
	private domain.model.Classe get_classe() {
		return _classe;
	}
	
	private void set_materia(domain.model.Materia value) {
		this._materia = value;
	}
	
	private domain.model.Materia get_materia() {
		return _materia;
	}
	
	private void set_compitiInClasse(java.util.Set<domain.model.compitoInClasse.CompitoInClasse> value) {
		this._compitiInClasse = value;
	}
	
	private java.util.Set<domain.model.compitoInClasse.CompitoInClasse> get_compitiInClasse() {
		return _compitiInClasse;
	}
	
	
	private void set_argomentiSvolti(java.util.Set<domain.model.Argomento> value) {
		this._argomentiSvolti = value;
	}
	
	private java.util.Set<domain.model.Argomento> get_argomentiSvolti() {
		return _argomentiSvolti;
	}
	
	
	private domain.implementor.RegistroDocenteImp implementor = new domain.implementor.RegistroDocenteImp();
	
	public domain.model.compitoInClasse.CompitoInClasse creaCompito() {
		return this.implementor.creaCompito(this);
	}
	
	public java.util.Set<Argomento> getArgomentiSvolti() {
		return this._argomentiSvolti;
	}
	
	public domain.model.Classe getClasse() {
		return this._classe;
	}
	
	public java.util.Set<domain.model.compitoInClasse.CompitoInClasse> getCompitiInClasse() {
		return this._compitiInClasse;
	}
	
	public domain.model.Materia getMateria() {
		return this._materia;
	}
	
	public void inserisciInfoCompito(domain.model.compitoInClasse.CompitoInClasse compito, java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<Argomento> argomenti) {
		this.implementor.inserisciInfoCompito(this, compito, data, oraInizio, oraFine, argomenti);
	}
	
	public void inserisciStudenti(domain.model.compitoInClasse.CompitoInClasse compito, domain.model.Studente[] studenti) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void inserisciVoti(domain.model.compitoInClasse.CompitoInClasse compito, java.util.Map<Studente, Voto> mapVoti) {
		this.implementor.inserisciVoti(this, compito, mapVoti);
	}
	
	public boolean isCompitoPresente(domain.model.compitoInClasse.CompitoInClasse compito) {
		return this.implementor.isCompitoPresente(this, compito);
	}
	
	public void setClasse(domain.model.Classe classe) {
		this._classe = classe;
	}
	
	public void setMateria(domain.model.Materia materia) {
		this._materia = materia;
	}
	
	/**
	 * Questo metodo dovrebbe essere utilizzato solo dal CompitoInCLasseState
	 * @param compitoInClasse
	 */
	public void eliminaCompito(domain.model.compitoInClasse.CompitoInClasse compitoInClasse) {
		this.implementor.eliminCompito(this, compitoInClasse);
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
