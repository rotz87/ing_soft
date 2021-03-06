/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateRegistroScolasticoData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente= (domain.model.Studente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello= (domain.model.Appello)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza= (domain.model.Assenza)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione= (domain.model.Giustificazione)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo= (domain.model.Ritardo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata= (domain.model.PermessoEntrata)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata= (domain.model.UscitaAnticipata)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita= (domain.model.PermessoUscita)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze= (domain.model.LibrettoAssenze)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelLibrettoAssenze);
			
			domain.model.Indirizzo ldomainmodelIndirizzo= (domain.model.Indirizzo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Indirizzo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelIndirizzo);
			
			domain.model.RegistroAppelli ldomainmodelRegistroAppelli= (domain.model.RegistroAppelli)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAppelli").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelRegistroAppelli);
			
			domain.model.Scuola ldomainmodelScuola= (domain.model.Scuola)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse= (domain.model.Classe)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente= (domain.model.Docente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelDocente);
			
			domain.model.GiornoFestivo ldomainmodelGiornoFestivo= (domain.model.GiornoFestivo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoFestivo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelGiornoFestivo);
			
			domain.model.GiornoSettimanaleFestivo ldomainmodelGiornoSettimanaleFestivo= (domain.model.GiornoSettimanaleFestivo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanaleFestivo").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelGiornoSettimanaleFestivo);
			
			domain.model.RegistroDocente ldomainmodelRegistroDocente= (domain.model.RegistroDocente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroDocente").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelRegistroDocente);
			
			domain.model.Materia ldomainmodelMateria= (domain.model.Materia)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Materia").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelMateria);
			
			domain.model.LibrettoVoti ldomainmodelLibrettoVoti= (domain.model.LibrettoVoti)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVoti").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelLibrettoVoti);
			
			domain.model.LibrettoVotiLineItem ldomainmodelLibrettoVotiLineItem= (domain.model.LibrettoVotiLineItem)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVotiLineItem").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelLibrettoVotiLineItem);
			
			domain.model.compitoInClasse.CompitoInClasse ldomainmodelcompitoInClasseCompitoInClasse= (domain.model.compitoInClasse.CompitoInClasse)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.compitoInClasse.CompitoInClasse").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelcompitoInClasseCompitoInClasse);
			
			domain.model.Voto ldomainmodelVoto= (domain.model.Voto)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Voto").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelVoto);
			
			domain.model.Argomento ldomainmodelArgomento= (domain.model.Argomento)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Argomento").setMaxResults(1).uniqueResult();
			// Update the properties of the persistent object
			service.RSPersistentManager.instance().getSession().update(ldomainmodelArgomento);
			
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
		//ldomainmodelStudenteCriteria.ID.eq();
		System.out.println(ldomainmodelStudenteCriteria.uniqueStudente());
		
		System.out.println("Retrieving Appello by AppelloCriteria");
		domain.model.AppelloCriteria ldomainmodelAppelloCriteria = new domain.model.AppelloCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelAppelloCriteria.ID.eq();
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
		
		System.out.println("Retrieving Indirizzo by IndirizzoCriteria");
		domain.model.IndirizzoCriteria ldomainmodelIndirizzoCriteria = new domain.model.IndirizzoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelIndirizzoCriteria.ID.eq();
		System.out.println(ldomainmodelIndirizzoCriteria.uniqueIndirizzo());
		
		System.out.println("Retrieving RegistroAppelli by RegistroAppelliCriteria");
		domain.model.RegistroAppelliCriteria ldomainmodelRegistroAppelliCriteria = new domain.model.RegistroAppelliCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelRegistroAppelliCriteria.ID.eq();
		System.out.println(ldomainmodelRegistroAppelliCriteria.uniqueRegistroAppelli());
		
		System.out.println("Retrieving Scuola by ScuolaCriteria");
		domain.model.ScuolaCriteria ldomainmodelScuolaCriteria = new domain.model.ScuolaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelScuolaCriteria.ID.eq();
		System.out.println(ldomainmodelScuolaCriteria.uniqueScuola());
		
		System.out.println("Retrieving Classe by ClasseCriteria");
		domain.model.ClasseCriteria ldomainmodelClasseCriteria = new domain.model.ClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelClasseCriteria.ID.eq();
		System.out.println(ldomainmodelClasseCriteria.uniqueClasse());
		
		System.out.println("Retrieving Docente by DocenteCriteria");
		domain.model.DocenteCriteria ldomainmodelDocenteCriteria = new domain.model.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelDocenteCriteria.ID.eq();
		System.out.println(ldomainmodelDocenteCriteria.uniqueDocente());
		
		System.out.println("Retrieving GiornoFestivo by GiornoFestivoCriteria");
		domain.model.GiornoFestivoCriteria ldomainmodelGiornoFestivoCriteria = new domain.model.GiornoFestivoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelGiornoFestivoCriteria.ID.eq();
		System.out.println(ldomainmodelGiornoFestivoCriteria.uniqueGiornoFestivo());
		
		System.out.println("Retrieving GiornoSettimanaleFestivo by GiornoSettimanaleFestivoCriteria");
		domain.model.GiornoSettimanaleFestivoCriteria ldomainmodelGiornoSettimanaleFestivoCriteria = new domain.model.GiornoSettimanaleFestivoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelGiornoSettimanaleFestivoCriteria.ID.eq();
		System.out.println(ldomainmodelGiornoSettimanaleFestivoCriteria.uniqueGiornoSettimanaleFestivo());
		
		System.out.println("Retrieving RegistroDocente by RegistroDocenteCriteria");
		domain.model.RegistroDocenteCriteria ldomainmodelRegistroDocenteCriteria = new domain.model.RegistroDocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelRegistroDocenteCriteria.ID.eq();
		System.out.println(ldomainmodelRegistroDocenteCriteria.uniqueRegistroDocente());
		
		System.out.println("Retrieving Materia by MateriaCriteria");
		domain.model.MateriaCriteria ldomainmodelMateriaCriteria = new domain.model.MateriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelMateriaCriteria.ID.eq();
		System.out.println(ldomainmodelMateriaCriteria.uniqueMateria());
		
		System.out.println("Retrieving LibrettoVoti by LibrettoVotiCriteria");
		domain.model.LibrettoVotiCriteria ldomainmodelLibrettoVotiCriteria = new domain.model.LibrettoVotiCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelLibrettoVotiCriteria.ID.eq();
		System.out.println(ldomainmodelLibrettoVotiCriteria.uniqueLibrettoVoti());
		
		System.out.println("Retrieving LibrettoVotiLineItem by LibrettoVotiLineItemCriteria");
		domain.model.LibrettoVotiLineItemCriteria ldomainmodelLibrettoVotiLineItemCriteria = new domain.model.LibrettoVotiLineItemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelLibrettoVotiLineItemCriteria.ID.eq();
		System.out.println(ldomainmodelLibrettoVotiLineItemCriteria.uniqueLibrettoVotiLineItem());
		
		System.out.println("Retrieving CompitoInClasse by CompitoInClasseCriteria");
		domain.model.compitoInClasse.CompitoInClasseCriteria ldomainmodelcompitoInClasseCompitoInClasseCriteria = new domain.model.compitoInClasse.CompitoInClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelcompitoInClasseCompitoInClasseCriteria.ID.eq();
		System.out.println(ldomainmodelcompitoInClasseCompitoInClasseCriteria.uniqueCompitoInClasse());
		
		System.out.println("Retrieving Voto by VotoCriteria");
		domain.model.VotoCriteria ldomainmodelVotoCriteria = new domain.model.VotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelVotoCriteria.ID.eq();
		System.out.println(ldomainmodelVotoCriteria.uniqueVoto());
		
		System.out.println("Retrieving Argomento by ArgomentoCriteria");
		domain.model.ArgomentoCriteria ldomainmodelArgomentoCriteria = new domain.model.ArgomentoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ldomainmodelArgomentoCriteria.ID.eq();
		System.out.println(ldomainmodelArgomentoCriteria.uniqueArgomento());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateRegistroScolasticoData retrieveAndUpdateRegistroScolasticoData = new RetrieveAndUpdateRegistroScolasticoData();
			try {
				retrieveAndUpdateRegistroScolasticoData.retrieveAndUpdateTestData();
				//retrieveAndUpdateRegistroScolasticoData.retrieveByCriteria();
			}
			finally {
				service.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
