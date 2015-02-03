/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListRegistroScolasticoData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Studente...");
		java.util.List lStudenteList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Studente").setMaxResults(ROW_COUNT).list();
		domain.persistent.Studente[] ldomainpersistentStudentes = (domain.persistent.Studente[]) lStudenteList.toArray(new domain.persistent.Studente[lStudenteList.size()]);
		int length = Math.min(ldomainpersistentStudentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentStudentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Appello...");
		java.util.List lAppelloList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Appello").setMaxResults(ROW_COUNT).list();
		domain.persistent.Appello[] ldomainpersistentAppellos = (domain.persistent.Appello[]) lAppelloList.toArray(new domain.persistent.Appello[lAppelloList.size()]);
		length = Math.min(ldomainpersistentAppellos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentAppellos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Assenza...");
		java.util.List lAssenzaList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Assenza").setMaxResults(ROW_COUNT).list();
		domain.persistent.Assenza[] ldomainpersistentAssenzas = (domain.persistent.Assenza[]) lAssenzaList.toArray(new domain.persistent.Assenza[lAssenzaList.size()]);
		length = Math.min(ldomainpersistentAssenzas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentAssenzas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Giustificazione...");
		java.util.List lGiustificazioneList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Giustificazione").setMaxResults(ROW_COUNT).list();
		domain.persistent.Giustificazione[] ldomainpersistentGiustificaziones = (domain.persistent.Giustificazione[]) lGiustificazioneList.toArray(new domain.persistent.Giustificazione[lGiustificazioneList.size()]);
		length = Math.min(ldomainpersistentGiustificaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentGiustificaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ritardo...");
		java.util.List lRitardoList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Ritardo").setMaxResults(ROW_COUNT).list();
		domain.persistent.Ritardo[] ldomainpersistentRitardos = (domain.persistent.Ritardo[]) lRitardoList.toArray(new domain.persistent.Ritardo[lRitardoList.size()]);
		length = Math.min(ldomainpersistentRitardos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentRitardos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoEntrata...");
		java.util.List lPermessoEntrataList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoEntrata").setMaxResults(ROW_COUNT).list();
		domain.persistent.PermessoEntrata[] ldomainpersistentPermessoEntratas = (domain.persistent.PermessoEntrata[]) lPermessoEntrataList.toArray(new domain.persistent.PermessoEntrata[lPermessoEntrataList.size()]);
		length = Math.min(ldomainpersistentPermessoEntratas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentPermessoEntratas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing UscitaAnticipata...");
		java.util.List lUscitaAnticipataList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.UscitaAnticipata").setMaxResults(ROW_COUNT).list();
		domain.persistent.UscitaAnticipata[] ldomainpersistentUscitaAnticipatas = (domain.persistent.UscitaAnticipata[]) lUscitaAnticipataList.toArray(new domain.persistent.UscitaAnticipata[lUscitaAnticipataList.size()]);
		length = Math.min(ldomainpersistentUscitaAnticipatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentUscitaAnticipatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoUscita...");
		java.util.List lPermessoUscitaList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.PermessoUscita").setMaxResults(ROW_COUNT).list();
		domain.persistent.PermessoUscita[] ldomainpersistentPermessoUscitas = (domain.persistent.PermessoUscita[]) lPermessoUscitaList.toArray(new domain.persistent.PermessoUscita[lPermessoUscitaList.size()]);
		length = Math.min(ldomainpersistentPermessoUscitas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentPermessoUscitas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LibrettoAssenze...");
		java.util.List lLibrettoAssenzeList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.LibrettoAssenze").setMaxResults(ROW_COUNT).list();
		domain.persistent.LibrettoAssenze[] ldomainpersistentLibrettoAssenzes = (domain.persistent.LibrettoAssenze[]) lLibrettoAssenzeList.toArray(new domain.persistent.LibrettoAssenze[lLibrettoAssenzeList.size()]);
		length = Math.min(ldomainpersistentLibrettoAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentLibrettoAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Indirizzo...");
		java.util.List lIndirizzoList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Indirizzo").setMaxResults(ROW_COUNT).list();
		domain.persistent.Indirizzo[] ldomainpersistentIndirizzos = (domain.persistent.Indirizzo[]) lIndirizzoList.toArray(new domain.persistent.Indirizzo[lIndirizzoList.size()]);
		length = Math.min(ldomainpersistentIndirizzos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentIndirizzos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RegistroAssenze...");
		java.util.List lRegistroAssenzeList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.RegistroAssenze").setMaxResults(ROW_COUNT).list();
		domain.persistent.RegistroAssenze[] ldomainpersistentRegistroAssenzes = (domain.persistent.RegistroAssenze[]) lRegistroAssenzeList.toArray(new domain.persistent.RegistroAssenze[lRegistroAssenzeList.size()]);
		length = Math.min(ldomainpersistentRegistroAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentRegistroAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Scuola...");
		java.util.List lScuolaList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Scuola").setMaxResults(ROW_COUNT).list();
		domain.persistent.Scuola[] ldomainpersistentScuolas = (domain.persistent.Scuola[]) lScuolaList.toArray(new domain.persistent.Scuola[lScuolaList.size()]);
		length = Math.min(ldomainpersistentScuolas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentScuolas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Classe...");
		java.util.List lClasseList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Classe").setMaxResults(ROW_COUNT).list();
		domain.persistent.Classe[] ldomainpersistentClasses = (domain.persistent.Classe[]) lClasseList.toArray(new domain.persistent.Classe[lClasseList.size()]);
		length = Math.min(ldomainpersistentClasses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentClasses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Docente...");
		java.util.List lDocenteList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Docente").setMaxResults(ROW_COUNT).list();
		domain.persistent.Docente[] ldomainpersistentDocentes = (domain.persistent.Docente[]) lDocenteList.toArray(new domain.persistent.Docente[lDocenteList.size()]);
		length = Math.min(ldomainpersistentDocentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentDocentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Calendario...");
		java.util.List lCalendarioList = domain.persistent.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.persistent.Calendario").setMaxResults(ROW_COUNT).list();
		domain.persistent.Calendario[] ldomainpersistentCalendarios = (domain.persistent.Calendario[]) lCalendarioList.toArray(new domain.persistent.Calendario[lCalendarioList.size()]);
		length = Math.min(ldomainpersistentCalendarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainpersistentCalendarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Studente by Criteria...");
		domain.persistent.StudenteCriteria ldomainpersistentStudenteCriteria = new domain.persistent.StudenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentStudenteCriteria.id.eq();
		ldomainpersistentStudenteCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Studente[] domainpersistentStudentes = ldomainpersistentStudenteCriteria.listStudente();
		int length =domainpersistentStudentes== null ? 0 : Math.min(domainpersistentStudentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentStudentes[i]);
		}
		System.out.println(length + " Studente record(s) retrieved."); 
		
		System.out.println("Listing Appello by Criteria...");
		domain.persistent.AppelloCriteria ldomainpersistentAppelloCriteria = new domain.persistent.AppelloCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentAppelloCriteria.idAppello.eq();
		ldomainpersistentAppelloCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Appello[] domainpersistentAppellos = ldomainpersistentAppelloCriteria.listAppello();
		length =domainpersistentAppellos== null ? 0 : Math.min(domainpersistentAppellos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentAppellos[i]);
		}
		System.out.println(length + " Appello record(s) retrieved."); 
		
		System.out.println("Listing Assenza by Criteria...");
		domain.persistent.AssenzaCriteria ldomainpersistentAssenzaCriteria = new domain.persistent.AssenzaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentAssenzaCriteria.ID.eq();
		ldomainpersistentAssenzaCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Assenza[] domainpersistentAssenzas = ldomainpersistentAssenzaCriteria.listAssenza();
		length =domainpersistentAssenzas== null ? 0 : Math.min(domainpersistentAssenzas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentAssenzas[i]);
		}
		System.out.println(length + " Assenza record(s) retrieved."); 
		
		System.out.println("Listing Giustificazione by Criteria...");
		domain.persistent.GiustificazioneCriteria ldomainpersistentGiustificazioneCriteria = new domain.persistent.GiustificazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentGiustificazioneCriteria.ID.eq();
		ldomainpersistentGiustificazioneCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Giustificazione[] domainpersistentGiustificaziones = ldomainpersistentGiustificazioneCriteria.listGiustificazione();
		length =domainpersistentGiustificaziones== null ? 0 : Math.min(domainpersistentGiustificaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentGiustificaziones[i]);
		}
		System.out.println(length + " Giustificazione record(s) retrieved."); 
		
		System.out.println("Listing Ritardo by Criteria...");
		domain.persistent.RitardoCriteria ldomainpersistentRitardoCriteria = new domain.persistent.RitardoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentRitardoCriteria.ID.eq();
		ldomainpersistentRitardoCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Ritardo[] domainpersistentRitardos = ldomainpersistentRitardoCriteria.listRitardo();
		length =domainpersistentRitardos== null ? 0 : Math.min(domainpersistentRitardos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentRitardos[i]);
		}
		System.out.println(length + " Ritardo record(s) retrieved."); 
		
		System.out.println("Listing PermessoEntrata by Criteria...");
		domain.persistent.PermessoEntrataCriteria ldomainpersistentPermessoEntrataCriteria = new domain.persistent.PermessoEntrataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentPermessoEntrataCriteria.ID.eq();
		ldomainpersistentPermessoEntrataCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.PermessoEntrata[] domainpersistentPermessoEntratas = ldomainpersistentPermessoEntrataCriteria.listPermessoEntrata();
		length =domainpersistentPermessoEntratas== null ? 0 : Math.min(domainpersistentPermessoEntratas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentPermessoEntratas[i]);
		}
		System.out.println(length + " PermessoEntrata record(s) retrieved."); 
		
		System.out.println("Listing UscitaAnticipata by Criteria...");
		domain.persistent.UscitaAnticipataCriteria ldomainpersistentUscitaAnticipataCriteria = new domain.persistent.UscitaAnticipataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentUscitaAnticipataCriteria.ID.eq();
		ldomainpersistentUscitaAnticipataCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.UscitaAnticipata[] domainpersistentUscitaAnticipatas = ldomainpersistentUscitaAnticipataCriteria.listUscitaAnticipata();
		length =domainpersistentUscitaAnticipatas== null ? 0 : Math.min(domainpersistentUscitaAnticipatas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentUscitaAnticipatas[i]);
		}
		System.out.println(length + " UscitaAnticipata record(s) retrieved."); 
		
		System.out.println("Listing PermessoUscita by Criteria...");
		domain.persistent.PermessoUscitaCriteria ldomainpersistentPermessoUscitaCriteria = new domain.persistent.PermessoUscitaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentPermessoUscitaCriteria.ID.eq();
		ldomainpersistentPermessoUscitaCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.PermessoUscita[] domainpersistentPermessoUscitas = ldomainpersistentPermessoUscitaCriteria.listPermessoUscita();
		length =domainpersistentPermessoUscitas== null ? 0 : Math.min(domainpersistentPermessoUscitas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentPermessoUscitas[i]);
		}
		System.out.println(length + " PermessoUscita record(s) retrieved."); 
		
		System.out.println("Listing LibrettoAssenze by Criteria...");
		domain.persistent.LibrettoAssenzeCriteria ldomainpersistentLibrettoAssenzeCriteria = new domain.persistent.LibrettoAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentLibrettoAssenzeCriteria.ID.eq();
		ldomainpersistentLibrettoAssenzeCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.LibrettoAssenze[] domainpersistentLibrettoAssenzes = ldomainpersistentLibrettoAssenzeCriteria.listLibrettoAssenze();
		length =domainpersistentLibrettoAssenzes== null ? 0 : Math.min(domainpersistentLibrettoAssenzes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentLibrettoAssenzes[i]);
		}
		System.out.println(length + " LibrettoAssenze record(s) retrieved."); 
		
		System.out.println("Listing Indirizzo by Criteria...");
		domain.persistent.IndirizzoCriteria ldomainpersistentIndirizzoCriteria = new domain.persistent.IndirizzoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentIndirizzoCriteria.ID.eq();
		ldomainpersistentIndirizzoCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Indirizzo[] domainpersistentIndirizzos = ldomainpersistentIndirizzoCriteria.listIndirizzo();
		length =domainpersistentIndirizzos== null ? 0 : Math.min(domainpersistentIndirizzos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentIndirizzos[i]);
		}
		System.out.println(length + " Indirizzo record(s) retrieved."); 
		
		System.out.println("Listing RegistroAssenze by Criteria...");
		domain.persistent.RegistroAssenzeCriteria ldomainpersistentRegistroAssenzeCriteria = new domain.persistent.RegistroAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentRegistroAssenzeCriteria.ID.eq();
		ldomainpersistentRegistroAssenzeCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.RegistroAssenze[] domainpersistentRegistroAssenzes = ldomainpersistentRegistroAssenzeCriteria.listRegistroAssenze();
		length =domainpersistentRegistroAssenzes== null ? 0 : Math.min(domainpersistentRegistroAssenzes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentRegistroAssenzes[i]);
		}
		System.out.println(length + " RegistroAssenze record(s) retrieved."); 
		
		System.out.println("Listing Scuola by Criteria...");
		domain.persistent.ScuolaCriteria ldomainpersistentScuolaCriteria = new domain.persistent.ScuolaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentScuolaCriteria.ID.eq();
		ldomainpersistentScuolaCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Scuola[] domainpersistentScuolas = ldomainpersistentScuolaCriteria.listScuola();
		length =domainpersistentScuolas== null ? 0 : Math.min(domainpersistentScuolas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentScuolas[i]);
		}
		System.out.println(length + " Scuola record(s) retrieved."); 
		
		System.out.println("Listing Classe by Criteria...");
		domain.persistent.ClasseCriteria ldomainpersistentClasseCriteria = new domain.persistent.ClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentClasseCriteria.idClasse.eq();
		ldomainpersistentClasseCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Classe[] domainpersistentClasses = ldomainpersistentClasseCriteria.listClasse();
		length =domainpersistentClasses== null ? 0 : Math.min(domainpersistentClasses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentClasses[i]);
		}
		System.out.println(length + " Classe record(s) retrieved."); 
		
		System.out.println("Listing Docente by Criteria...");
		domain.persistent.DocenteCriteria ldomainpersistentDocenteCriteria = new domain.persistent.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentDocenteCriteria.idDocente.eq();
		ldomainpersistentDocenteCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Docente[] domainpersistentDocentes = ldomainpersistentDocenteCriteria.listDocente();
		length =domainpersistentDocentes== null ? 0 : Math.min(domainpersistentDocentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentDocentes[i]);
		}
		System.out.println(length + " Docente record(s) retrieved."); 
		
		System.out.println("Listing Calendario by Criteria...");
		domain.persistent.CalendarioCriteria ldomainpersistentCalendarioCriteria = new domain.persistent.CalendarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainpersistentCalendarioCriteria.ID.eq();
		ldomainpersistentCalendarioCriteria.setMaxResults(ROW_COUNT);
		domain.persistent.Calendario[] domainpersistentCalendarios = ldomainpersistentCalendarioCriteria.listCalendario();
		length =domainpersistentCalendarios== null ? 0 : Math.min(domainpersistentCalendarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainpersistentCalendarios[i]);
		}
		System.out.println(length + " Calendario record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListRegistroScolasticoData listRegistroScolasticoData = new ListRegistroScolasticoData();
			try {
				listRegistroScolasticoData.listTestData();
				//listRegistroScolasticoData.listByCriteria();
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
