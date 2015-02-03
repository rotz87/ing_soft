package service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.joda.time.LocalDate;

import domain.model.MAppello;
import domain.model.MAssenza;
import domain.model.MClasse;
import domain.model.MDocente;
import domain.model.MLibrettoAssenze;
import domain.model.MRegistroAssenze;
import domain.model.MStudente;



public class DBFake {
	
	private static DBFake instance;
	
	private Map<Long, MClasse> classi;
	private Map<Long, MDocente> docenti;
	private Map<Long, MStudente> tuttiGliStudenti;
	private Map<Long, MAppello> tuttiGliAppelli;
	  // Private constructor prevents instantiation from other classes
	private DBFake() {
		  classi = new TreeMap<Long, MClasse>();
		  docenti = new TreeMap<Long, MDocente>();
		  tuttiGliStudenti = new TreeMap<Long, MStudente>();
		  tuttiGliAppelli = new TreeMap<Long, MAppello>();
		  
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
	
	public void setClassi( Map<Long, MClasse> classi){
		this.classi = classi;
	}

	public void setDocenti( Map<Long, MDocente> docenti){
		this.docenti = docenti;
	}
	
	public void setStudenti(Map<Long, MStudente> studenti){
		this.tuttiGliStudenti = studenti;
	}
	
	public MClasse getClasseById(Long idClasse){
		return classi.get(idClasse);
	}
	
	public MDocente getDocenteById(Long idDocente){
		return docenti.get(idDocente);
	}
	public MStudente getStudenteById(Long idStudente){
		return tuttiGliStudenti.get(idStudente);
	}
	
	public MAppello getAppelloById(Long idAppello){
		return tuttiGliAppelli.get(idAppello);
	}
	
	public void storeAppello(MAppello appello){
		tuttiGliAppelli.put(appello.getIdAppello(), appello);
	}
	
	
	private void initDB(){
		
		//creazione delle classi
		MClasse primaA = new MClasse("1A");
		MClasse secondaA = new MClasse("2A");
		MClasse primaB = new MClasse("1B");
		MClasse secondaB = new MClasse("2B");
		
		Map<Long, MClasse> mapClassi = new TreeMap <Long, MClasse>();
		mapClassi.put(primaA.getIdClasse(), primaA);
		mapClassi.put(secondaA.getIdClasse(), secondaA);
		mapClassi.put(primaB.getIdClasse(), primaB);
		mapClassi.put(secondaB.getIdClasse(), secondaB);
		
		setClassi(mapClassi);
		
		//Crrazione dei docenti
		MDocente marioRossi = new MDocente("Mario", "Rossi");
		MDocente mirkoBianchi = new MDocente("Mirko", "Bianchi");
		MDocente giulioVerdi = new MDocente("Giulio", "Verdi");
		MDocente vincenzoNeri = new MDocente("Vincenzo", "Neri");
		MDocente giuseppeGialli = new MDocente("Giuseppe", "Gialli");
		
		Map<Long, MDocente> mapDocenti = new TreeMap <Long, MDocente>();
		mapDocenti.put(marioRossi.getIdDocente(), marioRossi);
		mapDocenti.put(mirkoBianchi.getIdDocente(), mirkoBianchi);
		mapDocenti.put(giulioVerdi.getIdDocente(), giulioVerdi);
		mapDocenti.put(vincenzoNeri.getIdDocente(), vincenzoNeri);
		mapDocenti.put(giuseppeGialli.getIdDocente(), giuseppeGialli);
		
		
		setDocenti(mapDocenti);
		
		//assegnazione delle classi ai docenti
		
		//assegnazione delle classi a Rossi
		Collection<MClasse> classiDiRossi = new LinkedList<MClasse>();
		classiDiRossi.add(primaA);
		classiDiRossi.add(secondaA);
		classiDiRossi.add(primaB);
		classiDiRossi.add(secondaB);
		marioRossi.setClassi(classiDiRossi);
		
		//assegnazione delle classi a Rossi
		Collection<MClasse> classiDiBianchi = new LinkedList<MClasse>();
		classiDiBianchi.add(primaA);
		classiDiBianchi.add(primaB);
		mirkoBianchi.setClassi(classiDiBianchi);
		
		
		//Creazione degli studenti
//		Studente  = new Studente("", "");
		MStudente pieroRusso = new MStudente("Piero", "Russo");
		MStudente marinoEsposito = new MStudente("Marino", "Esposito");
		MStudente marioRomano = new MStudente("Mario", "Romano");
		MStudente davideDiSalvo = new MStudente("Davide", "Di Salvo");
		MStudente ivoMarino = new MStudente("Ivo", "Marini");
		MStudente leonardoRicci = new MStudente("Leonardo", "Ricci");
		MStudente valentinoFarina = new MStudente("Valentino", "Farina");
		MStudente roccoBenedetti = new MStudente("Rocco", "Benedetti");
		MStudente antonioGuerra = new MStudente("Antonio", "Guerra");
		MStudente cristinaAngeli = new MStudente("Cristina", "Angeli");
		
		MStudente mariannaDonati = new MStudente("Marianna", "Donati");
		MStudente elenaSarti = new MStudente("Elena", "Sarti");
		MStudente mariaPiaAlfredi = new MStudente("MariaPia", "Alfredi");
		MStudente giorgioGatti = new MStudente("Giorgio", "Gatti");
		MStudente lorenzoNegri = new MStudente("Lorenzo", "Negri");
		MStudente mattiaVitali = new MStudente("Mattia", "Vitali");
		MStudente emanueleDelMonte = new MStudente("Emanuele", "Del Monte");
		MStudente luigiBernardi = new MStudente("Luigi", "Bernardi");
		MStudente vittorioPellegrini = new MStudente("Vittorio", "Pellegrini");
		MStudente alexVilla = new MStudente("Alex", "Villa");
		
		MStudente marcoBattaglia = new MStudente("Marco", "Battaglia");
		MStudente alfredoMorelli = new MStudente("Alfredo", "Morelli");
		MStudente pieraDellaValle = new MStudente("Piera", "Della Valle");
		MStudente ignazioBoschi = new MStudente("Ignazio", "Boschi");
		MStudente jacopoValli = new MStudente("Jacopo", "Valli");
		
		MStudente gianniConte = new MStudente("Gianni", "Conte");
		MStudente lucaBarone = new MStudente("Luca", "Barone");
		MStudente giacomoSiciliano = new MStudente("Giacomo", "Siciliano");
		MStudente fabrizioToscani = new MStudente("Fabrizio", "Toscani");
		MStudente arturoAncona = new MStudente("Arturo", "Ancona");
		
		Map<Long, MStudente> mapStudenti = new TreeMap <Long, MStudente>();
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

		Set<MStudente> listaStudentiPrimaA = new HashSet<MStudente>();
		Set<MStudente> listaStudentiSecondaA = new HashSet<MStudente>();
		Set<MStudente> listaStudentiPrimaB = new HashSet<MStudente>();
		Set<MStudente> listaStudentiSecondaB = new HashSet<MStudente>();
		
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
		 Map<MStudente, MLibrettoAssenze> librettiPrimaA = new HashMap<MStudente, MLibrettoAssenze>(); 
		 Map<MStudente, MLibrettoAssenze> librettiSecondaA = new HashMap<MStudente, MLibrettoAssenze>();
		 Map<MStudente, MLibrettoAssenze> librettiPrimaB = new HashMap<MStudente, MLibrettoAssenze>();
		 Map<MStudente, MLibrettoAssenze> librettiSecondaB = new HashMap<MStudente, MLibrettoAssenze>();

//			LibrettoAssenze libretto =  new LibrettoAssenze();
		MLibrettoAssenze librettoMarioRomano = new MLibrettoAssenze(marioRomano);
		MLibrettoAssenze librettoDavideDiSalvo =  new MLibrettoAssenze(davideDiSalvo);
		MLibrettoAssenze librettoIvoMarino = new MLibrettoAssenze(ivoMarino);
		MLibrettoAssenze librettoPieroRusso = new MLibrettoAssenze(pieroRusso);
		MLibrettoAssenze librettoMarinoEsposito =  new MLibrettoAssenze(marinoEsposito);
		MLibrettoAssenze librettoLeonardoRicci =  new MLibrettoAssenze(leonardoRicci);
		MLibrettoAssenze librettoValentinoFarina =  new MLibrettoAssenze(valentinoFarina);
		MLibrettoAssenze librettoRoccoBenedetti =  new MLibrettoAssenze(roccoBenedetti);
		MLibrettoAssenze librettoAntonioGuerra =  new MLibrettoAssenze(antonioGuerra);
		MLibrettoAssenze librettoCristinaAngeli =  new MLibrettoAssenze(cristinaAngeli);
		
		MLibrettoAssenze librettoMariannaDonati =  new MLibrettoAssenze(mariannaDonati);
		MLibrettoAssenze librettoElenaSarti =  new MLibrettoAssenze(elenaSarti);
		MLibrettoAssenze librettoMariaPiaAlfredi =  new MLibrettoAssenze(mariaPiaAlfredi);
		MLibrettoAssenze librettoGiorgioGatti =  new MLibrettoAssenze(giorgioGatti);
		MLibrettoAssenze librettoLorenzoNegri =  new MLibrettoAssenze(lorenzoNegri);
		MLibrettoAssenze librettoMattiaVitali =  new MLibrettoAssenze(mattiaVitali);
		MLibrettoAssenze librettoEmanueleDelMonte =  new MLibrettoAssenze(emanueleDelMonte);
		MLibrettoAssenze librettoLuigiBernardi =  new MLibrettoAssenze(luigiBernardi);
		MLibrettoAssenze librettoVittorioPellegrini =  new MLibrettoAssenze(vittorioPellegrini);
		MLibrettoAssenze librettoAlexVilla =  new MLibrettoAssenze(alexVilla);
		
		MLibrettoAssenze librettoMarcoBattaglia =  new MLibrettoAssenze(marcoBattaglia);
		MLibrettoAssenze librettoAlfredoMorelli =  new MLibrettoAssenze(alfredoMorelli);
		MLibrettoAssenze librettoPieraDellaValle =  new MLibrettoAssenze(pieraDellaValle);
		MLibrettoAssenze librettoIgnazioBoschi =  new MLibrettoAssenze(ignazioBoschi);
		MLibrettoAssenze librettoJacopoValli =  new MLibrettoAssenze(jacopoValli);
		
		MLibrettoAssenze librettoGianniConte =  new MLibrettoAssenze(gianniConte);
		MLibrettoAssenze librettoLucaBarone =  new MLibrettoAssenze(lucaBarone);
		MLibrettoAssenze librettoGiacomoSiciliano =  new MLibrettoAssenze(giacomoSiciliano);
		MLibrettoAssenze librettoFabrizioToscani =  new MLibrettoAssenze(fabrizioToscani);
		MLibrettoAssenze librettoArturoAncona =  new MLibrettoAssenze(arturoAncona);
		
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
		MRegistroAssenze regAssPrimaA = new MRegistroAssenze();
		MRegistroAssenze regAssSecondaA = new MRegistroAssenze();
		MRegistroAssenze regAssPrimaB = new MRegistroAssenze();
		MRegistroAssenze regAssSecondaB = new MRegistroAssenze();
		
		//assegnazione del regitro alla classe primaA
		primaA.setRegistroAssenze(regAssPrimaA);
		secondaA.setRegistroAssenze(regAssSecondaA);
		primaB.setRegistroAssenze(regAssPrimaB);
		secondaB.setRegistroAssenze(regAssSecondaB);
		
		//Assegnazione dei libretti al registro delle classe primaA
		regAssPrimaA.assengaLibretti(librettiPrimaA);
		regAssSecondaA.assengaLibretti(librettiSecondaA);
		regAssPrimaB.assengaLibretti(librettiPrimaB);
		regAssSecondaB.assengaLibretti(librettiSecondaB);
		
		
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
		LinkedList<MAppello> appelliAssenzeMarioRomano = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzePieroRusso = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeIvoMarini = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeMarinoEsposito = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeDavideDiSalvo = new LinkedList<MAppello>();
		LinkedList<MAppello> AppelliAssenzeTestFineMese = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeIvoMarini2 = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeIvoMarini3 = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeMariannaDonati = new LinkedList<MAppello>();
		LinkedList<MAppello> appelliAssenzeLorenzoNegri = new LinkedList<MAppello>();
		
		
		//creazione di appelli
//		Appello appello8_12_14 = new Appello(data8_12_14);
		MAppello appello_1A_10_12_14 = new MAppello(data10_12_14);
		MAppello appello_1A_11_12_14 = new MAppello(data11_12_14);
		MAppello appello_1A_12_12_14 = new MAppello(data12_12_14);
		MAppello appello_1A_13_12_14 = new MAppello(data13_12_14);
//		Appello appello14_12_14 = new Appello(data14_12_14);
		MAppello appello_1A_15_12_14 = new MAppello(data15_12_14);
		MAppello appello_1A_16_12_14 = new MAppello(data16_12_14);
		
		MAppello appello_2A_16_12_14 = new MAppello(data16_12_14);
		MAppello appello_1B_16_12_14 = new MAppello(data16_12_14);
		MAppello appello_2B_16_12_14 = new MAppello(data16_12_14);
		
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
		regAssPrimaA.getAppelli().put(appello_1A_10_12_14.getData(), appello_1A_10_12_14);
		regAssPrimaA.getAppelli().put(appello_1A_11_12_14.getData(), appello_1A_11_12_14);
		regAssPrimaA.getAppelli().put(appello_1A_12_12_14.getData(), appello_1A_12_12_14);
		regAssPrimaA.getAppelli().put(appello_1A_13_12_14.getData(), appello_1A_13_12_14);
//		regAssPrimaA.getAppelli().put(appello14_12_14.getData(), appello14_12_14);
		regAssPrimaA.getAppelli().put(appello_1A_15_12_14.getData(), appello_1A_15_12_14);
		regAssPrimaA.getAppelli().put(appello_1A_16_12_14.getData(), appello_1A_16_12_14);
		
		regAssSecondaA.getAppelli().put(appello_2A_16_12_14.getData(), appello_2A_16_12_14);
		regAssPrimaB.getAppelli().put(appello_1B_16_12_14.getData(), appello_1B_16_12_14);
		regAssSecondaB.getAppelli().put(appello_2B_16_12_14.getData(), appello_2B_16_12_14);
		

		
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
		MAssenza assM1 = new MAssenza(appelliAssenzeMarioRomano);
		MAssenza assP1 = new MAssenza(appelliAssenzePieroRusso);
		MAssenza assI1 = new MAssenza(appelliAssenzeIvoMarini);
		MAssenza assI2 = new MAssenza(appelliAssenzeIvoMarini2);
		MAssenza assI3 = new MAssenza(appelliAssenzeIvoMarini3);
		MAssenza assD1 = new MAssenza(appelliAssenzeDavideDiSalvo);
		MAssenza assMa1 = new MAssenza(appelliAssenzeMarinoEsposito);
		
		MAssenza assMariannaDonati1 =  new MAssenza(appelliAssenzeMariannaDonati);
		MAssenza assLorenzoNegri1 =  new MAssenza(appelliAssenzeLorenzoNegri);
		
		//creazione delle liste di assenze da assegnare ai libretti
		LinkedList<MAssenza> listaAssenzeMarioRomano = new  LinkedList<MAssenza>();
		listaAssenzeMarioRomano.add(assM1);
		LinkedList<MAssenza> listaAssenzePieroRusso = new  LinkedList<MAssenza>();
		listaAssenzePieroRusso.add(assP1);
		LinkedList<MAssenza> listaAssenzeIvoMarini = new  LinkedList<MAssenza>();
//		listaAssenzeIvoMarini.add(assI3);
		listaAssenzeIvoMarini.add(assI2);
		listaAssenzeIvoMarini.add(assI1);
		LinkedList<MAssenza> listaAssenzeDavideDiSalvo = new  LinkedList<MAssenza>();
		listaAssenzeDavideDiSalvo.add(assD1);
		LinkedList<MAssenza> listaAssenzeMarinoEsposito = new  LinkedList<MAssenza>();
		listaAssenzeMarinoEsposito.add(assMa1);
		
		LinkedList<MAssenza> listaAssenzeMariannaDonati = new  LinkedList<MAssenza>();
		listaAssenzeMariannaDonati.add(assMariannaDonati1);
		LinkedList<MAssenza> listaAssenzeLorenzoNegri = new  LinkedList<MAssenza>();
		listaAssenzeLorenzoNegri.add(assLorenzoNegri1);
		
		//assegnazione delle liste ai libretti
		librettoMarioRomano.assengnaAssenzeNonGiustificate(listaAssenzeMarioRomano);
		librettoPieroRusso.assengnaAssenzeNonGiustificate(listaAssenzePieroRusso);
//		librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzeTsetFineMese);
		librettoIvoMarino.assengnaAssenzeNonGiustificate(listaAssenzeIvoMarini);
//		librettoMarino.assengnaAssenzeNonGiustificate(listaAssenzeMarino);
		librettoDavideDiSalvo.assengnaAssenzeNonGiustificate(listaAssenzeDavideDiSalvo);
		
		librettoMariannaDonati.assengnaAssenzeNonGiustificate(listaAssenzeMariannaDonati);
		librettoLorenzoNegri.assengnaAssenzeNonGiustificate(listaAssenzeLorenzoNegri);
		
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
