/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteRegistroScolasticoData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.persistent.Studente ldomainpersistentStudente= (domain.persistent.Studente)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Studente").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentStudente);
			
			domain.persistent.Appello ldomainpersistentAppello= (domain.persistent.Appello)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Appello").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentAppello);
			
			domain.persistent.Assenza ldomainpersistentAssenza= (domain.persistent.Assenza)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Assenza").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentAssenza);
			
			domain.persistent.Giustificazione ldomainpersistentGiustificazione= (domain.persistent.Giustificazione)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Giustificazione").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentGiustificazione);
			
			domain.persistent.Ritardo ldomainpersistentRitardo= (domain.persistent.Ritardo)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Ritardo").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentRitardo);
			
			domain.persistent.PermessoEntrata ldomainpersistentPermessoEntrata= (domain.persistent.PermessoEntrata)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoEntrata").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentPermessoEntrata);
			
			domain.persistent.UscitaAnticipata ldomainpersistentUscitaAnticipata= (domain.persistent.UscitaAnticipata)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.UscitaAnticipata").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentUscitaAnticipata);
			
			domain.persistent.PermessoUscita ldomainpersistentPermessoUscita= (domain.persistent.PermessoUscita)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoUscita").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentPermessoUscita);
			
			domain.persistent.LibrettoAssenze ldomainpersistentLibrettoAssenze= (domain.persistent.LibrettoAssenze)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.LibrettoAssenze").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentLibrettoAssenze);
			
			domain.persistent.Indirizzo ldomainpersistentIndirizzo= (domain.persistent.Indirizzo)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Indirizzo").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentIndirizzo);
			
			domain.persistent.RegistroAssenze ldomainpersistentRegistroAssenze= (domain.persistent.RegistroAssenze)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.RegistroAssenze").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentRegistroAssenze);
			
			domain.persistent.Scuola ldomainpersistentScuola= (domain.persistent.Scuola)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Scuola").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentScuola);
			
			domain.persistent.Classe ldomainpersistentClasse= (domain.persistent.Classe)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Classe").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentClasse);
			
			domain.persistent.Docente ldomainpersistentDocente= (domain.persistent.Docente)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Docente").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentDocente);
			
			domain.persistent.Calendario ldomainpersistentCalendario= (domain.persistent.Calendario)domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Calendario").setMaxResults(1).uniqueResult();
			domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().delete(ldomainpersistentCalendario);
			
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
				domain.persistent.RegistroScolasticoPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
