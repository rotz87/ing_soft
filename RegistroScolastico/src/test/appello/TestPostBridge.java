package test.appello;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import controller.FaiAppelloController;
import service.RSPersistentManager;
import sviluppo.Stampa;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.LibrettoAssenzeCriteria;
import domain.model.RegistroAssenze;
import domain.model.RegistroAssenzeCriteria;
import domain.model.Studente;
import domain.model.StudenteCriteria;

public class TestPostBridge {
	public static void main(String[] args){
		main6(null);
		main3(null);
		main6(null);
	}
	public static void mai0(String[] args){
		
		Classe classeCorrente = new Classe("1A");
//		LinkedList<Classe> classi = new LinkedList<Classe>();
//		classi.add(classeCorrente);
		
		Docente docenteCorrente = new Docente("mario","rossi");
		docenteCorrente.getClassi().add(classeCorrente);
		
		RegistroAssenze regAss = new RegistroAssenze();
		classeCorrente.setRegistroAssenze(regAss);
		
		Studente pieroRusso = new Studente("Piero", "Russo");
		Studente marinoEsposito = new Studente("Marino", "Esposito");
		Studente marioRomano = new Studente("Mario", "Romano");
		
		LibrettoAssenze librettoMarioRomano = new LibrettoAssenze();
		marioRomano.setLibrettoAssenze(librettoMarioRomano);
		LibrettoAssenze librettoPieroRusso = new LibrettoAssenze();
		pieroRusso.setLibrettoAssenze(librettoPieroRusso);
		LibrettoAssenze librettoMarinoEsposito =  new LibrettoAssenze();
		marinoEsposito.setLibrettoAssenze(librettoMarinoEsposito);
		
		Map<Integer, LibrettoAssenze> librettiPrimaA = new HashMap<Integer, LibrettoAssenze>(); 
		librettiPrimaA.put(marioRomano.getID(), librettoMarioRomano);
		librettiPrimaA.put(pieroRusso.getID(), librettoPieroRusso);
		librettiPrimaA.put(marinoEsposito.getID(), librettoMarinoEsposito);
		
		
		
//		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>();
		classeCorrente.getStudenti().add(marioRomano);
		classeCorrente.getStudenti().add(marinoEsposito);
		classeCorrente.getStudenti().add(pieroRusso);
//		listaStudentiPrimaA.add(marioRomano);
//		listaStudentiPrimaA.add(marinoEsposito);
//		listaStudentiPrimaA.add(pieroRusso);
//		classeCorrente.setStudenti(listaStudentiPrimaA);
		
		
//		Studente[] studenti = {pieroRusso};
		Collection<LibrettoAssenze> libretti = new LinkedList<LibrettoAssenze>();
		libretti.add(pieroRusso.getLibrettoAssenze());
		
//		Stempa.stampaln("docente corrente: " + docenteCorrente.getCognome());
//		Stempa.stampaln("classe corrente: " + classeCorrente.getNome());
//		Stempa.stampaln("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
			registroAssenzeCorrente.registraAssenze(libretti);
//			DBFake.getInstance().storeAppello(registroAssenzeCorrente.getAppelloOdierno());
			Stampa.stampa("sono dopo avvia appello!!");
//			TestFaiLAppelloController1.stampaLibretti(registroAssenzeCorrente);
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
	
	public static void main1(String[] args){
		int idStud = 2;
		StudenteCriteria studC;
		try {
			studC = new StudenteCriteria();
			
			studC.ID.eq(idStud);
			Studente stud = studC.uniqueStudente();
			
			Stampa.stampaln("stud: " +stud.getNome());
			stud.setNome("Pippo");
			
			PersistentTransaction t =RSPersistentManager.instance().getSession().beginTransaction();
			try {
				RSPersistentManager.instance().getSession().update(stud);
				t.commit();
			} catch (Exception e) {
				t.rollback();
				e.printStackTrace();
			}
			
//			DBService.getInstance().save(stud);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args){
		int idClasse = 1;
		
		try {
//			RegistroAssenzeCriteria regAssC = new RegistroAssenzeCriteria();
//			regAssC.ID.eq(idReg);
//			RegistroAssenze regAss = regAssC.uniqueRegistroAssenze();
			
			ClasseCriteria classeC = new ClasseCriteria();
			classeC.ID.eq(idClasse);
			Classe classeCorrente = classeC.uniqueClasse();
			
			RegistroAssenze regAss = classeCorrente.getRegistroAssenze();
			
			regAss.avviaAppello();
			
			PersistentTransaction t =RSPersistentManager.instance().getSession().beginTransaction();
			try {
				RSPersistentManager.instance().getSession().save(regAss.getAppelloOdierno());
				t.commit();
			} catch (Exception e) {
				t.rollback();
				e.printStackTrace();
			}
			
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main3(String[] args){
		int idClasse = 1;
		int idDocente = 1;
		Integer[] idStudenti = {2,5,6};
		FaiAppelloController controller = new FaiAppelloController();
		try {

			try{
				controller.avviaAppello(idClasse, idDocente);
			}catch(IllegalStateException ise){
				
			}
//			controller.avviaAppello(idClasse, idDocente);
			controller.registraAssenze(idStudenti, idClasse, idDocente);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main4(String[] args){
//		Stampa.stampaln("INIZIO ");
		int[] studentiId = {1,5,7,9};
		StudenteCriteria studC;
		try {
			studC = new StudenteCriteria();
			
//			studC.add(Restrictions.eq("id", 1));
//			studC.add(Restrictions.eq("id", 3));
//			studC.add(Restrictions.eq("id", 5));
//			studC.add(Restrictions.eq("id", 9));
			
//			Criterion id1 = Restrictions.eq("id", 1);
			studC.ID.in(studentiId);
			List<Studente> studenti = studC.list();
			
			for(Studente s :studenti){
				Stampa.stampaln("stud: " +s.getNome());
			}
			
//			Stampa.stampaln("FINE ");
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
	
	public static void main5(String[] args){
		int idLib = 1;
		LibrettoAssenze libAss;
		
		try {
			LibrettoAssenzeCriteria libAssC = new LibrettoAssenzeCriteria();
			libAssC.ID.eq(idLib);
			libAss = libAssC.uniqueLibrettoAssenze();
			
			RegistroAssenzeCriteria regAssC = new RegistroAssenzeCriteria();
			regAssC.ID.eq(1);
			
			RegistroAssenze registroAssenze;
			registroAssenze = regAssC.uniqueRegistroAssenze();

			
			PersistentTransaction t =RSPersistentManager.instance().getSession().beginTransaction();
			try {
				if(registroAssenze.getAppelloOdierno() == null){
					registroAssenze.avviaAppello();
					RSPersistentManager.instance().getSession().update(registroAssenze);
				}
				libAss.segnaAssenza(registroAssenze.getAppelloOdierno());
				RSPersistentManager.instance().getSession().update(libAss);
				t.commit();
			} catch (Exception e) {
				t.rollback();
				e.printStackTrace();
			}			
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		
	}
	public static void main6(String[] args) {
		try{
			ClasseCriteria classeC = new ClasseCriteria();
			classeC.ID.eq(1);
			
			Classe classe = classeC.uniqueClasse();
			TestFaiLAppelloController1.stampaLibretti(classe);
		}catch(PersistentException e){
			e.printStackTrace();
		}
	}
	

}
