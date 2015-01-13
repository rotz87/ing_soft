package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import service.DBFake;
import domain.*;

public class TestFaiLAppelloController1 {
	public static void main(String[] args){
		//creazione dal controller FaiAppelloConreoller
		FaiAppelloController controlloreAppello = new FaiAppelloController();
		
		//creazione delle classi
		Classe primaA = new Classe("1A");
		Classe secondaA = new Classe("2A");
		
		Map<Long, Classe> mapClassi = new TreeMap <Long, Classe>();
		mapClassi.put(primaA.getIdClasse(), primaA);
		mapClassi.put(secondaA.getIdClasse(), secondaA);
		
		DBFake.getInstance().setClassi(mapClassi);
		
		//Crrazione dei docenti
		Docente marioRossi = new Docente("Mario", "Rossi");
		Docente mirkoBianchi = new Docente("Mirko", "Bianchi");
		
		Map<Long, Docente> mapDocenti = new TreeMap <Long, Docente>();
		mapDocenti.put(marioRossi.getIdDocente(), marioRossi);
		mapDocenti.put(mirkoBianchi.getIdDocente(), mirkoBianchi);
		
		DBFake.getInstance().setDocenti(mapDocenti);
		
		//assegnazione delle classi ai docenti
		
		Collection<Classe> classiDiRossi = new LinkedList<Classe>();
		classiDiRossi.add(primaA);
		classiDiRossi.add(secondaA);
		marioRossi.setClassi(classiDiRossi);
		
		Collection<Classe> classiDiBianchi = new LinkedList<Classe>();
		classiDiBianchi.add(primaA);
		mirkoBianchi.setClassi(classiDiBianchi);
		
		
		//Creazione degli studenti
		Studente pieroPeluria = new Studente("Piero", "Peluria");
		Studente marinoPeluria = new Studente("Marino", "Peluria");
		Studente maccioCapatonda = new Studente("Maccio", "Capatonda");
		Studente herbertBallerina = new Studente("Herbert", "Ballerina");
		Studente ivoAvido = new Studente("Ivo", "Avido");
		
		Map<Long, Studente> mapStudenti = new TreeMap <Long, Studente>();
		mapStudenti.put(pieroPeluria.getId(), pieroPeluria);
		mapStudenti.put(marinoPeluria.getId(), marinoPeluria);
		mapStudenti.put(maccioCapatonda.getId(), maccioCapatonda);
		mapStudenti.put(herbertBallerina.getId(), herbertBallerina);
		mapStudenti.put(ivoAvido.getId(), ivoAvido);
		
		DBFake.getInstance().setStudenti(mapStudenti);
		
		//assegnazione degli studenti alle classi
		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>(mapStudenti.values());
		primaA.setStudenti(listaStudentiPrimaA);
		
		//creazione Libretti
		 Map<Studente, LibrettoAssenze> librettiDaAssegnare = new HashMap<Studente, LibrettoAssenze>(); 
		 
		LibrettoAssenze librettoMaccio = new LibrettoAssenze(maccioCapatonda);
		LibrettoAssenze librettoHerbert =  new LibrettoAssenze(herbertBallerina);
		LibrettoAssenze librettoIvo = new LibrettoAssenze(ivoAvido);
		LibrettoAssenze librettoPiero = new LibrettoAssenze(pieroPeluria);
		LibrettoAssenze librettoMarino =  new LibrettoAssenze(marinoPeluria);
		
		librettiDaAssegnare.put(maccioCapatonda, librettoMaccio);
		librettiDaAssegnare.put(herbertBallerina,librettoHerbert);
		librettiDaAssegnare.put(ivoAvido, librettoIvo);
		librettiDaAssegnare.put(pieroPeluria, librettoPiero);
		librettiDaAssegnare.put(marinoPeluria,librettoMarino);
		
		//creazione del registro
		RegistroAssenze regAssPrimaA = new RegistroAssenze();
		
		//assegnazione del regitro alla classe primaA
		primaA.setRegistroAssenze(regAssPrimaA);
		
		//Assegnazione dei libretti al registro delle classe primaA
		regAssPrimaA.assengaLibretti(librettiDaAssegnare);
		
		//Creazione di un vettore di studenti per cui segnare l'assenza
		Long[] listaIdStudAssenti = {maccioCapatonda.getId(), pieroPeluria.getId(),ivoAvido.getId()};
		
		//recupero dell'appello odierno dal registro
		Appello appelloOdierno = regAssPrimaA.getAppelloOdierno();
		
		// creazione delle date
		LocalDate data10_12_14 = new LocalDate(2014,12,10);
		LocalDate data11_12_14 = new LocalDate(2014,12,11);
		LocalDate data12_12_14 = new LocalDate(2014,12,12);
		LocalDate data13_12_14 = new LocalDate(2014,12,13);
		LocalDate data14_12_14 = new LocalDate(2014,12,14);
		LocalDate data15_12_14 = new LocalDate(2014,12,15);
		LocalDate data16_12_14 = new LocalDate(2014,12,16);
		LocalDate data17_12_14 = new LocalDate(2014,12,17);
		
		//creazione di lista di appelli 
		LinkedList<Appello> AppelliAssenzeMaccio = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzePiero = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeIvo = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeMarino = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeHerbert = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeTestFineMese = new LinkedList<Appello>();
		
		//creazione di appelli
		Appello appello10_12_14 = new Appello(data10_12_14);
		Appello appello11_12_14 = new Appello(data11_12_14);
		Appello appello12_12_14 = new Appello(data12_12_14);
		Appello appello13_12_14 = new Appello(data13_12_14);
		Appello appello14_12_14 = new Appello(data14_12_14);
		Appello appello15_12_14 = new Appello(data15_12_14);
		Appello appello16_12_14 = new Appello(data16_12_14);
		
		//assegnazione di appelli alle liste di appelli
		AppelliAssenzeMaccio.add(appello10_12_14);
		AppelliAssenzeMaccio.add(appello11_12_14);
//				AppelliAssenzeMaccio.add(appello12_12_14);
		 
		AppelliAssenzePiero.add(appello10_12_14);
		AppelliAssenzePiero.add(appello11_12_14);
		AppelliAssenzePiero.add(appello12_12_14);
//				AppelliAssenzePiero.add(appello16_12_14);
		
		AppelliAssenzeIvo.add(appello13_12_14);
		AppelliAssenzeIvo.add(appello14_12_14);
		AppelliAssenzeIvo.add(appello15_12_14);
		AppelliAssenzeIvo.add(appello16_12_14);
		
		AppelliAssenzeMarino.add(appello16_12_14);
		
		AppelliAssenzeHerbert.add(appello14_12_14);
		
		
		//assegnazione delle liste di appelli alle assenze
		Assenza assM1 = new Assenza(AppelliAssenzeMaccio);
		Assenza assP1 = new Assenza(AppelliAssenzePiero);
		Assenza assI1 = new Assenza(AppelliAssenzeIvo);
		Assenza assH1 = new Assenza(AppelliAssenzeHerbert);
		Assenza assMa1 = new Assenza(AppelliAssenzeMarino);
		
		//creazione delle liste di assenze da assegnare ai libretti
		LinkedList<Assenza> listaAssenzeMaccio = new  LinkedList<Assenza>();
		listaAssenzeMaccio.add(assM1);
		LinkedList<Assenza> listaAssenzePiero = new  LinkedList<Assenza>();
		listaAssenzePiero.add(assP1);
		LinkedList<Assenza> listaAssenzeIvo = new  LinkedList<Assenza>();
		listaAssenzeIvo.add(assI1);
		LinkedList<Assenza> listaAssenzeHerbert = new  LinkedList<Assenza>();
		listaAssenzeHerbert.add(assH1);
		LinkedList<Assenza> listaAssenzeMarino = new  LinkedList<Assenza>();
		listaAssenzeMarino.add(assMa1);
		
		
		//assegnazione delle liste ai libretti
		librettoMaccio.assengnaAssenzeNonGiustificate(listaAssenzeMaccio);
		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzePiero);
//		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzeTsetFineMese);
		librettoIvo.assengnaAssenzeNonGiustificate(listaAssenzeIvo);
		librettoMarino.assengnaAssenzeNonGiustificate(listaAssenzeMarino);
		librettoHerbert.assengnaAssenzeNonGiustificate(listaAssenzeHerbert);
		
		//TEST DEL METODO
//		System.out.println("studenti della 1A : " + primaA.getStudenti() );
		
		stampaLibretti(regAssPrimaA);
		
		controlloreAppello.avviaAppello(primaA.getIdClasse(), marioRossi.getIdDocente());
		
		controlloreAppello.registraAssenze(listaIdStudAssenti,primaA.getIdClasse(), marioRossi.getIdDocente() );
		
		//Stampa dei libretti
		stampaLibretti(regAssPrimaA);
		
		
		
	}
	
	private static void stampaLibretti(RegistroAssenze regAss){
		System.out.println();
		System.out.println("VISUALIZZAZIONE ASSENZE STUDENTI _________________________");
		Iterator entries = regAss.getLibrettiAssenze().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Studente Stud = (Studente)thisEntry.getKey();
		  LibrettoAssenze libAss = (LibrettoAssenze)thisEntry.getValue();
		  System.out.println("STUDENTE : "+libAss.getStudente().getNome() +" "+libAss.getStudente().getCognome());
		  System.out.println("ASSENZE NON GIUSTIFICATE :");
		  for (Assenza assNG : libAss.getNonGiustificate()) {
			  System.out.println("---------Inizio Assenza--------");
			  for (Appello app : assNG.getAppelli()){
				  System.out.println("data dell'appello dell'assenza : "+app.getDataL().toString());
			  }
			  System.out.println("-------Fine Assenza--------");
				
			}
		  System.out.println("-----------------");
		}
		System.out.println("________________________________________FINE");
		System.out.println();
		
	}
}
