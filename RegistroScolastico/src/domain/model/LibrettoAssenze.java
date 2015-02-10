package domain.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LibrettoAssenze {

	private Collection<Assenza> giustificate;
	private List<Assenza> nonGiustificate;
	private Studente studente;
	private Collection<Ritardo> ritardi;
	private Collection<UscitaAnticipata> uscite;

	public LibrettoAssenze(){
		this.nonGiustificate = new LinkedList<Assenza>();
		this.giustificate = new LinkedList<Assenza>();
	}
	
	public LibrettoAssenze(Studente stud){
		this();
		this.studente = stud;
		
	}
	
	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(Appello appello) {
		
//		Stempa.stampaln("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		boolean inseribile = false;
		Assenza ultimaAssenzaNonGiustificata = null;
		
		if(!(nonGiustificate.isEmpty())){
			ultimaAssenzaNonGiustificata = this.getUltimaAssenzaNonGiustificata();
//			Stempa.stampaln("\n libretto di:  "+ this.getStudente().getNome() +" "+ this.getStudente().getCognome());
//			Stempa.stampaln("ultimo appello dell'ultima assenza non giustificata "+ this.getUltimaAssenzaNonGiustificata().getUltimoAppelloAssenza().getDataL()+"\n");
			inseribile = ultimaAssenzaNonGiustificata.isInseribile(appello);	
		}
		

		// dall'alt del SD
		if (inseribile){
			
			ultimaAssenzaNonGiustificata.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("accodo l'assenza " );
		}else{
			
			Assenza nuovaAssenza = new Assenza();
			nonGiustificate.add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("creo l'assenza " );
		}
		
	}

	private Assenza getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
//		Stempa.stampaln("nonGiustificate.get(0): "+nonGiustificate.get(nonGiustificate.size()-1).getUltimoAppelloAssenza().getDataL());

		return nonGiustificate.get(nonGiustificate.size()-1);
	}
	
	public boolean esisteAssenza(Appello appello){
		boolean rit = false;
		 ListIterator<Assenza> listIteratorNG = nonGiustificate.listIterator();
	        while (listIteratorNG.hasNext() && rit == false) {
	        	Assenza assenza = listIteratorNG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        ListIterator<Assenza> listIteratorG = nonGiustificate.listIterator();
	        while (listIteratorG.hasNext() && rit == false) {
	        	Assenza assenza = listIteratorG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        return rit;
	}
	
	public Assenza getAssenza(Appello appello){
		Assenza rit = null;
		
		ListIterator<Assenza> listIteratorNG = nonGiustificate.listIterator();
        while (listIteratorNG.hasNext()) {
        	Assenza assenza = listIteratorNG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
        ListIterator<Assenza> listIteratorG = nonGiustificate.listIterator();
        while (listIteratorG.hasNext()) {
        	Assenza assenza = listIteratorG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
		
		return rit;
	}
	
	public void assengnaAssenzeNonGiustificate(List<Assenza> nonGistificate){
		//per le prove, probablmente è da togliere
		this.nonGiustificate = nonGistificate;
	}

	public Collection<Assenza> getGiustificate() {
		return giustificate;
	}

	public void setGiustificate(Collection<Assenza> giustificate) {
		this.giustificate = giustificate;
	}

	public List<Assenza> getNonGiustificate() {
		return nonGiustificate;
	}

	public void setNonGiustificate(List<Assenza> nonGiustificate) {
		this.nonGiustificate = nonGiustificate;
	}

}