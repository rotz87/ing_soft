/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteRegistroScolasticoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.model.Studente ldomainmodelStudente= (domain.model.Studente)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelStudente);
			
			domain.model.Appello ldomainmodelAppello= (domain.model.Appello)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelAppello);
			
			domain.model.Assenza ldomainmodelAssenza= (domain.model.Assenza)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelAssenza);
			
			domain.model.Giustificazione ldomainmodelGiustificazione= (domain.model.Giustificazione)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelGiustificazione);
			
			domain.model.Ritardo ldomainmodelRitardo= (domain.model.Ritardo)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelRitardo);
			
			domain.model.PermessoEntrata ldomainmodelPermessoEntrata= (domain.model.PermessoEntrata)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelPermessoEntrata);
			
			domain.model.UscitaAnticipata ldomainmodelUscitaAnticipata= (domain.model.UscitaAnticipata)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelUscitaAnticipata);
			
			domain.model.PermessoUscita ldomainmodelPermessoUscita= (domain.model.PermessoUscita)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelPermessoUscita);
			
			domain.model.LibrettoAssenze ldomainmodelLibrettoAssenze= (domain.model.LibrettoAssenze)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelLibrettoAssenze);
			
			domain.model.RegistroAssenze ldomainmodelRegistroAssenze= (domain.model.RegistroAssenze)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelRegistroAssenze);
			
			domain.model.Scuola ldomainmodelScuola= (domain.model.Scuola)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelScuola);
			
			domain.model.Classe ldomainmodelClasse= (domain.model.Classe)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelClasse);
			
			domain.model.Docente ldomainmodelDocente= (domain.model.Docente)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelDocente);
			
			domain.model.Calendario ldomainmodelCalendario= (domain.model.Calendario)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Calendario").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelCalendario);
			
			domain.model.Giorno ldomainmodelGiorno= (domain.model.Giorno)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giorno").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelGiorno);
			
			domain.model.GiornoSettimanale ldomainmodelGiornoSettimanale= (domain.model.GiornoSettimanale)domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanale").setMaxResults(1).uniqueResult();
			domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainmodelGiornoSettimanale);
			
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
				domain.model.RegistroScolasticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
