package test;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import service.DBFake;
import service.Stampa;
import domain.*;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;

public class TestPostBridge {
	public static void main(String[] args){
		
		
		Classe classeCorrente = new Classe("1A");
		LinkedList<Classe> classi = new LinkedList<Classe>();
		classi.add(classeCorrente);
		
		Docente docenteCorrente = new Docente("mario","rossi");
		docenteCorrente.setClassi(classi);
		
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
		
		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>();
		listaStudentiPrimaA.add(marioRomano);
		listaStudentiPrimaA.add(marinoEsposito);
		listaStudentiPrimaA.add(pieroRusso);
		classeCorrente.setStudenti(listaStudentiPrimaA);
		
		
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
			TestFaiLAppelloController1.stampaLibretti(registroAssenzeCorrente);
		}else{
			throw new IllegalStateException("ATTENZIONE IL DOCENTE NON E' ABILITATO AD ESEGUIRE L'APPELLO SULLA CLASSE SELEZIONATA");
		}
		
	}
}
