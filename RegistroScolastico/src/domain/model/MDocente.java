package domain.model;

import java.util.Collection;
import java.util.LinkedList;

import domain.persistent.Docente;

public class MDocente  extends AModel<Docente>{

//	private String nome;
//	private String cognome;
//	private long idDocente;
//	private static long contaId = 0;
//	private Collection<MClasse> classi;
	
	
	
	public MDocente() {
		this.idDocente = MDocente.generaId();
		classi = new LinkedList<MClasse>();
	}
	
	public MDocente(String nome, String cognome) {
		this();
		this.nome = nome;
		this.cognome = cognome;
	}



	public boolean isInsegnante(MClasse classe){
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
	

	public void setClassi(Collection<MClasse> classi) {
		this.classi = classi;
	}
	
	/**
	 * @deprecated
	 * @return
	 */
	public Collection<MClasse> getClassi() {
		return this.classi;
	}

	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
}