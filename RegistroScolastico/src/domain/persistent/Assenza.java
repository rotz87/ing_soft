package domain.persistent;


import java.util.LinkedList;

import org.joda.time.LocalDate;

import service.Stampa;

public class Assenza implements IPersistentModel{

	private LinkedList<Appello> appelli;
	private Giustificazione giustificazione;
	
	
}