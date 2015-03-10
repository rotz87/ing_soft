/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateRegistroScolasticoData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente = new domain.model.Studente();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello = new domain.model.Appello();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : assenzePrese
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza = new domain.model.Assenza();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelli
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione = new domain.model.Giustificazione();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : confermata
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo = new domain.model.Ritardo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appello
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata = new domain.model.PermessoEntrata();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata = new domain.model.UscitaAnticipata();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : permesso, appello
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita = new domain.model.PermessoUscita();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze = new domain.model.LibrettoAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : uscite, ritardi
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelLibrettoAssenze);
			
			domain.model.Indirizzo ldomainmodelIndirizzo = new domain.model.Indirizzo();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelIndirizzo);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze = new domain.model.RegistroAssenze();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : appelli
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola = new domain.model.Scuola();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : classi
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse = new domain.model.Classe();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : registroAssenze
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente = new domain.model.Docente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : registriDocente
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelDocente);
			
			domain.model.GiornoFestivo ldomainmodelGiornoFestivo = new domain.model.GiornoFestivo();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiornoFestivo);
			
			domain.model.GiornoSettimanaleFestivo ldomainmodelGiornoSettimanaleFestivo = new domain.model.GiornoSettimanaleFestivo();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : giorno
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelGiornoSettimanaleFestivo);
			
			domain.model.RegistroDocente ldomainmodelRegistroDocente = new domain.model.RegistroDocente();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : argomentiSvolti, classe
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelRegistroDocente);
			
			domain.model.Materia ldomainmodelMateria = new domain.model.Materia();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelMateria);
			
			domain.model.LibrettoVoti ldomainmodelLibrettoVoti = new domain.model.LibrettoVoti();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : libVotiLineItems
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelLibrettoVoti);
			
			domain.model.LibrettoVotiLineItem ldomainmodelLibrettoVotiLineItem = new domain.model.LibrettoVotiLineItem();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : compitoInClasse, voto
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelLibrettoVotiLineItem);
			
			domain.model.CompitoInClasse ldomainmodelCompitoInClasse = new domain.model.CompitoInClasse();			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : argomentiEsaminati
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelCompitoInClasse);
			
			domain.model.Voto ldomainmodelVoto = new domain.model.Voto();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelVoto);
			
			domain.model.Argomento ldomainmodelArgomento = new domain.model.Argomento();			// Initialize the properties of the persistent object here
			domain.model.RSPersistentManager.instance().getSession().save(ldomainmodelArgomento);
			
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
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
