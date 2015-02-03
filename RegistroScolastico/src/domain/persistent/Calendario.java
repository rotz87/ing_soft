package domain.persistent;

import java.util.LinkedList;
import java.util.TreeSet;

import org.joda.time.LocalDate;

public class Calendario implements IPersistentModel{

	private LocalDate dataOdierna;
	private  TreeSet<LocalDate> giorniFestivi;
	private LinkedList<Integer> giorniSettimanaliFestivi;
	
	
	
}
