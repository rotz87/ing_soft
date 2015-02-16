/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateRegistroScolasticoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente = new domain.model.Studente();			// Initialize the properties of the persistent object here
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello = new domain.model.Appello();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : assenzePrese
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza = new domain.model.Assenza();			// Initialize the properties of the persistent object here
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione = new domain.model.Giustificazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : confermata
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo = new domain.model.Ritardo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appello
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata = new domain.model.PermessoEntrata();			// Initialize the properties of the persistent object here
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata = new domain.model.UscitaAnticipata();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : permesso, appello
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita = new domain.model.PermessoUscita();			// Initialize the properties of the persistent object here
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze = new domain.model.LibrettoAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : uscite, ritardi, nonGiustificate, giustificate, studente
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelLibrettoAssenze);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze = new domain.model.RegistroAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelliRegistro, librettiAssenze
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola = new domain.model.Scuola();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : docenti, classi
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse = new domain.model.Classe();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : registroAssenze
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente = new domain.model.Docente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classi
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelDocente);
			
			domain.model.Calendario ldomainmodelCalendario = new domain.model.Calendario();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorniSettimanaliFestivi, giorniFestivi
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelCalendario);
			
			domain.model.Giorno ldomainmodelGiorno = new domain.model.Giorno();			// Initialize the properties of the persistent object here
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiorno);
			
			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale = new domain.model.GiornoSettimanale();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorno
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(ldomainmodelGiornoSettimanale);
			
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
				domain.model.RegistroScolasticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
