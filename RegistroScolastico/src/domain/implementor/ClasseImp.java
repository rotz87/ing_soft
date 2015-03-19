package domain.implementor;

import java.util.HashSet;
import java.util.Set;

import domain.model.Classe;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;

/**
 * Contiene il registro delle assenze.
 * @author marco
 *
 */
public class ClasseImp {
	
	public ClasseImp(){

	}
	
	public void inizialize(Classe classe, String nome){
		classe.setNome(nome);
	}
	
	public void inizialize(Classe classe, String nome, RegistroAssenze registroAssenze){
		inizialize(classe, nome);
		classe.setRegistroAssenze(registroAssenze);
	}

	/**
	 * 
	 * @param classe
	 */
	public java.util.Set<Studente> getStudenti(Classe classe) {
		// TODO - implement ClasseImp.getStudenti
		throw new UnsupportedOperationException();
	}



	
}
