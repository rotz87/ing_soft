package test;

import java.awt.List;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import domain.*;

public class TestRegistraAssenze {
	public static void main(String[] args) {
		RegistroAssenzeController regAssCtrl = new RegistroAssenzeController();
		
		Map<String, LibrettoAssenze> librettiDaAssegnare;
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
		Date data10_12_14 = new GregorianCalendar(10,12,2014).getTime();
		Date data11_12_14 = new GregorianCalendar(11,12,2014).getTime();
		Date data12_12_14 = new GregorianCalendar(12,12,2014).getTime();
		Date data13_12_14 = new GregorianCalendar(13,12,2014).getTime();
		Date data14_12_14 = new GregorianCalendar(14,12,2014).getTime();
		Date data15_12_14 = new GregorianCalendar(15,12,2014).getTime();
		Date data16_12_14 = new GregorianCalendar(16,12,2014).getTime();
		
		//creazione di lista di appelli 
		LinkedList<Appello> AppelliAssenzeMaccio = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzePiero = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeIvo = new LinkedList<Appello>();
		
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
		AppelliAssenzeMaccio.add(appello12_12_14);
		
//		AppelliAssenzePiero.add(appello14_12_14);
//		AppelliAssenzePiero.add(appello15_12_14);
		AppelliAssenzePiero.add(appello10_12_14);
		AppelliAssenzePiero.add(appello11_12_14);
		AppelliAssenzePiero.add(appello14_12_14);
		
		AppelliAssenzeIvo.add(appello14_12_14);
		
		//assegnazione delle liste di appelli alle assenze
		Assenza assM1 = new Assenza(AppelliAssenzeMaccio);
		Assenza assP1 = new Assenza(AppelliAssenzePiero);
		Assenza assI1 = new Assenza(AppelliAssenzeIvo);
		
		//creazione delle liste di assenze da assegnare ai libretti
		LinkedList<Assenza> listaAssenzeMaccio = new  LinkedList<Assenza>();
		listaAssenzeMaccio.add(assM1);
		LinkedList<Assenza> listaAssenzePiero = new  LinkedList<Assenza>();
		listaAssenzePiero.add(assP1);
		LinkedList<Assenza> listaAssenzeIvo = new  LinkedList<Assenza>();
		listaAssenzeIvo.add(assI1);
		
		//assegnazione delle liste ai libretti
		librettoMaccio.assengnaAssenzeNonGiustificate(listaAssenzeMaccio);
		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzePiero);
		librettoIvo.assengnaAssenzeNonGiustificate(listaAssenzeIvo);
		
		//TEST DEL METODO
		regAssCtrl.avviaAppello();
		System.out.println("APPELLO AVVIATO, la data è : "+ regAssCtrl.getAppelloOdierno().getData().toString());
		
		regAssCtrl.registraAssenze(listaIdStud);
	}

}
