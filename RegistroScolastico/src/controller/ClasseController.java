package controller;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.cassandra.thrift.cassandraConstants;
import org.hibernate.exception.DataException;
import org.joda.time.LocalDate;
import org.orm.PersistentException;

import service.Stampa;
import domain.error.ErrorMessage;
import domain.model.Appello;
import domain.model.Calendario;
import domain.model.Classe;
import domain.model.ClasseCriteria;
import domain.model.Docente;
import domain.model.DocenteCriteria;
import domain.model.RegistroDocente;
import domain.model.RegistroDocenteCriteria;
import domain.model.Studente;

public class ClasseController {
	
	public ClasseController() {
		
	}

	public Collection<Classe> getClassi(int idDocente){
		
			Docente docente = null;
			DocenteCriteria criteria = null;
			
			try {
				criteria = new DocenteCriteria();
			} catch (PersistentException e) {
				throw new RuntimeException(ErrorMessage.CLASSI_UNLOADED);
			}
			
			criteria.ID.eq(idDocente);

			docente = criteria.uniqueDocente();

			return docente.getClassi();
			
	}
	
	public Collection<Studente> getStudenti(int idClasse){
		
		Classe classe;
		ClasseCriteria criteria;
		
		criteria = null;
		
		try {
			criteria = new ClasseCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.STUDENTI_UNLOADED);
		}
		criteria.ID.eq(idClasse);
		classe = criteria.uniqueClasse();
		
		return classe.getStudenti();
		
	}

	
	public Collection<LocalDate> getDateFestive(int idClasse){
		Collection<LocalDate> dateFestive;
		Collection<LocalDate> rit;
		FaiAppelloController appelloController;
		
		dateFestive = Calendario.getInstance().getDateFestiveFuture();
		appelloController = new FaiAppelloController();
		
		for(LocalDate data = Calendario.getInstance().getInizioLezioni(); data.isBefore(Calendario.getInstance().getDataOdierna()); data = data.plusDays(1) ){
			if(!Calendario.getInstance().isSettimanaleFestivo(data) && appelloController.getAppello(idClasse, data) == null){
				dateFestive.add(data);
			}
		}
		rit = dateFestive;
		
		return rit;
	}

	public Collection<RegistroDocente> getRegistriDocente(int idClasse, int idDocente) {
		Classe classe;
		Docente docente;
		ClasseCriteria classeCriteria;
		DocenteCriteria docenteCriteria;
		RegistroDocenteCriteria registroDocenteCriteria;
		Collection<RegistroDocente> registri;
		
		classeCriteria = null;
		docenteCriteria = null;
		registri = new LinkedList<RegistroDocente>();
		
		try {
			classeCriteria = new ClasseCriteria();
			docenteCriteria = new DocenteCriteria();
			registroDocenteCriteria = new RegistroDocenteCriteria();
		} catch (PersistentException e) {
			throw new RuntimeException(ErrorMessage.REGISTRO_DOCENTE_UNLOADED);
		}
		classeCriteria.ID.eq(idClasse);
		classe = classeCriteria.uniqueClasse();
		docenteCriteria.ID.eq(idDocente);

		docente = docenteCriteria.uniqueDocente();
		
		registroDocenteCriteria._classeId.eq(idClasse);
		
		registri.addAll(registroDocenteCriteria.list());
		
		registri.retainAll(docente.getRegistriDocente());
		
		return registri;
	}
}
