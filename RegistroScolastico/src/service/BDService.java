/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package service;

import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.joda.time.LocalDate;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.RegistroScolasticoPersistentManager;
import domain.model.Scuola;
import domain.model.Studente;
public class BDService {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
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
						
			//Crrazione dei docenti
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
			
			//assegnazione delle classi ai docenti
			
			//assegnazione delle classi a Rossi

			marioRossi.getClassi().add(primaA);
			marioRossi.getClassi().add(secondaA);
			marioRossi.getClassi().add(primaB);
			marioRossi.getClassi().add(secondaB);
			
			//assegnazione delle classi a Rossi

			mirkoBianchi.getClassi().add(primaA);
			mirkoBianchi.getClassi().add(primaB);			
			
			//Creazione degli studenti
//			Studente  = new Studente("", "");
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
			
//			mapStudenti.put(.getId(), );
			primaA.getStudenti().add(pieroRusso);
			primaA.getStudenti().add( marinoEsposito);
			primaA.getStudenti().add( marioRomano);
			primaA.getStudenti().add( davideDiSalvo);
			primaA.getStudenti().add( ivoMarino);
			primaA.getStudenti().add(leonardoRicci );
			primaA.getStudenti().add( valentinoFarina);
			primaA.getStudenti().add( roccoBenedetti);
			primaA.getStudenti().add( antonioGuerra);
			primaA.getStudenti().add(cristinaAngeli );
			
			secondaA.getStudenti().add( mariannaDonati);
			secondaA.getStudenti().add( elenaSarti);
			secondaA.getStudenti().add( mariaPiaAlfredi);
			secondaA.getStudenti().add(giorgioGatti );
			secondaA.getStudenti().add(lorenzoNegri );
			secondaA.getStudenti().add( mattiaVitali);
			secondaA.getStudenti().add( emanueleDelMonte);
			secondaA.getStudenti().add(luigiBernardi);
			secondaA.getStudenti().add(vittorioPellegrini );
			secondaA.getStudenti().add( alexVilla);
			
			primaB.getStudenti().add( marcoBattaglia);
			primaB.getStudenti().add(alfredoMorelli );
			primaB.getStudenti().add(pieraDellaValle );
			primaB.getStudenti().add( ignazioBoschi);
			primaB.getStudenti().add( jacopoValli );
			
			secondaB.getStudenti().add( gianniConte);
			secondaB.getStudenti().add( lucaBarone);
			secondaB.getStudenti().add( giacomoSiciliano);
			secondaB.getStudenti().add(fabrizioToscani);
			secondaB.getStudenti().add( arturoAncona);
			

//				LibrettoAssenze libretto =  new LibrettoAssenze();
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
			
			//creazione dei registri
			RegistroAssenze regAssPrimaA = new RegistroAssenze();
			RegistroAssenze regAssSecondaA = new RegistroAssenze();
			RegistroAssenze regAssPrimaB = new RegistroAssenze();
			RegistroAssenze regAssSecondaB = new RegistroAssenze();
			
			regAssPrimaA.getLibrettiAssenze().put(marioRomano.getId(), librettoMarioRomano);
			regAssPrimaA.getLibrettiAssenze().put(davideDiSalvo.getId(),librettoDavideDiSalvo);
			regAssPrimaA.getLibrettiAssenze().put(ivoMarino.getId(), librettoIvoMarino);
			regAssPrimaA.getLibrettiAssenze().put(pieroRusso.getId(), librettoPieroRusso);
			regAssPrimaA.getLibrettiAssenze().put(marinoEsposito.getId(),librettoMarinoEsposito);
			regAssPrimaA.getLibrettiAssenze().put(leonardoRicci.getId(),librettoLeonardoRicci);
			regAssPrimaA.getLibrettiAssenze().put(valentinoFarina.getId(),librettoValentinoFarina);
			regAssPrimaA.getLibrettiAssenze().put(roccoBenedetti.getId(),librettoRoccoBenedetti);
			regAssPrimaA.getLibrettiAssenze().put(antonioGuerra.getId(),librettoAntonioGuerra);
			regAssPrimaA.getLibrettiAssenze().put(cristinaAngeli.getId(),librettoCristinaAngeli);
			
			regAssSecondaA.getLibrettiAssenze().put(mariannaDonati.getId(),librettoMariannaDonati);
			regAssSecondaA.getLibrettiAssenze().put(elenaSarti.getId(),librettoElenaSarti);
			regAssSecondaA.getLibrettiAssenze().put(mariaPiaAlfredi.getId(),librettoMariaPiaAlfredi);
			regAssSecondaA.getLibrettiAssenze().put(giorgioGatti.getId(),librettoGiorgioGatti);
			regAssSecondaA.getLibrettiAssenze().put(lorenzoNegri.getId(),librettoLorenzoNegri);
			regAssSecondaA.getLibrettiAssenze().put(mattiaVitali.getId(),librettoMattiaVitali);
			regAssSecondaA.getLibrettiAssenze().put(emanueleDelMonte.getId(),librettoEmanueleDelMonte);
			regAssSecondaA.getLibrettiAssenze().put(luigiBernardi.getId(),librettoLuigiBernardi);
			regAssSecondaA.getLibrettiAssenze().put(vittorioPellegrini.getId(),librettoVittorioPellegrini);
			regAssSecondaA.getLibrettiAssenze().put(alexVilla.getId(),librettoAlexVilla);
			
			regAssPrimaB.getLibrettiAssenze().put(marcoBattaglia.getId(),librettoMarcoBattaglia);
			regAssPrimaB.getLibrettiAssenze().put(alfredoMorelli.getId(),librettoAlfredoMorelli);
			regAssPrimaB.getLibrettiAssenze().put(pieraDellaValle.getId(),librettoPieraDellaValle);
			regAssPrimaB.getLibrettiAssenze().put(ignazioBoschi.getId(),librettoIgnazioBoschi);
			regAssPrimaB.getLibrettiAssenze().put(jacopoValli.getId(),librettoJacopoValli);
			
			regAssSecondaB.getLibrettiAssenze().put(gianniConte.getId(),librettoGianniConte);
			regAssSecondaB.getLibrettiAssenze().put(lucaBarone.getId() ,librettoLucaBarone );
			regAssSecondaB.getLibrettiAssenze().put(giacomoSiciliano.getId(),librettoGiacomoSiciliano);
			regAssSecondaB.getLibrettiAssenze().put(fabrizioToscani.getId(),librettoFabrizioToscani);
			regAssSecondaB.getLibrettiAssenze().put(arturoAncona.getId(),librettoArturoAncona);

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
			
//			//creazione di lista di appelli da assegnare all'assenza
//			LinkedList<Appello> appelliAssenzeMarioRomano = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzePieroRusso = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeIvoMarini = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeMarinoEsposito = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeDavideDiSalvo = new LinkedList<Appello>();
//			LinkedList<Appello> AppelliAssenzeTestFineMese = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeIvoMarini2 = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeIvoMarini3 = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeMariannaDonati = new LinkedList<Appello>();
//			LinkedList<Appello> appelliAssenzeLorenzoNegri = new LinkedList<Appello>();
			
			
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
			
//			tuttiGliAppelli.put(appello8_12_14.getIdAppello(), appello8_12_14);

//			regAssPrimaA.getAppelliRegistro().put(appello_1A_10_12_14.getIdAppello(), appello_1A_10_12_14);
//			regAssPrimaA.getAppelliRegistro().put(appello_1A_11_12_14.getIdAppello(), appello_1A_11_12_14);
//			regAssPrimaA.getAppelliRegistro().put(appello_1A_12_12_14.getIdAppello(), appello_1A_12_12_14);
//			regAssPrimaA.getAppelliRegistro().put(appello_1A_13_12_14.getIdAppello(), appello_1A_13_12_14);
////			tuttiGliAppelli.put(appello14_12_14.getIdAppello(), appello14_12_14);
//			regAssPrimaA.getAppelliRegistro().put(appello_1A_15_12_14.getIdAppello(), appello_1A_15_12_14);
//			regAssPrimaA.getAppelliRegistro().put(appello_1A_16_12_14.getIdAppello(), appello_1A_16_12_14);
//			
//			regAssSecondaA.getAppelliRegistro().put(appello_2A_16_12_14.getIdAppello(), appello_2A_16_12_14);
//			regAssPrimaB.getAppelliRegistro().put(appello_1B_16_12_14.getIdAppello(), appello_1B_16_12_14);
//			regAssSecondaB.getAppelliRegistro().put(appello_2B_16_12_14.getIdAppello(), appello_2B_16_12_14);
			
			
//			regAssPrimaA.getAppelli().put(appello8_12_14.getData(), appello8_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_10_12_14.getData()).toDate().hashCode()), appello_1A_10_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_11_12_14.getData()).toDate().hashCode()), appello_1A_11_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_12_12_14.getData())).toDate().hashCode(), appello_1A_12_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_13_12_14.getData())).toDate().hashCode(), appello_1A_13_12_14);
//			regAssPrimaA.getAppelli().put(appello14_12_14.getData(), appello14_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_15_12_14.getData())).toDate().hashCode(), appello_1A_15_12_14);
			regAssPrimaA.getAppelliRegistro().put((new LocalDate(appello_1A_16_12_14.getData())).toDate().hashCode(), appello_1A_16_12_14);
			
			regAssSecondaA.getAppelliRegistro().put((new LocalDate(appello_2A_16_12_14.getData())).toDate().hashCode(), appello_2A_16_12_14);
			regAssPrimaB.getAppelliRegistro().put((new LocalDate(appello_1B_16_12_14.getData())).toDate().hashCode(), appello_1B_16_12_14);
			regAssSecondaB.getAppelliRegistro().put((new LocalDate(appello_2B_16_12_14.getData())).toDate().hashCode(), appello_2B_16_12_14);
			
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
			

			assMarioRomano1.getAppelliAssenza().add(appello_1A_10_12_14);
			assMarioRomano1.getAppelliAssenza().add(appello_1A_11_12_14);
//					AppelliAssenzeMaccio.add(appello12_12_14);
			 
			assPieroRusso1.getAppelliAssenza().add(appello_1A_10_12_14);
			assPieroRusso1.getAppelliAssenza().add(appello_1A_11_12_14);
			assPieroRusso1.getAppelliAssenza().add(appello_1A_12_12_14);
//					assPieroRusso1.getAppelliAssenza().add(appello16_12_14);
			
			assIvoMarini2.getAppelliAssenza().add(appello_1A_10_12_14);
			assIvoMarini2.getAppelliAssenza().add(appello_1A_11_12_14);
			
//			assIvoMarini3.getAppelliAssenza().add(appello8_12_14);
			

//			assIvoMarini1.getAppelliAssenza().add(appello14_12_14);
			assIvoMarini1.getAppelliAssenza().add(appello_1A_15_12_14);
			assIvoMarini1.getAppelliAssenza().add(appello_1A_16_12_14);
			
			assMarinoEsposito1.getAppelliAssenza().add(appello_1A_16_12_14);
			
			assDavideDiSalvo1.getAppelliAssenza().add(appello_1A_16_12_14);
			
			assMariannaDonati1.getAppelliAssenza().add(appello_2A_16_12_14);
			assLorenzoNegri1.getAppelliAssenza().add(appello_2A_16_12_14);
			
			
//			//creazione delle liste di assenze da assegnare ai libretti
//			LinkedList<Assenza> listaAssenzeMarioRomano = new  LinkedList<Assenza>();
//			listaAssenzeMarioRomano.add(assM1);
//			LinkedList<Assenza> listaAssenzePieroRusso = new  LinkedList<Assenza>();
//			listaAssenzePieroRusso.add(assP1);
//			LinkedList<Assenza> listaAssenzeIvoMarini = new  LinkedList<Assenza>();
////			listaAssenzeIvoMarini.add(assI3);
//			listaAssenzeIvoMarini.add(assI2);
//			listaAssenzeIvoMarini.add(assI1);
//			LinkedList<Assenza> listaAssenzeDavideDiSalvo = new  LinkedList<Assenza>();
//			listaAssenzeDavideDiSalvo.add(assD1);
//			LinkedList<Assenza> listaAssenzeMarinoEsposito = new  LinkedList<Assenza>();
//			listaAssenzeMarinoEsposito.add(assMa1);
//			
//			LinkedList<Assenza> listaAssenzeMariannaDonati = new  LinkedList<Assenza>();
//			listaAssenzeMariannaDonati.add(assMariannaDonati1);
//			LinkedList<Assenza> listaAssenzeLorenzoNegri = new  LinkedList<Assenza>();
//			listaAssenzeLorenzoNegri.add(assLorenzoNegri1);
			
//			//assegnazione delle liste ai libretti
//			librettoMarioRomano.setNonGiustificate(listaAssenzeMarioRomano);
//			librettoPieroRusso.setNonGiustificate(listaAssenzePieroRusso);
////			librettoPiero.assengnaAssenzeNonGiustificate(listaAssenzeTsetFineMese);
//			librettoIvoMarino.setNonGiustificate(listaAssenzeIvoMarini);
////			librettoMarino.assengnaAssenzeNonGiustificate(listaAssenzeMarino);
//			librettoDavideDiSalvo.setNonGiustificate(listaAssenzeDavideDiSalvo);
//			
//			librettoMariannaDonati.setNonGiustificate(listaAssenzeMariannaDonati);
//			librettoLorenzoNegri.setNonGiustificate(listaAssenzeLorenzoNegri);
			
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
			
			RegistroScolasticoPersistentManager.instance().getSession().save(scuola1);
			
//			Classe primaA = new Classe("1A");
//			scuola1.getClassi().add(primaA);
//			
//			RegistroAssenze regAssPrimaA = new RegistroAssenze();
//			
//			Studente guidoGialli = new Studente("Guido","Gialli");
//			primaA.getStudenti().add(guidoGialli);
//			
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(scuola1);
			
//			domain.model.Studente ldomainmodelStudente = new domain.model.Studente();			// Initialize the properties of the persistent object here
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelStudente);
			
//			domain.model.Appello ldomainmodelAppello = new domain.model.Appello();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : assenzePrese
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelAppello);
//			
//			domain.model.Assenza ldomainmodelAssenza = new domain.model.Assenza();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelliAssenza
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelAssenza);
//			
//			domain.model.Giustificazione ldomainmodelGiustificazione = new domain.model.Giustificazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : confermata
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiustificazione);
//			
//			domain.model.Ritardo ldomainmodelRitardo = new domain.model.Ritardo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appello
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelRitardo);
//			
//			domain.model.PermessoEntrata ldomainmodelPermessoEntrata = new domain.model.PermessoEntrata();			// Initialize the properties of the persistent object here
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelPermessoEntrata);
//			
//			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata = new domain.model.UscitaAnticipata();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : permesso, appello
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelUscitaAnticipata);
//			
//			domain.model.PermessoUscita ldomainmodelPermessoUscita = new domain.model.PermessoUscita();			// Initialize the properties of the persistent object here
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelPermessoUscita);
//			
//			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze = new domain.model.LibrettoAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : uscite, ritardi, nonGiustificate, giustificate, studente
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelLibrettoAssenze);
//			
//			domain.model.RegistroAssenze ldomainmodelRegistroAssenze = new domain.model.RegistroAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelliRegistro, librettiAssenze, appelloOdierno
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelRegistroAssenze);
//			
//			domain.model.Scuola ldomainmodelScuola = new domain.model.Scuola();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : docenti, classi
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelScuola);
//			
//			domain.model.Classe ldomainmodelClasse = new domain.model.Classe();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : studenti, registroAssenze
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelClasse);
//			
//			domain.model.Docente ldomainmodelDocente = new domain.model.Docente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classi
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelDocente);
//			
//			domain.model.Calendario ldomainmodelCalendario = new domain.model.Calendario();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorniSettimanaliFestivi, giorniFestivi
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelCalendario);
//			
//			domain.model.Giorno ldomainmodelGiorno = new domain.model.Giorno();			// Initialize the properties of the persistent object here
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiorno);
//			
//			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale = new domain.model.GiornoSettimanale();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorno
//			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiornoSettimanale);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			BDService createRegistroScolasticoData = new BDService();
			try {
				createRegistroScolasticoData.createTestData();
			}
			finally {
				domain.model.RegistroScolasticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
