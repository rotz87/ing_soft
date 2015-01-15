package domain;

import org.joda.time.LocalDate;

public class Appello {

	private long idAppello;
	private boolean assenzePrese;

	/**
	 * @deprecated
	 * detiene il conteggio delle isranze create per generare l'idAppello.
	 */
	private static long contaId = 0;
	
	private LocalDate data;
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 * @param data
	 */
	
	public Appello(LocalDate data) {

		this.data = new LocalDate(data);
		this.assenzePrese = false;
		this.idAppello = Appello.generaId();
		
	}

	
	public LocalDate getData() {
		
		return this.data;
	
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


	public boolean isAssenzePrese() {
		return assenzePrese;
	}


	public void setAssenzePrese(boolean assenzePrese) {
		this.assenzePrese = assenzePrese;
	}
	
	

}