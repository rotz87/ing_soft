/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateRegistroScolasticoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.persistent.Studente ldomainpersistentStudente= (domain.persistent.Studente)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Studente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentStudente);
			
			domain.persistent.Appello ldomainpersistentAppello= (domain.persistent.Appello)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Appello").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentAppello);
			
			domain.persistent.Assenza ldomainpersistentAssenza= (domain.persistent.Assenza)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Assenza").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentAssenza);
			
			domain.persistent.Giustificazione ldomainpersistentGiustificazione= (domain.persistent.Giustificazione)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Giustificazione").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentGiustificazione);
			
			domain.persistent.Ritardo ldomainpersistentRitardo= (domain.persistent.Ritardo)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Ritardo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentRitardo);
			
			domain.persistent.PermessoEntrata ldomainpersistentPermessoEntrata= (domain.persistent.PermessoEntrata)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoEntrata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentPermessoEntrata);
			
			domain.persistent.UscitaAnticipata ldomainpersistentUscitaAnticipata= (domain.persistent.UscitaAnticipata)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.UscitaAnticipata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentUscitaAnticipata);
			
			domain.persistent.PermessoUscita ldomainpersistentPermessoUscita= (domain.persistent.PermessoUscita)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoUscita").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentPermessoUscita);
			
			domain.persistent.LibrettoAssenze ldomainpersistentLibrettoAssenze= (domain.persistent.LibrettoAssenze)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.LibrettoAssenze").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentLibrettoAssenze);
			
			domain.persistent.Indirizzo ldomainpersistentIndirizzo= (domain.persistent.Indirizzo)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Indirizzo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentIndirizzo);
			
			domain.persistent.RegistroAssenze ldomainpersistentRegistroAssenze= (domain.persistent.RegistroAssenze)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.RegistroAssenze").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentRegistroAssenze);
			
			domain.persistent.Scuola ldomainpersistentScuola= (domain.persistent.Scuola)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Scuola").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentScuola);
			
			domain.persistent.Classe ldomainpersistentClasse= (domain.persistent.Classe)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Classe").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentClasse);
			
			domain.persistent.Docente ldomainpersistentDocente= (domain.persistent.Docente)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Docente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentDocente);
			
			domain.persistent.Calendario ldomainpersistentCalendario= (domain.persistent.Calendario)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Calendario").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainpersistentCalendario);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Studente by StudenteCriteria");
		domain.persistent.StudenteCriteria ldomainpersistentStudenteCriteria = new domain.persistent.StudenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentStudenteCriteria.id.eq();
		System.out.println(ldomainpersistentStudenteCriteria.uniqueStudente());
		
		System.out.println("Retrieving Appello by AppelloCriteria");
		domain.persistent.AppelloCriteria ldomainpersistentAppelloCriteria = new domain.persistent.AppelloCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentAppelloCriteria.idAppello.eq();
		System.out.println(ldomainpersistentAppelloCriteria.uniqueAppello());
		
		System.out.println("Retrieving Assenza by AssenzaCriteria");
		domain.persistent.AssenzaCriteria ldomainpersistentAssenzaCriteria = new domain.persistent.AssenzaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentAssenzaCriteria.ID.eq();
		System.out.println(ldomainpersistentAssenzaCriteria.uniqueAssenza());
		
		System.out.println("Retrieving Giustificazione by GiustificazioneCriteria");
		domain.persistent.GiustificazioneCriteria ldomainpersistentGiustificazioneCriteria = new domain.persistent.GiustificazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentGiustificazioneCriteria.ID.eq();
		System.out.println(ldomainpersistentGiustificazioneCriteria.uniqueGiustificazione());
		
		System.out.println("Retrieving Ritardo by RitardoCriteria");
		domain.persistent.RitardoCriteria ldomainpersistentRitardoCriteria = new domain.persistent.RitardoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentRitardoCriteria.ID.eq();
		System.out.println(ldomainpersistentRitardoCriteria.uniqueRitardo());
		
		System.out.println("Retrieving PermessoEntrata by PermessoEntrataCriteria");
		domain.persistent.PermessoEntrataCriteria ldomainpersistentPermessoEntrataCriteria = new domain.persistent.PermessoEntrataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentPermessoEntrataCriteria.ID.eq();
		System.out.println(ldomainpersistentPermessoEntrataCriteria.uniquePermessoEntrata());
		
		System.out.println("Retrieving UscitaAnticipata by UscitaAnticipataCriteria");
		domain.persistent.UscitaAnticipataCriteria ldomainpersistentUscitaAnticipataCriteria = new domain.persistent.UscitaAnticipataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentUscitaAnticipataCriteria.ID.eq();
		System.out.println(ldomainpersistentUscitaAnticipataCriteria.uniqueUscitaAnticipata());
		
		System.out.println("Retrieving PermessoUscita by PermessoUscitaCriteria");
		domain.persistent.PermessoUscitaCriteria ldomainpersistentPermessoUscitaCriteria = new domain.persistent.PermessoUscitaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentPermessoUscitaCriteria.ID.eq();
		System.out.println(ldomainpersistentPermessoUscitaCriteria.uniquePermessoUscita());
		
		System.out.println("Retrieving LibrettoAssenze by LibrettoAssenzeCriteria");
		domain.persistent.LibrettoAssenzeCriteria ldomainpersistentLibrettoAssenzeCriteria = new domain.persistent.LibrettoAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentLibrettoAssenzeCriteria.ID.eq();
		System.out.println(ldomainpersistentLibrettoAssenzeCriteria.uniqueLibrettoAssenze());
		
		System.out.println("Retrieving Indirizzo by IndirizzoCriteria");
		domain.persistent.IndirizzoCriteria ldomainpersistentIndirizzoCriteria = new domain.persistent.IndirizzoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentIndirizzoCriteria.ID.eq();
		System.out.println(ldomainpersistentIndirizzoCriteria.uniqueIndirizzo());
		
		System.out.println("Retrieving RegistroAssenze by RegistroAssenzeCriteria");
		domain.persistent.RegistroAssenzeCriteria ldomainpersistentRegistroAssenzeCriteria = new domain.persistent.RegistroAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentRegistroAssenzeCriteria.ID.eq();
		System.out.println(ldomainpersistentRegistroAssenzeCriteria.uniqueRegistroAssenze());
		
		System.out.println("Retrieving Scuola by ScuolaCriteria");
		domain.persistent.ScuolaCriteria ldomainpersistentScuolaCriteria = new domain.persistent.ScuolaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentScuolaCriteria.ID.eq();
		System.out.println(ldomainpersistentScuolaCriteria.uniqueScuola());
		
		System.out.println("Retrieving Classe by ClasseCriteria");
		domain.persistent.ClasseCriteria ldomainpersistentClasseCriteria = new domain.persistent.ClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentClasseCriteria.idClasse.eq();
		System.out.println(ldomainpersistentClasseCriteria.uniqueClasse());
		
		System.out.println("Retrieving Docente by DocenteCriteria");
		domain.persistent.DocenteCriteria ldomainpersistentDocenteCriteria = new domain.persistent.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentDocenteCriteria.idDocente.eq();
		System.out.println(ldomainpersistentDocenteCriteria.uniqueDocente());
		
		System.out.println("Retrieving Calendario by CalendarioCriteria");
		domain.persistent.CalendarioCriteria ldomainpersistentCalendarioCriteria = new domain.persistent.CalendarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainpersistentCalendarioCriteria.ID.eq();
		System.out.println(ldomainpersistentCalendarioCriteria.uniqueCalendario());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateRegistroScolasticoData retrieveAndUpdateRegistroScolasticoData = new RetrieveAndUpdateRegistroScolasticoData();
			try {
				retrieveAndUpdateRegistroScolasticoData.retrieveAndUpdateTestData();
				//retrieveAndUpdateRegistroScolasticoData.retrieveByCriteria();
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
