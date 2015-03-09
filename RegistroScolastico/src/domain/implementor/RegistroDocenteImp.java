package domain.implementor;

import domain.model.CompitoInClasse;
import domain.model.RegistroDocente;

public class RegistroDocenteImp {

	public CompitoInClasse creaCompito(RegistroDocente registroDocente) {
		CompitoInClasse compito;
		
		compito = new CompitoInClasse();
		compito.setInsegnamento(registroDocente);
		registroDocente.getCompitiInClasse().add(compito);
		
		return compito;
	}
	
	

}
