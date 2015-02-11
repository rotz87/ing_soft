package domain.implementor;

import java.util.Collection;
import java.util.LinkedList;

import domain.model.Classe;
import domain.model.Docente;

public class DocenteImp {
	
	
	public void inizialize(Docente docente) {
		docente.setClassi((Collection)new LinkedList<ClasseImp>());
	}
	
	public void inizialize(Docente docente, String nome, String cognome) {
		inizialize(docente);
		docente.setNome(nome);
		docente.setCognome(cognome);
	}

	public boolean isInsegnante(Docente docente, Classe classe){
		boolean rit;
		if (docente.getClassi().contains(classe)){
			rit = true;
		}else{
			rit = false;
		}
		return rit;
	}

}