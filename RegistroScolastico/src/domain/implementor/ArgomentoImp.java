package domain.implementor;

import domain.model.Argomento;

public class ArgomentoImp {

	public void inizialize(Argomento argomento, String nome, String descrizione) {
		argomento.setNome(nome);
		argomento.setDescrizione(descrizione);
		
	}

}
