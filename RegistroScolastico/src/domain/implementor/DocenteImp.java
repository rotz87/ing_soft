package domain.implementor;

import domain.model.Classe;
import domain.model.Docente;

public class DocenteImp {
	
	
	public void inizialize(Docente docente) {

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