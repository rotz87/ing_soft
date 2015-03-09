package domain.implementor;

import java.util.HashSet;
import java.util.Set;

import domain.model.Classe;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.RegistroDocente;
import domain.model.Studente;

public class DocenteImp {
	private Set<Classe> classi = new HashSet<Classe>();
	
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

	public Set<Classe> getClassi(Docente docente) {
		this.classi.clear();
		for (RegistroDocente registroDoc : docente.getRegistriDocente()) {
			this.classi.add(registroDoc.getClasse());
		}
		
		return this.classi;
	}

	public boolean haRegistroDocente(Docente docente, RegistroDocente registro) {
		return docente.getRegistriDocente().contains(registro);
	}

}