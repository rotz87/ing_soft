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
	
	private domain.model.Classe classe;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setClasse(domain.model.Classe value) {
		this.classe = value;
	}
	
	public domain.model.Classe getClasse() {
		return classe;
	}
	
//	domain.model.Materia materia;
	
	private java.util.Set compitiInClasse;
	
	java.util.Set argomentiSvolti;
	
	public void creaCompito() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
//	public void inserisciDatiCompito(domain.model.CompitoInClasse compito, java.util.Date data, java.sql.Time ora, int durata, domain.model.Argomento[] argomenti) {
//		//TODO: Implement Method
//		throw new UnsupportedOperationException();
//	}
//	
//	public boolean compitoPresente(domain.model.CompitoInClasse compito) {
//		//TODO: Implement Method
//		throw new UnsupportedOperationException();
//	}
//	
//	public void inserisciStudenti(domain.model.CompitoInClasse compito, domain.model.Studente[] studenti) {
//		//TODO: Implement Method
//		throw new UnsupportedOperationException();
//	}
//	
//	public void inserisciVoti(domain.model.CompitoInClasse compito, presenter.resourcesupport.StudenteAppelloRS[] studenti, domain.model.Voto[] voti) {
//		//TODO: Implement Method
//		throw new UnsupportedOperationException();
//	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
