package domain.implementor;

import java.util.Collection;
import java.util.LinkedList;

public class DocenteImp {

	private String nome;
	private String cognome;
	private long idDocente;
	private static long contaId = 0;
	private Collection<ClasseImp> classi;
	
	
	
	public DocenteImp() {
		this.idDocente = DocenteImp.generaId();
		classi = new LinkedList<ClasseImp>();
	}
	
	public DocenteImp(String nome, String cognome) {
		this();
		this.nome = nome;
		this.cognome = cognome;
	}



	public boolean isInsegnante(ClasseImp classe){
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
	

	public void setClassi(Collection<ClasseImp> classi) {
		this.classi = classi;
	}
	
	/**
	 * @deprecated
	 * @return
	 */
	public Collection<ClasseImp> getClassi() {
		return this.classi;
	}

	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
}