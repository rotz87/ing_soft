package domain.implementor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LibrettoAssenzeImp {

	private Collection<AssenzaImp> giustificate;
	private List<AssenzaImp> nonGiustificate;
	private StudenteImp studente;
	private Collection<RitardoImp> ritardi;
	private Collection<UscitaAnticipataImp> uscite;

	public LibrettoAssenzeImp(){
		this.nonGiustificate = new LinkedList<AssenzaImp>();
		this.giustificate = new LinkedList<AssenzaImp>();
	}
	
	public LibrettoAssenzeImp(StudenteImp stud){
		this();
		this.studente = stud;
		
	}
	
	public StudenteImp getStudente() {
		return studente;
	}

	public void setStudente(StudenteImp studente) {
		this.studente = studente;
	}

	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(AppelloImp appello) {
		
//		Stempa.stampaln("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		boolean inseribile = false;
		AssenzaImp ultimaAssenzaNonGiustificata = null;
		
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
			
			AssenzaImp nuovaAssenza = new AssenzaImp();
			nonGiustificate.add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("creo l'assenza " );
		}
		
	}

	private AssenzaImp getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
//		Stempa.stampaln("nonGiustificate.get(0): "+nonGiustificate.get(nonGiustificate.size()-1).getUltimoAppelloAssenza().getDataL());

		return nonGiustificate.get(nonGiustificate.size()-1);
	}
	
	public boolean esisteAssenza(AppelloImp appello){
		boolean rit = false;
		 ListIterator<AssenzaImp> listIteratorNG = nonGiustificate.listIterator();
	        while (listIteratorNG.hasNext() && rit == false) {
	        	AssenzaImp assenza = listIteratorNG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        ListIterator<AssenzaImp> listIteratorG = nonGiustificate.listIterator();
	        while (listIteratorG.hasNext() && rit == false) {
	        	AssenzaImp assenza = listIteratorG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        return rit;
	}
	
	public AssenzaImp getAssenza(AppelloImp appello){
		AssenzaImp rit = null;
		
		ListIterator<AssenzaImp> listIteratorNG = nonGiustificate.listIterator();
        while (listIteratorNG.hasNext()) {
        	AssenzaImp assenza = listIteratorNG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
        ListIterator<AssenzaImp> listIteratorG = nonGiustificate.listIterator();
        while (listIteratorG.hasNext()) {
        	AssenzaImp assenza = listIteratorG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
		
		return rit;
	}
	
	public void assengnaAssenzeNonGiustificate(List<AssenzaImp> nonGistificate){
		//per le prove, probablmente è da togliere
		this.nonGiustificate = nonGistificate;
	}

	public Collection<AssenzaImp> getGiustificate() {
		return giustificate;
	}

	public void setGiustificate(Collection<AssenzaImp> giustificate) {
		this.giustificate = giustificate;
	}

	public List<AssenzaImp> getNonGiustificate() {
		return nonGiustificate;
	}

	public void setNonGiustificate(List<AssenzaImp> nonGiustificate) {
		this.nonGiustificate = nonGiustificate;
	}

}