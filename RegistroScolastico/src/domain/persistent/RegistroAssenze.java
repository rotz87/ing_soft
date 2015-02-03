package domain.persistent;

import java.util.Map;
import java.util.TreeMap;

import org.joda.time.LocalDate;


public class RegistroAssenze implements IPersistentModel{

	private MapAppelli appelli;
	private Map <Studente, LibrettoAssenze> librettiAssenze;
	
	

	public class MapAppelli extends TreeMap<LocalDate, Appello> {
		
	}

}