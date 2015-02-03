package domain.persistent;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LibrettoAssenze implements IPersistentModel{

	private Collection<Assenza> giustificate;
	private List<Assenza> nonGiustificate;
	private Studente studente;
	private Collection<Ritardo> ritardi;
	private Collection<UscitaAnticipata> uscite;



}