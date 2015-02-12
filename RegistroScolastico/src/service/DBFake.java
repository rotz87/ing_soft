package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
	
	private Map<Long, Classe> classi;
	private Map<Long, Docente> docenti;
	private Map<Long, Studente> tuttiGliStudenti;
	private Map<Long, Appello> tuttiGliAppelli;
	  // Private constructor prevents instantiation from other classes
	private DBFake() {
		  classi = new TreeMap<Long, Classe>();
		  docenti = new TreeMap<Long, Docente>();
		  tuttiGliStudenti = new TreeMap<Long, Studente>();
		  tuttiGliAppelli = new TreeMap<Long, Appello>();
		  
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
	
	public void setClassi( Map<Long, Classe> classi){
		this.classi = classi;
	}

	public void setDocenti( Map<Long, Docente> docenti){
		this.docenti = docenti;
	}
	
	public void setStudenti(Map<Long, Studente> studenti){
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
		tuttiGliAppelli.put(appello.getIdAppello(), appello);
	}
	
	
	private void initDB(){
		
		//creazione delle classi
		Classe primaA = new Classe("1A");
		Classe secondaA = new Classe("2A");
		Classe primaB = new Classe("1B");
		Classe secondaB = new Classe("2B");
		
		Map<Long, Classe> mapClassi = new TreeMap <Long, Classe>();
		mapClassi.put(primaA.getIdClasse(), primaA);
		mapClassi.put(secondaA.getIdClasse(), secondaA);
		mapClassi.put(primaB.getIdClasse(), primaB);
		mapClassi.put(secondaB.getIdClasse(), secondaB);
		
		setClassi(mapClassi);
		
		//Crrazione dei docenti
		Docente marioRossi = new Docente("Mario", "Rossi");
		Docente mirkoBianchi = new Docente("Mirko", "Bianchi");
		Docente giulioVerdi = new Docente("Giulio", "Verdi");
		Docente vincenzoNeri = new Docente("Vincenzo", "Neri");
		Docente giuseppeGialli = new Docente("Giuseppe", "Gialli");
		
		Map<Long, Docente> mapDocenti = new TreeMap <Long, Docente>();
		mapDocenti.put(marioRossi.getIdDocente(), marioRossi);
		mapDocenti.put(mirkoBianchi.getIdDocente(), mirkoBianchi);
		mapDocenti.put(giulioVerdi.getIdDocente(), giulioVerdi);
		mapDocenti.put(vincenzoNeri.getIdDocente(), vincenzoNeri);
		mapDocenti.put(giuseppeGialli.getIdDocente(), giuseppeGialli);
		
		
		setDocenti(mapDocenti);
		
		//assegnazione delle classi ai docenti
		
		//assegnazione delle classi a Rossi
		Collection<Classe> classiDiRossi = new LinkedList<Classe>();
		classiDiRossi.add(primaA);
		classiDiRossi.add(secondaA);
		classiDiRossi.add(primaB);
		classiDiRossi.add(secondaB);
		marioRossi.setClassi(classiDiRossi);
		
		//assegnazione delle classi a Rossi
		Collection<Classe> classiDiBianchi = new LinkedList<Classe>();
		classiDiBianchi.add(primaA);
		classiDiBianchi.add(primaB);
		mirkoBianchi.setClassi(classiDiBianchi);
		
		
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
		
		Map<Long, Studente> mapStudenti = new TreeMap <Long, Studente>();
//		mapStudenti.put(.getId(), );
		mapStudenti.put(pieroRusso.getId(), pieroRusso);
		mapStudenti.put(marinoEsposito.getId(), marinoEsposito);
		mapStudenti.put(marioRomano.getId(), marioRomano);
		mapStudenti.put(davideDiSalvo.getId(), davideDiSalvo);
		mapStudenti.put(ivoMarino.getId(), ivoMarino);
		mapStudenti.put(leonardoRicci.getId(),leonardoRicci );
		mapStudenti.put(valentinoFarina.getId(), valentinoFarina);
		mapStudenti.put(roccoBenedetti.getId(), roccoBenedetti);
		mapStudenti.put(antonioGuerra.getId(), antonioGuerra);
		mapStudenti.put(cristinaAngeli.getId(),cristinaAngeli );
		
		mapStudenti.put(mariannaDonati.getId(), mariannaDonati);
		mapStudenti.put(elenaSarti.getId(), elenaSarti);
		mapStudenti.put(mariaPiaAlfredi.getId(), mariaPiaAlfredi);
		mapStudenti.put(giorgioGatti.getId(),giorgioGatti );
		mapStudenti.put(lorenzoNegri.getId(),lorenzoNegri );
		mapStudenti.put(mattiaVitali.getId(), mattiaVitali);
		mapStudenti.put(emanueleDelMonte.getId(), emanueleDelMonte);
		mapStudenti.put(luigiBernardi.getId(), luigiBernardi);
		mapStudenti.put(vittorioPellegrini.getId(),vittorioPellegrini );
		mapStudenti.put(alexVilla.getId(), alexVilla);
		
		mapStudenti.put(marcoBattaglia.getId(), marcoBattaglia);
		mapStudenti.put(alfredoMorelli.getId(),alfredoMorelli );
		mapStudenti.put(pieraDellaValle.getId(),pieraDellaValle );
		mapStudenti.put(ignazioBoschi.getId(), ignazioBoschi);
		mapStudenti.put( jacopoValli.getId(), jacopoValli );
		
		mapStudenti.put(gianniConte.getId(), gianniConte);
		mapStudenti.put(lucaBarone.getId(), lucaBarone);
		mapStudenti.put(giacomoSiciliano.getId(), giacomoSiciliano);
		mapStudenti.put(fabrizioToscani.getId(), fabrizioToscani);
		mapStudenti.put(arturoAncona.getId(), arturoAncona);
		
		setStudenti(mapStudenti);
		
		//assegnazione degli studenti alle classi

		Set<Studente> listaStudentiPrimaA = new HashSet<Studente>();
		Set<Studente> listaStudentiSecondaA = new HashSet<Studente>();
		Set<Studente> listaStudentiPrimaB = new HashSet<Studente>();
		Set<Studente> listaStudentiSecondaB = new HashSet<Studente>();
		
		long i = new Long(1);
		
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
		primaA.setStudenti(listaStudentiPrimaA);
		secondaA.setStudenti(listaStudentiSecondaA);
		primaB.setStudenti(listaStudentiPrimaB);
		secondaB.setStudenti(listaStudentiSecondaB);
		
		//creazione Libretti
		 Map<Studente, LibrettoAssenze> librettiPrimaA = new HashMap<Studente, LibrettoAssenze>(); 
		 Map<Studente, LibrettoAssenze> librettiSecondaA = new HashMap<Studente, LibrettoAssenze>();
		 Map<Studente, LibrettoAssenze> librettiPrimaB = new HashMap<Studente, LibrettoAssenze>();
		 Map<Studente, LibrettoAssenze> librettiSecondaB = new HashMap<Studente, LibrettoAssenze>();

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
		
		librettiPrimaA.put(marioRomano, librettoMarioRomano);
		librettiPrimaA.put(davideDiSalvo,librettoDavideDiSalvo);
		librettiPrimaA.put(ivoMarino, librettoIvoMarino);
		librettiPrimaA.put(pieroRusso, librettoPieroRusso);
		librettiPrimaA.put(marinoEsposito,librettoMarinoEsposito);
		librettiPrimaA.put(leonardoRicci,librettoLeonardoRicci);
		librettiPrimaA.put(valentinoFarina,librettoValentinoFarina);
		librettiPrimaA.put(roccoBenedetti,librettoRoccoBenedetti);
		librettiPrimaA.put(antonioGuerra,librettoAntonioGuerra);
		librettiPrimaA.put(cristinaAngeli,librettoCristinaAngeli);
		
		librettiSecondaA.put(mariannaDonati,librettoMariannaDonati);
		librettiSecondaA.put(elenaSarti,librettoElenaSarti);
		librettiSecondaA.put(mariaPiaAlfredi,librettoMariaPiaAlfredi);
		librettiSecondaA.put(giorgioGatti,librettoGiorgioGatti);
		librettiSecondaA.put(lorenzoNegri,librettoLorenzoNegri);
		librettiSecondaA.put(mattiaVitali,librettoMattiaVitali);
		librettiSecondaA.put(emanueleDelMonte,librettoEmanueleDelMonte);
		librettiSecondaA.put(luigiBernardi,librettoLuigiBernardi);
		librettiSecondaA.put(vittorioPellegrini,librettoVittorioPellegrini);
		librettiSecondaA.put(alexVilla,librettoAlexVilla);
		
		librettiPrimaB.put(marcoBattaglia,librettoMarcoBattaglia);
		librettiPrimaB.put(alfredoMorelli,librettoAlfredoMorelli);
		librettiPrimaB.put(pieraDellaValle,librettoPieraDellaValle);
		librettiPrimaB.put(ignazioBoschi,librettoIgnazioBoschi);
		librettiPrimaB.put(jacopoValli,librettoJacopoValli);
		
		librettiSecondaB.put(gianniConte,librettoGianniConte);
		librettiSecondaB.put(lucaBarone ,librettoLucaBarone );
		librettiSecondaB.put(giacomoSiciliano,librettoGiacomoSiciliano);
		librettiSecondaB.put(fabrizioToscani,librettoFabrizioToscani);
		librettiSecondaB.put(arturoAncona,librettoArturoAncona);

		
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
		LinkedList<Appello> appelliAssenzeMarioRomano = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzePieroRusso = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeIvoMarini = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeMarinoEsposito = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeDavideDiSalvo = new LinkedList<Appello>();
		LinkedList<Appello> AppelliAssenzeTestFineMese = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeIvoMarini2 = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeIvoMarini3 = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeMariannaDonati = new LinkedList<Appello>();
		LinkedList<Appello> appelliAssenzeLorenzoNegri = new LinkedList<Appello>();
		
		
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
		tuttiGliAppelli.put(appello_1A_10_12_14.getIdAppello(), appello_1A_10_12_14);
		tuttiGliAppelli.put(appello_1A_11_12_14.getIdAppello(), appello_1A_11_12_14);
		tuttiGliAppelli.put(appello_1A_12_12_14.getIdAppello(), appello_1A_12_12_14);
		tuttiGliAppelli.put(appello_1A_13_12_14.getIdAppello(), appello_1A_13_12_14);
//		tuttiGliAppelli.put(appello14_12_14.getIdAppello(), appello14_12_14);
		tuttiGliAppelli.put(appello_1A_15_12_14.getIdAppello(), appello_1A_15_12_14);
		tuttiGliAppelli.put(appello_1A_16_12_14.getIdAppello(), appello_1A_16_12_14);
		
		tuttiGliAppelli.put(appello_2A_16_12_14.getIdAppello(), appello_2A_16_12_14);
		tuttiGliAppelli.put(appello_1B_16_12_14.getIdAppello(), appello_1B_16_12_14);
		tuttiGliAppelli.put(appello_2B_16_12_14.getIdAppello(), appello_2B_16_12_14);
		
		

		
//		regAssPrimaA.getAppelli().put(appello8_12_14.getData(), appello8_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_10_12_14.getData()), appello_1A_10_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_11_12_14.getData()), appello_1A_11_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_12_12_14.getData()), appello_1A_12_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_13_12_14.getData()), appello_1A_13_12_14);
//		regAssPrimaA.getAppelli().put(appello14_12_14.getData(), appello14_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_15_12_14.getData()), appello_1A_15_12_14);
		regAssPrimaA.getAppelliRegistro().put(new LocalDate(appello_1A_16_12_14.getData()), appello_1A_16_12_14);
		
		regAssSecondaA.getAppelliRegistro().put(new LocalDate(appello_2A_16_12_14.getData()), appello_2A_16_12_14);
		regAssPrimaB.getAppelliRegistro().put(new LocalDate(appello_1B_16_12_14.getData()), appello_1B_16_12_14);
		regAssSecondaB.getAppelliRegistro().put(new LocalDate(appello_2B_16_12_14.getData()), appello_2B_16_12_14);
		

		
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
		Assenza assM1 = new Assenza(appelliAssenzeMarioRomano);
		Assenza assP1 = new Assenza(appelliAssenzePieroRusso);
		Assenza assI1 = new Assenza(appelliAssenzeIvoMarini);
		Assenza assI2 = new Assenza(appelliAssenzeIvoMarini2);
		Assenza assI3 = new Assenza(appelliAssenzeIvoMarini3);
		Assenza assD1 = new Assenza(appelliAssenzeDavideDiSalvo);
		Assenza assMa1 = new Assenza(appelliAssenzeMarinoEsposito);
		
		Assenza assMariannaDonati1 =  new Assenza(appelliAssenzeMariannaDonati);
		Assenza assLorenzoNegri1 =  new Assenza(appelliAssenzeLorenzoNegri);
		
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
