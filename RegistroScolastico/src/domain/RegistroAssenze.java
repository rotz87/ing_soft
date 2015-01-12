package domain;

import java.util.*;
import org.joda.time.*;

public class RegistroAssenze {

	private Appello appelloOdierno;
	private MapAppelli appelli;
	private Collection<LibrettoAssenze> librettiAssenze;

	public Appello getAppelloOdierno() {
		return this.appelloOdierno;
	}

	public void setAppelloOdierno(Appello appelloOdierno) {
		this.appelloOdierno = appelloOdierno;
	}

	/**
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(String[] idStudenti) {
		// TODO - implement RegistroAssenze.registraAssenze
		throw new UnsupportedOperationException();
	}

	public void avviaAppello() {
		// TODO - implement RegistroAssenze.avviaAppello
		throw new UnsupportedOperationException();
	}

	public RegistroAssenze() {
		// TODO - implement RegistroAssenze.RegistroAssenze
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Appello getAppello(long id) {
		// TODO - implement RegistroAssenze.getAppello
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo per restituire un appello specifico, avendo la data
	 * serve per visualizzare un appello già fatto
	 * bottone visualizza dell'interfaccia
	 * @param data
	 */
	public Appello getAppelloByData(org.joda.time.LocalDate data) {
		// TODO - implement RegistroAssenze.getAppelloByData
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param librettiAssenze
	 */
	public void assengaLibretti(java.util.Map<String, LibrettoAssenze> librettiAssenze) {
		// TODO - implement RegistroAssenze.assengaLibretti
		throw new UnsupportedOperationException();
	}


	public class MapAppelli extends HashMap<LocalDate, Appello> {
	}

}