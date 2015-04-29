/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteRegistroScolasticoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = service.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente= (domain.model.Studente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello= (domain.model.Appello)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza= (domain.model.Assenza)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione= (domain.model.Giustificazione)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo= (domain.model.Ritardo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata= (domain.model.PermessoEntrata)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata= (domain.model.UscitaAnticipata)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita= (domain.model.PermessoUscita)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze= (domain.model.LibrettoAssenze)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelLibrettoAssenze);
			
			domain.model.Indirizzo ldomainmodelIndirizzo= (domain.model.Indirizzo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Indirizzo").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelIndirizzo);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze= (domain.model.RegistroAssenze)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola= (domain.model.Scuola)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse= (domain.model.Classe)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente= (domain.model.Docente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelDocente);
			
			domain.model.GiornoFestivo ldomainmodelGiornoFestivo= (domain.model.GiornoFestivo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoFestivo").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelGiornoFestivo);
			
			domain.model.GiornoSettimanaleFestivo ldomainmodelGiornoSettimanaleFestivo= (domain.model.GiornoSettimanaleFestivo)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanaleFestivo").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelGiornoSettimanaleFestivo);
			
			domain.model.RegistroDocente ldomainmodelRegistroDocente= (domain.model.RegistroDocente)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroDocente").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelRegistroDocente);
			
			domain.model.Materia ldomainmodelMateria= (domain.model.Materia)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Materia").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelMateria);
			
			domain.model.LibrettoVoti ldomainmodelLibrettoVoti= (domain.model.LibrettoVoti)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVoti").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelLibrettoVoti);
			
			domain.model.LibrettoVotiLineItem ldomainmodelLibrettoVotiLineItem= (domain.model.LibrettoVotiLineItem)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVotiLineItem").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelLibrettoVotiLineItem);
			
			domain.model.compitoInClasse.CompitoInClasse ldomainmodelcompitoInClasseCompitoInClasse= (domain.model.compitoInClasse.CompitoInClasse)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.compitoInClasse.CompitoInClasse").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelcompitoInClasseCompitoInClasse);
			
			domain.model.Voto ldomainmodelVoto= (domain.model.Voto)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Voto").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelVoto);
			
			domain.model.Argomento ldomainmodelArgomento= (domain.model.Argomento)service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Argomento").setMaxResults(1).uniqueResult();
			service.RSPersistentManager.instance().getSession().delete(ldomainmodelArgomento);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			DeleteRegistroScolasticoData deleteRegistroScolasticoData = new DeleteRegistroScolasticoData();
			try {
				deleteRegistroScolasticoData.deleteTestData();
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
