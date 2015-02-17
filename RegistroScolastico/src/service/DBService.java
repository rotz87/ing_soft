/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package service;

import java.awt.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.joda.time.LocalDate;
import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import domain.model.Appello;
import domain.model.Assenza;
import domain.model.Classe;
import domain.model.Docente;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.RegistroScolasticoPersistentManager;
import domain.model.Scuola;
import domain.model.Studente;
public class DBService {
	private static DBService instance;
	
	private DBService(){
		
	}
	
	public static DBService getInstance(){
		
		if(instance == null){
			instance = new DBService();
		}
		return instance;
	}

	public void save(Object[] value) throws PersistentException{
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try{
			for (Object o : value){
					domain.model.RegistroScolasticoPersistentManager.instance().getSession().save(o);
			}
			t.commit();
		}catch(Exception e){
			t.rollback();
		}
	}
	
	public void save(Object value) throws PersistentException{
		Object[] o = {value};
		save(o);
	}
	
	public void update(Object[] value)  throws PersistentException{
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try{
			for (Object o : value){
					domain.model.RegistroScolasticoPersistentManager.instance().getSession().update(o);
			}
			t.commit();
		}catch(Exception e){
			t.rollback();
		}
	}
	
	public void update(Object value) throws PersistentException{
		Object[] o = {value};
		update(o);
	}
	
	public void delete(Object[] value)  throws PersistentException{
		PersistentTransaction t = domain.model.RegistroScolasticoPersistentManager.instance().getSession().beginTransaction();
		try{
			for (Object o : value){
					domain.model.RegistroScolasticoPersistentManager.instance().getSession().delete(o);
			}
			t.commit();
		}catch(Exception e){
			t.rollback();
		}
	}
	
	public void delete(Object value) throws PersistentException{
		Object[] o = {value};
		delete(o);
	}
	
	
}
