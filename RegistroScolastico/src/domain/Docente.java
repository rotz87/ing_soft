package domain;

import java.util.*;

public class Docente {

	private String nome;
	private String cognome;
	private long idDocente;
	private static long contaId = 0;
	private Collection<Classe> classi;
	
	
	
	public Docente() {
		this.idDocente = Docente.generaId();
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
	
	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
}