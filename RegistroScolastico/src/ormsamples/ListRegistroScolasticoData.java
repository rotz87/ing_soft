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
		java.util.List lStudenteList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Studente").setMaxResults(ROW_COUNT).list();
		domain.model.Studente[] ldomainmodelStudentes = (domain.model.Studente[]) lStudenteList.toArray(new domain.model.Studente[lStudenteList.size()]);
		int length = Math.min(ldomainmodelStudentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelStudentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Appello...");
		java.util.List lAppelloList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Appello").setMaxResults(ROW_COUNT).list();
		domain.model.Appello[] ldomainmodelAppellos = (domain.model.Appello[]) lAppelloList.toArray(new domain.model.Appello[lAppelloList.size()]);
		length = Math.min(ldomainmodelAppellos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelAppellos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Assenza...");
		java.util.List lAssenzaList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Assenza").setMaxResults(ROW_COUNT).list();
		domain.model.Assenza[] ldomainmodelAssenzas = (domain.model.Assenza[]) lAssenzaList.toArray(new domain.model.Assenza[lAssenzaList.size()]);
		length = Math.min(ldomainmodelAssenzas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelAssenzas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Giustificazione...");
		java.util.List lGiustificazioneList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Giustificazione").setMaxResults(ROW_COUNT).list();
		domain.model.Giustificazione[] ldomainmodelGiustificaziones = (domain.model.Giustificazione[]) lGiustificazioneList.toArray(new domain.model.Giustificazione[lGiustificazioneList.size()]);
		length = Math.min(ldomainmodelGiustificaziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiustificaziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ritardo...");
		java.util.List lRitardoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Ritardo").setMaxResults(ROW_COUNT).list();
		domain.model.Ritardo[] ldomainmodelRitardos = (domain.model.Ritardo[]) lRitardoList.toArray(new domain.model.Ritardo[lRitardoList.size()]);
		length = Math.min(ldomainmodelRitardos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelRitardos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoEntrata...");
		java.util.List lPermessoEntrataList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoEntrata").setMaxResults(ROW_COUNT).list();
		domain.model.PermessoEntrata[] ldomainmodelPermessoEntratas = (domain.model.PermessoEntrata[]) lPermessoEntrataList.toArray(new domain.model.PermessoEntrata[lPermessoEntrataList.size()]);
		length = Math.min(ldomainmodelPermessoEntratas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelPermessoEntratas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing UscitaAnticipata...");
		java.util.List lUscitaAnticipataList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.UscitaAnticipata").setMaxResults(ROW_COUNT).list();
		domain.model.UscitaAnticipata[] ldomainmodelUscitaAnticipatas = (domain.model.UscitaAnticipata[]) lUscitaAnticipataList.toArray(new domain.model.UscitaAnticipata[lUscitaAnticipataList.size()]);
		length = Math.min(ldomainmodelUscitaAnticipatas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelUscitaAnticipatas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PermessoUscita...");
		java.util.List lPermessoUscitaList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.PermessoUscita").setMaxResults(ROW_COUNT).list();
		domain.model.PermessoUscita[] ldomainmodelPermessoUscitas = (domain.model.PermessoUscita[]) lPermessoUscitaList.toArray(new domain.model.PermessoUscita[lPermessoUscitaList.size()]);
		length = Math.min(ldomainmodelPermessoUscitas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelPermessoUscitas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LibrettoAssenze...");
		java.util.List lLibrettoAssenzeList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoAssenze").setMaxResults(ROW_COUNT).list();
		domain.model.LibrettoAssenze[] ldomainmodelLibrettoAssenzes = (domain.model.LibrettoAssenze[]) lLibrettoAssenzeList.toArray(new domain.model.LibrettoAssenze[lLibrettoAssenzeList.size()]);
		length = Math.min(ldomainmodelLibrettoAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelLibrettoAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Indirizzo...");
		java.util.List lIndirizzoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Indirizzo").setMaxResults(ROW_COUNT).list();
		domain.model.Indirizzo[] ldomainmodelIndirizzos = (domain.model.Indirizzo[]) lIndirizzoList.toArray(new domain.model.Indirizzo[lIndirizzoList.size()]);
		length = Math.min(ldomainmodelIndirizzos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelIndirizzos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RegistroAssenze...");
		java.util.List lRegistroAssenzeList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroAssenze").setMaxResults(ROW_COUNT).list();
		domain.model.RegistroAssenze[] ldomainmodelRegistroAssenzes = (domain.model.RegistroAssenze[]) lRegistroAssenzeList.toArray(new domain.model.RegistroAssenze[lRegistroAssenzeList.size()]);
		length = Math.min(ldomainmodelRegistroAssenzes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelRegistroAssenzes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Scuola...");
		java.util.List lScuolaList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Scuola").setMaxResults(ROW_COUNT).list();
		domain.model.Scuola[] ldomainmodelScuolas = (domain.model.Scuola[]) lScuolaList.toArray(new domain.model.Scuola[lScuolaList.size()]);
		length = Math.min(ldomainmodelScuolas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelScuolas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Classe...");
		java.util.List lClasseList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Classe").setMaxResults(ROW_COUNT).list();
		domain.model.Classe[] ldomainmodelClasses = (domain.model.Classe[]) lClasseList.toArray(new domain.model.Classe[lClasseList.size()]);
		length = Math.min(ldomainmodelClasses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelClasses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Docente...");
		java.util.List lDocenteList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Docente").setMaxResults(ROW_COUNT).list();
		domain.model.Docente[] ldomainmodelDocentes = (domain.model.Docente[]) lDocenteList.toArray(new domain.model.Docente[lDocenteList.size()]);
		length = Math.min(ldomainmodelDocentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelDocentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing GiornoFestivo...");
		java.util.List lGiornoFestivoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoFestivo").setMaxResults(ROW_COUNT).list();
		domain.model.GiornoFestivo[] ldomainmodelGiornoFestivos = (domain.model.GiornoFestivo[]) lGiornoFestivoList.toArray(new domain.model.GiornoFestivo[lGiornoFestivoList.size()]);
		length = Math.min(ldomainmodelGiornoFestivos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiornoFestivos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing GiornoSettimanaleFestivo...");
		java.util.List lGiornoSettimanaleFestivoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.GiornoSettimanaleFestivo").setMaxResults(ROW_COUNT).list();
		domain.model.GiornoSettimanaleFestivo[] ldomainmodelGiornoSettimanaleFestivos = (domain.model.GiornoSettimanaleFestivo[]) lGiornoSettimanaleFestivoList.toArray(new domain.model.GiornoSettimanaleFestivo[lGiornoSettimanaleFestivoList.size()]);
		length = Math.min(ldomainmodelGiornoSettimanaleFestivos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelGiornoSettimanaleFestivos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing RegistroDocente...");
		java.util.List lRegistroDocenteList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.RegistroDocente").setMaxResults(ROW_COUNT).list();
		domain.model.RegistroDocente[] ldomainmodelRegistroDocentes = (domain.model.RegistroDocente[]) lRegistroDocenteList.toArray(new domain.model.RegistroDocente[lRegistroDocenteList.size()]);
		length = Math.min(ldomainmodelRegistroDocentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelRegistroDocentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Materia...");
		java.util.List lMateriaList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Materia").setMaxResults(ROW_COUNT).list();
		domain.model.Materia[] ldomainmodelMaterias = (domain.model.Materia[]) lMateriaList.toArray(new domain.model.Materia[lMateriaList.size()]);
		length = Math.min(ldomainmodelMaterias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelMaterias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LibrettoVoti...");
		java.util.List lLibrettoVotiList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVoti").setMaxResults(ROW_COUNT).list();
		domain.model.LibrettoVoti[] ldomainmodelLibrettoVotis = (domain.model.LibrettoVoti[]) lLibrettoVotiList.toArray(new domain.model.LibrettoVoti[lLibrettoVotiList.size()]);
		length = Math.min(ldomainmodelLibrettoVotis.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelLibrettoVotis[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing LibrettoVotiLineItem...");
		java.util.List lLibrettoVotiLineItemList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.LibrettoVotiLineItem").setMaxResults(ROW_COUNT).list();
		domain.model.LibrettoVotiLineItem[] ldomainmodelLibrettoVotiLineItems = (domain.model.LibrettoVotiLineItem[]) lLibrettoVotiLineItemList.toArray(new domain.model.LibrettoVotiLineItem[lLibrettoVotiLineItemList.size()]);
		length = Math.min(ldomainmodelLibrettoVotiLineItems.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelLibrettoVotiLineItems[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing CompitoInClasse...");
		java.util.List lCompitoInClasseList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.compitoInClasse.CompitoInClasse").setMaxResults(ROW_COUNT).list();
		domain.model.compitoInClasse.CompitoInClasse[] ldomainmodelcompitoInClasseCompitoInClasses = (domain.model.compitoInClasse.CompitoInClasse[]) lCompitoInClasseList.toArray(new domain.model.compitoInClasse.CompitoInClasse[lCompitoInClasseList.size()]);
		length = Math.min(ldomainmodelcompitoInClasseCompitoInClasses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelcompitoInClasseCompitoInClasses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Voto...");
		java.util.List lVotoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Voto").setMaxResults(ROW_COUNT).list();
		domain.model.Voto[] ldomainmodelVotos = (domain.model.Voto[]) lVotoList.toArray(new domain.model.Voto[lVotoList.size()]);
		length = Math.min(ldomainmodelVotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelVotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Argomento...");
		java.util.List lArgomentoList = service.RSPersistentManager.instance().getSession().createQuery("From domain.model.Argomento").setMaxResults(ROW_COUNT).list();
		domain.model.Argomento[] ldomainmodelArgomentos = (domain.model.Argomento[]) lArgomentoList.toArray(new domain.model.Argomento[lArgomentoList.size()]);
		length = Math.min(ldomainmodelArgomentos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ldomainmodelArgomentos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Studente by Criteria...");
		domain.model.StudenteCriteria ldomainmodelStudenteCriteria = new domain.model.StudenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelStudenteCriteria.ID.eq();
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
		//ldomainmodelAppelloCriteria.ID.eq();
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
		
		System.out.println("Listing Indirizzo by Criteria...");
		domain.model.IndirizzoCriteria ldomainmodelIndirizzoCriteria = new domain.model.IndirizzoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelIndirizzoCriteria.ID.eq();
		ldomainmodelIndirizzoCriteria.setMaxResults(ROW_COUNT);
		domain.model.Indirizzo[] domainmodelIndirizzos = ldomainmodelIndirizzoCriteria.listIndirizzo();
		length =domainmodelIndirizzos== null ? 0 : Math.min(domainmodelIndirizzos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelIndirizzos[i]);
		}
		System.out.println(length + " Indirizzo record(s) retrieved."); 
		
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
		//ldomainmodelClasseCriteria.ID.eq();
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
		//ldomainmodelDocenteCriteria.ID.eq();
		ldomainmodelDocenteCriteria.setMaxResults(ROW_COUNT);
		domain.model.Docente[] domainmodelDocentes = ldomainmodelDocenteCriteria.listDocente();
		length =domainmodelDocentes== null ? 0 : Math.min(domainmodelDocentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelDocentes[i]);
		}
		System.out.println(length + " Docente record(s) retrieved."); 
		
		System.out.println("Listing GiornoFestivo by Criteria...");
		domain.model.GiornoFestivoCriteria ldomainmodelGiornoFestivoCriteria = new domain.model.GiornoFestivoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelGiornoFestivoCriteria.ID.eq();
		ldomainmodelGiornoFestivoCriteria.setMaxResults(ROW_COUNT);
		domain.model.GiornoFestivo[] domainmodelGiornoFestivos = ldomainmodelGiornoFestivoCriteria.listGiornoFestivo();
		length =domainmodelGiornoFestivos== null ? 0 : Math.min(domainmodelGiornoFestivos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelGiornoFestivos[i]);
		}
		System.out.println(length + " GiornoFestivo record(s) retrieved."); 
		
		System.out.println("Listing GiornoSettimanaleFestivo by Criteria...");
		domain.model.GiornoSettimanaleFestivoCriteria ldomainmodelGiornoSettimanaleFestivoCriteria = new domain.model.GiornoSettimanaleFestivoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelGiornoSettimanaleFestivoCriteria.ID.eq();
		ldomainmodelGiornoSettimanaleFestivoCriteria.setMaxResults(ROW_COUNT);
		domain.model.GiornoSettimanaleFestivo[] domainmodelGiornoSettimanaleFestivos = ldomainmodelGiornoSettimanaleFestivoCriteria.listGiornoSettimanaleFestivo();
		length =domainmodelGiornoSettimanaleFestivos== null ? 0 : Math.min(domainmodelGiornoSettimanaleFestivos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelGiornoSettimanaleFestivos[i]);
		}
		System.out.println(length + " GiornoSettimanaleFestivo record(s) retrieved."); 
		
		System.out.println("Listing RegistroDocente by Criteria...");
		domain.model.RegistroDocenteCriteria ldomainmodelRegistroDocenteCriteria = new domain.model.RegistroDocenteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelRegistroDocenteCriteria.ID.eq();
		ldomainmodelRegistroDocenteCriteria.setMaxResults(ROW_COUNT);
		domain.model.RegistroDocente[] domainmodelRegistroDocentes = ldomainmodelRegistroDocenteCriteria.listRegistroDocente();
		length =domainmodelRegistroDocentes== null ? 0 : Math.min(domainmodelRegistroDocentes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelRegistroDocentes[i]);
		}
		System.out.println(length + " RegistroDocente record(s) retrieved."); 
		
		System.out.println("Listing Materia by Criteria...");
		domain.model.MateriaCriteria ldomainmodelMateriaCriteria = new domain.model.MateriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelMateriaCriteria.ID.eq();
		ldomainmodelMateriaCriteria.setMaxResults(ROW_COUNT);
		domain.model.Materia[] domainmodelMaterias = ldomainmodelMateriaCriteria.listMateria();
		length =domainmodelMaterias== null ? 0 : Math.min(domainmodelMaterias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelMaterias[i]);
		}
		System.out.println(length + " Materia record(s) retrieved."); 
		
		System.out.println("Listing LibrettoVoti by Criteria...");
		domain.model.LibrettoVotiCriteria ldomainmodelLibrettoVotiCriteria = new domain.model.LibrettoVotiCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelLibrettoVotiCriteria.ID.eq();
		ldomainmodelLibrettoVotiCriteria.setMaxResults(ROW_COUNT);
		domain.model.LibrettoVoti[] domainmodelLibrettoVotis = ldomainmodelLibrettoVotiCriteria.listLibrettoVoti();
		length =domainmodelLibrettoVotis== null ? 0 : Math.min(domainmodelLibrettoVotis.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelLibrettoVotis[i]);
		}
		System.out.println(length + " LibrettoVoti record(s) retrieved."); 
		
		System.out.println("Listing LibrettoVotiLineItem by Criteria...");
		domain.model.LibrettoVotiLineItemCriteria ldomainmodelLibrettoVotiLineItemCriteria = new domain.model.LibrettoVotiLineItemCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelLibrettoVotiLineItemCriteria.ID.eq();
		ldomainmodelLibrettoVotiLineItemCriteria.setMaxResults(ROW_COUNT);
		domain.model.LibrettoVotiLineItem[] domainmodelLibrettoVotiLineItems = ldomainmodelLibrettoVotiLineItemCriteria.listLibrettoVotiLineItem();
		length =domainmodelLibrettoVotiLineItems== null ? 0 : Math.min(domainmodelLibrettoVotiLineItems.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelLibrettoVotiLineItems[i]);
		}
		System.out.println(length + " LibrettoVotiLineItem record(s) retrieved."); 
		
		System.out.println("Listing CompitoInClasse by Criteria...");
		domain.model.compitoInClasse.CompitoInClasseCriteria ldomainmodelcompitoInClasseCompitoInClasseCriteria = new domain.model.compitoInClasse.CompitoInClasseCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelcompitoInClasseCompitoInClasseCriteria.ID.eq();
		ldomainmodelcompitoInClasseCompitoInClasseCriteria.setMaxResults(ROW_COUNT);
		domain.model.compitoInClasse.CompitoInClasse[] domainmodelcompitoInClasseCompitoInClasses = ldomainmodelcompitoInClasseCompitoInClasseCriteria.listCompitoInClasse();
		length =domainmodelcompitoInClasseCompitoInClasses== null ? 0 : Math.min(domainmodelcompitoInClasseCompitoInClasses.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelcompitoInClasseCompitoInClasses[i]);
		}
		System.out.println(length + " CompitoInClasse record(s) retrieved."); 
		
		System.out.println("Listing Voto by Criteria...");
		domain.model.VotoCriteria ldomainmodelVotoCriteria = new domain.model.VotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelVotoCriteria.ID.eq();
		ldomainmodelVotoCriteria.setMaxResults(ROW_COUNT);
		domain.model.Voto[] domainmodelVotos = ldomainmodelVotoCriteria.listVoto();
		length =domainmodelVotos== null ? 0 : Math.min(domainmodelVotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelVotos[i]);
		}
		System.out.println(length + " Voto record(s) retrieved."); 
		
		System.out.println("Listing Argomento by Criteria...");
		domain.model.ArgomentoCriteria ldomainmodelArgomentoCriteria = new domain.model.ArgomentoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ldomainmodelArgomentoCriteria.ID.eq();
		ldomainmodelArgomentoCriteria.setMaxResults(ROW_COUNT);
		domain.model.Argomento[] domainmodelArgomentos = ldomainmodelArgomentoCriteria.listArgomento();
		length =domainmodelArgomentos== null ? 0 : Math.min(domainmodelArgomentos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(domainmodelArgomentos[i]);
		}
		System.out.println(length + " Argomento record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListRegistroScolasticoData listRegistroScolasticoData = new ListRegistroScolasticoData();
			try {
				listRegistroScolasticoData.listTestData();
				//listRegistroScolasticoData.listByCriteria();
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
