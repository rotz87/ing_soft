package domain.model;

import org.joda.time.LocalDate;
import org.orm.PersistentManager;

import domain.persistent.Appello;

public class MAppello extends AModel<Appello>{

//	private long idAppello;
//	private boolean assenzePrese;
//
//	/**
//	 * @deprecated
//	 * detiene il conteggio delle isranze create per generare l'idAppello.
//	 */
//	private static long contaId = 0;
//	
//	private LocalDate data;
	
	/**
	 * Costruttore dell'appello che prende come parametro la data.
	 * @param data
	 */

	public MAppello(LocalDate data) {
//		super();
//		this.data = new LocalDate(data);
//		this.assenzePrese = false;
//		this.idAppello = MAppello.generaId();


		getPersistentModel().setData(data.toDate());
		getPersistentModel().setAssenzePrese(false);
		
//		java.util.Date d = data.toDate();
//		LocalDate dd = new LocalDate(d);

	}

	
//	public LocalDate getData() {
//		
////		return this.data;
//		return getPersistentModel().getData();
//	
//	}

//	public long getIdAppello() {
////		return idAppello;
//		return getPersistentModel().getIdAppello();
//	}

//	public void setIdAppello(long idAppello) {
////		this.idAppello = idAppello;
//
//	}
	
//	/**
//	 * @deprecated
//	 * Genera un idAppello progressivo, è stato inserito per le prove, 
//	 * valutare se è il caso di tenerlo
//	 * @return 
//	 */
//	private static long generaId(){
//		contaId ++;
//		return contaId;
//		
//	}


//	public boolean isAssenzePrese() {
////		return assenzePrese;
//		return getPersistentModel().getAssenzePrese();
//	}


//	public void setAssenzePrese(boolean assenzePrese) {
////		this.assenzePrese = assenzePrese;
//		getPersistentModel().setAssenzePrese(assenzePrese);
//	}
	
	

}