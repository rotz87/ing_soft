/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CalendarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression giorniFestivi;
	public final CollectionExpression giorniSettimanaliFestivi;
	
	public CalendarioCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		giorniFestivi = new CollectionExpression("giorniFestivi", this);
		giorniSettimanaliFestivi = new CollectionExpression("giorniSettimanaliFestivi", this);
	}
	
	public CalendarioCriteria(PersistentSession session) {
		this(session.createCriteria(Calendario.class));
	}
	
	public CalendarioCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public GiornoCriteria createGiorniFestiviCriteria() {
		return new GiornoCriteria(createCriteria("giorniFestivi"));
	}
	
	public GiornoSettimanaleCriteria createGiorniSettimanaliFestiviCriteria() {
		return new GiornoSettimanaleCriteria(createCriteria("giorniSettimanaliFestivi"));
	}
	
	public Calendario uniqueCalendario() {
		return (Calendario) super.uniqueResult();
	}
	
	public Calendario[] listCalendario() {
		java.util.List list = super.list();
		return (Calendario[]) list.toArray(new Calendario[list.size()]);
	}
}

