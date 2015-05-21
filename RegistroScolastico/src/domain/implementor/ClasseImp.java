package domain.implementor;

import domain.model.Classe;
import domain.model.RegistroAppelli;

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
	
	public void inizialize(Classe classe, String nome, RegistroAppelli registroAppelli){
		inizialize(classe, nome);
		classe.setRegistroAppelli(registroAppelli);
	}
	
}
