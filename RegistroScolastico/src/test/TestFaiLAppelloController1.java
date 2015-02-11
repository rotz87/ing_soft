package test;

import java.util.Iterator;
import java.util.Map.Entry;

import service.DBFake;
import service.Stampa;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
import domain.model.Assenza;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;

public class TestFaiLAppelloController1 {
	public static void main(String[] args){
		Long idClasseProva = new Long(1);
		Long idDocenteProva = new Long(1);
		//creazione dal controller FaiAppelloConreoller
		FaiAppelloController controlloreAppello = new FaiAppelloController();
		
		//TEST DEL METODO
//		Stampa.stampaln("studenti della 1A : " + primaA.getStudenti() );
		
		stampaLibretti(DBFake.getInstance().getClasseById(idClasseProva).getRegistroAssenze());
		
		try{

			controlloreAppello.avviaAppello(idClasseProva, idDocenteProva);
//			controlloreAppello.avviaAppello(new Long(1), new Long(2));
		}catch(IllegalStateException ISE){
			Stampa.stampaln("Messaggio dell'eccezione: "+ISE.getMessage());
		}
		
		Long[] listaIdStudAssenti = {new Long(3), new Long(1), new Long(5), new Long(2)};//lista per classe con id 1
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
		stampaLibretti(DBFake.getInstance().getClasseById(idClasseProva).getRegistroAssenze());
		

	}
	
	public static void stampaLibretti(RegistroAssenze regAss){
		Stampa.stampaln();
		Stampa.stampaln("VISUALIZZAZIONE ASSENZE NON GIUSTIFICATE DEGLI STUDENTI _________________________ \n \n");
		Iterator entries = regAss.getLibrettiAssenze().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Studente Stud = (Studente)thisEntry.getKey();
		  LibrettoAssenze libAss = (LibrettoAssenze)thisEntry.getValue();
		  Stampa.stampaln("STUDENTE : "+libAss.getStudente().getNome() +" "+libAss.getStudente().getCognome());
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
}
