package test;

import java.awt.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.LocalDate;

import domain.*;

public class TestRegistraAssenze {
	public static Map<String, LibrettoAssenze> librettiDaAssegnare;
	
	public static void main(String[] args) {
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		
		
		librettiDaAssegnare = new HashMap<String, LibrettoAssenze>();
		
		//creazione Libretti
		LibrettoAssenze librettoMaccio = new LibrettoAssenze(new Studente("Maccio", "Capatonda"));
		LibrettoAssenze librettoHerbert =  new LibrettoAssenze(new Studente("Herbert", "Ballerina"));
		LibrettoAssenze librettoIvo = new LibrettoAssenze(new Studente("Ivo", "Avido"));
		LibrettoAssenze librettoPiero = new LibrettoAssenze(new Studente("Piero", "Peluria"));
		LibrettoAssenze librettoMarino =  new LibrettoAssenze(new Studente("Marino", "Peluria"));
		
		//composizione di una map di lbretti da assegnare al registo
		librettiDaAssegnare.put("Maccio", librettoMaccio);
		librettiDaAssegnare.put("Herbert",librettoHerbert);
		librettiDaAssegnare.put("Ivo", librettoIvo);
		librettiDaAssegnare.put("Piero", librettoPiero);
		librettiDaAssegnare.put("Marino",librettoMarino);
		
		//assegnazione dei libretti al registo
		regAssCtrl.assengaLibretti(librettiDaAssegnare);
		
		//inizializzazione vettore di id studenti assenti
		String[] listaIdStud = {"Maccio", "Piero","Ivo"};
		
		//recupero dell'appello odierno dal registro
		Appello appelloOdierno = regAssCtrl.getAppelloOdierno();
		
		//RIEMPIMENTO DELLE LISTE DI ASSENZE NON GIUSTIFICATE
		
		//creazione date
//		Calendar data10_12_14 = Calendar.getInstance();
//		data10_12_14.set(Calendar.YEAR, 2014);
//		data10_12_14.set(Calendar.MONTH, 11);
//		data10_12_14.set(Calendar.DAY_OF_MONTH, 10);
//		Calendar data11_12_14 = Calendar.getInstance();
//		data11_12_14.set(Calendar.YEAR, 2014);
//		data11_12_14.set(Calendar.MONTH, 11);
//		data11_12_14.set(Calendar.DAY_OF_MONTH, 11);
		
		// N.B. i mesi vanno da 0 a 11!!!!
//		Date data10_12_14 = new GregorianCalendar(2014,11,10).getTime();
//		Date data11_12_14 = new GregorianCalendar(2014,11,11).getTime();
//		Date data12_12_14 = new GregorianCalendar(2014,11,12).getTime();
//		Date data13_12_14 = new GregorianCalendar(2014,11,13).getTime();
//		Date data14_12_14 = new GregorianCalendar(2014,11,14).getTime();
//		Date data15_12_14 = new GregorianCalendar(2014,11,15).getTime();
//		Date data16_12_14 = new GregorianCalendar(2014,11,16).getTime();
//		Date data17_12_14 = new GregorianCalendar(2014,11,17).getTime();
		
		LocalDate data10_12_14 = new LocalDate(2014,12,10);
		LocalDate data11_12_14 = new LocalDate(2014,12,11);
		LocalDate data12_12_14 = new LocalDate(2014,12,12);
		LocalDate data13_12_14 = new LocalDate(2014,12,13);
		LocalDate data14_12_14 = new LocalDate(2014,12,14);
		LocalDate data15_12_14 = new LocalDate(2014,12,15);
		LocalDate data16_12_14 = new LocalDate(2014,12,16);
		LocalDate data17_12_14 = new LocalDate(2014,12,17);
		LocalDate dataTestFineMese = new LocalDate(2014,12,31);
		
//		String dataStringa = new String ("data : "+ data10_12_14.get(Calendar.DAY_OF_MONTH) +"/"+  data10_12_14.get(Calendar.MONTH) +"/"+  data10_12_14.get(Calendar.YEAR));
//		String dataStringa2 = new String ("data : "+ data11_12_14.get(Calendar.DAY_OF_MONTH) +"/"+  data11_12_14.get(Calendar.MONTH) +"/"+  data11_12_14.get(Calendar.YEAR));
//		System.out.println("------------------>>>Date:");
//		System.out.println(data10_12_14);
//		System.out.println(dataStringa );
//		System.out.println(data11_12_14 );
//		System.out.println(dataStringa2 + "\n __________________");
		
//		System.out.println("data 12 12 2014 "+data12_12_14 );
		
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
		Appello appelloTestFineMese = new Appello(dataTestFineMese);
		
		//assegnazione di appelli alle liste di appelli
		AppelliAssenzeMaccio.add(appello10_12_14);
		AppelliAssenzeMaccio.add(appello11_12_14);
//		AppelliAssenzeMaccio.add(appello12_12_14);
		 
//		AppelliAssenzePiero.add(appello14_12_14);
//		AppelliAssenzePiero.add(appello15_12_14);
//		AppelliAssenzePiero.add(appello10_12_14);
//		AppelliAssenzePiero.add(appello11_12_14);
		AppelliAssenzePiero.add(appello14_12_14);
		AppelliAssenzePiero.add(appello16_12_14);
		
		AppelliAssenzeIvo.add(appello13_12_14);
		AppelliAssenzeIvo.add(appello14_12_14);
		AppelliAssenzeIvo.add(appello15_12_14);
//		AppelliAssenzeIvo.add(appello16_12_14);
		
		AppelliAssenzeMarino.add(appello16_12_14);
		
		AppelliAssenzeHerbert.add(appello14_12_14);
		
		AppelliAssenzeTestFineMese.add(appelloTestFineMese);
		
		
		
		//assegnazione delle liste di appelli alle assenze
		Assenza assM1 = new Assenza(AppelliAssenzeMaccio);
		Assenza assP1 = new Assenza(AppelliAssenzePiero);
		Assenza assI1 = new Assenza(AppelliAssenzeIvo);
		Assenza assH1 = new Assenza(AppelliAssenzeHerbert);
		Assenza assMa1 = new Assenza(AppelliAssenzeMarino);
		Assenza assenzaFineMese = new Assenza(AppelliAssenzeTestFineMese);
		
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
		
		LinkedList<Assenza> listaAssenzeTsetFineMese = new  LinkedList<Assenza>();
		listaAssenzeTsetFineMese.add(assenzaFineMese);
		
		//assegnazione delle liste ai libretti
		librettoMaccio.assengnaAssenzeNonGiustificate(listaAssenzeMaccio);
		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzePiero);
//		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzeTsetFineMese);
		librettoIvo.assengnaAssenzeNonGiustificate(listaAssenzeIvo);
		librettoMarino.assengnaAssenzeNonGiustificate(listaAssenzeMarino);
		librettoHerbert.assengnaAssenzeNonGiustificate(listaAssenzeHerbert);
		
		//TEST DEL METODO
		visualizzaAssStud();
		regAssCtrl.avviaAppello();
		System.out.println("APPELLO AVVIATO, la data è : "+ regAssCtrl.getAppelloOdierno().getData().toString());
		
		regAssCtrl.registraAssenze(listaIdStud);
		
		visualizzaAssStud();
		
		
	}
	
	public static void visualizzaAssStud(){
		System.out.println();
		System.out.println("VISUALIZZAZIONE ASSENZE STUDENTI _________________________");
		Iterator entries = librettiDaAssegnare.entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  String idStud = (String)thisEntry.getKey();
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
