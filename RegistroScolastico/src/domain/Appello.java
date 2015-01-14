package domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.LocalDate;

public class Appello {

	private long idAppello;

	/**
	 * @deprecated
	 * detiene il conteggio delle isranze create per generare l'idAppello.
	 */
	private static long contaId = 0;
	
	private LocalDate dataL;
	private Date data;

	/**
	 * Costruttore dell'appello senza parametri, imposta la data odierna.
	 */
	public Appello(){

		dataL = Calendario.getInstance().getDataOdierna();
		
	}
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 * @param data
	 */
	
	public Appello(LocalDate data) {

		dataL = new LocalDate(data);
		this.idAppello = Appello.generaId();
		
	}

	
	public LocalDate getDataL() {
		
		return this.dataL;
	
	}

	public long getIdAppello() {
		return idAppello;
	}

	public void setIdAppello(long idAppello) {
		this.idAppello = idAppello;
	}
	
	/**
	 * @deprecated
	 * Genera un idAppello progressivo, è stato inserito per le prove, 
	 * valutare se è il caso di tenerlo
	 * @return 
	 */
	private static long generaId(){
		contaId ++;
		return contaId;
		
	}

}