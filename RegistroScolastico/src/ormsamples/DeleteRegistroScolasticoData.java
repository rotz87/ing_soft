/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteRegistroScolasticoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RSPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente= (domain.model.Studente)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello= (domain.model.Appello)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza= (domain.model.Assenza)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione= (domain.model.Giustificazione)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo= (domain.model.Ritardo)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata= (domain.model.PermessoEntrata)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata= (domain.model.UscitaAnticipata)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita= (domain.model.PermessoUscita)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze= (domain.model.LibrettoAssenze)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelLibrettoAssenze);
			
			domain.model.Indirizzo ldomainmodelIndirizzo= (domain.model.Indirizzo)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Indirizzo").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelIndirizzo);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze= (domain.model.RegistroAssenze)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola= (domain.model.Scuola)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse= (domain.model.Classe)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente= (domain.model.Docente)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelDocente);
			
			domain.model.Calendario ldomainmodelCalendario= (domain.model.Calendario)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Calendario").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelCalendario);
			
			domain.model.Giorno ldomainmodelGiorno= (domain.model.Giorno)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.Giorno").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelGiorno);
			
			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale= (domain.model.GiornoSettimanale)domain.model.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanale").setMaxResults(1).uniqueResult();
			domain.model.RSPersistentManager.instance().getSession().delete(ldomainmodelGiornoSettimanale);
			
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
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
