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
		java.util.List lStudenteList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(ROW_COUNT).list();
		domain.model.Studente[] ldomainmodelStudentes = (domain.model.Studente[]) lStudenteList.toArray(new domain.model.Studente[lStudenteList.size()]);
		int length = Math.min(ldomainmodelStudentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelStudentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Appello...");
		java.util.List lAppelloList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(ROW_COUNT).list();
		domain.model.Appello[] ldomainmodelAppellos = (domain.model.Appello[]) lAppelloList.toArray(new domain.model.Appello[lAppelloList.size()]);
		length = Math.min(ldomainmodelAppellos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelAppellos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Assenza...");
		java.util.List lAssenzaList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(ROW_COUNT).list();
		domain.model.Assenza[] ldomainmodelAssenzas = (domain.model.Assenza[]) lAssenzaList.toArray(new domain.model.Assenza[lAssenzaList.size()]);
		length = Math.min(ldomainmodelAssenzas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelAssenzas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Giustificazione...");
		java.util.List lGiustificazioneList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(ROW_COUNT).list();
		domain.model.Giustificazione[] ldomainmodelGiustificaziones = (domain.model.Giustificazione[]) lGiustificazioneList.toArray(new domain.model.Giustificazione[lGiustificazioneList.size()]);
		length = Math.min(ldomainmodelGiustificaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiustificaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ritardo...");
		java.util.List lRitardoList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(ROW_COUNT).list();
		domain.model.Ritardo[] ldomainmodelRitardos = (domain.model.Ritardo[]) lRitardoList.toArray(new domain.model.Ritardo[lRitardoList.size()]);
		length = Math.min(ldomainmodelRitardos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelRitardos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoEntrata...");
		java.util.List lPermessoEntrataList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(ROW_COUNT).list();
		domain.model.PermessoEntrata[] ldomainmodelPermessoEntratas = (domain.model.PermessoEntrata[]) lPermessoEntrataList.toArray(new domain.model.PermessoEntrata[lPermessoEntrataList.size()]);
		length = Math.min(ldomainmodelPermessoEntratas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelPermessoEntratas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing UscitaAnticipata...");
		java.util.List lUscitaAnticipataList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(ROW_COUNT).list();
		domain.model.UscitaAnticipata[] ldomainmodelUscitaAnticipatas = (domain.model.UscitaAnticipata[]) lUscitaAnticipataList.toArray(new domain.model.UscitaAnticipata[lUscitaAnticipataList.size()]);
		length = Math.min(ldomainmodelUscitaAnticipatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelUscitaAnticipatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoUscita...");
		java.util.List lPermessoUscitaList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(ROW_COUNT).list();
		domain.model.PermessoUscita[] ldomainmodelPermessoUscitas = (domain.model.PermessoUscita[]) lPermessoUscitaList.toArray(new domain.model.PermessoUscita[lPermessoUscitaList.size()]);
		length = Math.min(ldomainmodelPermessoUscitas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelPermessoUscitas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LibrettoAssenze...");
		java.util.List lLibrettoAssenzeList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(ROW_COUNT).list();
		domain.model.LibrettoAssenze[] ldomainmodelLibrettoAssenzes = (domain.model.LibrettoAssenze[]) lLibrettoAssenzeList.toArray(new domain.model.LibrettoAssenze[lLibrettoAssenzeList.size()]);
		length = Math.min(ldomainmodelLibrettoAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelLibrettoAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RegistroAssenze...");
		java.util.List lRegistroAssenzeList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(ROW_COUNT).list();
		domain.model.RegistroAssenze[] ldomainmodelRegistroAssenzes = (domain.model.RegistroAssenze[]) lRegistroAssenzeList.toArray(new domain.model.RegistroAssenze[lRegistroAssenzeList.size()]);
		length = Math.min(ldomainmodelRegistroAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelRegistroAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Scuola...");
		java.util.List lScuolaList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(ROW_COUNT).list();
		domain.model.Scuola[] ldomainmodelScuolas = (domain.model.Scuola[]) lScuolaList.toArray(new domain.model.Scuola[lScuolaList.size()]);
		length = Math.min(ldomainmodelScuolas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelScuolas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Classe...");
		java.util.List lClasseList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(ROW_COUNT).list();
		domain.model.Classe[] ldomainmodelClasses = (domain.model.Classe[]) lClasseList.toArray(new domain.model.Classe[lClasseList.size()]);
		length = Math.min(ldomainmodelClasses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelClasses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Docente...");
		java.util.List lDocenteList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(ROW_COUNT).list();
		domain.model.Docente[] ldomainmodelDocentes = (domain.model.Docente[]) lDocenteList.toArray(new domain.model.Docente[lDocenteList.size()]);
		length = Math.min(ldomainmodelDocentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelDocentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Calendario...");
		java.util.List lCalendarioList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Calendario").setMaxResults(ROW_COUNT).list();
		domain.model.Calendario[] ldomainmodelCalendarios = (domain.model.Calendario[]) lCalendarioList.toArray(new domain.model.Calendario[lCalendarioList.size()]);
		length = Math.min(ldomainmodelCalendarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelCalendarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Giorno...");
		java.util.List lGiornoList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.Giorno").setMaxResults(ROW_COUNT).list();
		domain.model.Giorno[] ldomainmodelGiornos = (domain.model.Giorno[]) lGiornoList.toArray(new domain.model.Giorno[lGiornoList.size()]);
		length = Math.min(ldomainmodelGiornos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiornos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing GiornoSettimanale...");
		java.util.List lGiornoSettimanaleList = domain.model.RegistroScolasticoPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanale").setMaxResults(ROW_COUNT).list();
		domain.model.GiornoSettimanale[] ldomainmodelGiornoSettimanales = (domain.model.GiornoSettimanale[]) lGiornoSettimanaleList.toArray(new domain.model.GiornoSettimanale[lGiornoSettimanaleList.size()]);
		length = Math.min(ldomainmodelGiornoSettimanales.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiornoSettimanales[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Studente by Criteria...");
		domain.model.StudenteCriteria ldomainmodelStudenteCriteria = new domain.model.StudenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelStudenteCriteria.id.eq();
		ldomainmodelStudenteCriteria.setMaxResults(ROW_COUNT);
		domain.model.Studente[] domainmodelStudentes = ldomainmodelStudenteCriteria.listStudente();
		int length =domainmodelStudentes== null ? 0 : Math.min(domainmodelStudentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelStudentes[i]);
		}
		System.out.println(length + " Studente record(s) retrieved."); 
		
		System.out.println("Listing Appello by Criteria...");
		domain.model.AppelloCriteria ldomainmodelAppelloCriteria = new domain.model.AppelloCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelAppelloCriteria.idAppello.eq();
		ldomainmodelAppelloCriteria.setMaxResults(ROW_COUNT);
		domain.model.Appello[] domainmodelAppellos = ldomainmodelAppelloCriteria.listAppello();
		length =domainmodelAppellos== null ? 0 : Math.min(domainmodelAppellos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelAppellos[i]);
		}
		System.out.println(length + " Appello record(s) retrieved."); 
		
		System.out.println("Listing Assenza by Criteria...");
		domain.model.AssenzaCriteria ldomainmodelAssenzaCriteria = new domain.model.AssenzaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelAssenzaCriteria.ID.eq();
		ldomainmodelAssenzaCriteria.setMaxResults(ROW_COUNT);
		domain.model.Assenza[] domainmodelAssenzas = ldomainmodelAssenzaCriteria.listAssenza();
		length =domainmodelAssenzas== null ? 0 : Math.min(domainmodelAssenzas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelAssenzas[i]);
		}
		System.out.println(length + " Assenza record(s) retrieved."); 
		
		System.out.println("Listing Giustificazione by Criteria...");
		domain.model.GiustificazioneCriteria ldomainmodelGiustificazioneCriteria = new domain.model.GiustificazioneCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelGiustificazioneCriteria.ID.eq();
		ldomainmodelGiustificazioneCriteria.setMaxResults(ROW_COUNT);
		domain.model.Giustificazione[] domainmodelGiustificaziones = ldomainmodelGiustificazioneCriteria.listGiustificazione();
		length =domainmodelGiustificaziones== null ? 0 : Math.min(domainmodelGiustificaziones.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelGiustificaziones[i]);
		}
		System.out.println(length + " Giustificazione record(s) retrieved."); 
		
		System.out.println("Listing Ritardo by Criteria...");
		domain.model.RitardoCriteria ldomainmodelRitardoCriteria = new domain.model.RitardoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelRitardoCriteria.ID.eq();
		ldomainmodelRitardoCriteria.setMaxResults(ROW_COUNT);
		domain.model.Ritardo[] domainmodelRitardos = ldomainmodelRitardoCriteria.listRitardo();
		length =domainmodelRitardos== null ? 0 : Math.min(domainmodelRitardos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelRitardos[i]);
		}
		System.out.println(length + " Ritardo record(s) retrieved."); 
		
		System.out.println("Listing PermessoEntrata by Criteria...");
		domain.model.PermessoEntrataCriteria ldomainmodelPermessoEntrataCriteria = new domain.model.PermessoEntrataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelPermessoEntrataCriteria.ID.eq();
		ldomainmodelPermessoEntrataCriteria.setMaxResults(ROW_COUNT);
		domain.model.PermessoEntrata[] domainmodelPermessoEntratas = ldomainmodelPermessoEntrataCriteria.listPermessoEntrata();
		length =domainmodelPermessoEntratas== null ? 0 : Math.min(domainmodelPermessoEntratas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelPermessoEntratas[i]);
		}
		System.out.println(length + " PermessoEntrata record(s) retrieved."); 
		
		System.out.println("Listing UscitaAnticipata by Criteria...");
		domain.model.UscitaAnticipataCriteria ldomainmodelUscitaAnticipataCriteria = new domain.model.UscitaAnticipataCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelUscitaAnticipataCriteria.ID.eq();
		ldomainmodelUscitaAnticipataCriteria.setMaxResults(ROW_COUNT);
		domain.model.UscitaAnticipata[] domainmodelUscitaAnticipatas = ldomainmodelUscitaAnticipataCriteria.listUscitaAnticipata();
		length =domainmodelUscitaAnticipatas== null ? 0 : Math.min(domainmodelUscitaAnticipatas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelUscitaAnticipatas[i]);
		}
		System.out.println(length + " UscitaAnticipata record(s) retrieved."); 
		
		System.out.println("Listing PermessoUscita by Criteria...");
		domain.model.PermessoUscitaCriteria ldomainmodelPermessoUscitaCriteria = new domain.model.PermessoUscitaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelPermessoUscitaCriteria.ID.eq();
		ldomainmodelPermessoUscitaCriteria.setMaxResults(ROW_COUNT);
		domain.model.PermessoUscita[] domainmodelPermessoUscitas = ldomainmodelPermessoUscitaCriteria.listPermessoUscita();
		length =domainmodelPermessoUscitas== null ? 0 : Math.min(domainmodelPermessoUscitas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelPermessoUscitas[i]);
		}
		System.out.println(length + " PermessoUscita record(s) retrieved."); 
		
		System.out.println("Listing LibrettoAssenze by Criteria...");
		domain.model.LibrettoAssenzeCriteria ldomainmodelLibrettoAssenzeCriteria = new domain.model.LibrettoAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelLibrettoAssenzeCriteria.ID.eq();
		ldomainmodelLibrettoAssenzeCriteria.setMaxResults(ROW_COUNT);
		domain.model.LibrettoAssenze[] domainmodelLibrettoAssenzes = ldomainmodelLibrettoAssenzeCriteria.listLibrettoAssenze();
		length =domainmodelLibrettoAssenzes== null ? 0 : Math.min(domainmodelLibrettoAssenzes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelLibrettoAssenzes[i]);
		}
		System.out.println(length + " LibrettoAssenze record(s) retrieved."); 
		
		System.out.println("Listing RegistroAssenze by Criteria...");
		domain.model.RegistroAssenzeCriteria ldomainmodelRegistroAssenzeCriteria = new domain.model.RegistroAssenzeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelRegistroAssenzeCriteria.ID.eq();
		ldomainmodelRegistroAssenzeCriteria.setMaxResults(ROW_COUNT);
		domain.model.RegistroAssenze[] domainmodelRegistroAssenzes = ldomainmodelRegistroAssenzeCriteria.listRegistroAssenze();
		length =domainmodelRegistroAssenzes== null ? 0 : Math.min(domainmodelRegistroAssenzes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelRegistroAssenzes[i]);
		}
		System.out.println(length + " RegistroAssenze record(s) retrieved."); 
		
		System.out.println("Listing Scuola by Criteria...");
		domain.model.ScuolaCriteria ldomainmodelScuolaCriteria = new domain.model.ScuolaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelScuolaCriteria.ID.eq();
		ldomainmodelScuolaCriteria.setMaxResults(ROW_COUNT);
		domain.model.Scuola[] domainmodelScuolas = ldomainmodelScuolaCriteria.listScuola();
		length =domainmodelScuolas== null ? 0 : Math.min(domainmodelScuolas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelScuolas[i]);
		}
		System.out.println(length + " Scuola record(s) retrieved."); 
		
		System.out.println("Listing Classe by Criteria...");
		domain.model.ClasseCriteria ldomainmodelClasseCriteria = new domain.model.ClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelClasseCriteria.idClasse.eq();
		ldomainmodelClasseCriteria.setMaxResults(ROW_COUNT);
		domain.model.Classe[] domainmodelClasses = ldomainmodelClasseCriteria.listClasse();
		length =domainmodelClasses== null ? 0 : Math.min(domainmodelClasses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelClasses[i]);
		}
		System.out.println(length + " Classe record(s) retrieved."); 
		
		System.out.println("Listing Docente by Criteria...");
		domain.model.DocenteCriteria ldomainmodelDocenteCriteria = new domain.model.DocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelDocenteCriteria.idDocente.eq();
		ldomainmodelDocenteCriteria.setMaxResults(ROW_COUNT);
		domain.model.Docente[] domainmodelDocentes = ldomainmodelDocenteCriteria.listDocente();
		length =domainmodelDocentes== null ? 0 : Math.min(domainmodelDocentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelDocentes[i]);
		}
		System.out.println(length + " Docente record(s) retrieved."); 
		
		System.out.println("Listing Calendario by Criteria...");
		domain.model.CalendarioCriteria ldomainmodelCalendarioCriteria = new domain.model.CalendarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelCalendarioCriteria.ID.eq();
		ldomainmodelCalendarioCriteria.setMaxResults(ROW_COUNT);
		domain.model.Calendario[] domainmodelCalendarios = ldomainmodelCalendarioCriteria.listCalendario();
		length =domainmodelCalendarios== null ? 0 : Math.min(domainmodelCalendarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelCalendarios[i]);
		}
		System.out.println(length + " Calendario record(s) retrieved."); 
		
		System.out.println("Listing Giorno by Criteria...");
		domain.model.GiornoCriteria ldomainmodelGiornoCriteria = new domain.model.GiornoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelGiornoCriteria.ID.eq();
		ldomainmodelGiornoCriteria.setMaxResults(ROW_COUNT);
		domain.model.Giorno[] domainmodelGiornos = ldomainmodelGiornoCriteria.listGiorno();
		length =domainmodelGiornos== null ? 0 : Math.min(domainmodelGiornos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelGiornos[i]);
		}
		System.out.println(length + " Giorno record(s) retrieved."); 
		
		System.out.println("Listing GiornoSettimanale by Criteria...");
		domain.model.GiornoSettimanaleCriteria ldomainmodelGiornoSettimanaleCriteria = new domain.model.GiornoSettimanaleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelGiornoSettimanaleCriteria.ID.eq();
		ldomainmodelGiornoSettimanaleCriteria.setMaxResults(ROW_COUNT);
		domain.model.GiornoSettimanale[] domainmodelGiornoSettimanales = ldomainmodelGiornoSettimanaleCriteria.listGiornoSettimanale();
		length =domainmodelGiornoSettimanales== null ? 0 : Math.min(domainmodelGiornoSettimanales.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelGiornoSettimanales[i]);
		}
		System.out.println(length + " GiornoSettimanale record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListRegistroScolasticoData listRegistroScolasticoData = new ListRegistroScolasticoData();
			try {
				listRegistroScolasticoData.listTestData();
				//listRegistroScolasticoData.listByCriteria();
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
