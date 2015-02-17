package test;

import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.orm.PersistentException;

import service.DBFake;
import service.DBService;
import service.Stampa;
import domain.*;
import domain.controller.FaiAppelloController;
import domain.model.Appello;
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
	public static void mainn(String[] args){
		
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
		
		LibrettoAssenze librettoMarioRomano = new LibrettoAssenze(marioRomano);
		LibrettoAssenze librettoPieroRusso = new LibrettoAssenze(pieroRusso);
		LibrettoAssenze librettoMarinoEsposito =  new LibrettoAssenze(marinoEsposito);
		
		Map<Integer, LibrettoAssenze> librettiPrimaA = new HashMap<Integer, LibrettoAssenze>(); 
		librettiPrimaA.put(marioRomano.getId(), librettoMarioRomano);
		librettiPrimaA.put(pieroRusso.getId(), librettoPieroRusso);
		librettiPrimaA.put(marinoEsposito.getId(), librettoMarinoEsposito);
		
		regAss.setLibrettiAssenze(librettiPrimaA);
		
//		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>();
		classeCorrente.getStudenti().add(marioRomano);
		classeCorrente.getStudenti().add(marinoEsposito);
		classeCorrente.getStudenti().add(pieroRusso);
//		listaStudentiPrimaA.add(marioRomano);
//		listaStudentiPrimaA.add(marinoEsposito);
//		listaStudentiPrimaA.add(pieroRusso);
//		classeCorrente.setStudenti(listaStudentiPrimaA);
		
		
		Studente[] studenti = {pieroRusso};
		
//		Stempa.stampaln("docente corrente: " + docenteCorrente.getCognome());
//		Stempa.stampaln("classe corrente: " + classeCorrente.getNome());
//		Stempa.stampaln("lista classi: " + docenteCorrente.getClassi().toString());
		
		if(docenteCorrente.isInsegnante(classeCorrente)){
			RegistroAssenze registroAssenzeCorrente = classeCorrente.getRegistroAssenze();
			registroAssenzeCorrente.avviaAppello();
			registroAssenzeCorrente.registraAssenze(studenti);
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
			
			studC.id.eq(idStud);
			Studente stud = studC.uniqueStudente();
			
			Stampa.stampaln("stud: " +stud.getNome());
			stud.setNome("Pippo");
			
			DBService.getInstance().save(stud);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
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
			classeC.idClasse.eq(idClasse);
			Classe classeCorrente = classeC.uniqueClasse();
			
			RegistroAssenze regAss = classeCorrente.getRegistroAssenze();
			
			regAss.avviaAppello();
			DBService.getInstance().save(regAss.getAppelloOdierno());
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args){
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
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
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
			studC.id.in(studentiId);
			List<Studente> studenti = studC.list();
			
			for(Studente s :studenti){
				Stampa.stampaln("stud: " +s.getNome());
			}
			
//			Stampa.stampaln("FINE ");
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
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

			if(registroAssenze.getAppelloOdierno() == null){
				registroAssenze.avviaAppello();
				DBService.getInstance().update(registroAssenze);
			}
			
			
			libAss.segnaAssenza(registroAssenze.getAppelloOdierno());
			DBService.getInstance().update(libAss);
			
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main6(String[] args) throws PersistentException{
		RegistroAssenzeCriteria regAssC = new RegistroAssenzeCriteria();
		regAssC.ID.eq(1);
		
		RegistroAssenze registroAssenze;
		registroAssenze = regAssC.uniqueRegistroAssenze();
		TestFaiLAppelloController1.stampaLibretti(registroAssenze);
	}

}
