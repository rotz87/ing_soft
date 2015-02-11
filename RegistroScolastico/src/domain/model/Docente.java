package domain.model;

import java.util.Collection;
import java.util.LinkedList;

import domain.implementor.DocenteImp;

public class Docente {

	private String nome;
	private String cognome;
	private long idDocente;
	private Collection<Classe> classi;
	private DocenteImp implementor;
	
	
	public Docente() {
		implementor = new DocenteImp();
		this.implementor.inizialize(this);
	}
	
	public Docente(String nome, String cognome) {
		implementor = new DocenteImp();
		this.implementor.inizialize(this, nome, cognome);
	}



	public boolean isInsegnante(Classe classe){
		return this.implementor.isInsegnante(this, classe);
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public long getIdDocente() {
		return idDocente;
	}
	

	public void setClassi(Collection<Classe> classi) {
		this.classi = classi;
	}
	

	public Collection<Classe> getClassi() {
		return this.classi;
	}

}