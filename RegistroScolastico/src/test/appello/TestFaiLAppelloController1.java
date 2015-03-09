package test.appello;

import java.util.Iterator;
import java.util.Map.Entry;

import org.orm.PersistentException;

import service.Stampa;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.LibrettoAssenze;
import domain.model.RSPersistentManager;
import domain.model.RegistroAssenze;
import domain.model.RegistroAssenzeCriteria;
import domain.model.Studente;

public class TestFaiLAppelloController1 {
	public static void main(String[] args) throws PersistentException{
		Integer idClasseProva = new Integer(1);
		Integer idDocenteProva = new Integer(1);
		//creazione dal controller FaiAppelloConreoller
		FaiAppelloController controlloreAppello = new FaiAppelloController();

		stampaLibretti(getClasseById(idClasseProva));
		
		
		try{

			controlloreAppello.avviaAppello(idClasseProva, idDocenteProva);
		}catch(IllegalStateException ISE){
			Stampa.stampaln("Messaggio dell'eccezione: "+ISE.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Integer[] listaIdStudAssenti = {new Integer(3), new Integer(1), new Integer(5), new Integer(2)};//lista per classe con id 1
//		Long[] listaIdStudAssenti = {new Long(13), new Long(11), new Long(15), new Long(12)};//lista per classe con id 2
//		Long[] listaIdStudAssenti = {new Long(23), new Long(24)};//lista per classe con id 3
//		Long[] listaIdStudAssenti = {new Long(26), new Long(28)};//lista per classe con id 4
		
		
		try{
			controlloreAppello.registraAssenze(listaIdStudAssenti,idClasseProva, idDocenteProva );
		}catch(IllegalStateException ISE){
			Stampa.stampaln("Messaggio dell'eccezione: "+ISE.getMessage());
		}
		catch(NullPointerException NPE){
			Stampa.stampaln("NULL POITER EXCEPTION: "+NPE.getMessage());
		}
		
		
		//Stampa dei libretti
//		stampaLibretti(DBFake.getInstance().getClasseById(idClasseProva).getRegistroAssenze());
		stampaLibretti(getClasseById(idClasseProva));
		

	}
	
	public static void stampaLibretti(Classe classe){
		Stampa.stampaln();
		Stampa.stampaln("VISUALIZZAZIONE ASSENZE NON GIUSTIFICATE DEGLI STUDENTI _________________________ \n \n");

//		while (entries.hasNext()) {
		for(Studente stud : classe.getStudenti()){
		  LibrettoAssenze libAss = stud.getLibrettoAssenze();
		  Stampa.stampaln("STUDENTE : "+stud.getNome() +" "+stud.getCognome());
		  Stampa.stampaln("ASSENZE NON GIUSTIFICATE : \n");
		  if (/*libAss.getNonGiustificate() != null && */ (!(libAss.getNonGiustificate().isEmpty()))){
			  for (Assenza assNG : libAss.getNonGiustificate()) {
				  Stampa.stampaln("---------Inizio Assenza-------- ");
				  for (Appello app : assNG.getAppelli()){
					  Stampa.stampaln("data dell'appello dell'assenza : "+app.getData().toString());
				  }
				  if(assNG.isCertificatoMedicoRichiesto()){
					  Stampa.stampaln(" \n E' richiesto il certificato medico !! \n");  
				  }
				  Stampa.stampaln("-------Fine Assenza--------\n");
					
				}
			  Stampa.stampaln("-------fine studente---------- \n \n");
			}else{ Stampa.stampaln("\n non ci sono assenze non giustificate \n");}
		}
		Stampa.stampaln("________________________________________FINE");
		Stampa.stampaln();
		
	}
	
	private static Classe getClasseById(int idClasse){
		Classe ret;
		
		ret = null;
		try {
			try {
				
				
				domain.model.ClasseCriteria ldomainmodelClasseCriteria = new domain.model.ClasseCriteria();
				ldomainmodelClasseCriteria.ID.eq(idClasse);
				ret = ldomainmodelClasseCriteria.uniqueClasse();
			}
			finally {
				RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
