/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateRegistroScolasticoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente= (domain.model.Studente)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello= (domain.model.Appello)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza= (domain.model.Assenza)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione= (domain.model.Giustificazione)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo= (domain.model.Ritardo)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata= (domain.model.PermessoEntrata)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata= (domain.model.UscitaAnticipata)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita= (domain.model.PermessoUscita)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze= (domain.model.LibrettoAssenze)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelLibrettoAssenze);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze= (domain.model.RegistroAssenze)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola= (domain.model.Scuola)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse= (domain.model.Classe)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente= (domain.model.Docente)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelDocente);
			
			domain.model.Calendario ldomainmodelCalendario= (domain.model.Calendario)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Calendario").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelCalendario);
			
			domain.model.Giorno ldomainmodelGiorno= (domain.model.Giorno)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giorno").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelGiorno);
			
			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale= (domain.model.GiornoSettimanale)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanale").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(ldomainmodelGiornoSettimanale);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Studente by StudenteCriteria");
		domain.model.StudenteCriteria ldomainmodelStudenteCriteria = new domain.model.StudenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelStudenteCriteria.id.eq();
		System.out.println(ldomainmodelStudenteCriteria.uniqueStudente());
		
		System.out.println("Retrieving Appello by AppelloCriteria");
		domain.model.AppelloCriteria ldomainmodelAppelloCriteria = new domain.model.AppelloCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelAppelloCriteria.idAppello.eq();
		System.out.println(ldomainmodelAppelloCriteria.uniqueAppello());
		
		System.out.println("Retrieving Assenza by AssenzaCriteria");
		domain.model.AssenzaCriteria ldomainmodelAssenzaCriteria = new domain.model.AssenzaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelAssenzaCriteria.ID.eq();
		System.out.println(ldomainmodelAssenzaCriteria.uniqueAssenza());
		
		System.out.println("Retrieving Giustificazione by GiustificazioneCriteria");
		domain.model.GiustificazioneCriteria ldomainmodelGiustificazioneCriteria = new domain.model.GiustificazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelGiustificazioneCriteria.ID.eq();
		System.out.println(ldomainmodelGiustificazioneCriteria.uniqueGiustificazione());
		
		System.out.println("Retrieving Ritardo by RitardoCriteria");
		domain.model.RitardoCriteria ldomainmodelRitardoCriteria = new domain.model.RitardoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelRitardoCriteria.ID.eq();
		System.out.println(ldomainmodelRitardoCriteria.uniqueRitardo());
		
		System.out.println("Retrieving PermessoEntrata by PermessoEntrataCriteria");
		domain.model.PermessoEntrataCriteria ldomainmodelPermessoEntrataCriteria = new domain.model.PermessoEntrataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelPermessoEntrataCriteria.ID.eq();
		System.out.println(ldomainmodelPermessoEntrataCriteria.uniquePermessoEntrata());
		
		System.out.println("Retrieving UscitaAnticipata by UscitaAnticipataCriteria");
		domain.model.UscitaAnticipataCriteria ldomainmodelUscitaAnticipataCriteria = new domain.model.UscitaAnticipataCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelUscitaAnticipataCriteria.ID.eq();
		System.out.println(ldomainmodelUscitaAnticipataCriteria.uniqueUscitaAnticipata());
		
		System.out.println("Retrieving PermessoUscita by PermessoUscitaCriteria");
		domain.model.PermessoUscitaCriteria ldomainmodelPermessoUscitaCriteria = new domain.model.PermessoUscitaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelPermessoUscitaCriteria.ID.eq();
		System.out.println(ldomainmodelPermessoUscitaCriteria.uniquePermessoUscita());
		
		System.out.println("Retrieving LibrettoAssenze by LibrettoAssenzeCriteria");
		domain.model.LibrettoAssenzeCriteria ldomainmodelLibrettoAssenzeCriteria = new domain.model.LibrettoAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelLibrettoAssenzeCriteria.ID.eq();
		System.out.println(ldomainmodelLibrettoAssenzeCriteria.uniqueLibrettoAssenze());
		
		System.out.println("Retrieving RegistroAssenze by RegistroAssenzeCriteria");
		domain.model.RegistroAssenzeCriteria ldomainmodelRegistroAssenzeCriteria = new domain.model.RegistroAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelRegistroAssenzeCriteria.ID.eq();
		System.out.println(ldomainmodelRegistroAssenzeCriteria.uniqueRegistroAssenze());
		
		System.out.println("Retrieving Scuola by ScuolaCriteria");
		domain.model.ScuolaCriteria ldomainmodelScuolaCriteria = new domain.model.ScuolaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelScuolaCriteria.ID.eq();
		System.out.println(ldomainmodelScuolaCriteria.uniqueScuola());
		
		System.out.println("Retrieving Classe by ClasseCriteria");
		domain.model.ClasseCriteria ldomainmodelClasseCriteria = new domain.model.ClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelClasseCriteria.idClasse.eq();
		System.out.println(ldomainmodelClasseCriteria.uniqueClasse());
		
		System.out.println("Retrieving Docente by DocenteCriteria");
		domain.model.DocenteCriteria ldomainmodelDocenteCriteria = new domain.model.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelDocenteCriteria.idDocente.eq();
		System.out.println(ldomainmodelDocenteCriteria.uniqueDocente());
		
		System.out.println("Retrieving Calendario by CalendarioCriteria");
		domain.model.CalendarioCriteria ldomainmodelCalendarioCriteria = new domain.model.CalendarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelCalendarioCriteria.ID.eq();
		System.out.println(ldomainmodelCalendarioCriteria.uniqueCalendario());
		
		System.out.println("Retrieving Giorno by GiornoCriteria");
		domain.model.GiornoCriteria ldomainmodelGiornoCriteria = new domain.model.GiornoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelGiornoCriteria.ID.eq();
		System.out.println(ldomainmodelGiornoCriteria.uniqueGiorno());
		
		System.out.println("Retrieving GiornoSettimanale by GiornoSettimanaleCriteria");
		domain.model.GiornoSettimanaleCriteria ldomainmodelGiornoSettimanaleCriteria = new domain.model.GiornoSettimanaleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelGiornoSettimanaleCriteria.ID.eq();
		System.out.println(ldomainmodelGiornoSettimanaleCriteria.uniqueGiornoSettimanale());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateRegistroScolasticoData retrieveAndUpdateRegistroScolasticoData = new RetrieveAndUpdateRegistroScolasticoData();
			try {
				retrieveAndUpdateRegistroScolasticoData.retrieveAndUpdateTestData();
				//retrieveAndUpdateRegistroScolasticoData.retrieveByCriteria();
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
