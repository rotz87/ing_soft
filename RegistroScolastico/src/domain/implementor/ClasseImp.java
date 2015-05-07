package domain.implementor;

import domain.model.Classe;
import domain.model.RegistroAssenze;

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
	
}
