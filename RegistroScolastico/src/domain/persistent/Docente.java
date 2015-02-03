package domain.persistent;

import java.util.Collection;
import java.util.LinkedList;

public class Docente implements IPersistentModel{

	private String nome;
	private String cognome;
	private long idDocente;
	private Collection<Classe> classi;
	
}