package sviluppo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.joda.time.LocalDate;
import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import presenter.StartUp;
import service.RSPersistentManager;
import domain.model.Appello;
import domain.model.Argomento;
import domain.model.Assenza;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.GiornoFestivo;
import domain.model.GiornoSettimanaleFestivo;
import domain.model.LibrettoAssenze;
import domain.model.LibrettoVoti;
import domain.model.Materia;
import domain.model.RegistroAssenze;
import domain.model.RegistroDocente;
import domain.model.Scuola;
import domain.model.Studente;
import domain.model.Voto;
import domain.model.compitoInClasse.CompitoInClasse;

public class ResetDB {

	public static void main(String[] args) {
		try {
			initDB();
			Stampa.stampa("DATABASE rigenerato!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initDB() {
		try {
//			DBService createRegistroScolasticoData = new DBService();
			try {
				ORMDatabaseInitiator.dropSchema(service.RSPersistentManager.instance());
				service.RSPersistentManager.instance().disposePersistentManager();
				
				ORMDatabaseInitiator.createSchema(service.RSPersistentManager.instance());
				service.RSPersistentManager.instance().disposePersistentManager();
				
				createTestData();
			}
//			catch(Exception e1){
//				e1.printStackTrace();
//			}
			finally {
				service.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createTestData() throws PersistentException {
		PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			
//			INIZIALIZZAZIONE DEL CALENDARIO
			Calendario.getInstance().setInizioLezioni(new LocalDate(2014,12,01));
			Calendario.getInstance().setFineLezioni(new  LocalDate(2015,6,12));
//  			CREAZIONE E SALVATAGGIO DEI GIORNI FESTIVI
			GiornoSettimanaleFestivo sabato = new GiornoSettimanaleFestivo(6);
			GiornoSettimanaleFestivo domenica = new GiornoSettimanaleFestivo(7);
			Calendario.getInstance().getGiorniSettimanaliFestivi().add(sabato);
			Calendario.getInstance().getGiorniSettimanaliFestivi().add(domenica);
			for(GiornoSettimanaleFestivo gf : Calendario.getInstance().getGiorniSettimanaliFestivi()){
				RSPersistentManager.instance().getSession().save(gf);
			}
			
			LocalDate l8Dic = new LocalDate(2014,12,8);
			java.sql.Date d8Dic = new java.sql.Date(l8Dic.toDate().getTime());
			GiornoFestivo ottoDic = new GiornoFestivo(d8Dic);
			Calendario.getInstance().getGiorniFestivi().add(ottoDic);
			
			LocalDate lVigilia = new LocalDate(2014,12,24);
			java.sql.Date dataVigilia = new java.sql.Date(lVigilia.toDate().getTime());
			GiornoFestivo vigilia = new GiornoFestivo(dataVigilia);
			Calendario.getInstance().getGiorniFestivi().add(vigilia);
			
			LocalDate lDataNatale = new LocalDate(2014,12,25);
			java.sql.Date dataNatale = new java.sql.Date(lDataNatale.toDate().getTime());
			GiornoFestivo natale = new GiornoFestivo(dataNatale);
			Calendario.getInstance().getGiorniFestivi().add(natale);
			
			LocalDate lDataSStefano = new LocalDate(2014,12,26);
			java.sql.Date dataSStefano = new java.sql.Date(lDataSStefano.toDate().getTime());
			GiornoFestivo sStefano = new GiornoFestivo(dataSStefano);
			Calendario.getInstance().getGiorniFestivi().add(sStefano);
			
			LocalDate lDataCapodanno = new LocalDate(2015,1,1);
			java.sql.Date dataCapodanno = new java.sql.Date(lDataCapodanno.toDate().getTime());
			GiornoFestivo capodanno = new GiornoFestivo(dataCapodanno);
			Calendario.getInstance().getGiorniFestivi().add(capodanno);
			
			for(GiornoFestivo g : Calendario.getInstance().getGiorniFestivi()){
				RSPersistentManager.instance().getSession().save(g);
			}

//			RSPersistentManager.instance().getSession().save(sabato);
//			RSPersistentManager.instance().getSession().save(domenica);
//			RSPersistentManager.instance().getSession().save(ottoDic);
//			RSPersistentManager.instance().getSession().save(vigilia);
//			RSPersistentManager.instance().getSession().save(natale);
//			RSPersistentManager.instance().getSession().save(sStefano);
//			RSPersistentManager.instance().getSession().save(capodanno);
			
//			CREAZIONE DELLA SCUOLA
			Scuola scuola1 = new Scuola();
			
//			CREAZIONE DELLE CLASSI
			Classe primaA = new Classe("1A");
			Classe secondaA = new Classe("2A");
			Classe primaB = new Classe("1B");
			Classe secondaB = new Classe("2B");
			
			scuola1.getClassi().add(primaA);
			scuola1.getClassi().add( secondaA);
			scuola1.getClassi().add( primaB);
			scuola1.getClassi().add( secondaB);
						
//			CREAZIONE DEI DOCENTI
			Docente marioRossi = new Docente("Mario", "Rossi");
			Docente mirkoBianchi = new Docente("Mirko", "Bianchi");
			Docente giulioVerdi = new Docente("Giulio", "Verdi");
			Docente vincenzoNeri = new Docente("Vincenzo", "Neri");
			Docente giuseppeGialli = new Docente("Giuseppe", "Gialli");
			
//			ASSEGNAZIONE DEI DOCENTI ALLA SCUOLA
			scuola1.getDocenti().add(marioRossi);
			scuola1.getDocenti().add( mirkoBianchi);
			scuola1.getDocenti().add( giulioVerdi);
			scuola1.getDocenti().add( vincenzoNeri);
			scuola1.getDocenti().add( giuseppeGialli);
			
			
//			CREAZIONE DEI REGISTRI DOCENTE
			RegistroDocente registroRossiPrimaAstoria = new RegistroDocente();
			RegistroDocente registroRossiPrimaAmat = new RegistroDocente();
			RegistroDocente registroRossiSecondaA = new RegistroDocente();
			RegistroDocente registroRossiPrimaB = new RegistroDocente();
			RegistroDocente registroRossiSecondaB = new RegistroDocente();
			
			RegistroDocente registroBianchiPrimaA = new RegistroDocente();
			RegistroDocente registroBianchiPrimaB = new RegistroDocente();
			
//			ASSEGNAZIONE DELLE CLASSI AI REGISTRI DOCENTE
			registroRossiPrimaAstoria.setClasse(primaA);
			registroRossiPrimaAmat.setClasse(primaA);
			
			registroRossiSecondaA.setClasse(secondaA);
			registroRossiPrimaB.setClasse(primaB);
			registroRossiSecondaB.setClasse(secondaB);
			
			registroBianchiPrimaA.setClasse(primaA);
			registroBianchiPrimaB.setClasse(primaB);
			
//			ASSEGNAZIONE DEI REGISTRO DOCENTE AI DOCENTI
			marioRossi.getRegistriDocente().add(registroRossiPrimaAstoria);
			marioRossi.getRegistriDocente().add(registroRossiPrimaAmat);
			marioRossi.getRegistriDocente().add(registroRossiSecondaA);
			marioRossi.getRegistriDocente().add(registroRossiPrimaB);
			marioRossi.getRegistriDocente().add(registroRossiSecondaB);
			
			mirkoBianchi.getRegistriDocente().add(registroBianchiPrimaA);
			mirkoBianchi.getRegistriDocente().add(registroBianchiPrimaB);
			
//			CREAZIONE DEGLI STUDENTI
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
			
//			VETTORE CON TUTTI GLI STUDENTI
			Studente[]studenti  = {pieroRusso, marinoEsposito, marioRomano, davideDiSalvo, ivoMarino, leonardoRicci, valentinoFarina, roccoBenedetti, antonioGuerra, cristinaAngeli, mariannaDonati, elenaSarti, mariaPiaAlfredi, giorgioGatti, lorenzoNegri, mattiaVitali, emanueleDelMonte, 	luigiBernardi, vittorioPellegrini, alexVilla, marcoBattaglia, alfredoMorelli, pieraDellaValle, ignazioBoschi, jacopoValli, gianniConte, lucaBarone, giacomoSiciliano, fabrizioToscani, arturoAncona};

//			CREAZIONE DEI LIBRETTI ASSENZA E ASSEGNAZIONE AGLI STUDENTI

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
			
//			CREAZIONE DEI LIBRETTI VOTI E ASSEGNAZIONE AGLI STUDENTI
			LibrettoVoti librettoVoti;
			for(Studente studente : studenti){
				librettoVoti = new LibrettoVoti();
				studente.setLibrettoVoti(librettoVoti);
			}
			
//			CREAZIONE DEI REGISTRI ASSENZA
			RegistroAssenze regAssPrimaA = new RegistroAssenze();
			RegistroAssenze regAssSecondaA = new RegistroAssenze();
			RegistroAssenze regAssPrimaB = new RegistroAssenze();
			RegistroAssenze regAssSecondaB = new RegistroAssenze();
			

//			ASSEGNAZIONE DEGLI STUDENTI ALLE CLASSI
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
			
//			ASSEGNAZIONE DEI REGISTRI ASSENZA ALLE CLASSI
			primaA.setRegistroAssenze(regAssPrimaA);
			secondaA.setRegistroAssenze(regAssSecondaA);
			primaB.setRegistroAssenze(regAssPrimaB);
			secondaB.setRegistroAssenze(regAssSecondaB);
			
			
//			CREAZIONE DELLE DATE
			LocalDate data01_12_14 = new LocalDate(2014,12,1);
			LocalDate data02_12_14 = new LocalDate(2014,12,2);
			LocalDate data03_12_14 = new LocalDate(2014,12,3);
			LocalDate data04_12_14 = new LocalDate(2014,12,4);
			LocalDate data05_12_14 = new LocalDate(2014,12,5);
			LocalDate data09_12_14 = new LocalDate(2014,12,9);
			LocalDate data10_12_14 = new LocalDate(2014,12,10);
			LocalDate data11_12_14 = new LocalDate(2014,12,11);
			LocalDate data12_12_14 = new LocalDate(2014,12,12);
			LocalDate data15_12_14 = new LocalDate(2014,12,15);
			LocalDate data16_12_14 = new LocalDate(2014,12,16);
			
			LocalDate data17_12_14 = new LocalDate(2014,12,17);

			LinkedList<LocalDate> datePerAppelli = new LinkedList<LocalDate>();
			datePerAppelli.add(data01_12_14);
			datePerAppelli.add(data02_12_14);
			datePerAppelli.add(data03_12_14);
			datePerAppelli.add(data04_12_14);
			datePerAppelli.add(data05_12_14);
			datePerAppelli.add(data09_12_14);
			datePerAppelli.add(data10_12_14);
			datePerAppelli.add(data11_12_14);
			datePerAppelli.add(data12_12_14);
			datePerAppelli.add(data15_12_14);
			
//			CREAZIONE DEGLI APPELLI
			Appello appello_1A_01_12_14 = new Appello(data01_12_14);
			Appello appello_1A_02_12_14 = new Appello(data02_12_14);
			Appello appello_1A_03_12_14 = new Appello(data03_12_14);
			Appello appello_1A_04_12_14 = new Appello(data04_12_14);
			Appello appello_1A_05_12_14 = new Appello(data05_12_14);
			Appello appello_1A_09_12_14 = new Appello(data09_12_14);
			Appello appello_1A_10_12_14 = new Appello(data10_12_14);
			Appello appello_1A_11_12_14 = new Appello(data11_12_14);
			Appello appello_1A_12_12_14 = new Appello(data12_12_14);
			Appello appello_1A_15_12_14 = new Appello(data15_12_14);
			Appello appello_1A_16_12_14 = new Appello(data16_12_14);
			
			Appello appello_2A_16_12_14 = new Appello(data16_12_14);
			Appello appello_1B_16_12_14 = new Appello(data16_12_14);
			Appello appello_2B_16_12_14 = new Appello(data16_12_14);
			
//			ASSEGNAZIONE DEGLI APPELLI AI REGISTRI
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_01_12_14.getData()) , appello_1A_01_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_02_12_14.getData()) , appello_1A_02_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_03_12_14.getData()) , appello_1A_03_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_04_12_14.getData()) , appello_1A_04_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_05_12_14.getData()) , appello_1A_05_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_09_12_14.getData()) , appello_1A_09_12_14);
			regAssPrimaA.getAppelli().put( Calendario.getInstance().getDaysFromZero(appello_1A_10_12_14.getData()) , appello_1A_10_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_11_12_14.getData()), appello_1A_11_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_12_12_14.getData()), appello_1A_12_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_15_12_14.getData()), appello_1A_15_12_14);
			regAssPrimaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1A_16_12_14.getData()), appello_1A_16_12_14);
			
			regAssSecondaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_2A_16_12_14.getData()), appello_2A_16_12_14);
			regAssPrimaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_1B_16_12_14.getData()), appello_1B_16_12_14);
			regAssSecondaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello_2B_16_12_14.getData()), appello_2B_16_12_14);
			
//			CREAZIONE DELLE ASSENZE
			Assenza assMarioRomano1 = new Assenza();
			Assenza assPieroRusso1 = new Assenza();
			Assenza assIvoMarini1 = new Assenza();
			Assenza assIvoMarini2 = new Assenza();
			Assenza assIvoMarini3 = new Assenza();
			Assenza assDavideDiSalvo1 = new Assenza();
			Assenza assMarinoEsposito1 = new Assenza();
			
			Assenza assMariannaDonati1 =  new Assenza();
			Assenza assLorenzoNegri1 =  new Assenza();
			
// 			ASSEGNAZIONE DEGLI APPELLI ALLE ASSENZE
			
			assMarioRomano1.getAppelli().add(appello_1A_10_12_14);
			assMarioRomano1.getAppelli().add(appello_1A_11_12_14);
			assPieroRusso1.getAppelli().add(appello_1A_10_12_14);
			assPieroRusso1.getAppelli().add(appello_1A_11_12_14);
			assPieroRusso1.getAppelli().add(appello_1A_12_12_14);
			assIvoMarini1.getAppelli().add(appello_1A_15_12_14);
			assIvoMarini1.getAppelli().add(appello_1A_16_12_14);
			assIvoMarini2.getAppelli().add(appello_1A_10_12_14);
			assIvoMarini2.getAppelli().add(appello_1A_11_12_14);
			assMarinoEsposito1.getAppelli().add(appello_1A_16_12_14);
			assDavideDiSalvo1.getAppelli().add(appello_1A_16_12_14);
			assMariannaDonati1.getAppelli().add(appello_2A_16_12_14);
			assLorenzoNegri1.getAppelli().add(appello_2A_16_12_14);
			
//			ASSEGNAZIONE DELLE ASSENZE AI LIBRETTI
			librettoMarioRomano.getNonGiustificate().add(assMarioRomano1);
			librettoIvoMarino.getNonGiustificate().add(assIvoMarini1);
			librettoIvoMarino.getNonGiustificate().add(assIvoMarini2);
			librettoMarinoEsposito.getNonGiustificate().add(assMarinoEsposito1);
			librettoDavideDiSalvo.getNonGiustificate().add(assDavideDiSalvo1);
			librettoMariannaDonati.getNonGiustificate().add(assMariannaDonati1);
			librettoLorenzoNegri.getNonGiustificate().add(assLorenzoNegri1);	
			
//			-----------------------------------------	
			appello_1A_01_12_14.setAssenzePrese(true);
			appello_1A_02_12_14.setAssenzePrese(true);
			appello_1A_03_12_14.setAssenzePrese(true);
			appello_1A_04_12_14.setAssenzePrese(true);
			appello_1A_05_12_14.setAssenzePrese(true);
			appello_1A_09_12_14.setAssenzePrese(true);
			appello_1A_10_12_14.setAssenzePrese(true);
			appello_1A_11_12_14.setAssenzePrese(true);
			appello_1A_12_12_14.setAssenzePrese(true);
//			appello_1A_13_12_14.setAssenzePrese(true);
			appello_1A_15_12_14.setAssenzePrese(true);
			appello_1A_16_12_14.setAssenzePrese(true);
			
			appello_2A_16_12_14.setAssenzePrese(true);
			appello_1B_16_12_14.setAssenzePrese(true);
			appello_2B_16_12_14.setAssenzePrese(true);
			
//			Ulteriori appelli per la seconda A
			Appello appello;
			for(LocalDate data : datePerAppelli){
				appello = new Appello(data);
				regAssSecondaA.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello.getData()), appello);
				appello.setAssenzePrese(true);
			}
			
//			Ulteriori appelli per la prima B
			for(LocalDate data : datePerAppelli){
				appello = new Appello(data);
				regAssPrimaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello.getData()), appello);
				appello.setAssenzePrese(true);
			}
			
//			Ulteriori appelli per la seconda B
			for(LocalDate data : datePerAppelli){
				appello = new Appello(data);
				regAssSecondaB.getAppelli().put(Calendario.getInstance().getDaysFromZero(appello.getData()), appello);
				appello.setAssenzePrese(true);
			}
			
//			CREAZIONE DELLE MATERIE
			Materia storia = new Materia();
			storia.setNome("Storia");

			Materia geografia = new Materia();
			geografia.setNome("Geografia");

			Materia matematica = new Materia();
			matematica.setNome("Matematica");
			
//			ASSEGNAZIONE DELLE MATERIE AI REGISTRI
			registroRossiPrimaAstoria.setMateria(storia);
			registroRossiPrimaB.setMateria(storia);
			
			registroBianchiPrimaA.setMateria(geografia);
			registroBianchiPrimaB.setMateria(geografia);
			
			registroRossiSecondaA.setMateria(geografia);
			registroRossiSecondaB.setMateria(geografia);
			
			registroRossiPrimaAmat.setMateria(matematica);

//			SALVATAGGIO DELLE MATERIE
			RSPersistentManager.instance().getSession().save(storia);
			RSPersistentManager.instance().getSession().save(geografia);
			RSPersistentManager.instance().getSession().save(matematica);
			
//			CREAZIONE DEGLI ARGOMENTI
			Argomento worldWar1 = new Argomento("I Guerra Mondiale", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento worldWar2 = new Argomento("II Guerra Mondiale","", java.sql.Date.valueOf("2014-11-18"));
			Argomento colonialismo = new Argomento("colonialismo","", java.sql.Date.valueOf("2014-12-23"));
			Argomento secondoDopoGuerra = new Argomento("secondo dopoguerra","",java.sql.Date.valueOf("2014-12-10") );
			
			Argomento romanEmpireFall = new Argomento("Caduta dell'Impero Romano", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento epocaDeiComuni = new Argomento("Epoca dei comuni", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento fondazioneRoma = new Argomento("Fondazione di Roma", "", java.sql.Date.valueOf("2014-11-16"));
			
			Argomento equazioni = new Argomento("Equazioni", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento disequazioni = new Argomento("Disequazioni", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento sistemiEquazioni = new Argomento("Sistemi di Equazioni", "", java.sql.Date.valueOf("2014-11-16"));
			
			Argomento regioniItalia = new Argomento("Regioni D'Italia", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento provincePiemonte = new Argomento("Province del Piemonte", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento provinceLombardia = new Argomento("Province della Lombardia", "", java.sql.Date.valueOf("2014-11-16"));
			
			Argomento provinceAbruzzo = new Argomento("Province del Abruzzo", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento provincePuglia = new Argomento("Province della Puglia", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento provinceSardegna = new Argomento("Province della Sardegna", "", java.sql.Date.valueOf("2014-11-16"));
			
			Argomento scandinavia = new Argomento("Scandinavia", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento penisolaIberica = new Argomento("Penisola Iberica", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento balcani = new Argomento("Balcani", "", java.sql.Date.valueOf("2014-11-16"));
			
			Argomento usa = new Argomento("U.S.A", "", java.sql.Date.valueOf("2014-11-11"));
			Argomento canada = new Argomento("Canada", "", java.sql.Date.valueOf("2014-11-15"));
			Argomento messico = new Argomento("Messico", "", java.sql.Date.valueOf("2014-11-16"));
			
//			ASSEGNAZIONE DEGLI ARGOMENTI AI REGISTRI
			registroRossiPrimaAstoria.getArgomentiSvolti().add(worldWar1);
			registroRossiPrimaAstoria.getArgomentiSvolti().add(worldWar2);
			registroRossiPrimaAstoria.getArgomentiSvolti().add(colonialismo);
			registroRossiPrimaAstoria.getArgomentiSvolti().add(secondoDopoGuerra);
			
			registroRossiPrimaAmat.getArgomentiSvolti().add(equazioni);
			registroRossiPrimaAmat.getArgomentiSvolti().add(disequazioni);
			registroRossiPrimaAmat.getArgomentiSvolti().add(sistemiEquazioni);
			
			registroRossiPrimaB.getArgomentiSvolti().add(romanEmpireFall);
			registroRossiPrimaB.getArgomentiSvolti().add(epocaDeiComuni);
			registroRossiPrimaB.getArgomentiSvolti().add(fondazioneRoma);
			
			registroRossiSecondaA.getArgomentiSvolti().add(regioniItalia);
			registroRossiSecondaA.getArgomentiSvolti().add(provincePiemonte);
			registroRossiSecondaA.getArgomentiSvolti().add(provinceLombardia);
			
			registroRossiSecondaB.getArgomentiSvolti().add(provinceAbruzzo);
			registroRossiSecondaB.getArgomentiSvolti().add(provincePuglia);
			registroRossiSecondaB.getArgomentiSvolti().add(provinceSardegna);
			
			registroBianchiPrimaA.getArgomentiSvolti().add(scandinavia);
			registroBianchiPrimaA.getArgomentiSvolti().add(penisolaIberica);
			registroBianchiPrimaA.getArgomentiSvolti().add(balcani);
			
			registroBianchiPrimaB.getArgomentiSvolti().add(usa);
			registroBianchiPrimaB.getArgomentiSvolti().add(canada);
			registroBianchiPrimaB.getArgomentiSvolti().add(messico);
			
//			COMPITI IN CLASSE DI STRORIA
			
//			CREAZIONE DEL PRIMO COMPITO IN CLASSE -sto
			Collection<Argomento> argomenti = new LinkedList<Argomento>();
			argomenti.clear();
			argomenti.add(worldWar1);
			argomenti.add(worldWar2);
			CompitoInClasse compitoStoria1A = new CompitoInClasse(registroRossiPrimaAstoria);
			compitoStoria1A.setInfo(java.sql.Date.valueOf("2014-12-16"), java.sql.Time.valueOf("11:00:00"), java.sql.Time.valueOf("13:00:00"), argomenti);

			registroRossiPrimaAstoria.getCompitiInClasse().add(compitoStoria1A);
			
			Map<Studente, Voto> mapVoti;
			mapVoti = new HashMap<Studente, Voto>();
			
			mapVoti.put(pieroRusso, new Voto(4f));
			mapVoti.put(marioRomano, new Voto(8f));
			mapVoti.put(leonardoRicci, new Voto(9f));
			mapVoti.put(valentinoFarina, new Voto(7f));
			mapVoti.put(roccoBenedetti, new Voto(5f));
			mapVoti.put(antonioGuerra, new Voto(10f));
			mapVoti.put(cristinaAngeli, new Voto(6f));
			
			compitoStoria1A.setSvolto();
			compitoStoria1A.inserisciVoti(mapVoti);
			compitoStoria1A.chiudi();
			
//			CREAZIONE DEL SECONDO COMPITO IN CLASSE -sto
			argomenti.clear();
			compitoStoria1A = new CompitoInClasse(registroRossiPrimaAstoria);
			compitoStoria1A.setInfo(java.sql.Date.valueOf("2014-12-15"), java.sql.Time.valueOf("10:00:00"), java.sql.Time.valueOf("11:30:00"), argomenti);

			registroRossiPrimaAstoria.getCompitiInClasse().add(compitoStoria1A);
			
//			CREAZIONE DEL TERZO COMPITO IN CLASSE -sto

			Collection<Argomento> argomenti_3 = new LinkedList<Argomento>();
			argomenti_3.clear();
			argomenti_3.add(colonialismo);
			argomenti_3.add(secondoDopoGuerra);
			CompitoInClasse compitoStoria1A_3 = new CompitoInClasse(registroRossiPrimaAstoria);
			compitoStoria1A_3.setInfo(java.sql.Date.valueOf("2014-12-02"), java.sql.Time.valueOf("9:00:00"), java.sql.Time.valueOf("11:00:00"), argomenti_3);
			registroRossiPrimaAstoria.getCompitiInClasse().add(compitoStoria1A_3);
			Map<Studente, Voto> mapVoti_3;
			mapVoti_3 = new HashMap<Studente, Voto>();
			mapVoti_3.put(pieroRusso, new Voto(4.4f));
			mapVoti_3.put(marinoEsposito, new Voto(5.7f));
			mapVoti_3.put(marioRomano, new Voto(6.5f));
			mapVoti_3.put(davideDiSalvo, new Voto(8.2f));
			mapVoti_3.put(ivoMarino, new Voto(7.5f));
			mapVoti_3.put(leonardoRicci, new Voto(8.8f));
			mapVoti_3.put(valentinoFarina, new Voto(6.2f));
			mapVoti_3.put(roccoBenedetti, new Voto(2f));
			mapVoti_3.put(antonioGuerra, new Voto(9.3f));
			mapVoti_3.put(cristinaAngeli, new Voto(8.7f));
						
			
			compitoStoria1A_3.setSvolto();
			compitoStoria1A_3.inserisciVoti(mapVoti_3);
			compitoStoria1A_3.chiudi();
			
//			COMPITI IN CLASSE DI MATEMATICA
//			CREAZIONE DEL PRIMO COMPITO IN CLASSE -mat
			Collection<Argomento> argomentiMat1 = new LinkedList<Argomento>();
			argomentiMat1.clear();
			argomentiMat1.add(disequazioni);
			CompitoInClasse compitoMat1A_1 = new CompitoInClasse(registroRossiPrimaAmat);
			compitoMat1A_1.setInfo(java.sql.Date.valueOf("2014-12-16"), java.sql.Time.valueOf("10:30:00"), java.sql.Time.valueOf("12:30:00"), argomentiMat1);

			registroRossiPrimaAmat.getCompitiInClasse().add(compitoMat1A_1);
			
			Map<Studente, Voto> mapVoti_mat;
			mapVoti_mat = new HashMap<Studente, Voto>();
			
			mapVoti_mat.put(pieroRusso, new Voto(4.4f));
			mapVoti_mat.put(marioRomano, new Voto(7f));
			mapVoti_mat.put(leonardoRicci, new Voto(8f));
			mapVoti_mat.put(valentinoFarina, new Voto(9f));
			mapVoti_mat.put(roccoBenedetti, new Voto(6.5f));
			mapVoti_mat.put(antonioGuerra, new Voto(10.2f));
			mapVoti_mat.put(cristinaAngeli, new Voto(6.4f));
			
			compitoMat1A_1.setSvolto();
			compitoMat1A_1.inserisciVoti(mapVoti_mat);
//			compitoMat1A_1.chiudi();
			
//			CREAZIONE DEL SECONDO COMPITO IN CLASSE -mat

			Collection<Argomento> argomentiMat2 = new LinkedList<Argomento>();
			argomentiMat2.clear();
			argomentiMat2.add(equazioni);

			CompitoInClasse compitoMat1A_2 = new CompitoInClasse(registroRossiPrimaAmat);
			compitoMat1A_2.setInfo(java.sql.Date.valueOf("2014-12-02"), java.sql.Time.valueOf("9:30:00"), java.sql.Time.valueOf("11:30:00"), argomenti_3);
			registroRossiPrimaAmat.getCompitiInClasse().add(compitoMat1A_2);
			Map<Studente, Voto> mapVoti_mat2;
			mapVoti_mat2 = new HashMap<Studente, Voto>();
			mapVoti_mat2.put(pieroRusso, new Voto(4.4f));
			mapVoti_mat2.put(marinoEsposito, new Voto(5.7f));
			mapVoti_mat2.put(marioRomano, new Voto(6.5f));
			mapVoti_mat2.put(davideDiSalvo, new Voto(8.2f));
			mapVoti_mat2.put(ivoMarino, new Voto(7.5f));
			mapVoti_mat2.put(leonardoRicci, new Voto(8.8f));
			mapVoti_mat2.put(valentinoFarina, new Voto(6.2f));
			mapVoti_mat2.put(roccoBenedetti, new Voto(2f));
			mapVoti_mat2.put(antonioGuerra, new Voto(9.3f));
			mapVoti_mat2.put(cristinaAngeli, new Voto(8.7f));
						
			
			compitoMat1A_2.setSvolto();
			compitoMat1A_2.inserisciVoti(mapVoti_mat2);
//			compitoMat1A_2.chiudi();
			
//			SALVATAGGIO DELLA SCUOLA SUL DATABASE -------------------------------------------------------------
			RSPersistentManager.instance().getSession().save(scuola1);
//          ---------------------------------------------------------------------------------------------------

			
			t.commit();

		}
		catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
		
	}
	

}
