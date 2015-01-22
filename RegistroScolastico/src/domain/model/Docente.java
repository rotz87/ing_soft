package domain.model;

import java.util.Collection;
import java.util.LinkedList;

public class Docente {

	private String nome;
	private String cognome;
	private long idDocente;
	private static long contaId = 0;
	private Collection<Classe> classi;
	
	
	
	public Docente() {
		this.idDocente = Docente.generaId();
		classi = new LinkedList<Classe>();
	}
	
	public Docente(String nome, String cognome) {
		this();
		this.nome = nome;
		this.cognome = cognome;
	}



	public boolean isInsegnante(Classe classe){
		boolean rit;
		if (classi.contains(classe)){
			rit = true;
		}else{
			rit = false;
		}
		return rit;
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
	
	/**
	 * @deprecated
	 * @return
	 */
	public Collection<Classe> getClassi() {
		return this.classi;
	}

	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
}