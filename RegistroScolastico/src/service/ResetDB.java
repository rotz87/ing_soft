package service;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.time.LocalDate;
import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.model.Appello;
import domain.model.Argomento;
import domain.model.Assenza;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.CompitoInClasse;
import domain.model.Docente;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.LibrettoAssenze;
import domain.model.Materia;
import domain.model.RSPersistentManager;
import domain.model.RegistroAssenze;
import domain.model.RegistroDocente;
import domain.model.Scuola;
import domain.model.Studente;

public class ResetDB {

	public static void main(String[] args) {
		try {
			initDB();
			Stampa.stampa("DATABASE rigenerato!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initDB() {
		try {
//			DBService createRegistroScolasticoData = new DBService();
			try {
				ORMDatabaseInitiator.dropSchema(domain.model.RSPersistentManager.instance());
				domain.model.RSPersistentManager.instance().disposePersistentManager();
				
				ORMDatabaseInitiator.createSchema(domain.model.RSPersistentManager.instance());
				domain.model.RSPersistentManager.instance().disposePersistentManager();
				
				createTestData();
			}
//			catch(Exception e1){
//				e1.printStackTrace();
//			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			Scuola scuola1 = new Scuola();
			
			//creazione delle classi
			Classe primaA = new Classe("1A");
			Classe secondaA = new Classe("2A");
			Classe primaB = new Classe("1B");
			Classe secondaB = new Classe("2B");
			
			scuola1.getClassi().add(primaA);
			scuola1.getClassi().add( secondaA);
			scuola1.getClassi().add( primaB);
			scuola1.getClassi().add( secondaB);
						
			//Creazione dei docenti
			Docente marioRossi = new Docente("Mario", "Rossi");
			Docente mirkoBianchi = new Docente("Mirko", "Bianchi");
			Docente giulioVerdi = new Docente("Giulio", "Verdi");
			Docente vincenzoNeri = new Docente("Vincenzo", "Neri");
			Docente giuseppeGialli = new Docente("Giuseppe", "Gialli");
			
			scuola1.getDocenti().add(marioRossi);
			scuola1.getDocenti().add( mirkoBianchi);
			scuola1.getDocenti().add( giulioVerdi);
			scuola1.getDocenti().add( vincenzoNeri);
			scuola1.getDocenti().add( giuseppeGialli);
			
			
//			CREAZIONE DEI REGISTRI DOCENTE
			RegistroDocente registroRossiPrimaA = new RegistroDocente();
			RegistroDocente registroRossiSecondaA = new RegistroDocente();
			RegistroDocente registroRossiPrimaB = new RegistroDocente();
			RegistroDocente registroRossiSecondaB = new RegistroDocente();
			
			RegistroDocente registroBianchiPrimaA = new RegistroDocente();
			RegistroDocente registroBianchiPrimaB = new RegistroDocente();
			
//			ASSEGNAZIONE DELLE CLASSI AI REGISTRI DOCENTE
			registroRossiPrimaA.setClasse(primaA);
			registroRossiSecondaA.setClasse(secondaA);
			registroRossiPrimaB.setClasse(primaB);
			registroRossiSecondaB.setClasse(secondaB);
			
			registroBianchiPrimaA.setClasse(primaA);
			registroBianchiPrimaB.setClasse(primaB);
			
//			ASSEGNAZIONE DEI REGISTRO DOCENTE AI DOCENTI
			marioRossi.getRegistriDocente().add(registroRossiPrimaA);
			marioRossi.getRegistriDocente().add(registroRossiSecondaA);
			marioRossi.getRegistriDocente().add(registroRossiPrimaB);
			marioRossi.getRegistriDocente().add(registroRossiSecondaB);
			
			mirkoBianchi.getRegistriDocente().add(registroBianchiPrimaA);
			mirkoBianchi.getRegistriDocente().add(registroBianchiPrimaB);
			
			//Creazione degli studenti
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
			
			
//			GLI STUDENTI VENGONO SALVATI UNO ALLA VOLTA PERCHE' CI SERVONO GLI ID DA METTERE NELLA MAP
//			RSPersistentManager.instance().getSession().save(pieroRusso);
//			RSPersistentManager.instance().getSession().save(marinoEsposito);
//			RSPersistentManager.instance().getSession().save(marioRomano);
//			RSPersistentManager.instance().getSession().save(davideDiSalvo);
//			RSPersistentManager.instance().getSession().save(ivoMarino);
//			RSPersistentManager.instance().getSession().save(leonardoRicci);
//			RSPersistentManager.instance().getSession().save(valentinoFarina);
//			RSPersistentManager.instance().getSession().save(roccoBenedetti);
//			RSPersistentManager.instance().getSession().save(antonioGuerra);
//			RSPersistentManager.instance().getSession().save(cristinaAngeli);
//			
//			RSPersistentManager.instance().getSession().save(mariannaDonati);
//			RSPersistentManager.instance().getSession().save(elenaSarti);
//			RSPersistentManager.instance().getSession().save(mariaPiaAlfredi);
//			RSPersistentManager.instance().getSession().save(giorgioGatti);
//			RSPersistentManager.instance().getSession().save(lorenzoNegri);
//			RSPersistentManager.instance().getSession().save(mattiaVitali);
//			RSPersistentManager.instance().getSession().save(emanueleDelMonte);
//			RSPersistentManager.instance().getSession().save(luigiBernardi);
//			RSPersistentManager.instance().getSession().save(vittorioPellegrini);
//			RSPersistentManager.instance().getSession().save(alexVilla);
//			
//			RSPersistentManager.instance().getSession().save(marcoBattaglia);
//			RSPersistentManager.instance().getSession().save(alfredoMorelli);
//			RSPersistentManager.instance().getSession().save(pieraDellaValle);
//			RSPersistentManager.instance().getSession().save(ignazioBoschi);
//			RSPersistentManager.instance().getSession().save(jacopoValli);
//			
//			RSPersistentManager.instance().getSession().save(gianniConte);
//			RSPersistentManager.instance().getSession().save(lucaBarone);
//			RSPersistentManager.instance().getSession().save(giacomoSiciliano);
//			RSPersistentManager.instance().getSession().save(fabrizioToscani);
//			RSPersistentManager.instance().getSession().save(arturoAncona);
//			

//				LibrettoAssenze libretto =  new LibrettoAssenze();
			LibrettoAssenze librettoMarioRomano = new LibrettoAssenze();
			marioRomano.setLibrettoAssenze(librettoMarioRomano);
			LibrettoAssenze librettoDavideDiSalvo =  new LibrettoAssenze();
			davideDiSalvo.setLibrettoAssenze(librettoDavideDiSalvo);
			LibrettoAssenze librettoIvoMarino = new LibrettoAssenze();
			ivoMarino.setLibrettoAssenze(librettoIvoMarino);
			LibrettoAssenze librettoPieroRusso = new LibrettoAssenze();
			pieroRusso.setLibrettoAssenze(librettoPieroRusso);
			LibrettoAssenze librettoMarinoEsposito =  new LibrettoAssenze();
			marinoEsposito.setLibrettoAssenze(librettoMarinoEsposito);
			LibrettoAssenze librettoLeonardoRicci =  new LibrettoAssenze();
			leonardoRicci.setLibrettoAssenze(librettoLeonardoRicci);
			LibrettoAssenze librettoValentinoFarina =  new LibrettoAssenze();
			valentinoFarina.setLibrettoAssenze(librettoValentinoFarina);
			LibrettoAssenze librettoRoccoBenedetti =  new LibrettoAssenze();
			roccoBenedetti.setLibrettoAssenze(librettoRoccoBenedetti);
			LibrettoAssenze librettoAntonioGuerra =  new LibrettoAssenze();
			antonioGuerra.setLibrettoAssenze(librettoAntonioGuerra);
			LibrettoAssenze librettoCristinaAngeli =  new LibrettoAssenze();
			cristinaAngeli.setLibrettoAssenze(librettoCristinaAngeli);
			
			LibrettoAssenze librettoMariannaDonati =  new LibrettoAssenze();
			mariannaDonati.setLibrettoAssenze(librettoMariannaDonati);
			LibrettoAssenze librettoElenaSarti =  new LibrettoAssenze();
			elenaSarti.setLibrettoAssenze(librettoElenaSarti);
			LibrettoAssenze librettoMariaPiaAlfredi =  new LibrettoAssenze();
			mariaPiaAlfredi.setLibrettoAssenze(librettoMariaPiaAlfredi);
			LibrettoAssenze librettoGiorgioGatti =  new LibrettoAssenze();
			giorgioGatti.setLibrettoAssenze(librettoGiorgioGatti);
			LibrettoAssenze librettoLorenzoNegri =  new LibrettoAssenze();
			lorenzoNegri.setLibrettoAssenze(librettoLorenzoNegri);
			LibrettoAssenze librettoMattiaVitali =  new LibrettoAssenze();
			mattiaVitali.setLibrettoAssenze(librettoMattiaVitali);
			LibrettoAssenze librettoEmanueleDelMonte =  new LibrettoAssenze();
			emanueleDelMonte.setLibrettoAssenze(librettoEmanueleDelMonte);
			LibrettoAssenze librettoLuigiBernardi =  new LibrettoAssenze();
			luigiBernardi.setLibrettoAssenze(librettoLuigiBernardi);
			LibrettoAssenze librettoVittorioPellegrini =  new LibrettoAssenze();
			vittorioPellegrini.setLibrettoAssenze(librettoVittorioPellegrini);
			LibrettoAssenze librettoAlexVilla =  new LibrettoAssenze();
			alexVilla.setLibrettoAssenze(librettoAlexVilla);
			
			LibrettoAssenze librettoMarcoBattaglia =  new LibrettoAssenze();
			marcoBattaglia.setLibrettoAssenze(librettoMarcoBattaglia);
			LibrettoAssenze librettoAlfredoMorelli =  new LibrettoAssenze();
			alfredoMorelli.setLibrettoAssenze(librettoAlfredoMorelli);
			LibrettoAssenze librettoPieraDellaValle =  new LibrettoAssenze();
			pieraDellaValle.setLibrettoAssenze(librettoPieraDellaValle);
			LibrettoAssenze librettoIgnazioBoschi =  new LibrettoAssenze();
			ignazioBoschi.setLibrettoAssenze(librettoIgnazioBoschi);
			LibrettoAssenze librettoJacopoValli =  new LibrettoAssenze();
			jacopoValli.setLibrettoAssenze(librettoJacopoValli);
			
			LibrettoAssenze librettoGianniConte =  new LibrettoAssenze();
			gianniConte.setLibrettoAssenze(librettoGianniConte);
			LibrettoAssenze librettoLucaBarone =  new LibrettoAssenze();
			lucaBarone.setLibrettoAssenze(librettoLucaBarone);
			LibrettoAssenze librettoGiacomoSiciliano =  new LibrettoAssenze();
			giacomoSiciliano.setLibrettoAssenze(librettoGiacomoSiciliano);
			LibrettoAssenze librettoFabrizioToscani =  new LibrettoAssenze();
			fabrizioToscani.setLibrettoAssenze(librettoFabrizioToscani);
			LibrettoAssenze librettoArturoAncona =  new LibrettoAssenze();
			arturoAncona.setLibrettoAssenze(librettoArturoAncona);
			
			//creazione dei registri
			RegistroAssenze regAssPrimaA = new RegistroAssenze();
			RegistroAssenze regAssSecondaA = new RegistroAssenze();
			RegistroAssenze regAssPrimaB = new RegistroAssenze();
			RegistroAssenze regAssSecondaB = new RegistroAssenze();
			

			//METTERE GLI STUDENTI NELLE CLASSI!!!
			primaA.getStudenti().add(pieroRusso);
			primaA.getStudenti().add(marinoEsposito);
			primaA.getStudenti().add(marioRomano);
			primaA.getStudenti().add(davideDiSalvo);
			primaA.getStudenti().add(ivoMarino);
			primaA.getStudenti().add(leonardoRicci);
			primaA.getStudenti().add(valentinoFarina);
			primaA.getStudenti().add(roccoBenedetti);
			primaA.getStudenti().add(antonioGuerra);
			primaA.getStudenti().add(cristinaAngeli);
			
			secondaA.getStudenti().add(mariannaDonati);
			secondaA.getStudenti().add(elenaSarti);
			secondaA.getStudenti().add(mariaPiaAlfredi);
			secondaA.getStudenti().add(giorgioGatti);
			secondaA.getStudenti().add(lorenzoNegri);
			secondaA.getStudenti().add(mattiaVitali);
			secondaA.getStudenti().add(emanueleDelMonte);
			secondaA.getStudenti().add(luigiBernardi);
			secondaA.getStudenti().add(vittorioPellegrini);
			secondaA.getStudenti().add(alexVilla);
			
			primaB.getStudenti().add(marcoBattaglia);
			primaB.getStudenti().add(alfredoMorelli);
			primaB.getStudenti().add(pieraDellaValle);
			primaB.getStudenti().add(ignazioBoschi);
			primaB.getStudenti().add(jacopoValli);
			
			secondaB.getStudenti().add(gianniConte);
			secondaB.getStudenti().add(lucaBarone);
			secondaB.getStudenti().add(giacomoSiciliano);
			secondaB.getStudenti().add(fabrizioToscani);
			secondaB.getStudenti().add(arturoAncona);
			
			//assegnazione del regitro alla classe primaA
			primaA.setRegistroAssenze(regAssPrimaA);
			secondaA.setRegistroAssenze(regAssSecondaA);
			primaB.setRegistroAssenze(regAssPrimaB);
			secondaB.setRegistroAssenze(regAssSecondaB);
			
			
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
			
			
			//creazione di appelli
//			Appello appello8_12_14 = new Appello(data8_12_14);
			Appello appello_1A_10_12_14 = new Appello(data10_12_14);
			Appello appello_1A_11_12_14 = new Appello(data11_12_14);
			Appello appello_1A_12_12_14 = new Appello(data12_12_14);
			Appello appello_1A_13_12_14 = new Appello(data13_12_14);
//			Appello appello14_12_14 = new Appello(data14_12_14);
			Appello appello_1A_15_12_14 = new Appello(data15_12_14);
			Appello appello_1A_16_12_14 = new Appello(data16_12_14);
			
			Appello appello_2A_16_12_14 = new Appello(data16_12_14);
			Appello appello_1B_16_12_14 = new Appello(data16_12_14);
			Appello appello_2B_16_12_14 = new Appello(data16_12_14);
			

			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_10_12_14.getData()) , appello_1A_10_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_11_12_14.getData()), appello_1A_11_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_12_12_14.getData()), appello_1A_12_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_13_12_14.getData()), appello_1A_13_12_14);
//			regAssPrimaA.getAppelli().put(appello14_12_14.getData(), appello14_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_15_12_14.getData()), appello_1A_15_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_16_12_14.getData()), appello_1A_16_12_14);
			
			regAssSecondaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_2A_16_12_14.getData()), appello_2A_16_12_14);
			regAssPrimaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1B_16_12_14.getData()), appello_1B_16_12_14);
			regAssSecondaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_2B_16_12_14.getData()), appello_2B_16_12_14);
			
			//creazione delle assenze
			Assenza assMarioRomano1 = new Assenza();
			Assenza assPieroRusso1 = new Assenza();
			Assenza assIvoMarini1 = new Assenza();
			Assenza assIvoMarini2 = new Assenza();
			Assenza assIvoMarini3 = new Assenza();
			Assenza assDavideDiSalvo1 = new Assenza();
			Assenza assMarinoEsposito1 = new Assenza();
			
			Assenza assMariannaDonati1 =  new Assenza();
			Assenza assLorenzoNegri1 =  new Assenza();
			
			//assegnazione di appelli alle liste di appelli
			

			assMarioRomano1.getAppelli().add(appello_1A_10_12_14);
			assMarioRomano1.getAppelli().add(appello_1A_11_12_14);
//					AppelliAssenzeMaccio.add(appello12_12_14);
			 
			assPieroRusso1.getAppelli().add(appello_1A_10_12_14);
			assPieroRusso1.getAppelli().add(appello_1A_11_12_14);
			assPieroRusso1.getAppelli().add(appello_1A_12_12_14);
//			assPieroRusso1.getAppelliAssenza().add(appello16_12_14);

//			assIvoMarini1.getAppelliAssenza().add(appello14_12_14);
			assIvoMarini1.getAppelli().add(appello_1A_15_12_14);
			assIvoMarini1.getAppelli().add(appello_1A_16_12_14);
			
			assIvoMarini2.getAppelli().add(appello_1A_10_12_14);
			assIvoMarini2.getAppelli().add(appello_1A_11_12_14);
			
//			assIvoMarini3.getAppelliAssenza().add(appello8_12_14);
			
			assMarinoEsposito1.getAppelli().add(appello_1A_16_12_14);
			
			assDavideDiSalvo1.getAppelli().add(appello_1A_16_12_14);
			
			assMariannaDonati1.getAppelli().add(appello_2A_16_12_14);
			assLorenzoNegri1.getAppelli().add(appello_2A_16_12_14);
			
			librettoMarioRomano.getNonGiustificate().add(assMarioRomano1);
			librettoIvoMarino.getNonGiustificate().add(assIvoMarini1);
			librettoIvoMarino.getNonGiustificate().add(assIvoMarini2);
			librettoMarinoEsposito.getNonGiustificate().add(assMarinoEsposito1);
			librettoDavideDiSalvo.getNonGiustificate().add(assDavideDiSalvo1);
			librettoMariannaDonati.getNonGiustificate().add(assMariannaDonati1);
			librettoLorenzoNegri.getNonGiustificate().add(assLorenzoNegri1);	
			
			
//			appello8_12_14.setAssenzePrese(true);
			appello_1A_10_12_14.setAssenzePrese(true);
			appello_1A_11_12_14.setAssenzePrese(true);
			appello_1A_12_12_14.setAssenzePrese(true);
			appello_1A_13_12_14.setAssenzePrese(true);
//			appello14_12_14.setAssenzePrese(true);
			appello_1A_15_12_14.setAssenzePrese(true);
			appello_1A_16_12_14.setAssenzePrese(true);
			
			appello_2A_16_12_14.setAssenzePrese(true);
			appello_1B_16_12_14.setAssenzePrese(true);
			appello_2B_16_12_14.setAssenzePrese(true);

			// FINE CODICE PRESO DA DBFake
			
			RSPersistentManager.instance().getSession().save(scuola1);
			
			GiornoSettimanaleFestivo sabato = new GiornoSettimanaleFestivo(6);
			GiornoSettimanaleFestivo domenica = new GiornoSettimanaleFestivo(7);
			
			RSPersistentManager.instance().getSession().save(sabato);
			RSPersistentManager.instance().getSession().save(domenica);
			
//			Materia storia = new Materia();
//			registroRossiPrimaA.setMateria(storia);
			
			Collection<Argomento> argomenti = new LinkedList<Argomento>();
			
			Argomento worldWar1 = new Argomento("world war I", "");
			Argomento worldWar2 = new Argomento("world war II","");
			Argomento colonialismo = new Argomento("colonialismo","");
			Argomento secondoDopoGuerra = new Argomento("secomdo dopoguerra","");
			
			registroRossiPrimaA.getArgomentiSvolti().add(worldWar1);
			registroRossiPrimaA.getArgomentiSvolti().add(worldWar2);
			registroRossiPrimaA.getArgomentiSvolti().add(colonialismo);
			registroRossiPrimaA.getArgomentiSvolti().add(secondoDopoGuerra);
			
			argomenti.clear();
			argomenti.add(worldWar1);
			argomenti.add(worldWar2);
			CompitoInClasse compitoStoria1A = new CompitoInClasse();
			compitoStoria1A.setInfo(java.sql.Date.valueOf("2014-12-16"), java.sql.Time.valueOf("11:00:00"), java.sql.Time.valueOf("13:00:00"), argomenti);
			compitoStoria1A.setInsegnamento(registroRossiPrimaA);
			registroRossiPrimaA.getCompitiInClasse().add(compitoStoria1A);
			
			argomenti.clear();
			compitoStoria1A = new CompitoInClasse();
			compitoStoria1A.setInfo(java.sql.Date.valueOf("2014-12-15"), java.sql.Time.valueOf("10:00:00"), java.sql.Time.valueOf("11:30:00"), argomenti);
			compitoStoria1A.setInsegnamento(registroRossiPrimaA);
			registroRossiPrimaA.getCompitiInClasse().add(compitoStoria1A);
			
			
//			domain.model.Studente ldomainmodelStudente = new domain.model.Studente();			// Initialize the properties of the persistent object here
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelStudente);
			
//			domain.model.Appello ldomainmodelAppello = new domain.model.Appello();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : assenzePrese
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelAppello);
//			
//			domain.model.Assenza ldomainmodelAssenza = new domain.model.Assenza();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelliAssenza
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelAssenza);
//			
//			domain.model.Giustificazione ldomainmodelGiustificazione = new domain.model.Giustificazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : confermata
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiustificazione);
//			
//			domain.model.Ritardo ldomainmodelRitardo = new domain.model.Ritardo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appello
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelRitardo);
//			
//			domain.model.PermessoEntrata ldomainmodelPermessoEntrata = new domain.model.PermessoEntrata();			// Initialize the properties of the persistent object here
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelPermessoEntrata);
//			
//			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata = new domain.model.UscitaAnticipata();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : permesso, appello
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelUscitaAnticipata);
//			
//			domain.model.PermessoUscita ldomainmodelPermessoUscita = new domain.model.PermessoUscita();			// Initialize the properties of the persistent object here
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelPermessoUscita);
//			
//			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze = new domain.model.LibrettoAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : uscite, ritardi, nonGiustificate, giustificate, studente
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelLibrettoAssenze);
//			
//			domain.model.RegistroAssenze ldomainmodelRegistroAssenze = new domain.model.RegistroAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelliRegistro, librettiAssenze, appelloOdierno
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelRegistroAssenze);
//			
//			domain.model.Scuola ldomainmodelScuola = new domain.model.Scuola();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : docenti, classi
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelScuola);
//			
//			domain.model.Classe ldomainmodelClasse = new domain.model.Classe();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : studenti, registroAssenze
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelClasse);
//			
//			domain.model.Docente ldomainmodelDocente = new domain.model.Docente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classi
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelDocente);
//			
//			domain.model.Calendario ldomainmodelCalendario = new domain.model.Calendario();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorniSettimanaliFestivi, giorniFestivi
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelCalendario);
//			
//			domain.model.Giorno ldomainmodelGiorno = new domain.model.Giorno();			// Initialize the properties of the persistent object here
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiorno);
//			
//			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale = new domain.model.GiornoSettimanale();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorno
//			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiornoSettimanale);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		
	}
	

}
