/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateRegistroScolasticoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.persistent.Studente ldomainpersistentStudente = new domain.persistent.Studente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : indrizzo
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentStudente);
			
			domain.persistent.Appello ldomainpersistentAppello = new domain.persistent.Appello();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : assenzePrese
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentAppello);
			
			domain.persistent.Assenza ldomainpersistentAssenza = new domain.persistent.Assenza();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelli, appelliAssenza, appello
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentAssenza);
			
			domain.persistent.Giustificazione ldomainpersistentGiustificazione = new domain.persistent.Giustificazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : confermata
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentGiustificazione);
			
			domain.persistent.Ritardo ldomainpersistentRitardo = new domain.persistent.Ritardo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appello, permessoEntrata
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentRitardo);
			
			domain.persistent.PermessoEntrata ldomainpersistentPermessoEntrata = new domain.persistent.PermessoEntrata();			// Initialize the properties of the persistent object here
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentPermessoEntrata);
			
			domain.persistent.UscitaAnticipata ldomainpersistentUscitaAnticipata = new domain.persistent.UscitaAnticipata();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : permesso, appello
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentUscitaAnticipata);
			
			domain.persistent.PermessoUscita ldomainpersistentPermessoUscita = new domain.persistent.PermessoUscita();			// Initialize the properties of the persistent object here
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentPermessoUscita);
			
			domain.persistent.LibrettoAssenze ldomainpersistentLibrettoAssenze = new domain.persistent.LibrettoAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : uscite, ritardi, nonGiustificate, giustificate, studente
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentLibrettoAssenze);
			
			domain.persistent.Indirizzo ldomainpersistentIndirizzo = new domain.persistent.Indirizzo();			// Initialize the properties of the persistent object here
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentIndirizzo);
			
			domain.persistent.RegistroAssenze ldomainpersistentRegistroAssenze = new domain.persistent.RegistroAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelli, librettiAssenze, appelloOdierno
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentRegistroAssenze);
			
			domain.persistent.Scuola ldomainpersistentScuola = new domain.persistent.Scuola();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : docenti, classi
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentScuola);
			
			domain.persistent.Classe ldomainpersistentClasse = new domain.persistent.Classe();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : studenti, registroAssenze
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentClasse);
			
			domain.persistent.Docente ldomainpersistentDocente = new domain.persistent.Docente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classi
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentDocente);
			
			domain.persistent.Calendario ldomainpersistentCalendario = new domain.persistent.Calendario();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : instance
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainpersistentCalendario);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateRegistroScolasticoData createRegistroScolasticoData = new CreateRegistroScolasticoData();
			try {
				createRegistroScolasticoData.createTestData();
			}
			finally {
				domain.persistent.RegistroScolasticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
