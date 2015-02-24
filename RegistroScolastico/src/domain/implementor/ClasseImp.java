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

	private Set<Studente> studenti = new HashSet<Studente>();
	
	
	public ClasseImp(){

	}
	
	public void inizialize(Classe classe, String nome){
		classe.setNome(nome);
	}
	
	public void inizialize(Classe classe, String nome, RegistroAssenze registroAssenze){
		inizialize(classe, nome);
		classe.setRegistroAssenze(registroAssenze);
	}

	public Set<Studente> getStudenti(Classe classe) {
		this.studenti.clear();
		
		for (LibrettoAssenze libretto : classe.getRegistroAssenze().getLibrettiAssenze().values()) {
			this.studenti.add(libretto.getStudente());
		}
		
		return this.studenti;
	}

	
}
