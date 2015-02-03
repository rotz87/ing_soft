package domain.persistent;

import java.util.Collection;
import java.util.HashSet;

/**
 * Conterrà il registro delle assenze.
 * Per il momento non verrà implementata in questo UC.
 * @author marco
 *
 */
public class Classe implements IPersistentModel{
	private String nome;
	private long idClasse;
	private RegistroAssenze registroAssenze;
	private Collection<Studente> studenti;
	

}
