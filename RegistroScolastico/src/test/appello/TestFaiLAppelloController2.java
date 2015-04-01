package test.appello;

import org.orm.PersistentException;

import service.Stampa;
import domain.controller.FaiAppelloController;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.RegistroAssenze;
import domain.model.RegistroAssenzeCriteria;

public class TestFaiLAppelloController2 {
	
	private static RegistroAssenze getRegistroAssenzeByIdClasse(int idClasse){
		RegistroAssenze ret;
		
		ret = null;
		try {
			try {
				RegistroAssenzeCriteria registroAssenzeCriteria;
				
				domain.model.ClasseCriteria ldomainmodelClasseCriteria = new domain.model.ClasseCriteria();
				ldomainmodelClasseCriteria.ID.eq(idClasse);
				ret = ldomainmodelClasseCriteria.uniqueClasse().getRegistroAssenze();
			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static void stampaLibretti(Classe classe){
		TestFaiLAppelloController1.stampaLibretti(classe);
		
	}
	
	public static void main(String[] args){
		
		Integer idClasseProva = new Integer(1);
		Integer idDocenteProva = new Integer(1);
		//creazione dal controller FaiAppelloConreoller
		FaiAppelloController controlloreAppello = new FaiAppelloController();
		
		
		try{
			ClasseCriteria classeC = new ClasseCriteria();
			classeC.ID.eq(idClasseProva);
			Classe classeCorrente = classeC.uniqueClasse();
			
			stampaLibretti(classeCorrente);

			controlloreAppello.avviaAppello(idClasseProva, idDocenteProva);
//			controlloreAppello.avviaAppello(new Long(1), new Long(2));

		
			Integer[] listaIdStudAssenti = {new Integer(3), new Integer(1), new Integer(5), new Integer(2)};//lista per classe con id 1
//			Long[] listaIdStudAssenti = {new Long(13), new Long(11), new Long(15), new Long(12)};//lista per classe con id 2
//			Long[] listaIdStudAssenti = {new Long(23), new Long(24)};//lista per classe con id 3
//			Long[] listaIdStudAssenti = {new Long(26), new Long(28)};//lista per classe con id 4

			controlloreAppello.registraAssenze(listaIdStudAssenti,idClasseProva, idDocenteProva );
			
			//Stampa dei libretti
			stampaLibretti(classeCorrente);
		}catch(IllegalStateException ISE){
			Stampa.stampaln("Messaggio dell'eccezione: "+ISE.getMessage());
		}
		catch(NullPointerException NPE){
			Stampa.stampaln("NULL POINTER EXCEPTION: "+NPE.getMessage());
		} catch (PersistentException e) {
			e.printStackTrace();
		}

	}
	
}
