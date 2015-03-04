package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;



public class DBFake {
	
	private static DBFake instance;
	
	private Map<Integer, Classe> classi;
	private Map<Integer, Docente> docenti;
	private Map<Integer, Studente> tuttiGliStudenti;
	private Map<Integer, Appello> tuttiGliAppelli;
	  // Private constructor prevents instantiation from other classes
	private DBFake() {
		  classi = new TreeMap<Integer, Classe>();
		  docenti = new TreeMap<Integer, Docente>();
		  tuttiGliStudenti = new TreeMap<Integer, Studente>();
		  tuttiGliAppelli = new TreeMap<Integer, Appello>();
		  
		  initDB();
	}
	 
	  /**
	   * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
	   * or the first access to SingletonHolder.INSTANCE, not before.
	   */


	public static synchronized DBFake getInstance() {
	    if(DBFake.instance == null){
	    	DBFake.instance = new DBFake();
	    }
	    return DBFake.instance;
	}
	
	public void setClassi( Map<Integer, Classe> classi){
		this.classi = classi;
	}

	public void setDocenti( Map<Integer, Docente> docenti){
		this.docenti = docenti;
	}
	
	public void setStudenti(Map<Integer, Studente> studenti){
		this.tuttiGliStudenti = studenti;
	}
	
	public Classe getClasseById(int idClasse){
		return classi.get(idClasse);
	}
	
	public Docente getDocenteById(int idDocente){
		return docenti.get(idDocente);
	}
	public Studente getStudenteById(Integer idStudente){
		return tuttiGliStudenti.get(idStudente);
	}
	
	public Appello getAppelloById(int idAppello){
		return tuttiGliAppelli.get(idAppello);
	}
	
	public void storeAppello(Appello appello){
		tuttiGliAppelli.put(appello.getID(), appello);
	}
	
	
	private void initDB(){
		
		//creazione delle classi
		Classe primaA = new Classe("1A");
		Classe secondaA = new Classe("2A");
		Classe primaB = new Classe("1B");
		Classe secondaB = new Classe("2B");
		
		Map<Integer, Classe> mapClassi = new TreeMap <Integer, Classe>();
		mapClassi.put(primaA.getID(), primaA);
		mapClassi.put(secondaA.getID(), secondaA);
		mapClassi.put(primaB.getID(), primaB);
		mapClassi.put(secondaB.getID(), secondaB);
		
		setClassi(mapClassi);
		
		//Crrazione dei docenti
		Docente marioRossi = new Docente("Mario", "Rossi");
		Docente mirkoBianchi = new Docente("Mirko", "Bianchi");
		Docente giulioVerdi = new Docente("Giulio", "Verdi");
		Docente vincenzoNeri = new Docente("Vincenzo", "Neri");
		Docente giuseppeGialli = new Docente("Giuseppe", "Gialli");
		
		Map<Integer, Docente> mapDocenti = new TreeMap <Integer, Docente>();
		mapDocenti.put(marioRossi.getID(), marioRossi);
		mapDocenti.put(mirkoBianchi.getID(), mirkoBianchi);
		mapDocenti.put(giulioVerdi.getID(), giulioVerdi);
		mapDocenti.put(vincenzoNeri.getID(), vincenzoNeri);
		mapDocenti.put(giuseppeGialli.getID(), giuseppeGialli);
		
		
		setDocenti(mapDocenti);
		
		//assegnazione delle classi ai docenti
		
		//assegnazione delle classi a Rossi
		Set<Classe> classiDiRossi = new HashSet<Classe>();
		classiDiRossi.add(primaA);
		classiDiRossi.add(secondaA);
		classiDiRossi.add(primaB);
		classiDiRossi.add(secondaB);
//		marioRossi.setClassi(classiDiRossi);
		
		//assegnazione delle classi a Rossi
		Set<Classe> classiDiBianchi = new HashSet<Classe>();
		classiDiBianchi.add(primaA);
		classiDiBianchi.add(primaB);
//		mirkoBianchi.setClassi(classiDiBianchi);
		
		
		//Creazione degli studenti
//		Studente  = new Studente("", "");
		Studente pieroRusso = new Studente("Piero", "Russo");
		Studente marinoEsposito = new Studente("Marino", "Esposito");
		Studente marioRomano = new Studente("Mario", "Romano");
		Studente davideDiSalvo = new Studente("Davide", "Di Salvo");
		Studente ivoMarino = new Studente("Ivo", "Marini");
		Studente leonardoRicci = new Studente("Leonardo", "Ricci");
		Studente valentinoFarina = new Studente("Valentino", "Farina");
		Studente roccoBenedetti = new Studente("Rocco", "Benedetti");
		Studente antonioGuerra = new Studente("Antonio", "Guerra");
		Studente cristinaAngeli = new Studente("Cristina", "Angeli");
		
		Studente mariannaDonati = new Studente("Marianna", "Donati");
		Studente elenaSarti = new Studente("Elena", "Sarti");
		Studente mariaPiaAlfredi = new Studente("MariaPia", "Alfredi");
		Studente giorgioGatti = new Studente("Giorgio", "Gatti");
		Studente lorenzoNegri = new Studente("Lorenzo", "Negri");
		Studente mattiaVitali = new Studente("Mattia", "Vitali");
		Studente emanueleDelMonte = new Studente("Emanuele", "Del Monte");
		Studente luigiBernardi = new Studente("Luigi", "Bernardi");
		Studente vittorioPellegrini = new Studente("Vittorio", "Pellegrini");
		Studente alexVilla = new Studente("Alex", "Villa");
		
		Studente marcoBattaglia = new Studente("Marco", "Battaglia");
		Studente alfredoMorelli = new Studente("Alfredo", "Morelli");
		Studente pieraDellaValle = new Studente("Piera", "Della Valle");
		Studente ignazioBoschi = new Studente("Ignazio", "Boschi");
		Studente jacopoValli = new Studente("Jacopo", "Valli");
		
		Studente gianniConte = new Studente("Gianni", "Conte");
		Studente lucaBarone = new Studente("Luca", "Barone");
		Studente giacomoSiciliano = new Studente("Giacomo", "Siciliano");
		Studente fabrizioToscani = new Studente("Fabrizio", "Toscani");
		Studente arturoAncona = new Studente("Arturo", "Ancona");
		
		Map<Integer, Studente> mapStudenti = new TreeMap <Integer, Studente>();
//		mapStudenti.put(.getId(), );
		mapStudenti.put(pieroRusso.getID(), pieroRusso);
		mapStudenti.put(marinoEsposito.getID(), marinoEsposito);
		mapStudenti.put(marioRomano.getID(), marioRomano);
		mapStudenti.put(davideDiSalvo.getID(), davideDiSalvo);
		mapStudenti.put(ivoMarino.getID(), ivoMarino);
		mapStudenti.put(leonardoRicci.getID(),leonardoRicci );
		mapStudenti.put(valentinoFarina.getID(), valentinoFarina);
		mapStudenti.put(roccoBenedetti.getID(), roccoBenedetti);
		mapStudenti.put(antonioGuerra.getID(), antonioGuerra);
		mapStudenti.put(cristinaAngeli.getID(),cristinaAngeli );
		
		mapStudenti.put(mariannaDonati.getID(), mariannaDonati);
		mapStudenti.put(elenaSarti.getID(), elenaSarti);
		mapStudenti.put(mariaPiaAlfredi.getID(), mariaPiaAlfredi);
		mapStudenti.put(giorgioGatti.getID(),giorgioGatti );
		mapStudenti.put(lorenzoNegri.getID(),lorenzoNegri );
		mapStudenti.put(mattiaVitali.getID(), mattiaVitali);
		mapStudenti.put(emanueleDelMonte.getID(), emanueleDelMonte);
		mapStudenti.put(luigiBernardi.getID(), luigiBernardi);
		mapStudenti.put(vittorioPellegrini.getID(),vittorioPellegrini );
		mapStudenti.put(alexVilla.getID(), alexVilla);
		
		mapStudenti.put(marcoBattaglia.getID(), marcoBattaglia);
		mapStudenti.put(alfredoMorelli.getID(),alfredoMorelli );
		mapStudenti.put(pieraDellaValle.getID(),pieraDellaValle );
		mapStudenti.put(ignazioBoschi.getID(), ignazioBoschi);
		mapStudenti.put( jacopoValli.getID(), jacopoValli );
		
		mapStudenti.put(gianniConte.getID(), gianniConte);
		mapStudenti.put(lucaBarone.getID(), lucaBarone);
		mapStudenti.put(giacomoSiciliano.getID(), giacomoSiciliano);
		mapStudenti.put(fabrizioToscani.getID(), fabrizioToscani);
		mapStudenti.put(arturoAncona.getID(), arturoAncona);
		
		setStudenti(mapStudenti);
		
		//assegnazione degli studenti alle classi

		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>();
		Set<Studente> listaStudentiSecondaA = new HashSet<Studente>();
		Set<Studente> listaStudentiPrimaB = new HashSet<Studente>();
		Set<Studente> listaStudentiSecondaB = new HashSet<Studente>();
		
		int i = new Integer(1);
		
		for(i = 1; i<11; i++){
			listaStudentiPrimaA.add(mapStudenti.get(i));
		}
		for(i = 11; i<21; i++){
			listaStudentiSecondaA.add(mapStudenti.get(i));
		}
		for(i = 21; i<26; i++){
			listaStudentiPrimaB.add(mapStudenti.get(i));
		}
		for(i = 26; i<=mapStudenti.size(); i++){
			listaStudentiSecondaB.add(mapStudenti.get(i));
		}
//		primaA.setStudenti(listaStudentiPrimaA);
//		secondaA.setStudenti(listaStudentiSecondaA);
//		primaB.setStudenti(listaStudentiPrimaB);
//		secondaB.setStudenti(listaStudentiSecondaB);
		
		//creazione Libretti
		 Map<Integer, LibrettoAssenze> librettiPrimaA = new HashMap<Integer, LibrettoAssenze>(); 
		 Map<Integer, LibrettoAssenze> librettiSecondaA = new HashMap<Integer, LibrettoAssenze>();
		 Map<Integer, LibrettoAssenze> librettiPrimaB = new HashMap<Integer, LibrettoAssenze>();
		 Map<Integer, LibrettoAssenze> librettiSecondaB = new HashMap<Integer, LibrettoAssenze>();

//			LibrettoAssenze libretto =  new LibrettoAssenze();
		LibrettoAssenze librettoMarioRomano = new LibrettoAssenze(marioRomano);
		LibrettoAssenze librettoDavideDiSalvo =  new LibrettoAssenze(davideDiSalvo);
		LibrettoAssenze librettoIvoMarino = new LibrettoAssenze(ivoMarino);
		LibrettoAssenze librettoPieroRusso = new LibrettoAssenze(pieroRusso);
		LibrettoAssenze librettoMarinoEsposito =  new LibrettoAssenze(marinoEsposito);
		LibrettoAssenze librettoLeonardoRicci =  new LibrettoAssenze(leonardoRicci);
		LibrettoAssenze librettoValentinoFarina =  new LibrettoAssenze(valentinoFarina);
		LibrettoAssenze librettoRoccoBenedetti =  new LibrettoAssenze(roccoBenedetti);
		LibrettoAssenze librettoAntonioGuerra =  new LibrettoAssenze(antonioGuerra);
		LibrettoAssenze librettoCristinaAngeli =  new LibrettoAssenze(cristinaAngeli);
		
		LibrettoAssenze librettoMariannaDonati =  new LibrettoAssenze(mariannaDonati);
		LibrettoAssenze librettoElenaSarti =  new LibrettoAssenze(elenaSarti);
		LibrettoAssenze librettoMariaPiaAlfredi =  new LibrettoAssenze(mariaPiaAlfredi);
		LibrettoAssenze librettoGiorgioGatti =  new LibrettoAssenze(giorgioGatti);
		LibrettoAssenze librettoLorenzoNegri =  new LibrettoAssenze(lorenzoNegri);
		LibrettoAssenze librettoMattiaVitali =  new LibrettoAssenze(mattiaVitali);
		LibrettoAssenze librettoEmanueleDelMonte =  new LibrettoAssenze(emanueleDelMonte);
		LibrettoAssenze librettoLuigiBernardi =  new LibrettoAssenze(luigiBernardi);
		LibrettoAssenze librettoVittorioPellegrini =  new LibrettoAssenze(vittorioPellegrini);
		LibrettoAssenze librettoAlexVilla =  new LibrettoAssenze(alexVilla);
		
		LibrettoAssenze librettoMarcoBattaglia =  new LibrettoAssenze(marcoBattaglia);
		LibrettoAssenze librettoAlfredoMorelli =  new LibrettoAssenze(alfredoMorelli);
		LibrettoAssenze librettoPieraDellaValle =  new LibrettoAssenze(pieraDellaValle);
		LibrettoAssenze librettoIgnazioBoschi =  new LibrettoAssenze(ignazioBoschi);
		LibrettoAssenze librettoJacopoValli =  new LibrettoAssenze(jacopoValli);
		
		LibrettoAssenze librettoGianniConte =  new LibrettoAssenze(gianniConte);
		LibrettoAssenze librettoLucaBarone =  new LibrettoAssenze(lucaBarone);
		LibrettoAssenze librettoGiacomoSiciliano =  new LibrettoAssenze(giacomoSiciliano);
		LibrettoAssenze librettoFabrizioToscani =  new LibrettoAssenze(fabrizioToscani);
		LibrettoAssenze librettoArturoAncona =  new LibrettoAssenze(arturoAncona);
		
		librettiPrimaA.put(marioRomano.getID(), librettoMarioRomano);
		librettiPrimaA.put(davideDiSalvo.getID(),librettoDavideDiSalvo);
		librettiPrimaA.put(ivoMarino.getID(), librettoIvoMarino);
		librettiPrimaA.put(pieroRusso.getID(), librettoPieroRusso);
		librettiPrimaA.put(marinoEsposito.getID(),librettoMarinoEsposito);
		librettiPrimaA.put(leonardoRicci.getID(),librettoLeonardoRicci);
		librettiPrimaA.put(valentinoFarina.getID(),librettoValentinoFarina);
		librettiPrimaA.put(roccoBenedetti.getID(),librettoRoccoBenedetti);
		librettiPrimaA.put(antonioGuerra.getID(),librettoAntonioGuerra);
		librettiPrimaA.put(cristinaAngeli.getID(),librettoCristinaAngeli);
		
		librettiSecondaA.put(mariannaDonati.getID(),librettoMariannaDonati);
		librettiSecondaA.put(elenaSarti.getID(),librettoElenaSarti);
		librettiSecondaA.put(mariaPiaAlfredi.getID(),librettoMariaPiaAlfredi);
		librettiSecondaA.put(giorgioGatti.getID(),librettoGiorgioGatti);
		librettiSecondaA.put(lorenzoNegri.getID(),librettoLorenzoNegri);
		librettiSecondaA.put(mattiaVitali.getID(),librettoMattiaVitali);
		librettiSecondaA.put(emanueleDelMonte.getID(),librettoEmanueleDelMonte);
		librettiSecondaA.put(luigiBernardi.getID(),librettoLuigiBernardi);
		librettiSecondaA.put(vittorioPellegrini.getID(),librettoVittorioPellegrini);
		librettiSecondaA.put(alexVilla.getID(),librettoAlexVilla);
		
		librettiPrimaB.put(marcoBattaglia.getID(),librettoMarcoBattaglia);
		librettiPrimaB.put(alfredoMorelli.getID(),librettoAlfredoMorelli);
		librettiPrimaB.put(pieraDellaValle.getID(),librettoPieraDellaValle);
		librettiPrimaB.put(ignazioBoschi.getID(),librettoIgnazioBoschi);
		librettiPrimaB.put(jacopoValli.getID(),librettoJacopoValli);
		
		librettiSecondaB.put(gianniConte.getID(),librettoGianniConte);
		librettiSecondaB.put(lucaBarone.getID() ,librettoLucaBarone );
		librettiSecondaB.put(giacomoSiciliano.getID(),librettoGiacomoSiciliano);
		librettiSecondaB.put(fabrizioToscani.getID(),librettoFabrizioToscani);
		librettiSecondaB.put(arturoAncona.getID(),librettoArturoAncona);

		
		//creazione del registro
		RegistroAssenze regAssPrimaA = new RegistroAssenze();
		RegistroAssenze regAssSecondaA = new RegistroAssenze();
		RegistroAssenze regAssPrimaB = new RegistroAssenze();
		RegistroAssenze regAssSecondaB = new RegistroAssenze();
		
		//assegnazione del regitro alla classe primaA
		primaA.setRegistroAssenze(regAssPrimaA);
		secondaA.setRegistroAssenze(regAssSecondaA);
		primaB.setRegistroAssenze(regAssPrimaB);
		secondaB.setRegistroAssenze(regAssSecondaB);
		
		//Assegnazione dei libretti al registro delle classe primaA
		regAssPrimaA.setLibrettiAssenze(librettiPrimaA);
		regAssSecondaA.setLibrettiAssenze(librettiSecondaA);
		regAssPrimaB.setLibrettiAssenze(librettiPrimaB);
		regAssSecondaB.setLibrettiAssenze(librettiSecondaB);
		
		
		//Creazione di un vettore di studenti per cui segnare l'assenza
//		Long[] listaIdStudAssenti = {marioRomano.getId(), pieroRusso.getId(),ivoMarino.getId(), marinoEsposito.getId()};
		
		//recupero dell'appello odierno dal registro
//		Appello appelloOdierno = regAssPrimaA.getAppelloOdierno();
		
		// creazione delle date
		LocalDate data8_12_14 = new LocalDate(2014,12,8);
		LocalDate data10_12_14 = new LocalDate(2014,12,10);
		LocalDate data11_12_14 = new LocalDate(2014,12,11);
		LocalDate data12_12_14 = new LocalDate(2014,12,12);
		LocalDate data13_12_14 = new LocalDate(2014,12,13);
		LocalDate data14_12_14 = new LocalDate(2014,12,14);
		LocalDate data15_12_14 = new LocalDate(2014,12,15);
		LocalDate data16_12_14 = new LocalDate(2014,12,16);
		LocalDate data17_12_14 = new LocalDate(2014,12,17);
		
		//creazione di lista di appelli da assegnare all'assenza
		Collection<Appello> appelliAssenzeMarioRomano = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzePieroRusso = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeIvoMarini = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeMarinoEsposito = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeDavideDiSalvo = new LinkedList<Appello>();
		Collection<Appello> AppelliAssenzeTestFineMese = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeIvoMarini2 = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeIvoMarini3 = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeMariannaDonati = new LinkedList<Appello>();
		Collection<Appello> appelliAssenzeLorenzoNegri = new LinkedList<Appello>();
		
		
		//creazione di appelli
//		Appello appello8_12_14 = new Appello(data8_12_14);
		Appello appello_1A_10_12_14 = new Appello(data10_12_14);
		Appello appello_1A_11_12_14 = new Appello(data11_12_14);
		Appello appello_1A_12_12_14 = new Appello(data12_12_14);
		Appello appello_1A_13_12_14 = new Appello(data13_12_14);
//		Appello appello14_12_14 = new Appello(data14_12_14);
		Appello appello_1A_15_12_14 = new Appello(data15_12_14);
		Appello appello_1A_16_12_14 = new Appello(data16_12_14);
		
		Appello appello_2A_16_12_14 = new Appello(data16_12_14);
		Appello appello_1B_16_12_14 = new Appello(data16_12_14);
		Appello appello_2B_16_12_14 = new Appello(data16_12_14);
		
//		tuttiGliAppelli.put(appello8_12_14.getIdAppello(), appello8_12_14);
		tuttiGliAppelli.put(appello_1A_10_12_14.getID(), appello_1A_10_12_14);
		tuttiGliAppelli.put(appello_1A_11_12_14.getID(), appello_1A_11_12_14);
		tuttiGliAppelli.put(appello_1A_12_12_14.getID(), appello_1A_12_12_14);
		tuttiGliAppelli.put(appello_1A_13_12_14.getID(), appello_1A_13_12_14);
//		tuttiGliAppelli.put(appello14_12_14.getIdAppello(), appello14_12_14);
		tuttiGliAppelli.put(appello_1A_15_12_14.getID(), appello_1A_15_12_14);
		tuttiGliAppelli.put(appello_1A_16_12_14.getID(), appello_1A_16_12_14);
		
		tuttiGliAppelli.put(appello_2A_16_12_14.getID(), appello_2A_16_12_14);
		tuttiGliAppelli.put(appello_1B_16_12_14.getID(), appello_1B_16_12_14);
		tuttiGliAppelli.put(appello_2B_16_12_14.getID(), appello_2B_16_12_14);
		
		

		
//		regAssPrimaA.getAppelli().put(appello8_12_14.getData(), appello8_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_10_12_14.getData()).toDate().hashCode()), appello_1A_10_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_11_12_14.getData()).toDate().hashCode()), appello_1A_11_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_12_12_14.getData())).toDate().hashCode(), appello_1A_12_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_13_12_14.getData())).toDate().hashCode(), appello_1A_13_12_14);
//		regAssPrimaA.getAppelli().put(appello14_12_14.getData(), appello14_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_15_12_14.getData())).toDate().hashCode(), appello_1A_15_12_14);
		regAssPrimaA.getAppelli().put((new LocalDate(appello_1A_16_12_14.getData())).toDate().hashCode(), appello_1A_16_12_14);
		
		regAssSecondaA.getAppelli().put((new LocalDate(appello_2A_16_12_14.getData())).toDate().hashCode(), appello_2A_16_12_14);
		regAssPrimaB.getAppelli().put((new LocalDate(appello_1B_16_12_14.getData())).toDate().hashCode(), appello_1B_16_12_14);
		regAssSecondaB.getAppelli().put((new LocalDate(appello_2B_16_12_14.getData())).toDate().hashCode(), appello_2B_16_12_14);
		

		
		//assegnazione di appelli alle liste di appelli
		appelliAssenzeMarioRomano.add(appello_1A_10_12_14);
		appelliAssenzeMarioRomano.add(appello_1A_11_12_14);
//				AppelliAssenzeMaccio.add(appello12_12_14);
		 
		appelliAssenzePieroRusso.add(appello_1A_10_12_14);
		appelliAssenzePieroRusso.add(appello_1A_11_12_14);
		appelliAssenzePieroRusso.add(appello_1A_12_12_14);
//				AppelliAssenzePiero.add(appello16_12_14);
		
		appelliAssenzeIvoMarini2.add(appello_1A_10_12_14);
		appelliAssenzeIvoMarini2.add(appello_1A_11_12_14);
		
//		appelliAssenzeIvoMarini3.add(appello8_12_14);
		

//		appelliAssenzeIvoMarini.add(appello14_12_14);
		appelliAssenzeIvoMarini.add(appello_1A_15_12_14);
		appelliAssenzeIvoMarini.add(appello_1A_16_12_14);
		
		appelliAssenzeMarinoEsposito.add(appello_1A_16_12_14);
		
		appelliAssenzeDavideDiSalvo.add(appello_1A_16_12_14);
		
		appelliAssenzeMariannaDonati.add(appello_2A_16_12_14);
		appelliAssenzeLorenzoNegri.add(appello_2A_16_12_14);
		
		
		//assegnazione delle liste di appelli alle assenze
		// aggiunto il cast per non far dare errore sicuramente lancia una ClassCastException al run time!!
		Assenza assM1 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeMarioRomano);
		Assenza assP1 = new Assenza((LinkedHashSet<Appello>)appelliAssenzePieroRusso);
		Assenza assI1 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeIvoMarini);
		Assenza assI2 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeIvoMarini2);
		Assenza assI3 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeIvoMarini3);
		Assenza assD1 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeDavideDiSalvo);
		Assenza assMa1 = new Assenza((LinkedHashSet<Appello>)appelliAssenzeMarinoEsposito);
		
		Assenza assMariannaDonati1 =  new Assenza((LinkedHashSet<Appello>)appelliAssenzeMariannaDonati);
		Assenza assLorenzoNegri1 =  new Assenza((LinkedHashSet<Appello>)appelliAssenzeLorenzoNegri);
		
		//creazione delle liste di assenze da assegnare ai libretti
		LinkedList<Assenza> listaAssenzeMarioRomano = new  LinkedList<Assenza>();
		listaAssenzeMarioRomano.add(assM1);
		LinkedList<Assenza> listaAssenzePieroRusso = new  LinkedList<Assenza>();
		listaAssenzePieroRusso.add(assP1);
		LinkedList<Assenza> listaAssenzeIvoMarini = new  LinkedList<Assenza>();
//		listaAssenzeIvoMarini.add(assI3);
		listaAssenzeIvoMarini.add(assI2);
		listaAssenzeIvoMarini.add(assI1);
		LinkedList<Assenza> listaAssenzeDavideDiSalvo = new  LinkedList<Assenza>();
		listaAssenzeDavideDiSalvo.add(assD1);
		LinkedList<Assenza> listaAssenzeMarinoEsposito = new  LinkedList<Assenza>();
		listaAssenzeMarinoEsposito.add(assMa1);
		
		LinkedList<Assenza> listaAssenzeMariannaDonati = new  LinkedList<Assenza>();
		listaAssenzeMariannaDonati.add(assMariannaDonati1);
		LinkedList<Assenza> listaAssenzeLorenzoNegri = new  LinkedList<Assenza>();
		listaAssenzeLorenzoNegri.add(assLorenzoNegri1);
		
		//assegnazione delle liste ai libretti
		librettoMarioRomano.setNonGiustificate(listaAssenzeMarioRomano);
		librettoPieroRusso.setNonGiustificate(listaAssenzePieroRusso);
//		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzeTsetFineMese);
		librettoIvoMarino.setNonGiustificate(listaAssenzeIvoMarini);
//		librettoMarino.assengnaAssenzeNonGiustificate(listaAssenzeMarino);
		librettoDavideDiSalvo.setNonGiustificate(listaAssenzeDavideDiSalvo);
		
		librettoMariannaDonati.setNonGiustificate(listaAssenzeMariannaDonati);
		librettoLorenzoNegri.setNonGiustificate(listaAssenzeLorenzoNegri);
		
//		appello8_12_14.setAssenzePrese(true);
		appello_1A_10_12_14.setAssenzePrese(true);
		appello_1A_11_12_14.setAssenzePrese(true);
		appello_1A_12_12_14.setAssenzePrese(true);
		appello_1A_13_12_14.setAssenzePrese(true);
//		appello14_12_14.setAssenzePrese(true);
		appello_1A_15_12_14.setAssenzePrese(true);
		appello_1A_16_12_14.setAssenzePrese(true);
		
		appello_2A_16_12_14.setAssenzePrese(true);
		appello_1B_16_12_14.setAssenzePrese(true);
		appello_2B_16_12_14.setAssenzePrese(true);

	}
	
}
