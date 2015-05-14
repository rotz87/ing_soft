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
package domain.model.compitoInClasse;

public class CompitoInClasse {
	public CompitoInClasse() {
	}
	
	private int ID;
	
	protected domain.model.RegistroDocente _insegnamento;
	
	protected java.sql.Date _data;
	
	protected java.sql.Time _oraInizio;
	
	protected java.sql.Time _oraFine;
	
	protected domain.model.compitoInClasse.CompitoInClasseState _state = domain.model.compitoInClasse.CompitoDaSvolgere.getInstance();
	
	private java.util.Set<domain.model.Argomento> _argomentiEsaminati = new java.util.LinkedHashSet<domain.model.Argomento>();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	protected void set_data(java.sql.Date value) {
		this._data = value;
	}
	
	protected java.sql.Date get_data() {
		return _data;
	}
	
	protected void set_oraInizio(java.sql.Time value) {
		this._oraInizio = value;
	}
	
	protected java.sql.Time get_oraInizio() {
		return _oraInizio;
	}
	
	protected void set_oraFine(java.sql.Time value) {
		this._oraFine = value;
	}
	
	protected java.sql.Time get_oraFine() {
		return _oraFine;
	}
	
	protected void set_state(domain.model.compitoInClasse.CompitoInClasseState value) {
		this._state = value;
	}
	
	protected domain.model.compitoInClasse.CompitoInClasseState get_state() {
		return _state;
	}
	
	protected void set_insegnamento(domain.model.RegistroDocente value) {
		this._insegnamento = value;
	}
	
	protected domain.model.RegistroDocente get_insegnamento() {
		return _insegnamento;
	}
	
	protected void set_argomentiEsaminati(java.util.Set<domain.model.Argomento> value) {
		this._argomentiEsaminati = value;
	}
	
	protected java.util.Set<domain.model.Argomento> get_argomentiEsaminati() {
		return _argomentiEsaminati;
	}
	
	
	public void setInfo(java.sql.Date data, java.sql.Time oraInizio, java.sql.Time oraFine, java.util.Collection<domain.model.Argomento> argomenti) {
		this._state.setInfo(this, data, oraInizio, oraFine, argomenti);
	}
	
	public void inserisciVoti(java.util.Map<domain.model.Studente, domain.model.Voto> mapVoti) {
		this._state.inserisciVoti(this, mapVoti);
	}
	
	public java.sql.Date getData() {
		return this._data;
	}
	
	public domain.model.RegistroDocente getInsegnamento() {
		return this._insegnamento;
	}
	
	public java.sql.Time getOraInizio() {
		return this._oraInizio;
	}
	
	public java.sql.Time getOraFine() {
		return this._oraFine;
	}
	
	public java.util.Set<domain.model.Argomento> getArgomentiEsaminati() {
		return this._argomentiEsaminati;
	}
	
	public CompitoInClasse(domain.model.RegistroDocente insegnamento) {
		this._insegnamento = insegnamento;
	}
	
	public void setSvolto() {
		this._state.setSvolto(this);
	}
	
	public void annulla() {
		this._state.annulla(this);
	}
	
	public void chiudi() {
		this._state.chiudi(this);
	}
	
	public void elimina() {
		this._state.elimina(this);
	}
	
	public domain.model.compitoInClasse.CompitoInClasseState getState() {
		return this._state;
	}
	
	public boolean isChiuso() {
		return this._state.isChiuso();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
