package domain.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import domain.persistent.LibrettoAssenze;

public class MLibrettoAssenze  extends AModel<LibrettoAssenze>{

//	private Collection<MAssenza> giustificate;
//	private List<MAssenza> nonGiustificate;
//	private MStudente studente;
//	private Collection<MRitardo> ritardi;
//	private Collection<MUscitaAnticipata> uscite;

	public MLibrettoAssenze(){
		this.nonGiustificate = new LinkedList<MAssenza>();
		this.giustificate = new LinkedList<MAssenza>();
	}
	
	public MLibrettoAssenze(MStudente stud){
		this();
		this.studente = stud;
		
	}
	
	public MStudente getStudente() {
		return studente;
	}

	public void setStudente(MStudente studente) {
		this.studente = studente;
	}

	/**
	 * 
	 * @param appello
	 */
	public void segnaAssenza(MAppello appello) {
		
//		Stempa.stampaln("sono in librettoAssenze.segnaAssenza di " + studente.getNome());
		boolean inseribile = false;
		MAssenza ultimaAssenzaNonGiustificata = null;
		
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
			
			MAssenza nuovaAssenza = new MAssenza();
			nonGiustificate.add(nuovaAssenza);
			nuovaAssenza.inserisciAppelloAssenza(appello);
//			Stempa.stampaln("creo l'assenza " );
		}
		
	}

	private MAssenza getUltimaAssenzaNonGiustificata() {
		//probabilmente è da cambiare
//		Stempa.stampaln("nonGiustificate.get(0): "+nonGiustificate.get(nonGiustificate.size()-1).getUltimoAppelloAssenza().getDataL());

		return nonGiustificate.get(nonGiustificate.size()-1);
	}
	
	public boolean esisteAssenza(MAppello appello){
		boolean rit = false;
		 ListIterator<MAssenza> listIteratorNG = nonGiustificate.listIterator();
	        while (listIteratorNG.hasNext() && rit == false) {
	        	MAssenza assenza = listIteratorNG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        ListIterator<MAssenza> listIteratorG = nonGiustificate.listIterator();
	        while (listIteratorG.hasNext() && rit == false) {
	        	MAssenza assenza = listIteratorG.next();
	            if(assenza.esisteAppello(appello)){
	            	rit = true;
	            }
	        }
	        return rit;
	}
	
	public MAssenza getAssenza(MAppello appello){
		MAssenza rit = null;
		
		ListIterator<MAssenza> listIteratorNG = nonGiustificate.listIterator();
        while (listIteratorNG.hasNext()) {
        	MAssenza assenza = listIteratorNG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
        ListIterator<MAssenza> listIteratorG = nonGiustificate.listIterator();
        while (listIteratorG.hasNext()) {
        	MAssenza assenza = listIteratorG.next();
            if(assenza.esisteAppello(appello)){
            	rit = assenza;
            }
        }
		
		return rit;
	}
	
	public void assengnaAssenzeNonGiustificate(List<MAssenza> nonGistificate){
		//per le prove, probablmente è da togliere
		this.nonGiustificate = nonGistificate;
	}

	public Collection<MAssenza> getGiustificate() {
		return giustificate;
	}

	public void setGiustificate(Collection<MAssenza> giustificate) {
		this.giustificate = giustificate;
	}

	public List<MAssenza> getNonGiustificate() {
		return nonGiustificate;
	}

	public void setNonGiustificate(List<MAssenza> nonGiustificate) {
		this.nonGiustificate = nonGiustificate;
	}

}