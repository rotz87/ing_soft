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
public class prova {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			Scuola scuola1 = new Scuola();
			
			//creazione delle classi
			Classe primaA = new Classe("1A");

			scuola1.getClassi().add(primaA);
						
			//Crrazione dei docenti
			Docente marioRossi = new Docente("Mario", "Rossi");
			
			

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
			prova createRegistroScolasticoData = new prova();
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
