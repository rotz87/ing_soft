package domain.implementor;

import java.sql.Date;

import domain.model.Argomento;

public class ArgomentoImp {

	public void inizialize(Argomento argomento, String nome, String descrizione) {
		argomento.setNome(nome);
		argomento.setDescrizione(descrizione);
		
	}

	public void inizialize(Argomento argomento, String nome, String descrizione, Date data) {
		inizialize(argomento, nome, descrizione);
		argomento.setData(data);
		
	}

}
